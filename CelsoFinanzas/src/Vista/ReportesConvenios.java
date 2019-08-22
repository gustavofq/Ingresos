package Vista;

import Logica.Convenio;
import java.awt.BasicStroke;
import java.awt.Color;
import javax.swing.JLabel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

public class ReportesConvenios extends javax.swing.JInternalFrame {
    private ControladorVisual unControladorVisual = new ControladorVisual();
    private Utilitario unUtilitario = new Utilitario();
    private TimeSeries producido = new TimeSeries("Producido");
    private TimeSeries cobrado = new TimeSeries("Cobrado");
    private TimeSeriesCollection dataset = new TimeSeriesCollection();
    private JLabel mensaje = new JLabel("mensaje");
   
    public ReportesConvenios() {
        initComponents();
        this.unUtilitario.cargarAnhoActual(tfYear);
        this.unUtilitario.cargarComboObjeto(unControladorVisual.obtenerConvenios(), cmbConvenios);
        generarGraficaAnual(2019);
    }

    public void generarGraficaAnual(int year){
        this.dataset.removeAllSeries();
        this.jpGraficos.removeAll();
        int mes = 0;
        Convenio unConvenio = (Convenio) this.cmbConvenios.getSelectedItem();
        while (mes<=11){
            if(this.unControladorVisual.obtenerProducciones(mes, year, unConvenio)!= null){
                
                producido.addOrUpdate(new Month( mes+1, year), this.unControladorVisual.obtenerProducciones(mes, year, unConvenio).getProducido());
            }else{
                producido.addOrUpdate(new Month( mes+1, year),0);
            }
            
            cobrado.addOrUpdate(new Month( mes+1, year), this.unControladorVisual.obtenerAfiliadoMesYear(year, mes));
            mes++;
        }
        dataset.addSeries(cobrado);
        dataset.addSeries(producido);
        
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Año " +year , "Meses","Pesos",dataset,true,false,false);
        
        this.renderizarGrafico(chart);
    }
    
    
    private void renderizarGrafico(JFreeChart chart){
        XYPlot plot  = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer render = new XYLineAndShapeRenderer();
        render.setSeriesPaint(0, Color.RED);
        render.setSeriesPaint(1, Color.GREEN);
        render.setSeriesStroke(0, new BasicStroke(4.0f));
        render.setSeriesStroke(1, new BasicStroke(6.0f));
        plot.setRenderer(render);
        ChartPanel panel = new ChartPanel(chart);
        panel.setBounds(0, 0, 1168, 556);
        this.jpGraficos.add(panel);
        this.jpGraficos.setEnabled(false);
        panel.setEnabled(false);
        panel.setFocusable(false);
        this.jpGraficos.setFocusable(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlGeneral = new javax.swing.JPanel();
        jpGraficos = new javax.swing.JPanel();
        pnlBusqueda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfYear = new javax.swing.JTextField();
        cmbConvenios = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

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

        tfYear.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tfYear.setText("2019");

        cmbConvenios.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        cmbConvenios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CEMEBA", "ALERTA", "UTE OSPIT", "UTE A. URUGUAY", "TODOS" }));
        cmbConvenios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbConveniosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("CONVENIO:");

        javax.swing.GroupLayout pnlBusquedaLayout = new javax.swing.GroupLayout(pnlBusqueda);
        pnlBusqueda.setLayout(pnlBusquedaLayout);
        pnlBusquedaLayout.setHorizontalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlBusquedaLayout.setVerticalGroup(
            pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBusquedaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBusquedaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbConvenios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
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

    private void cmbConveniosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbConveniosActionPerformed
        this.jpGraficos.removeAll();
        this.generarGraficaAnual(2019);
        
    }//GEN-LAST:event_cmbConveniosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmbConvenios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpGraficos;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlGeneral;
    private javax.swing.JTextField tfYear;
    // End of variables declaration//GEN-END:variables
}
