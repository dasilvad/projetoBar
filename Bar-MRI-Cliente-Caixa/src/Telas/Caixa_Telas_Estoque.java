/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import PacotePrincipal.*;
import clienteCaixaPER.ProdutoPER;
import clienteCaixaRN.ProdutoRN;
import java.awt.GridLayout;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author adson
 */
public class Caixa_Telas_Estoque extends javax.swing.JFrame {

    private Caixa_Telas_Inicio inicio;
    private static DefaultTableModel tabelaBebidas;
    private static DefaultTableModel tabelaPratos;
    private static JTable tBebidas;
    private static JTable tPratos;
    private String acao = "novo";//Acao pode ser: "editar" ou "novo"
    ArrayList<Produto> produto;//armazena o estoque para mostrar na tela
    /**
     * Creates new form Consumo
     */
    public Caixa_Telas_Estoque(Caixa_Telas_Inicio inicio) {
        this.inicio = inicio;

        initComponents();
        inicializarAbas();
        
//        JComponent panelBebidas = makeTextPanel("Tudo as Bebida");
//        jTabbedPaneCardapio.addTab("Bebidas", panelBebidas);
//        JComponent panelPratos = makeTextPanel("Tudo as Comida");
//        jTabbedPaneCardapio.addTab("Pratos", panelPratos);

    }

    public void inicializarAbas() {
        String[] colunas = {"Produto", "Valor", "Quantidade", "id"};

        String[][] dadosBebidas = {};

        String[][] dadosPratos = {};
        

        tabelaBebidas = new DefaultTableModel(dadosBebidas, colunas);
        tabelaPratos = new DefaultTableModel(dadosPratos, colunas);
        
        
        
        //System.out.println(tabelaBebidas.getColumnClass(3).);
        
        
        tBebidas = new JTable(tabelaBebidas);
        tPratos = new JTable(tabelaPratos);
        
        tBebidas.getColumn("id").setPreferredWidth(0);
        tBebidas.getColumn("id").setMinWidth(0);
        tBebidas.getColumn("id").setWidth(0);
        tBebidas.getColumn("id").setMaxWidth(0);
        
        jTabbedPaneCardapio.add("Bebidas", tBebidas);
        jTabbedPaneCardapio.add("Pratos", tPratos);
        
        ProdutoPER produtoPER = new ProdutoPER();
        try {
            this.produto = produtoPER.buscarProdutos();
            
            for (int i=0; i < produto.size(); i++){
                this.mostrarEstoqueNaTela(produto.get(i).getCategoria(), produto.get(i).getNome(), produto.get(i).getPreco(), produto.get(i).getQuantidade(), String.valueOf(produto.get(i).getId()));
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar dados");
        }
        
    }

    public static void mostrarEstoqueNaTela(String categoria, String nome, double preco, int quantidade, String id) {
        if (categoria.equals("Bebida")) {
            tabelaBebidas.addRow(new String[]{nome, String.format("%.2f", preco), String.valueOf(quantidade), id});
        } else {
            tabelaPratos.addRow(new String[]{nome, String.format("%.2f", preco), String.valueOf(quantidade), id});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneCardapio = new javax.swing.JTabbedPane();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jComboBoxCategoria = new javax.swing.JComboBox<String>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jBDeletarProduto = new javax.swing.JButton();
        jBSalvarProduto = new javax.swing.JButton();
        jBNovoProduto = new javax.swing.JButton();
        jBEditarProduto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estoque");
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jTabbedPaneCardapio.setAutoscrolls(true);

        jLabel1.setForeground(new java.awt.Color(30, 120, 120));
        jLabel1.setText("Nome:");

        jComboBoxCategoria.setBackground(new java.awt.Color(120, 180, 125));
        jComboBoxCategoria.setForeground(new java.awt.Color(35, 120, 120));
        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bebida", "Comida", " " }));

        jLabel2.setForeground(new java.awt.Color(35, 120, 120));
        jLabel2.setText("Preço (R$):");

        jLabel3.setForeground(new java.awt.Color(35, 120, 120));
        jLabel3.setText("Quantidade:");

        jBDeletarProduto.setBackground(new java.awt.Color(120, 180, 125));
        jBDeletarProduto.setForeground(new java.awt.Color(14, 63, 80));
        jBDeletarProduto.setText("Deletar");
        jBDeletarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBDeletarProdutoActionPerformed(evt);
            }
        });

