/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorNotificaciones.dto;
import servidorNotificaciones.sop_rmi.*;
import java.io.Serializable;
/**
 *
 * @author ACER
 */
public class HamburguesaNotificacionDTO implements Serializable{
     private char tipo;
    private int cantidadIngredientesExtra;

    public HamburguesaNotificacionDTO(char tipo, int cantidadIngredientesExtra) {
        this.tipo = tipo;
        this.cantidadIngredientesExtra = cantidadIngredientesExtra;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public int getCantidadIngredientesExtra() {
        return cantidadIngredientesExtra;
    }

    public void setCantidadIngredientesExtra(int cantidadIngredientesExtra) {
        this.cantidadIngredientesExtra = cantidadIngredientesExtra;
    }

    
    
}
