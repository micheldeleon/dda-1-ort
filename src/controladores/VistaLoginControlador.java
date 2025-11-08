package controladores;

import logicanegocios.usuarios.Usuario;


public interface VistaLoginControlador {
    void cerrarVentana();
    void redireccionamiento(Usuario u);
    void mensajeDenegado();
}
