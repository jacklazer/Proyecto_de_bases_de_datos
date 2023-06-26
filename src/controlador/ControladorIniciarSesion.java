
package controlador;

import modelo.ModeloIniciarSesion;
import Vistas.VistaIniciarSesion;
import Vistas.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Modelo_editorial;
import accesoDatos.InterfaceIniciarSesionDAO;

/**
 *
 * @author Franklin Aguirre
 */
public class ControladorIniciarSesion implements ActionListener {
    private VistaIniciarSesion view;
    private ModeloIniciarSesion Model;
    private InterfaceIniciarSesionDAO administradorDAO;
    private String Usuario ;
    

    public ControladorIniciarSesion (VistaIniciarSesion view , ModeloIniciarSesion Model, InterfaceIniciarSesionDAO administradorDAO) {
        this.view= view;
        this.Model= Model;
        this.administradorDAO = administradorDAO;

        this.view.btnEntrar.addActionListener(this);
        view.txtContraseña.addActionListener(this);
    }

    public void iniciar() {
        view.setTitle("LOGIN");
        view.setLocationRelativeTo(null);
    }

    public void actionPerformed(    ActionEvent e) {
        if (e.getSource() == view.btnEntrar || e.getSource() == view.txtContraseña) {
            Model.setContraseña(view.txtContraseña.getText());
            Model.setUsuario(view.txtUsuario.getText());
            Usuario = view.txtUsuario.getText();
            ModeloIniciarSesion administrador = administradorDAO.getAdministrador(Model.getUsuario());
            
            if(administrador != null && administrador.getContraseña().equals(Model.getContraseña())){
                JOptionPane.showMessageDialog(null, "El Acceso Fue Valido", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                   Vista_editorial Vista_editorial =  new Vista_editorial();
                   Modelo_editorial Modelo_editorial =new Modelo_editorial();
                   Vista_editorial.setVisible(true);
                   ;
//                VistaPrincipal vistaPrincipal = new VistaPrincipal(Usuario);
//                vistaPrincipal.setVisible(true);
//                ControladorMenu controladorMenu = new ControladorMenu(vistamenu);
//                controladorMenu.iniciar();
                view.dispose();
                
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o Contraseña Incorrecta", "Advertencia", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
