package logicanegocios.EstadosMano;

import logicanegocios.EstadosMesa.Mesa;
import java.util.ArrayList;
import logicanegocios.Apuesta;
import logicanegocios.Carta;
import logicanegocios.Figura;
import logicanegocios.Pozo;
import logicanegocios.SitucaionesJugador.AccionPendiente;
import logicanegocios.observable.Observable;
import logicanegocios.usuarios.Jugador;

public class Mano extends Observable {

    private Mesa mesaActual;
    private Apuesta apuestaActual;
    private Pozo pozo;
    private Figura ganadora;
    private ArrayList<Jugador> participantes = new ArrayList();
    private EstadoMano estadoMano;
    private ArrayList<Jugador> jugadoresQuePasan = new ArrayList();

    public enum EventosMano {
        actualizarApuesta,
        apuestaIniciada,
        siguienteMano,
        pidiendoCartas,
        pedidoFinalizado,
    }

    public int montoApuesta() {
        if (apuestaActual == null) {
            return 0;
        }
        return apuestaActual.getValor();
    }

    public Mano(Mesa mesaActual, ArrayList<Jugador> jugadores) {
        this.mesaActual = mesaActual;
        this.participantes = jugadores;
        this.pozo = new Pozo(this);
        this.apuestaActual = null;
        mesaActual.setNumManoActual(mesaActual.getNumManoActual() + 1);
        this.estadoMano = new EsperandoApuesta(this);
        this.situacionInicial();
        this.observadores = mesaActual.getObservadores();
        descuentoBase();

    }

    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
    }

    public Apuesta getApuestaActual() {
        return apuestaActual;
    }

    public EstadoMano getEstadoMano() {
        return estadoMano;
    }

    public void setEstadoMano(EstadoMano estadoMano) {
        this.estadoMano = estadoMano;
    }

    public void crearApuesta(Apuesta apuesta) {
        if (apuesta.getValor() > jugadorMenosSaldo()) {
            this.apuestaActual = null;
            throw new IllegalArgumentException("No puede superar el monto minimo del jugador con menos saldo(" + jugadorMenosSaldo() + ")");
        } else {
            this.apuestaActual = apuesta;
        }
    }

    protected int jugadorMenosSaldo() {
        int respuesta = Integer.MAX_VALUE;
        for (Jugador j : participantes) {
            if (j.getSaldo() < respuesta) {
                respuesta = j.getSaldo();
            }
        }
        return respuesta;
    }

    public void setParticipantes(ArrayList<Jugador> participantes) {
        this.participantes = participantes;
    }

    private Jugador jugadorGanador;

    public Figura buscarFiguraGanador() {
        Figura figuraGanadora = null;
        for (Jugador j : participantes) {

            if (!j.getSituacion().tipo.equals(Jugador.Situcaiones.NoPagoLaApuesta)) {
                Figura figuraActual = j.getFigura();
                if (figuraGanadora == null || figuraActual.calcularValorFigura() > figuraGanadora.calcularValorFigura()) {
                    figuraGanadora = figuraActual;
                    jugadorGanador = j;
                } else if (figuraGanadora.calcularValorFigura() == figuraActual.calcularValorFigura()) {
                    ArrayList<Carta> cartasAltas = new ArrayList();
                    cartasAltas.add(figuraGanadora.buscarCartaMasAlta(figuraGanadora.getCartas()));
                    cartasAltas.add(figuraActual.buscarCartaMasAlta(figuraActual.getCartas()));
                    Carta ganadora = figuraGanadora.buscarCartaMasAlta(cartasAltas);
                    if (figuraGanadora.getCartaTop() != ganadora) {
                        figuraGanadora = figuraActual;
                        jugadorGanador = j;
                    }
                }
            }
            // Si la figuraGanadora es null (primer jugador) o figuraActual es mejor
        }
        return figuraGanadora;
    }

    public void descuentoBase() {
        for (Jugador j : participantes) {
            if (j.getSaldo() >= this.mesaActual.getValorApuestaBase()) {
                j.descontar(this.mesaActual.getValorApuestaBase());
                this.pozo.agregarSaldo(this.mesaActual.getValorApuestaBase());
            }
        }

    }

    public ArrayList<Jugador> getJugadoresQuePasan() {
        return jugadoresQuePasan;
    }

    public ArrayList<Jugador> getParticipantes() {
        return participantes;
    }

    public void iniciarApuesta(Apuesta apuesta) {
        this.estadoMano.iniciarApuesta(apuesta);

    }

    public void situacionInicial() {
        for (Jugador j : participantes) {
            j.setSituacion(new AccionPendiente(j));
        }
    }

    public void igualarApuesta(Jugador j) {
        this.apuestaActual.agregarPagador(j);
        decisionTomada();
    }

    public void pasarApuesta(Jugador j) {
        this.jugadoresQuePasan.add(j);
        j.getSituacion().pasar();
        decisionTomada();
    }

    public void decisionTomada() {
        if (this.apuestaActual != null) {
            if (this.jugadoresQuePasan.size() + this.apuestaActual.cantPagadores() == this.participantes.size()) {
                if (this.apuestaActual.cantPagadores() == 1) {
                    unicoApostador();
                } else {
                    this.estadoMano.terminar();
                }
            }
        } else {
            if (this.jugadoresQuePasan.size() == this.participantes.size()) {
                todosPasaron();
            }
        }
    }

    protected void todosPasaron() {
        Pozo pozo = this.pozo;
        mesaActual.empezarSiguienteMano();
        mesaActual.getRondaActual().setPozo(pozo);
        this.avisar(EventosMano.siguienteMano);
    }

    public Boolean todosDecidieron() {
        return this.jugadoresQuePasan.size() + this.apuestaActual.cantPagadores() == this.participantes.size();
    }

    protected void noPasaronTodos() {
        // if(this.todosDecidieron()&& this.participantes.size() >this.jugadoresQuePasan.size()){
        ArrayList<Jugador> pagadores = this.apuestaActual.getPagadores();
        aEstadoPendiente(pagadores);
        this.avisar(EventosMano.pidiendoCartas);
    }

    private void aEstadoPendiente(ArrayList<Jugador> activos) {
        for (Jugador j : activos) {
            j.setSituacion(new AccionPendiente(j));
        }
    }

    public Boolean esPagador(Jugador jugador) {
        return this.getApuestaActual().getPagadores().contains(jugador);
    }

    private int cantPidieron;

    public void pidio() {
        cantPidieron++;
        if (cantPidieron == this.apuestaActual.getPagadores().size()) {
            this.estadoMano.pedirCartas();
        }
    }

    protected void notificarGanador() {
        this.ganadora = this.buscarFiguraGanador();
        jugadorGanador.setAumentarSaldo(repartirGanancias());
        this.avisar(EventosMano.pedidoFinalizado);
        manoTerminada();
        this.avisar(EventosMano.siguienteMano);
    }

    protected int repartirGanancias() {
        int valorTotalPozo = this.pozo.getValorTotal();
        int porcentajeComision = this.mesaActual.getPorcentajeComision();
        int montoComision = (valorTotalPozo * porcentajeComision) / 100;

        this.mesaActual.sumarMontoRecaudado(montoComision);
        int valorFinal = valorTotalPozo - montoComision;

        return valorFinal;
    }

    protected void manoTerminada() {
        mesaActual.empezarSiguienteMano();
        this.estadoMano = new Terminada(this);
        this.avisar(EventosMano.siguienteMano);
    }

    protected void unicoApostador() {
        Jugador unico = this.apuestaActual.getPagadores().get(0);
        unico.setAumentarSaldo(repartirGanancias());
        this.ganadora = unico.getFigura();
        manoTerminada();
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

    public Pozo getPozo() {
        return pozo;
    }

    public void sumarTotalApotado(int apostado) {
        this.mesaActual.setMontoTotalApostado(apostado);
    }

    protected void pasarMano(Jugador jugador) {
        if (!this.getParticipantes().contains(jugador)) {
            this.getJugadoresQuePasan().add(jugador);
        }
        if (this.getJugadoresQuePasan().size() == this.getParticipantes().size()) {
            this.estadoMano.terminar();
        }
    }

    protected void terminarMano() {
        if ((this.getParticipantes().size() - this.getJugadoresQuePasan().size()) == 1 && this.todosDecidieron()) {
            this.unicoApostador();
        } else {
            this.noPasaronTodos();
            this.setEstadoMano(new PidiendoCartas(this));
        }
    }

    protected void pagarApuestaMano(Jugador jugador) {
        if (jugador.getSaldo() < this.montoApuesta()) {
            throw new IllegalArgumentException("Saldo insuficiente");
        } else {
            jugador.getSituacion().pagarApuesta();
            jugador.descontar(this.montoApuesta());
        }
    }

    protected void iniciarApuestaMano(Apuesta apuesta) {
        try {
            if (this.getApuestaActual() == null) {
                this.crearApuesta(apuesta);
                if (this.getJugadoresQuePasan().size() == (this.getParticipantes().size() - 1)) {
                    this.setJugadorGanador(apuesta.getCreador());
                    this.avisar(Mano.EventosMano.pedidoFinalizado);
                    this.manoTerminada();
                } else {
                    this.avisar(Mano.EventosMano.apuestaIniciada);
                }
                apuesta.getCreador().getSituacion().iniciarApuesta();
                this.setEstadoMano(new ApuestaIniciada(this));
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Figura getGanadora() {
        return ganadora;
    }

}
