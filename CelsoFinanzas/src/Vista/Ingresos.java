package Vista;

import Logica.Area;
import Logica.Cobrador;
import Logica.Cobranza;
import Logica.Ingreso;
import java.awt.Font;
import java.text.ParseException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Ingresos extends javax.swing.JInternalFrame {
    private Utilitario unUtilitario = new Utilitario();
    private ControladorVisual unControladorVisual = new ControladorVisual();
    private JTableHeader th= new JTableHeader();
    Font fuente = new Font("Dialog", Font.BOLD, 18);
    JLabel mensaje = new JLabel("mensaje");
    
    public Ingresos() {
        initComponents();
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), cmbCobradores);
        this.unUtilitario.cargarMesActual(cmbMes);
        this.unUtilitario.cargarAnhoActual(tfYear);
        th = this.tblIngresos.getTableHeader();
        th.setFont(fuente);
        this.tblIngresos.setTableHeader(th);
        th = this.tblTotales.getTableHeader();
        th.setFont(fuente);
        this.tblTotales.setTableHeader(th);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlBuscar = new javax.swing.JPanel();
        cmbCobradores = new javax.swing.JComboBox<>();
        lblCobrador = new javax.swing.JLabel();
        lblMes = new javax.swing.JLabel();
        cmbMes = new com.toedter.calendar.JMonthChooser();
        lblYear = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        pnlNuevosDatos = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        pnlTablas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIngresos = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTotales = new javax.swing.JTable();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        pnlBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));

        cmbCobradores.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbCobradores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "QUINTANA JOSE", "GUTLEBER HUGO", "IVAN INSAURRALDE" }));
        cmbCobradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCobradoresActionPerformed(evt);
            }
        });

        lblCobrador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblCobrador.setText("COBRADOR:");

        lblMes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblMes.setText("MES:");

        cmbMes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cmbMes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmbMesMouseClicked(evt);
            }
        });

        lblYear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblYear.setText("AÑO:");

        tfYear.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBuscarLayout = new javax.swing.GroupLayout(pnlBuscar);
        pnlBuscar.setLayout(pnlBuscarLayout);
        pnlBuscarLayout.setHorizontalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCobrador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCobradores, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(lblMes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblYear)
                .addGap(18, 18, 18)
                .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBuscarLayout.setVerticalGroup(
            pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBuscarLayout.createSequentialGroup()
                .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCobradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCobrador)
                        .addComponent(lblMes))
                    .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnlBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblYear)
                            .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnlNuevosDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevos Datos"));

        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlNuevosDatosLayout = new javax.swing.GroupLayout(pnlNuevosDatos);
        pnlNuevosDatos.setLayout(pnlNuevosDatosLayout);
        pnlNuevosDatosLayout.setHorizontalGroup(
            pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(44, 44, 44))
        );
        pnlNuevosDatosLayout.setVerticalGroup(
            pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnGuardar)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        tblIngresos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblIngresos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "FECHA", "CONCEPTO", "AFILIADO", "COMISION AF.", "SP.", "COMISION SP.", "COBRANZA T.", "COMISION T.", "NETO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblIngresos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblIngresosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblIngresos);
        if (tblIngresos.getColumnModel().getColumnCount() > 0) {
            tblIngresos.getColumnModel().getColumn(8).setResizable(false);
        }

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("TOTALES"));

        tblTotales.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblTotales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "COB. NETO. AF", "COB. NETO SP.", "AFILIADO", "COMISION AF.", "SP", "COMISION SP.", "COBRANZA T.", "COMISION T.", "NETO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTotales);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlTablasLayout = new javax.swing.GroupLayout(pnlTablas);
        pnlTablas.setLayout(pnlTablasLayout);
        pnlTablasLayout.setHorizontalGroup(
            pnlTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablasLayout.createSequentialGroup()
                .addGroup(pnlTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1328, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlTablasLayout.setVerticalGroup(
            pnlTablasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTablasLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlNuevosDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(pnlTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTablas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlNuevosDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isCamposOk(){
        boolean camposOk = true;
        if(this.cmbCobradores.getSelectedIndex() == -1){
            camposOk= false;
        }
        if(this.tfYear.getText().length() == 0){
            camposOk = false;
        }
        return camposOk;
    }
    
    public void actualizarTablas(){
        if(this.isCamposOk()){
            limpiarTabla();
            this.obtenerIngresosAfiliado();
            this.obtenerIngresosSp();
            calcularFilas();
            calcularColumnas();
        }
    }
    
    private void limpiarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) this.tblIngresos.getModel();
        int fila = this.tblIngresos.getRowCount();
        for (int i = 0; i < fila ; i++){
            model.removeRow(0);
        }
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            this.guardarAfiliadoBis();
            this.guardarSPBis();
            this.actualizarTablas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "");
            Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbCobradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCobradoresActionPerformed
        
    }//GEN-LAST:event_cmbCobradoresActionPerformed
 
    private void tfYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfYearActionPerformed
       this.actualizarTablas();
    }//GEN-LAST:event_tfYearActionPerformed

    private void cmbMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbMesMouseClicked
        
    }//GEN-LAST:event_cmbMesMouseClicked

    private void tblIngresosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblIngresosKeyReleased
        calcularFilas();
        calcularColumnas();
    }//GEN-LAST:event_tblIngresosKeyReleased

    
    
    private void guardarAfiliadoBis() throws ParseException, Exception{
        DefaultTableModel model = (DefaultTableModel)this.tblIngresos.getModel();
        Area unArea = unArea = this.unControladorVisual.obtenerAreaPorNombre("Afiliados");
        Cobrador unCobrador = (Cobrador) this.cmbCobradores.getSelectedItem();
        int mes = this.cmbMes.getMonth();
        int year = Integer.parseInt(this.tfYear.getText());
        Cobranza unCobranza = this.unControladorVisual.obtenerCobranza(unCobrador, year, mes, unArea);
        for(int i = 0; i< this.tblIngresos.getRowCount();i++){
            if(model.getValueAt(i, 2)!= null){
                Double importe = Double.parseDouble(model.getValueAt(i, 2).toString());
                Calendar fecha = this.unUtilitario.obtenerFecha((this.tblIngresos.getValueAt(i, 0)).toString());
                 String concepto = "";
                if((this.tblIngresos.getValueAt(i, 1))!= null){
                    concepto = this.controlarConcepto((this.tblIngresos.getValueAt(i, 1)).toString());
                }else{
                    concepto= "-";
                }
                Ingreso oldIngreso = this.unControladorVisual.obtenerIngreso(unCobrador, year, mes, unArea, i);
                Ingreso newIngreso = oldIngreso;
                newIngreso.setAfiliado(importe);
                newIngreso.setConcepto(concepto);
                newIngreso.setFecha(fecha);
                oldIngreso = this.unControladorVisual.obtenerIngreso(unCobrador, year, mes, unArea, i);
                if(oldIngreso.getFecha() != null){
                     if(!oldIngreso.equals(newIngreso)){
                        this.unControladorVisual.modificarIngreso(unCobranza, oldIngreso, newIngreso);
                     }
                }else{
                    Ingreso unIngreso = new Ingreso(importe,concepto, fecha, i);
                    this.unControladorVisual.agregarIngreso(unCobranza, unIngreso);
                }   
            }
        }
    }
    
    public String controlarConcepto(String text){
        String otroText = "";
        if((text.length() == 0) || (text == null)){
            otroText = "-";
        }else{
            otroText = text;
        }
        return otroText;
    }
    
    private void guardarSPBis() throws ParseException, Exception{
        DefaultTableModel model = (DefaultTableModel)this.tblIngresos.getModel();
        Area unArea = unArea = this.unControladorVisual.obtenerAreaPorNombre("Sector Protegido");
        Cobrador unCobrador = (Cobrador) this.cmbCobradores.getSelectedItem();
        int mes = this.cmbMes.getMonth();
        int year = Integer.parseInt(this.tfYear.getText());
        Cobranza unCobranza = this.unControladorVisual.obtenerCobranza(unCobrador, year, mes, unArea);
        for(int i = 0; i< this.tblIngresos.getRowCount();i++){
            if(model.getValueAt(i, 4)!= null){
                Double importe = Double.parseDouble(model.getValueAt(i, 4).toString());
                Calendar fecha = this.unUtilitario.obtenerFecha((this.tblIngresos.getValueAt(i, 0)).toString());
                String concepto = "";
                if((this.tblIngresos.getValueAt(i, 1))!= null){
                    concepto = this.controlarConcepto((this.tblIngresos.getValueAt(i, 1)).toString());
                }else{
                    concepto= "-";
                }
                Ingreso oldIngreso = this.unControladorVisual.obtenerIngreso(unCobrador, year, mes, unArea, i);
                Ingreso newIngreso = oldIngreso;
                newIngreso.setAfiliado(importe);
                newIngreso.setConcepto(concepto);
                newIngreso.setFecha(fecha);
                oldIngreso = this.unControladorVisual.obtenerIngreso(unCobrador, year, mes, unArea, i);
                if(oldIngreso.getFecha() != null){
                     if(!oldIngreso.equals(newIngreso)){
                        this.unControladorVisual.modificarIngreso(unCobranza, oldIngreso, newIngreso);
                     }
                }else{
                    Ingreso unIngreso = new Ingreso(importe,concepto, fecha, i);
                    this.unControladorVisual.agregarIngreso(unCobranza, unIngreso);
                }   
            }
        }
    }
    
    private void obtenerIngresosAfiliado(){
        Cobrador unCobrador = (Cobrador)this.cmbCobradores.getSelectedItem();
        Area unArea = this.unControladorVisual.obtenerAreaPorNombre("Afiliados");
        int year = Integer.parseInt(tfYear.getText());
        int mes = this.cmbMes.getMonth();
        int fila = 0;
        DefaultTableModel model = (DefaultTableModel) this.tblIngresos.getModel();
        for(Ingreso unIngreso: this.unControladorVisual.obtenerIngresos(unCobrador, year, mes , unArea)){
            fila = unIngreso.getFila();
            model.setValueAt(this.unUtilitario.obtenerFecha(unIngreso.getFecha()), fila, 0);
            if(!unIngreso.getConcepto().equals("-")){
                model.setValueAt(unIngreso.getConcepto(), fila, 1);
            }
            model.setValueAt(unIngreso.getAfiliado(), fila, 2);
            model.setValueAt((unCobrador.getUnaComision() * unIngreso.getAfiliado())/100 , fila, 3);      
        }
        this.tblIngresos.setModel(model);
    }
   
    public void obtenerIngresosSp(){
        Cobrador unCobrador = (Cobrador)this.cmbCobradores.getSelectedItem();
        Area unArea = this.unControladorVisual.obtenerAreaPorNombre("Sector Protegido");
        int year = Integer.parseInt(tfYear.getText());
        int mes = this.cmbMes.getMonth();
        int fila = 0;
        DefaultTableModel model = (DefaultTableModel) this.tblIngresos.getModel();
        for(Ingreso unIngreso: this.unControladorVisual.obtenerIngresos(unCobrador, year, mes , unArea)){
            fila = unIngreso.getFila();
            model.setValueAt(this.unUtilitario.obtenerFecha(unIngreso.getFecha()), fila, 0);
            if(!unIngreso.getConcepto().equals("-")){
                model.setValueAt(unIngreso.getConcepto(), fila, 1);
            }
            model.setValueAt(unIngreso.getAfiliado(), fila, 4);
            model.setValueAt((unCobrador.getUnaComision() * unIngreso.getAfiliado())/100 , fila, 5);      
        }
        this.tblIngresos.setModel(model);
    }
    
    private Double controlarValores(Object valor){
        Double otroValor = 0.0;
        if(valor != null){
           otroValor = Double.parseDouble(valor.toString());
        }
        return otroValor;
    }
    
    private void calcularFilas(){
        DefaultTableModel model = (DefaultTableModel) this.tblIngresos.getModel();
        for(int i = 0; i < model.getRowCount(); i++ ){
            Double afiliado = controlarValores(model.getValueAt(i, 2));
            Double sp = controlarValores(model.getValueAt(i, 4));
            Double comisionAF = controlarValores(model.getValueAt(i, 3));
            Double comisionSP = controlarValores(model.getValueAt(i, 5));
            Double neto = (afiliado+sp)- (comisionAF+comisionSP);
            model.setValueAt(afiliado+sp, i, 6);
            model.setValueAt(comisionAF+comisionSP, i, 7);
            model.setValueAt(neto, i, 8);   
        }
        this.tblIngresos.setModel(model);
    }
    
    private void calcularColumnas(){
        DefaultTableModel model = (DefaultTableModel) this.tblIngresos.getModel();
        DefaultTableModel total = (DefaultTableModel) this.tblTotales.getModel();
        Double afiliado = 0.0;
        Double sp = 0.0;
        Double comisionAF = 0.0;
        Double comisionSP = 0.0;
        Double neto = 0.0;
        Double cobTota= 0.0;
        Double comTota = 0.0;
        for(int i = 0; i < model.getRowCount(); i++ ){
            afiliado += controlarValores(model.getValueAt(i, 2));
            comisionAF += controlarValores(model.getValueAt(i, 3));
            sp += controlarValores(model.getValueAt(i, 4));
            comisionSP += controlarValores(model.getValueAt(i, 5));
            cobTota += controlarValores(model.getValueAt(i, 6));
            comTota += controlarValores(model.getValueAt(i, 7));
            neto +=controlarValores(model.getValueAt(i, 8));
        }
        total.setValueAt(afiliado-comisionAF, 0, 0);
        total.setValueAt(sp-comisionSP, 0, 1);
        total.setValueAt(afiliado, 0, 2);
        total.setValueAt(comisionAF, 0, 3);
        total.setValueAt(sp, 0, 4);
        total.setValueAt(comisionSP, 0, 5);
        total.setValueAt(cobTota, 0, 6);
        total.setValueAt(comTota, 0, 7);
        total.setValueAt(neto, 0, 8);
        this.tblTotales.setModel(total);
    }
     
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCobradores;
    private com.toedter.calendar.JMonthChooser cmbMes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCobrador;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblYear;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlNuevosDatos;
    private javax.swing.JPanel pnlTablas;
    private javax.swing.JTable tblIngresos;
    private javax.swing.JTable tblTotales;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}
