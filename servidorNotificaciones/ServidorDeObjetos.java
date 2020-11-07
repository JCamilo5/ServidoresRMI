/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorNotificaciones;

import java.rmi.RemoteException;
import servidorNotificaciones.utilidades.UtilidadesConsola;
import servidorNotificaciones.utilidades.UtilidadesRegistroS;
import servidorNotificaciones.sop_rmi.NotificacionImpl;
/**
 *
 * @author ACER
 */
public class ServidorDeObjetos {
    public static void main(String[] args) throws RemoteException{
        
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
                       
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero();
        
        NotificacionImpl objRemoto = new NotificacionImpl();
        
        try {
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoNotificaciones");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }

    }
    
}
