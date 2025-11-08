package controladores;

import logicanegocios.EstadosMano.Mano;
import logicanegocios.Excepciones.MesaException;
import logicanegocios.Fachada;
import logicanegocios.observable.Observable;
import logicanegocios.observable.Observador;
import logicanegocios.usuarios.Usuario;

public class AdminControlador implements Observador {

    private Fachada fachada;

    private VistaAdmin vistaAdmin;
    private VistaDetalle vistaDetalle;
    private Usuario usuarioConectado;

    public AdminControlador(VistaAdmin vista, Usuario usuario) {
        this.vistaAdmin = vista;
        this.usuarioConectado = usuario;
    }

    public void crear(int apuestaBase, int porcentajeComision, int cantidadMaximaJugadores) throws MesaException {
        if (apuestaBase <= 0 || porcentajeComision <= 0 || cantidadMaximaJugadores <= 0) {
            vistaAdmin.mostrarError("Los valores deben de ser mayores a 0");
        } else if (cantidadMaximaJugadores < 2 || cantidadMaximaJugadores > 5) {
            vistaAdmin.mostrarError("Cantidad de jugadores no válida");
        } else if (apuestaBase < 1) {
            vistaAdmin.mostrarError("Apuesta base inválida");
        } else if (porcentajeComision < 1 || porcentajeComision > 50) {
            vistaAdmin.mostrarError("Comisión inválida");
        } else {
            vistaAdmin.mostrarError("Mesa creada exitosamente");
            Fachada.getInstancia().crearMesa(apuestaBase, porcentajeComision, cantidadMaximaJugadores);
            vistaAdmin.redireccionamiento();
        }
    }

    public void cargarMesas() {
        vistaAdmin.cargarMesas(fachada.getInstancia().getMesas());
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if (evento.equals(Mano.EventosMano.siguienteMano)) {
            cargarMesas();
        }
    }

    public void setVistaDetalle(VistaDetalle vistaDetalle) {
        this.vistaDetalle = vistaDetalle;
    }

    public void verDetalles(int numero) {
        vistaDetalle.detalleMesaVer(Fachada.getInstancia().buscarMesa(numero));
    }

    public void logOut() {
        Fachada.getInstancia().logOut(usuarioConectado);
    }
}
