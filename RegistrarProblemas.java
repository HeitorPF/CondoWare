/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package condoware.CondoWare;

import javax.swing.JOptionPane;

/**
 *
 * @author joaop
 */
public class RegistrarProblemas extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarProblemas
     */
    private RegistrarProblemas() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private static RegistrarProblemas registrarProblemasUnic;
    public static RegistrarProblemas getRegistrarProblemasUnic(){
        if(registrarProblemasUnic == null){
            registrarProblemasUnic = new RegistrarProblemas();
        }
        return registrarProblemasUnic;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtDesc = new javax.swing.JTextArea();
        rotDescriçao = new javax.swing.JLabel();
        rotBloco = new javax.swing.JLabel();
        cxBloco = new javax.swing.JTextField();
        btEnviar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        btHistorico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de Problemas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        txtDesc.setColumns(20);
        txtDesc.setRows(5);
        jScrollPane1.setViewportView(txtDesc);

        rotDescriçao.setText("Descrição do Problema:");

        rotBloco.setText("Bloco do Problema (opcional):");

        btEnviar.setText("Enviar");
        btEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEnviarActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btHistorico.setText("Histórico de Problemas");
        btHistorico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHistoricoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rotDescriçao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rotBloco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxBloco, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btHistorico)
                        .addGap(18, 18, 18)
                        .addComponent(btEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(rotDescriçao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotBloco)
                    .addComponent(cxBloco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btEnviar)
                    .addComponent(btVoltar)
                    .addComponent(btHistorico))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEnviarActionPerformed
        if(cxBloco.getText().equals("")) {
            if(Conexao.getConexao().registrarProblemas(CondoWare.getCpf(), txtDesc.getText()) == 1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Problema enviado com sucesso",
                        "Problema",
                        1);
            }
            else {
                JOptionPane.showMessageDialog(
                        null,
                        "Problema não enviado",
                        "Problema",
                        0);
            }
        }
        else {
            if(Conexao.getConexao().registrarProblemas(CondoWare.getCpf(), txtDesc.getText(), (cxBloco.getText())) == 1) {
                JOptionPane.showMessageDialog(
                        null,
                        "Problema enviado com sucesso",
                        "Problema",
                        1);
            }
            else {
                JOptionPane.showMessageDialog(
                        null,
                        "Problema não enviado",
                        "Problema",
                        0);
            }
        }
    }//GEN-LAST:event_btEnviarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        txtDesc.setText("");
        cxBloco.setText("");
    }//GEN-LAST:event_formWindowActivated

    private void btHistoricoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHistoricoActionPerformed
        HistoricoProblema.getHistoricoProblemaUnicUnic().setVisible(true);
    }//GEN-LAST:event_btHistoricoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEnviar;
    private javax.swing.JButton btHistorico;
    private javax.swing.JButton btVoltar;
    private javax.swing.JTextField cxBloco;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel rotBloco;
    private javax.swing.JLabel rotDescriçao;
    private javax.swing.JTextArea txtDesc;
    // End of variables declaration//GEN-END:variables
}
