/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorPedidos.dto;
import  java.io.Serializable;
/**
 *
 * @author ACER
 */
public class HamburguesaPedidoDTO implements Serializable {
    private String identificador;
    private char tipo;
    private int cantidadIngredientesExtra;
    private float costo;

    public HamburguesaPedidoDTO(String identificador, char tipo, int cantidadIngredientesExtra, float costo) {
        this.identificador = identificador;
        this.tipo = tipo;
        this.cantidadIngredientesExtra = cantidadIngredientesExtra;
        this.costo = costo;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
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

    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
}
