package iugrafica;

import controladores.UsuarioControlador;
import java.awt.Frame;
import logicanegocios.usuarios.Usuario;
import iugrafica.ListarMesas;
import javax.swing.JOptionPane;


public class LoginAdmin extends LoginAbstracto {

    private UsuarioControlador login;

    public LoginAdmin(Frame parent, boolean modal, UsuarioControlador loginC) {
        super(parent, modal, "Acceso al Gestion", loginC);
        this.login = loginC;
        login.setVista(this);
    }

    public void llamarLogin(String cedula, String contrasenia) {
         login.loginAdministrador(cedula, contrasenia);
    }

    @Override
    public void redireccionamientoPrincipal(Usuario us) {
        new ListarMesas(null, false, us).setVisible(true);
    }

    @Override
    public void cerrarVentana() {
        dispose();
    }

    @Override
    public void redireccionamiento(Usuario u) {
        redireccionamientoPrincipal(u);
        dispose();
    }

    @Override
    public void mensajeDenegado() {
        JOptionPane.showMessageDialog(this, "Acceso Denegado");
    }

    
    
}
