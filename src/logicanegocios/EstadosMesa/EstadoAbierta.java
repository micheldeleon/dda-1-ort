package logicanegocios.EstadosMesa;

import logicanegocios.usuarios.Jugador;

public class EstadoAbierta extends EstadoMesa {

    public EstadoAbierta(Mesa mesa) {
        super(mesa);
        this.tipo = tipo.ABIERTA;
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        /*if (!mesa.mesaLlena() && !mesa.estaEnMesa(jugador)) {
            mesa.puedeEntrar(jugador);
            jugador.setMesaActual(mesa);
        } else {
            throw new IllegalArgumentException("No se puede agregar el jugador: mesa llena o el jugador ya está en la mesa.");
        }*/
        mesa.agregarJugadorMesa(jugador);
    }

    @Override
    public void iniciarJuego() {
        /*try {
            mesa.empezarPartida();
            mesa.setEstadoMesa(new EstadoIniciada(mesa));
        } catch (Exception e) {
            throw new IllegalArgumentException("Faltan jugadores para iniciar la partida");
        }*/
        mesa.iniciarJuegoMesa();
    }

    @Override
    public void realizarApuesta(int monto, Jugador jugador) {
        throw new IllegalArgumentException("La mesa aun no inicio");
    }

    @Override
    public void finalizarJuego(Jugador ganador) {
        throw new IllegalArgumentException("La mesa aun no inicio");
    }

    @Override
    public String toString() {
        return "Abierta";
    }
}
