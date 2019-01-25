package Vista;

import Logica.Area;
import Logica.Cobrador;
import Logica.Cobranza;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Iterator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class GestionarEstadisticas extends javax.swing.JInternalFrame {
    ControladorVisual unControladorVisual = new ControladorVisual();
    Utilitario unUtilitario = new Utilitario();
    public GestionarEstadisticas() {
        initComponents();
        
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerAreas(), this.cmbArea);
        this.unUtilitario.cargarComboObjeto(this.unControladorVisual.obtenerCobradores(), this.cmbCobrador);   
        this.unUtilitario.cargarAnhoActual(this.tfYear);
        this.cmbArea.setSelectedIndex(-1);
        this.cmbCobrador.setSelectedIndex(-1);
        this.cmbArea.addItem("Todos");
        this.cmbCobrador.addItem("Todos");
    }
    
    public void mostraGraficos(Cobrador unCobrador, int year){
        XYSeries series = new XYSeries(unCobrador.getAlias());
        Iterator it = this.unControladorVisual.obenerCobranzasDeCobrador(unCobrador, year).iterator();
        Cobranza unaCobranza = new Cobranza();
        while (it.hasNext()){
            unaCobranza = (Cobranza) it.next();
            series.add(unaCobranza.getMes(), unaCobranza.getListado());
        }
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        JFreeChart chart = ChartFactory.createXYLineChart("Eficiencia de Cobrador","Meses ->"," $ ->",dataset,PlotOrientation.VERTICAL,true,false,false);
        XYPlot plot  = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
        render.setSeriesPaint(0, Color.RED);
        render.setSeriesStroke(0, new BasicStroke(4.0f));
        plot.setRenderer(render);
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(0, 0, 1000, 900);
        this.jpGraficos.add(panel); 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTodo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbCobrador = new javax.swing.JComboBox<>();
        cmbArea = new javax.swing.JComboBox<>();
        jpGraficos = new javax.swing.JPanel();
        btnGraficar = new javax.swing.JButton();
        tfYear = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);

        jLabel1.setText("Año");

        jLabel3.setText("Cobrador");

        jLabel4.setText("Area");

        cmbCobrador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jpGraficosLayout = new javax.swing.GroupLayout(jpGraficos);
        jpGraficos.setLayout(jpGraficosLayout);
        jpGraficosLayout.setHorizontalGroup(
            jpGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 987, Short.MAX_VALUE)
        );
        jpGraficosLayout.setVerticalGroup(
            jpGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
        );

        btnGraficar.setText("Graficar");
        btnGraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficarActionPerformed(evt);
            }
        });

        tfYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfYearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTodoLayout = new javax.swing.GroupLayout(jpTodo);
        jpTodo.setLayout(jpTodoLayout);
        jpTodoLayout.setHorizontalGroup(
            jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTodoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGraficar)
                    .addGroup(jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(cmbCobrador, 0, 163, Short.MAX_VALUE)
                        .addComponent(cmbArea, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jpGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpTodoLayout.setVerticalGroup(
            jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTodoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCobrador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(jpTodoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGraficar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jpTodoLayout.createSequentialGroup()
                .addComponent(jpGraficos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpTodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficarActionPerformed
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
                }
            }
        }
        
        
        //this.generarGrafica(unCobrador, Integer.parseInt(tfYear.getText()) , unArea);
        //this.generarGrafica(unArea,  Integer.parseInt(tfYear.getText()) );
    }//GEN-LAST:event_btnGraficarActionPerformed

    private void tfYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfYearActionPerformed

    public void generarGraficaAnual(int year){
        this.jpGraficos.removeAll();
        TimeSeries Listado = new TimeSeries("Listado");
        TimeSeries cobrado = new TimeSeries("Cobrado");
        TimeSeries neto = new TimeSeries("Neto");
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        Iterator it = this.unControladorVisual.obtenerCobrnzasYear(year).iterator();
        Cobranza unaCobranza = new Cobranza();
        while (it.hasNext()){
            unaCobranza = (Cobranza) it.next();
            Listado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.getListado());
            cobrado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.calcularAfiliadoTotal());
            neto.addOrUpdate(new Month(unaCobranza.getMes()+1,year), unaCobranza.calcularNeto());
        }
        dataset.addSeries(cobrado);
        dataset.addSeries(Listado);
        dataset.addSeries(neto);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Año " +year , "Meses","Ingreso",dataset,true,false,false);
        XYPlot plot  = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
        render.setSeriesPaint(0, Color.RED);
        render.setSeriesPaint(1, Color.GREEN);
        render.setSeriesPaint(2, Color.YELLOW);
        render.setSeriesStroke(0, new BasicStroke(4.0f));
        render.setSeriesStroke(1, new BasicStroke(3.0f));
        render.setSeriesStroke(2,new BasicStroke(3.0f));
        plot.setRenderer(render);
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(0, 0, 1000, 600);
        this.jpGraficos.add(panel);
        this.jpGraficos.setEnabled(false);
        panel.setEnabled(false);
        panel.setFocusable(false);
        this.jpGraficos.setFocusable(false);
        
    }
    
    public void generarGraficaCobradorArea(Cobrador unCobrador, int year, Area unArea){
        this.jpGraficos.removeAll();
        TimeSeries Listado = new TimeSeries("Listado");
        TimeSeries cobrado = new TimeSeries("Cobrado");
        TimeSeries neto = new TimeSeries("Neto");
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        Iterator it = this.unControladorVisual.obtenerCobranzasAreaCobrador(unArea, year,unCobrador).iterator();
        Cobranza unaCobranza = new Cobranza();
        while (it.hasNext()){
            unaCobranza = (Cobranza) it.next();
            Listado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.getListado());
            cobrado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.calcularAfiliadoTotal());
            neto.addOrUpdate(new Month(unaCobranza.getMes()+1,year), unaCobranza.calcularNeto());
        }
        dataset.addSeries(cobrado);
        dataset.addSeries(Listado);
        dataset.addSeries(neto);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(unCobrador.getAlias() , "Meses","Ingreso",dataset,true,false,false);
        XYPlot plot  = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
        render.setSeriesPaint(0, Color.RED);
        render.setSeriesPaint(1, Color.GREEN);
        render.setSeriesPaint(2, Color.YELLOW);
        render.setSeriesStroke(0, new BasicStroke(4.0f));
        render.setSeriesStroke(1, new BasicStroke(3.0f));
        render.setSeriesStroke(2,new BasicStroke(3.0f));
        plot.setRenderer(render);
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(0, 0, 1000, 600);
        this.jpGraficos.add(panel);
        this.jpGraficos.setEnabled(false);
        panel.setEnabled(false);
        panel.setFocusable(false);
        this.jpGraficos.setFocusable(false);
    }
    
    public void generarGraficaArea(Area unArea, int year){
        this.jpGraficos.removeAll();
        TimeSeries Listado = new TimeSeries("Listado");
        TimeSeries cobrado = new TimeSeries("Cobrado");
        TimeSeries neto = new TimeSeries("Neto");
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        Iterator it = this.unControladorVisual.cobranzasDeCartera(unArea, year).iterator();
        Cobranza unaCobranza = new Cobranza();
        while (it.hasNext()){
            unaCobranza = (Cobranza) it.next();
            Listado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.getListado());
            cobrado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.calcularAfiliadoTotal());
            neto.addOrUpdate(new Month(unaCobranza.getMes()+1,year), unaCobranza.calcularNeto());
        }
        dataset.addSeries(cobrado);
        dataset.addSeries(Listado);
        dataset.addSeries(neto);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(unArea.getNombre() , "Meses","Ingreso",dataset,true,false,false);
        XYPlot plot  = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
        render.setSeriesPaint(0, Color.RED);
        render.setSeriesPaint(1, Color.GREEN);
        render.setSeriesPaint(2, Color.YELLOW);
        render.setSeriesStroke(0, new BasicStroke(4.0f));
        render.setSeriesStroke(1, new BasicStroke(3.0f));
        render.setSeriesStroke(2,new BasicStroke(3.0f));
        plot.setRenderer(render);
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(0, 0, 1000, 600);
        this.jpGraficos.add(panel);
        this.jpGraficos.setEnabled(false);
        panel.setEnabled(false);
        panel.setFocusable(false);
        this.jpGraficos.setFocusable(false);
        
    }
    
    public void generarGraficaCobrador(Cobrador unCobrador, int year){
        this.jpGraficos.removeAll();
        TimeSeries Listado = new TimeSeries("Listado");
        TimeSeries cobrado = new TimeSeries("Cobrado");
        TimeSeries neto = new TimeSeries("Neto");
        TimeSeriesCollection dataset = new TimeSeriesCollection();
        Iterator it = this.unControladorVisual.obenerCobranzasDeCobrador(unCobrador, year).iterator();
        Cobranza unaCobranza = new Cobranza();
        while (it.hasNext()){
            unaCobranza = (Cobranza) it.next();
            Listado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.getListado());
            cobrado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.calcularAfiliadoTotal());
            neto.addOrUpdate(new Month(unaCobranza.getMes()+1,year), unaCobranza.calcularNeto());
        }
        dataset.addSeries(cobrado);
        dataset.addSeries(Listado);
        dataset.addSeries(neto);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(unCobrador.getAlias() , "Meses","Ingreso",dataset,true,false,false);
        XYPlot plot  = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
        render.setSeriesPaint(0, Color.RED);
        render.setSeriesPaint(1, Color.GREEN);
        render.setSeriesPaint(2, Color.YELLOW);
        render.setSeriesStroke(0, new BasicStroke(4.0f));
        render.setSeriesStroke(1, new BasicStroke(3.0f));
        render.setSeriesStroke(2,new BasicStroke(3.0f));
        plot.setRenderer(render);
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(0, 0, 1000, 600);
        this.jpGraficos.add(panel);
        this.jpGraficos.setEnabled(false);
        panel.setEnabled(false);
        panel.setFocusable(false);
        this.jpGraficos.setFocusable(false);
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGraficar;
    private javax.swing.JComboBox<String> cmbArea;
    private javax.swing.JComboBox<String> cmbCobrador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jpGraficos;
    private javax.swing.JPanel jpTodo;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}
