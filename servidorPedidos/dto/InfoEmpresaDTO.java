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
public class InfoEmpresaDTO implements Serializable{

    private String nit;
    private String nombre;
    float mediana;
    float pequena;
    float grande;
    float ingredientes;

    public InfoEmpresaDTO() {
    }

    public InfoEmpresaDTO(String nit, String nombre, float mediana, float pequena, float grande, float ingredientes) {
        this.nit = nit;
        this.nombre = nombre;
        this.mediana = mediana;
        this.pequena = pequena;
        this.grande = grande;
        this.ingredientes = ingredientes;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getMediana() {
        return mediana;
    }

    public void setMediana(float mediana) {
        this.mediana = mediana;
    }

    public float getPequena() {
        return pequena;
    }

    public void setPequena(float pequena) {
        this.pequena = pequena;
    }

    public float getGrande() {
        return grande;
    }

    public void setGrande(float grande) {
        this.grande = grande;
    }

    public float getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(float ingredientes) {
        this.ingredientes = ingredientes;
    }
    
    
}
