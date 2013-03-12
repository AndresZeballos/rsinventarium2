/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import logica.ControladorCostos;
import logica.ControladorPrecios;

/**
 *
 * @author Andres
 */
public class PrototipoPrecioCostos extends AZPanel {

    private ControladorCostos costos;
    private ControladorPrecios precios;

    @Override
    protected void cargarCaracteristicas() {
        cargarCombo("descripciones", this.jComboBox35);
    }

    public ControladorCostos getCostos() {
        return costos;
    }

    public void setCostos(ControladorCostos costos) {
        this.costos = costos;
    }

    public ControladorPrecios getPrecios() {
        return precios;
    }

    public void setPrecios(ControladorPrecios precios) {
        this.precios = precios;
    }

    /**
     * Creates new form PrototipoPrecioCostos
     */
    public PrototipoPrecioCostos() {
        initComponents();
    }
    
    private void cargarTabla(String codigo){
        List<String> talles = caracteristicas.getCaracteristica("talles");
        DefaultTableModel model = (DefaultTableModel) this.jTable3.getModel();
        while (model.getRowCount() != 0) {
            model.removeRow(0);
        }
        String precio, origen, costoEntrada, costo;
        String[] aux;
        for (String talle : talles) {
            precio = this.precios.cargar(codigo, talle);
            aux = this.costos.cargar(codigo, talle);
            origen = aux[0];
            costoEntrada = aux[1];
            costo = aux[2];
            model.addRow(new Object[]{talle, precio, origen, costoEntrada, costo});
        }
        this.jLabel1.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox35 = new javax.swing.JComboBox();
        jTextField12 = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(975, 528));

        jComboBox35.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox35ItemStateChanged(evt);
            }
        });

        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField12KeyReleased(evt);
            }
        });

        jLabel54.setText("Código de producto");

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Talle", "Precio", "Origen", "Costo de entrada", "Costo de compra"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane7.setViewportView(jTable3);

        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(160, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(160, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(160, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel54)
                        .addGap(10, 10, 10)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox35, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel54)
                        .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jComboBox35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 477, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox35ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox35ItemStateChanged
        String codigo = this.jComboBox35.getSelectedItem().toString();
        this.jTextField12.setText(codigo);
        cargarTabla(codigo);
    }//GEN-LAST:event_jComboBox35ItemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.jLabel1.setText("");
        String codigo = this.jTextField12.getText();
        DefaultTableModel model = (DefaultTableModel) this.jTable3.getModel();
        String talle;
        String precio, origen, costoEntrada, costo;
        String precio_ant, origen_ant, costoEntrada_ant, costo_ant;
        String[] aux;
        boolean resultado = true;
        for (int i = 0; i < model.getRowCount(); i++) {
            talle = model.getValueAt(i, 0).toString();
            if (!talle.equals("")) {
                precio = (String) model.getValueAt(i, 1);
                precio_ant = this.precios.cargar(codigo, talle);
                if(!precio.equals(precio_ant)){
                    resultado = resultado & this.precios.modificar(codigo, talle, precio);
                }
                origen = (String) model.getValueAt(i, 2);
                costoEntrada = (String) model.getValueAt(i, 3);
                costo = (String) model.getValueAt(i, 4);
                aux = this.costos.cargar(codigo, talle);
                origen_ant = aux[0];
                costoEntrada_ant = aux[1];
                costo_ant = aux[2];
                if(!origen.equals(origen_ant) || !costoEntrada.equals(costoEntrada_ant) || !costo.equals(costo_ant) ){
                    resultado = resultado & this.costos.modificar(codigo, talle, origen, costoEntrada, costo);
                }
            }
        }
        if (resultado) {
            this.jLabel1.setText("Operación exitosa");
        } else {
            this.jLabel1.setText("Ocurrió un problema");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField12KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyReleased
        String codigo = this.jTextField12.getText();
        if (codigo.length() >= 5) {
            codigo = codigo.substring(0, 5);
            this.jTextField12.setText(codigo);
            cargarTabla(codigo);
        }
    }//GEN-LAST:event_jTextField12KeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox35;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField12;
    // End of variables declaration//GEN-END:variables
}
