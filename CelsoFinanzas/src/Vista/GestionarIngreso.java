package Vista;

import Logica.Cobranza;
import Logica.Ingreso;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;


public class GestionarIngreso extends javax.swing.JInternalFrame {
    Utilitario unUtilitario = new Utilitario();
    ControladorVisual unControladorVisual = new ControladorVisual();
    JTableHeader th;
    Font fuente = new Font("Dialog", Font.BOLD, 18);
    JLabel mensaje = new JLabel("mensaje");
 
    public GestionarIngreso() {
        initComponents();
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), this.cmbCobradores);
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerAreas(), this.cmbAreas);
        this.unUtilitario.cargarAnhoActual(tfyear);
        this.unUtilitario.cargarMesActual(cmbMes);
        BuscarListadoModelTable tiModel = new BuscarListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        this.tblListado.setModel(tiModel);
        th = this.tblAfiliados.getTableHeader();
        th.setFont(fuente);
        this.tblAfiliados.setTableHeader(th);
        th = this.tblListado.getTableHeader();
        th.setFont(fuente);
        this.tblListado.setTableHeader(th);
        this.mensaje.setFont(new Font("Arial", Font.BOLD, 18));
        this.unUtilitario.cargarFechaActual(jdcFecha);
        this.unUtilitario.establecerFormato(jpDetalles, fuente);
    }

    public void cargarTablaIngresos(){
        BuscarListadoModelTable modelListado = new BuscarListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        Cobranza unaCobranza = modelListado.getUserAt(this.tblListado.getSelectedRow());
        IngresoModelTable model = new IngresoModelTable(unaCobranza);
        this.tblAfiliados.setModel(model);
    }
    
    public void cargarTablaListado(){
        BuscarListadoModelTable modelListado = new BuscarListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        this.tblListado.setModel(modelListado);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pIngreso = new javax.swing.JPanel();
        jpIngresos = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfConcepto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfAfiliado = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAfiliados = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jpDetalles = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lblShowCartera = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblShowIngreso = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblShowComision = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblShowNeto = new javax.swing.JLabel();
        jpBuscar = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblListado = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cmbCobradores = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tfyear = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cmbMes = new com.toedter.calendar.JMonthChooser();
        cmbAreas = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblShowCobrador = new javax.swing.JLabel();
        lblShowYear = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lblShowMes = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lblListado = new javax.swing.JLabel();
        lblShowListado = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblShowGeneralComision = new javax.swing.JLabel();
        lblShowGeneralIngreso = new javax.swing.JLabel();
        lblShowGeneralNeto = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jpIngresos.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingresos"));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Concepto");

        tfConcepto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel6.setText("Afiliado");

        tfAfiliado.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfAfiliado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfAfiliadoKeyReleased(evt);
            }
        });

        tblAfiliados.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tblAfiliados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Concepto", "Afiliado", "Comision", "Neto"
            }
        ));
        tblAfiliados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAfiliadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAfiliados);

        btnAgregar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEditar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnBorrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel7.setText("Fecha");

        jdcFecha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jpDetalles.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles de Cartera"));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel13.setText("Cartera:");

        lblShowCartera.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Totales"));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel8.setText("Ingreso:");

        lblShowIngreso.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel10.setText("Comisión:");

        lblShowComision.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Neto:");

        lblShowNeto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblShowIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblShowComision, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblShowNeto, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblShowNeto, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(lblShowComision, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(lblShowIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpDetallesLayout = new javax.swing.GroupLayout(jpDetalles);
        jpDetalles.setLayout(jpDetallesLayout);
        jpDetallesLayout.setHorizontalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jpDetallesLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblShowCartera, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpDetallesLayout.setVerticalGroup(
            jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpDetallesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpDetallesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(lblShowCartera, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout jpIngresosLayout = new javax.swing.GroupLayout(jpIngresos);
        jpIngresos.setLayout(jpIngresosLayout);
        jpIngresosLayout.setHorizontalGroup(
            jpIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIngresosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpIngresosLayout.createSequentialGroup()
                        .addGroup(jpIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpIngresosLayout.createSequentialGroup()
                                .addComponent(tfAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfConcepto))
                        .addGap(161, 161, 161))
                    .addGroup(jpIngresosLayout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(104, 104, 104)
                        .addComponent(btnBorrar)
                        .addGap(69, 69, 69))
                    .addGroup(jpIngresosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpIngresosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jpDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jpIngresosLayout.setVerticalGroup(
            jpIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpIngresosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(tfConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(tfAfiliado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(jpIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar)
                    .addComponent(btnBorrar)
                    .addComponent(btnAgregar))
                .addContainerGap())
        );

        javax.swing.GroupLayout pIngresoLayout = new javax.swing.GroupLayout(pIngreso);
        pIngreso.setLayout(pIngresoLayout);
        pIngresoLayout.setHorizontalGroup(
            pIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pIngresoLayout.createSequentialGroup()
                .addComponent(jpIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pIngresoLayout.setVerticalGroup(
            pIngresoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jpBuscar.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar"));
        jpBuscar.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        tblListado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
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

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Cobrador");

        cmbCobradores.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbCobradores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Año");

        tfyear.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfyear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfyearKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Mes");

        cmbMes.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        cmbAreas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbAreas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Cartera");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalles del vendedor"));

        lblShowCobrador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        lblShowYear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel17.setText("Año:");

        lblShowMes.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel15.setText("Mes:");

        lblListado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblListado.setText("Listado:");

        lblShowListado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel12.setText("Ingreso:");

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel14.setText("Comisión:");

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel16.setText("Neto:");

        lblShowGeneralComision.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        lblShowGeneralIngreso.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        lblShowGeneralNeto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblListado)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblShowGeneralComision, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblShowListado, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblShowGeneralIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblShowGeneralNeto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblShowYear, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblShowMes, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(lblShowCobrador, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblShowCobrador, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(lblShowYear, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(lblShowMes, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblShowListado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblShowGeneralIngreso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblShowGeneralNeto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel16)
                        .addComponent(lblShowGeneralComision, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jpBuscarLayout = new javax.swing.GroupLayout(jpBuscar);
        jpBuscar.setLayout(jpBuscarLayout);
        jpBuscarLayout.setHorizontalGroup(
            jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 513, Short.MAX_VALUE)
                    .addGroup(jpBuscarLayout.createSequentialGroup()
                        .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jpBuscarLayout.createSequentialGroup()
                                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(tfyear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbCobradores, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbAreas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jpBuscarLayout.setVerticalGroup(
            jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBuscarLayout.createSequentialGroup()
                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tfyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(cmbAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCobradores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addComponent(cmbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jpBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListadoMouseClicked
        BuscarListadoModelTable modelListado = new BuscarListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        Cobranza unaCobranza = modelListado.getUserAt(this.tblListado.getSelectedRow());
        this.lblShowComision.setText(String.valueOf(unaCobranza.calcularComision()));
        this.lblShowIngreso.setText(String.valueOf(unaCobranza.calcularAfiliadoTotal()));
        this.lblShowNeto.setText(String.valueOf(unaCobranza.calcularNeto()));
        this.lblShowCartera.setText(unaCobranza.getUnArea().getNombre());
        this.lblShowCobrador.setText(unaCobranza.getUnCobrador().toString());
        this.lblShowMes.setText(this.unUtilitario.getMonth(unaCobranza.getMes()));
        this.lblShowYear.setText(String.valueOf(unaCobranza.getYear()));
        this.lblShowListado.setText(String.valueOf(this.unControladorVisual.obtenerListadoDelCobrador(unaCobranza.getUnCobrador(), unaCobranza.getYear(), unaCobranza.getMes())));
        this.lblShowGeneralIngreso.setText(String.valueOf(this.unControladorVisual.obtenerAfiliadoDelCobrador(unaCobranza.getUnCobrador(), unaCobranza.getYear(), unaCobranza.getMes())));
        this.lblShowGeneralComision.setText(String.valueOf(this.unControladorVisual.obtenerComisionDelCobrador(unaCobranza.getUnCobrador(), unaCobranza.getYear(), unaCobranza.getMes())));
        this.lblShowGeneralNeto.setText(String.valueOf(this.unControladorVisual.obtenerNetoDelCobrador(unaCobranza.getUnCobrador(), unaCobranza.getYear(), unaCobranza.getMes())));
        IngresoModelTable modelIngreso = new IngresoModelTable(unaCobranza);
        this.tblAfiliados.setModel(modelIngreso);
        
        
    }//GEN-LAST:event_tblListadoMouseClicked
   
    private Cobranza obtenerCobranzaSeleccionada(){
        BuscarListadoModelTable modelListado = new BuscarListadoModelTable(this.unControladorVisual.obtenerCobranzas());
        Cobranza unaCobranza = modelListado.getUserAt(this.tblListado.getSelectedRow());
        return unaCobranza;
    }
    
    private Ingreso obtenerIngresoSeleccionado(){
        IngresoModelTable modelIngreso = new IngresoModelTable(this.obtenerCobranzaSeleccionada().getIngresos());
        Ingreso unIngreso = (Ingreso)modelIngreso.getUserAt(this.tblAfiliados.getSelectedRow());
        return unIngreso;    
    }
    
    private void tfyearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfyearKeyReleased
        this.unUtilitario.borrarLetra(tfyear);
    }//GEN-LAST:event_tfyearKeyReleased

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if(this.tblAfiliados.getSelectedRow() != -1){
            this.mensaje.setText("Esta seguro de que desea borrar?");
            if(JOptionPane.showConfirmDialog(rootPane, mensaje, "Borrando", JOptionPane.YES_NO_OPTION) == 0) {
                this.mensaje.setText("Se ha borrado existosamente.");
                JOptionPane.showMessageDialog(null,this.mensaje,"Éxito!",JOptionPane.INFORMATION_MESSAGE);
                BuscarListadoModelTable modelListado = new BuscarListadoModelTable(this.unControladorVisual.obtenerCobranzas());
                Cobranza unaCobranza = modelListado.getUserAt(this.tblListado.getSelectedRow());
                IngresoModelTable modelIngreso = new IngresoModelTable(unaCobranza);
                Ingreso unIngreso = (Ingreso)modelIngreso.getUserAt(this.tblAfiliados.getSelectedRow());
                try {
                    this.unControladorVisual.borrarIngreso(unaCobranza, unIngreso);
                    cargarTablaIngresos();
                } catch (Exception ex) {
                    Logger.getLogger(GestionarIngreso.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            this.mensaje.setText("Debe seleccionar un Ingreso para poder borrar.");
            JOptionPane.showMessageDialog(null,this.mensaje,"Borrar Ingreso.",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if(this.tblAfiliados.getSelectedRow() != -1){
            if(this.tfAfiliado.getText().length() > 0 &&this.jdcFecha.getCalendar()!= null){
                this.mensaje.setText("Esta seguro de que desea modificar?");
                if(JOptionPane.showConfirmDialog(rootPane, mensaje, "Modificar Datos", JOptionPane.YES_NO_OPTION) == 0){
                    Cobranza unaCobranza = this.obtenerCobranzaSeleccionada();
                    Ingreso oldIngreso;
                    Ingreso newIngreso = obtenerIngresoSeleccionado();
                    oldIngreso = newIngreso;
                    newIngreso.setAfiliado(Double.parseDouble(this.tfAfiliado.getText()));
                    newIngreso.setConcepto(this.tfConcepto.getText());
                    newIngreso.setFecha(this.jdcFecha.getCalendar());
                    try {
                        this.controlarConcepto();
                        this.unControladorVisual.modificarIngreso(unaCobranza, oldIngreso,newIngreso);
                        cargarTablaIngresos();
                    } catch (Exception ex) {
                        Logger.getLogger(GestionarIngreso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }else{
                this.mensaje.setText("Verifique que esten todos los datos.");
                JOptionPane.showMessageDialog(null,this.mensaje,"Datos faltantes",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            this.mensaje.setText("Seleccione un ingreso para modificar");
            JOptionPane.showMessageDialog(null,this.mensaje,"Editar Ingresos.",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if(this.tblListado.getSelectedRow() != -1){
            if(this.tfAfiliado.getText().length() > 0 && this.jdcFecha.getCalendar()!= null){
                BuscarListadoModelTable modelListado = new BuscarListadoModelTable(this.unControladorVisual.obtenerCobranzas());
                Double afiliado = Double.parseDouble(this.tfAfiliado.getText());
                Cobranza unaCobranza = modelListado.getUserAt(this.tblListado.getSelectedRow());
                Ingreso unIngreso = new Ingreso(afiliado, this.tfConcepto.getText(), this.jdcFecha.getCalendar());
                controlarConcepto();
                try {
                    this.unControladorVisual.agregarIngreso(unaCobranza, unIngreso);
                } catch (Exception ex) {
                    Logger.getLogger(GestionarIngreso.class.getName()).log(Level.SEVERE, null, ex);
                }
                this.cargarTablaIngresos();
            }else{
                this.mensaje.setText("Verifique que esten todos los datos.");
                JOptionPane.showMessageDialog(null,this.mensaje,"Datos faltantes",JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            this.mensaje.setText("Debe seleccionar una Cobranza.");
            JOptionPane.showMessageDialog(null,this.mensaje,"Datos faltantes",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    
    
    private void tblAfiliadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAfiliadosMouseClicked
        if(this.tblListado.getSelectedRow() != -1){
            BuscarListadoModelTable modelListado = new BuscarListadoModelTable(this.unControladorVisual.obtenerCobranzas());
            Cobranza unaCobranza = modelListado.getUserAt(this.tblListado.getSelectedRow());
            IngresoModelTable modelIngreso = new IngresoModelTable(unaCobranza);
            Ingreso unIngreso = modelIngreso.getUserAt(this.tblAfiliados.getSelectedRow());
            this.tfConcepto.setText(unIngreso.getConcepto());
            this.tfAfiliado.setText(String.valueOf(unIngreso.getAfiliado()));
            this.jdcFecha.setCalendar(unIngreso.getFecha());
        }
    }//GEN-LAST:event_tblAfiliadosMouseClicked

    private void tfAfiliadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAfiliadoKeyReleased
        this.unUtilitario.borrarLetra(tfAfiliado);
    }//GEN-LAST:event_tfAfiliadoKeyReleased

    private void controlarConcepto(){
        if(this.tfConcepto.getText().length() == 0 ){
            this.tfConcepto.setText("-");
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JComboBox<String> cmbAreas;
    private javax.swing.JComboBox<String> cmbCobradores;
    private com.toedter.calendar.JMonthChooser cmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JPanel jpBuscar;
    private javax.swing.JPanel jpDetalles;
    private javax.swing.JPanel jpIngresos;
    private javax.swing.JLabel lblListado;
    private javax.swing.JLabel lblShowCartera;
    private javax.swing.JLabel lblShowCobrador;
    private javax.swing.JLabel lblShowComision;
    private javax.swing.JLabel lblShowGeneralComision;
    private javax.swing.JLabel lblShowGeneralIngreso;
    private javax.swing.JLabel lblShowGeneralNeto;
    private javax.swing.JLabel lblShowIngreso;
    private javax.swing.JLabel lblShowListado;
    private javax.swing.JLabel lblShowMes;
    private javax.swing.JLabel lblShowNeto;
    private javax.swing.JLabel lblShowYear;
    private javax.swing.JPanel pIngreso;
    private javax.swing.JTable tblAfiliados;
    private javax.swing.JTable tblListado;
    private javax.swing.JTextField tfAfiliado;
    private javax.swing.JTextField tfConcepto;
    private javax.swing.JTextField tfyear;
    // End of variables declaration//GEN-END:variables
}
