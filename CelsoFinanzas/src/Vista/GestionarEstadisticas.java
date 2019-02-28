package Vista;

import Logica.Area;
import Logica.Cobrador;
import Logica.Cobranza;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;



public class GestionarEstadisticas extends javax.swing.JInternalFrame implements Observador{
    private ControladorVisual unControladorVisual = new ControladorVisual();
    private Utilitario unUtilitario = new Utilitario();
    private TimeSeries Listado = new TimeSeries("Listado");
    private TimeSeries cobrado = new TimeSeries("Cobrado");
    private TimeSeries neto = new TimeSeries("Neto");
    private TimeSeriesCollection dataset = new TimeSeriesCollection();
    private JLabel mensaje = new JLabel("mensaje");
    
    public GestionarEstadisticas() {
        initComponents();
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerAreas(), this.cmbArea);
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), this.cmbCobrador);   
        this.unUtilitario.cargarAnhoActual(this.tfYear);
        this.cmbArea.setSelectedIndex(-1);
        this.cmbCobrador.setSelectedIndex(-1);
        this.cmbArea.addItem("Todos");
        this.cmbCobrador.addItem("Todos");
        this.mensaje.setFont(new Font("Arial", Font.BOLD, 18));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTodo = new javax.swing.JPanel();
        jpGraficos = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        cmbCobrador = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cmbArea = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        btnGraficar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        javax.swing.GroupLayout jpGraficosLayout = new javax.swing.GroupLayout(jpGraficos);
        jpGraficos.setLayout(jpGraficosLayout);
        jpGraficosLayout.setHorizontalGroup(
            jpGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpGraficosLayout.setVerticalGroup(
            jpGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Cobrador");

        cmbCobrador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbCobrador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("Cartera");

        cmbArea.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Año");

        tfYear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        tfYear.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfYearKeyReleased(evt);
            }
        });

        btnGraficar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnGraficar.setText("Graficar");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCobrador, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnGraficar)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbCobrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(btnGraficar))
                .addContainerGap())
        );

        javax.swing.GroupLayout jpTodoLayout = new javax.swing.GroupLayout(jpTodo);
        jpTodo.setLayout(jpTodoLayout);
        jpTodoLayout.setHorizontalGroup(
            jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTodoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpTodoLayout.createSequentialGroup()
                        .addComponent(jpGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jpTodoLayout.setVerticalGroup(
            jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTodoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTodo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
        boolean llamadoLocal = true;
        this.graficar(llamadoLocal);
        
    }//GEN-LAST:event_btnGraficarActionPerformed

    public void graficar(boolean llamadoLocal){
        if(this.tfYear.getText().length()>0){
            if(this.cmbArea.getSelectedIndex()!= -1){
                if(this.cmbCobrador.getSelectedIndex() != -1 ){
                    if((this.cmbArea.getSelectedItem().equals("Todos")) && (this.cmbCobrador.getSelectedItem().equals("Todos"))){
                        this.generarGraficaAnual(Integer.parseInt(this.tfYear.getText()));
                    }else if((this.cmbArea.getSelectedItem().equals("Todos")) && (!this.cmbCobrador.getSelectedItem().equals("Todos"))){
                        //imprimir cobrador general.
                        generarGraficaCobrador((Cobrador) this.cmbCobrador.getSelectedItem(),Integer.parseInt(this.tfYear.getText()));
                    }else if((!this.cmbArea.getSelectedItem().equals("Todos")) && (this.cmbCobrador.getSelectedItem().equals("Todos"))){
                        //imprimir general de todas las areas
                        this.generarGraficaArea((Area)this.cmbArea.getSelectedItem(), Integer.parseInt(this.tfYear.getText()));
                    }else if((!this.cmbArea.getSelectedItem().equals("Todos")) && (!this.cmbCobrador.getSelectedItem().equals("Todos"))){
                        this.generarGraficaCobradorArea((Cobrador)this.cmbCobrador.getSelectedItem(), Integer.parseInt(tfYear.getText()) , (Area)this.cmbArea.getSelectedItem());
                    }
                }else if(llamadoLocal){
                    this.mensaje.setText("Seleccione un cobrador.");
                    JOptionPane.showMessageDialog(null,this.mensaje,"Faltan datos.",JOptionPane.INFORMATION_MESSAGE);
                }
            }else if(llamadoLocal){
                this.mensaje.setText("Seleccione una cartera de negocios.");
                JOptionPane.showMessageDialog(null,this.mensaje,"Faltan datos.",JOptionPane.INFORMATION_MESSAGE);
            }
        }else if(llamadoLocal){
            this.mensaje.setText("Ingrese el año.");
            JOptionPane.showMessageDialog(null,this.mensaje,"Faltan datos",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    private void tfYearKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfYearKeyReleased
        this.unUtilitario.borrarLetra(tfYear);
        this.unUtilitario.limitarLetra(4, tfYear);
    }//GEN-LAST:event_tfYearKeyReleased

    public void generarGraficaAnual(int year){
        this.dataset.removeAllSeries();
        this.jpGraficos.removeAll();
        int mes = 1;
        Iterator it = this.unControladorVisual.obtenerCobrnzasYear(year).iterator();
        Cobranza unaCobranza = new Cobranza();
        this.carcagarSeries(year);
        while (it.hasNext()){
            unaCobranza = (Cobranza) it.next();
            Listado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.getListado());
            cobrado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.calcularAfiliadoTotal());
            neto.addOrUpdate(new Month(unaCobranza.getMes()+1,year), unaCobranza.calcularNeto());
            mes++;
        }
       // this.agregarMeses(mes, year);
        dataset.addSeries(cobrado);
        dataset.addSeries(Listado);
        dataset.addSeries(neto);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Año " +year , "Meses","Ingreso",dataset,true,false,false);
        this.renderizarGrafico(chart);
    }
    
    public void generarGraficaCobradorArea(Cobrador unCobrador, int year, Area unArea){
        this.jpGraficos.removeAll();
        this.dataset.removeAllSeries();
        int mes = 1;
        Iterator it = this.unControladorVisual.obtenerCobranzasAreaCobrador(unArea, year,unCobrador).iterator();
        Cobranza unaCobranza = new Cobranza();
        this.carcagarSeries(year);
        while (it.hasNext()){
            unaCobranza = (Cobranza) it.next();
            Listado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.getListado());
            cobrado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.calcularAfiliadoTotal());
            neto.addOrUpdate(new Month(unaCobranza.getMes()+1,year), unaCobranza.calcularNeto());
            mes++;
        }
       // this.agregarMeses(mes, year);
        dataset.addSeries(cobrado);
        dataset.addSeries(Listado);
        dataset.addSeries(neto);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(unCobrador.getAlias() + " en el año " + year + " en " + unArea.getNombre() , "Meses","Ingreso",dataset,true,false,false);
        this.renderizarGrafico(chart);
    }
    
    public void generarGraficaArea(Area unArea, int year){
        this.jpGraficos.removeAll();
        this.dataset.removeAllSeries();
        int mes = 1;
        Iterator it = this.unControladorVisual.cobranzasDeCartera(unArea, year).iterator();
        Cobranza unaCobranza = new Cobranza();
        this.carcagarSeries(year);
        while (it.hasNext()){
            unaCobranza = (Cobranza) it.next();
            Listado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.getListado());
            cobrado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.calcularAfiliadoTotal());
            neto.addOrUpdate(new Month(unaCobranza.getMes()+1,year), unaCobranza.calcularNeto());
            mes++;
        }
        //this.agregarMeses(mes, year);
        dataset.addSeries(cobrado);
        dataset.addSeries(Listado);
        dataset.addSeries(neto);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(unArea.getNombre() +" en el año "+ year , "Meses","Ingreso",dataset,true,false,false);
        this.renderizarGrafico(chart);
    }
    
    public void generarGraficaCobrador(Cobrador unCobrador, int year){
        this.dataset.removeAllSeries();
        this.jpGraficos.removeAll();
        int mes = 1;
        Iterator it = this.unControladorVisual.obtenerCobranzasDeCobrador(unCobrador, year).iterator();
        Cobranza unaCobranza = new Cobranza();
        this.carcagarSeries(year);
        while (it.hasNext()){
            unaCobranza = (Cobranza) it.next();
            Listado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.getListado());
            cobrado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.calcularAfiliadoTotal());
            neto.addOrUpdate(new Month(unaCobranza.getMes()+1,year), unaCobranza.calcularNeto()); 
            mes++;
        }
        
        //this.agregarMeses(mes, year);
        dataset.addSeries(cobrado);
        dataset.addSeries(Listado);
        dataset.addSeries(neto);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(unCobrador.getAlias() +" en el año  "  + year, "Meses","Ingreso",dataset,true,false,false);
        this.renderizarGrafico(chart);
    }
    
    private void renderizarGrafico(JFreeChart chart){
        XYPlot plot  = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
        render.setSeriesPaint(0, Color.RED);
        render.setSeriesPaint(1, Color.GREEN);
        render.setSeriesPaint(2, Color.YELLOW);
        render.setSeriesStroke(0, new BasicStroke(4.0f));
        render.setSeriesStroke(1, new BasicStroke(6.0f));
        render.setSeriesStroke(2,new BasicStroke(2.0f));
        plot.setRenderer(render);
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(0, 0, 1168, 556);
        this.jpGraficos.add(panel);
        this.jpGraficos.setEnabled(false);
        panel.setEnabled(false);
        panel.setFocusable(false);
        this.jpGraficos.setFocusable(false);
    }

    private void agregarMeses(int mes, int year){
        if(mes <12 ){
            while(mes<=12){
                Listado.addOrUpdate(new Month( mes, year), 0.0);
                cobrado.addOrUpdate(new Month( mes, year), 0.0);
                neto.addOrUpdate(new Month(mes,year), 0.0);
                mes++;
            }
        }
    }
    
    public void carcagarSeries(int year){
        for(int i = 1; i<=12; i++){
            Listado.addOrUpdate(new Month( i, year), 0);
            cobrado.addOrUpdate(new Month( i, year), 0);
            neto.addOrUpdate(new Month(i,year), 0); 
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficar;
    private javax.swing.JComboBox<String> cmbArea;
    private javax.swing.JComboBox<String> cmbCobrador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jpGraficos;
    private javax.swing.JPanel jpTodo;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update() {
        this.graficar(false);
    }
}
