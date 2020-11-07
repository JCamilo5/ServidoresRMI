/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorNotificaciones.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidorNotificaciones.dto.PedidoDTO;

/**
 *
 * @author ACER
 */

public class NotificacionImpl extends UnicastRemoteObject implements NotificacionInt {

    public NotificacionImpl() throws RemoteException {
        super();
    }

    @Override
    public void notificarRegistro(PedidoDTO objNotificacion) throws RemoteException {
        System.out.println("invocando al método notificar registro");
        System.out.println("No Mesa: "+objNotificacion.getNumMesa());
        for (int i = 0; i < objNotificacion.getListaHamburguesas().size(); i++) {
            System.out.println("\nHamburguesa no: " + i);
            if (objNotificacion.getListaHamburguesas().get(i).getTipo() == 'p') {
                System.out.println("Tipo: Pequeña");
            } else if (objNotificacion.getListaHamburguesas().get(i).getTipo() == 'm') {
                System.out.println("Tipo: Mediana");
            } else {
                System.out.println("Tipo: Grande");
            }
            System.out.println("Cantidad de ingredientes extra: " + objNotificacion.getListaHamburguesas().get(i).getCantidadIngredientesExtra());
        }
    }

}
