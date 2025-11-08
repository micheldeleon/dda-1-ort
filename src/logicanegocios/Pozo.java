package logicanegocios;

import logicanegocios.EstadosMano.Mano;
import java.util.ArrayList;

public class Pozo {

    private Mano mano;
    private int valorTotal;
    private ArrayList<Apuesta> hisApuestas;

    public Pozo(Mano mano) {
        this.mano = mano;
    }

    public void agregarSaldo(int apuestaBase) {
        valorTotal += apuestaBase;
    }

    public int getValorTotal() {
        return valorTotal;
    }

}
