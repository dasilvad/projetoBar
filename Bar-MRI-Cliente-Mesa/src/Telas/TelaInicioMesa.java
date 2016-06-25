package Telas;

import PacotePrincipal.Produto;
import clienteMesaRN.ProdutoRN;
import java.util.ArrayList;
import java.util.Vector;
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
        
        this.buscarCardapio();
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
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabelNomeMesa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
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
        getContentPane().add(jButtonIncluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 434, -1, -1));

        jLabelQuantidade.setText("Quantidade");
        getContentPane().add(jLabelQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 440, -1, -1));

        jSpinnerQuantidade.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1)));
        jSpinnerQuantidade.setValue(1);
        getContentPane().add(jSpinnerQuantidade, new org.netbeans.lib.awtextra.AbsoluteConstraints(131, 435, -1, -1));

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

        jButton1.setText("Finalizar Pedido");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 430, -1, -1));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 24)); // NOI18N
        jLabel2.setText("Total:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(467, 495, -1, -1));

        jButton2.setText("Deletar");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 430, -1, -1));

        jLabelNomeMesa.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabelNomeMesa.setText("Mesa: ");
        getContentPane().add(jLabelNomeMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(354, 12, -1, -1));

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
           System.out.println();
       }else if (jTableComidas.getSelectedRow() != -1 && jTabbedPaneCardapio.getSelectedIndex() == 1) {
            if (jTableComidas.getSelectedRow() != -1){//usuario clicou em alguma linha
                Vector a =  (Vector) modelComida.getDataVector().elementAt(jTableComidas.getSelectedRow());
                String quantidade = this.jSpinnerQuantidade.getValue().toString();
                String item = a.get(0).toString();
                String precoUnitario = a.get(1).toString();
                String id = a.get(2).toString();

                float subtotal =Integer.parseInt(quantidade) * Float.parseFloat(precoUnitario);

                this.modelPedido.addRow(new String [] {item, precoUnitario, quantidade, String.valueOf(subtotal), id});
                 System.out.println();
            }
       
       }else{
           
       }
    }//GEN-LAST:event_jButtonIncluirActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonIncluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelCardapio;
    private javax.swing.JLabel jLabelNomeMesa;
    private javax.swing.JLabel jLabelQuantidade;
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
        ArrayList<Produto> produto = prn.buscarCardapio();
        
        for (int i=0; i < produto.size(); i++){
                this.mostrarCardapioNaTela(produto.get(i).getNome(), produto.get(i).getPreco(), produto.get(i).getCategoria(), String.valueOf(produto.get(i).getId()));
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
}
