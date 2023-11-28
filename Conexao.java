package condoware.CondoWare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexao {
    
    private String url;
    private String usuario;
    private  static String senha = CondoWare.getSenhaPostgreSql();
    private Connection con;
    private static Conexao conUnico;
    
    public static Conexao getConexao() {
        if(conUnico == null) {
            conUnico = new Conexao(senha);
        }
        return conUnico;
    }
    
    private Conexao(String senha) {
        url = "jdbc:postgresql://localhost:5432/CondoWare";
        usuario = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conexão feita com sucesso!",
                    "Sucesso", 1);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Conexão não realizada",
                    "Sucesso", 1);
        }

    }
    
    
    //------------------------------------------------------ //verifica tipo da pessoa eu logou
    
    public int verificaCargo(String email) {
        int resultado = 0;
        String stringSql = "SELECT desc_pessoa('" + email + "')";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(stringSql);
            rs.next();
            resultado = rs.getInt("desc_pessoa");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultado;
    }
    
    //----------------------------------------------------------- //verifica cpf da pessoa que logou
    
    public String buscaCpf(String email) {
        String cpf = "";
        String stringSql = "SELECT cpf FROM pessoa WHERE email = '" + email + "'";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(stringSql);
            rs.next();
            cpf = rs.getString("cpf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpf;
    }
    
    public String buscaSenha(String email) {
        String senha = "";
        String stringSql = "SELECT senha FROM pessoa WHERE email = '" + email + "'";
        try {
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(stringSql);
            rs.next();
            senha = rs.getString("senha");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return senha;
    }
    
    //--------------------------------------------------------- // relacionado aos Condôminos
    
    public ResultSet atualizaBancoCondomino() {
        Bancos.getBancos().getBdCondomino().clear();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = null;
            rs = stm.executeQuery("SELECT * FROM relatorio_condominos");
            try { // moradores
                while (rs.next()) {
                    Condomino morador = new Condomino();
                    
                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    int bloco = rs.getInt("bloco");
                    int apartamento = rs.getInt("apartamento");
                    String placa = rs.getString("placa");
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");
                    
                    morador.setCpf(cpf);
                    morador.setNome(nome);
                    morador.setBloco(bloco);
                    morador.setApartamento(apartamento);
                    morador.getVeiculo().setPlaca(placa);
                    morador.setEmail(email);
                    morador.setSenha(senha);
                    Bancos.getBancos().getBdCondomino().add(morador);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int achaCondominoCpf(String cpf) {
        int tamanho = 0;
        while(tamanho < Bancos.getBancos().getBdCondomino().size()) {
            if(Bancos.getBancos().getBdCondomino().get(tamanho).getCpf().equals(cpf)) {  
                return tamanho;
            }
            tamanho = tamanho + 1;
        }
        return tamanho;
    }
    
    public int achaCondominoAp(int ap , String nome){
        int tamanho = 0;
        while(tamanho < Bancos.getBancos().getBdCondomino().size()){
            if(Bancos.getBancos().getBdCondomino().get(tamanho).getApartamento() == ap && Bancos.getBancos().getBdCondomino().get(tamanho).getNome().equals(nome)) {  
                return tamanho;
            }
            tamanho = tamanho + 1;
        }
        return tamanho;          
    }
    
    public int addCondomino(String cpf, String nome, int bloco, int apartamento, String placa ,String email, String senha) {
        if(placa.equals("")) {
            placa  = "null";
        }
        else {
            placa = "'" + placa + "'";
        }
        try{
            String sql = "INSERT INTO relatorio_condominos "
                    + "values('" + cpf + "','" + nome + "','" + bloco + "','" + apartamento + "'," + placa + ",'" + email + "','" + senha + "')";
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
    
    public int editCondomino(String cpf, String nome,String placa ,String email, String senha){
        int res = 0;
        try {
            Statement stm = con.createStatement();
            res = stm.executeUpdate("UPDATE relatorio_condominos SET nome = '"+ nome + "', email = '" + email + "', senha = '" + senha + "', placa = '" + placa + "' WHERE cpf = " + cpf);
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }
    
    public ResultSet executaBuscaCondomino(String pesquisa) {
        try {
            Statement stm = con.createStatement();
            ResultSet rs = null;
            rs = stm.executeQuery("SELECT * FROM relatorio_condominos WHERE nome LIKE '"+pesquisa+"%';" );
            try {
                while (rs.next()) {
                    Condomino c = new Condomino();
                    String nome = rs.getString("nome");
                    int bloco = rs.getInt("bloco");
                    int apartamento = rs.getInt("apartamento");
                    c.setNome(nome);
                    c.setBloco(bloco);
                    c.setApartamento(apartamento);
                    Bancos.getBancos().getBdCondomino().add(c);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int apagarCondomino(String cpf){
        String sql= "SELECT exc_condomino ("+cpf+")";
        try{
        Statement stm = con.createStatement();
        ResultSet rs = null;
        rs = stm.executeQuery(sql);
        return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    //-------------------------------------------------------- //Relacionado aos Funcionarios
    
    public ResultSet atualizaBancoFuncionario() {
        try {
            Bancos.getBancos().getBdFuncionario().clear();
            Statement stm = con.createStatement();
            ResultSet rs = null;
            rs = stm.executeQuery("SELECT * FROM relatorio_funcionarios");
            try { // moradores
                while (rs.next()) {
                    Funcionario func = new Funcionario();

                    String cpf = rs.getString("cpf");
                    String nome = rs.getString("nome");
                    Float salario = rs.getFloat("salario");
                    String cargo = rs.getString("cargo");
                    String placa = rs.getString("placa");
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");

                    func.setCpf(cpf);
                    func.setNome(nome);
                    func.setSalario(salario);
                    func.setCargo(cargo);
                    func.getVeiculo().setPlaca(placa);
                    func.setEmail(email);
                    func.setSenha(senha);;
                    Bancos.getBancos().getBdFuncionario().add(func);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int achaFuncionarioCpf(String cpf) {
        int tamanho = 0;
        while (tamanho < Bancos.getBancos().getBdFuncionario().size()) {
            if (Bancos.getBancos().getBdFuncionario().get(tamanho).getCpf().equals(cpf)) {
                return tamanho;
            }
            tamanho = tamanho + 1;
        }
        return tamanho;
    }
    
    public int achaFuncionarioNoSal(String nome, float salario){
        int tamanho = 0;
        while(tamanho < Bancos.getBancos().getBdFuncionario().size()){
            if(Bancos.getBancos().getBdFuncionario().get(tamanho).getNome() == nome && Bancos.getBancos().getBdFuncionario().get(tamanho).getSalario() == salario) {  
                return tamanho;
            }
            tamanho = tamanho + 1;
        }
        return tamanho;          
    }
    
    public ResultSet executaBuscaFuncionario(String pesquisa) {
        try {
            Statement stm = con.createStatement();
            ResultSet rs = null;
            rs = stm.executeQuery("SELECT * FROM relatorio_funcionarios WHERE nome LIKE '"+pesquisa+"%';" );
            try {
                while (rs.next()) {
                    Funcionario f = new Funcionario();
                    String nome = rs.getString("nome");
                    String cargo = rs.getString("cargo");
                    float salario = rs.getFloat("salario");
                    f.setNome(nome);
                    f.setCargo(cargo);
                    f.setSalario(salario);
                    Bancos.getBancos().getBdFuncionario().add(f);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int addFuncionario(String cpf, String nome, Float salario, String cargo, String email, String senha, String placa) {
        try{
            if(placa.equals("")) {
                placa = "null";
            }
            else {
                placa = "'" + placa + "'";
            }
            Statement stm = con.createStatement();
            stm.executeUpdate("INSERT INTO relatorio_funcionarios "
                    + "values('" + cpf + "','" + nome + "','" + salario + "','" + cargo + "'," + placa + ",'" + email + "','" + senha + "')");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
    
    public int editFuncionario(String nome, String email, String senha, String placa, String cpf) {
        int res = 0;
        try {
            Statement stm = con.createStatement();
            res = stm.executeUpdate("UPDATE relatorio_funcionarios SET nome = '"+ nome + "', email = '" + email + "', senha = '" + senha + "', placa = '" + placa + "' WHERE cpf = " + cpf);
        } catch (SQLException e) {
            return 0;
        }
        return 1;
    }
    
    public int apagarFuncionario(String cpf){
        String sql= "SELECT exc_funcionario ("+cpf+")";
        try{
        Statement stm = con.createStatement();
        ResultSet rs = null;
        rs = stm.executeQuery(sql);
        return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    //------------------------------------------------------ // Registrar problemas
    
    public int registrarProblemas(String cpf, String desc, int bloco) {
        String sql = "INSERT INTO Reg_Problemas values (" + cpf + ", '" + desc + "', " + bloco + ", CURRENT_TIMESTAMP)";
        return registraProb(sql);
    }
    
    public int registrarProblemas(String cpf, String desc) {
        String sql = "INSERT INTO Reg_Problemas values (" + cpf + ", '" + desc + "', null, CURRENT_TIMESTAMP)";
        return registraProb(sql); 
    }
    
    public int registraProb(String sql) {
        int res = 0;
        try {
            Statement stm = con.createStatement();
            res = stm.executeUpdate(sql);
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }
    
    //-------------------------------------------------Visitantes
    
    public ResultSet atualizaBancoVisitante() {
        Bancos.getBancos().getBdVisitante().clear();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = null;
            rs = stm.executeQuery("SELECT * FROM Visita");
            try { // moradores
                while (rs.next()) {
                    Visitante visitante = new Visitante();

                    String nomeVisitante = rs.getString("nome");
                    int blocoVisitado = rs.getInt("bloco_vis");
                    int apVisitado = rs.getInt("apartamento_vis");
                    String entrada = rs.getString("entrada");
                    String saida = rs.getString("saida");

                    visitante.setNomeVisitante(nomeVisitante);
                    visitante.setBlocoVisitado(blocoVisitado);
                    visitante.setApVisitado(apVisitado);
                    visitante.setEntrada(entrada);
                    visitante.setSaida(saida);
                    Bancos.getBancos().getBdVisitante().add(visitante);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int registraEntradaVisitante(String nome, int bloco, int apartamento) {
        String sql = "INSERT INTO Visita VALUES ('" + nome + "', " + bloco + ", " + apartamento + ", CURRENT_TIMESTAMP, null)";
        System.out.println(sql);
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }
    
    public int registraSaidaVisitante(String nome, int bloco, int apartamento) {
        String sql = "UPDATE Visita SET saida = CURRENT_TIMESTAMP WHERE nome = '"+nome+"', bloco_vis = "+bloco+", apartamento_vis = " + apartamento;
        try {
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return 1;
        } catch (SQLException e) {
            return 0;
        }
        
    }
    
    //---------------------------------------------Empresas
        
    public int addEmpresasParceiras(String nome, String contato, String responsavel) {
        String sql = "INSERT INTO Emp_Contrat values ('"+nome+"', '"+contato+"', '"+responsavel+"')";
        try{
            Statement stm = con.createStatement();
            stm.executeUpdate(sql);
            return 1;
        } catch (SQLException e) {
            return 0;
        }
    }
    
    public ResultSet atualizaBancoEmpresa() {
        Bancos.getBancos().getBdEmpresas().clear();
        try {
            Statement stm = con.createStatement();
            ResultSet rs = null;
            rs = stm.executeQuery("SELECT * FROM emp_contrat");
            try { // moradores
                while (rs.next()) {
                    Empresas empresa = new Empresas();

                    String nome = rs.getString("nome");
                    String contato = rs.getString("contato");
                    String responsavel = rs.getString("responsavel");

                    empresa.setNome(nome);
                    empresa.setContato(contato);
                    empresa.setResponsavel(responsavel);
                    Bancos.getBancos().getBdEmpresas().add(empresa);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}

