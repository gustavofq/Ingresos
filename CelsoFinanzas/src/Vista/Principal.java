package Vista;

import javax.swing.JFrame;

public class Principal extends javax.swing.JFrame{
    GestionarListado unGestionarListado = new GestionarListado();
    GestionarIngreso unGestionarIngreso = new GestionarIngreso();
    GestionarEstadisticas unGestionarEstadisticas = new GestionarEstadisticas();
    public Principal() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpContenedor = new javax.swing.JDesktopPane();
        jMenuBar = new javax.swing.JMenuBar();
        jMVendedores = new javax.swing.JMenu();
        jMGestionarCobrador = new javax.swing.JMenuItem();
        jMCobranzas = new javax.swing.JMenu();
        jMIngresos = new javax.swing.JMenuItem();
        jMListado = new javax.swing.JMenuItem();
        jMReporte = new javax.swing.JMenuItem();
        jMAreas = new javax.swing.JMenu();
        jmGestionArea = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dpContenedorLayout = new javax.swing.GroupLayout(dpContenedor);
        dpContenedor.setLayout(dpContenedorLayout);
        dpContenedorLayout.setHorizontalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        dpContenedorLayout.setVerticalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        jMenuBar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        jMVendedores.setText("Cobrador");
        jMVendedores.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMGestionarCobrador.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMGestionarCobrador.setText("Gestionar Cobradores");
        jMGestionarCobrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMGestionarCobradorActionPerformed(evt);
            }
        });
        jMVendedores.add(jMGestionarCobrador);

        jMenuBar.add(jMVendedores);

        jMCobranzas.setText("Cobranzas");
        jMCobranzas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jMIngresos.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMIngresos.setText("Ingresos");
        jMIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIngresosActionPerformed(evt);
            }
        });
        jMCobranzas.add(jMIngresos);

        jMListado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMListado.setText("Listado");
        jMListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListadoActionPerformed(evt);
            }
        });
        jMCobranzas.add(jMListado);

        jMReporte.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jMReporte.setText("Reportes");
        jMReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMReporteActionPerformed(evt);
            }
        });
        jMCobranzas.add(jMReporte);

        jMenuBar.add(jMCobranzas);

        jMAreas.setText("Cartera");
        jMAreas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        jmGestionArea.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jmGestionArea.setText("Gestionar Cartera");
        jmGestionArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionAreaActionPerformed(evt);
            }
        });
        jMAreas.add(jmGestionArea);

        jMenuBar.add(jMAreas);

        jMenu1.setText("ADMIN");

        jMenuItem1.setText("Listado");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Ingreso");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar.add(jMenu1);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpContenedor)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dpContenedor)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMGestionarCobradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMGestionarCobradorActionPerformed
        GestionVendedor unaGestionVendedor = new GestionVendedor();
        this.dpContenedor.add(unaGestionVendedor);
        unaGestionVendedor.setVisible(true);
    }//GEN-LAST:event_jMGestionarCobradorActionPerformed

    private void jmGestionAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionAreaActionPerformed
        GestionarArea unGestionarArea = new GestionarArea();
        this.dpContenedor.add(unGestionarArea);
        unGestionarArea.setVisible(true);
    }//GEN-LAST:event_jmGestionAreaActionPerformed

    private void jMListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListadoActionPerformed
        /*this.dpContenedor.add(unGestionarListado);
        unGestionarListado.setVisible(true);
        unGestionarListado.suscribirObservador(this.unGestionarEstadisticas);
        unGestionarListado.suscribirObservador(unGestionarIngreso);*/
        NuevoListado listado = new NuevoListado();
        this.dpContenedor.add(listado);
        listado.setVisible(true);
    }//GEN-LAST:event_jMListadoActionPerformed

    private void jMIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIngresosActionPerformed
        
        Ingresos unIngresos = new Ingresos();
        this.dpContenedor.add(unIngresos);
        unIngresos.setVisible(true);
        /*this.dpContenedor.add(unGestionarIngreso);
        unGestionarIngreso.setVisible(true);
        unGestionarIngreso.suscribirObservador(this.unGestionarListado);
        unGestionarIngreso.suscribirObservador(this.unGestionarEstadisticas);*/
    }//GEN-LAST:event_jMIngresosActionPerformed

    private void jMReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMReporteActionPerformed
        this.dpContenedor.add(unGestionarEstadisticas);
        unGestionarEstadisticas.setVisible(true);
    }//GEN-LAST:event_jMReporteActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        GestionarListado unGestionarListado = new GestionarListado();
        this.dpContenedor.add(unGestionarListado);
        unGestionarListado.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        GestionarIngreso unGestionarIngreso = new GestionarIngreso();
        this.dpContenedor.add(unGestionarIngreso);
        unGestionarIngreso.setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane dpContenedor;
    private javax.swing.JMenu jMAreas;
    private javax.swing.JMenu jMCobranzas;
    private javax.swing.JMenuItem jMGestionarCobrador;
    private javax.swing.JMenuItem jMIngresos;
    private javax.swing.JMenuItem jMListado;
    private javax.swing.JMenuItem jMReporte;
    private javax.swing.JMenu jMVendedores;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jmGestionArea;
    // End of variables declaration//GEN-END:variables

}