        jBSalvarProduto.setText("Salvar");
        jBSalvarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSalvarProdutoActionPerformed(evt);
            }
        });

        jBNovoProduto.setText("Novo");
        jBNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBNovoProdutoActionPerformed(evt);
            }
        });

        jBEditarProduto.setText("Editar");
        jBEditarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBEditarProdutoActionPerformed(evt);
            }
        });

        jLabel4.setText("Produto");

        jLabel5.setText("Preço");

        jLabel6.setText("Quantidade");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPaneCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboBoxCategoria, 0, 166, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel5)
                                        .addGap(70, 70, 70)
                                        .addComponent(jLabel6)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jBDeletarProduto)
                        .addGap(18, 18, 18)
                        .addComponent(jBEditarProduto)
                        .addGap(18, 18, 18)
                        .addComponent(jBSalvarProduto)
                        .addGap(18, 18, 18)
                        .addComponent(jBNovoProduto)
                        .addGap(65, 65, 65)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBDeletarProduto)
                    .addComponent(jBSalvarProduto)
                    .addComponent(jBNovoProduto)
                    .addComponent(jBEditarProduto))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBDeletarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBDeletarProdutoActionPerformed
        if (jTabbedPaneCardapio.getSelectedIndex() == 0) {
            if (tBebidas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Selecione um produto",
                        "Operação Inválida",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                ProdutoRN prn = new ProdutoRN();
                int id_produto = Integer.parseInt((String) tBebidas.getValueAt(tBebidas.getSelectedRow(), 3));
                if (prn.deletarProduto(id_produto)){
                    tabelaBebidas.removeRow(tBebidas.getSelectedRow());
                }else{
                    JOptionPane.showMessageDialog(null,
                        "Erro ao deletar Produto!.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                }
                                            
            }
           
        } else if (jTabbedPaneCardapio.getSelectedIndex() == 1) {
            if (tPratos.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Selecione um produto",
                        "Operação Inválida",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                ProdutoRN prn = new ProdutoRN();
                int id_produto = Integer.parseInt((String) tPratos.getValueAt(tPratos.getSelectedRow(), 3));
                if (prn.deletarProduto(id_produto)){
                    tabelaPratos.removeRow(tPratos.getSelectedRow());
                }else{
                    JOptionPane.showMessageDialog(null,
                        "Erro ao deletar Produto!.",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jBDeletarProdutoActionPerformed

    private void jBSalvarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSalvarProdutoActionPerformed
        if (acao.equals("novo")){
            
            try{
                String nome = this.jTextFieldNome.getText();
                String categoria = this.jComboBoxCategoria.getSelectedItem().toString();
                float preco = Float.parseFloat(this.jTextFieldPreco.getText());
                int quantidade = Integer.parseInt(this.jTextFieldQuantidade.getText());
                Produto produto = new Produto (nome, categoria, preco, quantidade);
                ProdutoRN produtoRN = new ProdutoRN();

                //-2: campos nao preenchidos incorretamente
                //-1: erro ao salvar no banco de dados
                // >=0: chave primaria do produto inserido
                int codigo = produtoRN.inserirProduto(produto);

                if (codigo >=0){
                    mostrarEstoqueNaTela(categoria, nome, preco, quantidade, String.valueOf(codigo));
                    JOptionPane.showMessageDialog(null, "Produto Inserido com Sucesso!");
                }else if (codigo == -1){
                     JOptionPane.showMessageDialog(null, "Erro ao Salvar no banco de dados. Tente novamente.");
                }else if (codigo == -2){
                     JOptionPane.showMessageDialog(null, "Campos invalidos");
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Campos invalidos");
                return;
            }
        }else if (acao.equals("editar")){
            System.out.println("editar not implemented yet!");
        }
    }//GEN-LAST:event_jBSalvarProdutoActionPerformed

    private void jBNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBNovoProdutoActionPerformed
        this.acao = "novo";
        this.jTextFieldNome.setText("");
        this.jTextFieldPreco.setText("");
        this.jTextFieldQuantidade.setText("");
    }//GEN-LAST:event_jBNovoProdutoActionPerformed

    private void jBEditarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBEditarProdutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBEditarProdutoActionPerformed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowGainedFocus

    

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(true);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBDeletarProduto;
    private javax.swing.JButton jBEditarProduto;
    private javax.swing.JButton jBNovoProduto;
    private javax.swing.JButton jBSalvarProduto;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPaneCardapio;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQuantidade;
    // End of variables declaration//GEN-END:variables
}
