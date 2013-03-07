/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Andres
 */
public class ControladorConfiguracion {
    
    public static Hashtable<String, String> leer_ini() {
        Hashtable<String, String> conf = new Hashtable<String, String>();
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("C:\\Sistema de RossiSport\\params.ini"));
            conf.put("driver", p.getProperty("driver"));
            conf.put("jdbc", p.getProperty("jdbc"));
            conf.put("host", p.getProperty("host"));
            conf.put("puerto", p.getProperty("puerto"));
            conf.put("base", p.getProperty("base"));
            // Si no está el parametro user, utiliza uno por defecto ("usuario")
            conf.put("usuario", p.getProperty("user", "usuario"));
            conf.put("contraseña", p.getProperty("data"));
            conf.put("local", p.getProperty("local"));
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema", "Error al leer la configuración", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            return null;
        }
        return conf;
    }
    
    public static String leerDato(String nombre){
        String conf = null;
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("C:\\Sistema de RossiSport\\params.ini"));
            conf = p.getProperty(nombre);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema", "Error al leer el dato" + nombre, JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
        }
        return conf;
    }
}