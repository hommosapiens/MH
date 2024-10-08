package com.mh.gui;

import com.mh.biz.pojo.Venta;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan Pedro Rodriguez Aranda
 */
public class VentasJDialog extends javax.swing.JDialog {

    /**
     * Creates new form VentasJDialog
     */
    public VentasJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        interfaz = (ExecGUI) this.getParent();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableVentas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTableVentas.setBackground(new java.awt.Color(40, 100, 40));
        jTableVentas.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jTableVentas.setForeground(new java.awt.Color(40, 200, 40));
        jTableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Posicion", "Nombre", "Precio", "Tipo", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableVentas.setGridColor(new java.awt.Color(40, 150, 40));
        jTableVentas.setSelectionBackground(new java.awt.Color(40, 150, 40));
        jTableVentas.setSelectionForeground(new java.awt.Color(70, 255, 70));
        jTableVentas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableVentas.getTableHeader().setReorderingAllowed(false);
        jTableVentas.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jTableVentasAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(jTableVentas);
        if (jTableVentas.getColumnModel().getColumnCount() > 0) {
            jTableVentas.getColumnModel().getColumn(0).setResizable(false);
            jTableVentas.getColumnModel().getColumn(1).setResizable(false);
            jTableVentas.getColumnModel().getColumn(2).setResizable(false);
            jTableVentas.getColumnModel().getColumn(3).setResizable(false);
            jTableVentas.getColumnModel().getColumn(4).setResizable(false);
            jTableVentas.getColumnModel().getColumn(5).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableVentasAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jTableVentasAncestorAdded
        // TODO add your handling code here:

        //Alinea los elementos de la tabla a la izquierda
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.LEFT);
        this.jTableVentas.setDefaultRenderer(Object.class, centerRenderer);

        //Leemos los datos
        DefaultTableModel dtm = (DefaultTableModel) this.jTableVentas.getModel();
        List<Venta> ventas = null;

        try {
            ventas = interfaz.getVentas();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Añadimos ventas a la tabla
        for (Venta venta : ventas) {
            Object[] o = {venta.getFecha_hora(), venta.getPosicion(), venta.getNombre(), venta.getPrecio(), venta.getTipo(), venta.getCantidad()};
            dtm.addRow(o);
        }
    }//GEN-LAST:event_jTableVentasAncestorAdded

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(VentasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentasJDialog dialog = new VentasJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    ExecGUI interfaz;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableVentas;
    // End of variables declaration//GEN-END:variables
}
