package logicanegocios.sistemas;

import java.util.ArrayList;
import logicanegocios.Excepciones.MesaException;
import logicanegocios.EstadosMesa.Mesa;
import logicanegocios.EstadosMesa.Mesa.Estados;

public class SistemaMesa {

    private ArrayList<Mesa> mesas = new ArrayList();

    public void crearMesa(int valorApuestaBase, int porcentajeComision, int cantJugadoresMaxima) throws MesaException {
        Mesa m = new Mesa(mesas.size() + 1, valorApuestaBase, porcentajeComision, cantJugadoresMaxima);
        if (mesas.contains(m)) {
            throw new MesaException("Ya existe la mesa");
        } else {
            mesas.add(m);
        }
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public Mesa buscarMesa(int id) {
        return mesas.get(id);
    }

    public ArrayList<Mesa> obtenerMesasAbirtas() {
        ArrayList<Mesa> mesasAbiertas = new ArrayList();
        for (Mesa mesa : mesas) {
            if (mesa.getEstadoMesa() != null && mesa.getEstadoMesa().tipo != null) {
                if (mesa.getEstadoMesa().tipo.equals(Estados.ABIERTA)
                        || mesa.getEstadoMesa().tipo.equals(Estados.INICIADA)) {
                    mesasAbiertas.add(mesa);
                }
            }
        }
        return mesasAbiertas;
    }

}
