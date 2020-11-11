/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorPedidos.dto;
import java.io.Serializable;
/**
 *
 * @author ACER
 */
public class FacturaDTO implements Serializable{

    
    private int canPeq;
    private int canMed;
    private int canGran;
    private float sinIVA;
    private float IVA;
    private float costoIVA;

    public FacturaDTO() {
    }

    
    public FacturaDTO(int canPeq, int canMed, int canGran, float sinIVA, float IVA, float costoIVA) {
        this.canPeq = canPeq;
        this.canMed = canMed;
        this.canGran = canGran;
        this.sinIVA = sinIVA;
        this.IVA = IVA;
        this.costoIVA = costoIVA;
    }

    public int getCanPeq() {
        return canPeq;
    }

    public void setCanPeq(int canPeq) {
        this.canPeq = canPeq;
    }

    public int getCanMed() {
        return canMed;
    }

    public void setCanMed(int canMed) {
        this.canMed = canMed;
    }

    public int getCanGran() {
        return canGran;
    }

    public void setCanGran(int canGran) {
        this.canGran = canGran;
    }

    public float getSinIVA() {
        return sinIVA;
    }

    public void setSinIVA(float sinIVA) {
        this.sinIVA = sinIVA;
    }

    public float getIVA() {
        return IVA;
    }

    public void setIVA(float IVA) {
        this.IVA = IVA;
    }

    public float getCostoIVA() {
        return costoIVA;
    }

    public void setCostoIVA(float costoIVA) {
        this.costoIVA = costoIVA;
    }
    
    

}
