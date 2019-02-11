package Vista;

import Logica.Area;
import Logica.Cobrador;
import Logica.Cobranza;
import Logica.Ingreso;
import java.awt.Font;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

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
        th= this.tblIngresos.getTableHeader();
        th.setFont(fuente);
        this.tblIngresos.setTableHeader(th);
        th= this.tblTotales.getTableHeader();
        th.setFont(fuente);
        this.tblTotales.setTableHeader(th);
        this.carcarFechas();
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerAreas(), this.cmbCarteras);
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
        jLabel1 = new javax.swing.JLabel();
        tfIngreso = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbCarteras = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        btnGuardar = new javax.swing.JButton();
        tfConcepto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
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

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("INGRESO:");

        tfIngreso.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("CARTERA:");

        cmbCarteras.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbCarteras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("FECHA:");

        dcFecha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tfConcepto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("CONCEPTO:");

        javax.swing.GroupLayout pnlNuevosDatosLayout = new javax.swing.GroupLayout(pnlNuevosDatos);
        pnlNuevosDatos.setLayout(pnlNuevosDatosLayout);
        pnlNuevosDatosLayout.setHorizontalGroup(
            pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCarteras, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(44, 44, 44))
        );
        pnlNuevosDatosLayout.setVerticalGroup(
            pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnGuardar)
                        .addComponent(tfConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(tfIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cmbCarteras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))))
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
            this.unUtilitario.LimpiarTabla(this.tblIngresos);
            this.unUtilitario.LimpiarTabla(this.tblTotales);
            this.carcarFechas();
            this.obtenerIngresosAfiliado();
            this.obtenerIngresosSp();
            calcularFilas();
            calcularColumnas();
        }
    }
    
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        Double importe = Double.parseDouble(this.tfIngreso.getText());
        Calendar fecha = this.dcFecha.getCalendar();
        Area unArea = (Area)this.cmbCarteras.getSelectedItem();
        Cobrador unCobrador = (Cobrador) this.cmbCobradores.getSelectedItem();
        int mes = this.cmbMes.getMonth();
        int year = Integer.parseInt(this.tfYear.getText());
        Cobranza unCobranza = this.unControladorVisual.obtenerCobranza(unCobrador, year, mes, unArea);
        Ingreso unIngreso = new Ingreso(importe,controlarConcepto(this.tfConcepto.getText()), fecha);
        try {
            this.unControladorVisual.agregarIngreso(unCobranza, unIngreso);
            this.actualizarTablas();
        } catch (Exception ex) {
            Logger.getLogger(Ingresos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void cmbCobradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCobradoresActionPerformed
        //this.actualizarTablas();
    }//GEN-LAST:event_cmbCobradoresActionPerformed

    private String controlarConcepto(String texto){
        String otroConcepto = "-";
        if(this.tfConcepto.getText().length()!=0){
           otroConcepto = texto;
        }
        return otroConcepto;
    }
    
    private void tfYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfYearActionPerformed
       this.actualizarTablas();
    }//GEN-LAST:event_tfYearActionPerformed

    private void cmbMesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbMesMouseClicked
        //actualizarTablas();
    }//GEN-LAST:event_cmbMesMouseClicked

    public void carcarFechas(){
        Cobrador unCobrador =(Cobrador) this.cmbCobradores.getSelectedItem();
        int mes = this.cmbMes.getMonth();
        int year = Integer.parseInt(this.tfYear.getText());
        DefaultTableModel modelo = (DefaultTableModel) this.tblIngresos.getModel(); //GENERO UN NUEVO TABLE MODEL.. AL CUAL LE ASIGNO EL MODELO DE LA TABLA QUE CARGAMOS
        int filas = tblIngresos.getRowCount(); ///GENERO UN INDICE PARA SABER CUANTAS FILAS TIENE MI TABLA
        for (int i = 0; i < filas; i++) {    ////RECORRO EL INDICE A TRAVES DE UN CICLO FOR
            modelo.removeRow(0);   /////DE ESTA MANERA VOY QUITANDO EL SIEMPRE LA PRIMER FILA DEL MODELO...ESTO UNA VEZ FINALIZADO EL RECORRIDO DEL FOR NOS 								     
        }		
        Object[] fila = new Object[1];   ///GENERO UN VECTOR DE TIPO OBJECT DADO QUE EN EL VOY A CARGAR DISTINTOS TIPOS DE DATOS
            for (Calendar unCalendar: this.unControladorVisual.obtenerFechas(unCobrador, year, mes)) { ///RECORRO LA LISTA UTILIZANDO UN FOR EACH
                fila[0] = this.unUtilitario.obtenerFecha(unCalendar);
                modelo.addRow(fila);  ////AGREGO A MI MODELO UNA FILA (ES IMPORTANTE SABER QUE CADA VECTOR ES UNA FILA DA LA TABLA)
            }
        tblIngresos.setModel(modelo); 
    } 
    
    private void obtenerIngresosAfiliado(){
        Cobrador unCobrador = (Cobrador)this.cmbCobradores.getSelectedItem();
        Area unArea = this.unControladorVisual.obtenerAreaPorNombre("Afiliados");
        int year = Integer.parseInt(tfYear.getText());
        int mes = this.cmbMes.getMonth();
        DefaultTableModel model = (DefaultTableModel) this.tblIngresos.getModel();
        for(int i = 0; i < model.getRowCount(); i++ ){
            for(Ingreso unIngreso: this.unControladorVisual.obtenerIngresos(unCobrador, year, mes , unArea)){
                if(this.unUtilitario.obtenerFecha(unIngreso.getFecha()).equals(model.getValueAt(i, 0))){
                    model.setValueAt(unIngreso.getConcepto(), i, 1);
                    model.setValueAt(unIngreso.getAfiliado(), i, 2);
                    model.setValueAt((unCobrador.getUnaComision() * unIngreso.getAfiliado())/100 , i, 3);
                }
            }
        }
        this.tblIngresos.setModel(model);
    }
    
    public void obtenerIngresosSp(){
        Cobrador unCobrador = (Cobrador)this.cmbCobradores.getSelectedItem();
        Area unArea = this.unControladorVisual.obtenerAreaPorNombre("Sector Protegido");
        int year = Integer.parseInt(tfYear.getText());
        int mes = this.cmbMes.getMonth();
        DefaultTableModel model = (DefaultTableModel) this.tblIngresos.getModel();
        for(int i = 0; i < model.getRowCount(); i++ ){
            for(Ingreso unIngreso: this.unControladorVisual.obtenerIngresos(unCobrador, year, mes , unArea)){
                if(this.unUtilitario.obtenerFecha(unIngreso.getFecha()).equals(model.getValueAt(i, 0))){
                    model.setValueAt(unIngreso.getAfiliado(), i, 4);
                    model.setValueAt((unCobrador.getUnaComision() * unIngreso.getAfiliado())/100 , i, 5);
                }
            }
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
    private javax.swing.JComboBox<String> cmbCarteras;
    private javax.swing.JComboBox<String> cmbCobradores;
    private com.toedter.calendar.JMonthChooser cmbMes;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JTextField tfConcepto;
    private javax.swing.JTextField tfIngreso;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}
