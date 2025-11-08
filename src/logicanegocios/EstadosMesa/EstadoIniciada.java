package logicanegocios.EstadosMesa;

import logicanegocios.usuarios.Jugador;

public class EstadoIniciada extends EstadoMesa {

    public EstadoIniciada(Mesa mesa) {
        super(mesa);
        this.tipo = tipo.INICIADA;
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        throw new IllegalArgumentException("No se puede ingresar a la mesa si ya esta iniciada");
    }

    @Override
    public void iniciarJuego() {
        throw new IllegalArgumentException("El juego ya esta iniciado");
    }

    @Override
    public void realizarApuesta(int monto, Jugador jugador) {
        mesa.getRondaActual();
    }

    @Override
    public void finalizarJuego(Jugador ganador) {
        this.mesa.setEstadoMesa(new EstadoFinalizada(this.mesa));

    }

    @Override
    public String toString() {
        return "Iniciada";
    }
}
