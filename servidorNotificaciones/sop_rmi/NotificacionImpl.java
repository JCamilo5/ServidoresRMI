/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorNotificaciones.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidorNotificaciones.dto.PedidoDTO;
import servidorNotificaciones.vista.GUINotificaciones;

/**
 *
 * @author ACER
 */

public class NotificacionImpl extends UnicastRemoteObject implements NotificacionInt {

    GUINotificaciones vista;

    public NotificacionImpl() throws RemoteException {
        super();
        vista = new GUINotificaciones(this);
        
    }

    @Override
    public void notificarRegistro(PedidoDTO objNotificacion) throws RemoteException {
        int numMesa = 0;
        int numHamburguesa = 0;
        String tipo = "";
        int cantiIngreExtra=0;
        System.out.println("invocando al método notificar registro");
        numMesa = objNotificacion.getNumMesa();
        for (int i = 0; i < objNotificacion.getListaHamburguesas().size(); i++) {
            numHamburguesa = i;
            switch (objNotificacion.getListaHamburguesas().get(i).getTipo()) {
                case 'p':
                    tipo = "pequeña";
                    break;
                case 'm':
                    tipo = "mediana";
                    break;
                default:
                    tipo="grande";
                    break;
            }
           cantiIngreExtra= objNotificacion.getListaHamburguesas().get(i).getCantidadIngredientesExtra();
           vista.agrgarFila(numMesa, numHamburguesa+1, tipo, cantiIngreExtra);
        }
    }

}
