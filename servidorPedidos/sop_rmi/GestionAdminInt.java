/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorPedidos.sop_rmi;

import Administrador.sop_rmi.AdministradorNotificacionInt;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import servidorPedidos.dto.FacturaDTO;

/**
 *
 * @author Daniel
 */
public interface GestionAdminInt extends Remote{
    public boolean registrarCliente(AdministradorNotificacionInt  admin) throws RemoteException;
    ArrayList<FacturaDTO> consultarFacturas()throws RemoteException;
}