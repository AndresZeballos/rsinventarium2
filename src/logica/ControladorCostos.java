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
 *
 * @author Andres
 */
public class ControladorCostos {

    private ConectionH c;

    public ControladorCostos() {
        this.c = new ConectionH();
    }

    public String[] cargar(String codigo, String talle) {
        Statement stmt = this.c.getStatement();
        String[] costos = new String[]{"", "", ""};
        try {
            String select = "SELECT origen, costo_entrada, costo_compra FROM costos"
                    + " WHERE codigo='" + codigo + "' AND talle='" + talle + "';";
            ResultSet rs = stmt.executeQuery(select);
            rs.last();
            if (rs.getRow() != 0) {
                rs.first();
                costos[0] = rs.getString("origen");
                if(costos[0] == null || costos[0].equals("null")){
                    costos[0] = "";
                }
                costos[1] = rs.getString("costo_entrada");
                if(costos[1] == null || costos[1].equals("null")){
                    costos[1] = "";
                }
                costos[2] = rs.getString("costo_compra");
                if(costos[2] == null || costos[2].equals("null")){
                    costos[2] = "";
                }
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al cargar los costos.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        return costos;
    }

    public boolean modificar(String codigo, String talle, String origen, String costoEntrada, String costoCompra) {
        Statement stmt = this.c.getStatement();
        String update = "UPDATE costos "
                + "SET origen='" + origen + "', costo_entrada='" + costoEntrada + "', costo_compra='" + costoCompra + "'"
                + " WHERE codigo='" + codigo + "' AND talle='" + talle + "'";
        try {
            String select = "SELECT * FROM costos "
                    + " WHERE codigo = '" + codigo + "' AND talle = '" + talle + "'";
            ResultSet rs = stmt.executeQuery(select);
            rs.last();
            if (rs.getRow() == 0) {
                update = "INSERT INTO costos (codigo, talle, origen, costo_entrada, costo_compra) VALUES "
                        + "('" + codigo + "', '" + talle + "', '" + origen + "', '" + costoEntrada + "', '" + costoCompra + "')";
            }
            stmt.executeUpdate(update);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Error!", "Ocurrió un problema al modificar los costos.\nProducto: " + codigo + " Talle: " + talle + ".", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
    
    public boolean modificar(String codigo, String talle, String costoCompra) {
        Statement stmt = this.c.getStatement();
        String update = "UPDATE costos "
                + "SET costo_compra='" + costoCompra + "'"
                + " WHERE codigo='" + codigo + "' AND talle='" + talle + "'";
        try {
            String select = "SELECT * FROM costos "
                    + " WHERE codigo = '" + codigo + "' AND talle = '" + talle + "'";
            ResultSet rs = stmt.executeQuery(select);
            rs.last();
            if (rs.getRow() == 0) {
                update = "INSERT INTO costos (codigo, talle, costo_compra) VALUES "
                        + "('" + codigo + "', '" + talle + "', '" + costoCompra + "')";
            }
            stmt.executeUpdate(update);
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al modificar los costos.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}
