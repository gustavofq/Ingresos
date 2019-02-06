package Vista;

import Logica.Area;
import Logica.Cobrador;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class NuevoListado extends javax.swing.JInternalFrame {
    private JTableHeader th= new JTableHeader();
    private ControladorVisual unControladorVisual = new ControladorVisual();
    private Utilitario unUtilitario = new Utilitario();
    
    public NuevoListado() {
        initComponents();
        Font fuente = new Font("Dialog", Font.BOLD, 18);
        th = this.tblListado.getTableHeader();
        th.setFont(fuente);
        this.tblListado.setTableHeader(th);
        th= this.tblTotales.getTableHeader();
        th.setFont(fuente);
        this.tblTotales.setTableHeader(th);
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), cmbCobradores);
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerAreas(), cmbCartera);
        this.cmbCartera.addItem("GENERAL");
        this.cmbCobradores.addItem("GENERAL");
    }
    
    private void cargarTablaListadoCobradorGeneral(){
        Cobrador unCobrador =(Cobrador) this.cmbCobradores.getSelectedItem();
        int year = Integer.parseInt(this.tfYear.getText());
        DefaultTableModel modelo = (DefaultTableModel) this.tblListado.getModel(); 
        for(int i=0; i<=11; i++){
            modelo.setValueAt(this.unControladorVisual.obtenerListadoDelCobrador(unCobrador, year, i), i, 1);
            modelo.setValueAt(this.unControladorVisual.obtenerAfiliadoDelCobrador(unCobrador, year, i), i, 2);
            modelo.setValueAt(this.unControladorVisual.obtenerComisionDelCobrador(unCobrador, year, i), i, 3);
            modelo.setValueAt(this.unControladorVisual.obtenerNetoDelCobrador(unCobrador, year, i), i, 4);
            modelo.setValueAt((this.unUtilitario.getMonth(i)).toUpperCase(), i, 0);
        }
        this.tblListado.setModel(modelo);
    }
    
    private void cargarTablaListadoMesArea(){
        Area unArea = (Area)this.cmbCartera.getSelectedItem();
        Cobrador unCobrador =(Cobrador) this.cmbCobradores.getSelectedItem();
        int year = Integer.parseInt(this.tfYear.getText());
        DefaultTableModel modelo = (DefaultTableModel) this.tblListado.getModel(); 
        for(int i=0; i<=11; i++){
            modelo.setValueAt(this.unControladorVisual.obtenerListadoDelCobrador(unCobrador, year, i,unArea), i, 1);
            modelo.setValueAt(this.unControladorVisual.obtenerAfiliadoDelCobrador(unCobrador, year, i,unArea), i, 2);
            modelo.setValueAt(this.unControladorVisual.obtenerComisionDelCobrador(unCobrador, year, i,unArea), i, 3);
            modelo.setValueAt(this.unControladorVisual.obtenerNetoDelCobrador(unCobrador, year, i,unArea), i, 4);
            modelo.setValueAt((this.unUtilitario.getMonth(i)).toUpperCase(), i, 0);
        }
        this.tblListado.setModel(modelo);
    }
    
    private void cargarTablaListadoPorArea(){
        Area unArea = (Area) this.cmbCartera.getSelectedItem();
        int year = Integer.parseInt(this.tfYear.getText());
        DefaultTableModel modelo = (DefaultTableModel) this.tblListado.getModel(); 
        for(int i=0; i<=11; i++){
            modelo.setValueAt(this.unControladorVisual.obtenerListadoMesArea(year, i,unArea), i, 1);
            modelo.setValueAt(this.unControladorVisual.obtenerAfiliadoMesArea( year, i,unArea), i, 2);
            modelo.setValueAt(this.unControladorVisual.obtenerComisionMesArea( year, i,unArea), i, 3);
            modelo.setValueAt(this.unControladorVisual.obtenerNetoMesArea(year, i,unArea), i, 4);
            modelo.setValueAt((this.unUtilitario.getMonth(i)).toUpperCase(), i, 0);
        }
        this.tblListado.setModel(modelo);
    }
    
    private void cargarTablaListadoMesYear(){
        int year = Integer.parseInt(this.tfYear.getText());
        DefaultTableModel modelo = (DefaultTableModel) this.tblListado.getModel(); 
        for(int i=0; i<=11; i++){
            modelo.setValueAt(this.unControladorVisual.obtenerListadoMesYear(year, i), i, 1);
            modelo.setValueAt(this.unControladorVisual.obtenerAfiliadoMesYear( year, i), i, 2);
            modelo.setValueAt(this.unControladorVisual.obtenerComisionMesYear( year, i), i, 3);
            modelo.setValueAt(this.unControladorVisual.obtenerNetoMesYear(year, i), i, 4);
            modelo.setValueAt((this.unUtilitario.getMonth(i)).toUpperCase(), i, 0);
        }
        this.tblListado.setModel(modelo);
    }
    
    private void cargarTablaTotalCobradorPorArea(){
        Cobrador unCobrador =(Cobrador) this.cmbCobradores.getSelectedItem();
        Area unArea = (Area) this.cmbCartera.getSelectedItem();
        int year = Integer.parseInt(this.tfYear.getText());
        DefaultTableModel modelo = (DefaultTableModel) this.tblTotales.getModel(); 
        modelo.setValueAt(this.unControladorVisual.obtenerListadoDelCobrador(unCobrador, year ,unArea), 0, 1);
        modelo.setValueAt(this.unControladorVisual.obtenerAfiliadoDelCobrador(unCobrador, year ,unArea), 0, 2);
        modelo.setValueAt(this.unControladorVisual.obtenerComisionDelCobrador(unCobrador, year,unArea), 0, 3);
        modelo.setValueAt(this.unControladorVisual.obtenerNetoDelCobrador(unCobrador, year,unArea), 0, 4);
        this.tblTotales.setModel(modelo);
    }
    
    private void cargarTablaTotalPorArea(){
        Area unArea = (Area) this.cmbCartera.getSelectedItem();
        int year = Integer.parseInt(this.tfYear.getText());
        DefaultTableModel modelo = (DefaultTableModel) this.tblTotales.getModel(); 
        modelo.setValueAt(this.unControladorVisual.obtenerListadoDeArea(year ,unArea), 0, 1);
        modelo.setValueAt(this.unControladorVisual.obtenerAfiliadoDeArea( year ,unArea), 0, 2);
        modelo.setValueAt(this.unControladorVisual.obtenerComisionDeArea( year,unArea), 0, 3);
        modelo.setValueAt(this.unControladorVisual.obtenerNetoDeArea( year,unArea), 0, 4);
        this.tblTotales.setModel(modelo);
    }
    
    private void cargarTablaTotalYear(){
        int year = Integer.parseInt(this.tfYear.getText());
        DefaultTableModel modelo = (DefaultTableModel) this.tblTotales.getModel(); 
        modelo.setValueAt(this.unControladorVisual.obtenerListadoYear(year), 0, 1);
        modelo.setValueAt(this.unControladorVisual.obtenerAfiliadoYear(year), 0, 2);
        modelo.setValueAt(this.unControladorVisual.obtenerComisionYear(year), 0, 3);
        modelo.setValueAt(this.unControladorVisual.obtenerNetoYear(year), 0, 4);
        this.tblTotales.setModel(modelo);
    }
    
    private void cargarTablaTotalCobradorGeneral(){
        Cobrador unCobrador =(Cobrador) this.cmbCobradores.getSelectedItem();
        int year = Integer.parseInt(this.tfYear.getText());
        DefaultTableModel modelo = (DefaultTableModel) this.tblTotales.getModel(); 
        modelo.setValueAt(this.unControladorVisual.obtenerListadoDelCobrador(unCobrador, year ), 0, 1);
        modelo.setValueAt(this.unControladorVisual.obtenerAfiliadoDelCobrador(unCobrador, year ), 0, 2);
        modelo.setValueAt(this.unControladorVisual.obtenerComisionDelCobrador(unCobrador, year), 0, 3);
        modelo.setValueAt(this.unControladorVisual.obtenerNetoDelCobrador(unCobrador, year), 0, 4);
        this.tblTotales.setModel(modelo);
    }
    
    private void cargarTabla(){
        if(this.isCamposOk()){
            if(!this.cmbCobradores.getSelectedItem().equals("GENERAL")){
                if(this.cmbCartera.getSelectedItem().equals("GENERAL")){
                    this.cargarTablaListadoCobradorGeneral();
                    this.cargarTablaTotalCobradorGeneral();
                }else{
                    this.cargarTablaListadoMesArea();
                    this.cargarTablaTotalCobradorPorArea();
                }
            }else{
                if(!this.cmbCartera.getSelectedItem().equals("GENERAL")){
                    this.cargarTablaListadoPorArea();
                    this.cargarTablaTotalPorArea();
                }else{
                    cargarTablaListadoMesYear();
                    this.cargarTablaTotalYear();
                }
            }
        }
        
    }
    
    public boolean isCamposOk(){
        boolean camposCompletos = true;
        if(this.cmbCartera.getSelectedIndex()==-1){
            camposCompletos= false;
        }
        if(this.cmbCobradores.getSelectedIndex()==-1){
            camposCompletos = false;
        }
        if(this.tfYear.getText().length()==0){
            camposCompletos = false;
        }
        return camposCompletos;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlBuscar = new javax.swing.JPanel();
        lblCobradores = new javax.swing.JLabel();
        cmbCobradores = new javax.swing.JComboBox<>();
        lblYear = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        lblCartera = new javax.swing.JLabel();
        cmbCartera = new javax.swing.JComboBox<>();
        pnlTotales = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTotales = new javax.swing.JTable();
        pnlDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        pnlNuevosDatos = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pnlBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        lblCobradores.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCobradores.setText("COBRADOR:");

        cmbCobradores.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbCobradores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TODOS", "QUINTANA JOSE", "GUTLEBER HUGO", "IVAN INSAURRALDE" }));

        lblYear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblYear.setText("AÑO:");

        tfYear.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        lblCartera.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCartera.setText("CARTERA:");

        cmbCartera.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbCartera.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GENERAL", "AFILIADOS", "SECTOR P." }));

        javax.swing.GroupLayout pnlBuscarLayout = new javax.swing.GroupLayout(pnlBuscar);
        pnlBuscar.setLayout(pnlBuscarLayout);
        pnlBuscarLayout.setHorizontalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCobradores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCobradores, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(lblCartera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbCartera, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(117, Short.MAX_VALUE))
        );
        pnlBuscarLayout.setVerticalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCobradores)
                    .addComponent(cmbCobradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblYear)
                    .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCartera)
                    .addComponent(cmbCartera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlTotales.setBorder(javax.swing.BorderFactory.createTitledBorder("TOTALES"));

        tblTotales.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblTotales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "", "LISTADO ", "INGRESO", "COMISION", "NETO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTotales.setFocusable(false);
        jScrollPane2.setViewportView(tblTotales);
        if (tblTotales.getColumnModel().getColumnCount() > 0) {
            tblTotales.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout pnlTotalesLayout = new javax.swing.GroupLayout(pnlTotales);
        pnlTotales.setLayout(pnlTotalesLayout);
        pnlTotalesLayout.setHorizontalGroup(
            pnlTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTotalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        pnlTotalesLayout.setVerticalGroup(
            pnlTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalesLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlDatos.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("informe"), "DATOS"));

        tblListado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"ENERO", null, null, null, null},
                {"FEBRERO", null, null, null, null},
                {"MARZO", null, null, null, null},
                {"ABRIL", null, null, null, null},
                {"MAYO", null, null, null, null},
                {"JUNIO", null, null, null, null},
                {"JULIO", null, null, null, null},
                {"AGOSTO", null, null, null, null},
                {"SEPTIEMBRE", null, null, null, null},
                {"OCTUBRE", null, null, null, null},
                {"NOVIEMBRE", null, null, null, null},
                {"DICIEMBRE", null, null, null, null}
            },
            new String [] {
                "MES", "LISTADO", "INGRESO", "COMISION", "NETO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblListado);

        javax.swing.GroupLayout pnlDatosLayout = new javax.swing.GroupLayout(pnlDatos);
        pnlDatos.setLayout(pnlDatosLayout);
        pnlDatosLayout.setHorizontalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        pnlDatosLayout.setVerticalGroup(
            pnlDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
        );

        pnlNuevosDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevos Datos"));

        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnImprimir.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnImprimir.setText("IMPRIMIR");

        javax.swing.GroupLayout pnlNuevosDatosLayout = new javax.swing.GroupLayout(pnlNuevosDatos);
        pnlNuevosDatos.setLayout(pnlNuevosDatosLayout);
        pnlNuevosDatosLayout.setHorizontalGroup(
            pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnGuardar)
                .addGap(29, 29, 29)
                .addComponent(btnImprimir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlNuevosDatosLayout.setVerticalGroup(
            pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnImprimir))
                .addGap(0, 2, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlTotales, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNuevosDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDatos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pnlDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlNuevosDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.cargarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JComboBox<String> cmbCartera;
    private javax.swing.JComboBox<String> cmbCobradores;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCartera;
    private javax.swing.JLabel lblCobradores;
    private javax.swing.JLabel lblYear;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlDatos;
    private javax.swing.JPanel pnlNuevosDatos;
    private javax.swing.JPanel pnlTotales;
    private javax.swing.JTable tblListado;
    private javax.swing.JTable tblTotales;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}