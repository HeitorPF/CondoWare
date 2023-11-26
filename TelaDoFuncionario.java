/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package condoware.CondoWare;

/**
 *
 * @author joaop
 */
public class TelaDoFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form TelaDoCondomino
     */
    private TelaDoFuncionario() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private static TelaDoFuncionario telaFuncUnic;
    public static TelaDoFuncionario getTelaFuncUnic(){
        if(telaFuncUnic == null){
            telaFuncUnic = new TelaDoFuncionario();
        }
        return telaFuncUnic;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btRegistarProblemas = new javax.swing.JButton();
        btGerenciarEspaços = new javax.swing.JButton();
        btDadosPessoais = new javax.swing.JButton();
        btGerenciarPortão = new javax.swing.JButton();
        btRegistrarVisitante = new javax.swing.JButton();
        bRegistrarEmpressas = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Inicial");

        btRegistarProblemas.setText("Registrar Problemas");
        btRegistarProblemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistarProblemasActionPerformed(evt);
            }
        });

        btGerenciarEspaços.setText("Gerenciar Espaços");
        btGerenciarEspaços.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciarEspaçosActionPerformed(evt);
            }
        });

        btDadosPessoais.setText("Dados Pessoais");
        btDadosPessoais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDadosPessoaisActionPerformed(evt);
            }
        });

        btGerenciarPortão.setText("Gerenciar Portão");
        btGerenciarPortão.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGerenciarPortãoActionPerformed(evt);
            }
        });

        btRegistrarVisitante.setText("Registrar Visitante");
        btRegistrarVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegistrarVisitanteActionPerformed(evt);
            }
        });

        bRegistrarEmpressas.setText("Registrar Empresas");
        bRegistrarEmpressas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistrarEmpressasActionPerformed(evt);
            }
        });

        jButton1.setText("Empresas Parceiras");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bRegistrarEmpressas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRegistarProblemas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciarEspaços, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDadosPessoais, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btGerenciarPortão, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRegistrarVisitante, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btDadosPessoais)
                .addGap(18, 18, 18)
                .addComponent(btGerenciarEspaços)
                .addGap(18, 18, 18)
                .addComponent(btRegistarProblemas)
                .addGap(18, 18, 18)
                .addComponent(btGerenciarPortão)
                .addGap(18, 18, 18)
                .addComponent(btRegistrarVisitante)
                .addGap(18, 18, 18)
                .addComponent(bRegistrarEmpressas)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btRegistarProblemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistarProblemasActionPerformed
        RegistrarProblemas.getRegistrarProblemasUnic().setVisible(true);
    }//GEN-LAST:event_btRegistarProblemasActionPerformed

    private void btDadosPessoaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDadosPessoaisActionPerformed
        DadosPessoaisFuncionarios.getDadosPessoaisFuncUnic().setVisible(true);
    }//GEN-LAST:event_btDadosPessoaisActionPerformed

    private void btGerenciarEspaçosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciarEspaçosActionPerformed
        GerenciarEspaços.getTelaFuncUnic().setVisible(true);
    }//GEN-LAST:event_btGerenciarEspaçosActionPerformed

    private void btGerenciarPortãoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGerenciarPortãoActionPerformed
       GerenciarPortão.getGerenciarPortaoUnic().setVisible(true);
    }//GEN-LAST:event_btGerenciarPortãoActionPerformed

    private void bRegistrarEmpressasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistrarEmpressasActionPerformed
        RegistrarEmpresas.getRegistrarEmpresasUnic().setVisible(true);
    }//GEN-LAST:event_bRegistrarEmpressasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        EmpresasParceiras.getEmpresasParceirasUnic().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btRegistrarVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegistrarVisitanteActionPerformed
        RegistrarVisitante.getRegistrarVisitanteUnic().setVisible(true);
    }//GEN-LAST:event_btRegistrarVisitanteActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TelaDoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDoFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDoFuncionario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bRegistrarEmpressas;
    private javax.swing.JButton btDadosPessoais;
    private javax.swing.JButton btGerenciarEspaços;
    private javax.swing.JButton btGerenciarPortão;
    private javax.swing.JButton btRegistarProblemas;
    private javax.swing.JButton btRegistrarVisitante;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
