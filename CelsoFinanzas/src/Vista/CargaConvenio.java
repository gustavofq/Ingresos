package Vista;

import Logica.Convenio;
import Persistencia.exceptions.NonexistentEntityException;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CargaConvenio extends javax.swing.JInternalFrame {
    private Utilitario unUtilitario = new Utilitario();
    private ControladorVisual unControladorVisual = new ControladorVisual();
    JLabel mensaje = new JLabel("mensaje");
    Font fuente = new Font("Dialog", Font.BOLD, 18);
    
    public CargaConvenio() {
        initComponents();
        this.mensaje.setFont(new Font("Arial", Font.BOLD, 18));
        unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerConvenios(), cmbConvenios); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeneral = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        bntAgregar = new javax.swing.JButton();
        lblConvenios = new javax.swing.JLabel();
        cmbConvenios = new javax.swing.JComboBox<>();
        btnModificar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Gestionar Convenios");

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombre.setText("Nombre: ");

        tfNombre.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        bntAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        bntAgregar.setText("Agregar");
        bntAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntAgregarActionPerformed(evt);
            }
        });

        lblConvenios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblConvenios.setText("Convenios:");

        cmbConvenios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbConvenios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnModificar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addComponent(bntAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addComponent(lblConvenios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlGeneralLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(lblNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblConvenios)
                    .addComponent(cmbConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
                    .addComponent(btnModificar)
                    .addComponent(bntAgregar)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntAgregarActionPerformed
        String nombre = this.tfNombre.getText();
        unControladorVisual.agregarConvenio(nombre);
        unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerConvenios(), cmbConvenios);
        this.tfNombre.setText("");
        this.mensaje.setText("Se ha agregado satisfactoriamente al convenio " + nombre );
        JOptionPane.showMessageDialog(null,this.mensaje,"Éxito!",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_bntAgregarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String nombre = this.tfNombre.getText();
        Convenio unConvenio = (Convenio) this.cmbConvenios.getSelectedItem();
        unConvenio.setNombre(nombre);
        try {
            unControladorVisual.modificarConvenio(unConvenio);
        } catch (Exception ex) {
            Logger.getLogger(CargaConvenio.class.getName()).log(Level.SEVERE, null, ex);
        }
        unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerConvenios(), cmbConvenios);
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        Convenio unConvenio = (Convenio) this.cmbConvenios.getSelectedItem();
        try {
            this.unControladorVisual.borrarConvenio(unConvenio.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CargaConvenio.class.getName()).log(Level.SEVERE, null, ex);
        }
        unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerConvenios(), cmbConvenios);
    }//GEN-LAST:event_btnBorrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbConvenios;
    private javax.swing.JLabel lblConvenios;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables
}
