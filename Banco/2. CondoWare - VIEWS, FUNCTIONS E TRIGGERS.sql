--RELATÓRIO E INSERIR FUNCIONÁRIO
CREATE VIEW relatorio_funcionarios(cpf, nome, salario, cargo, placa, email, senha) AS
SELECT Pessoa.cpf, nome, salario, cargo, (SELECT placa FROM Veiculo WHERE Pessoa.cpf = Veiculo.cpf LIMIT 1) AS placa, email, senha
FROM Pessoa NATURAL JOIN Funcionario
WHERE Pessoa.cpf = Funcionario.cpf;

CREATE OR REPLACE FUNCTION insere_funcionarios() RETURNS TRIGGER AS $$
BEGIN
	IF NOT EXISTS (SELECT cpf FROM Pessoa WHERE NEW.cpf = cpf) THEN
		INSERT INTO Pessoa VALUES(NEW.cpf, NEW.nome, NEW.email, NEW.senha);
		INSERT INTO Funcionario VALUES(NEW.cpf, NEW.salario, NEW.cargo);
		INSERT INTO Veiculo VALUES(NEW.cpf, NEW.placa);
	ELSEIF NOT EXISTS (SELECT cpf FROM Funcionario WHERE NEW.cpf = cpf) THEN
		INSERT INTO Funcionario VALUES(NEW.cpf, NEW.salario, NEW.cargo);
		INSERT INTO Veiculo VALUES(NEW.cpf, NEW.placa);
	END IF;
	RETURN NEW;
END; $$ LANGUAGE plpgsql;

CREATE TRIGGER insere_funcionarios INSTEAD OF INSERT ON relatorio_funcionarios
FOR EACH ROW EXECUTE PROCEDURE insere_funcionarios();

--RELATÓRIO E INSERIR CONDÔMINO
CREATE VIEW relatorio_condominos(cpf, nome, bloco, apartamento, placa, email, senha) AS
SELECT cpf, nome, bloco, apartamento, (SELECT placa FROM Veiculo WHERE Pessoa.cpf = Veiculo.cpf LIMIT 1) AS placa, email, senha
FROM Pessoa NATURAL JOIN Condomino
WHERE Pessoa.cpf = Condomino.cpf;

CREATE OR REPLACE FUNCTION insere_condominos() RETURNS TRIGGER AS $$
BEGIN
	IF EXISTS (SELECT * FROM Apartamento WHERE NEW.apartamento = numero AND NEW.bloco = bloco AND ocupado = FALSE) THEN
		IF NOT EXISTS (SELECT * FROM Pessoa WHERE NEW.cpf = cpf) THEN 
			INSERT INTO Pessoa VALUES(NEW.cpf, NEW.nome, NEW.email, NEW.senha);
		END IF;
		INSERT INTO Condomino VALUES(NEW.cpf, NEW.bloco, NEW.apartamento);
		INSERT INTO Veiculo VALUES(NEW.cpf,NEW.placa);
	END IF;
	RETURN NEW;
END; $$ LANGUAGE plpgsql;

CREATE TRIGGER insere_condominos INSTEAD OF INSERT ON relatorio_condominos
FOR EACH ROW EXECUTE PROCEDURE insere_condominos();

--ALTERA CONDÔMINO
CREATE OR REPLACE FUNCTION alt_condomino() RETURNS TRIGGER AS $$
BEGIN
	UPDATE Pessoa SET nome = NEW.nome, email = NEW.email, senha = NEW.senha WHERE cpf = NEW.cpf;
	UPDATE Condomino SET bloco = NEW.bloco, apartamento = NEW.apartamento WHERE cpf = NEW.cpf;
	UPDATE Veiculo SET placa = NEW.placa WHERE cpf = NEW.cpf;
	RETURN NEW;
END; $$ LANGUAGE plpgsql;

CREATE TRIGGER alt_condominos INSTEAD OF UPDATE ON relatorio_condominos
FOR EACH ROW EXECUTE PROCEDURE alt_condomino();

--ALTERA FUNCIONÁRIO
CREATE OR REPLACE FUNCTION alt_funcionario() RETURNS TRIGGER AS $$
BEGIN
	UPDATE Pessoa SET nome = NEW.nome, email = NEW.email, senha = NEW.senha WHERE cpf = NEW.cpf;
	UPDATE Funcionario SET salario = NEW.salario, cargo = NEW.cargo WHERE cpf = NEW.cpf;
	UPDATE Veiculo SET placa = NEW.placa WHERE cpf = NEW.cpf;
	RETURN NEW;
END; $$ LANGUAGE plpgsql;

CREATE TRIGGER alt_funcionarios INSTEAD OF UPDATE ON relatorio_funcionarios
FOR EACH ROW EXECUTE PROCEDURE alt_funcionario();

--EXCLUI CONDÔMINO
CREATE OR REPLACE FUNCTION exc_condomino(cod BIGINT) RETURNS INTEGER AS $$
BEGIN
	DELETE FROM Condomino WHERE cpf = cod;
	DELETE FROM Veiculo WHERE cpf = cod;
	UPDATE Area_Lazer SET locador = NULL WHERE locador = cod;
	IF NOT EXISTS (SELECT * FROM Funcionario WHERE cpf = cod) THEN
		DELETE FROM Pessoa WHERE cpf = cod;
	END IF;
	RETURN 0;
END; $$ LANGUAGE plpgsql;

