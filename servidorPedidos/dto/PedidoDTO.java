/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorPedidos.dto;

import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author ACER
 */
public class PedidoDTO implements Serializable{
    private int numMesa;
    private ArrayList<HamburguesaPedidoDTO> listaHamburguesas;

    public PedidoDTO() {
        this.listaHamburguesas = new ArrayList();
    }
    public void agregarHamburguesa(HamburguesaPedidoDTO objHamburguesa){
        this.listaHamburguesas.add(objHamburguesa);
    }
    public ArrayList<HamburguesaPedidoDTO> getListaHamburguesas(){
        return this.listaHamburguesas;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public void setNumMesa(int numMesa) {
        this.numMesa = numMesa;
    }

   
    
}
