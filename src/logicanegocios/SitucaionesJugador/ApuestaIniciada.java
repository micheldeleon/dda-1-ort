package logicanegocios.SitucaionesJugador;

import logicanegocios.usuarios.Jugador;


public class ApuestaIniciada extends Situacion{

    public ApuestaIniciada(Jugador jugador) {
        super(jugador);
        this.tipo = tipo.ApuestaIniciada;
    }

    @Override
    public void iniciarApuesta() {
        throw new IllegalArgumentException("No se puede iniciar una apuesta en este momento, ya hay una creada");
    }

    @Override
    public void pagarApuesta() {
        throw new IllegalArgumentException("No puedes pagar tu propia apuesta");
    }

    @Override
    public void pasar() {
        throw new IllegalArgumentException("No puedes pasar, usted creo la apuesta");
    }
    
}
