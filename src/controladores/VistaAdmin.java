package controladores;

import java.util.ArrayList;
import logicanegocios.EstadosMesa.Mesa;


public interface VistaAdmin {
    void mostrarError(String mensaje);
    void redireccionamiento();
    void cargarMesas(ArrayList<Mesa> mesas);
}
