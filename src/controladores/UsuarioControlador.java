package controladores;

import iugrafica.ListarMesas;
import javax.swing.JOptionPane;
import logicanegocios.Fachada;
import logicanegocios.usuarios.Jugador;
import logicanegocios.usuarios.Usuario;


public class UsuarioControlador {

    private VistaLoginControlador vista;
    private Fachada fachada;

    public UsuarioControlador( Fachada f) {
        this.fachada = f;
    }

    public void loginAdministrador(String cedula, String contrasenia) {
         existeUsuario(fachada.loginAdministrador(cedula, contrasenia));
    }
    
    public void loginJugador(String cedula, String contrasenia){
       existeUsuario(fachada.loginJugador(cedula, contrasenia));
    }
    
    public Jugador obtenerXcedula(String cedula){
        return fachada.obtenerJugadorXCedula(cedula);
    }
    
    public void existeUsuario(Usuario u){
        if(u == null){
            vista.mensajeDenegado();
        }else{
            vista.redireccionamiento(u);
        }
    }

    public void setVista(VistaLoginControlador vista) {
        this.vista = vista;
    }
    
    
    
}
