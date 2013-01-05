/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.FileInputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.swing.JOptionPane;
import sistemadeinventario.ConectionH;

/**
 *
 * @author Andres
 */
public class ControladorFacturas {

    private ControladorArticulos articulos;
    private ControladorCostos costos;
    private ConectionH c;

    public ControladorFacturas(ControladorArticulos articulos, ControladorCostos costos) {
        this.articulos = articulos;
        this.costos = costos;
        this.c = new ConectionH();
    }

    /**
     *
     */
    public boolean crear(String prov, String fac, String fecha, String mon, String tipop, String plazop, int iva, int desc, int total_s_iva, ArrayList<String[]> lineas) {
        String local = getLocal();
        Statement stmt = this.c.getStatement();
        String insert =
                "INSERT INTO facturas "
                + "(proveedor, factura, fecha, moneda, tipopago, plazopago, iva, descuentos, total_s_iva) "
                + "VALUES ('" + prov + "', '" + fac + "', STR_TO_DATE(REPLACE('" + fecha + "','/','.') ,GET_FORMAT(date,'EUR')), '" + mon + "', '" + tipop + "', '" + plazop + "', '" + iva + "', '" + desc + "', '" + total_s_iva + "')";
        int clave;
        try {
            //stmt.executeUpdate("set autocommit = 0");
            stmt.executeUpdate(insert, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            clave = rs.getInt(1);
            rs.close();
            int i = 0;
            for (String[] linea : lineas) {
                insert = "INSERT INTO linea_factura (factura, linea, cantidad, codigo, talle, color, precio) "
                        + "VALUES ('" + clave + "', '" + i + "', '" + linea[0] + "', '" + linea[1] + "', '" + linea[2] + "', '" + linea[3] + "', '" + linea[4] + "')";
                stmt.executeUpdate(insert);
                this.articulos.actualizarStock(linea[1], linea[2], linea[3], local, Integer.parseInt(linea[0]));
                this.costos.modificar(linea[1], linea[2], linea[4]);
                i++;
            }
            //stmt.executeUpdate("commit");
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al crear la factura.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private String getLocal() {
        String local = "";
        try {
            Properties p = new Properties();
            p.load(new FileInputStream("C:\\Sistema de RossiSport\\params.ini"));
            local = p.getProperty("local");
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema", "Error al leer la configuración", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
        }
        return local;
    }

    public ArrayList<String[]> cargarFacturas(String prov) {
        ArrayList<String[]> lineas = new ArrayList<String[]>();
        Statement stmt = c.getStatement();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT numero, fecha, factura, total_s_iva FROM facturas WHERE proveedor = '" + prov + "' ORDER BY fecha DESC");
            while (rs.next()) {
                String numero = rs.getString(1);
                Date dia = rs.getDate(2);
                String fecha = dia.getDate() + "/" + (dia.getMonth() + 1) + "/" + (dia.getYear() + 1900);
                String factura = rs.getString(3);
                String total = "" + rs.getInt(4);
                lineas.add(new String[]{numero, fecha, factura, total});
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema", "Error al recuperar las facturas.", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
            return new ArrayList<String[]>();
        }
        return lineas;
    }

    public String[] cargarFactura(int nfactura) {
        String[] datos = new String[]{"", "", "", "", "", "", "", "", ""};
        Statement stmt = c.getStatement();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * from facturas where numero = '" + nfactura + "'");
            while (rs.next()) {
                String prov = rs.getString("proveedor");
                String factura = rs.getString("factura");
                Date dia = rs.getDate("fecha");
                String fecha = dia.getDate() + "/" + (dia.getMonth() + 1) + "/" + (dia.getYear() + 1900);
                String mon = rs.getString("moneda");
                String tpago = rs.getString("tipopago");
                String tplazo = rs.getString("plazopago");
                String iva = "" + rs.getInt("iva");
                String desc = "" + rs.getInt("descuentos");
                String total = "" + rs.getInt("total_s_iva");
                datos = new String[]{prov, factura, fecha, mon, tpago, tplazo, iva, desc, total};
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema", "Error al recuperar la factura.", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
        }
        return datos;
    }
    
    public ArrayList<String[]> cargarFacturaLineas(int nfactura) {
        ArrayList<String[]> lineas = new ArrayList<String[]>();
        Statement stmt = c.getStatement();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT cantidad, codigo, talle, color, precio from linea_factura where factura = '" + nfactura + "' ORDER BY linea");
            while (rs.next()) {
                String cantidad = rs.getString("cantidad");
                String codigo = rs.getString("codigo");
                String talle = rs.getString("talle");
                String color = rs.getString("color");
                String precio = rs.getString("precio");
                lineas.add(new String[]{cantidad, codigo, talle, color, precio});
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema", "Error al recuperar las lineas de la factura.", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
        }
        return lineas;
    }
    
}
