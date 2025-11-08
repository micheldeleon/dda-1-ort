package logicanegocios.EstadosMano;

import logicanegocios.Apuesta;
import logicanegocios.usuarios.Jugador;


public class Terminada extends EstadoMano {

    public Terminada(Mano mano) {
        super(mano);
        this.estado = Estados.TERMINADA;
    }

    @Override
    public void iniciarApuesta(Apuesta apuesta) {
        throw new IllegalArgumentException("La partida ya finalizo, no se puede iniciar una apuesta");
    }

    @Override
    public void pagarApuesta(Jugador jugador) {
        throw new IllegalArgumentException("La partida ya finalizo, no se puede iniciar el pago");
    }

    @Override
    public void pasar(Jugador jugador) {
        throw new IllegalArgumentException("La partida ya finalizo, no se puede pasar");
    }

    @Override
    public void pedirCartas() {
        throw new IllegalArgumentException("La partida ya finalizo, no se puede pedir cartas");
    }

    @Override
    public void terminar() {
        throw new IllegalArgumentException("La partida ya finalizo");
    }
    
}
