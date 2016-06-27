/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import PacotePrincipal.Consumo;
import PacotePrincipal.ItemPedido;
import PacotePrincipal.Produto;
import clienteCaixaRN.ConsumoRN;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniel
 */
public class InicioCaixa extends javax.swing.JFrame {
    
    private DefaultTableModel modelPedido;

    ArrayList<Consumo> listConsumo;
    /**
     * Creates new form InicioCaixa
     */
    public InicioCaixa() {
        initComponents();
        
        this.modelPedido = new DefaultTableModel();
        this.modelPedido.addColumn("Item");
        this.modelPedido.addColumn("Preco Unitário");
        this.modelPedido.addColumn("Quantidade");
        this.modelPedido.addColumn("Subtotal");
        
        this.jTablePedido.setModel(this.modelPedido);
        
        
        this.buscarMesas();
        
        //this.mostrarHistoricoNaTela();
        //this.calcularTotalDoPedido();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePedido = new javax.swing.JTable();
        jLabelNomeMesa = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jComboBoxNomeMesa = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuEstoque = new javax.swing.JMenu();
        jMenuItemGerenciarEstoque = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(982, 622));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTablePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Quantidade", "Subtotal"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTablePedido);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, 490, 370));

        jLabelNomeMesa.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelNomeMesa.setText("Mesa ");
        getContentPane().add(jLabelNomeMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setText("Items Pedidos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 60, -1, -1));

        jLabelTotal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelTotal.setText("Total: 0");
        getContentPane().add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 500, -1, -1));

        jComboBoxNomeMesa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        jComboBoxNomeMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxNomeMesaActionPerformed(evt);
            }
        });
        jComboBoxNomeMesa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBoxNomeMesaFocusGained(evt);
            }
        });
        getContentPane().add(jComboBoxNomeMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jMenuEstoque.setText("Estoque");

        jMenuItemGerenciarEstoque.setText("Gerenciar Estoque");
        jMenuItemGerenciarEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGerenciarEstoqueActionPerformed(evt);
            }
        });
        jMenuEstoque.add(jMenuItemGerenciarEstoque);

        jMenuBar1.add(jMenuEstoque);

        jMenu2.setText("Sobre");

        jMenuItem2.setText("About");
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxNomeMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxNomeMesaActionPerformed
        if (this.jComboBoxNomeMesa.getSelectedIndex() > 0){
            try {
                listConsumo = new ArrayList<Consumo>();
                
                ConsumoRN consumoRN = new ConsumoRN();
                String id_mesa = this.jComboBoxNomeMesa.getSelectedItem().toString();
                listConsumo = consumoRN.buscarConsumo(id_mesa);
                if (listConsumo.size() > 0){
                    System.out.println("Selecionou elemento: "+id_mesa);
                    System.out.println("quantidade: "+listConsumo.get(0).getQuantidade());
                    this.mostrarConsumoNaTela(listConsumo);
                    this.calcularTotalDoPedido();
                }
            } catch (RemoteException ex) {
                JOptionPane.showMessageDialog(null, "Erro ao buscar conta");
            }
        }else if (this.jComboBoxNomeMesa.getSelectedIndex() == 0){
            this.removerTodosElementosTabelaConsumo();
        }
    }//GEN-LAST:event_jComboBoxNomeMesaActionPerformed

    private void jComboBoxNomeMesaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBoxNomeMesaFocusGained
         this.buscarMesas();
    }//GEN-LAST:event_jComboBoxNomeMesaFocusGained

    private void jMenuItemGerenciarEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGerenciarEstoqueActionPerformed
        TelaEstoque telaEstoque = new TelaEstoque();
        telaEstoque.setVisible(true);
    }//GEN-LAST:event_jMenuItemGerenciarEstoqueActionPerformed
    
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
            java.util.logging.Logger.getLogger(InicioCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBoxNomeMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNomeMesa;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuEstoque;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItemGerenciarEstoque;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTablePedido;
    // End of variables declaration//GEN-END:variables


    
    private void calcularTotalDoPedido() {
        float total=0;
        
        for (int i= 0; i < this.modelPedido.getRowCount(); i++){
            String subtotal = (String) this.modelPedido.getValueAt(i, 3);
            total += Float.parseFloat(subtotal);
        }
        this.jLabelTotal.setText("Total: "+String.valueOf(total));
    }



    private void mostrarConsumoNaTela(ArrayList<Consumo> listaConsumo) {

        this.removerTodosElementosTabelaConsumo();
        
        
        Iterator c = listaConsumo.iterator();
        while (c.hasNext()){
            Consumo consumo = (Consumo) c.next();
            Produto produto = consumo.getProduto();
            float subtotal = produto.getPreco() * consumo.getQuantidade();
            this.modelPedido.addRow(new String [] {produto.getNome(), String.valueOf(produto.getPreco()), String.valueOf(consumo.getQuantidade()), String.valueOf(subtotal)});
        }
    }

    private void mostrarMesasNaTela(ArrayList<String> mesas) {
        Iterator it = mesas.iterator();
        this.jComboBoxNomeMesa.removeAllItems();
        
        while(it.hasNext()){
            String m = (String) it.next();
            this.jComboBoxNomeMesa.addItem(m);
        }
    }
    
    private void buscarMesas(){
        ConsumoRN consumoRN = new ConsumoRN();
         ArrayList<String> mesas;
         
        try {
            mesas = consumoRN.buscarMesas();
            if (mesas.size() > 1){
                mesas.add(0, "Selecione");
                this.mostrarMesasNaTela(mesas);
                 
            }else if (mesas == null){
                JOptionPane.showMessageDialog(null, "Erro ao buscar mesas no banco de dados.");
            }else{//nenhuma mesa no banco de dados
                JOptionPane.showMessageDialog(null,"Nenhuma mesa Encontrada!");
            }
            
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar Mesas no Servidor");
            return;
        }
    }

    private void removerTodosElementosTabelaConsumo() {
        //remove all rows
        while(this.modelPedido.getRowCount() > 0){
            this.modelPedido.removeRow(0);
        }
        //---------------
    }

}
