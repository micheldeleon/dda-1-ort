package logicanegocios.SitucaionesJugador;

import logicanegocios.usuarios.Jugador;


public class AccionPendiente extends Situacion{

    public AccionPendiente(Jugador jugador) {
        super(jugador);
        this.tipo = tipo.AccionPendiente;
    }

    @Override
    public void iniciarApuesta() {
        jugador.setSituacion(new ApuestaIniciada(this.jugador));
    }

    @Override
    public void pagarApuesta() {
        jugador.setSituacion(new ApuestaPagada(this.jugador));
    }

    @Override
    public void pasar() {
        jugador.setSituacion(new NoPagoLaApuesta(this.jugador));
    }
    
}
