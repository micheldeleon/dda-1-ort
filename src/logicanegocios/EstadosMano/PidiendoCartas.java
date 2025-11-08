package logicanegocios.EstadosMano;

import logicanegocios.Apuesta;
import logicanegocios.usuarios.Jugador;


public class PidiendoCartas extends EstadoMano {

    public PidiendoCartas(Mano mano) {
        super(mano);
        this.estado = Estados.PIDIENDO_CARTAS;

    }


   @Override
    public void iniciarApuesta(Apuesta apuesta) {
        throw new IllegalArgumentException("no puedes iniciar una apuesta mientras se estan pidiendo cartas"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void pagarApuesta(Jugador jugador) {
        throw new IllegalArgumentException("no puedes pagar apuesta mientras se piden cartas"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void pasar(Jugador jugador) {
        throw new IllegalArgumentException("no puedes pasar mientras se estan pidiendo cartas"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void pedirCartas() {
        mano.notificarGanador();
    }

    @Override
    public void terminar() {
        throw new IllegalArgumentException("No se puede terminar la partida mientras se dan cartas");
    }

 
}
