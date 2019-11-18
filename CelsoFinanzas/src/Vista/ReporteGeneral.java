package Vista;

import Logica.Area;
import Logica.Cobranza;
import Logica.Convenio;
import java.awt.BasicStroke;
import java.awt.Color;
import java.util.Iterator;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class ReporteGeneral extends javax.swing.JInternalFrame {
    private ControladorVisual unControladorVisual = new ControladorVisual();
    private Utilitario unUtilitario = new Utilitario();
    private TimeSeries producido = new TimeSeries("Producido");
    private TimeSeries cobrado = new TimeSeries("Cobrado");
    private TimeSeries Listado = new TimeSeries("Listado");
    private TimeSeries cobradoC = new TimeSeries("Cobrado");
    private TimeSeries neto = new TimeSeries("Neto");
    private TimeSeries egresos = new TimeSeries("Egresos");
    private TimeSeries impuestos = new TimeSeries("Impuestos");
    
    private TimeSeriesCollection dataset = new TimeSeriesCollection();
    private JLabel mensaje = new JLabel("mensaje");
   
    public ReporteGeneral() {
        initComponents();
        
        cargarCombo();
        this.cmbConvenios.setSelectedIndex(-1);
    }

    public void cargarCombo(){
        this.cmbConvenios.addItem("TODO");
        this.cmbConvenios.addItem("Afiliados");
        this.cmbConvenios.addItem("Convenios");
        this.cmbConvenios.addItem("Sector Protegido");
        
    }
    
public void generarGraficaAfiliadosySp(int year){
        this.dataset.removeAllSeries();
        this.jpGraficos.removeAll();
        this.Listado.clear();
        this.cobradoC.clear();
        this.neto.clear();
        int mes = 0;
        while (mes<=11){
            Listado.addOrUpdate(new Month( mes+1, year), this.unControladorVisual.obtenerListadoMesYear(year, mes));
            cobradoC.addOrUpdate(new Month( mes+1, year), this.unControladorVisual.obtenerAfiliadoMesYear(year, mes));
            neto.addOrUpdate(new Month(mes+1,year), this.unControladorVisual.obtenerNetoMesYear(year, mes));
            mes++;
        }
        dataset.addSeries(cobradoC);
        dataset.addSeries(Listado);
        dataset.addSeries(neto);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Año " +year , "Meses","Ingreso",dataset,true,false,false);
        this.renderizarGrafico(chart);
    }
    
    public void generarGraficaAnualConvenio(int year){
        this.dataset.removeAllSeries();
        this.jpGraficos.removeAll();
        this.producido.clear();
        this.cobrado.clear();
        int mes = 0;
        Double importeProducido = 0.0;
        Double importeCobrado = 0.0;
        Convenio unConvenio=null;
        while (mes<=11){
            Iterator it = this.unControladorVisual.obtenerConvenios().iterator();
            while(it.hasNext()){
                 unConvenio = (Convenio) it.next();
                if(this.unControladorVisual.obtenerProducciones(mes, year, unConvenio)!= null){
                    importeProducido += this.unControladorVisual.obtenerProducciones(mes, year, unConvenio).getProducido();
                    importeCobrado += this.unControladorVisual.obtenerImporteCobradoMes(mes, year, unConvenio);
                    //importeCobrado += this.unControladorVisual.obtenerProducciones(mes, year, unConvenio).getImporteCobrador();
                }
                importeCobrado += this.unControladorVisual.obtenerImporteCobradoMes(mes, year, unConvenio);
                producido.addOrUpdate(new Month( mes+1, year), importeProducido);
                cobrado.addOrUpdate(new Month( mes+1, year), importeCobrado);
            }
            importeProducido=0.0;
            importeCobrado=0.0;
            mes++;
        }
        dataset.addSeries(cobrado);
        dataset.addSeries(producido);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Convenios en el año " +year , "Meses","Pesos",dataset,true,false,false);
        this.renderizarGrafico(chart);
    }

    public void generarGraficaArea(Area unArea, int year){
        this.jpGraficos.removeAll();
        this.dataset.removeAllSeries();
        this.Listado.clear();
        this.cobrado.clear();
        this.neto.clear();
        Double ingresa =0.0;
        Iterator it = this.unControladorVisual.cobranzasDeCartera(unArea, year).iterator();
        Cobranza unaCobranza = new Cobranza();
        this.carcagarSeries(year);
        while (it.hasNext()){
            unaCobranza = (Cobranza) it.next();
            ingresa += unaCobranza.getListado();
            Listado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), ingresa);
            cobrado.addOrUpdate(new Month( unaCobranza.getMes()+1, year), unaCobranza.calcularAfiliadoTotal());
            neto.addOrUpdate(new Month(unaCobranza.getMes()+1,year), unaCobranza.calcularNeto());
        }
        dataset.addSeries(cobrado);
        dataset.addSeries(Listado);
        dataset.addSeries(neto);
        JFreeChart chart = ChartFactory.createTimeSeriesChart(unArea.getNombre() +" en el año "+ year , "Meses","Ingreso",dataset,true,false,false);
        this.renderizarGrafico(chart);
    }

    public void generarGraficaTotal(int year){
        this.dataset.removeAllSeries();
        this.jpGraficos.removeAll();
        this.producido.clear();
        this.cobrado.clear();
        this.impuestos.clear();
        this.egresos.clear();
        int mes = 0;
        Double importeProducido = 0.0;
        Double importeCobrado = 0.0;
        Double impuestosV = 0.0;
        Double egresosV = 0.0;
        while (mes<=11){
            Iterator it = this.unControladorVisual.obtenerConvenios().iterator();
            while(it.hasNext()){
                Convenio unConvenio = (Convenio) it.next();
                if(this.unControladorVisual.obtenerProducciones(mes, year, unConvenio)!= null){
                    importeProducido+=this.unControladorVisual.obtenerProducciones(mes, year, unConvenio).getProducido();
                    importeCobrado += this.unControladorVisual.obtenerImporteCobradoMes(mes, year, unConvenio);
                }
                if(!this.unControladorVisual.existeEgreso(year, mes)){
                    impuestos.addOrUpdate(new Month( mes+1, year), 0.0);
                    egresos.addOrUpdate(new Month( mes+1, year),0.0);
                }else{
                    impuestos.addOrUpdate(new Month( mes+1, year), this.unControladorVisual.obtenerUnEgresos(mes, year).getImpuestos());
                    egresos.addOrUpdate(new Month( mes+1, year), this.unControladorVisual.obtenerUnEgresos(mes, year).getSubTotal());
                }
                
                producido.addOrUpdate(new Month( mes+1, year), importeProducido+this.unControladorVisual.obtenerListadoMesYear(year, mes) );
                cobrado.addOrUpdate(new Month( mes+1, year), importeCobrado+this.unControladorVisual.obtenerNetoMesYear(year, mes));
            }
            
            importeProducido=0.0;
            importeCobrado=0.0;
            mes++;
        }
        dataset.addSeries(cobrado);
        dataset.addSeries(producido);
        dataset.addSeries(impuestos);
        dataset.addSeries(egresos);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Reporte general del año " +year , "Meses","Pesos",dataset,true,false,false);
        this.renderizarGrafico(chart);
    }
    
    private void renderizarGrafico(JFreeChart chart){
        XYPlot plot  = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
        render.setSeriesPaint(0, Color.green);
        render.setSeriesPaint(1, Color.red);
        render.setSeriesPaint(2, Color.BLACK);
        render.setSeriesPaint(3, Color.BLUE);
        render.setSeriesStroke(0, new BasicStroke(8.0f,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
        render.setSeriesStroke(1, new BasicStroke(4.0f));
        render.setSeriesStroke(2, new BasicStroke(4.0f));
        render.setSeriesStroke(3, new BasicStroke(4.0f));
        plot.setRenderer(render);
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(0, 0, 1168, 556);
        this.jpGraficos.add(panel);
        this.jpGraficos.setEnabled(false);
        panel.setEnabled(false);
        panel.setFocusable(false);
        this.jpGraficos.setFocusable(false);
    }
    
    public void carcagarSeries(int year){
        for(int i = 1; i<=12; i++){
            Listado.addOrUpdate(new Month( i, year), 0);
            cobrado.addOrUpdate(new Month( i, year), 0);
            neto.addOrUpdate(new Month(i,year), 0); 
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeneral = new javax.swing.JPanel();
        jpGraficos = new javax.swing.JPanel();
        pnlBusqueda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbConvenios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jycYear = new com.toedter.calendar.JYearChooser();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);

        jpGraficos.setBorder(javax.swing.BorderFactory.createTitledBorder("Gráfico"));

        javax.swing.GroupLayout jpGraficosLayout = new javax.swing.GroupLayout(jpGraficos);
        jpGraficos.setLayout(jpGraficosLayout);
        jpGraficosLayout.setHorizontalGroup(
            jpGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1175, Short.MAX_VALUE)
        );
        jpGraficosLayout.setVerticalGroup(
            jpGraficosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlGeneralLayout = new javax.swing.GroupLayout(pnlGeneral);
        pnlGeneral.setLayout(pnlGeneralLayout);
        pnlGeneralLayout.setHorizontalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlGeneralLayout.setVerticalGroup(
            pnlGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlGeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpGraficos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pnlBusqueda.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("AÑO:");

        cmbConvenios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbConvenios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbConveniosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("CARTERA:");

        jycYear.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jycYear.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jycYearPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout pnlBusquedaLayout = new javax.swing.GroupLayout(pnlBusqueda);
        pnlBusqueda.setLayout(pnlBusquedaLayout);
        pnlBusquedaLayout.setHorizontalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jycYear, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cmbConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(689, Short.MAX_VALUE))
        );
        pnlBusquedaLayout.setVerticalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jycYear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cmbConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBusqueda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlGeneral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jycYearPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jycYearPropertyChange
        this.generarGraficos();
    }//GEN-LAST:event_jycYearPropertyChange

    private void cmbConveniosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbConveniosActionPerformed
        this.generarGraficos();
    }//GEN-LAST:event_cmbConveniosActionPerformed

    private void generarGraficos(){
        this.jpGraficos.removeAll();
        if(this.cmbConvenios.getSelectedIndex()!= -1){
            if(this.cmbConvenios.getSelectedItem().toString() == "TODO"){
                generarGraficaTotal(jycYear.getYear());
            }else if(this.cmbConvenios.getSelectedItem().toString() == "Convenios"){
                this.generarGraficaAnualConvenio(jycYear.getYear());
            }else if(this.cmbConvenios.getSelectedItem().toString() == "Sector Protegido"){
                Area unArea = this.unControladorVisual.obtenerAreaPorNombre("Sector Protegido");
                this.generarGraficaArea(unArea, jycYear.getYear());
            }else if(this.cmbConvenios.getSelectedItem().toString() == "Afiliados"){
                Area unArea = this.unControladorVisual.obtenerAreaPorNombre("Afiliados");
                this.generarGraficaArea(unArea, jycYear.getYear());
            }
        }
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbConvenios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpGraficos;
    private com.toedter.calendar.JYearChooser jycYear;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlGeneral;
    // End of variables declaration//GEN-END:variables
}
