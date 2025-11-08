package logicanegocios.SitucaionesJugador;

import logicanegocios.usuarios.Jugador;


public abstract class Situacion {
    protected Jugador jugador;
    
    public abstract void iniciarApuesta();
    public abstract void pagarApuesta();
    public abstract void pasar();

    public Situacion(Jugador jugador) {
        this.jugador = jugador;
    }
    
    
    public Jugador.Situcaiones tipo;
    
    
}
