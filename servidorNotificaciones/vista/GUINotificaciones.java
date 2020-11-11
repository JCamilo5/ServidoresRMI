/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorNotificaciones.vista;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import javax.swing.JOptionPane;
import servidorNotificaciones.sop_rmi.NotificacionImpl;
import servidorNotificaciones.utilidades.UtilidadesRMIServidor;
import servidorNotificaciones.utilidades.UtilidadesRegistroS;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class GUINotificaciones extends javax.swing.JFrame {

    {
        //Set Look & Feel
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private JPanel jpanelconexion;

    private JLabel jlabelclienteNombre;
    private JLabel jlabelservidor;
    private JTextField jtextfieldservidor;
    private JPanel jpanelchat;
    private JTextField jtextfieldpuerto;
    private JTextArea jtextareamsg;
    private JTextArea jtextareacontacto;
    private JTextArea jtextareachat;

    private JButton jbuttonsalir;
    private JButton jbuttonenviar;
    private JButton jbuttonconec;
    private JTextField jtextfieldcliente;
    private JLabel jlabelpuerto;
    private JButton jButton1;
    private GUITabla vistaNoti;
    String nombre;
    NotificacionImpl objRemoto;
    int opin = 0;

    /**
     * Auto-generated main method to display this JFrame
     *
     * @param args
     */
    public GUINotificaciones(NotificacionImpl prmRemoto) {
        super();
        this.objRemoto = prmRemoto;
        initGUI();
        this.setVisible(true);
    }

   

    private void initGUI() {
        try {
            {
                this.setEnabled(true);
            }
            {
                //jButtonHis.setVisible(false);
            }
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            BorderLayout thisLayout = new BorderLayout();
            getContentPane().setLayout(thisLayout);
            this.setVisible(false);
            {
                jpanelconexion = new JPanel();
                getContentPane().add(jpanelconexion, BorderLayout.CENTER);
                GridBagLayout PanelConexionLayout = new GridBagLayout();
                PanelConexionLayout.columnWidths = new int[]{156, 21, 7};
                PanelConexionLayout.rowHeights = new int[]{59, 42, 48};
                PanelConexionLayout.columnWeights = new double[]{0.0, 0.0,
                    0.1};
                PanelConexionLayout.rowWeights = new double[]{0.0, 0.0, 0.0};
                jpanelconexion.setLayout(PanelConexionLayout);
                jpanelconexion
                        .setPreferredSize(new java.awt.Dimension(392, -1));

                {
                    jlabelservidor = new JLabel();
                    jpanelconexion.add(jlabelservidor, new GridBagConstraints(
                            0,
                            1,
                            1,
                            1,
                            0.0,
                            0.0,
                            GridBagConstraints.CENTER,
                            GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 0),
                            0,
                            0));
                    jlabelservidor.setText("Dirección ip del rmiregistry");
                }
                {
                    jlabelpuerto = new JLabel();
                    jpanelconexion.add(jlabelpuerto, new GridBagConstraints(
                            0,
                            2,
                            1,
                            1,
                            0.0,
                            0.0,
                            GridBagConstraints.CENTER,
                            GridBagConstraints.NONE,
                            new Insets(0, 0, 0, 0),
                            0,
                            0));
                    jlabelpuerto.setText("Puerto del rmiregistry");
                }

                {
                    jtextfieldservidor = new JTextField();
                    jpanelconexion.add(
                            jtextfieldservidor,
                            new GridBagConstraints(
                                    2,
                                    1,
                                    1,
                                    1,
                                    0.0,
                                    0.0,
                                    GridBagConstraints.CENTER,
                                    GridBagConstraints.HORIZONTAL,
                                    new Insets(0, 0, 0, 25),
                                    0,
                                    0));
                }
                {
                    jtextfieldpuerto = new JTextField();
                    jpanelconexion.add(
                            jtextfieldpuerto,
                            new GridBagConstraints(
                                    2,
                                    2,
                                    1,
                                    1,
                                    0.0,
                                    0.0,
                                    GridBagConstraints.CENTER,
                                    GridBagConstraints.HORIZONTAL,
                                    new Insets(0, 0, 0, 25),
                                    0,
                                    0));
                }
                {
                    jbuttonconec = new JButton();
                    jpanelconexion.add(jbuttonconec, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    jbuttonconec.setText("Conectar");
                    jbuttonconec
                            .setBackground(new java.awt.Color(230, 230, 250));
                    jbuttonconec.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            try {
                                jButtonConecActionPerformed(evt);
                            } catch (RemoteException ex) {
                                Logger.getLogger(GUINotificaciones.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                }
                {
                    jButton1 = new JButton();
                    jpanelconexion.add(jButton1, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
                    jButton1.setText("Salir");
                    jButton1.setBackground(new java.awt.Color(230, 230, 250));
                    jButton1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            try {
                                jButton1ActionPerformed(evt);
                            } catch (RemoteException ex) {
                                Logger.getLogger(GUINotificaciones.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    });
                }
            }
            pack();
            setSize(400, 300);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jButtonConecActionPerformed(ActionEvent evt) throws RemoteException {
        this.setVisible(false);
        int puerto = Integer.parseInt(jtextfieldpuerto.getText());
        String ip = jtextfieldservidor.getText();
        
        
        try {
            UtilidadesRMIServidor.ArrancarNS(puerto);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto, ip, puerto, "ObjetoRemotoNotificaciones");
            
            vistaNoti = new GUITabla();
            vistaNoti.setVisible(true);
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }

    }

    public void agrgarFila(int nMesa, int nHamburguesa, String tipo, int nIngredientesExtra) {
        vistaNoti.agrgarFila(nMesa, nHamburguesa, tipo, nIngredientesExtra);
    }

    public void fijarTexto(String nombre, String msg) {
        System.out.println("Este método se invoca para informar al cliente de un mensaje nuevo en el chat");
        try {
            jtextareachat.append(nombre + " dice:\n" + msg + "\n");
        } catch (Exception ex) {
        }
        //TODO add your code for jbuttonHistorial.actionPerformed
    }

    public void fijarContacto(String nombre) {
        System.out.println("Este método se invoca para informar al cliente que un nuevo ha entrado al chat");
        try {
            jtextareacontacto.append(nombre + " en linea\n");
        } catch (Exception ex) {
        }
        //TODO add your code for jbuttonHistorial.actionPerformed
    }

    public void fijarContactos(String nombre) {
        System.out.println("Este método se invoca para actualizar el listado de contactos");
        try {

            jtextareacontacto.append(nombre + " en linea\n");
        } catch (Exception ex) {
        }
        //TODO add your code for jbuttonHistorial.actionPerformed
    }

    private void jtextareamsgKeyPressed(KeyEvent evt) {

        jbuttonenviar.setEnabled(true);
        //TODO add your code for jtextareamsg.keyPressed
    }

    private void jbuttonenviarActionPerformed(ActionEvent evt) {

        //TODO add your code for jbuttonenviar.actionPerformed
    }

    private void jButton1ActionPerformed(ActionEvent evt) throws RemoteException {

        System.exit(0);

    }

    public void limpiarContactos() {
        jtextareacontacto.setText(null);
    }

    private void jbuttonsalirActionPerformed(ActionEvent evt) throws RemoteException {

        System.exit(0);
    }

}
