package Vista;

import Logica.Area;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import Persistencia.exceptions.ViolacionClaveForaneaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class GestionarArea extends javax.swing.JInternalFrame {
    Utilitario unUtilitario = new Utilitario();
    ControladorVisual unControladorVisual = new ControladorVisual();
    
    public GestionarArea() {
        initComponents();
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerAreas(), this.cmbAreas);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        plGestionArea = new javax.swing.JPanel();
        lblArea = new javax.swing.JLabel();
        cmbAreas = new javax.swing.JComboBox<>();
        lblNombre = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestionar Areas");
        setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        lblArea.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblArea.setText("Area");

        cmbAreas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbAreas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAreas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbAreasMouseClicked(evt);
            }
        });
        cmbAreas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAreasActionPerformed(evt);
            }
        });

        lblNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNombre.setText("Nombre");

        tfNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plGestionAreaLayout = new javax.swing.GroupLayout(plGestionArea);
        plGestionArea.setLayout(plGestionAreaLayout);
        plGestionAreaLayout.setHorizontalGroup(
            plGestionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plGestionAreaLayout.createSequentialGroup()
                .addGroup(plGestionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(plGestionAreaLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(plGestionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblNombre)
                            .addComponent(lblArea))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(plGestionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfNombre)
                            .addComponent(cmbAreas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(plGestionAreaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBorrar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        plGestionAreaLayout.setVerticalGroup(
            plGestionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plGestionAreaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(plGestionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblArea)
                    .addComponent(cmbAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plGestionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(plGestionAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBorrar)
                    .addComponent(btnEditar)
                    .addComponent(btnAgregar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plGestionArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plGestionArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(this.cmbAreas.getSelectedItem() != null){
            if(this.tfNombre.getText().length() > 0){
                Area unArea = (Area) this.cmbAreas.getSelectedItem();
                unArea.setNombre(this.tfNombre.getText());
                try {
                    this.unControladorVisual.modificarArea(unArea);
                    this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerAreas(), this.cmbAreas);
                    this.unUtilitario.LimpiarCaja(plGestionArea);
                } catch (Exception ex) {
                    Logger.getLogger(GestionarArea.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        try {
            this.unControladorVisual.agregarArea(this.tfNombre.getText());
            this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerAreas(), this.cmbAreas);
            this.unUtilitario.LimpiarCaja(plGestionArea);
        } catch (PreexistingEntityException ex) {
            JOptionPane.showMessageDialog(rootPane, "ya existe una Cartera con tal nombre");
        }
        
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        Area unArea = (Area) this.cmbAreas.getSelectedItem();
        try {
            this.unControladorVisual.borrarArea(unArea.getId());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(GestionarArea.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ViolacionClaveForaneaException ex) {
            JOptionPane.showMessageDialog(rootPane, "No se puede borrar debido a que existen cobranzas relacionadas a esta cartera.");
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void cmbAreasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAreasActionPerformed
        if(this.cmbAreas.getSelectedItem() != null){
            Area unArea = (Area) this.cmbAreas.getSelectedItem();
            this.tfNombre.setText(unArea.getNombre());
        }
        
    }//GEN-LAST:event_cmbAreasActionPerformed

    private void cmbAreasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbAreasMouseClicked
        //Area unArea = (Area) this.cmbAreas.getSelectedItem();
        //this.tfNombre.setText(unArea.getNombre());
    }//GEN-LAST:event_cmbAreasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cmbAreas;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JPanel plGestionArea;
    private javax.swing.JTextField tfNombre;
    // End of variables declaration//GEN-END:variables

}
