package logicanegocios.EstadosMano;

import logicanegocios.Apuesta;
import logicanegocios.usuarios.Jugador;


public class EsperandoApuesta extends EstadoMano {

    public EsperandoApuesta(Mano mano) {
        super(mano);
        this.estado = Estados.ESPERANDO_APUESTA;

    }

    @Override
    public void iniciarApuesta(Apuesta apuesta) {
        mano.iniciarApuestaMano(apuesta);
    }

    @Override
    public void pagarApuesta(Jugador jugador) {
        throw new IllegalArgumentException("No se creo niunguna apuesta");
    }

    @Override
    public void pasar(Jugador jugador) {
        throw new IllegalArgumentException("No se puede pasar. No hay ninguna apuesta iniciada");
    }

    @Override
    public void pedirCartas() {
        throw new IllegalArgumentException("aun no se puede pedir cartas. No existe ninguna apuesta");
    }

    @Override
    public void terminar() {
        mano.todosPasaron();
    }

}
