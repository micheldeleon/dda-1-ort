package logicanegocios.SitucaionesJugador;

import logicanegocios.usuarios.Jugador;


public class NoPagoLaApuesta extends Situacion{

    public NoPagoLaApuesta(Jugador jugador) {
        super(jugador);
        this.tipo = tipo.NoPagoLaApuesta;
    }

    @Override
    public void iniciarApuesta() {
        throw new IllegalArgumentException("No puedes iniciar una apuesta, usted se fue de la mano");
    }

    @Override
    public void pagarApuesta() {
        throw new IllegalArgumentException("No puedes pagar la apuesta, usted se fue de la mano");
    }

    @Override
    public void pasar() {
        throw new IllegalArgumentException("Usted ya paso de la apeusta");
    }
    
}
