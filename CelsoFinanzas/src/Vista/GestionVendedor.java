package Vista;

import Logica.Cobrador;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import Persistencia.exceptions.ViolacionClaveForaneaException;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GestionVendedor extends javax.swing.JInternalFrame {
    Utilitario unUtilitario = new Utilitario();
    ControladorVisual unControladorVisual = new ControladorVisual();
    JLabel mensaje = new JLabel("mensaje");
    Font fuente = new Font("Dialog", Font.BOLD, 18);
    
    
    public GestionVendedor() {
        initComponents();
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), this.cmbCobradores);
        this.unUtilitario.LimpiarCaja(jpCobrador);
        this.mensaje.setFont(new Font("Arial", Font.BOLD, 18));
        this.cmbCobradores.setSelectedIndex(-1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpCobrador = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbCobradores = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDni = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfAlias = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfPorcentaje = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestionar Cobradores");
        setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Cobrador");

        cmbCobradores.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbCobradores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCobradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCobradoresActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Nombre");

        tfNombre.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tfNombre.setCaretColor(new java.awt.Color(0, 0, 204));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Apellido");

        tfApellido.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("DNI");

        tfDni.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tfDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfDniKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Alias");

        tfAlias.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

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

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Comisión");

        tfPorcentaje.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tfPorcentaje.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPorcentajeKeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("%");

        javax.swing.GroupLayout jpCobradorLayout = new javax.swing.GroupLayout(jpCobrador);
        jpCobrador.setLayout(jpCobradorLayout);
        jpCobradorLayout.setHorizontalGroup(
            jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCobradorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpCobradorLayout.createSequentialGroup()
                        .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpCobradorLayout.createSequentialGroup()
                                .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpCobradorLayout.createSequentialGroup()
                                        .addComponent(tfPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(tfAlias, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                        .addComponent(tfDni, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGap(0, 5, Short.MAX_VALUE))
                            .addGroup(jpCobradorLayout.createSequentialGroup()
                                .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(tfNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCobradores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))
                    .addGroup(jpCobradorLayout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBorrar)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jpCobradorLayout.setVerticalGroup(
            jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpCobradorLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbCobradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(tfApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfAlias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpCobradorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnBorrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpCobrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpCobrador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbCobradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCobradoresActionPerformed
        if(this.cmbCobradores.getSelectedIndex() != -1){
            Cobrador unCobrador = (Cobrador) this.cmbCobradores.getSelectedItem();
            this.tfApellido.setText(unCobrador.getApellido());
            this.tfNombre.setText(unCobrador.getNombre());
            this.tfAlias.setText(unCobrador.getAlias());
            this.tfDni.setText(Long.toString(unCobrador.getDni()));
            this.tfPorcentaje.setText(Integer.toString(unCobrador.getUnaComision()));
        }
    }//GEN-LAST:event_cmbCobradoresActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(this.cmbCobradores.getSelectedItem() != null){
            Cobrador unCobrador = (Cobrador) this.cmbCobradores.getSelectedItem();
            try {
                this.unControladorVisual.borrarCobrador(unCobrador.getDni());
                this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), this.cmbCobradores);
                this.unUtilitario.LimpiarCaja(jpCobrador);
                this.mensaje.setText("Se ha agregado satisfactoriamente!");
                JOptionPane.showMessageDialog(null,this.mensaje,"Éxito!",JOptionPane.INFORMATION_MESSAGE);
                this.cmbCobradores.setSelectedIndex(-1);
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(GestionVendedor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ViolacionClaveForaneaException ex) {
                this.mensaje.setText("No se puede borrar debido a que existen cobranzas relacionadas a este Cobrador.");
                JOptionPane.showMessageDialog(null,this.mensaje,"ERROR",JOptionPane.WARNING_MESSAGE);
            }
        }else{
            this.mensaje.setText("Debe seleccionar un Cobrador para borrar.");
            JOptionPane.showMessageDialog(null,this.mensaje,"ERROR",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(this.unUtilitario.campoCompleto(this.jpCobrador)){
            String nombre = this.tfNombre.getText();
            String alias = this.tfAlias.getText();
            String apellido = this.tfApellido.getText();
            int comision = Integer.parseInt(this.tfPorcentaje.getText());
            long dni= Long.parseLong(this.tfDni.getText());
            try {
                this.unControladorVisual.agregarCobrador(nombre, alias, apellido, dni, comision);
                this.cmbCobradores.removeAll();
                this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), this.cmbCobradores);
                this.unUtilitario.LimpiarCaja(jpCobrador);
                this.mensaje.setText("Se ha agregado satisfactoriamente!");
                JOptionPane.showMessageDialog(null,this.mensaje,"Éxito!",JOptionPane.INFORMATION_MESSAGE);
                this.cmbCobradores.setSelectedIndex(-1);
            } catch (PreexistingEntityException ex) {
                this.mensaje.setText("Ya existe un Cobrador con este DNI.");
                JOptionPane.showMessageDialog(null,this.mensaje,"ERROR!",JOptionPane.ERROR_MESSAGE);
                this.unUtilitario.LimpiarCaja(jpCobrador);
                this.cmbCobradores.setSelectedIndex(-1);
            }
        }else{
            this.mensaje.setText("Debe completar los campos coloreados.");
            JOptionPane.showMessageDialog(null,this.mensaje,"Borrar Listado",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Cobrador unCobrador = (Cobrador)this.cmbCobradores.getSelectedItem();
        if(this.unUtilitario.campoCompleto(this.jpCobrador)){
            unCobrador.setNombre(this.tfNombre.getText());
            unCobrador.setAlias(this.tfAlias.getText());
            unCobrador.setApellido(this.tfApellido.getText());
            unCobrador.setUnaComision(Integer.parseInt(this.tfPorcentaje.getText()));
            try {
                this.unControladorVisual.modificarCobrador(unCobrador);
                this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), this.cmbCobradores);
                this.unUtilitario.LimpiarCaja(jpCobrador);
            } catch (Exception ex) {
                Logger.getLogger(GestionVendedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            this.mensaje.setText("Debe ingresa datos en los campos coloreados.");
            JOptionPane.showMessageDialog(null,this.mensaje,"Datos faltantes",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tfDniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDniKeyReleased
        this.unUtilitario.borrarLetra(tfDni);
        this.unUtilitario.limitarLetra(8, tfDni);
    }//GEN-LAST:event_tfDniKeyReleased

    private void tfPorcentajeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPorcentajeKeyReleased
        this.unUtilitario.borrarLetra(tfPorcentaje);
        this.unUtilitario.limitarLetra(2, tfPorcentaje);
    }//GEN-LAST:event_tfPorcentajeKeyReleased

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cmbCobradores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jpCobrador;
    private javax.swing.JTextField tfAlias;
    private javax.swing.JTextField tfApellido;
    private javax.swing.JTextField tfDni;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfPorcentaje;
    // End of variables declaration//GEN-END:variables
}
