package controladores;

import java.util.ArrayList;
import logicanegocios.Carta;
import logicanegocios.EstadosMesa.Mesa;
import panelCartasPoker.PanelCartasListener;
import logicanegocios.usuarios.Jugador;


public interface VistaPoker extends PanelCartasListener {

    void btnPasarApuesta(Boolean b);

    void btnIgualarApuesta(Boolean b);

    void opcionesCrearApuesta(Boolean b);

    void enEspera(Jugador jugadorActual, Mesa mesaActual);

    void cargarCartas(ArrayList<Carta> cartas);

    void mostrarFiguraJugador(String f);

    void volverMenu(Jugador us);

    void cerrarJuego();
    
    void mostrarError(String mensaje);
    
    void mostrarApuestaActual(String num);
    
    void opcionesPedirCartas(Boolean b);
    
    void editarTitulo(String string);
    
    void editarSubTitulos(String string);
    
    void cargarNombresJugadores(Mesa mesa);
}
