
package logicanegocios.figuras;

import java.util.ArrayList;
import logicanegocios.Figura;
import logicanegocios.Figura.TipoFiguraPoker;
import logicanegocios.figuras.*;

public class EvaluadorFiguras {

    public Figura crearFigura(ArrayList mano) {
        ArrayList<Figura> figuras = new ArrayList<>();
        figuras.add(new Poker(TipoFiguraPoker.POKER, mano));
        figuras.add(new Escalera(TipoFiguraPoker.ESCALERA, mano));
        figuras.add(new Pierna(TipoFiguraPoker.PIERNA, mano));
        figuras.add(new Par(TipoFiguraPoker.PAR, mano));

        for (Figura figura : figuras) {
            if (figura.esValido()) {
                return figura;
            }
        }

        return new SinFigura(TipoFiguraPoker.SIN_FIGURA, mano);
    }
}
