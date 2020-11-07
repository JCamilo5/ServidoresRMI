/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorPedidos.sop_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidorPedidos.dto.FacturaDTO;
import servidorPedidos.dto.PedidoDTO;
import servidorPedidos.utilidades.UtilidadesRegistroC;
import servidorPedidos.sop_rmi.GestionPedidosInt;
import servidorPedidos.dto.FacturaDTO;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorNotificaciones.dto.HamburguesaNotificacionDTO;
import servidorNotificaciones.sop_rmi.NotificacionInt;
import servidorPedidos.dao.InfoEmpresaDAO;
import servidorPedidos.dao.PedidoDAO;
import servidorPedidos.dto.InfoEmpresaDTO;

/**
 *
 * @author ACER
 */
public class GestionPedidosImpl extends UnicastRemoteObject implements GestionPedidosInt {
    
    private final PedidoDAO pedidoDao;
    private final InfoEmpresaDAO infoDAO;
    private NotificacionInt objReferenciaRemotaNotificacion;
    
    public GestionPedidosImpl() throws RemoteException {
        super();
        pedidoDao = new PedidoDAO();
        infoDAO = new InfoEmpresaDAO();
    }

    @Override
    public FacturaDTO registrarPedidoSistema(PedidoDTO objPedido) throws RemoteException {
        System.out.println("Invocando a registrar pedido");
        servidorNotificaciones.dto.PedidoDTO objNotificacion = new servidorNotificaciones.dto.PedidoDTO();
        for (int i = 0; i < objPedido.getListaHamburguesas().size(); i++) {
            HamburguesaNotificacionDTO objHamburguesaNoti = 
               new HamburguesaNotificacionDTO(objPedido.getListaHamburguesas().get(i).getTipo(),objPedido.getListaHamburguesas().get(i).getCantidadIngredientesExtra());
            objNotificacion.agregarHamburguesa(objHamburguesaNoti);
        }
        this.objReferenciaRemotaNotificacion.notificarRegistro(objNotificacion);
        return pedidoDao.crearFactura(objPedido);
    }

    @Override
    public InfoEmpresaDTO consultarInfo() throws RemoteException {
        return infoDAO.consultarInfo();
    }
    public void consultarReferenciaRemotaDeNotificacion(String direccionIpRMIRegistry, int numPuertoRMIRegistry){
        this.objReferenciaRemotaNotificacion =(NotificacionInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoNotificaciones");
    }

}