--EXCLUI FUNCIONÁRIO
CREATE OR REPLACE FUNCTION exc_funcionario(cod BIGINT) RETURNS INTEGER AS $$
BEGIN
	DELETE FROM Funcionario WHERE cpf = cod;
	DELETE FROM Veiculo WHERE cpf = cod;
	IF NOT EXISTS (SELECT * FROM Condomino WHERE cpf = cod) THEN
		DELETE FROM Pessoa WHERE cpf = cod;
	END IF;
	RETURN 0;
END; $$ LANGUAGE plpgsql;

--RELATÓRIO DAS ÁREAS ALUGADAS
CREATE VIEW relatorio_areas_alugadas(id, tipo, data, locador, bloco, apartamento) AS
SELECT id, tipo, data_aluguel, nome, (SELECT bloco FROM Condomino WHERE locador = cpf LIMIT 1) as bloco, 
	(SELECT apartamento FROM Condomino WHERE locador = cpf LIMIT 1) as apartamento
FROM Area_Lazer NATURAL JOIN Pessoa
WHERE alugada = TRUE AND locador = cpf;

--FUNÇÃO PARA ALUGAR ÁREAS DE LAZER
CREATE OR REPLACE FUNCTION alug_area(cod INTEGER, loc BIGINT, dat DATE) RETURNS VOID AS $$
BEGIN
	UPDATE Area_Lazer SET alugada = TRUE, locador = loc, data_aluguel = dat WHERE id = cod;
END; $$ LANGUAGE plpgsql;

--FUNÇÃO P/ CRIAR OS APARTAMENTOS ASSIM QUE UM CONDOMÍNIO FOR CRIADO NA TABELA CONDOMÍNIO
CREATE OR REPLACE FUNCTION tab_apartamentos() RETURNS TRIGGER AS $$
DECLARE
	bloco INTEGER := NEW.quant_blocos::INTEGER;
	ap INTEGER := NEW.quant_ap_bloco::INTEGER;
BEGIN
	FOR contBloco in 1..bloco LOOP
		FOR contAp in 1..ap LOOP
			INSERT INTO Apartamento VALUES(contBloco, contAp, FALSE);
		END LOOP;
	END LOOP;
	RETURN NEW;
END; $$ LANGUAGE plpgsql;

CREATE TRIGGER insere_apartamentos AFTER INSERT ON Condominio
FOR EACH ROW EXECUTE PROCEDURE tab_apartamentos();

--FUNÇÃO PARA MARCAR UM AP COMO OCUPADA SEMPRE QUE UM CONDÔMINO FOR REGISTRADO
CREATE OR REPLACE FUNCTION ocup_ap() RETURNS TRIGGER AS $$
BEGIN
	UPDATE Apartamento SET ocupado = TRUE WHERE bloco = NEW.bloco AND numero = NEW.apartamento;
	RETURN NEW;
END; $$ LANGUAGE plpgsql;

CREATE TRIGGER muda_status AFTER INSERT ON Condomino
FOR EACH ROW EXECUTE PROCEDURE ocup_ap();

--FUNÇÃO P/ QUANDO FOR REALIZADO LOGIN INFORMAR O TIPO DE USUÁRIO QUE ESTÁ LOGANDO
CREATE OR REPLACE FUNCTION desc_pessoa(mail VARCHAR) RETURNS INTEGER AS $$
DECLARE
	doc BIGINT;
BEGIN
	IF EXISTS (SELECT * FROM Pessoa WHERE mail = Pessoa.email) THEN
		doc := (SELECT Pessoa.cpf FROM Pessoa WHERE mail = Pessoa.email LIMIT 1) AS id;
		IF EXISTS (SELECT * FROM Condomino WHERE Condomino.cpf = doc) THEN
			IF EXISTS (SELECT * FROM Funcionario WHERE Funcionario.cpf = doc AND cargo = 'Síndico') THEN
				RETURN 1;
			ELSEIF EXISTS (SELECT * FROM Funcionario WHERE Funcionario.cpf = doc) THEN
				RETURN 2;
			ELSE
				RETURN 3;
			END IF;
		ELSEIF EXISTS (SELECT * FROM Funcionario WHERE Funcionario.cpf = doc) THEN
			RETURN 2;
		END IF;
	END IF;
	RETURN 0;
END; $$ LANGUAGE plpgsql;

--REGISTRA ENTRADA DE UM VISITANTE
CREATE OR REPLACE FUNCTION visita_entrada(nom VARCHAR, bloc INTEGER, ap INTEGER) RETURNS VOID AS $$
BEGIN
	INSERT INTO Visita VALUES (nom, bloc, ap, CURRENT_TIMESTAMP, NULL);
END; $$ LANGUAGE plpgsql;

--REGISTRA A SAÍDA DO VISITANTE
CREATE OR REPLACE FUNCTION visita_saida(nom VARCHAR) RETURNS VOID AS $$
BEGIN
	UPDATE Visita SET saida = CURRENT_TIMESTAMP WHERE nome = nom;
END; $$ LANGUAGE plpgsql;

--RELATÓRIO DE VISITANTES
CREATE VIEW hist_visitas (nome, condomino, bloco, apartamento, entrada, saida) AS
SELECT nome, (SELECT nome
			  FROM (SELECT * 
					FROM Pessoa NATURAL JOIN Condomino WHERE bloco = bloco_vis AND apartamento = apartamento_vis) AS cond LIMIT 1) AS condomino, 
bloco_vis, apartamento_vis, entrada, saida
FROM Visita;

--RELATÓRIO DOS PROBLEMAS
CREATE VIEW relatorio_problemas(nome, descricao, bloco, data) AS
SELECT (SELECT nome FROM PESSOA WHERE condomino = cpf LIMIT 1) AS nome, descricao, bloco, data
FROM Reg_Problemas NATURAL JOIN Pessoa
WHERE condomino = cpf;
