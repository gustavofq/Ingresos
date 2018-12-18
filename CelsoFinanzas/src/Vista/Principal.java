package Vista;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dpContenedor = new javax.swing.JDesktopPane();
        jMenuBar = new javax.swing.JMenuBar();
        jMVendedores = new javax.swing.JMenu();
        jMGestionarCobrador = new javax.swing.JMenuItem();
        jMComisionV = new javax.swing.JMenuItem();
        jMCobranzas = new javax.swing.JMenu();
        jMIngresos = new javax.swing.JMenuItem();
        jMListado = new javax.swing.JMenuItem();
        jMReporte = new javax.swing.JMenuItem();
        jMAreas = new javax.swing.JMenu();
        jmGestionArea = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout dpContenedorLayout = new javax.swing.GroupLayout(dpContenedor);
        dpContenedor.setLayout(dpContenedorLayout);
        dpContenedorLayout.setHorizontalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        dpContenedorLayout.setVerticalGroup(
            dpContenedorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );

        jMVendedores.setText("Cobrador");
        jMVendedores.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jMGestionarCobrador.setText("Gestionar Cobradores");
        jMGestionarCobrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMGestionarCobradorActionPerformed(evt);
            }
        });
        jMVendedores.add(jMGestionarCobrador);

        jMComisionV.setText("Comisiones");
        jMComisionV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMComisionVActionPerformed(evt);
            }
        });
        jMVendedores.add(jMComisionV);

        jMenuBar.add(jMVendedores);

        jMCobranzas.setText("Cobranzas");

        jMIngresos.setText("Ingresos");
        jMIngresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMIngresosActionPerformed(evt);
            }
        });
        jMCobranzas.add(jMIngresos);

        jMListado.setText("Listado");
        jMListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMListadoActionPerformed(evt);
            }
        });
        jMCobranzas.add(jMListado);

        jMReporte.setText("Reportes");
        jMCobranzas.add(jMReporte);

        jMenuBar.add(jMCobranzas);

        jMAreas.setText("Areas");

        jmGestionArea.setText("Gestionar Areas");
        jmGestionArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmGestionAreaActionPerformed(evt);
            }
        });
        jMAreas.add(jmGestionArea);

        jMenuBar.add(jMAreas);

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
        unaGestionVendedor.show();
    }//GEN-LAST:event_jMGestionarCobradorActionPerformed

    private void jmGestionAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmGestionAreaActionPerformed
        GestionarArea unGestionarArea = new GestionarArea();
        this.dpContenedor.add(unGestionarArea);
        unGestionarArea.setVisible(true);
    }//GEN-LAST:event_jmGestionAreaActionPerformed

    private void jMComisionVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMComisionVActionPerformed
        GestionComision unaGestionComision = new GestionComision();
        this.dpContenedor.add(unaGestionComision);
        unaGestionComision.setVisible(true);
    }//GEN-LAST:event_jMComisionVActionPerformed

    private void jMListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMListadoActionPerformed
        GestionarListado unGestionarListado = new GestionarListado();
        this.dpContenedor.add(unGestionarListado);
        unGestionarListado.setVisible(true);
    }//GEN-LAST:event_jMListadoActionPerformed

    private void jMIngresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMIngresosActionPerformed
        GestionarIngreso unGestionarIngreso = new GestionarIngreso();
        this.dpContenedor.add(unGestionarIngreso);
        unGestionarIngreso.setVisible(true);
    }//GEN-LAST:event_jMIngresosActionPerformed

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
    private javax.swing.JMenuItem jMComisionV;
    private javax.swing.JMenuItem jMGestionarCobrador;
    private javax.swing.JMenuItem jMIngresos;
    private javax.swing.JMenuItem jMListado;
    private javax.swing.JMenuItem jMReporte;
    private javax.swing.JMenu jMVendedores;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jmGestionArea;
    // End of variables declaration//GEN-END:variables
}
