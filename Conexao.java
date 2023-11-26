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
    
    
    //------------------------------------------------------
    
    public int verificaCargo(String email) {
        int resultado = 0;
        String stringSql = "SELECT desc_pessoa('" + email + "')";
        try{
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(stringSql);
            rs.next();
            resultado = rs.getInt("desc_pessoa");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resultado);
        return resultado;
    }
}
