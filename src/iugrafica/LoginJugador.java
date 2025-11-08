package iugrafica;

import controladores.UsuarioControlador;
import java.awt.Frame;
import javax.swing.JOptionPane;
import logicanegocios.usuarios.Usuario;


public class LoginJugador extends LoginAbstracto {
    private UsuarioControlador login;
    public LoginJugador(Frame parent, boolean modal, UsuarioControlador loginC) {
        super(parent, modal, "Acceso a juego", loginC);
        this.login =loginC;
        login.setVista(this);
    }
    
    @Override
    public void llamarLogin(String cedula, String contrasenia){
        login.loginJugador(cedula, contrasenia);
    }
    
    public void redireccionamientoPrincipal(Usuario us){
     new IngresarAMesa(null, false, us).setVisible(true);
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
