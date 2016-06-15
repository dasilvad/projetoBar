/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

/**
 *
 * @author adson
 */
public class Mesa {

    private static JTextPane jTPMesa;
    private static String mesa;
    private static String consumo;
    private static double total = 0;
    private static String geral;

    public Mesa(String mesa) {
        this.mesa = mesa;
        consumo = "";
        jTPMesa = new JTextPane();
    }

    public void addConsumo(String nome, double valor) {
        String sTotal = "Total";
        String sValor;
        
        total = total + valor;
        consumo = consumo + nome;
        
        sValor = String.format("%.2f", valor);
                
        for (int i = sTotal.length(); i < 50 - String.format("%.2f", total).length(); i++) {
            sTotal = sTotal + "-";
        }
        
        sTotal = "\n" + sTotal + String.format("%.2f", total);
        
        for (int i = nome.length(); i < 50 - sValor.length(); i++) {
            consumo = consumo + "-";
        }
        
        consumo = consumo + sValor + "\n";
        geral = consumo + sTotal;
        
        
    }
    
    public String getConsumo(){
        return geral;
    }
    
    public String getNome(){
        return mesa;
    }
    
}
