package logicanegocios.EstadosMano;

import logicanegocios.Apuesta;
import logicanegocios.EstadosMano.Mano;
import logicanegocios.usuarios.Jugador;

public abstract class EstadoMano {

    public Estados estado;
    protected Mano mano;

    public EstadoMano(Mano mano) {
        this.mano = mano;
    }
    
    
    public enum Estados {
        ESPERANDO_APUESTA,
        APUESTA_INICIADA,
        PIDIENDO_CARTAS,
        TERMINADA
    }

    public abstract void iniciarApuesta(Apuesta apuesta);

    public abstract void pagarApuesta(Jugador jugador);

    public abstract void pasar(Jugador jugador);

    public abstract void pedirCartas();

    public abstract void terminar();

    @Override
    public String toString() {
        return ""+ estado;
    }
    
    

}
