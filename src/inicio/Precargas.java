package inicio;

import logicanegocios.Excepciones.MesaException;
import logicanegocios.Fachada;

public class Precargas {

    Fachada fachada = Fachada.getInstancia();

    public void cargarDatos() throws MesaException {
        // Precarga de administradores
        fachada.agregarAdmin("100", "100", "A 100");
        fachada.agregarAdmin("200", "101", "A 200");
        fachada.crearMesa(2, 2, 2);
        fachada.crearMesa(2, 2, 3);

        // Precarga de jugadores
        fachada.agregarJugador(0, "0", "0", "J0");
        fachada.agregarJugador(1000, "1", "1", "J1");
        fachada.agregarJugador(2000, "2", "2", "J2");
        fachada.agregarJugador(3000, "3", "3", "J3");
        fachada.agregarJugador(4000, "4", "4", "J4");
        fachada.agregarJugador(5000, "5", "5", "J5");
        fachada.agregarJugador(6000, "6", "6", "J6");
        fachada.agregarJugador(7000, "7", "7", "J7");
        fachada.agregarJugador(8000, "8", "8", "J8");
        fachada.agregarJugador(9000, "9", "9", "J9");
    }
}
