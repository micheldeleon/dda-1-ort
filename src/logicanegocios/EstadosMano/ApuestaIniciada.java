package logicanegocios.EstadosMano;

import logicanegocios.Apuesta;
import logicanegocios.usuarios.Jugador;


public class ApuestaIniciada extends EstadoMano {

    public ApuestaIniciada(Mano mano) {
        super(mano);
        this.estado = Estados.APUESTA_INICIADA;

    }


    @Override
    public void iniciarApuesta(Apuesta apuesta) {
        throw new IllegalArgumentException("Ya hay una apuesta en curso");

    }


    @Override
    public void pagarApuesta(Jugador jugador) {
        /*if (jugador.getSaldo() < mano.montoApuesta()) {
            throw new IllegalArgumentException("Saldo insuficiente");
        } else {
            jugador.getSituacion().pagarApuesta();
            jugador.descontar(mano.montoApuesta());
        }*/
        mano.pagarApuestaMano(jugador);
    }


    @Override
    public void pasar(Jugador jugador) {
       /* if (!mano.getParticipantes().contains(jugador)) {
            jugador.getSituacion().pasar();
            mano.getJugadoresQuePasan().add(jugador);
        }
        if (mano.getJugadoresQuePasan().size() == mano.getParticipantes().size()) {
            terminarMano(mano);
        }*/
       mano.pasarMano(jugador);
    }


    @Override
    public void pedirCartas() {
        throw new IllegalArgumentException("la apuesta esta en proiceso aun no se pueden pedir cartas"); 
    }

 
    @Override
    public void terminar() {
        /*if((mano.getParticipantes().size() - mano.getJugadoresQuePasan().size())== 1 && mano.todosDecidieron()){
            mano.unicoApostador();
        }else{
            mano.noPasaronTodos();
            mano.setEstadoMano(new PidiendoCartas(mano));
        }*/
        mano.terminarMano();
    }

}
