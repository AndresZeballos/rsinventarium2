/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sistemadeinventario.ConectionH;

/**
 * Esta clase es responsable de realizar las consultas de stock y las
 * actualizaciones sobre el mismo
 *
 * @author Andres
 */
public class ControladorArticulos {

    public static final int OK = 0;
    public static final int CODIGO_INCORRECTO = 1;
    public static final int NO_NUMERICO = 2;
    private ControladorCaracteristicas caracteristicas;
    private ConectionH c;

    public ControladorArticulos(ControladorCaracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
        this.c = new ConectionH();
    }

    /**
     * Metodo responsable de realizar las consultas de stock. Permite realizar
     * busquedas avanzadas de articulos por: codigo, talle, color, lugar del
     * articulo; categoria, marca y composicion del producto y por precio.
     */
    public String[][] consultar(String codigo, String talle, String color, String local, String categoria, String marca, String tela, String precio) {
        String consulta = "";
        String tablas = " articulos AS a LEFT JOIN precios AS p ON a.talle = p.talle AND a.codigo = p.codigo, descripciones AS d ";
        // Se agrega a.stock <> 0 AND para evitar los resultados "vacios"
        String joins = " a.stock <> 0 AND a.codigo = d.codigo ";
        // Arma las condiciones de la consulta a partir de los filtros presentes
        if (!codigo.equals("") || !talle.equals("") || !color.equals("") || !local.equals("") || !categoria.equals("") || !marca.equals("") || !tela.equals("") || !precio.equals("")) {
            boolean solo_uno = true;
            if (!codigo.equals("")) {
                consulta += " a.codigo = \"" + codigo + "\"";
                solo_uno = false;
            }
            if (!talle.equals("")) {
                // max = (a > b) ? a : b;
                // 
                if (!solo_uno) {
                    consulta += " AND";
                }
                consulta += " a.talle = \"" + talle + "\"";
                solo_uno = false;
            }
            if (!color.equals("")) {
                if (!solo_uno) {
                    consulta += " AND";
                }
                consulta += " a.color = \"" + color + "\"";
                solo_uno = false;
            }
            if (!local.equals("")) {
                if (!solo_uno) {
                    consulta += " AND";
                }
                consulta += " a.local = \"" + local + "\"";
                solo_uno = false;
            }
            if (!categoria.equals("")) {
                if (!solo_uno) {
                    consulta += " AND";
                }
                consulta += " d.categoria = \"" + categoria + "\"";
                solo_uno = false;
            }
            if (!marca.equals("")) {
                if (!solo_uno) {
                    consulta += " AND";
                }
                consulta += " d.marca = \"" + marca + "\"";
                solo_uno = false;
            }
            if (!tela.equals("")) {
                tablas += ", composiciones AS c";
                joins += " AND a.codigo = c.codigo ";
                if (!solo_uno) {
                    consulta += " AND";
                }
                consulta += " c.component = \"" + tela + "\"";
                solo_uno = false;
            }
            if (!precio.equals("")) {
                if (!solo_uno) {
                    consulta += " AND";
                }
                consulta += " p.precio = \"" + precio + "\"";
                // solo_uno = false;
            }
        }
        String[][] resultado = new String[][]{};
        Statement stmt = this.c.getStatement();
        ResultSet rs;
        try {
            int cColumnas = 7;
            // Completa la consulta con las tablas, reuniones y condiciones
            consulta = "SELECT DISTINCT a.codigo, d.descripcion, p.precio, a.talle, a.color, a.local, a.stock "
                    + "FROM " + tablas + " WHERE " + joins + ((consulta.equals("")) ? "" : " AND ") + consulta; // + " ORDER BY a.codigo";
            rs = stmt.executeQuery(consulta);
            // Crea la estructura a retornar a partir de la cantidad de resultados de la consulta
            rs.last();
            int rowCount = rs.getRow();
            if (rowCount != 1) {
                resultado = new String[rowCount + 1][cColumnas];
            } else {
                resultado = new String[rowCount][cColumnas];
            }
            int suma = 0;
            rs.first();
            // Carga los resultados en la estructura
            for (int i = 0; i < rowCount; i++, rs.next()) {
                resultado[i][0] = rs.getString("codigo");
                resultado[i][1] = rs.getString("descripcion");
                resultado[i][2] = ((rs.getString("precio") == null) ? "" : rs.getString("precio"));
                resultado[i][3] = rs.getString("talle");
                resultado[i][4] = rs.getString("color");
                resultado[i][5] = rs.getString("local");
                resultado[i][6] = rs.getString("stock");
                suma += Integer.parseInt(rs.getString("stock"));
            }
            // Agrega la fila con los datos genericos (*) o concretos y su suma
            if (rowCount != 1) {
                if (!codigo.equals("")) {
                    resultado[rowCount][0] = codigo;
                } else {
                    resultado[rowCount][0] = "*";
                }
                resultado[rowCount][1] = "*";
                if (!precio.equals("")) {
                    resultado[rowCount][2] = "$" + precio;
                } else {
                    resultado[rowCount][2] = "*";
                }
                if (!talle.equals("")) {
                    resultado[rowCount][3] = talle;
                } else {
                    resultado[rowCount][3] = "*";
                }
                if (!color.equals("")) {
                    resultado[rowCount][4] = color;
                } else {
                    resultado[rowCount][4] = "*";
                }
                if (!local.equals("")) {
                    resultado[rowCount][5] = local;
                } else {
                    resultado[rowCount][5] = "*";
                }
                resultado[rowCount][6] = String.valueOf(suma);
            }
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al consultar el stock.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }

    /**
     *
     */
    public boolean actualizarStock(String codigo, String talle, String color, String local, int cantidad) {
        Statement stmt = this.c.getStatement();
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT stock FROM articulos "
                    + " WHERE codigo = '" + codigo
                    + "' AND talle = '" + talle
                    + "' AND color = '" + color
                    + "' AND local = '" + local + "'");
            rs.last();
            if (rs.getRow() == 0) {
                stmt.executeUpdate("INSERT INTO articulos (codigo, talle, color, local, stock) VALUES "
                        + "('" + codigo + "', '" + talle + "', '" + color + "', '" + local + "', '" + cantidad + "')");
            } else {
                stmt.executeUpdate("UPDATE articulos SET stock = stock + " + cantidad + " WHERE codigo = \"" + codigo
                        + "\" AND talle = \"" + talle + "\" AND color = \"" + color + "\" AND local = \"" + local + "\"");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorArticulos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    /**
     * Procesa el archivo aumentando o reduciendo el stock dependiendo del
     * parametro aumentar.
     */
    public boolean cargar(String archivo, boolean aumentar) {
        // Carga el contenido del archivo y lo valida
        ArrayList<String[]> csv = levantarCSV(archivo);
        if (!validarCSV(csv)) {
            return false;
        }
        // Procesa el CSV actualizando el stock
        Statement stmt = this.c.getStatement();
        String select, update;
        String[] linea = new String[6];
        ResultSet rs;
        for (int i = 0; i < csv.size(); i++) {
            try {
                linea = csv.get(i);
                // Consulta si existe la fila con los datos
                select = "SELECT * FROM articulos "
                        + " WHERE codigo = '" + linea[0]
                        + "' AND talle = '" + linea[1]
                        + "' AND color = '" + linea[2]
                        + "' AND local = '" + linea[3] + "'";
                rs = stmt.executeQuery(select);
                rs.last();
                if (rs.getRow() == 0) {
                    // Si no existe la crea con stock 0 (cero)
                    stmt.executeUpdate("INSERT INTO articulos "
                            + "(codigo, talle, color, local, stock) VALUES "
                            + "('" + linea[0] + "', '" + linea[1] + "', '" + linea[2] + "', '" + linea[3] + "', '0')");
                }
                // Aumenta o reduce el stock del articulo
                update = "UPDATE articulos SET stock = stock " + ((aumentar) ? "+ " : "- ") + linea[4]
                        + " WHERE codigo = '" + linea[0]
                        + "' AND talle = '" + linea[1]
                        + "' AND color = '" + linea[2]
                        + "' AND local = '" + linea[3] + "'";
                stmt.executeUpdate(update);
                linea[5] = "OK";
            } catch (SQLException ex) {
                JOptionPane.showConfirmDialog(null, "Ocurrió un problema al actualizar el stock.\nAbra el archivo por más detalles.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
                linea[5] = "NO";
            }
        }
        // Guarda el resultado de la operación
        guardarCSV(archivo, csv);
        return true;
    }

    /**
     * Abre el archivo pasado por parametro y lee su contenido almacenandolo en
     * memoria para procesarlo.
     */
    private ArrayList<String[]> levantarCSV(String archivo) {
        ArrayList<String[]> resultado = new ArrayList<String[]>();
        try {
            //create BufferedReader to read csv file
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String strLine;
            StringTokenizer st;
            int lineNumber = 0, tokenNumber = 0;
            //read comma separated file line by line
            while ((strLine = br.readLine()) != null) {
                //break comma separated line using ","
                st = new StringTokenizer(strLine, ",");
                resultado.add(new String[6]);
                while (st.hasMoreTokens()) {
                    //display csv values
                    resultado.get(lineNumber)[tokenNumber] = st.nextToken();
                    tokenNumber++;
                }
                //reset token number
                tokenNumber = 0;
                // Nueva linea
                lineNumber++;
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al leer el CSV.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        }
        return resultado;
    }

    /**
     * Valida que los códigos de todos los artículos a ingresar esten dados de
     * alta en el sistema.
     */
    private boolean validarCSV(ArrayList<String[]> csv) {
        String[] linea;
        for (int i = 0; i < csv.size(); i++) {
            linea = csv.get(i);
            if (!this.caracteristicas.existeElementoCaracteristica(linea[0], "descripciones")) {
                // Si no existe el código del producto
                return false;
            }
        }
        return true;
    }

    /**
     * Luego de procesar el CSV, se guarda su información agregando el resultado
     * en cada fila ("OK" o "NO")
     */
    private void guardarCSV(String archivo, ArrayList<String[]> resultado) {
        FileWriter fichero = null;
        BufferedWriter bw;
        String str;
        String[] linea;
        try {
            fichero = new FileWriter(archivo);
            bw = new BufferedWriter(fichero);
            // Para cada línea del archivo
            for (int i = 0; i < resultado.size(); i++) {
                // Arma la línea nuevamente más el resultado
                str = "";
                linea = resultado.get(i);
                for (int j = 0; j < linea.length; j++) {
                    str += linea[j] + ",";
                }
                // Escribe la línea en el archivo
                bw.write(str + "\n");
            }
            bw.close();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Ocurrió un problema al guardar el CSV.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "Ocurrió un problema al cerrar el CSV.", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
