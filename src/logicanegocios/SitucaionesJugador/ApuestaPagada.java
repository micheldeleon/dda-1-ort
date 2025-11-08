package logicanegocios.SitucaionesJugador;

import logicanegocios.usuarios.Jugador;


public class ApuestaPagada extends Situacion{

    public ApuestaPagada(Jugador jugador) {
        super(jugador);
        this.tipo = tipo.ApuestaPagada;
    }

    @Override
    public void iniciarApuesta() {
        throw new IllegalArgumentException("Ya hay una apuesta en curso, debes igualar o pasar dicha apuesta");
    }

    @Override
    public void pagarApuesta() {
        throw new IllegalArgumentException("Ya has pagado la apuesta");
    }

    @Override
    public void pasar() {
       throw new IllegalArgumentException("No puedes pasar una vez pagado la apuesta");
    }
    
}
