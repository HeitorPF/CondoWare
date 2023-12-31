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
public class ApagarCondomino extends javax.swing.JFrame {

    int ap = 0;
    String nome = "";
    /**
     * Creates new form AddFuncionario
     */
    private ApagarCondomino() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    private static ApagarCondomino apagarCondominoUnic;
    public static ApagarCondomino getApagarCondominoUnic() {
        if (apagarCondominoUnic == null) {
            apagarCondominoUnic= new ApagarCondomino();
        }
        return apagarCondominoUnic;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rotNome = new javax.swing.JLabel();
        rotCPF = new javax.swing.JLabel();
        rotBloco = new javax.swing.JLabel();
        rotAp = new javax.swing.JLabel();
        rotEmail = new javax.swing.JLabel();
        rotSenha = new javax.swing.JLabel();
        rotPlaca = new javax.swing.JLabel();
        cxNome = new javax.swing.JTextField();
        cxCPF = new javax.swing.JTextField();
        cxBloco = new javax.swing.JTextField();
        cxAp = new javax.swing.JTextField();
        cxEmail = new javax.swing.JTextField();
        cxSenha = new javax.swing.JTextField();
        cxPlaca = new javax.swing.JTextField();
        btDeletar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Deletar Condômino");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        rotNome.setText("Nome:");

        rotCPF.setText("CPF:");

        rotBloco.setText("Bloco:");

        rotAp.setText("Apartamento:");

        rotEmail.setText("Email:");

        rotSenha.setText("Senha:");

        rotPlaca.setText("Placa do Veiculo:");

        btDeletar.setText("Deletar");
        btDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeletarActionPerformed(evt);
            }
        });

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rotCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cxCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotBloco)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cxBloco))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotAp)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cxAp))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cxEmail))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(rotSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cxSenha))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(rotPlaca)
                                .addComponent(btVoltar))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cxPlaca)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(btDeletar))))))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotNome)
                    .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotCPF)
                    .addComponent(cxCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotBloco)
                    .addComponent(cxBloco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotAp)
                    .addComponent(cxAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotEmail)
                    .addComponent(cxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotSenha)
                    .addComponent(cxSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotPlaca)
                    .addComponent(cxPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btVoltar)
                    .addComponent(btDeletar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
        limpar();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        desativarCaixas();
        mostrarDados();
    }//GEN-LAST:event_formWindowActivated

    private void btDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeletarActionPerformed
        int res = Conexao.getConexao().apagarCondomino(cxCPF.getText());
        if(res == 1) {
            JOptionPane.showMessageDialog(
                        null,
                        "Condômino apagado com sucesso",
                        "Apagar",
                        1);
            this.dispose();
        }
        else {
            JOptionPane.showMessageDialog(
                        null,
                        "Erro ao apagar condômino",
                        "Apagar",
                        0);
        }
    }//GEN-LAST:event_btDeletarActionPerformed

    public void receberApNome(int numAp, String name){
        ap = numAp;
        nome = name;
    }
    
    public void mostrarDados(){
        int index = Conexao.getConexao().achaCondominoAp(ap,nome);
        cxNome.setText(Bancos.getBancos().getBdCondomino().get(index).getNome());
        cxCPF.setText(Bancos.getBancos().getBdCondomino().get(index).getCpf());
        cxEmail.setText(Bancos.getBancos().getBdCondomino().get(index).getEmail());
        cxSenha.setText(Bancos.getBancos().getBdCondomino().get(index).getSenha());
        cxBloco.setText(Integer.toString(Bancos.getBancos().getBdCondomino().get(index).getBloco()));
        cxAp.setText(Integer.toString(Bancos.getBancos().getBdCondomino().get(index).getApartamento()));
        cxPlaca.setText(Bancos.getBancos().getBdCondomino().get(index).getVeiculo().getPlaca());
    }
    
    public void limpar(){
        cxNome.setText("");
        cxBloco.setText("");
        cxAp.setText("");
        cxEmail.setText("");
        cxSenha.setText("");
        cxPlaca.setText("");
    }
    
    public void desativarCaixas(){
        cxNome.setEnabled(false);
        cxCPF.setEnabled(false);
        cxEmail.setEnabled(false);
        cxSenha.setEnabled(false);
        cxBloco.setEnabled(false);
        cxAp.setEnabled(false);
        cxPlaca.setEnabled(false); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDeletar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JTextField cxAp;
    private javax.swing.JTextField cxBloco;
    private javax.swing.JTextField cxCPF;
    private javax.swing.JTextField cxEmail;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxPlaca;
    private javax.swing.JTextField cxSenha;
    private javax.swing.JLabel rotAp;
    private javax.swing.JLabel rotBloco;
    private javax.swing.JLabel rotCPF;
    private javax.swing.JLabel rotEmail;
    private javax.swing.JLabel rotNome;
    private javax.swing.JLabel rotPlaca;
    private javax.swing.JLabel rotSenha;
    // End of variables declaration//GEN-END:variables
}
