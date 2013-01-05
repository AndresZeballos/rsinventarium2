/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sistemadeinventario.ConectionH;

/**
 *
 * @author Andres
 */
public class ControladorProveedor {

    private ControladorCaracteristicas caracteristicas;
    private ConectionH c;

    public ControladorProveedor(ControladorCaracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
        this.c = new ConectionH();
    }

    /**
     *
     */
    public boolean crear(String nombre, String ruc, String dir, String pais, String tel, String correo, ArrayList<String[]> contactos) {
        Statement stmt = this.c.getStatement();
        String insert = "INSERT INTO proveedores (nombre, ruc, direccion, pais, telefono, correo) VALUES "
                + "('" + nombre + "', '" + ruc + "', '" + dir + "', '" + pais + "', '" + tel + "', '" + correo + "')";
        try {
            stmt.executeUpdate(insert);
            for (String[] con : contactos) {
                insert = "INSERT INTO contactos (proveedor, nombre, telefono, correo) VALUES "
                        + " ('" + nombre + "', '" + con[0] + "', '" + con[1] + "', '" + con[2] + "')";
                stmt.executeUpdate(insert);
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al crear el proveedor.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // Actualiza las listas cargadas en memoria
        this.caracteristicas.initCaracteristicas();
        return true;
    }

    public String[] cargarDatos(String nombre) {
        String[] datos = new String[5];
        Statement stmt = this.c.getStatement();
        String consulta = "SELECT ruc, direccion, pais, telefono, correo FROM proveedores "
                + " WHERE nombre = '" + nombre + "'";
        ResultSet rs;
        try {
            rs = stmt.executeQuery(consulta);
            rs.first();
            datos[0] = rs.getString("ruc");
            datos[1] = rs.getString("direccion");
            datos[2] = rs.getString("pais");
            datos[3] = rs.getString("telefono");
            datos[4] = rs.getString("correo");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al cargar los datos.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        return datos;
    }

    public String[][] cargarContactos(String nombre) {
        String[][] contactos = new String[1][3];
        Statement stmt = this.c.getStatement();
        String consulta = "SELECT nombre, telefono, correo FROM contactos "
                + " WHERE proveedor = '" + nombre + "' ORDER BY nombre";
        ResultSet rs;
        try {
            rs = stmt.executeQuery(consulta);
            // Crea la estructura a retornar a partir de la cantidad de resultados de la consulta
            rs.last();
            int rowCount = rs.getRow();
            contactos = new String[rowCount][3];
            rs.first();
            for (int i = 0; i < rowCount; i++, rs.next()) {
                contactos[i][0] = rs.getString("nombre");
                contactos[i][1] = rs.getString("telefono");
                contactos[i][2] = rs.getString("correo");
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al cargar los datos.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        return contactos;
    }

    public boolean modificar(String nombre, String ruc, String dir, String pais, String tel, String correo, ArrayList<String[]> contactos) {
        Statement stmt = this.c.getStatement();
        String update = "UPDATE proveedores SET ruc='" + ruc
                + "', direccion='" + dir
                + "', pais='" + pais
                + "', telefono='" + tel
                + "', correo='" + correo
                + "' WHERE nombre='" + nombre + "'";
        try {
            stmt.executeUpdate(update);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al modificar el proveedor.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        String consulta = "delete from contactos where proveedor = '" + nombre + "'";
        try {
            stmt.executeUpdate(consulta);
            for (String[] con : contactos) {
                consulta = "INSERT INTO contactos (proveedor, nombre, telefono, correo) VALUES "
                        + " ('" + nombre + "', '" + con[0] + "', '" + con[1] + "', '" + con[2] + "')";
                stmt.executeUpdate(consulta);
            }
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al modificar los contactos del proveedor.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
