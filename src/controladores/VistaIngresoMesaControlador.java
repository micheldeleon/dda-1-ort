
package controladores;

import java.util.ArrayList;
import logicanegocios.EstadosMesa.Mesa;
import logicanegocios.usuarios.Jugador;


public interface VistaIngresoMesaControlador{

    public void abrirPoker(Mesa mesa, Jugador j);

    public void cargarMesas(ArrayList<Mesa> m);

    public void cargarInterfaz(Jugador o);

    public void notificarError(String mensaje);
    
    public void cerrarVentana();
}
