package condoware.CondoWare;

import javax.swing.JOptionPane;

public class DadosPessoaisCondômino extends javax.swing.JFrame {

    /**
     * Creates new form DadosPessoais
     */
    private DadosPessoaisCondômino() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private static DadosPessoaisCondômino dadosPessoaisCondUnic;
    public static DadosPessoaisCondômino getDadosPessoaisCondUnic(){
        if(dadosPessoaisCondUnic == null){
            dadosPessoaisCondUnic = new DadosPessoaisCondômino();
        }
        return dadosPessoaisCondUnic;
    }
    
    private int index = 0;

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
        rotEmail = new javax.swing.JLabel();
        rotSenha = new javax.swing.JLabel();
        rotBloco = new javax.swing.JLabel();
        rotApartamento = new javax.swing.JLabel();
        cxNome = new javax.swing.JTextField();
        cxCPF = new javax.swing.JTextField();
        cxEmail = new javax.swing.JTextField();
        cxBloco = new javax.swing.JTextField();
        cxSenha = new javax.swing.JPasswordField();
        cxAp = new javax.swing.JTextField();
        btVoltar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btSalvarMudanças = new javax.swing.JButton();
        rotPlaca = new javax.swing.JLabel();
        cxPlaca = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dados Pessoais");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        rotNome.setText("Nome:");

        rotCPF.setText("CPF:");

        rotEmail.setText("Email:");

        rotSenha.setText("Senha:");

        rotBloco.setText("Bloco:");

        rotApartamento.setText("Apartamento:");

        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btSalvarMudanças.setText("Salvar Mudanças");
        btSalvarMudanças.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarMudançasActionPerformed(evt);
            }
        });

        rotPlaca.setText("Placa do Veiculo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btVoltar)
                        .addGap(41, 41, 41)
                        .addComponent(btEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btSalvarMudanças))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rotPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cxPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rotNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxNome))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rotCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxCPF))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rotEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxEmail))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rotSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxSenha))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rotBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxBloco))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(rotApartamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cxAp)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotNome)
                    .addComponent(cxNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotCPF)
                    .addComponent(cxCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotEmail)
                    .addComponent(cxEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotSenha)
                    .addComponent(cxSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotBloco)
                    .addComponent(cxBloco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotApartamento)
                    .addComponent(cxAp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rotPlaca)
                    .addComponent(cxPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvarMudanças)
                    .addComponent(btEditar)
                    .addComponent(btVoltar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        setarCaixasCond();
    }//GEN-LAST:event_formWindowActivated

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        ativarEdicao();
    }//GEN-LAST:event_btEditarActionPerformed

    private void btSalvarMudançasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarMudançasActionPerformed
        int editCondomino = Conexao.getConexao().editCondomino(cxCPF.getText(), cxNome.getText(),cxPlaca.getText(), cxEmail.getText(), cxSenha.getText());
        if(editCondomino == 1){
            JOptionPane.showMessageDialog(
                        null,
                        "Dados alterados com sucesso!",
                        "Alterado",
                        1);
        }
        else {
            JOptionPane.showMessageDialog(
                        null,
                        "Erro na alteração de dados!",
                        "Erro!",
                        0);
        }
        Conexao.getConexao().atualizaBancoCondomino();
        setarCaixasCond();
        desativarCaixas();
    }//GEN-LAST:event_btSalvarMudançasActionPerformed

    public void desativarCaixas(){
        cxNome.setEnabled(false);
        cxCPF.setEnabled(false);
        cxEmail.setEnabled(false);
        cxSenha.setEnabled(false);
        cxBloco.setEnabled(false);
        cxAp.setEnabled(false);
        cxPlaca.setEnabled(false); 
    }
    
    public void ativarEdicao(){
        cxNome.setEnabled(true);
        cxEmail.setEnabled(true);
        cxSenha.setEnabled(true);
        cxPlaca.setEnabled(true);
    }
    
    public void setarCaixasCond(){
        index = Conexao.getConexao().achaCondominoCpf(CondoWare.getCpf());
        cxNome.setText(Bancos.getBancos().getBdCondomino().get(index).getNome());
        cxCPF.setText(Bancos.getBancos().getBdCondomino().get(index).getCpf());
        cxEmail.setText(Bancos.getBancos().getBdCondomino().get(index).getEmail());
        cxSenha.setText(Bancos.getBancos().getBdCondomino().get(index).getSenha());
        cxBloco.setText(Integer.toString(Bancos.getBancos().getBdCondomino().get(index).getBloco()));
        cxAp.setText(Integer.toString(Bancos.getBancos().getBdCondomino().get(index).getApartamento()));  
        cxPlaca.setText(Bancos.getBancos().getBdCondomino().get(index).getVeiculo().getPlaca());
        desativarCaixas();  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btSalvarMudanças;
    private javax.swing.JButton btVoltar;
    private javax.swing.JTextField cxAp;
    private javax.swing.JTextField cxBloco;
    private javax.swing.JTextField cxCPF;
    private javax.swing.JTextField cxEmail;
    private javax.swing.JTextField cxNome;
    private javax.swing.JTextField cxPlaca;
    private javax.swing.JPasswordField cxSenha;
    private javax.swing.JLabel rotApartamento;
    private javax.swing.JLabel rotBloco;
    private javax.swing.JLabel rotCPF;
    private javax.swing.JLabel rotEmail;
    private javax.swing.JLabel rotNome;
    private javax.swing.JLabel rotPlaca;
    private javax.swing.JLabel rotSenha;
    // End of variables declaration//GEN-END:variables
}
