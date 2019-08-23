package Vista;

import Logica.Convenio;
import java.awt.Font;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ResumenCobros extends javax.swing.JInternalFrame {
    ControladorVisual unControladorVisual = new ControladorVisual();
    Utilitario unUtilitario = new Utilitario();
    private JTableHeader th = new JTableHeader();
    private Font fuente = new Font("Dialog", Font.BOLD, 18);
    public ResumenCobros() {
        initComponents();
        cargarAspectos();
        cargarProduccion();
        sumarMensual();
    }

    
    
    public void cargarAspectos(){
        th= this.tblResumen.getTableHeader();
        th.setFont(fuente);
        this.tblResumen.setTableHeader(th);
        
    }
    
    public void cargarProduccion(){
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) this.tblResumen.getModel();
        int fila = unControladorVisual.obtenerConvenios().size();
        Iterator it = unControladorVisual.obtenerConvenios().iterator();
        int year = Integer.parseInt(this.tfYear.getText());
        model.setNumRows(0);
        model.setNumRows(fila+1);
        Convenio unConvenio = new Convenio();
        
        int i=0;
        while(it.hasNext()){
            Double totalConvenio=0.0;
            unConvenio = (Convenio) it.next();
            this.tblResumen.setValueAt(unConvenio.getNombre(), i, 0);
            for(int j=0;j<12;j++){
                if(unControladorVisual.obtenerProducciones(j, year, unConvenio) != null){
                    this.tblResumen.setValueAt(unControladorVisual.obtenerProducciones(j, year, unConvenio).getProducido(), i,unControladorVisual.obtenerProducciones(j, year, unConvenio).getMes() +1 );
                    totalConvenio+=unControladorVisual.obtenerProducciones(j, year, unConvenio).getProducido();
                }
            }
            this.tblResumen.setValueAt(totalConvenio, i, 13 );
            i++;
            
        }
        this.tblResumen.setValueAt("TOTAL", this.tblResumen.getRowCount()-1, 0);
    }

    private void sumarMensual(){
       Double total = 0.0;
       for(int i=1;i<=13;i++){
           for(int j=0;j< this.tblResumen.getRowCount();j++){
               if(this.tblResumen.getValueAt(j, i)!=null && this.tblResumen.getValueAt(j, i)!= ""){
                   total += Double.parseDouble(this.tblResumen.getValueAt(j, i).toString());
               }
           }
           this.tblResumen.setValueAt(total, this.tblResumen.getRowCount()-1, i);
           total=0.0;
      }
      
   }
    
    
    public void cargarCobrado(){
        DefaultTableModel model = new DefaultTableModel();
        model = (DefaultTableModel) this.tblResumen.getModel();
        int fila = unControladorVisual.obtenerConvenios().size();
        Iterator it = unControladorVisual.obtenerConvenios().iterator();
        int year = Integer.parseInt(this.tfYear.getText());
        model.setNumRows(0);
        model.setNumRows(fila+1);
        Convenio unConvenio = new Convenio();
        int i=0;
        Double totalCobradoConvenio = 0.0;
        Double totalMes=0.0;
        while(it.hasNext()){
            totalCobradoConvenio =0.0;
            unConvenio = (Convenio) it.next();
            this.tblResumen.setValueAt(unConvenio.getNombre(), i, 0);
            for(int j=0;j<12;j++){
                if(unControladorVisual.obtenerImporteCobradoMes(j, year, unConvenio)!=0){
                    this.tblResumen.setValueAt(unControladorVisual.obtenerImporteCobradoMes(j, year, unConvenio), i,j+1 );
                    totalCobradoConvenio+=unControladorVisual.obtenerImporteCobradoMes(j, year, unConvenio);
                }
            }
            this.tblResumen.setValueAt(totalCobradoConvenio, i,13 );
            i++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        pnlGeneral = new javax.swing.JPanel();
        pnlBusqueda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        rbProduccion = new javax.swing.JRadioButton();
        rbCobrado = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblResumen = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        pnlBusqueda.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("AÑO:");

        tfYear.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfYear.setText("2019");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        buttonGroup1.add(rbProduccion);
        rbProduccion.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rbProduccion.setSelected(true);
        rbProduccion.setText("PRODUCCION");
        rbProduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbProduccionActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbCobrado);
        rbCobrado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        rbCobrado.setText("COBRADO");
        rbCobrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCobradoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(rbProduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rbCobrado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbProduccion)
                    .addComponent(rbCobrado))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlBusquedaLayout = new javax.swing.GroupLayout(pnlBusqueda);
        pnlBusqueda.setLayout(pnlBusquedaLayout);
        pnlBusquedaLayout.setHorizontalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusquedaLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(827, Short.MAX_VALUE))
        );
        pnlBusquedaLayout.setVerticalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBusquedaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        tblResumen.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tblResumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CONVENIO", "ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE", "TOTAL"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblResumen);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGeneralLayout.createSequentialGroup()
                .addComponent(pnlBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbProduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbProduccionActionPerformed
        if(this.rbProduccion.isSelected()){
            cargarProduccion();
        }else{
            cargarCobrado();
        }
           sumarMensual();
    }//GEN-LAST:event_rbProduccionActionPerformed

    private void rbCobradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCobradoActionPerformed
        if(this.rbCobrado.isSelected()){
            cargarCobrado();
        }else{
            cargarProduccion();
        }
        sumarMensual();
    }//GEN-LAST:event_rbCobradoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JRadioButton rbCobrado;
    private javax.swing.JRadioButton rbProduccion;
    private javax.swing.JTable tblResumen;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}
