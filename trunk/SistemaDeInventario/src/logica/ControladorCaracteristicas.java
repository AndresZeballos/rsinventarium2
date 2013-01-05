/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JOptionPane;
import sistemadeinventario.ConectionH;

/**
 * Esta clase se encarga de controlar las tablas basicas de caracteristicas, las
 * cuales completan los listados de opciones de las pantallas También es
 * responsable de validar el mantenimiento del sistema Esto se debe a que la
 * tabla de control de mantenimiento tiene la misma estructura básica de las
 * caracteristicas, y por eso se reutiliza esa lógica Es la primer controladora
 * a instanciarse para que realiza la validación al comienzo de la ejecución del
 * programa
 *
 * @author Andres
 */
public class ControladorCaracteristicas {

    // Este hashtable contiene los pares:
    // nombre de tabla (o caracteristica) como clave
    // Y el contenido de la tabla como valor
    private Hashtable<String, List> caracteristicas;
    // Campos utilizado para informar errores de conectividad y otros errores
    private boolean ok;
    private ConectionH c;

    public ControladorCaracteristicas() {
        this.ok = true;
        this.c = new ConectionH();
        if (!this.c.getOk()) {
            JOptionPane.showConfirmDialog(null, "Problema de conectividad!", "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            this.ok = false;
            return;
        }
        initCaracteristicas();
        validarMantenimiento();
    }

    /**
     * Carga a memoria el contenido de las tablas de la base de datos de las
     * caracteriasticas.
     */
    public void initCaracteristicas() {
        this.caracteristicas = new Hashtable<String, List>();
        String[] tablas = {
            // Caracteristicas propias de la descripción de los articulos
            // Estas categorias solo agregaban complejidad al sistema
            // Y no aportaban de manera clara un uso o beneficio
            /*
             "pinzas",
             "telas",
             "estaciones",
             "tipopantalon",
             "tipoestampado",
             "cuellos",
             "mangas",
             "tiporemera",
             "lisorayado",
             "tipocampera",
             "lisafantasia",
             "tiposuela",
             "tipotirador",
             "tipocinturon",
             "tipopack",
             "vbotones",
             "vbase",
             "cortolargo",
             */
            // Categorias necesarias del sistema y comunes a los productos
            "colores",
            "talles",
            "locales",
            "marcas",
            "categorias",
            "descripciones",
            "componentes",
            // Controlador de pago de servicio
            "meses",
            // Modificación para modulo de compras
            "monedas",
            "tipo_pagos",
            "plazo_pagos",
            "paises",
            "proveedores"
        };
        Statement stmt = c.getStatement();
        ResultSet rs;
        List<String> lista;
        // Para cada tabla listada, carga su contenido en memoria.
        String columna;
        for (String tabla : tablas) {
            try {
                rs = stmt.executeQuery("SELECT COLUMN_NAME "
                        + "FROM information_schema.COLUMNS "
                        + "WHERE TABLE_SCHEMA = 'rossisport' "
                        + "AND TABLE_NAME = '" + tabla + "' "
                        + "limit 1");
                rs.next();
                columna = rs.getString(1);
                rs = stmt.executeQuery("SELECT " + columna
                        + " from " + tabla
                        + " ORDER BY " + columna);
                //rs = stmt.executeQuery("SELECT * from " + tabla);
                lista = new ArrayList<String>();
                while (rs.next()) {
                    lista.add(rs.getString(1));
                }
                this.caracteristicas.put(tabla, lista);
            } catch (SQLException e) {
                JOptionPane.showConfirmDialog(null, "SQLException al iniciar las caracteristicas!\nOcurrencia de: " + tabla, "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
                JOptionPane.showConfirmDialog(null, e.toString(), "Error!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
                this.ok = false;
                return;
            }
        }
    }

    /**
     * Valida que el mantenimiento haya sido realizado.
     */
    public void validarMantenimiento() {
        // Formatea el string con el mes actual y año (MM/YYYY)
        Date d = new Date();
        String fecha = (d.getMonth() + 1) + "/" + (d.getYear() + 1900);
        if ((d.getMonth() + 1) < 10) {
            fecha = "0" + fecha;
        }
        // Verifica que exista el registro en la base de datos
        if (!this.existeElementoCaracteristica(fecha, "meses")) {
            // De no existir, termina la inicialización en error
            this.ok = false;
            JOptionPane.showConfirmDialog(null, "No se ha cumplido con el calendario de pagos.", "Excepción", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            this.caracteristicas = new Hashtable<String, List>();
        }
    }

    public boolean getOk() {
        return this.ok;
    }

    /**
     * Retorna el contenido de la tabla (caracteristica) con el nombre pasado
     * por parametro.
     */
    public List<String> getCaracteristica(String caracteristica) {
        // Para la tabla de talles se carga el contenido de la siguiente
        // manera:  (La tabla de talles no se puede modificar con la aplicación)
        if (caracteristica.equals("talles")) {
            List<String> l = new ArrayList<String>();
            l.add("XS");
            l.add("S");
            l.add("M");
            l.add("L");
            l.add("XL");
            l.add("2XL");
            l.add("3XL");
            l.add("4XL");
            l.add("5XL");
            l.add("6XL");
            l.add("");
            l.add("14");
            l.add("16");
            l.add("");
            l.add("28");
            l.add("30");
            l.add("32");
            l.add("34");
            l.add("36");
            l.add("38");
            l.add("40");
            l.add("42");
            l.add("44");
            l.add("46");
            l.add("48");
            l.add("50");
            l.add("52");
            l.add("54");
            l.add("56");
            l.add("58");
            l.add("60");
            l.add("62");
            l.add("64");
            l.add("66");
            l.add("68");
            l.add("70");
            l.add("72");
            l.add("74");
            return l;
        }
        // Las demás tablas retornan su contenido directamente.
        return this.caracteristicas.get(caracteristica);
    }

    /**
     * Retorna verdadero si existe el elemento en la caracteristica.
     */
    public boolean existeElementoCaracteristica(String elemento, String caracteristica) {
        List a = this.caracteristicas.get(caracteristica);
        return a.contains(elemento);
    }

    /**
     * Inserta el elemento en la tabla y retorna el resultado de la operación.
     */
    public boolean crear(String tabla, String elemento) {
        // Se realiza la inserción.
        Statement stmt = c.getStatement();
        try {
            stmt.executeUpdate("INSERT INTO " + tabla + " VALUES ('" + elemento + "')");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Problema de inserción!\nNo esta permitida esta operación", "Error!!!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.initCaracteristicas();
        return true;
    }

    /**
     * Elimina el elemento de la tabla y retorna el resultado de la operación.
     */
    public boolean eliminar(String tabla, String elemento) {
        /* Se tomó la siguiente convención:
         * El nombre de la columna es el mismo que la tabla sin 
         * la "s" final. Si al quitar la "s", y la palabra queda
         * terminando en "e", también se quita la "e". 
         */
        // Se procesa el nombre de la columna en base a la convención.
        String columna = tabla.substring(0, tabla.length() - 1).replaceAll("_", "");
        if (columna.charAt(columna.length() - 1) == 'e') {
            columna = columna.substring(0, columna.length() - 1);
        }
        // Se realiza la eliminación.
        Statement stmt = c.getStatement();
        try {
            stmt.executeUpdate("DELETE FROM " + tabla + " WHERE " + columna + " = '" + elemento + "'");
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Problema de eliminación!\nNo esta permitida esta operación", "Error!!!", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return false;
        }
        this.initCaracteristicas();
        return true;
    }
}
