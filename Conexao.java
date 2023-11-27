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
    
    //--------------------------------------------------------- // relacionado aos Condôminos
    
    public ResultSet atualizaBancoCondomino() {
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
    
    public int addCondomino(String cpf, String nome, int bloco, int apartamento, String placa ,String email, String senha) {
        int res = 0;
        try{
            Statement stm = con.createStatement();
            res = stm.executeUpdate("INSERT INTO relatorio_condominos "
                    + "values('" + cpf + "','" + nome + "','" + bloco + "','" + apartamento + "','" + placa + "','" + email + "','" + senha + "')");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
    
    public int editCondomino(String cpf, String nome, int bloco, int apartamento, String placa ,String email, String senha){
        int res = 0;
        try{
            Statement stm = con.createStatement();
            res = stm.executeUpdate("UPDATE relatorio_condominos "
                    + "SET(cpf =" + cpf + ",'nome =" + nome + "','bloco =" + bloco + "','apartamento =" + apartamento + "','placa =" + placa + "','email =" + email + "','senha =" + senha + "') WHERE cpf =" + cpf +";");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
    
    //-------------------------------------------------------- //Relacionado aos Funcionarios
    
    public ResultSet atualizaBancoFuncionario() {
        try {
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
    
    public int addFuncionario(String cpf, String nome, Float salario, String cargo, String email, String senha, String placa) {
        int res = 0;
        try{
            Statement stm = con.createStatement();
            res = stm.executeUpdate("INSERT INTO relatorio_funcionarios "
                    + "values('" + cpf + "','" + nome + "','" + salario + "','" + cargo + "','" + placa + "','" + email + "','" + senha + "')");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
    
}


    

//------------------------------------------------------

