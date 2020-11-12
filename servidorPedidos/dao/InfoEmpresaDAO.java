/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorPedidos.dao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import servidorPedidos.dto.InfoEmpresaDTO;
/**
 *
 * @author ACER
 */
public class InfoEmpresaDAO {
    private final String ruta="./src/servidorPedidos/infoEmp";

    public InfoEmpresaDAO() {
    }
    /**
     * Metodo el cual obtine los datos de la empresa de un archivo de texto y los guarda en un objeto InfoEmpresaDTO
     * @return objeto con los datos
     */
    public InfoEmpresaDTO consultarInfo(){
        ArrayList<String> datos = new ArrayList<>();
        InfoEmpresaDTO informacion= new InfoEmpresaDTO();
        String cadena;
        try{
        //Leo la info de la empresa
        FileReader f = new FileReader(ruta+"/datosEmpresa.txt");
        BufferedReader b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            datos.add(cadena);
        }
        b.close();
        //Leo la info de las hamburguesas
        f = new FileReader(ruta+"/datosHamburguesa.txt");
        b = new BufferedReader(f);
        while ((cadena = b.readLine()) != null) {
            datos.add(cadena);
        }
        b.close();
        }catch(IOException e){
            
        }
        informacion.setNit(datos.get(0));
        informacion.setNombre(datos.get(1));
        informacion.setPequena(Float.parseFloat(datos.get(2)));
        informacion.setMediana(Float.parseFloat(datos.get(3)));
        informacion.setGrande(Float.parseFloat(datos.get(4)));
        informacion.setIngredientes(Float.parseFloat(datos.get(5)));
        
        return informacion;
        
    }
}
