package logicanegocios.EstadosMesa;

import logicanegocios.EstadosMesa.Mesa.Estados;
import logicanegocios.usuarios.Jugador;


public abstract class EstadoMesa {
    public Estados tipo;
    Mesa mesa;

    public EstadoMesa(Mesa mesa) {
        this.mesa = mesa;
    }
    
    
    public abstract void agregarJugador(Jugador jugador);
    public abstract void iniciarJuego();
    public abstract void realizarApuesta(int monto, Jugador jugador);
    public abstract void finalizarJuego(Jugador ganador);
    
}


