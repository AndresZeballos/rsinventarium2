/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import logica.ControladorArticulos;
import logica.ControladorCaracteristicas;
import logica.ControladorCostos;
import logica.ControladorEtiquetas;
import logica.ControladorFacturas;
import logica.ControladorPrecios;
import logica.ControladorProductos;
import logica.ControladorProveedor;

/**
 * Clase encargada de las interfaz gráfica
 *
 * @author Andres
 */
public class Principal extends javax.swing.JFrame {

    private ControladorCaracteristicas caracteristicas;
    private ControladorArticulos articulos;
    private ControladorProductos productos;
    private ControladorPrecios precios;
    private ControladorCostos costos;
    private ControladorProveedor proveedores;
    private ControladorFacturas facturas;
    private int columna_orden;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.caracteristicas = new ControladorCaracteristicas();
        if (!this.caracteristicas.getOk()) {
            this.dispose();
        } else {
            this.articulos = new ControladorArticulos(this.caracteristicas);
            this.productos = new ControladorProductos(this.caracteristicas);
            this.precios = new ControladorPrecios();
            this.costos = new ControladorCostos();
            this.proveedores = new ControladorProveedor(this.caracteristicas);
            this.facturas = new ControladorFacturas(this.articulos, this.costos);
            cargarPantallas(true);
        }
        this.columna_orden = 0;
    }

    /**
     * Retorna el resultado de la inicialización.
     */
    public boolean getOk() {
        return this.caracteristicas.getOk();
    }

    /**
     * Carga los elementos de las pantallas. Si total es verdadero, blanquea los
     * campos de texto; De lo contrario, mantiene su contenido.
     */
    public void cargarPantallas(boolean total) {
        cargarCombo("descripciones", this.jComboBox1);
        cargarCombo("talles", this.jComboBox2);
        cargarCombo("colores", this.jComboBox3);
        cargarCombo("locales", this.jComboBox4);

        cargarCombo("descripciones", this.jComboBox5);
        cargarCombo("talles", this.jComboBox6);
        cargarCombo("colores", this.jComboBox7);
        cargarCombo("locales", this.jComboBox8);

        cargarCombo("marcas", this.jComboBox9);
        cargarCombo("categorias", this.jComboBox10);
        cargarComposicion("componentes", this.jTable4/*, this.jList1, this.jTextArea1*/, total);

        cargarCombo("descripciones", this.jComboBox28);
        cargarCombo("marcas", this.jComboBox26);
        cargarCombo("categorias", this.jComboBox27);
        cargarComposicion("componentes", this.jTable10, total);
        //cargarList("componentes", this.jList2, this.jTextArea2, total);

        cargarCombo("descripciones", this.jComboBox29);
        cargarCombo("marcas", this.jComboBox30);
        cargarCombo("categorias", this.jComboBox31);
        cargarComposicion("componentes", this.jTable11, total);
        //cargarList("componentes", this.jList3, this.jTextArea3, total);

        // Modificaciones en la pantalla de consultar
        cargarCombo("categorias", this.jComboBox32);
        cargarCombo("marcas", this.jComboBox33);
        cargarCombo("componentes", this.jComboBox34);

        // Modificaciones para AB generico

        // Colores es el primer elemento del combo 38
        cargarCombo(this.jComboBox38.getSelectedItem().toString().toLowerCase().replaceAll(" ", "_"), this.jComboBox39);

        // Modificaciones para el Ver de producto

        cargarCombo("descripciones", this.jComboBox42);
        cargarCombo("marcas", this.jComboBox40);
        cargarCombo("categorias", this.jComboBox41);
        cargarComposicion("componentes", this.jTable6, total);
        //cargarList("componentes", this.jList4, this.jTextArea4, total);

        // Modificaciones para las etiquetas

        cargarCombo("descripciones", this.jComboBox43);
        cargarCombo("talles", this.jComboBox44);
        cargarCombo("colores", this.jComboBox45);

        // Modificaciones para el modulo de compras

        cargarCombo("monedas", this.jComboBox16);
        cargarCombo("tipo_pagos", this.jComboBox17);
        cargarCombo("plazo_pagos", this.jComboBox18);
        cargarCombo("paises", this.jComboBox11);
        cargarCombo("paises", this.jComboBox22);
        cargarCombo("paises", this.jComboBox12);

        cargarCombo("proveedores", this.jComboBox14);
        cargarCombo("proveedores", this.jComboBox15);
        cargarCombo("proveedores", this.jComboBox21);
        cargarCombo("proveedores", this.jComboBox20);


        agregarCombosALineasFactura(this.jTable3);

        Date hoy = new Date();
        String fecha = hoy.getDate() + "/" + (hoy.getMonth() + 1) + "/" + (hoy.getYear() + 1900);
        this.jTextField39.setText(fecha);

        // Modificaciones de la reingenieria

        // Enviar el controlador al panel
        this.prototipoIngresoMasivoEImpresion1.setCaracteristicas(caracteristicas);
        this.prototipoIngresoMasivoEImpresion1.setArticulos(articulos);
        this.prototipoIngresoMasivoEImpresion1.setPrecios(precios);
        this.prototipoIngresoMasivoEImpresion1.setProductos(productos);

        this.moverStock1.setArticulos(articulos);
        this.moverStock1.setCaracteristicas(caracteristicas);

        this.moverStockProducto1.setArticulos(articulos);
        this.moverStockProducto1.setCaracteristicas(caracteristicas);

        this.prototipoPrecioCostos1.setCaracteristicas(caracteristicas);
        this.prototipoPrecioCostos1.setCostos(costos);
        this.prototipoPrecioCostos1.setPrecios(precios);

        this.bajarStock1.setArticulos(articulos);
        this.bajarStock1.setCaracteristicas(caracteristicas);
        this.bajarStock1.setPrecios(precios);

        this.listadoProductos.setCaracteristicas(caracteristicas);
        this.listadoProductos.setProductos(productos);

        // Mejoras varias a la pantalla de compras
        this.jComboBox16.setSelectedIndex(1);

    }

    /**
     * Carga el combo indicado con los datos de la tabla.
     */
    private void cargarCombo(String tabla, JComboBox comboBox) {
        String selected = null;
        if (comboBox.getSelectedItem() != null) {
            selected = comboBox.getSelectedItem().toString();
        }
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        model.addElement("");
        List<String> l = this.caracteristicas.getCaracteristica(tabla);
        for (String m : l) {
            model.addElement(m);
        }
        comboBox.setModel(model);
        if (selected != null) {
            comboBox.setSelectedItem(selected);
        }
    }

    /**
     * Carga los list y textarea indicados con los datos de la tabla.
     */
    private void cargarComposicion(String tabla, JTable jtable /*, JList list, JTextArea area*/, boolean borrar_text) {
        List<String> l = this.caracteristicas.getCaracteristica(tabla);
        DefaultTableModel modelo = (DefaultTableModel) jtable.getModel();
        if (borrar_text) {
            while (modelo.getRowCount() != 0) {
                modelo.removeRow(0);
            }
            for (String comp : l) {
                modelo.addRow(new Object[]{comp, new Integer(0)});
            }
        } else {
            if (l.size() != modelo.getRowCount()) {
                modelo.addRow(new Object[]{l.get(l.size() - 1), new Integer(0)});
            }
        }
        /*
         DefaultListModel model = new DefaultListModel();
         if (borrar_text) {
         area.setText("");
         }
         for (String m : l) {
         model.addElement(m);
         if (borrar_text) {
         area.setText(area.getText() + "0\n");
         }
         }
         list.setModel(model);
         */
    }

    /**
     * Carga los elementos de la pantalla con los datos del producto.
     */
    private void cargarProducto(String codigo, JComboBox marca, JComboBox categoria, JTextField descripcion1, JTextField descripcion2, JTable tabla) {
        Hashtable<String, String> datos = this.productos.cargarDatos(codigo);
        marca.setSelectedItem(datos.get("marca"));
        categoria.setSelectedItem(datos.get("categoria"));
        String desc = datos.get("descripcion");
        String desc1 = "";
        String desc2 = "";
        if (desc.length() > 0) {
            desc1 = desc.substring(0, 30).trim();
            if (desc.length() > 30) {
                desc2 = desc.substring(30, desc.length()).trim();
            }
        }
        descripcion1.setText(desc1);
        descripcion2.setText(desc2);

        Hashtable<String, String> componentes = this.productos.cargarComponentes(codigo);

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        while (modelo.getRowCount() != 0) {
            modelo.removeRow(0);
        }
        List<String> l = this.caracteristicas.getCaracteristica("componentes");
        for (String comp : l) {
            if (componentes.containsKey(comp)) {
                modelo.addRow(new Object[]{comp, new Integer(componentes.get(comp))});
            } else {
                modelo.addRow(new Object[]{comp, new Integer(0)});
            }
        }
        /*
         ListModel model = lista.getModel();
         String str = "";

         for (int i = 0; i < model.getSize(); i++) {
         if (componentes.containsKey(model.getElementAt(i))) {
         str += componentes.get(model.getElementAt(i)) + "\n";
         } else {
         str += "0\n";
         }
         }
         porcentajes.setText(str);
         */
    }

    private DefaultTableModel agregarLinea(TableModel a) {
        DefaultTableModel b = new DefaultTableModel(a.getRowCount(), a.getColumnCount());
        Object[] identifiers = new Object[a.getColumnCount()];
        for (int j = 0; j < a.getColumnCount(); j++) {
            identifiers[j] = a.getColumnName(j);
        }
        b.setColumnIdentifiers(identifiers);
        for (int i = 0; i < a.getRowCount(); i++) {
            for (int j = 0; j < a.getColumnCount(); j++) {
                b.setValueAt(a.getValueAt(i, j), i, j);
            }
        }
        String[] nrow = new String[a.getColumnCount()];
        for (int j = 0; j < a.getColumnCount(); j++) {
            nrow[j] = "";
        }
        b.addRow(nrow);
        return b;
    }

    private void agregarCombosALineasFactura(JTable a) {
        JComboBox combo = new JComboBox();
        cargarCombo("descripciones", combo);
        TableColumn col = a.getColumnModel().getColumn(1);
        col.setCellEditor(new DefaultCellEditor(combo));
        combo = new JComboBox();
        cargarCombo("talles", combo);
        col = a.getColumnModel().getColumn(2);
        col.setCellEditor(new DefaultCellEditor(combo));
        combo = new JComboBox();
        cargarCombo("colores", combo);
        col = a.getColumnModel().getColumn(3);
        col.setCellEditor(new DefaultCellEditor(combo));
    }

    private void borrarContactos(JTable tabla) {
        tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {"", "", ""},
                    {"", "", ""},
                    {"", "", ""},
                    {"", "", ""}
                },
                new String[]{
                    "Nombre", "Teléfono", "Correo"
                }) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
    }

    private void cargarProveedor(String nombre, JTextField ruc, JTextField dir, JComboBox pais, JTextField tel, JTextField cor, JTable cont) {
        String[] datos = this.proveedores.cargarDatos(nombre);
        ruc.setText(datos[0]);
        dir.setText(datos[1]);
        pais.setSelectedItem(datos[2]);
        tel.setText(datos[3]);
        cor.setText(datos[4]);
        String[][] contactos = this.proveedores.cargarContactos(nombre);
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                contactos,
                new String[]{
                    "Nombre", "Telefono", "Correo"
                });
        cont.setModel(modelo);
    }

    public void calcularTotales() {
        this.jLabel106.setText("");
        TableModel foo = this.jTable3.getModel();
        int cant, prec;
        int subtotal = 0;
        for (int i = 0; i < foo.getRowCount(); i++) {
            try {
                cant = Integer.parseInt(foo.getValueAt(i, 0).toString());
                prec = Integer.parseInt(foo.getValueAt(i, 4).toString());
                subtotal += cant * prec;
                foo.setValueAt(cant * prec, i, 5);
            } catch (NumberFormatException nfe) {
            }
        }
        this.jTextField34.setText("" + subtotal);
        int iva, desc;
        try {
            iva = Integer.parseInt(this.jTextField33.getText());
            desc = Integer.parseInt(this.jTextField36.getText());
        } catch (NumberFormatException nfe) {
            this.jLabel106.setText("El iva y descuento deben ser numericos.");
            return;
        }
        this.jTextField35.setText("" + (subtotal * iva) / 100);
        this.jTextField37.setText("" + (subtotal + ((subtotal * iva) / 100) - desc));
    }

    public void cargarVerProducto(JTextField cod, JLabel err, JComboBox marca, JComboBox categoria, JTextField descripcion1, JTextField descripcion2, JTable tabla) {
        String codigo = cod.getText();
        if (!this.caracteristicas.existeElementoCaracteristica(codigo, "descripciones")) {
            err.setText("No existe el codigo del producto");
            return;
        }
        err.setText("");
        cargarProducto(codigo, marca, categoria, descripcion1, descripcion2, tabla);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ConsultarStock_Consultar = new javax.swing.JButton();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jComboBox32 = new javax.swing.JComboBox();
        jComboBox33 = new javax.swing.JComboBox();
        jComboBox34 = new javax.swing.JComboBox();
        jLabel107 = new javax.swing.JLabel();
        jTextField56 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        prototipoIngresoMasivoEImpresion1 = new presentacion.PrototipoIngresoMasivoEImpresion();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jComboBox5 = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox();
        IngresarArticulos_Ingresar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        moverStock1 = new presentacion.MoverStock();
        moverStockProducto1 = new presentacion.MoverStockProducto();
        bajarStock1 = new presentacion.BajarStock();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        CargarArticulos_Cargar = new javax.swing.JButton();
        jFileChooser1 = new javax.swing.JFileChooser();
        jLabel11 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        BajarArticulos_Bajar = new javax.swing.JButton();
        jFileChooser2 = new javax.swing.JFileChooser();
        jLabel12 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        CrearProducto_Crear = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jComboBox40 = new javax.swing.JComboBox();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jComboBox41 = new javax.swing.JComboBox();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();
        jTextField16 = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        jComboBox42 = new javax.swing.JComboBox();
        jTextField23 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jComboBox26 = new javax.swing.JComboBox();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jComboBox27 = new javax.swing.JComboBox();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable10 = new javax.swing.JTable();
        jTextField9 = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        ModificarProducto_Modificar = new javax.swing.JButton();
        jComboBox28 = new javax.swing.JComboBox();
        jTextField24 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jComboBox29 = new javax.swing.JComboBox();
        jComboBox30 = new javax.swing.JComboBox();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jComboBox31 = new javax.swing.JComboBox();
        jTextField11 = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable11 = new javax.swing.JTable();
        EliminarProducto_Eliminar = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        listadoProductos = new presentacion.ListadoProductos();
        prototipoPrecioCostos1 = new presentacion.PrototipoPrecioCostos();
        jPanel14 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jComboBox37 = new javax.swing.JComboBox();
        jTextField14 = new javax.swing.JTextField();
        AltasBajas_Crear = new javax.swing.JButton();
        AltasBajas_Eliminar = new javax.swing.JButton();
        jComboBox38 = new javax.swing.JComboBox();
        jLabel59 = new javax.swing.JLabel();
        jComboBox39 = new javax.swing.JComboBox();
        jPanel17 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jComboBox43 = new javax.swing.JComboBox();
        jComboBox44 = new javax.swing.JComboBox();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jComboBox45 = new javax.swing.JComboBox();
        jLabel70 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jLabel71 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel20 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox();
        jComboBox16 = new javax.swing.JComboBox();
        jComboBox17 = new javax.swing.JComboBox();
        jComboBox18 = new javax.swing.JComboBox();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jTextField34 = new javax.swing.JTextField();
        jTextField35 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jTextField37 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jTextField38 = new javax.swing.JTextField();
        jLabel81 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel82 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel24 = new javax.swing.JPanel();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jLabel98 = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        jTextField47 = new javax.swing.JTextField();
        jTextField48 = new javax.swing.JTextField();
        jTextField49 = new javax.swing.JTextField();
        jLabel101 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jTextField50 = new javax.swing.JTextField();
        jTextField51 = new javax.swing.JTextField();
        jTextField52 = new javax.swing.JTextField();
        jLabel103 = new javax.swing.JLabel();
        jTextField53 = new javax.swing.JTextField();
        jLabel104 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jTextField32 = new javax.swing.JTextField();
        jTextField42 = new javax.swing.JTextField();
        jTextField43 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jTextField27 = new javax.swing.JTextField();
        jTextField28 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jTextField30 = new javax.swing.JTextField();
        jComboBox11 = new javax.swing.JComboBox();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        proveedor_Alta_Crear = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        proveedores_Alta_Agregar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jTextField59 = new javax.swing.JTextField();
        jTextField60 = new javax.swing.JTextField();
        jLabel113 = new javax.swing.JLabel();
        jTextField61 = new javax.swing.JTextField();
        jTextField62 = new javax.swing.JTextField();
        jComboBox12 = new javax.swing.JComboBox();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable8 = new javax.swing.JTable();
        jComboBox14 = new javax.swing.JComboBox();
        jPanel25 = new javax.swing.JPanel();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jTextField64 = new javax.swing.JTextField();
        jTextField65 = new javax.swing.JTextField();
        jLabel120 = new javax.swing.JLabel();
        jTextField66 = new javax.swing.JTextField();
        jTextField67 = new javax.swing.JTextField();
        jComboBox22 = new javax.swing.JComboBox();
        jScrollPane13 = new javax.swing.JScrollPane();
        jTable9 = new javax.swing.JTable();
        proveedor_Alta_Crear2 = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        proveedores_Alta_Agregar2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jComboBox21 = new javax.swing.JComboBox();
        jPanel28 = new javax.swing.JPanel();
        jLabel105 = new javax.swing.JLabel();
        jComboBox20 = new javax.swing.JComboBox();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable7 = new javax.swing.JTable();
        proveedor_Facturas_verFactura = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de inventario");

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(700, 390));

        jLabel1.setText("Código de producto");

        jTextField1.setPreferredSize(new java.awt.Dimension(160, 20));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));
        jComboBox1.setPreferredSize(new java.awt.Dimension(160, 20));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jLabel2.setText("Talle");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));
        jComboBox2.setPreferredSize(new java.awt.Dimension(160, 20));

        jLabel3.setText("Color");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        jLabel4.setText("Lugar");

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", "", "", ""}
            },
            new String [] {
                "Código", "Descripción", "Precio ($)", "Talle", "Color", "Lugar", "Stock"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);

        ConsultarStock_Consultar.setText("Consultar");
        ConsultarStock_Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsultarStock_ConsultarActionPerformed(evt);
            }
        });

        jLabel51.setText("Categoria");

        jLabel52.setText("Marca");

        jLabel53.setText("Tela");

        jLabel107.setText("Precio");

        jButton5.setText("Imprimir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox4, 0, 161, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConsultarStock_Consultar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51)
                            .addComponent(jLabel52)
                            .addComponent(jLabel53)
                            .addComponent(jLabel107))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox32, 0, 160, Short.MAX_VALUE)
                            .addComponent(jComboBox33, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox34, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField56))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel51)
                    .addComponent(jComboBox32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox33, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel52)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel53)
                    .addComponent(jComboBox34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ConsultarStock_Consultar)
                    .addComponent(jLabel107)
                    .addComponent(jTextField56, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consultar stock", jPanel1);

        jTabbedPane5.addTab("Ingreso masivo", prototipoIngresoMasivoEImpresion1);

        jLabel5.setText("Código de producto");

        jTextField2.setPreferredSize(new java.awt.Dimension(160, 20));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));
        jComboBox5.setPreferredSize(new java.awt.Dimension(160, 20));
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });

        jLabel6.setText("Talle");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        jLabel7.setText("Color");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        jLabel8.setText("Lugar");

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        IngresarArticulos_Ingresar.setText("Ingresar");
        IngresarArticulos_Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarArticulos_IngresarActionPerformed(evt);
            }
        });

        jLabel9.setText("Cantidad a ingresar");

        jTextField3.setText("0");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(IngresarArticulos_Ingresar)))))
                .addContainerGap(510, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IngresarArticulos_Ingresar)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(397, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Ingresar artículos", jPanel8);
        jTabbedPane5.addTab("Mover stock", moverStock1);
        jTabbedPane5.addTab("Mover stock producto", moverStockProducto1);
        jTabbedPane5.addTab("Bajar stock", bajarStock1);

        jLabel17.setText("Ruta del archivo");

        CargarArticulos_Cargar.setText("Cargar");
        CargarArticulos_Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarArticulos_CargarActionPerformed(evt);
            }
        });

        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFileChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CargarArticulos_Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CargarArticulos_Cargar)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jFileChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Cargar archivo", jPanel3);

        jLabel18.setText("Ruta del archivo");

        BajarArticulos_Bajar.setText("Bajar");
        BajarArticulos_Bajar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BajarArticulos_BajarActionPerformed(evt);
            }
        });

        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BajarArticulos_Bajar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BajarArticulos_Bajar)))
                .addGap(7, 7, 7)
                .addComponent(jFileChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane5.addTab("Bajar archivo", jPanel4);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 955, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane5)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Actualizar stock", jPanel22);

        jLabel13.setText("Código de producto");

        jLabel14.setText("Marca");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"",  new Integer(0)},
                {"",  new Integer(0)},
                {"",  new Integer(0)},
                {"",  new Integer(0)}
            },
            new String [] {
                "Componente", "Porcentaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable4);

        jLabel15.setText("Composición");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        jLabel16.setText("Categoria");

        jLabel19.setText("Descripción");

        CrearProducto_Crear.setText("Crear");
        CrearProducto_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearProducto_CrearActionPerformed(evt);
            }
        });

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel16)
                    .addComponent(jLabel19)
                    .addComponent(jLabel15))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CrearProducto_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jComboBox10, javax.swing.GroupLayout.Alignment.LEADING, 0, 160, Short.MAX_VALUE)
                                .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox9, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CrearProducto_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(295, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Crear producto", jPanel5);

        jLabel60.setText("Código de producto");

        jComboBox40.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jLabel61.setText("Marca");

        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jComboBox41.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        jLabel63.setText("Categoria");

        jLabel64.setText("Descripción");

        jLabel65.setText("Composición");

        jTable6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"",  new Integer(0)},
                {"",  new Integer(0)},
                {"",  new Integer(0)},
                {"",  new Integer(0)}
            },
            new String [] {
                "Componente", "Porcentaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jTable6);

        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jComboBox42.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox42ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60)
                    .addComponent(jLabel61)
                    .addComponent(jLabel63)
                    .addComponent(jLabel64)
                    .addComponent(jLabel65))
                .addGap(10, 10, 10)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox40, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox42, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jComboBox41, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel62, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jComboBox40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel63)
                        .addComponent(jComboBox41, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel64)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel65)
                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(295, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Ver producto", jPanel15);

        jLabel37.setText("Código de producto");

        jComboBox26.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jLabel38.setText("Marca");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jComboBox27.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        jLabel40.setText("Categoria");

        jLabel41.setText("Descripción");

        jLabel42.setText("Composición");

        jTable10.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"",  new Integer(0)},
                {"",  new Integer(0)},
                {"",  new Integer(0)},
                {"",  new Integer(0)}
            },
            new String [] {
                "Componente", "Porcentaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable10);

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        ModificarProducto_Modificar.setText("Modificar");
        ModificarProducto_Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarProducto_ModificarActionPerformed(evt);
            }
        });

        jComboBox28.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox28ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel37)
                    .addComponent(jLabel38)
                    .addComponent(jLabel40)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42))
                .addGap(10, 10, 10)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ModificarProducto_Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(279, 279, 279))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(jComboBox26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel40)
                        .addComponent(jComboBox27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel42)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ModificarProducto_Modificar))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(295, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Modificar producto", jPanel6);

        jLabel44.setText("Código de producto");

        jComboBox29.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox29ItemStateChanged(evt);
            }
        });

        jComboBox30.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jLabel45.setText("Marca");

        jLabel46.setText("Categoria");

        jComboBox31.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        jLabel47.setText("Descripción");

        jLabel48.setText("Composición");

        jTable11.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"",  new Integer(0)},
                {"",  new Integer(0)},
                {"",  new Integer(0)},
                {"",  new Integer(0)}
            },
            new String [] {
                "Componente", "Porcentaje"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable11);

        EliminarProducto_Eliminar.setText("Eliminar");
        EliminarProducto_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminarProducto_EliminarActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44)
                    .addComponent(jLabel45)
                    .addComponent(jLabel46)
                    .addComponent(jLabel47)
                    .addComponent(jLabel48))
                .addGap(10, 10, 10)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(EliminarProducto_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jComboBox30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(113, 113, 113)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jComboBox31, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(860, 860, 860))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(jComboBox30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel46)
                        .addComponent(jComboBox31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel47)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(EliminarProducto_Eliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Eliminar producto", jPanel7);
        jTabbedPane2.addTab("Listado de productos", listadoProductos);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 955, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Productos", jPanel10);
        jTabbedPane1.addTab("Precios y Costos", prototipoPrecioCostos1);

        jLabel58.setText("Listado:");

        jComboBox37.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Colores", "Locales", "Marcas", "Categorias", "Componentes", "Monedas", "Tipo pagos", "Plazo pagos", "Paises" }));

        AltasBajas_Crear.setText("Crear");
        AltasBajas_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltasBajas_CrearActionPerformed(evt);
            }
        });

        AltasBajas_Eliminar.setText("Eliminar");
        AltasBajas_Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AltasBajas_EliminarActionPerformed(evt);
            }
        });

        jComboBox38.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Colores", "Locales", "Marcas", "Categorias", "Componentes", "Monedas", "Tipo pagos", "Plazo pagos", "Paises" }));
        jComboBox38.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox38ItemStateChanged(evt);
            }
        });

        jLabel59.setText("Listado:");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox37, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AltasBajas_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox38, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jComboBox39, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(AltasBajas_Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(469, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jComboBox37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AltasBajas_Crear))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jComboBox38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AltasBajas_Eliminar)
                    .addComponent(jComboBox39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(536, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Altas/Bajas", jPanel14);

        jLabel67.setText("Código de producto");

        jComboBox43.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox43ItemStateChanged(evt);
            }
        });

        jComboBox44.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jLabel68.setText("Talle");

        jLabel69.setText("Color");

        jComboBox45.setModel(new javax.swing.DefaultComboBoxModel(new String[] {  }));

        jLabel70.setText("Cantidad");

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Etiquetas con precio");

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68)
                            .addComponent(jLabel69)
                            .addComponent(jLabel70))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox45, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox44, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                                .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox43, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTextField18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1))))
                    .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(535, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel67)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel68)
                    .addComponent(jComboBox44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel69)
                    .addComponent(jComboBox45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel70)
                    .addComponent(jTextField18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(442, 442, 442))
        );

        jTabbedPane1.addTab("Etiquetas", jPanel17);

        jLabel31.setText("Proveedor");

        jLabel32.setText("Nro de factura");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                { new Integer(0), "", "", "",  new Integer(0),  new Integer(0),  new Boolean(true)},
                { new Integer(0), "", "", "",  new Integer(0),  new Integer(0),  new Boolean(true)},
                { new Integer(0), "", "", "",  new Integer(0),  new Integer(0),  new Boolean(true)},
                { new Integer(0), "", "", "",  new Integer(0),  new Integer(0),  new Boolean(true)}
            },
            new String [] {
                "Cantidad", "Producto", "Talle", "Color", "Costo", "Sub total", "Eiquetas c/precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable3KeyReleased(evt);
            }
        });
        jScrollPane7.setViewportView(jTable3);

        jLabel33.setText("Fecha");

        jLabel34.setText("Tipo de pago");

        jLabel76.setText("Plazo de pago");

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "" }));

        jLabel77.setText("Sub total");

        jLabel78.setText("Iva");

        jTextField33.setText("22");
        jTextField33.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField33KeyReleased(evt);
            }
        });

        jLabel79.setText("Descuento");

        jLabel80.setText("Total");

        jTextField36.setText("0");
        jTextField36.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField36KeyReleased(evt);
            }
        });

        jButton3.setText("Agregar linea");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel81.setText("Moneda");

        jButton4.setText("Ingresar factura");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel82.setText("%");

        jButton6.setText("Borrar lineas");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jCheckBox2.setSelected(true);
        jCheckBox2.setText("Actualiza stock");

        jCheckBox3.setSelected(true);
        jCheckBox3.setText("Imprime etiquetas");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel77)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel80)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel78)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel79))
                                .addGap(6, 6, Short.MAX_VALUE)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField36, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel82)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32)
                            .addComponent(jLabel33)
                            .addComponent(jLabel81))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel76)
                                    .addComponent(jLabel34))
                                .addGap(64, 64, 64)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox16, 0, 120, Short.MAX_VALUE)
                                    .addComponent(jTextField39))
                                .addGap(161, 161, 161)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jCheckBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton3))
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jCheckBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34)
                    .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel76)
                    .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel81)
                        .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3))
                    .addComponent(jCheckBox3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel77)
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel78)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel82))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel79)
                    .addComponent(jTextField36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel80)
                    .addComponent(jTextField37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jLabel106, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Ingresar factura", jPanel20);

        jLabel94.setText("Proveedor");

        jLabel95.setText("Nro de factura");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Cantidad", "Producto", "Talle", "Color", "Precio", "Sub total"
            }
        ));
        jScrollPane9.setViewportView(jTable5);

        jLabel96.setText("Fecha");

        jLabel97.setText("Tipo de pago");

        jLabel98.setText("Plazo de pago");

        jLabel99.setText("Sub total");

        jLabel100.setText("Iva");

        jTextField47.setText("22");

        jLabel101.setText("Descuento");

        jLabel102.setText("Total");

        jLabel103.setText("Moneda");

        jLabel104.setText("%");

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel99)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addComponent(jLabel102)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel24Layout.createSequentialGroup()
                                    .addComponent(jLabel100)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel101))
                            .addGap(6, 6, Short.MAX_VALUE)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextField50, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                    .addComponent(jLabel104)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel24Layout.createSequentialGroup()
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel94)
                                .addComponent(jLabel95)
                                .addComponent(jLabel96)
                                .addComponent(jLabel103))
                            .addGap(37, 37, 37)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel24Layout.createSequentialGroup()
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField52, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(jTextField31))
                                    .addGap(30, 30, 30)
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel98)
                                        .addComponent(jLabel97))
                                    .addGap(64, 64, 64)
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField42, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                        .addComponent(jTextField43)))
                                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField32, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField53, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE))))
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(280, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel94)
                    .addComponent(jLabel97)
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField42, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel95)
                    .addComponent(jTextField52, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel98)
                    .addComponent(jTextField43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel96)
                    .addComponent(jTextField53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel103)
                    .addComponent(jTextField32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel99)
                    .addComponent(jTextField48, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel100)
                    .addComponent(jTextField47, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField49, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel104))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel101)
                    .addComponent(jTextField50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel102)
                    .addComponent(jTextField51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Ver factura", jPanel24);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane3)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Compras", jPanel19);

        jLabel20.setText("Nombre");

        jLabel21.setText("R.U.C.");

        jLabel22.setText("Dirección");

        jLabel23.setText("País");

        jLabel24.setText("Teléfono");

        jLabel25.setText("Correo");

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
            },
            new String [] {
                "Nombre", "Teléfono", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(jTable2);

        proveedor_Alta_Crear.setText("Crear");
        proveedor_Alta_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedor_Alta_CrearActionPerformed(evt);
            }
        });

        proveedores_Alta_Agregar.setText("Agregar linea");
        proveedores_Alta_Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedores_Alta_AgregarActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar contactos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel22)
                            .addComponent(jLabel24))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField29, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jTextField28, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jTextField26))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23)
                            .addComponent(jLabel25))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField27, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jTextField30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(proveedores_Alta_Agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(proveedor_Alta_Crear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jTextField28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(jComboBox11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(jTextField30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proveedores_Alta_Agregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proveedor_Alta_Crear)
                    .addComponent(jButton2))
                .addContainerGap(249, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Alta", jPanel21);

        jLabel108.setText("Nombre");

        jLabel109.setText("R.U.C.");

        jLabel110.setText("Dirección");

        jLabel111.setText("País");

        jLabel112.setText("Teléfono");

        jLabel113.setText("Correo");

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jTable8.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
            },
            new String [] {
                "Nombre", "Teléfono", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane12.setViewportView(jTable8);

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        jComboBox14.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox14ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel108)
                            .addComponent(jLabel110)
                            .addComponent(jLabel112))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField61, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jTextField60, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jComboBox14, javax.swing.GroupLayout.Alignment.TRAILING, 0, 120, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel109)
                            .addComponent(jLabel111)
                            .addComponent(jLabel113))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox12, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField59, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jTextField62)))
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel108)
                        .addComponent(jLabel109)
                        .addComponent(jTextField59))
                    .addComponent(jComboBox14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel110)
                    .addComponent(jTextField60, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel111)
                    .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel112)
                    .addComponent(jTextField61, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel113)
                    .addComponent(jTextField62, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(293, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Consulta", jPanel23);

        jLabel115.setText("Nombre");

        jLabel116.setText("R.U.C.");

        jLabel117.setText("Dirección");

        jLabel118.setText("País");

        jLabel119.setText("Teléfono");

        jLabel120.setText("Correo");

        jComboBox22.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));

        jTable9.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
            },
            new String [] {
                "Nombre", "Teléfono", "Correo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane13.setViewportView(jTable9);

        proveedor_Alta_Crear2.setText("Modificar");
        proveedor_Alta_Crear2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedor_ModificarActionPerformed(evt);
            }
        });

        proveedores_Alta_Agregar2.setText("Agregar linea");
        proveedores_Alta_Agregar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedores_Alta_Agregar2ActionPerformed(evt);
            }
        });

        jButton8.setText("Borrar contactos");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jComboBox21.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        jComboBox21.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox21ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel115)
                            .addComponent(jLabel117)
                            .addComponent(jLabel119))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField66, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jTextField65, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jComboBox21, 0, 120, Short.MAX_VALUE))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel116)
                            .addComponent(jLabel118)
                            .addComponent(jLabel120))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jComboBox22, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField64, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jTextField67))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(proveedores_Alta_Agregar2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(proveedor_Alta_Crear2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(340, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel115)
                    .addComponent(jLabel116)
                    .addComponent(jTextField64, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel117)
                    .addComponent(jTextField65, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel118)
                    .addComponent(jComboBox22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel119)
                    .addComponent(jTextField66, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel120)
                    .addComponent(jTextField67, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proveedores_Alta_Agregar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel121, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proveedor_Alta_Crear2)
                    .addComponent(jButton8))
                .addContainerGap(249, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Modificar", jPanel25);

        jLabel105.setText("Nombre");

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel(new String[] { }));
        jComboBox20.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox20ItemStateChanged(evt);
            }
        });

        jTable7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "#", "Fecha", "Nro factura", "Total S/IVA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane11.setViewportView(jTable7);

        proveedor_Facturas_verFactura.setText("Ver factura");
        proveedor_Facturas_verFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proveedor_Facturas_verFacturaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel28Layout.createSequentialGroup()
                        .addComponent(jLabel105)
                        .addGap(35, 35, 35)
                        .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(proveedor_Facturas_verFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(390, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel105)
                    .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(proveedor_Facturas_verFactura))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane4.addTab("Facturas del proveedor", jPanel28);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane4)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Proveedores", jPanel18);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConsultarStock_ConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsultarStock_ConsultarActionPerformed
        DefaultTableModel modelo = new javax.swing.table.DefaultTableModel(
                this.articulos.consultar(this.jTextField1.getText(),
                this.jComboBox2.getSelectedItem().toString(),
                this.jComboBox3.getSelectedItem().toString(),
                this.jComboBox4.getSelectedItem().toString(),
                this.jComboBox32.getSelectedItem().toString(),
                this.jComboBox33.getSelectedItem().toString(),
                this.jComboBox34.getSelectedItem().toString(),
                this.jTextField56.getText()),
                new String[]{
                    "Código", "Descripción", "Precio ($)", "Talle", "Color", "Lugar", "Stock"
                }) {
            Class[] types = new Class[]{
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        this.jTable1.setModel(modelo);
        TableRowSorter rs = new TableRowSorter<DefaultTableModel>(modelo);
        Comparator comparador_asterisco = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals("*")) {
                    return Integer.MAX_VALUE;
                }
                if (o2.equals("*")) {
                    return Integer.MIN_VALUE;
                }
                return o1.compareTo(o2);
            }
        };
        Comparator comparador_numerico = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.equals("*")) {
                    return Integer.MAX_VALUE;
                }
                if (o2.equals("*")) {
                    return Integer.MIN_VALUE;
                }
                int io1 = ((o1.equals("")) ? 0 : Integer.parseInt(o1));
                int io2 = ((o2.equals("")) ? 0 : Integer.parseInt(o2));
                return io1 - io2;
            }
        };
        rs.setComparator(0, comparador_asterisco);
        rs.setComparator(1, comparador_asterisco);
        rs.setComparator(2, comparador_numerico);
        rs.setComparator(3, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                List<String> l = caracteristicas.getCaracteristica("talles");
                if (o1.equals("*")) {
                    return Integer.MAX_VALUE;
                }
                if (o2.equals("*")) {
                    return Integer.MIN_VALUE;
                }
                int io1 = l.indexOf(o1);
                int io2 = l.indexOf(o2);
                return io1 - io2;
            }
        });
        rs.setComparator(4, comparador_asterisco);
        rs.setComparator(5, comparador_asterisco);
        rs.setComparator(6, comparador_numerico);
        this.jTable1.setRowSorter(rs);
        this.jTable1.getRowSorter().toggleSortOrder(3);
        this.jTable1.getRowSorter().toggleSortOrder(0);
        this.jTable1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        for (int i = 0; i < modelo.getColumnCount(); i++) {
            TableColumn column = this.jTable1.getColumnModel().getColumn(i);
            column.setPreferredWidth(95);
        }
        this.jTable1.getColumnModel().getColumn(1).setPreferredWidth(348);

        // Modificacion para que aparesca una linea negra entre cuando
        // se cambia a otro producto en la tabla de la consulta de stock
        this.jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JTextField foo = new JTextField(value.toString());
                int rows = table.getRowCount();
                if (row < rows - 1) {
                    String sig = table.getValueAt(row + 1, columna_orden).toString();
                    String valor = table.getValueAt(row, columna_orden).toString();
                    if (!sig.equals(valor)) {
                        foo.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.red));
                    } else {
                        foo.setBorder(BorderFactory.createEmptyBorder());
                    }
                } else {
                    foo.setBorder(BorderFactory.createEmptyBorder());
                }
                return foo;
            }
        });
    }//GEN-LAST:event_ConsultarStock_ConsultarActionPerformed

    private void IngresarArticulos_IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarArticulos_IngresarActionPerformed
        String codigo = this.jTextField2.getText();
        String talle = this.jComboBox6.getSelectedItem().toString();
        String color = this.jComboBox7.getSelectedItem().toString();
        String lugar = this.jComboBox8.getSelectedItem().toString();
        if (codigo.equals("")
                || !this.caracteristicas.existeElementoCaracteristica(codigo, "descripciones")) {
            this.jLabel10.setText("El código de producto es invalido");
            return;
        }
        try {
            Integer.parseInt(this.jTextField3.getText());
        } catch (NumberFormatException nfe) {
            this.jLabel10.setText("La cantidad de articulos tiene que ser un número");
            return;
        }
        if (talle.equals("")) {
            this.jLabel10.setText("Debe seleccionar el talle");
            return;
        }
        if (color.equals("")) {
            this.jLabel10.setText("Debe seleccionar el color");
            return;
        }
        if (lugar.equals("")) {
            this.jLabel10.setText("Debe seleccionar el lugar");
            return;
        }
        int cantidad = Integer.parseInt(this.jTextField3.getText());
        boolean resultado = this.articulos.actualizarStock(codigo,
                talle, color, lugar, cantidad);
        if (!resultado) {
            this.jLabel10.setText("No se pudo realizar la actualización");
            return;
        }
        this.jLabel10.setText("Se actualizó el stock");
        this.jTextField3.setText("0");
    }//GEN-LAST:event_IngresarArticulos_IngresarActionPerformed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        this.jTextField1.setText(this.jComboBox1.getSelectedItem().toString());
        ConsultarStock_ConsultarActionPerformed(null);
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        this.jTextField2.setText(this.jComboBox5.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void CargarArticulos_CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarArticulos_CargarActionPerformed
        if (!this.jTextField6.getText().equals("")) {
            if (this.articulos.cargar(this.jTextField6.getText(), true)) {
                this.jLabel11.setText("Se cargaron correctamente los articulos");
                this.jLabel6.setText("");
            } else {
                this.jLabel11.setText("Ocurrió un problema, verifique el archivo");
            }
        } else {
            this.jLabel11.setText("Debe ingresar un archivo");
        }
    }//GEN-LAST:event_CargarArticulos_CargarActionPerformed

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        if (evt.getActionCommand().equals("ApproveSelection")) {
            this.jTextField6.setText(this.jFileChooser1.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_jFileChooser1ActionPerformed

    private void BajarArticulos_BajarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BajarArticulos_BajarActionPerformed
        if (!this.jTextField7.getText().equals("")) {
            if (this.articulos.cargar(this.jTextField7.getText(), false)) {
                this.jLabel12.setText("Se bajaron correctamente los articulos");
                this.jLabel7.setText("");
            } else {
                this.jLabel12.setText("Ocurrió un problema, verifique el archivo");
            }
        } else {
            this.jLabel12.setText("Debe ingresar un archivo");
        }
    }//GEN-LAST:event_BajarArticulos_BajarActionPerformed

    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed
        if (evt.getActionCommand().equals("ApproveSelection")) {
            this.jTextField7.setText(this.jFileChooser2.getSelectedFile().getAbsolutePath());
        }
    }//GEN-LAST:event_jFileChooser2ActionPerformed

    private void CrearProducto_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearProducto_CrearActionPerformed
        this.jLabel36.setText("");
        String codigo = this.jTextField4.getText();
        if (codigo.equals("")) {
            this.jLabel36.setText("No ingreso el codigo del producto");
            return;
        }
        // Modificación para código de barras
        if (codigo.length() != 5) {
            this.jLabel36.setText("El codigo del producto es invalido");
            return;
        }
        if (this.caracteristicas.existeElementoCaracteristica(codigo, "descripciones")) {
            this.jLabel36.setText("Ya existe el codigo del producto");
            return;
        }
        String marca = this.jComboBox9.getSelectedItem().toString();
        if (marca.equals("")) {
            this.jLabel36.setText("No ingreso la marca");
            return;
        }
        String categoria = this.jComboBox10.getSelectedItem().toString();
        if (categoria.equals("")) {
            this.jLabel36.setText("No ingreso la categoria");
            return;
        }
        TableModel modelo = this.jTable4.getModel();
        Hashtable<String, String> componentes = new Hashtable<String, String>();
        Integer porc;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            porc = (Integer) modelo.getValueAt(i, 1);
            if (porc > 0) {
                componentes.put(modelo.getValueAt(i, 0).toString(), modelo.getValueAt(i, 1).toString());
            } else {
                this.jLabel35.setText("Los porcentajes \nno son positivos");
                return;
            }
        }
        // Modificación para etiquetas
        String descripcion1 = this.jTextField5.getText();
        if (descripcion1.length() > 30) {
            this.jLabel36.setText("La descripción1 es demasiado larga");
            return;
        }
        String descripcion2 = this.jTextField22.getText();
        if (descripcion2.length() > 30) {
            this.jLabel36.setText("La descripción2 es demasiado larga");
            return;
        }
        if (descripcion1.length() != 0) {
            while (descripcion1.length() < 30) {
                descripcion1 += " ";
            }
        }
        if (descripcion2.length() != 0) {
            while (descripcion2.length() < 30) {
                descripcion2 += " ";
            }
        }
        String descripcion = descripcion1 + descripcion2;
        if (this.productos.crear(codigo, marca, categoria, descripcion, componentes)) {
            this.jLabel35.setText("");
            this.jLabel36.setText("Se creó el producto");
            cargarPantallas(false);
        } else {
            this.jLabel35.setText("");
            this.jLabel36.setText("Ocurrió un problema, intentelo nuevamente");
        }
    }//GEN-LAST:event_CrearProducto_CrearActionPerformed

    private void ModificarProducto_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarProducto_ModificarActionPerformed
        String codigo = this.jTextField8.getText();
        if (!this.caracteristicas.existeElementoCaracteristica(codigo, "descripciones")) {
            this.jLabel39.setText("Esta ingresando un codigo incorrecto");
            return;
        }
        String marca = this.jComboBox26.getSelectedItem().toString();
        if (marca.equals("")) {
            this.jLabel39.setText("No ingreso la marca");
            return;
        }
        String categoria = this.jComboBox27.getSelectedItem().toString();
        if (categoria.equals("")) {
            this.jLabel39.setText("No ingreso la categoria");
            return;
        }
        TableModel modelo = this.jTable10.getModel();
        Hashtable<String, String> componentes = new Hashtable<String, String>();
        Integer porc;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            porc = (Integer) modelo.getValueAt(i, 1);
            if (porc > 0) {
                componentes.put(modelo.getValueAt(i, 0).toString(), modelo.getValueAt(i, 1).toString());
            } else {
                this.jLabel35.setText("Los porcentajes \nno son positivos");
                return;
            }
        }
        // Modificación para etiquetas
        String descripcion1 = this.jTextField9.getText();
        if (descripcion1.length() > 30) {
            this.jLabel39.setText("La descripción1 es demasiado larga");
            return;
        }
        String descripcion2 = this.jTextField24.getText();
        if (descripcion2.length() > 30) {
            this.jLabel39.setText("La descripción2 es demasiado larga");
            return;
        }
        if (descripcion1.length() != 0) {
            while (descripcion1.length() < 30) {
                descripcion1 += " ";
            }
        }
        if (descripcion2.length() != 0) {
            while (descripcion2.length() < 30) {
                descripcion2 += " ";
            }
        }
        String descripcion = descripcion1 + descripcion2;
        if (this.productos.modificar(codigo, marca, categoria, descripcion, componentes)) {
            this.jLabel39.setText("Se modificó el producto");
            this.jLabel43.setText("");
        } else {
            this.jLabel39.setText("Ocurrió un problema, intentelo nuevamente");
            this.jLabel43.setText("");
        }
    }//GEN-LAST:event_ModificarProducto_ModificarActionPerformed

    private void jComboBox28ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox28ItemStateChanged
        this.jTextField8.setText(this.jComboBox28.getSelectedItem().toString());
        cargarVerProducto(this.jTextField8, this.jLabel39, this.jComboBox26, this.jComboBox27, this.jTextField9, this.jTextField24, this.jTable10);
    }//GEN-LAST:event_jComboBox28ItemStateChanged

    private void jComboBox29ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox29ItemStateChanged
        this.jTextField10.setText(this.jComboBox29.getSelectedItem().toString());
        cargarVerProducto(this.jTextField10, this.jLabel49, this.jComboBox30, this.jComboBox31, this.jTextField11, this.jTextField25, this.jTable11);
        this.jLabel50.setText("");
        this.jLabel49.setText("");
    }//GEN-LAST:event_jComboBox29ItemStateChanged

    private void EliminarProducto_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminarProducto_EliminarActionPerformed
        String codigo = this.jTextField10.getText();
        if (!this.caracteristicas.existeElementoCaracteristica(codigo, "descripciones")) {
            this.jLabel49.setText("Esta ingresando un codigo incorrecto");
            return;
        }
        int resp = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de querer eliminar el producto?\nSe eliminara toda información relacionada al mismo", "Confirmar eliminación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == JOptionPane.YES_OPTION) {
            if (this.productos.eliminar(codigo)) {
                this.jLabel50.setText("Se eliminó el producto");
                this.jLabel49.setText("");
                cargarPantallas(false);
            } else {
                this.jLabel50.setText("Ocurrió un problema, intentelo nuevamente");
                this.jLabel49.setText("");
            }
        }
    }//GEN-LAST:event_EliminarProducto_EliminarActionPerformed

    private void jComboBox42ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox42ItemStateChanged
        this.jTextField15.setText(this.jComboBox42.getSelectedItem().toString());
        cargarVerProducto(this.jTextField15, this.jLabel62, this.jComboBox40, this.jComboBox41, this.jTextField16, this.jTextField23, this.jTable6);
    }//GEN-LAST:event_jComboBox42ItemStateChanged

    private void AltasBajas_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltasBajas_CrearActionPerformed
        String tabla = this.jComboBox37.getSelectedItem().toString().toLowerCase();
        String elemento = this.jTextField14.getText();

        // Modificación para etiquetas
        if (tabla.equals("colores") && elemento.length() > 5) {
            JOptionPane.showConfirmDialog(null, "No se pueden crear colores con más de 5 letras", "Atención", JOptionPane.CLOSED_OPTION, JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Modificación para modulo de compras
        if (tabla.equals("tipo pagos") || tabla.equals("plazo pagos")) {
            tabla = tabla.replaceAll(" ", "_");
        }

        boolean res = this.caracteristicas.crear(tabla, elemento);
        if (res) {
            cargarPantallas(false);
        }
    }//GEN-LAST:event_AltasBajas_CrearActionPerformed

    private void jComboBox38ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox38ItemStateChanged
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        String caracteristica = jComboBox38.getSelectedItem().toString().toLowerCase();

        // Modificación para modulo de compras
        if (caracteristica.equals("tipo pagos") || caracteristica.equals("plazo pagos")) {
            caracteristica = caracteristica.replaceAll(" ", "_");
        }

        List<String> l = this.caracteristicas.getCaracteristica(caracteristica);
        for (String m : l) {
            model.addElement(m);
        }
        this.jComboBox39.setModel(model);
    }//GEN-LAST:event_jComboBox38ItemStateChanged

    private void AltasBajas_EliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AltasBajas_EliminarActionPerformed
        String tabla = this.jComboBox38.getSelectedItem().toString().toLowerCase();
        String elemento = this.jComboBox39.getSelectedItem().toString();

        // Modificación para modulo de compras
        if (tabla.equals("tipo pagos") || tabla.equals("plazo pagos")) {
            tabla = tabla.replaceAll(" ", "_");
        }

        boolean res = this.caracteristicas.eliminar(tabla, elemento);
        if (res) {
            cargarPantallas(false);
        }
    }//GEN-LAST:event_AltasBajas_EliminarActionPerformed

    private void jComboBox43ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox43ItemStateChanged
        this.jTextField17.setText(this.jComboBox43.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox43ItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DefaultTableModel a = (DefaultTableModel) this.jTable3.getModel();
        a.addRow(new Object[]{new Integer(0), "", "", "", new Integer(0), new Integer(0), new Boolean(true)});
    }//GEN-LAST:event_jButton3ActionPerformed

    private void proveedor_Alta_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedor_Alta_CrearActionPerformed
        this.jLabel26.setText("");
        String nombre = this.jTextField26.getText();
        if (nombre.equals("")) {
            this.jLabel26.setText("Debe ingresar el nombre del proveedor.");
            return;
        }
        String ruc = this.jTextField27.getText();
        String dir = this.jTextField28.getText();
        String pais = this.jComboBox11.getSelectedItem().toString();
        String tel = this.jTextField29.getText();
        String correo = this.jTextField30.getText();

        TableModel foo = this.jTable2.getModel();
        ArrayList<String[]> con = new ArrayList<String[]>();
        String n, t, c;
        for (int i = 0; i < foo.getRowCount(); i++) {
            n = foo.getValueAt(i, 0).toString();
            t = foo.getValueAt(i, 1).toString();
            c = foo.getValueAt(i, 2).toString();
            if (!(n.equals("") && t.equals("") && c.equals(""))) {
                con.add(new String[]{n, t, c});
            }
        }

        boolean res = this.proveedores.crear(nombre, ruc, dir, pais, tel, correo, con);
        if (res) {
            this.jLabel26.setText("Se creó correctamente el proveedor.");
            cargarPantallas(false);
        } else {
            this.jLabel26.setText("Ocurrió un problema.");
        }
    }//GEN-LAST:event_proveedor_Alta_CrearActionPerformed

    private void proveedores_Alta_AgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedores_Alta_AgregarActionPerformed
        DefaultTableModel a = (DefaultTableModel) this.jTable2.getModel();
        a.addRow(new Object[]{"", "", ""});
        this.jLabel26.setText("");
    }//GEN-LAST:event_proveedores_Alta_AgregarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        borrarContactos(this.jTable2);
        this.jLabel26.setText("");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {new Integer(0), "", "", "", new Integer(0), new Integer(0), new Boolean(true)},
                    {new Integer(0), "", "", "", new Integer(0), new Integer(0), new Boolean(true)},
                    {new Integer(0), "", "", "", new Integer(0), new Integer(0), new Boolean(true)},
                    {new Integer(0), "", "", "", new Integer(0), new Integer(0), new Boolean(true)}
                },
                new String[]{
                    "Cantidad", "Producto", "Talle", "Color", "Costo", "Sub total", "Eiquetas c/precio"
                }) {
            Class[] types = new Class[]{
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        });
        agregarCombosALineasFactura(this.jTable3);
        this.jLabel106.setText("");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.jLabel106.setText("");
        String prov = this.jComboBox15.getSelectedItem().toString(),
                fac = this.jTextField38.getText(),
                fecha = this.jTextField39.getText(),
                mon = this.jComboBox16.getSelectedItem().toString(),
                tipop = this.jComboBox17.getSelectedItem().toString(),
                plazop = this.jComboBox18.getSelectedItem().toString();
        if (prov.equals("")) {
            this.jLabel106.setText("Debe ingresar el proveedor");
            return;
        }
        if (fecha.equals("")) {
            this.jLabel106.setText("Debe ingresar la fecha");
            return;
        }
        int iva, desc, total_s_iva;
        try {
            iva = Integer.parseInt(this.jTextField33.getText());
            desc = Integer.parseInt(this.jTextField36.getText());
            total_s_iva = Integer.parseInt(this.jTextField37.getText()) - Integer.parseInt(this.jTextField35.getText());
        } catch (NumberFormatException nfe) {
            this.jLabel106.setText("El iva y descuento deben ser numericos.");
            return;
        }
        TableModel foo = this.jTable3.getModel();
        ArrayList<String[]> lineas = new ArrayList<String[]>();
        String cant, p, t, c, prec, c_precio;
        for (int i = 0; i < foo.getRowCount(); i++) {
            cant = foo.getValueAt(i, 0).toString();
            p = foo.getValueAt(i, 1).toString();
            t = foo.getValueAt(i, 2).toString();
            c = foo.getValueAt(i, 3).toString();
            prec = foo.getValueAt(i, 4).toString();
            c_precio = foo.getValueAt(i, 6).toString();
            if (!cant.equals("0") && !p.equals("") && !t.equals("") && !c.equals("") && !prec.equals("0")) {
                lineas.add(new String[]{cant, p, t, c, prec, c_precio});
            } else {
                if (!(cant.equals("0") && p.equals("") && t.equals("") && c.equals("") && prec.equals("0"))) {
                    this.jLabel106.setText("La linea " + (i + 1) + " tiene campos en blanco.");
                    return;
                }
            }
        }
        boolean imprimir = this.jCheckBox3.isSelected();
        if (imprimir) {
            String l = "";
            try {
                Properties props = new Properties();
                props.load(new FileInputStream("C:\\Sistema de RossiSport\\params.ini"));
                l = props.getProperty("local");
            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "Ocurrió un problema", "Error al leer la configuración", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                return;
            }
            for (String[] linea : lineas) {
                p = linea[1];
                t = linea[2];
                String precio = this.precios.cargar(p, t);
                if (precio.equals("")) {
                    JOptionPane.showConfirmDialog(null, "Debe ingresar los precios antes de imprimir", "Ocurrió un problema", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            for (String[] linea : lineas) {
                cant = linea[0];
                p = linea[1];
                t = linea[2];
                c = linea[3];
                c_precio = linea[5];
                String descripcion = this.productos.cargarDatos(p).get("descripcion");
                Boolean c_p = Boolean.valueOf(c_precio);
                String precio = this.precios.cargar(p, t);
                if (!ControladorEtiquetas.imprimir(null, p, descripcion, precio, t, c, (Integer.parseInt(cant) + 1) / 2, c_p, false)) {
                    JOptionPane.showConfirmDialog(null, "Ocurrió un problema", "Error al imprimir", JOptionPane.CLOSED_OPTION, JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        boolean actualizar_stock = this.jCheckBox2.isSelected();
        boolean res = this.facturas.crear(prov, fac, fecha, mon, tipop, plazop, iva, desc, total_s_iva, lineas, actualizar_stock);
        if (res) {
            this.jLabel106.setText("Factura ingresada correctamente.");

        } else {
            this.jLabel106.setText("Ocurrió un problema al ingresar la factura.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox20ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox20ItemStateChanged
        if (ItemEvent.DESELECTED == evt.getStateChange()) {
            return;
        }
        String prov = this.jComboBox20.getSelectedItem().toString();
        ArrayList<String[]> facturas = this.facturas.cargarFacturas(prov);
        String[][] lineas = new String[facturas.size()][this.jTable7.getModel().getColumnCount()];
        for (int i = 0; i < facturas.size(); i++) {
            lineas[i] = facturas.get(i);
        }
        DefaultTableModel modelo = (DefaultTableModel) this.jTable7.getModel();
        modelo.setDataVector(lineas, new String[]{"#", "Fecha", "Nro factura", "Total S/IVA"});

        TableColumn column = this.jTable7.getColumnModel().getColumn(0);
        column.setMaxWidth(25);
    }//GEN-LAST:event_jComboBox20ItemStateChanged

    private void proveedor_Facturas_verFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedor_Facturas_verFacturaActionPerformed
        int fila = this.jTable7.getSelectedRow();
        int nfactura = Integer.parseInt(this.jTable7.getModel().getValueAt(fila, 0).toString());

        String[] datos = this.facturas.cargarFactura(nfactura);
        this.jTextField31.setText(datos[0]);
        this.jTextField52.setText(datos[1]);
        this.jTextField53.setText(datos[2]);
        this.jTextField32.setText(datos[3]);
        this.jTextField42.setText(datos[4]);
        this.jTextField43.setText(datos[5]);
        this.jTextField47.setText(datos[6]);
        this.jTextField50.setText(datos[7]);

        ArrayList<String[]> prods = this.facturas.cargarFacturaLineas(nfactura);
        String[][] lineas = new String[prods.size()][6];
        int subtotal = 0;
        for (int i = 0; i < prods.size(); i++) {
            System.arraycopy(prods.get(i), 0, lineas[i], 0, 5);
            lineas[i][5] = "" + (Integer.parseInt(lineas[i][0]) * Integer.parseInt(lineas[i][4]));
            subtotal += Integer.parseInt(lineas[i][5]);
        }
        DefaultTableModel modelo = new DefaultTableModel(lineas, new String[]{"Cantidad", "Producto", "Talle", "Color", "Precio", "Sub total"});
        this.jTable5.setModel(modelo);

        this.jTextField48.setText("" + subtotal);
        this.jTextField49.setText("" + (subtotal * Integer.parseInt(datos[6])) / 100);
        this.jTextField51.setText("" + (subtotal + (subtotal * Integer.parseInt(datos[6])) / 100 - Integer.parseInt(datos[7])));

        this.jTabbedPane3.setSelectedIndex(1);
        this.jTabbedPane1.setSelectedIndex(6);


    }//GEN-LAST:event_proveedor_Facturas_verFacturaActionPerformed

    private void jTextField36KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField36KeyReleased
        calcularTotales();
    }//GEN-LAST:event_jTextField36KeyReleased

    private void jTextField33KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField33KeyReleased
        calcularTotales();
    }//GEN-LAST:event_jTextField33KeyReleased

    private void jTable3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable3KeyReleased
        calcularTotales();
    }//GEN-LAST:event_jTable3KeyReleased

    private void jComboBox14ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox14ItemStateChanged
        String nombre = this.jComboBox14.getSelectedItem().toString();
        if (nombre.equals("")) {
            return;
        }
        cargarProveedor(nombre, this.jTextField59, this.jTextField60, this.jComboBox12, this.jTextField61, this.jTextField62, this.jTable8);
    }//GEN-LAST:event_jComboBox14ItemStateChanged

    private void proveedor_ModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedor_ModificarActionPerformed
        String nombre = this.jComboBox21.getSelectedItem().toString();
        if (nombre.equals("")) {
            this.jLabel121.setText("Debe ingresar el nombre del proveedor.");
            return;
        }
        String ruc = this.jTextField64.getText();
        String dir = this.jTextField65.getText();
        String pais = this.jComboBox22.getSelectedItem().toString();
        String tel = this.jTextField66.getText();
        String correo = this.jTextField67.getText();

        TableModel foo = this.jTable9.getModel();
        ArrayList<String[]> con = new ArrayList<String[]>();
        String n, t, c;
        for (int i = 0; i < foo.getRowCount(); i++) {
            n = foo.getValueAt(i, 0).toString();
            t = foo.getValueAt(i, 1).toString();
            c = foo.getValueAt(i, 2).toString();
            if (!(n.equals("") && t.equals("") && c.equals(""))) {
                con.add(new String[]{n, t, c});
            }
        }

        boolean res = this.proveedores.modificar(nombre, ruc, dir, pais, tel, correo, con);
        if (res) {
            this.jLabel121.setText("Se modifico correctamente el proveedor.");
            cargarPantallas(false);
        } else {
            this.jLabel121.setText("Ocurrió un problema.");
        }
    }//GEN-LAST:event_proveedor_ModificarActionPerformed

    private void proveedores_Alta_Agregar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proveedores_Alta_Agregar2ActionPerformed
        DefaultTableModel a = (DefaultTableModel) this.jTable9.getModel();
        a.addRow(new Object[]{"", "", ""});
        this.jLabel121.setText("");
    }//GEN-LAST:event_proveedores_Alta_Agregar2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        borrarContactos(this.jTable9);
        this.jLabel121.setText("");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jComboBox21ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox21ItemStateChanged
        String nombre = this.jComboBox21.getSelectedItem().toString();
        if (nombre.equals("")) {
            return;
        }
        cargarProveedor(nombre, this.jTextField64, this.jTextField65, this.jComboBox22, this.jTextField66, this.jTextField67, this.jTable9);
    }//GEN-LAST:event_jComboBox21ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jLabel71.setText("");
        String codigo = this.jTextField17.getText();
        if (!this.caracteristicas.existeElementoCaracteristica(codigo, "descripciones")) {
            this.jLabel71.setText("No existe el codigo del producto");
            return;
        }
        String talle = this.jComboBox44.getSelectedItem().toString();
        if (talle.equals("")) {
            this.jLabel71.setText("No ingreso el talle");
            return;
        }
        String color = this.jComboBox45.getSelectedItem().toString();
        if (color.equals("")) {
            this.jLabel71.setText("No ingreso el color");
            return;
        }
        String precio = this.precios.cargar(codigo, talle);
        if (precio.equals("")) {
            this.jLabel71.setText("El producto y talle no tienen precio");
            return;
        }
        int cantidad;
        try {
            cantidad = Integer.parseInt(this.jTextField18.getText());
        } catch (NumberFormatException nfe) {
            this.jLabel71.setText("La cantidad debe ser un número");
            return;
        }
        String descripcion = this.productos.cargarDatos(codigo).get("descripcion");

        // M9 INICIO
        boolean con_precio = this.jCheckBox1.isSelected();
        // M9 FIN
        // Se agrega false al parametro append para que no agregue el contenido al archivo
        if (ControladorEtiquetas.imprimir(null, codigo, descripcion, precio, talle, color, cantidad, con_precio, false)) {
            this.jLabel71.setText("El archivo fue creado correctamente");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String codigo = this.jTextField1.getText();
        if (codigo.length() >= 5) {
            codigo = codigo.substring(0, 5);
            this.jTextField1.setText(codigo);
            ConsultarStock_ConsultarActionPerformed(null);
        }
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        // Valida la impresion antes de procesarla
        TableModel modelo = this.jTable1.getModel();
        boolean valido = true;
        String codigo = modelo.getValueAt(0, 0).toString();
        if (codigo.equals("")) {
            valido = false;
        }
        String descripcion = modelo.getValueAt(0, 1).toString();
        for (int i = 1; i < modelo.getRowCount(); i++) {
            if (!codigo.equals(modelo.getValueAt(i, 0).toString())) {
                valido = false;
                break;
            }
        }
        if (!valido) {
            JOptionPane.showConfirmDialog(null, "Debe seleccionar un producto", "Advertencia", JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // Levanta los datos del modelo
        List<String> refTalles = this.caracteristicas.getCaracteristica("talles");
        List<String> tallesList = new ArrayList<String>();

        List<String> tallList = new ArrayList<String>();
        List<String> coloList = new ArrayList<String>();

        Hashtable<String, String> stock = new Hashtable<String, String>();
        String separador = ";";
        String c, t, s, key;
        int bar;
        for (int i = 0; i < modelo.getRowCount(); i++) {
            // TODO columnas 3, 4 y 6 talles, colores y stock
            c = modelo.getValueAt(i, 4).toString();
            t = modelo.getValueAt(i, 3).toString();
            key = c + separador + t;
            if (stock.containsKey(key)) {
                bar = Integer.parseInt(stock.get(key));
                bar += Integer.parseInt(modelo.getValueAt(i, 6).toString());
                s = "" + bar;
                stock.remove(key);
            } else {
                s = modelo.getValueAt(i, 6).toString();
            }
            stock.put(key, s);
            // Actualiza los colores y talles que tienen stock
            if (!coloList.contains(c) && !c.equals("*")) {
                coloList.add(c);
            }
            if (!tallList.contains(t) && !t.equals("*")) {
                tallList.add(t);
            }
        }
        // Agrega el intervalo de talles adecuados
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int iaz;
        for(String saz: tallList){
            iaz = refTalles.indexOf(saz);
            if(iaz > max){
                max = iaz;
            }
            if(iaz < min){
                min = iaz;
            }
        }
        for (int i = min; i <= max; i++) {
            tallesList.add(refTalles.get(i));
        }

        String f = "C:\\temp\\imprimir.pdf";
        try {
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, new FileOutputStream(f));
            document.open();
            document.addTitle("Inventario");
            Paragraph preface = new Paragraph();
            Paragraph aux = new Paragraph("Rossi Sport", new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD));
            aux.setAlignment(Element.ALIGN_CENTER);
            preface.add(aux);
            preface.add(new Paragraph(" "));
            Date now = Calendar.getInstance().getTime();
            String sdf = new SimpleDateFormat("dd MMM yyyy hh:mm:ss").format(now);
            aux = new Paragraph("Fecha: " + sdf, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
            aux.setAlignment(Element.ALIGN_RIGHT);
            preface.add(aux);
            //preface.add(new Paragraph(" "));
            aux = new Paragraph("Producto: " + codigo, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
            aux.setAlignment(Element.ALIGN_LEFT);
            preface.add(aux);
            //preface.add(new Paragraph(" "));
            aux = new Paragraph("Descripción: " + descripcion, new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD));
            aux.setAlignment(Element.ALIGN_LEFT);
            preface.add(aux);
            preface.add(new Paragraph(" "));

            // TODO
            // Falta realizar la logica de procesamiento de talles
            String[] talles = new String[tallesList.size()];
            for (int i = 0; i < tallesList.size(); i++) {
                talles[i] = tallesList.get(i);
            }
            String[] colores = new String[coloList.size()];
            for (int i = 0; i < coloList.size(); i++) {
                colores[i] = coloList.get(i);
            }
            // Creamos la tabla
            PdfPTable table = new PdfPTable(talles.length + 1);
            // Cargamos los headers de las columnas y sus anchos
            PdfPCell c1;
            String[] headers = new String[talles.length + 1];
            headers[0] = "";
            System.arraycopy(talles, 0, headers, 1, talles.length);
            int idx = 0;
            float[] anchos = new float[talles.length + 1];
            for (String header : headers) {
                c1 = new PdfPCell(new Phrase(header));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                anchos[idx] = 1.0f;
                idx++;
            }
            anchos[0] = 2.0f;
            table.setWidths(anchos);
            // Carga el contenido de la tabla
            for (String color : colores) {
                c1 = new PdfPCell(new Phrase(color));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                for (String talle : talles) {
                    // TODO ponerle onda a la carga de la tabla
                    c1 = new PdfPCell(new Phrase(stock.get(color + separador + talle)));
                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(c1);
                }
            }
            table.setHeaderRows(1);

            /*
             int j;
             for (int i = 0; i < t.getRowCount(); i++) {
             j = this.jTable1.convertRowIndexToModel(i);
             table.addCell((String) t.getValueAt(j, 0));
             table.addCell((String) t.getValueAt(j, 1));
             table.addCell((String) t.getValueAt(j, 2));
             table.addCell((String) t.getValueAt(j, 3));
             }
             */
            preface.add(table);

            document.add(preface);
            document.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Desktop desktop = Desktop.getDesktop();
        if (desktop.isSupported(Desktop.Action.PRINT)) {
            try {
                File archivo_pdf = new File(f);
                desktop.print(archivo_pdf);
            } catch (Exception e1) {
                System.out.print("El sistema no permite imprimir usando la clase Desktop");
                e1.printStackTrace();
            }
        } else {
            System.out.print("El sistema no permite imprimir usando la clase Desktop");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AltasBajas_Crear;
    private javax.swing.JButton AltasBajas_Eliminar;
    private javax.swing.JButton BajarArticulos_Bajar;
    private javax.swing.JButton CargarArticulos_Cargar;
    private javax.swing.JButton ConsultarStock_Consultar;
    private javax.swing.JButton CrearProducto_Crear;
    private javax.swing.JButton EliminarProducto_Eliminar;
    private javax.swing.JButton IngresarArticulos_Ingresar;
    private javax.swing.JButton ModificarProducto_Modificar;
    private presentacion.BajarStock bajarStock1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox10;
    private javax.swing.JComboBox jComboBox11;
    private javax.swing.JComboBox jComboBox12;
    private javax.swing.JComboBox jComboBox14;
    private javax.swing.JComboBox jComboBox15;
    private javax.swing.JComboBox jComboBox16;
    private javax.swing.JComboBox jComboBox17;
    private javax.swing.JComboBox jComboBox18;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JComboBox jComboBox20;
    private javax.swing.JComboBox jComboBox21;
    private javax.swing.JComboBox jComboBox22;
    private javax.swing.JComboBox jComboBox26;
    private javax.swing.JComboBox jComboBox27;
    private javax.swing.JComboBox jComboBox28;
    private javax.swing.JComboBox jComboBox29;
    private javax.swing.JComboBox jComboBox3;
    private javax.swing.JComboBox jComboBox30;
    private javax.swing.JComboBox jComboBox31;
    private javax.swing.JComboBox jComboBox32;
    private javax.swing.JComboBox jComboBox33;
    private javax.swing.JComboBox jComboBox34;
    private javax.swing.JComboBox jComboBox37;
    private javax.swing.JComboBox jComboBox38;
    private javax.swing.JComboBox jComboBox39;
    private javax.swing.JComboBox jComboBox4;
    private javax.swing.JComboBox jComboBox40;
    private javax.swing.JComboBox jComboBox41;
    private javax.swing.JComboBox jComboBox42;
    private javax.swing.JComboBox jComboBox43;
    private javax.swing.JComboBox jComboBox44;
    private javax.swing.JComboBox jComboBox45;
    private javax.swing.JComboBox jComboBox5;
    private javax.swing.JComboBox jComboBox6;
    private javax.swing.JComboBox jComboBox7;
    private javax.swing.JComboBox jComboBox8;
    private javax.swing.JComboBox jComboBox9;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable11;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable7;
    private javax.swing.JTable jTable8;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField42;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField47;
    private javax.swing.JTextField jTextField48;
    private javax.swing.JTextField jTextField49;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField50;
    private javax.swing.JTextField jTextField51;
    private javax.swing.JTextField jTextField52;
    private javax.swing.JTextField jTextField53;
    private javax.swing.JTextField jTextField56;
    private javax.swing.JTextField jTextField59;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField60;
    private javax.swing.JTextField jTextField61;
    private javax.swing.JTextField jTextField62;
    private javax.swing.JTextField jTextField64;
    private javax.swing.JTextField jTextField65;
    private javax.swing.JTextField jTextField66;
    private javax.swing.JTextField jTextField67;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private presentacion.ListadoProductos listadoProductos;
    private presentacion.MoverStock moverStock1;
    private presentacion.MoverStockProducto moverStockProducto1;
    private presentacion.PrototipoIngresoMasivoEImpresion prototipoIngresoMasivoEImpresion1;
    private presentacion.PrototipoPrecioCostos prototipoPrecioCostos1;
    private javax.swing.JButton proveedor_Alta_Crear;
    private javax.swing.JButton proveedor_Alta_Crear2;
    private javax.swing.JButton proveedor_Facturas_verFactura;
    private javax.swing.JButton proveedores_Alta_Agregar;
    private javax.swing.JButton proveedores_Alta_Agregar2;
    // End of variables declaration//GEN-END:variables
}
