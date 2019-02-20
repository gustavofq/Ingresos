package Vista;

import Logica.Area;
import Logica.Cobrador;
import Logica.Cobranza;
import Logica.Ingreso;
import Persistencia.exceptions.NonexistentEntityException;
import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Ingresos extends javax.swing.JInternalFrame implements Sujeto, Observador {
    private Utilitario unUtilitario = new Utilitario();
    private ControladorVisual unControladorVisual = new ControladorVisual();
    private JTableHeader th= new JTableHeader();
    Font fuente = new Font("Dialog", Font.BOLD, 18);
    JLabel mensaje = new JLabel("mensaje");
    private ArrayList<Observador> observadores = new ArrayList<>();
    
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
        btnMarcar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNetoValor = new javax.swing.JLabel();
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
        cmbMes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbMesPropertyChange(evt);
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

        btnMarcar.setText("MARCAR");
        btnMarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarActionPerformed(evt);
            }
        });

        jLabel1.setText("NETO: ");

        javax.swing.GroupLayout pnlNuevosDatosLayout = new javax.swing.GroupLayout(pnlNuevosDatos);
        pnlNuevosDatos.setLayout(pnlNuevosDatosLayout);
        pnlNuevosDatosLayout.setHorizontalGroup(
            pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnMarcar)
                .addGap(458, 458, 458)
                .addComponent(jLabel1)
                .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(44, 44, 44))
                    .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNetoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        pnlNuevosDatosLayout.setVerticalGroup(
            pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                        .addComponent(lblNetoValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24))
                    .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnGuardar)
                                .addComponent(btnMarcar))
                            .addComponent(jLabel1))))
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
        tblIngresos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                tblIngresosMouseDragged(evt);
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
            this.obtenerIngresosAfiliado();
            this.obtenerIngresosSp();
            calcularFilas();
            calcularColumnas();
        }
    }
    
    private void limpiarTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) this.tblIngresos.getModel();
        model.setRowCount(0);
        model.setRowCount(40);
        DefaultTableModel model2 = new DefaultTableModel();
        model2 = (DefaultTableModel) this.tblTotales.getModel();
        model2.setRowCount(0);
        model2.setRowCount(1);
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            this.guardarAfiliadoBis();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error al cargar Afiliados.");
            Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try{
            this.guardarSPBis();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane, "Ocurrió un error al cargar Sector Protegido.");
            Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.actualizarTablas();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbCobradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCobradoresActionPerformed
        inicializarTablas();
    }//GEN-LAST:event_cmbCobradoresActionPerformed
 
    private void inicializarTablas(){
        if(this.tfYear.getText().length() != 0){
            Area unArea = unArea = this.unControladorVisual.obtenerAreaPorNombre("Afiliados");
            Cobrador unCobrador = (Cobrador) this.cmbCobradores.getSelectedItem();
            int mes = this.cmbMes.getMonth();
            int year = Integer.parseInt(this.tfYear.getText());
            if((this.unControladorVisual.existeCobranza(unCobrador, year, mes, unArea))||(this.unControladorVisual.existeCobranza(unCobrador, year, mes, this.unControladorVisual.obtenerAreaPorNombre("Sector Protegido")))){
                this.limpiarTabla();
                this.actualizarTablas();
            }else{
                DefaultTableModel model = new DefaultTableModel();
                model = (DefaultTableModel) this.tblIngresos.getModel();
                model.setRowCount(0);
                DefaultTableModel model2 = new DefaultTableModel();
                model2 = (DefaultTableModel) this.tblTotales.getModel();
                model2.setRowCount(0);
                this.mensaje.setText("No existe listado para el cobrador " + unCobrador +" del mes " + this.unUtilitario.getMonth(mes)+ " del año " + year);
                JOptionPane.showMessageDialog(null,this.mensaje,"No hay listado.",JOptionPane.INFORMATION_MESSAGE);
            }
        } 
    }
    
    private void tfYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfYearActionPerformed
        inicializarTablas();
    }//GEN-LAST:event_tfYearActionPerformed

    private void btnMarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarActionPerformed
        this.tblIngresos.setDefaultRenderer(Object.class, new RenderCelda(this.tblIngresos.getSelectedRow(),1));
    }//GEN-LAST:event_btnMarcarActionPerformed

    private void cmbMesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbMesPropertyChange
       inicializarTablas();
    }//GEN-LAST:event_cmbMesPropertyChange

    private void tblIngresosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIngresosMouseDragged
        Double total = 0.0;
        for(int i = 0; i<this.tblIngresos.getSelectedRowCount();i++){
            total += Double.parseDouble(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,7).toString());
        }
        this.lblNetoValor.setText(String.valueOf(total));
    }//GEN-LAST:event_tblIngresosMouseDragged

    private void guardarAfiliadoBis() throws ParseException{
        DefaultTableModel model = (DefaultTableModel)this.tblIngresos.getModel();
        Area unArea = unArea = this.unControladorVisual.obtenerAreaPorNombre("Afiliados");
        Cobrador unCobrador = (Cobrador) this.cmbCobradores.getSelectedItem();
        int mes = this.cmbMes.getMonth();
        int year = Integer.parseInt(this.tfYear.getText());
        try {
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
                            if(importe.equals(0)|| importe == null){
                                this.unControladorVisual.borrarIngreso(unCobranza, oldIngreso);
                            }else{
                                this.unControladorVisual.modificarIngreso(unCobranza, oldIngreso, newIngreso);
                            }
                        }
                    }else{
                        Ingreso unIngreso = new Ingreso(importe,concepto, fecha, i);
                        this.unControladorVisual.agregarIngreso(unCobranza, unIngreso);
                    }
                }
            }
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
            this.mensaje.setText("No existe listado para el cobrador " + unCobrador +" del mes " + this.unUtilitario.getMonth(mes)+ " del año " + year+ " correspondiente a la cartera " + unArea.getNombre());
            JOptionPane.showMessageDialog(null,this.mensaje,"No hay listado.",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private void guardarSPBis() throws ParseException{
        DefaultTableModel model = (DefaultTableModel)this.tblIngresos.getModel();
        Area unArea = unArea = this.unControladorVisual.obtenerAreaPorNombre("Sector Protegido");
        Cobrador unCobrador = (Cobrador) this.cmbCobradores.getSelectedItem();
        int mes = this.cmbMes.getMonth();
        int year = Integer.parseInt(this.tfYear.getText());
        try {
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
                            if(importe.equals(0)|| importe == null){
                                this.unControladorVisual.borrarIngreso(unCobranza, oldIngreso);
                            }else{
                                this.unControladorVisual.modificarIngreso(unCobranza, oldIngreso, newIngreso);
                            }
                        }
                    }else{
                        Ingreso unIngreso = new Ingreso(importe,concepto, fecha, i);
                        this.unControladorVisual.agregarIngreso(unCobranza, unIngreso);
                    }
                }
            }
        } catch (NonexistentEntityException ex) {
            if(unArea.getNombre().equals("Sector Protegido")){
                Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
                this.mensaje.setText("No existe listado para el cobrador " + unCobrador +" del mes " + this.unUtilitario.getMonth(mes)+ " del año " + year+ " correspondiente a la cartera " + unArea.getNombre());
                JOptionPane.showMessageDialog(null,this.mensaje,"No hay listado.",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnMarcar;
    private javax.swing.JComboBox<String> cmbCobradores;
    private com.toedter.calendar.JMonthChooser cmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCobrador;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNetoValor;
    private javax.swing.JLabel lblYear;
    private javax.swing.JPanel pnlBuscar;
    private javax.swing.JPanel pnlNuevosDatos;
    private javax.swing.JPanel pnlTablas;
    private javax.swing.JTable tblIngresos;
    private javax.swing.JTable tblTotales;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables

    @Override
    public void notificar() {
        for(Observador unObservador : observadores){
            unObservador.update();
        }
    }

    @Override
    public void suscribirObservador(Observador o) {
        this.observadores.add(o);
    }

    @Override
    public void update() {
        //this.actualizarTablas();
    }
}
