package sistemadeinventario;

import java.sql.*;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import logica.ControladorConfiguracion;

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
        Hashtable<String, String> datos = ControladorConfiguracion.leer_ini();
        driver = datos.get("driver");
        jdbc = datos.get("jdbc");
        host = datos.get("host");
        puerto = datos.get("puerto");
        base = datos.get("base");
        // Si no está el parametro user, utiliza uno por defecto ("usuario")
        usuario = datos.get("usuario");
        contraseña = datos.get("contraseña");

    }
}
