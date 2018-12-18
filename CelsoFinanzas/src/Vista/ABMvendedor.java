
package Vista;

import Logica.Cobrador;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class ABMvendedor extends javax.swing.JFrame {
    private ControladorVisual unControladorVisual = new ControladorVisual();
    private Utilitario unUtilitario = new Utilitario();
    
    public ABMvendedor() {
        initComponents();
        cargarCombo();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPCobrador = new javax.swing.JPanel();
        jLCobrador = new javax.swing.JLabel();
        jLNombre = new javax.swing.JLabel();
        jLApellido = new javax.swing.JLabel();
        jLAlias = new javax.swing.JLabel();
        jLDni = new javax.swing.JLabel();
        jCBCobradores = new javax.swing.JComboBox<>();
        jTFNombre = new javax.swing.JTextField();
        jTFApellido = new javax.swing.JTextField();
        jTFAlias = new javax.swing.JTextField();
        jTFDni = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jBModificar = new javax.swing.JButton();
        jBBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLCobrador.setText("Cobrador:");

        jLNombre.setText("Nombre:");

        jLApellido.setText("Apellido:");

        jLAlias.setText("Alias:");

        jLDni.setText("DNI:");

        jCBCobradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBCobradoresActionPerformed(evt);
            }
        });

        jTFNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFNombreActionPerformed(evt);
            }
        });

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBModificar.setText("Modificar");

        jBBorrar.setText("Borrar");

        javax.swing.GroupLayout jPCobradorLayout = new javax.swing.GroupLayout(jPCobrador);
        jPCobrador.setLayout(jPCobradorLayout);
        jPCobradorLayout.setHorizontalGroup(
            jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCobradorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPCobradorLayout.createSequentialGroup()
                        .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLApellido)
                            .addComponent(jLAlias)
                            .addComponent(jLDni))
                        .addGap(18, 18, 18)
                        .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTFDni)
                            .addComponent(jTFAlias)
                            .addComponent(jTFApellido)))
                    .addGroup(jPCobradorLayout.createSequentialGroup()
                        .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLNombre)
                            .addComponent(jLCobrador))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCBCobradores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTFNombre)))
                    .addGroup(jPCobradorLayout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jBAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jBModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
        );
        jPCobradorLayout.setVerticalGroup(
            jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPCobradorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLCobrador)
                    .addComponent(jCBCobradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLNombre)
                    .addComponent(jTFNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLApellido)
                    .addComponent(jTFApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLAlias)
                    .addComponent(jTFAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLDni)
                    .addComponent(jTFDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBAgregar)
                    .addComponent(jBModificar)
                    .addComponent(jBBorrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPCobrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPCobrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTFNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFNombreActionPerformed

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        this.agregarCobrador();
        this.unUtilitario.LimpiarCaja(this.jPCobrador);
    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jCBCobradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBCobradoresActionPerformed
        String alias = this.jCBCobradores.getSelectedItem().toString();
        Cobrador unCobrador = new Cobrador();
        unCobrador= this.unControladorVisual.obtenerCobradorPorAlias(alias);
        this.jTFAlias.setText(unCobrador.getAlias());
        this.jTFApellido.setText(unCobrador.getApellido());
        this.jTFNombre.setText(unCobrador.getNombre());
        this.jTFDni.setText(Long.toString(  unCobrador.getDni()));
    }//GEN-LAST:event_jCBCobradoresActionPerformed

    private void agregarCobrador(){
        if(this.campoCompleto()){
            String nombre = this.jTFNombre.getText();
            String alias = this.jTFAlias.getText();
            String apellido = this.jTFApellido.getText();
            long dni= Long.parseLong(this.jTFDni.getText());
            this.unControladorVisual.agregarCobrador(nombre, alias, apellido, dni, 0);
            this.jCBCobradores.removeAll();
            cargarCombo();
        }
    }
    
    private boolean campoCompleto(){
        boolean camposListo= true;
        if(this.jTFNombre.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ingresar un Apellido.");
            camposListo = false;
        }else if(this.jTFApellido.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ingresar un Nombre.");
            camposListo = false;
        }else if(this.jTFDni.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Ingresar un DNI.");
            camposListo = false;
        }else if(unUtilitario.isLong(this.jTFDni.getText()) == false){
            JOptionPane.showMessageDialog(rootPane, "Ingresar un DNI valido.");
            camposListo = false;
        }  
        return camposListo;
    }  

    private void cargarCombo(){
        this.jCBCobradores.removeAllItems();
        Iterator it = this.unControladorVisual.obtenerCobradores().iterator();
        Cobrador unCobrador = new Cobrador();
        while(it.hasNext()){
            unCobrador = (Cobrador) it.next();
            this.jCBCobradores.addItem(unCobrador.getAlias());
        } 
    }
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
            java.util.logging.Logger.getLogger(ABMvendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABMvendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABMvendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABMvendedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABMvendedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBAgregar;
    private javax.swing.JButton jBBorrar;
    private javax.swing.JButton jBModificar;
    private javax.swing.JComboBox<String> jCBCobradores;
    private javax.swing.JLabel jLAlias;
    private javax.swing.JLabel jLApellido;
    private javax.swing.JLabel jLCobrador;
    private javax.swing.JLabel jLDni;
    private javax.swing.JLabel jLNombre;
    private javax.swing.JPanel jPCobrador;
    private javax.swing.JTextField jTFAlias;
    private javax.swing.JTextField jTFApellido;
    private javax.swing.JTextField jTFDni;
    private javax.swing.JTextField jTFNombre;
    // End of variables declaration//GEN-END:variables
}
