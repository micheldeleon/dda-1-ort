package controladores;

import java.util.ArrayList;
import logicanegocios.Apuesta;
import logicanegocios.Carta;
import logicanegocios.EstadosMano.Mano;
import static logicanegocios.EstadosMano.Mano.EventosMano.pidiendoCartas;
import logicanegocios.EstadosMesa.Mesa;
import static logicanegocios.EstadosMesa.Mesa.Eventos.cambiarDatos;
import static logicanegocios.EstadosMesa.Mesa.Eventos.start;
import logicanegocios.observable.Observable;
import logicanegocios.observable.Observador;
import logicanegocios.usuarios.Jugador;

public class JuegoControlador implements Observador {

    private Mesa mesa;
    private Mano mano;
    private Jugador jugador;
    private VistaPoker vista;

    public JuegoControlador(Mesa mesa, Mano mano, Jugador jugador, VistaPoker vista) {
        this.mesa = mesa;
        this.mano = mano;
        this.jugador = jugador;
        this.vista = vista;
        this.mesa.agregarObservador(this);
        ocultar();
    }

    public void ocultar() {
        vista.btnIgualarApuesta(false);
        vista.btnPasarApuesta(false);
        vista.opcionesCrearApuesta(false);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        vista.cargarNombresJugadores(mesa);
        if (evento instanceof Mesa.Eventos) {
            switch ((Mesa.Eventos) evento) {
                case start:
                    inicioPartida();
                    subTitulo();
                    break;
                case cambiarDatos:
                    vista.enEspera(jugador, mesa);
                    break;
                case finalizo:
                    felicitarGanador();
                    break;
            }
        } else if (evento instanceof Mano.EventosMano) {
            switch ((Mano.EventosMano) evento) {
                case siguienteMano:
                    inicioPartida();
                    subTitulo();
                    break;
                case apuestaIniciada:
                    opcionesApuestaSegunJugador();
                    vista.opcionesCrearApuesta(false);
                    subTitulo();
                    break;
                case pidiendoCartas:
                    ofrecerPedir();
                    subTitulo();
                    break;
                case pedidoFinalizado:
                    subTitulo();
                    notificarGanador();

                    break;
            }
        }
    }

    private void notificarGanador() {
        String figuraGanadora = mano.getGanadora() == null ? "" : " Gano con figura: " + mano.getGanadora().toString();
        vista.mostrarError(
                "Ganador: " + mano.getJugadorGanador().getNombreCompleto()
                + figuraGanadora
                + " Gano un pozo total de: " + mano.getPozo().getValorTotal()
        );
    }

    private void inicioPartida() {
        cargarCartasYMostrarFigura();
        botonesInicioMano();
        vista.editarTitulo("Poker");
    }

    private void ofrecerPedir() {
        if (mano.esPagador(jugador)) {
            vista.opcionesPedirCartas(Boolean.TRUE);
        }

    }


    private void botonesInicioMano() {
        this.mano = mesa.getRondaActual();
        vista.opcionesCrearApuesta(Boolean.TRUE);
        vista.btnPasarApuesta(Boolean.TRUE);
        vista.opcionesPedirCartas(false);
    }

    private void opcionesApuestaSegunJugador() {
        if (!mano.getApuestaActual().esMia(jugador) && this.jugador.getSituacion().tipo.equals(Jugador.Situcaiones.AccionPendiente)) {
            vista.mostrarApuestaActual("LA APUESTA ACTUAL ES DE $" + mano.getApuestaActual().getValor());
            vista.btnIgualarApuesta(true);
            vista.btnPasarApuesta(true);
        } else {
            vista.btnPasarApuesta(false);
        }
    }

    public void cargarCartasYMostrarFigura() {
        jugador.establecerCartasVisibles();
        vista.cargarCartas(jugador.getCartas());
        mostrarFiguraJugador();
    }

    public void mostrarFiguraJugador() {
        System.out.println(jugador.getFigura().toString());
        vista.mostrarFiguraJugador(jugador.getFigura().getTipo().toString());
    }

    public void crearApuesta(int valor) {
        try {
            if (mano.getApuestaActual() == null) {
                Apuesta apuesta = new Apuesta(mano, jugador, valor);
                mano.iniciarApuesta(apuesta);
                vista.mostrarError("Apuesta creada exitosamente: " + valor);
            }
        } catch (IllegalArgumentException e) {
            vista.mostrarError("Error al crear apuesta: " + e.getMessage());
        }

    }

    public void salirDeLaMesaActual() {
        try {
            mesa.salirDeLaMesa(jugador);
            vista.cerrarJuego();
            vista.volverMenu(jugador);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void felicitarGanador() {
        vista.cerrarJuego();
        vista.volverMenu(jugador);

    }

    public void botonApuestaApretado() {
        vista.btnPasarApuesta(false);
        vista.btnIgualarApuesta(false);
    }

    public void igualar() {
        try {
            mano.igualarApuesta(jugador);
            botonApuestaApretado();
        } catch (Exception e) {
            vista.mostrarError(e.getMessage());
        }
    }

    public void pasar() {
        try {
            botonApuestaApretado();
            mano.pasarApuesta(jugador);
        } catch (Exception e) {
            vista.mostrarError(e.getMessage());
        }
    }

    private ArrayList<Carta> cartaspedidas = new ArrayList<>();

    public void pedirCartas(Carta carta) {
        if (cartaspedidas.size() < 5 && !cartaspedidas.contains(carta)) {
            this.cartaspedidas.add(carta);
        }
    }

    public void cancelarPedir() {
        jugador.establecerCartasVisibles();
        cartaspedidas.removeAll(cartaspedidas);
        vista.cargarCartas(jugador.getCartas());
    }

    public void pedidoCompleto() {
        vista.opcionesPedirCartas(false);
        if (!cartaspedidas.isEmpty()) {
            mesa.pedidoCartas(cartaspedidas, jugador);

            //pedir
        }
        mano.pidio();

    }

    public void subTitulo() {
        vista.editarSubTitulos("Nombre Jugador:" + this.jugador.getNombreCompleto() + "    Numero de mesa:" + mesa.getNumMesa() + "    Saldo:" + this.jugador.getSaldo()
                + "    Numero mano:" + mesa.getNumManoActual() + "    Valor de pozo:" + mano.getPozo().getValorTotal() + "    Estado mano: " + mano.getEstadoMano().estado.toString());
    }

}
