/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorPedidos.sop_rmi;

import Administrador.sop_rmi.AdministradorNotificacionInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidorPedidos.dto.FacturaDTO;
import servidorPedidos.dto.PedidoDTO;
import servidorPedidos.utilidades.UtilidadesRegistroC;
import servidorPedidos.sop_rmi.GestionPedidosInt;
import servidorPedidos.dto.FacturaDTO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidorNotificaciones.dto.HamburguesaNotificacionDTO;
import servidorNotificaciones.sop_rmi.NotificacionInt;
import servidorPedidos.dao.InfoEmpresaDAO;
import servidorPedidos.dao.FacturaDAO;
import servidorPedidos.dto.InfoEmpresaDTO;

/**
 *
 * @author ACER
 */
public class GestionPedidosImpl extends UnicastRemoteObject implements GestionPedidosInt, GestionAdminInt {
    
    private final FacturaDAO facturaDao;
    private final InfoEmpresaDAO infoDAO;
    private NotificacionInt objReferenciaRemotaNotificacion;
    private AdministradorNotificacionInt objReferenciaAdminNotificacion;
    public GestionPedidosImpl() throws RemoteException {
        super();
        facturaDao = new FacturaDAO();
        infoDAO = new InfoEmpresaDAO();
    }

    @Override
    public synchronized FacturaDTO registrarPedidoSistema(PedidoDTO objPedido) throws RemoteException {
        System.out.println("Invocando a registrar pedido");
        servidorNotificaciones.dto.PedidoDTO objNotificacion = new servidorNotificaciones.dto.PedidoDTO();
        for (int i = 0; i < objPedido.getListaHamburguesas().size(); i++) {
            HamburguesaNotificacionDTO objHamburguesaNoti = 
               new HamburguesaNotificacionDTO(objPedido.getListaHamburguesas().get(i).getTipo(),objPedido.getListaHamburguesas().get(i).getCantidadIngredientesExtra());
            objNotificacion.agregarHamburguesa(objHamburguesaNoti);
        }
        objNotificacion.setNumMesa(objPedido.getNumMesa());
        this.objReferenciaRemotaNotificacion.notificarRegistro(objNotificacion);
        if(objReferenciaAdminNotificacion != null){
          objReferenciaAdminNotificacion.mostrarNotificacion(facturaDao.crearFactura(objPedido));  
        }
        return facturaDao.crearFactura(objPedido);
    }

    @Override
    public InfoEmpresaDTO consultarInfo() throws RemoteException {
        System.out.println("Invocando al metodo consultarInfromacion de la empresa");
        return infoDAO.consultarInfo();
    }
    public void consultarReferenciaRemotaDeNotificacion(String direccionIpRMIRegistry, int numPuertoRMIRegistry){
        this.objReferenciaRemotaNotificacion =(NotificacionInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "ObjetoRemotoNotificaciones");
    }

    @Override
    public boolean registrarCliente(AdministradorNotificacionInt admin) throws RemoteException {
        this.objReferenciaAdminNotificacion = admin;
        return true;
    }

    @Override
    public ArrayList<FacturaDTO> consultarFacturas() throws RemoteException {
        return facturaDao.consultarFacturas();
    }
    
    
    
}
