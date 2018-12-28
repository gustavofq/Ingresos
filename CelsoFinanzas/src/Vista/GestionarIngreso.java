package Vista;

import Logica.Cobranza;
import Logica.Ingreso;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GestionarIngreso extends javax.swing.JInternalFrame {
    Utilitario unUtilitario = new Utilitario();
    ControladorVisual unControladorVisual = new ControladorVisual();
 
    public GestionarIngreso() {
        initComponents();
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), this.cmbCobradores);
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerAreas(), this.cmbAreas);
        this.unUtilitario.cargarAnhoActual(tfyear);
        this.unUtilitario.cargarMesActual(cmbMes);
        //this.cargarTabla();
        BuscarListadoModelTable tiModel = new BuscarListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        this.tblListado.setModel(tiModel);
        IngresoModelTable modelIngreso = new IngresoModelTable(this.unControladorVisual.ObtenerCobranzaPorId(101).getIngresos());
        this.tblAfiliados.setModel(modelIngreso);
        
    }

    private void cargarTabla(){
        this.unUtilitario.LimpiarTabla(tblListado);
        ListadoModelTable tiModel = new ListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        this.tblListado.setModel(tiModel);
        /*
        
        DefaultTableModel model = (DefaultTableModel)this.tblListado.getModel();
        List<Cobranza> cobranzas = this.unControladorVisual.obtenerCobranzas();
        Object[] fila = new Object[4];
        for (Cobranza unaCobranza : cobranzas ){
            fila[0] = unaCobranza.getYear();
            fila[1] = unaCobranza.getMes();
            if(unaCobranza.getUnArea() == null){
                fila[2] = "";
            }else{
                fila[2] = unaCobranza.getUnArea().getNombre();
            }
            
            fila[3] = unaCobranza.getUnCobrador();
            model.addRow(fila);
        }
        this.tblListado.setModel(model);
*/
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pIngreso = new javax.swing.JPanel();
        jpBuscar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cmbCobradores = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tfyear = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbMes = new com.toedter.calendar.JMonthChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cmbAreas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        tfConcepto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfAfiliado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAfiliados = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jpBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Año", "Mes", "Área", "Cobrador"
            }
        ));
        tblListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListadoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblListado);

        jLabel3.setText("Cobrador");

        cmbCobradores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Año");

        tfyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfyearActionPerformed(evt);
            }
        });

        jLabel2.setText("Mes");

        javax.swing.GroupLayout jpBuscarLayout = new javax.swing.GroupLayout(jpBuscar);
        jpBuscar.setLayout(jpBuscarLayout);
        jpBuscarLayout.setHorizontalGroup(
            jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBuscarLayout.createSequentialGroup()
                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBuscarLayout.createSequentialGroup()
                        .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBuscarLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jpBuscarLayout.createSequentialGroup()
                                .addComponent(tfyear, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cmbCobradores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 73, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpBuscarLayout.setVerticalGroup(
            jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBuscarLayout.createSequentialGroup()
                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCobradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresos"));

        jLabel4.setText("Area");

        cmbAreas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Concepto");

        tfConcepto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfConceptoActionPerformed(evt);
            }
        });

        jLabel6.setText("Afiliado");

        tblAfiliados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Concepto", "Afiliado", "Comision", "Neto"
            }
        ));
        jScrollPane1.setViewportView(tblAfiliados);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbAreas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(80, 80, 80))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(tfConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnEditar)
                    .addComponent(btnBorrar))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout pIngresoLayout = new javax.swing.GroupLayout(pIngreso);
        pIngreso.setLayout(pIngresoLayout);
        pIngresoLayout.setHorizontalGroup(
            pIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pIngresoLayout.setVerticalGroup(
            pIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pIngresoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfyearActionPerformed

    private void tfConceptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfConceptoActionPerformed
  
    }//GEN-LAST:event_tfConceptoActionPerformed

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        ListadoModelTable modelListado = new ListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        
        int id = modelListado.getUserAt(this.tblListado.getSelectedRow()).getId();
        //this.unControladorVisual.ObtenerCobranzaPorId(id).getIngresos();
        IngresoModelTable modelIngreso = new IngresoModelTable(this.unControladorVisual.ObtenerCobranzaPorId(id).getIngresos());
        this.tblAfiliados.setModel(modelIngreso);
    }//GEN-LAST:event_tblListadoMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        ListadoModelTable modelListado = new ListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        int id = modelListado.getUserAt(this.tblListado.getSelectedRow()).getId();
        Double afiliado = Double.parseDouble(this.tfAfiliado.getText());
        Ingreso unIngreso = new Ingreso(afiliado, this.tfConcepto.getText(), null);
        try {
            this.unControladorVisual.agregarListado(id, unIngreso);
        } catch (Exception ex) {
            Logger.getLogger(GestionarIngreso.class.getName()).log(Level.SEVERE, null, ex);
        }
        IngresoModelTable modelIngreso = new IngresoModelTable(this.unControladorVisual.ObtenerCobranzaPorId(id).getIngresos());
        this.tblAfiliados.setModel(modelIngreso);
//      this.cargarTabla();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        ListadoModelTable modelListado = new ListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        int id = modelListado.getUserAt(this.tblListado.getSelectedRow()).getId();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cmbAreas;
    private javax.swing.JComboBox<String> cmbCobradores;
    private com.toedter.calendar.JMonthChooser cmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpBuscar;
    private javax.swing.JPanel pIngreso;
    private javax.swing.JTable tblAfiliados;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField tfAfiliado;
    private javax.swing.JTextField tfConcepto;
    private javax.swing.JTextField tfyear;
    // End of variables declaration//GEN-END:variables
}
