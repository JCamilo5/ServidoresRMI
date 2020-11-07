/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorPedidos.sop_rmi;
import servidorPedidos.dto.PedidoDTO;
import servidorPedidos.dto.FacturaDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import servidorPedidos.dto.InfoEmpresaDTO;
/**
 *
 * @author ACER
 */
public interface GestionPedidosInt extends Remote{
    public FacturaDTO registrarPedidoSistema(PedidoDTO objPedido) throws RemoteException;
    public InfoEmpresaDTO consultarInfo() throws RemoteException;
}
