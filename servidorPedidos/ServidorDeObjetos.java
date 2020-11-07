/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorPedidos;
import java.rmi.RemoteException;
import servidorPedidos.sop_rmi.GestionPedidosImpl;
import servidorPedidos.utilidades.UtilidadesConsola;
import servidorPedidos.utilidades.UtilidadesRegistroS;

/**
 *
 * @author ACER
 */
public class ServidorDeObjetos {
    public static void main(String[] args) throws RemoteException {
        int numPuertoNs = 0;
        String direccionIpNs = "";

        System.out.println("Cual es el la dirección ip donde se encuentra  el n_s de alertas ");
        direccionIpNs = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el n_s de alertas ");
        numPuertoNs = UtilidadesConsola.leerEntero();

        GestionPedidosImpl objRemotoPedidos = new GestionPedidosImpl();
        objRemotoPedidos.consultarReferenciaRemotaDeNotificacion(direccionIpNs, numPuertoNs);

        try {
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoPedidos, direccionIpNs, numPuertoNs, "ObjetoPedidos");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }
    }
}
