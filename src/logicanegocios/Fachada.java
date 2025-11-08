package logicanegocios;

import logicanegocios.EstadosMesa.Mesa;
import java.util.ArrayList;
import logicanegocios.Excepciones.MesaException;
import logicanegocios.usuarios.*;
import logicanegocios.sistemas.*;

public class Fachada {

    private SistemaAcceso sAcceso = new SistemaAcceso();
    private SistemaMesa sMesa = new SistemaMesa();

    private static Fachada instancia = new Fachada();

    public static Fachada getInstancia() {
        return instancia;
    }

    //-------usuario----------
    public Jugador loginJugador(String cedula, String contrasenia) {
        return sAcceso.loginJugador(cedula, contrasenia);
    }

    public Administrador loginAdministrador(String cedula, String contrasenia) {
        return sAcceso.loginAdministrador(cedula, contrasenia);
    }

    public void agregarAdmin(String cedula, String contrasenia, String nombreCompleto) {
        sAcceso.agregarAdmin(cedula, contrasenia, nombreCompleto);
    }

    public void agregarJugador(int saldo, String cedula, String contrasenia, String nombreCompleto) {
        sAcceso.agregarJugador(saldo, cedula, contrasenia, nombreCompleto);
    }

    public Jugador obtenerJugadorXCedula(String cedula) {
        return sAcceso.obtenerJugadorXCedula(cedula);
    }

    public void logOut(Usuario j) {
        sAcceso.logOut(j);
    }

    //----------MESA------------
    public void crearMesa(int valorApuestaBase, int porcentajeComision, int cantJugadoresMaxima) throws MesaException {
        sMesa.crearMesa(valorApuestaBase, porcentajeComision, cantJugadoresMaxima);
    }

    public ArrayList<Mesa> getMesas() {
        return sMesa.getMesas();
    }

    public Mesa buscarMesa(int numMesa) {
    for (Mesa mesa : this.getMesas()) {
        if (mesa.getNumMesa() == numMesa) {
            return mesa;
        }
    }
    return null; // Si no se encuentra, devuelve null
}

    public ArrayList<Mesa> obtenerMesasAbiertas() {
        return sMesa.obtenerMesasAbirtas();
    }

}
