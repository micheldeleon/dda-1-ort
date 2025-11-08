package controladores;

import java.util.ArrayList;
import logicanegocios.EstadosMesa.Mesa;
import static logicanegocios.EstadosMesa.Mesa.Eventos.cambiarDatos;
import static logicanegocios.EstadosMesa.Mesa.Eventos.start;
import logicanegocios.Fachada;
import logicanegocios.Figura;
import logicanegocios.observable.Observable;
import logicanegocios.observable.Observador;
import logicanegocios.usuarios.Jugador;
import logicanegocios.usuarios.Usuario;


public class MesaLobbyControlador implements Observador {

    public VistaIngresoMesaControlador vistaIngreso;
    public Jugador conectado;
    public Mesa mesa;
    public Fachada fachada;

    public MesaLobbyControlador(VistaIngresoMesaControlador vista, Usuario j) {
        this.vistaIngreso = vista;
        this.fachada = Fachada.getInstancia();
        this.conectado = (Jugador) j;
        vista.cargarInterfaz(conectado);
        vista.cargarMesas(fachada.obtenerMesasAbiertas());
    }

    public void ingresarJugador(Mesa mesa) {
        try {
            if (mesa != null) {
                this.mesa = mesa;
                if (!mesa.estaEnMesa(conectado)) {
                    System.out.println(!mesa.estaEnMesa(conectado));
                    vistaIngreso.abrirPoker(mesa, conectado);
                }
                mesa.ingresarJugador(conectado);

                partidaEnEspera();
            } else {
                throw new IllegalArgumentException("Debes seleccionar una mesa");
            }
        } catch (Exception e) {
            vistaIngreso.cargarMesas(fachada.obtenerMesasAbiertas());
            vistaIngreso.notificarError(e.getMessage());
        }
    }

    public ArrayList<Mesa> obtenerMesasAbiertas() {
        return fachada.obtenerMesasAbiertas();
    }

    public void partidaEnEspera() {
        if (mesa.puedeIniciar()) {
            mesa.iniciarMesa();
            System.out.println("EMPIEZA");
        }
    }

    public void logOut() {
        fachada.logOut(conectado);
        vistaIngreso.cerrarVentana();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
