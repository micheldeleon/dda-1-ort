package logicanegocios.EstadosMesa;

import logicanegocios.usuarios.Jugador;

public class EstadoFinalizada extends EstadoMesa {

    public EstadoFinalizada(Mesa mesa) {
        super(mesa);
    }

    @Override
    public void agregarJugador(Jugador jugador) {
        throw new IllegalArgumentException("La meza ya finalizo. No se pueden agregar jugadores");
    }

    @Override
    public void iniciarJuego() {
        throw new IllegalArgumentException("La meza ya finalizo. No se puede volver a inicializar");
    }

    @Override
    public void realizarApuesta(int monto, Jugador jugador) {
        throw new IllegalArgumentException("La meza ya finalizo. No se pueden agregar apuestas");
    }

    @Override
    public void finalizarJuego(Jugador ganador) {
        throw new IllegalArgumentException("La meza ya finalizo");
    }

    @Override
    public String toString() {
        return "Finalizada";
    }
}
