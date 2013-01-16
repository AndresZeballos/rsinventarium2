package sistemadeinventario;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import javax.swing.JOptionPane;

/*
 * Esta clase levanta el archivo de configuración ubicado en:
 * "C:\\Sistema de RossiSport\\params.ini"
 * Y utiliza sus valores como parametro para levantar la conección con 
 * la base de datos.
 * Mediante el método getStatement se puede obtener una instancia de 
 * Statement para realizar las consultas a la base de datos.
 */
public class ConectionH {

    private Statement stmt;
    private Connection con;
    private String driver, jdbc, host, puerto, base, usuario, contraseña;
    private boolean ok;

    public boolean getOk() {
        return this.ok;
    }
    public Statement getStatement() {
        return this.stmt;
    }

    public ConectionH() {
        leer_ini();
        try {
            Class.forName(driver); // Class.forName("com.mysql.jdbc.Driver");
            String url = jdbc + host + puerto + base; // "jdbc:mysql://localhost:3306/rossisport";
            con = DriverManager.getConnection(url, usuario, contraseña); // DriverManager.getConnection(url, "root", "");
            stmt = con.createStatement();
            this.ok = true;
        } catch (Exception e) {
            this.ok = false;
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al conectarse a la base de datos", "Error en la conección", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
        }
    }
    
    private void leer_ini() {
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("C:\\Sistema de RossiSport\\params.ini"));
            driver = p.getProperty("driver");
            jdbc = p.getProperty("jdbc");
            host = p.getProperty("host");
            puerto = p.getProperty("puerto");
            base = p.getProperty("base");
            // Si no está el parametro user, utiliza uno por defecto ("usuario")
            usuario = p.getProperty("user", "usuario");
            contraseña = p.getProperty("data");
        } catch (Exception e) {
            this.ok = false;
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema", "Error al leer la configuración", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
        }
    }
}
