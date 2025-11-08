package logicanegocios.sistemas;

import java.util.ArrayList;
import logicanegocios.usuarios.*;

public class SistemaAcceso {

    private ArrayList<Administrador> administradores = new ArrayList();
    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Usuario> conectados = new ArrayList();

    public Jugador loginJugador(String cedula, String contrasenia) {
        return (Jugador) login(cedula, contrasenia, jugadores);
    }

    public Administrador loginAdministrador(String cedula, String contrasenia) {
        return (Administrador) login(cedula, contrasenia, administradores);
    }

    private Usuario login(String cedula, String contrasenia, ArrayList lista) {
        Usuario usuario;
        for (Object actual : lista) {
            usuario = (Usuario) actual;
            if (usuario.getCedulaIdentidad().equals(cedula) && !conectados.contains(actual) && usuario.getContrasenia().equals(contrasenia)) {
                conectados.add(usuario);
                return usuario;
            }
        }
        return null;
    }
    
    public void logOut(Usuario j){
        if(conectados.contains(j)){
            conectados.remove(j);
        }else{
            throw new IllegalArgumentException("no se encuetra conectado");
        }
    }

    public void agregarAdmin(String cedula, String contrasenia, String nombreCompleto) {
        administradores.add(new Administrador(cedula, contrasenia, nombreCompleto));
    }

    public void agregarJugador(int saldo, String cedula, String contrasenia, String nombreCompleto) {
        jugadores.add(new Jugador(saldo, cedula, contrasenia, nombreCompleto));
    }

    public Jugador obtenerJugadorXCedula(String cedula) {
        for (Jugador j : this.jugadores) {
            if (cedula.equals(j.getCedulaIdentidad())) {
                return j;
            }
        }
        return null;
    }

}
