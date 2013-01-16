/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import sistemadeinventario.ConectionH;

/**
 * Esta clase es la responsable de leer y modificar los precios de 
 * los articulos de acuerdo a su codigo y talle 
 * @author Andres
 */
public class ControladorPrecios {

    private ConectionH c;

    public ControladorPrecios() {
        this.c = new ConectionH();
    }

    /**
     * Retorna el precio almacenado en la base de datos a partir del
     * codigo y talle del articulo
     */
    public String cargar(String codigo, String talle) {
        Statement stmt = this.c.getStatement();
        String precio = "";
        try {
            String select = "SELECT precio FROM precios "
                    + " WHERE codigo = '" + codigo + "' AND talle = '" + talle + "'";
            ResultSet rs = stmt.executeQuery(select);
            rs.last();
            if (rs.getRow() != 0) {
                rs.first();
                precio = rs.getString("precio");
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al cargar el precio.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        return precio;
    }

    /**
     * Modifica el precio almacenado en la base de datos a partir del
     * codigo y talle del articulo
     */
    public boolean modificar(String codigo, String talle, String precio) {
        Statement stmt = this.c.getStatement();
        String update = "UPDATE precios SET precio='" + precio
                + "' WHERE codigo='" + codigo + "' AND talle='" + talle + "'";
        try {
            String select = "SELECT precio FROM precios "
                    + " WHERE codigo = '" + codigo + "' AND talle = '" + talle + "'";
            ResultSet rs = stmt.executeQuery(select);
            rs.last();
            if (rs.getRow() == 0) {
                update = "INSERT INTO precios (codigo, talle, precio) VALUES "
                        + "('" + codigo + "', '" + talle + "', '" + precio + "')";
            }
            stmt.executeUpdate(update);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al modificar el precio.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
