package Vista;

import Logica.Convenio;
import Logica.Produccion;
import Persistencia.exceptions.PreexistingEntityException;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class CargaDatosConvenio extends javax.swing.JInternalFrame {
    private Utilitario unUtilitario = new Utilitario();
    private ControladorVisual unControladorVisual = new ControladorVisual();
    private JTableHeader th = new JTableHeader();
    private Font fuente = new Font("Dialog", Font.BOLD, 18);
    private JLabel mensaje = new JLabel("mensaje");
    
    public CargaDatosConvenio() {
        initComponents();
        this.unUtilitario.cargarAnhoActual(tfYear);
        this.cmbConvenios.setSelectedIndex(-1);
        th= this.tblProduccion.getTableHeader();
        th.setFont(fuente);
        this.tblProduccion.setTableHeader(th);
        this.unUtilitario.cargarComboObjeto(unControladorVisual.obtenerConvenios(), cmbConvenios);
        
    }

    private void cargarMeses(){
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) this.tblProduccion.getModel();
        int fila = this.tblProduccion.getRowCount();
        for (int i = 0; i < fila ; i++){
            model.setValueAt(0, i, 1);
            model.setValueAt("", i, 2);
            model.setValueAt(0, i, 3);
            model.setValueAt("", i, 4);
        
    }
        for(int i = 0;i<=11;i++){
            this.tblProduccion.setValueAt(this.unUtilitario.getMonth(i), i, 0);
        }
    }

    private void cargarTabla(){
        this.limpiarTabla();
        if(tfYear.getText().length() > 0 && this.cmbConvenios.getSelectedIndex() != -1){
            int year = Integer.parseInt(tfYear.getText());
            Convenio unConvenio = (Convenio) this.cmbConvenios.getSelectedItem();
            Iterator it = this.unControladorVisual.obtenerProducciones(year, unConvenio).iterator();
            Produccion unaProduccion = new Produccion();
            while(it.hasNext()){
                unaProduccion = (Produccion) it.next();
                if(unaProduccion.getProducido()!=null) this.tblProduccion.setValueAt(unaProduccion.getProducido(), unaProduccion.getMes(), 1);
                else this.tblProduccion.setValueAt(null, unaProduccion.getMes(), 1);
                this.tblProduccion.setValueAt(unaProduccion.getnFactura(), unaProduccion.getMes(), 2);
                if(unaProduccion.getImporteCobrador()!= null) this.tblProduccion.setValueAt(unaProduccion.getImporteCobrador(), unaProduccion.getMes(), 3);
                else this.tblProduccion.setValueAt(0, unaProduccion.getMes(), 3);
                this.tblProduccion.setValueAt(this.unUtilitario.obtenerFecha(unaProduccion.getFechaCobrado()), unaProduccion.getMes(), 4);
            }
            this.sumarTotales();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeneral = new javax.swing.JPanel();
        pnlBusqueda = new javax.swing.JPanel();
        cmbConvenios = new javax.swing.JComboBox<>();
        lblConvenios = new javax.swing.JLabel();
        lblYear = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        pnlTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProduccion = new javax.swing.JTable();
        pnlTotales = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTotales = new javax.swing.JTable();
        pnlBotonera = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        cmbConvenios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbConvenios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CEMEBA", "ALERTA", "UTE OSPIT", "UTE A. URUGUAY" }));
        cmbConvenios.setAutoscrolls(true);
        cmbConvenios.setDoubleBuffered(true);
        cmbConvenios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbConveniosActionPerformed(evt);
            }
        });
        cmbConvenios.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cmbConveniosPropertyChange(evt);
            }
        });

        lblConvenios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblConvenios.setText("CONVENIO:");

        lblYear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblYear.setText("AÑO:");

        tfYear.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfYear.setText("2019");
        tfYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBusquedaLayout = new javax.swing.GroupLayout(pnlBusqueda);
        pnlBusqueda.setLayout(pnlBusquedaLayout);
        pnlBusquedaLayout.setHorizontalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblConvenios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblYear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(408, Short.MAX_VALUE))
        );
        pnlBusquedaLayout.setVerticalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusquedaLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblConvenios)
                    .addComponent(lblYear)
                    .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        tblProduccion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblProduccion.setModel(new javax.swing.table.DefaultTableModel(
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
                "MES", "PRODUC.", "N° FACT.", "COBRADO", "FECHA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblProduccionKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblProduccion);
        if (tblProduccion.getColumnModel().getColumnCount() > 0) {
            tblProduccion.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout pnlTableLayout = new javax.swing.GroupLayout(pnlTable);
        pnlTable.setLayout(pnlTableLayout);
        pnlTableLayout.setHorizontalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        pnlTableLayout.setVerticalGroup(
            pnlTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                .addContainerGap())
        );

        tblTotales.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblTotales.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"TOTAL COBROS", null, null, null, null},
                {"TOTAL PRODUCCION", null, null, null, null}
            },
            new String [] {
                "", "", "", "", ""
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Object.class, java.lang.Double.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblTotales);

        javax.swing.GroupLayout pnlTotalesLayout = new javax.swing.GroupLayout(pnlTotales);
        pnlTotales.setLayout(pnlTotalesLayout);
        pnlTotalesLayout.setHorizontalGroup(
            pnlTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 797, Short.MAX_VALUE))
        );
        pnlTotalesLayout.setVerticalGroup(
            pnlTotalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTotalesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlTable, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTotales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlTotales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        jButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jButton1.setText("MARCAR");

        btnGuardar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGuardar.setText("GUARDAR");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoneraLayout = new javax.swing.GroupLayout(pnlBotonera);
        pnlBotonera.setLayout(pnlBotoneraLayout);
        pnlBotoneraLayout.setHorizontalGroup(
            pnlBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotoneraLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(199, 199, 199)
                .addComponent(btnGuardar)
                .addGap(18, 18, 18))
        );
        pnlBotoneraLayout.setVerticalGroup(
            pnlBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoneraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnGuardar))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBotonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlBotonera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public int getMesTabla(){
        int mes = this.tblProduccion.getSelectedRow();
        return mes;
    }
    
    private void tblProduccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblProduccionKeyReleased
        /*if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            int i = getMesTabla();
            Convenio unConvenio = (Convenio) this.cmbConvenios.getSelectedItem();
            int year = Integer.parseInt(this.tfYear.getText());
            Double importe = Double.parseDouble(this.tblProduccion.getValueAt(i, 1).toString());
            if(importe!=null || importe != 0){
                String factura = this.tblProduccion.getValueAt(i, 2).toString();
                Double importePagado = Double.parseDouble(this.tblProduccion.getValueAt(i, 3).toString());
                Calendar fecha = null;
                try {
                    if(this.tblProduccion.getValueAt(i, 4).toString().length()>0){
                        fecha = this.unUtilitario.obtenerFecha(this.tblProduccion.getValueAt(i, 4).toString());
                    }
                    
                } catch (ParseException ex) {
                    Logger.getLogger(CargaDatosConvenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(this.unControladorVisual.existeProduccion(i,year, unConvenio)){
                    this.modificarProduccion(unConvenio, year, importe, year, factura, importePagado, fecha);
                }else{
                    this.agregarProduccion(unConvenio, year, importe, i);
                }
            }
            this.cargarTabla();
        }*/
    }//GEN-LAST:event_tblProduccionKeyReleased

    public void limpiarTabla(){
        
        this.cargarMeses();
    }
    
   private void sumarTotales(){
       Double totalProduccion = 0.0;
       Double totalCobrado = 0.0;
       for(int i= 0;i<=11;i++){
           if(this.tblProduccion.getValueAt(i, 1)!=null && this.tblProduccion.getValueAt(i, 1)!= "")
           totalProduccion += Double.parseDouble(this.tblProduccion.getValueAt(i, 1).toString());
           if(this.tblProduccion.getValueAt(i, 3)!=null && this.tblProduccion.getValueAt(i, 1)!= "")
           totalCobrado+=Double.parseDouble(this.tblProduccion.getValueAt(i, 3).toString());
      }
      this.tblTotales.setValueAt(totalProduccion, 1, 1);
      this.tblTotales.setValueAt(totalCobrado, 0, 3);
   }
    
    private void cmbConveniosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbConveniosActionPerformed
        if(this.cmbConvenios.getSelectedIndex()!=-1) this.cargarTabla();
    }//GEN-LAST:event_cmbConveniosActionPerformed

    private void tfYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfYearActionPerformed
        this.cargarTabla();
    }//GEN-LAST:event_tfYearActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        for(int i = 0;i <= 11;i++){
            Convenio unConvenio = (Convenio) this.cmbConvenios.getSelectedItem();
            int year = Integer.parseInt(this.tfYear.getText());
            Double importe = Double.parseDouble(this.tblProduccion.getValueAt(i, 1).toString());
            if(Double.compare(importe,0.0)!=0){
                String factura = this.tblProduccion.getValueAt(i, 2).toString();
                Double importePagado = Double.parseDouble(this.tblProduccion.getValueAt(i, 3).toString());
                Calendar fecha = Calendar.getInstance();
                this.tblProduccion.setValueAt(this.unUtilitario.obtenerFecha(fecha),i, 4);
                try {
                    fecha = this.unUtilitario.obtenerFecha(this.tblProduccion.getValueAt(i, 4).toString());
                } catch (ParseException ex) {
                    Logger.getLogger(CargaDatosConvenio.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(this.unControladorVisual.existeProduccion(i,year, unConvenio)){
                    //this.modificarProduccion(unConvenio, year, importe, year, factura, importePagado, fecha);
                }else{
                    this.agregarProduccion(unConvenio, year, importe, i,fecha, factura, importePagado);
                }
            }
       }
        this.cargarTabla();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void agregarProduccion(Convenio unConvenio, int year, Double importe, int mes, Calendar fecha, String factura, Double cobrado){
        try {
            this.unControladorVisual.agregarProduccion(importe, mes, year, unConvenio ,fecha, factura, cobrado);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(CargaDatosConvenio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void modificarProduccion(Convenio unConvenio, int year, Double produccion, int mes, String numFactura,Double cobrado, Calendar fecha){
        if(this.unControladorVisual.existeProduccion(mes,year, unConvenio)){
            Produccion unaProduccion =  this.unControladorVisual.obtenerProducciones(mes, year, unConvenio);
            unaProduccion.setProducido(produccion);
            unaProduccion.setnFactura(numFactura);
            unaProduccion.setImporteCobrador(cobrado);
            unaProduccion.setFechaCobrado(fecha);
            try {
                    this.unControladorVisual.modificarProduccion(unaProduccion);
                } catch (Exception ex) {
                    Logger.getLogger(CargaDatosConvenio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
    private void borrarProduccion(){
        
    }
    
    private void cmbConveniosPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cmbConveniosPropertyChange
       if(this.cmbConvenios.getSelectedIndex()!= -1 ) this.cargarTabla();
    }//GEN-LAST:event_cmbConveniosPropertyChange

    private boolean camposOk(){
        boolean campoOk = false;
        if(this.tfYear.getText().length()>0){
            if(this.cmbConvenios.getSelectedIndex()!= -1){
                campoOk = true;
            }
        }
        return campoOk;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbConvenios;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblConvenios;
    private javax.swing.JLabel lblYear;
    private javax.swing.JPanel pnlBotonera;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JPanel pnlTotales;
    private javax.swing.JTable tblProduccion;
    private javax.swing.JTable tblTotales;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}
