package Vista;

import Logica.Area;
import Logica.Cobrador;
import Logica.Cobranza;
import Logica.Ingreso;
import Persistencia.exceptions.NonexistentEntityException;
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
    int veces = 0;
    public Ingresos() {
        initComponents();
        //this.marcarPagado();
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
        lblNetoValor = new javax.swing.JLabel();
        lblComisionSP = new javax.swing.JLabel();
        lblSP = new javax.swing.JLabel();
        lblComisionAF = new javax.swing.JLabel();
        lblAfiliado = new javax.swing.JLabel();
        lblComisionT = new javax.swing.JLabel();
        lblNeto = new javax.swing.JLabel();
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

        btnMarcar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnMarcar.setText("MARCAR");
        btnMarcar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMarcarMouseClicked(evt);
            }
        });
        btnMarcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcarActionPerformed(evt);
            }
        });

        lblNetoValor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNetoValor.setText("0.0");

        lblComisionSP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblComisionSP.setText("0.0");

        lblSP.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblSP.setText("0.0");

        lblComisionAF.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblComisionAF.setText("0.0");

        lblAfiliado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblAfiliado.setText("0.0");

        lblComisionT.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblComisionT.setText("0.0");

        lblNeto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblNeto.setText("0.0");

        javax.swing.GroupLayout pnlNuevosDatosLayout = new javax.swing.GroupLayout(pnlNuevosDatos);
        pnlNuevosDatos.setLayout(pnlNuevosDatosLayout);
        pnlNuevosDatosLayout.setHorizontalGroup(
            pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnMarcar)
                .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlNuevosDatosLayout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(lblAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(lblComisionAF, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(lblSP, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblComisionSP, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNetoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblComisionT, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        pnlNuevosDatosLayout.setVerticalGroup(
            pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNuevosDatosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnMarcar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNuevosDatosLayout.createSequentialGroup()
                .addGroup(pnlNuevosDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblComisionSP)
                    .addComponent(lblSP)
                    .addComponent(lblComisionAF)
                    .addComponent(lblAfiliado)
                    .addComponent(lblNetoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblComisionT)
                    .addComponent(lblNeto))
                .addGap(2, 2, 2)
                .addComponent(btnGuardar))
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

    private void cmbMesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbMesPropertyChange
       inicializarTablas();
    }//GEN-LAST:event_cmbMesPropertyChange

    private void tblIngresosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIngresosMouseDragged
        Double afiliado = 0.0;
        Double comAf = 0.0;
        Double sp = 0.0;
        Double comSp = 0.0;
        Double cobranzaTotal = 0.0;
        Double comisionTotal = 0.0;
        Double neto = 0.0;
        for(int i = 0; i<this.tblIngresos.getSelectedRowCount();i++){
            if(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,2)!= null){
                afiliado += Double.parseDouble(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,2).toString());
            }else{
                afiliado+=0.0;
            }
            if(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,3)!= null){
                comAf += Double.parseDouble(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,3).toString());
            }else{
                comAf+=0.0;
            }
            if(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,4)!= null){
                sp += Double.parseDouble(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,4).toString());
            }else{
                sp+=0.0;
            }
            if(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,5)!= null){
                comSp += Double.parseDouble(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,5).toString());
            }else{
                comSp+=0.0;
            }
            if(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,6)!= null){
                cobranzaTotal += Double.parseDouble(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,6).toString());
            }else{
                cobranzaTotal+=0.0;
            }
            if(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,7)!= null){
                comisionTotal += Double.parseDouble(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,7).toString());
            }else{
                comisionTotal+=0.0;
            }
            if(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,8)!= null){
                neto += Double.parseDouble(this.tblIngresos.getValueAt(this.tblIngresos.getSelectedRows()[i] ,8).toString());
            }else{
                neto+=0.0;
            }
        }
        this.lblAfiliado.setText(String.valueOf(afiliado));
        this.lblComisionAF.setText(String.valueOf(comAf));
        this.lblSP.setText(String.valueOf(sp));
        this.lblComisionSP.setText(String.valueOf(comSp));
        this.lblNetoValor.setText(String.valueOf(cobranzaTotal));
        this.lblComisionT.setText(String.valueOf(comisionTotal));
        this.lblNeto.setText(String.valueOf(neto));
        
    }//GEN-LAST:event_tblIngresosMouseDragged

    private void btnMarcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcarActionPerformed
        this.marcarPagado();
    }//GEN-LAST:event_btnMarcarActionPerformed

    private void btnMarcarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMarcarMouseClicked

    }//GEN-LAST:event_btnMarcarMouseClicked

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

    private void marcarPagado(){
        int fila = this.tblIngresos.getSelectedRow();
        if(tblIngresos.getValueAt(fila, 0) != null){
            if(tblIngresos.getValueAt(fila, 1) != null){
            if(this.tblIngresos.getSelectedRow()!= -1){
                if(!(tblIngresos.getValueAt(fila, 1).toString()).contains("(pagado)")){
                    String texto = this.tblIngresos.getValueAt(fila, 1).toString();
                    this.tblIngresos.setValueAt(texto+"(pagado)", fila, 1); 
                }else{
                    String texto = this.tblIngresos.getValueAt(fila, 1).toString();
                    String sinTexto = texto.replace("(pagado)", "");
                    this.tblIngresos.setValueAt(sinTexto, fila, 1); 
                }
            }
        }else{
            this.tblIngresos.setValueAt("(pagado)", fila, 1);
        }
        }
        
    }      
    
    
    private Ingreso gestionarPagos(Ingreso unIngreso, int fila){
        Ingreso otroIngreso = new Ingreso();
        otroIngreso= unIngreso;
        if((tblIngresos.getValueAt(fila, 1).toString()).contains("(pagado)")){
            if(!otroIngreso.isPagado()){
                otroIngreso.pagar();
            }
        }else{
            if(otroIngreso.isPagado()){
                otroIngreso.noPagar();
            }
        }
        return otroIngreso;
    }
    
    
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
                    Calendar fecha = Calendar.getInstance();
                    try{
                        fecha = this.unUtilitario.obtenerFecha((this.tblIngresos.getValueAt(i, 0)).toString());
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
                                newIngreso = this.gestionarPagos(newIngreso, i);
                                if(importe.equals(0)|| importe == null){
                                    this.unControladorVisual.borrarIngreso(unCobranza, oldIngreso);
                                }else{
                                    this.unControladorVisual.modificarIngreso(unCobranza, oldIngreso, newIngreso);
                                }
                            }
                        }else{
                            Ingreso unIngreso = new Ingreso(importe,concepto, fecha, i);
                            unIngreso = this.gestionarPagos(unIngreso, i);
                            this.unControladorVisual.agregarIngreso(unCobranza, unIngreso);
                        }
                    }catch(ParseException ex){
                        this.mensaje.setText("El formato de la fecha " + (this.tblIngresos.getValueAt(i, 0)).toString() + " es incorrecta, deberia ser (dd/mm/yyyy) ej: 1/2/2019" );
                        JOptionPane.showMessageDialog(null,this.mensaje,"Formato de fecha incorrecta.",JOptionPane.INFORMATION_MESSAGE); 
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
                    Calendar fecha = Calendar.getInstance();
                    try {
                        fecha = this.unUtilitario.obtenerFecha((this.tblIngresos.getValueAt(i, 0)).toString());
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
                                newIngreso = this.gestionarPagos(newIngreso, i);
                                if(importe.equals(0)|| importe == null){
                                    this.unControladorVisual.borrarIngreso(unCobranza, oldIngreso);
                                }else{
                                    this.unControladorVisual.modificarIngreso(unCobranza, oldIngreso, newIngreso);
                                }
                            }   
                        }else{
                            Ingreso unIngreso = new Ingreso(importe,concepto, fecha, i);
                            unIngreso= this.gestionarPagos(unIngreso, i);
                            this.unControladorVisual.agregarIngreso(unCobranza, unIngreso);
                        }
                    }catch (ParseException ex){
                        this.mensaje.setText("El formato de la fecha " + (this.tblIngresos.getValueAt(i, 0)).toString() + " es incorrecta, deberia ser (dd/mm/yyyy) ej: 1/2/2019" );
                        JOptionPane.showMessageDialog(null,this.mensaje,"Formato de fecha incorrecta.",JOptionPane.INFORMATION_MESSAGE);  
                    }
                }
            }
        }catch (NonexistentEntityException ex) {
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAfiliado;
    private javax.swing.JLabel lblCobrador;
    private javax.swing.JLabel lblComisionAF;
    private javax.swing.JLabel lblComisionSP;
    private javax.swing.JLabel lblComisionT;
    private javax.swing.JLabel lblMes;
    private javax.swing.JLabel lblNeto;
    private javax.swing.JLabel lblNetoValor;
    private javax.swing.JLabel lblSP;
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
