package Servidor;

import Interfaces.ServidorInterface;
import PacotePrincipal.Consumo;
import PacotePrincipal.ItemPedido;
import PacotePrincipal.Produto;
import ServidorPER.ConsumoPER;
import ServidorPER.LoginPER;
import ServidorPER.MesaPER;
import ServidorPER.PedidoPER;
import ServidorPER.ProdutoPER;
import Telas.TelaServidor;
import java.rmi.RemoteException;
import java.rmi.server.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Adson
 */

// Classe responsável pela implementação dos métodos remotos definidos pela Interface
public class ImplementacaoIntefaces extends UnicastRemoteObject implements ServidorInterface {
    TelaServidor telaServidor;
    
    public ImplementacaoIntefaces(TelaServidor telaServidor) throws RemoteException {
        
        super();
        this.telaServidor = telaServidor;
    }    

    @Override
    public boolean atualizarProduto(Produto produto) throws RemoteException {
        ProdutoPER produtoPER = new ProdutoPER();
        boolean retorno = produtoPER.atualizarProduto(produto);
        
        if (retorno){
            this.telaServidor.mostrarMensagemNaTela("Usuário: Caixa, Descrição: Reabastecimento de Estoque, Data: "+getDataAtual());
        }
        
        return retorno;
    }

    @Override
    public boolean buscarProdutosDoBanco() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inserirProdutoNoBanco(Produto produto) {
        ProdutoPER produtoPER = new ProdutoPER();
        int retorno = produtoPER.inserirProduto(produto);
        
        if (retorno != -1 ){
            this.telaServidor.mostrarMensagemNaTela("Usuário: Caixa, Descrição: Cadastro de Produto, Data: "+getDataAtual());
        }
        return retorno;
    }

    @Override
    public ArrayList<Produto> buscarProdutos() {
        ProdutoPER produtoPER = new ProdutoPER();
        return produtoPER.buscarProdutos();
    }

    @Override
    public boolean deletarProduto(int id_produto) {
        ProdutoPER produtoPER = new ProdutoPER();
        return produtoPER.deletarProduto(id_produto);
    }

    @Override
    public boolean logar(String usuario) throws RemoteException {
        LoginPER loginPER = new LoginPER();
        return loginPER.logar(usuario);
    }

    @Override
    public boolean fazerPedido(ArrayList<ItemPedido> pedido, String usuario) throws RemoteException {
        PedidoPER pedidoPER = new PedidoPER();
        
        boolean retorno = pedidoPER.fazerPedido(pedido, usuario);
        
        if (retorno){
            this.telaServidor.mostrarMensagemNaTela("Usuário: "+usuario+" Descrição: Pedido, Data: "+getDataAtual());
        }
        
        return retorno;
    }

    @Override
    public boolean cadastrarMesa(String usuario) throws RemoteException {
        MesaPER mesaPER = new MesaPER();
        return mesaPER.cadastrarMesa(usuario);
    }

    @Override
    public boolean isDisponivelNoEstoque(ItemPedido item) throws RemoteException {
        PedidoPER pedidoPER = new PedidoPER();
        return pedidoPER.isDisponivelNoEstoque(item);
    }

    @Override
    public ArrayList<String> buscarMesas() throws RemoteException {
       ConsumoPER consumoPER = new ConsumoPER();
       return consumoPER.buscarMesas();
    }

    @Override
    public ArrayList<Consumo> buscarConsumo(String id_mesa) throws RemoteException {
        ConsumoPER consumoPER = new ConsumoPER();
        return consumoPER.buscarConsumo(id_mesa);
    }

    @Override
    public boolean fecharConta(String id_mesa) throws RemoteException {
        ConsumoPER consumoPER = new ConsumoPER();
        return consumoPER.fecharConta(id_mesa);
    }
    
    public String getDataAtual(){
             String dataEhora = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime()) ;
             return dataEhora;
    }
}
