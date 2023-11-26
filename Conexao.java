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
    private  static String senha;
    private Connection con;
    private static Conexao conUnico;
    
    private static Conexao getConexao() {
        if(conUnico == null) {
            conUnico = new Conexao(senha);
        }
        return conUnico;
    }
    
    private Conexao(String senha) {
        url = "jdbc:postgresql://localhost:5432/Sapaiada";
        usuario = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conexão feita com sucesso!",
                    "Sucesso", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
