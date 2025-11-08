package logicanegocios.figuras;

import java.util.ArrayList;
import logicanegocios.Carta;
import logicanegocios.Figura;


public class Pierna extends Figura {

    @Override
    public int calcularValorFigura() {
        return 2;
    }

    public Pierna(TipoFiguraPoker tipo, ArrayList<Carta> cartas) {
        super(tipo, cartas);
    }

    @Override
    public boolean esValido() {
        return contadorPorValor(3);
    }
    
}
