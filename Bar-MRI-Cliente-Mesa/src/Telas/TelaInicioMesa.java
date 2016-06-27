package Telas;

import PacotePrincipal.ItemPedido;
import PacotePrincipal.Produto;
import clienteMesaRN.MesaRN;
import clienteMesaRN.PedidoRN;

import clienteMesaRN.ProdutoRN;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 */
public class TelaInicioMesa extends javax.swing.JFrame {
    private DefaultTableModel modelBebida;
    private DefaultTableModel modelComida;
    private DefaultTableModel modelPedido;
    private String usuario;
    private ArrayList<ItemPedido> pedidoAtual;
    private ArrayList<ItemPedido> historicoConsumo;
    private ArrayList<Produto> cardapio;
    /**
     * Creates new form TelaInicioMesa
     */
    public TelaInicioMesa() {
        initComponents();
        this.modelBebida = new DefaultTableModel();
        modelBebida.addColumn("Bebida");
        modelBebida.addColumn("Preco");
        modelBebida.addColumn("id");
        this.jTableBebidas.setModel(this.modelBebida);
        
        //hide the id in table Bebidas
        this.jTableBebidas.getColumn("id").setPreferredWidth(0);
        this.jTableBebidas.getColumn("id").setMinWidth(0);
        this.jTableBebidas.getColumn("id").setWidth(0);
        this.jTableBebidas.getColumn("id").setMaxWidth(0);
        
        this.modelComida = new DefaultTableModel();
        this.modelComida.addColumn("Comida");
        this.modelComida.addColumn("Preco");
        this.modelComida.addColumn("id");
        this.jTableComidas.setModel(this.modelComida);
        
        //hide id in table Comida
        this.jTableComidas.getColumn("id").setPreferredWidth(0);
        this.jTableComidas.getColumn("id").setMinWidth(0);
        this.jTableComidas.getColumn("id").setWidth(0);
        this.jTableComidas.getColumn("id").setMaxWidth(0);
        
        this.modelPedido = new DefaultTableModel();
        this.modelPedido.addColumn("Item");
        this.modelPedido.addColumn("Preco Unitário");
        this.modelPedido.addColumn("Quantidade");
        this.modelPedido.addColumn("Subtotal");
        this.modelPedido.addColumn("id");
        this.jTablePedido.setModel(this.modelPedido);
        
        //hide the id in table Pedido
        this.jTablePedido.getColumn("id").setPreferredWidth(0);
        this.jTablePedido.getColumn("id").setMinWidth(0);
        this.jTablePedido.getColumn("id").setWidth(0);
        this.jTablePedido.getColumn("id").setMaxWidth(0);
        this.jButtonDeletar.setEnabled(false);
        this.jButtonFinalizarPedido.setEnabled(false);
        this.jButtonHistoricoConsumo.setEnabled(false);
        this.buscarCardapio();
        this.pedidoAtual = new ArrayList<>();
        historicoConsumo = new ArrayList<>();
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
        tabBebidas = new javax.swing.JScrollPane();
        jTableBebidas = new javax.swing.JTable();
        tabComidas = new javax.swing.JScrollPane();
        jTableComidas = new javax.swing.JTable();
        jButtonIncluir = new javax.swing.JButton();
        jLabelQuantidade = new javax.swing.JLabel();
        jSpinnerQuantidade = new javax.swing.JSpinner();
        jLabelCardapio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePedido = new javax.swing.JTable();
        jButtonFinalizarPedido = new javax.swing.JButton();
        jLabelSubtotal = new javax.swing.JLabel();
        jButtonDeletar = new javax.swing.JButton();
        jLabelNomeMesa = new javax.swing.JLabel();
        jButtonHistoricoConsumo = new javax.swing.JButton();
        jLabelTotal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1140, 620));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Bebida", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabBebidas.setViewportView(jTableBebidas);

        jTabbedPaneCardapio.addTab("Bebidas", tabBebidas);

        jTableComidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Comida", "Preço"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabComidas.setViewportView(jTableComidas);

        jTabbedPaneCardapio.addTab("Comidas", tabComidas);

        getContentPane().add(jTabbedPaneCardapio, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 68, 438, 330));

        jButtonIncluir.setText("Pedir");
        jButtonIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIncluirActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, 70, 40));

        jLabelQuantidade.setText("Quantidade:");
        getContentPane().add(jLabelQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 440, -1, -1));

        jSpinnerQuantidade.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerQuantidade.setValue(1);
        getContentPane().add(jSpinnerQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 435, 50, 30));

        jLabelCardapio.setText("Cardápio");
        getContentPane().add(jLabelCardapio, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 42, -1, -1));

        jLabel1.setText("Pedido");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(791, 42, -1, -1));

        jTablePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Quantidade", "Preço"
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
        if (jTablePedido.getColumnModel().getColumnCount() > 0) {
            jTablePedido.getColumnModel().getColumn(0).setResizable(false);
            jTablePedido.getColumnModel().getColumn(1).setResizable(false);
            jTablePedido.getColumnModel().getColumn(2).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(568, 98, -1, 300));

        jButtonFinalizarPedido.setText("Finalizar Pedido");
        jButtonFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonFinalizarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 430, 140, 40));

        jLabelSubtotal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelSubtotal.setText("Subtotal Pedido: 0");
        getContentPane().add(jLabelSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 500, -1, -1));

        jButtonDeletar.setText("Deletar");
        jButtonDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeletarActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonDeletar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 80, 40));

        jLabelNomeMesa.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelNomeMesa.setText("Mesa: ");
        getContentPane().add(jLabelNomeMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 12, -1, -1));

        jButtonHistoricoConsumo.setText("Historico Consumo");
        jButtonHistoricoConsumo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHistoricoConsumoActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonHistoricoConsumo, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 430, 160, 40));

        jLabelTotal.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelTotal.setText("Total: 0");
        getContentPane().add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 540, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIncluirActionPerformed
       if (jTableBebidas.getSelectedRow() != -1 && jTabbedPaneCardapio.getSelectedIndex() == 0){//usuario clicou em alguma linha
          Vector a =  (Vector) modelBebida.getDataVector().elementAt(jTableBebidas.getSelectedRow());
          String quantidade = this.jSpinnerQuantidade.getValue().toString();
          String item = a.get(0).toString();
          String precoUnitario = a.get(1).toString();
          String id = a.get(2).toString();
          
          
          
          float subtotal =Integer.parseInt(quantidade) * Float.parseFloat(precoUnitario);
          
          this.modelPedido.addRow(new String [] {item, precoUnitario, quantidade, String.valueOf(subtotal), id});
          this.ativarBotoesPedido();
          this.calcularSubtotalDoPedido();
          this.atualizarListaPedidoAtual(Integer.parseInt(id), this.usuario, Integer.parseInt(quantidade));
          
       }else if (jTableComidas.getSelectedRow() != -1 && jTabbedPaneCardapio.getSelectedIndex() == 1) {
            if (jTableComidas.getSelectedRow() != -1){//usuario clicou em alguma linha
                Vector a =  (Vector) modelComida.getDataVector().elementAt(jTableComidas.getSelectedRow());
                String quantidade = this.jSpinnerQuantidade.getValue().toString();
                String item = a.get(0).toString();
                String precoUnitario = a.get(1).toString();
                String id = a.get(2).toString();

                float subtotal =Integer.parseInt(quantidade) * Float.parseFloat(precoUnitario);

                this.modelPedido.addRow(new String [] {item, precoUnitario, quantidade, String.valueOf(subtotal), id});
                this.ativarBotoesPedido();
                this.calcularSubtotalDoPedido();
                this.atualizarListaPedidoAtual(Integer.parseInt(id), this.usuario, Integer.parseInt(quantidade));
            }
       
       }else{
           
       }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

    private void jButtonDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeletarActionPerformed
        int linhaSelecionada = this.jTablePedido.getSelectedRow();
        if (linhaSelecionada != -1){
            this.removerItemPedidoAtual (Integer.parseInt((String) this.modelPedido.getValueAt(this.jTablePedido.getSelectedRow(), 4)));
            this.modelPedido.removeRow(linhaSelecionada);
            if (jTablePedido.getRowCount() < 1){
                this.jButtonDeletar.setEnabled(false);
                this.jButtonFinalizarPedido.setEnabled(false);
            }
            this.calcularSubtotalDoPedido();
        }else{
            JOptionPane.showMessageDialog(null, "Primeiro selecione um item para deletar.");
        }
    }//GEN-LAST:event_jButtonDeletarActionPerformed

    private void jButtonFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarPedidoActionPerformed
        try {
            //verficia se os produtos do pedido atual estao disponiveis no estoque
            if (this.verificarEstoque() == false){
                return;
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se conectar com o servidor para verificar estoque!");
           return;
        }
        
        if (this.cadastrarMesa() == false){
            JOptionPane.showMessageDialog(null, "Erro ao Finalizar Pedido. Mesa nao foi cadastrada!");
            return;
        }
        this.atualizarHistoricoConsumo();
        this.imprimirPedidos();
                
        //salvar pedido no banco
        PedidoRN pedidoRN = new PedidoRN();
        try {
            if (pedidoRN.fazerPedido(pedidoAtual, this.usuario)){
                
                float precoTotal = this.calcularTotal(this.historicoConsumo);
                this.jLabelTotal.setText("Total: "+precoTotal);
                this.jLabelSubtotal.setText("Subtotal Pedido: 0");
                
                JOptionPane.showMessageDialog(null, "Pedido Realizado com Sucesso!");
            }else{
                JOptionPane.showMessageDialog(null, "Erro ao fazer pedido. Chame o garçom!");
            }
        } catch (RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer pedido. Servidor nao localizado. Chame o garçom!");
        }
        
        pedidoAtual = new  ArrayList<>();
        this.limparTabelaPedido();
        this.ativarBotaoHistoricoConsumo();
        this.jButtonDeletar.setEnabled(false);
        this.jButtonFinalizarPedido.setEnabled(false);
       
        
       
    }//GEN-LAST:event_jButtonFinalizarPedidoActionPerformed

    private void jButtonHistoricoConsumoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHistoricoConsumoActionPerformed
        TelaConsumoMesa telaConsumoMesa = new TelaConsumoMesa(this.cardapio, this.historicoConsumo, this.usuario);
        telaConsumoMesa.setVisible(true);
        
    }//GEN-LAST:event_jButtonHistoricoConsumoActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TelaInicioMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TelaInicioMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TelaInicioMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TelaInicioMesa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new TelaInicioMesa().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeletar;
    private javax.swing.JButton jButtonFinalizarPedido;
    private javax.swing.JButton jButtonHistoricoConsumo;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelCardapio;
    private javax.swing.JLabel jLabelNomeMesa;
    private javax.swing.JLabel jLabelQuantidade;
    private javax.swing.JLabel jLabelSubtotal;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinnerQuantidade;
    private javax.swing.JTabbedPane jTabbedPaneCardapio;
    private javax.swing.JTable jTableBebidas;
    private javax.swing.JTable jTableComidas;
    private javax.swing.JTable jTablePedido;
    private javax.swing.JScrollPane tabBebidas;
    private javax.swing.JScrollPane tabComidas;
    // End of variables declaration//GEN-END:variables

    private void buscarCardapio() {
        ProdutoRN prn = new ProdutoRN();
        cardapio = prn.buscarCardapio();
        
        for (int i=0; i < cardapio.size(); i++){
                this.mostrarCardapioNaTela(cardapio.get(i).getNome(), cardapio.get(i).getPreco(), cardapio.get(i).getCategoria(), String.valueOf(cardapio.get(i).getId()));
        }
    }
    
    public void mostrarCardapioNaTela(String nome, float preco, String categoria, String id){
       if (categoria.equals("Bebida")) {
            this.modelBebida.addRow(new String[]{nome, String.format("%.2f", preco), id});
        } else {
            this.modelComida.addRow(new String[]{nome, String.format("%.2f", preco), id});
        }
    }

    void setUsuario(String usuario) {
        this.usuario = usuario;
        this.jLabelNomeMesa.setText("Mesa: "+usuario);
    }

    private void ativarBotoesPedido() {
        this.jButtonDeletar.setEnabled(true);
        this.jButtonFinalizarPedido.setEnabled(true);
        
    }

    private void calcularSubtotalDoPedido() {
        float total=0;
        
        for (int i= 0; i < this.modelPedido.getRowCount(); i++){
            String subtotal = (String) this.modelPedido.getValueAt(i, 3);
            total += Float.parseFloat(subtotal);
        }
        this.jLabelSubtotal.setText("Subtotal Pedido: "+String.valueOf(total));
    }

    private void atualizarListaPedidoAtual(int id_produto, String usuario, int quantidade) {
        for (int i=0; i < pedidoAtual.size(); i++){
            if(pedidoAtual.get(i).getId_produto() == id_produto){
                pedidoAtual.get(i).setQuantidade(pedidoAtual.get(i).getQuantidade() + quantidade);
                return;
            }
        }
        pedidoAtual.add(new ItemPedido(id_produto, quantidade));
    }

    private void atualizarHistoricoConsumo() {
        for (int i = 0; i < pedidoAtual.size(); i++){
            if (this.produtoNaoExisteNoHistoricoDeConsumo(pedidoAtual.get(i))){
                historicoConsumo.add(new ItemPedido(pedidoAtual.get(i).getId_produto(), pedidoAtual.get(i).getQuantidade()));
            }
        }
        
        
    }

    private boolean produtoNaoExisteNoHistoricoDeConsumo(ItemPedido item) {
        for (int i = 0; i < historicoConsumo.size(); i++){
            if (historicoConsumo.get(i).getId_produto() == item.getId_produto()){
                historicoConsumo.get(i).setQuantidade(historicoConsumo.get(i).getQuantidade() + item.getQuantidade());
                return false;
            }
        }
        return true;
    }

    private void limparTabelaPedido() {
       while(modelPedido.getRowCount() > 0){
           modelPedido.removeRow(0);
       }
       
    }

    private void ativarBotaoHistoricoConsumo() {
        this.jButtonHistoricoConsumo.setEnabled(true);
    }

    private void imprimirPedidos() {
        System.out.println("Pedido Atual");
        for (int i=0; i < pedidoAtual.size(); i++){
            System.out.println(pedidoAtual.get(i).getId_produto() + " quatde: "+pedidoAtual.get(i).getQuantidade());
        }
        System.out.println("historico consumo");
        for (int i=0; i < historicoConsumo.size(); i++){
            
            System.out.println(historicoConsumo.get(i).getId_produto() + " quatde: "+historicoConsumo.get(i).getQuantidade());
        }
    }
    /*cadastra se nao houver nenhum consumo relacionado a mesa. Portanto esse metodo executa somente uma vez. Esse metodo e chamado quando um pedido e finalizado.*/
    private boolean cadastrarMesa() {
        MesaRN mesaRN = new MesaRN();
        if (historicoConsumo.size() == 0){
            return mesaRN.cadastrarMesa(this.usuario);
        }else{
            return true;
        }
        
    }
    //verifica se os produtos do pedidoAtual estao disponiveis no estoque
    private boolean verificarEstoque() throws RemoteException {
        ArrayList<ItemPedido> itemIndisponivel = new ArrayList<>();
        Iterator it = pedidoAtual.iterator();
        boolean temNoEstoque = true;
        PedidoRN pedidoRN = new PedidoRN();
        
        while(it.hasNext()){
            ItemPedido item = (ItemPedido) it.next();
            
            if (pedidoRN.isDisponivelNoEstoque(item) == false){
               temNoEstoque = false;
               itemIndisponivel.add(item);
            }
        }
        
        String indisponivel = "";
        Iterator iti = itemIndisponivel.iterator();
       
        while(iti.hasNext()){
            ItemPedido item = (ItemPedido) iti.next();
            Iterator c = this.cardapio.iterator();
            while(c.hasNext()){
                Produto produto = (Produto) c.next();
                if (produto.getId() == item.getId_produto()){
                    indisponivel += produto.getNome()+" ";
                    break;
                }
            }
        }
        if (temNoEstoque == false){
            JOptionPane.showMessageDialog(null, "Produtos indiponíveis: "+indisponivel+". Delete eles do Pedido e tente uma quantidade menor.");
        }
        
        return temNoEstoque;
    }

    private void removerItemPedidoAtual(int id_produto) {
        for (int i=0; i < this.pedidoAtual.size(); i++){
            if (this.pedidoAtual.get(i).getId_produto() == id_produto){
                this.pedidoAtual.remove(i);
                return;
            }
        }
    }

    private float calcularTotal(ArrayList<ItemPedido> historicoConsumo) {
        Iterator it = historicoConsumo.iterator();
        float total = 0;
        
        while(it.hasNext()){
            ItemPedido item = (ItemPedido) it.next();
            float subtotal = this.buscarSubtotalProduto(item.getId_produto(), item.getQuantidade());
            total += subtotal;
        }
        
        return total;
    }
    
    //busca o preco do produto no cardapio e calcula o subtotal com base na quantidade pedida de um produto
    private float buscarSubtotalProduto(int id_produto, int quantidade){
        Iterator it = this.cardapio.iterator();
        
        while(it.hasNext()){
            Produto produto = (Produto) it.next();
            if (produto.getId() == id_produto){
                return produto.getPreco() * quantidade;
            }
        }
        return -1;
    }
}
