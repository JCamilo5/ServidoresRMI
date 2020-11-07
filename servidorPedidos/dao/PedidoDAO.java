/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorPedidos.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import servidorPedidos.dto.FacturaDTO;
import servidorPedidos.dto.HamburguesaPedidoDTO;
import servidorPedidos.dto.PedidoDTO;

/**
 *
 * @author ACER
 */
public class PedidoDAO {

    private final String ruta = "./facturas";
    private static int idFactura=1;
    private FacturaDTO factura;
    public PedidoDAO() {
   
    }

    public FacturaDTO crearFactura(PedidoDTO objPedido) {
        factura = new FacturaDTO();
        File directorio = new File(ruta);
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("El directorio ya estaba creado");
            }
        }
        try {
            String rutaF = ruta+"/factura"+idFactura+".txt";
            String contenido =objPedido.getNumMesa()+"\n"+cantiHamburguesas(objPedido)+"\n"+calCostoSinIva(objPedido)+"\n"+calcularIva(objPedido)+"\n"+calCostoSinIva(objPedido)+calcularIva(objPedido);
            File file = new File(rutaF);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(contenido);
            bw.close();
            idFactura++;
            //Creo la facuta
        } catch (IOException e) {
        }
        return factura;
    }
    private float calCostoSinIva(PedidoDTO objPedido){
        float costoSinIva =0;
        for (int i = 0; i < objPedido.getListaHamburguesas().size(); i++) {
            costoSinIva = costoSinIva + objPedido.getListaHamburguesas().get(i).getCosto();
        }
        factura.setSinIVA(costoSinIva);
        return costoSinIva;
    }
    private  float calcularIva(PedidoDTO objPedido){
        int cantidadHamburguesas = objPedido.getListaHamburguesas().size();
        float iva=0,costoSinIva = calCostoSinIva(objPedido);       
        if(cantidadHamburguesas> 0 && cantidadHamburguesas < 4){
            iva = (float) 0.05;
        }else{
            if(cantidadHamburguesas > 3 && cantidadHamburguesas < 8){
                iva= (float) 0.08;
            }else{
                if(cantidadHamburguesas >7 && costoSinIva > 120000){
                    iva = (float)0.18;
                }
            }
        }
        factura.setIVA(costoSinIva * iva);
        factura.setCostoIVA(costoSinIva + (costoSinIva * iva));
        return costoSinIva * iva;   
    }
    private String cantiHamburguesas(PedidoDTO objPedido){
        ArrayList<HamburguesaPedidoDTO> listaAux = objPedido.getListaHamburguesas();
        String cadena="";
        int canP = 0;
        int canM = 0;
        int canG = 0;
        for (int i = 0; i < listaAux.size(); i++) {
            if(listaAux.get(i).getTipo() == 'p'){
                canP++;
            }else{
                if(listaAux.get(i).getTipo() == 'm'){
                    canM++;
                }else{
                    if(listaAux.get(i).getTipo() == 'g'){
                        canG++;
                    }
                }
            }  
        }
        factura.setCanPeq(canP);
        factura.setCanMed(canM);
        factura.setCanGran(canG);
        cadena = canP +"\n"+canM+"\n"+canG ;
        return cadena;
    }
}
