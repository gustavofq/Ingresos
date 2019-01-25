package Vista;
import Logica.Area;
import Logica.Cobrador;
import Logica.Cobranza;
import Persistencia.exceptions.NonexistentEntityException;
import Persistencia.exceptions.PreexistingEntityException;
import Persistencia.exceptions.ViolacionClaveForaneaException;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class GestionarListado extends javax.swing.JInternalFrame {
    Utilitario unUtilitario = new Utilitario();
    ControladorVisual unControladorVisual = new ControladorVisual();
    Font fuente = new Font("Dialog", Font.BOLD, 18);
    JLabel mensaje = new JLabel("mensaje");
    
    
    public  GestionarListado() {
        initComponents();
        this.mensaje.setFont(new Font("Arial", Font.BOLD, 18));
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), this.cmbCobradores);
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerAreas(), this.cmbCartera);
        this.unUtilitario.cargarAnhoActual(this.tfanho);
        this.unUtilitario.cargarMesActual(this.cmbMoth);
        this.cmbCobradores.setSelectedIndex(-1);
        this.cmbCartera.setSelectedIndex(-1);
        this.cargarTabla();
        mensaje.setFont(fuente);
        this.unUtilitario.CambiarEncabezado(this.tblListado, fuente);
    }

    private void cargarTabla(){
        ListadoModelTable modelListado = new ListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        this.tblListado.setModel(modelListado);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jpListado = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfListado = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfanho = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbCobradores = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cmbMoth = new com.toedter.calendar.JMonthChooser();
        cmbCartera = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setIconifiable(true);
        setTitle("Gestionar Listado");
        setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Listado");

        tfListado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfListado.setNextFocusableComponent(cmbCobradores);
        tfListado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfListadoKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Año");

        tfanho.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfanho.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfanhoKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Mes");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Cobrador");

        cmbCobradores.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbCobradores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

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

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("$");

        cmbMoth.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        cmbCartera.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbCartera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCartera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCarteraActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Cartera");

        tblListado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Listado", "Cobrado", "Comisión", "Neto"
            }
        ));
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblListado);

        javax.swing.GroupLayout jpListadoLayout = new javax.swing.GroupLayout(jpListado);
        jpListado.setLayout(jpListadoLayout);
        jpListadoLayout.setHorizontalGroup(
            jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpListadoLayout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(1064, 1064, 1064))
                    .addGroup(jpListadoLayout.createSequentialGroup()
                        .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpListadoLayout.createSequentialGroup()
                                .addComponent(tfanho, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbMoth, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
                            .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jpListadoLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                                    .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jpListadoLayout.createSequentialGroup()
                                    .addComponent(tfListado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5))
                                .addComponent(cmbCobradores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbCartera, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jpListadoLayout.setVerticalGroup(
            jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListadoLayout.createSequentialGroup()
                .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpListadoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(tfanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addComponent(cmbMoth, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbCobradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCartera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfListado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpListadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEditar)
                            .addComponent(btnAgregar)
                            .addComponent(btnBorrar))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpListado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(this.unUtilitario.comboBoxCompleto(jpListado) && this.unUtilitario.campoCompleto(jpListado) ){
            int year = Integer.parseInt(this.tfanho.getText());
            int mes =this.cmbMoth.getMonth();
            Cobrador unCobrador = (Cobrador) this.cmbCobradores.getSelectedItem();
            long dni = unCobrador.getDni();
            Double listado = Double.parseDouble(this.tfListado.getText());
            Area unArea = (Area) this.cmbCartera.getSelectedItem();
            try {
                this.unControladorVisual.agregarCobranza(listado, mes, year, unCobrador,unArea);
                this.cargarTabla();
                this.mensaje.setText("Se a agregado un nuevo listado exitosamente.");
                JOptionPane.showMessageDialog(null,this.mensaje,"Exito!",JOptionPane.INFORMATION_MESSAGE); 
            } catch (PreexistingEntityException ex) {
                this.mensaje.setText("ya existe la cobranza del mes " + mes +" del año " + year +" corresponeidntes al cobrador " +unCobrador.toString()+" del la cartera " + unArea.getNombre() );
                JOptionPane.showMessageDialog(null,this.mensaje,"Ya existe.",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            this.mensaje.setText("Debe completar los campos coloreados y seleccionar cobrador y area correspondientes.");
            JOptionPane.showMessageDialog(null,this.mensaje,"Datos faltantes.",JOptionPane.INFORMATION_MESSAGE); 
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(this.tblListado.getSelectedRow() != -1){
            Cobranza unaCobranza = this.obtenerCobranzaSeleccionada();
            try {
                this.mensaje.setText("Realmente quiere eliminar el listado?");
                if(JOptionPane.showConfirmDialog(rootPane, mensaje, "Borrar Listado ", JOptionPane.YES_NO_OPTION) == 0){
                    this.unControladorVisual.borrarCobranza(unaCobranza.getId());
                    this.mensaje.setText("Se ha borrado el listado exitosamente.");
                    JOptionPane.showMessageDialog(null,this.mensaje,"Éxito!",JOptionPane.INFORMATION_MESSAGE);
                    this.cargarTabla();
                } 
            } catch (NonexistentEntityException ex) {
                JOptionPane.showMessageDialog(rootPane, "No se Existe tal Listado");
            } catch(ViolacionClaveForaneaException ex){
                this.mensaje.setText("No se puede borrar porque existen Ingresos relacionados a este listado.");
                JOptionPane.showMessageDialog(null,this.mensaje,"Denegado",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            this.mensaje.setText("Debe seleccionar un Listado para borrar.");
            JOptionPane.showMessageDialog(null,this.mensaje,"Borrar Listado",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void tfanhoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfanhoKeyReleased
        this.unUtilitario.limitarLetra(4, tfanho);
        this.unUtilitario.borrarLetra(tfanho);
    }//GEN-LAST:event_tfanhoKeyReleased

    private void tfListadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfListadoKeyReleased
        this.unUtilitario.borrarLetra(this.tfListado);
    }//GEN-LAST:event_tfListadoKeyReleased

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(this.unUtilitario.comboBoxCompleto(this.jpListado)){
            Cobranza unaCobranza = this.obtenerCobranzaSeleccionada();
            unaCobranza.setListado(Double.parseDouble(this.tfListado.getText()));
            unaCobranza.setMes(this.cmbMoth.getMonth());
            unaCobranza.setYear(Integer.parseInt(this.tfanho.getText()));
            unaCobranza.setUnArea((Area)this.cmbCartera.getSelectedItem());
            unaCobranza.setUnCobrador((Cobrador)this.cmbCobradores.getSelectedItem());
            try {
                this.unControladorVisual.modificarCobranza(unaCobranza);
                 this.mensaje.setText("Se modifico exitosamente.");
            JOptionPane.showMessageDialog(null,this.mensaje,"Éxito.",JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(GestionarListado.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.cargarTabla();
        }else{
            this.mensaje.setText("Debe ingresar todos los datos requeridos.");
            JOptionPane.showMessageDialog(null,this.mensaje,"Faltan datos.",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        Cobranza unaCobranza = this.obtenerCobranzaSeleccionada();
        this.unUtilitario.posicionarCombo(this.cmbCobradores, unaCobranza.getUnCobrador());
        this.unUtilitario.posicionarCombo(this.cmbCartera, unaCobranza.getUnArea());
        this.cmbMoth.setMonth(unaCobranza.getMes());
        this.cmbCartera.setSelectedItem(unaCobranza.getUnArea());
        this.tfanho.setText(String.valueOf(unaCobranza.getYear()));
        this.tfListado.setText(String.valueOf(unaCobranza.getListado()));
    }//GEN-LAST:event_tblListadoMouseClicked

    private void cmbCarteraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCarteraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCarteraActionPerformed
    
    private Cobranza obtenerCobranzaSeleccionada(){
        ListadoModelTable model = new ListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        Cobranza unaCobranza = new Cobranza();
        try {
            unaCobranza = (Cobranza) model.getUserAt(this.tblListado.getSelectedRow());
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            System.out.println("debe seleccionar un listado");
        }
        
        
        return unaCobranza;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cmbCartera;
    private javax.swing.JComboBox<String> cmbCobradores;
    private com.toedter.calendar.JMonthChooser cmbMoth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JPanel jpListado;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField tfListado;
    private javax.swing.JTextField tfanho;
    // End of variables declaration//GEN-END:variables
}
