/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import java.awt.GridLayout;
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
public class Telas_Cardapio extends javax.swing.JFrame {

    private Telas_Inicio inicio;
    private static DefaultTableModel modeloBebidas;
    private static DefaultTableModel modeloPratos;
    private static JTable tBebidas;
    private static JTable tPratos;

    /**
     * Creates new form Consumo
     */
    public Telas_Cardapio(Telas_Inicio inicio) {
        this.inicio = inicio;

        initComponents();
        inicializarAbas();
        gravarLog("Bebida", "Coca Cola", 3.56, 75);
        gravarLog("Prato", "Cheese Burguer", 8.70, 30);
//        JComponent panelBebidas = makeTextPanel("Tudo as Bebida");
//        jTabbedPaneCardapio.addTab("Bebidas", panelBebidas);
//        JComponent panelPratos = makeTextPanel("Tudo as Comida");
//        jTabbedPaneCardapio.addTab("Pratos", panelPratos);

    }

    public void inicializarAbas() {
        String[] colunas = {"Produto", "Valor", "Quantidade"};

        String[][] dadosBebidas = {{"cerveja", "3,57", "150"},
        {"refrigerante", "2,50", "70"}};

        String[][] dadosPratos = {{"Hot Dog", "6,70", "40"},
        {"porção Fritas", "14,50", "50"}};

        modeloBebidas = new DefaultTableModel(dadosBebidas, colunas);
        modeloPratos = new DefaultTableModel(dadosPratos, colunas);
        tBebidas = new JTable(modeloBebidas);
        tPratos = new JTable(modeloPratos);
        jTabbedPaneCardapio.add("Bebidas", tBebidas);
        jTabbedPaneCardapio.add("Pratos", tPratos);
    }

    public static void gravarLog(String tab, String nome, double preco, int quantidade) {
        if (tab.equals("Bebida")) {
            modeloBebidas.addRow(new String[]{nome, String.format("%.2f", preco), String.valueOf(quantidade)});
        } else {
            modeloPratos.addRow(new String[]{nome, String.format("%.2f", preco), String.valueOf(quantidade)});
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
        jButtonTelaInicial = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldNome = new javax.swing.JTextField();
        jComboBoxCategoria = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldPreco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldQuantidade = new javax.swing.JTextField();
        jButtonInserir = new javax.swing.JButton();
        jButtonDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButtonTelaInicial.setBackground(new java.awt.Color(120, 180, 125));
        jButtonTelaInicial.setForeground(new java.awt.Color(14, 63, 80));
        jButtonTelaInicial.setText("Tela Inicial");
        jButtonTelaInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTelaInicialActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(30, 120, 120));
        jLabel1.setText("Nome:");

        jComboBoxCategoria.setBackground(new java.awt.Color(120, 180, 125));
        jComboBoxCategoria.setForeground(new java.awt.Color(35, 120, 120));
        jComboBoxCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebida", "Comida", " " }));

        jLabel2.setForeground(new java.awt.Color(35, 120, 120));
        jLabel2.setText("Preço (R$):");

        jLabel3.setForeground(new java.awt.Color(35, 120, 120));
        jLabel3.setText("Quantidade:");

        jButtonInserir.setBackground(new java.awt.Color(120, 180, 125));
        jButtonInserir.setForeground(new java.awt.Color(14, 63, 80));
        jButtonInserir.setText("Inserir");
        jButtonInserir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInserirActionPerformed(evt);
            }
        });

        jButtonDeletar.setBackground(new java.awt.Color(120, 180, 125));
        jButtonDeletar.setForeground(new java.awt.Color(14, 63, 80));
        jButtonDeletar.setText("Deletar");
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });

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
                                .addComponent(jComboBoxCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonInserir)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTelaInicial)))
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
                    .addComponent(jTextFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInserir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonTelaInicial)
                    .addComponent(jButtonDeletar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTelaInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTelaInicialActionPerformed
        inicio.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButtonTelaInicialActionPerformed

    private void jButtonInserirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInserirActionPerformed
        if (jTextFieldNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Informar Nome.",
                    "Dados Incompletos",
                    JOptionPane.ERROR_MESSAGE);
        } else if (jTextFieldPreco.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Informar preço.",
                    "Dados Incompletos",
                    JOptionPane.ERROR_MESSAGE);
        } else if (jTextFieldQuantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Informar quantidade.",
                    "Dados Incompletos",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            gravarLog(jComboBoxCategoria.getSelectedItem().toString(), jTextFieldNome.getText(), Double.parseDouble(jTextFieldPreco.getText()), Integer.parseInt(jTextFieldQuantidade.getText()));
        }
    }//GEN-LAST:event_jButtonInserirActionPerformed

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        if (jTabbedPaneCardapio.getSelectedIndex() == 0) {
            if (tBebidas.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Selecionar produto à ser deletado.",
                        "Operação Inválida",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                modeloBebidas.removeRow(tBebidas.getSelectedRow());
            }
        } else if (jTabbedPaneCardapio.getSelectedIndex() == 1) {
            if (tPratos.getSelectedRow() == -1) {
                JOptionPane.showMessageDialog(null,
                        "Selecionar produto à ser deletado.",
                        "Operação Inválida",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                modeloPratos.removeRow(tPratos.getSelectedRow());
            }
        }
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    public void addProdudo() {
    }

    protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(true);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonInserir;
    private javax.swing.JButton jButtonTelaInicial;
    private javax.swing.JComboBox<String> jComboBoxCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPaneCardapio;
    private javax.swing.JTextField jTextFieldNome;
    private javax.swing.JTextField jTextFieldPreco;
    private javax.swing.JTextField jTextFieldQuantidade;
    // End of variables declaration//GEN-END:variables
}
