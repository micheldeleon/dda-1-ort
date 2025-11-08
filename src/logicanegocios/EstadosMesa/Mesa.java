package logicanegocios.EstadosMesa;

import logicanegocios.Excepciones.MesaException;
import java.util.ArrayList;
import logicanegocios.Carta;
import logicanegocios.EstadosMano.Mano;
import logicanegocios.Mazo;
import logicanegocios.observable.Observable;
import logicanegocios.usuarios.*;

public class Mesa extends Observable {

    private int numMesa;

    private ArrayList<Jugador> jugadores = new ArrayList();
    private ArrayList<Mano> hisManos = new ArrayList();
    private Mano rondaActual;
    private int valorApuestaBase;
    private int cantJugadoresMaxima;
    private int numManoActual;
    private int montoTotalApostado;
    private int porcentajeComision;
    private int montoTotalRecaudado;
    private EstadoMesa estadoMesa;
    private Mazo mazo;

    public Mano getRondaActual() {
        return rondaActual;
    }

    public int getNumManoActual() {
        return numManoActual;
    }

    public void setNumManoActual(int numManoActual) {
        this.numManoActual = numManoActual;
    }

    public enum Estados {
        ABIERTA,
        INICIADA,
        FINALIZADA
    }

    public enum Eventos {
        start,
        cambiarDatos,
        finalizo
    }

    public Mesa(int num, int valorApuestaBase, int PorcentajeComision, int cantJugadoresMaxima) throws MesaException {
        validar(valorApuestaBase, PorcentajeComision, cantJugadoresMaxima);
        this.numMesa = num;
        this.valorApuestaBase = valorApuestaBase;
        this.porcentajeComision = PorcentajeComision;
        this.cantJugadoresMaxima = cantJugadoresMaxima;
        this.estadoMesa = new EstadoAbierta(this);
        this.mazo = new Mazo(this);
        this.rondaActual = null;
    }

    private void validar(int valorApuestaBase, int porcentajeComision, int cantJugadoresMaxima) throws MesaException {
        if (cantJugadoresMaxima < 2 || cantJugadoresMaxima > 5) {
            throw new MesaException("Cantidad de jugadores no válida");
        }
        if (valorApuestaBase < 1) {
            throw new MesaException("Apuesta base inválida");
        }
        if (porcentajeComision < 1 || porcentajeComision > 50) {
            throw new MesaException("Comisión inválida");
        }
    }

    public void setEstadoMesa(EstadoMesa estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public EstadoMesa getEstadoMesa() {
        return estadoMesa;
    }

    public void sumarMontoRecaudado(int pozo) {
        this.montoTotalRecaudado += pozo;
    }

    public int getNumMesa() {
        return numMesa;
    }

    public String StringAdmin() {
        return "Número de mesa: " + numMesa + "\n"
                + "Cantidad de jugadores requeridos: " + cantJugadoresMaxima + "\n"
                + "Valor de apuesta base: " + valorApuestaBase + "\n"
                + "Cantidad actual de jugadores: " + jugadores.size() + "\n"
                + "Número de mano actual: " + numManoActual + "\n"
                + "Monto total apostado: " + this.montoTotalApostado + "\n"
                + "Porcentaje de comisión: " + porcentajeComision + "%\n"
                + "Monto total recaudado: " + this.montoTotalRecaudado + "\n"
                + "Estado de la mesa: " + estadoMesa;
    }

    public int getValorApuestaBase() {
        return valorApuestaBase;
    }

    public ArrayList<Mano> getHisManos() {
        return hisManos;
    }

    protected void puedeEntrar(Jugador j) {
        if (j.getSaldo() > (valorApuestaBase * 10)) {
            this.jugadores.add(j);
        } else {
            throw new IllegalArgumentException("No tiene saldo suficiente para ingresar a la mesa");
        }
    }//adaptarlo

    public boolean estaEnMesa(Jugador jugador) {
        return jugadores.contains(jugador) || jugador.getMesaActual() != null;
    }

    @Override
    public String toString() {
        return "Mesa{" + "numeroMesa=" + numMesa + "jugadores=" + jugadores.size() + ", valorApuestaBase=" + valorApuestaBase + ", cantJugadoresMaxima=" + cantJugadoresMaxima + ", porcentajeComision=" + porcentajeComision + '}';
    }

    public int cantJugadoresConectados() {
        return jugadores.size();
    }

    public int getCantJugadoresMaxima() {
        return cantJugadoresMaxima;
    }

    public int getNumeroMesa() {
        return numMesa;
    }

    public void salirMesa(Jugador jugador) {//ver een que estado
        this.jugadores.remove(jugador);
        jugador.setMesaActual(null);
        //poner cartas en mazo
    }

    public boolean mesaLlena() {
        return jugadores.size() == cantJugadoresMaxima;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void repartirCartas() {
        for (Jugador j : jugadores) {
            for (int i = 0; i < 5; i++) {
                Carta carta = mazo.agarrarCarta();
                j.agregarCarta(carta);
            }
        }
    }

    public void ingresarJugador(Jugador jugador) {
        this.estadoMesa.agregarJugador(jugador);
        if (!this.puedeIniciar()) {
            avisar(Mesa.Eventos.cambiarDatos);
        }
    }

    //MESA------------------------
    //llamar
    public void iniciarMesa() {
        this.estadoMesa.iniciarJuego();
        avisar(Mesa.Eventos.start);

    }

    protected void empezarPartida() {
        if (this.rondaActual == null) {
            this.repartirCartas();
            this.rondaActual = new Mano(this, jugadores);
            this.hisManos.add(rondaActual);
        }
    }

    public void terminarMesa() {
        this.estadoMesa.finalizarJuego(this.rondaActual.getJugadorGanador());
        this.avisar(Mesa.Eventos.finalizo);
    }

    private ArrayList<Jugador> eliminarJugadoresConDineroInsuficiente(ArrayList<Jugador> lista) {
        for (Jugador j : lista) {
            if (j.getSaldo() < this.getValorApuestaBase()) {
                lista.remove(j);
            }
        }
        return lista;
    }

    public void empezarSiguienteMano() {
        if (this.rondaActual != null) {
            if (rondaActual.getParticipantes().size() > 1) {
                devolverAMaso();
                this.repartirCartas();
                this.rondaActual = new Mano(this, eliminarJugadoresConDineroInsuficiente(this.rondaActual.getParticipantes()));
                this.hisManos.add(rondaActual);
            } else {
                this.terminarMesa();
            }
        }
    }

    public void devolverAMaso() {
        for (Jugador j : this.jugadores) {
            mazo.devolverCartas(j.getCartas());
            j.borrarCartas();
        }
    }

    public void salirDeLaMesa(Jugador j) {
        if (!estaEnMesa(j)) {
            throw new IllegalArgumentException("el jugador no se encuentra en mesa");
        } else {
            if (!j.getCartas().isEmpty()) {
                this.mazo.devolverCartas(j.getCartas());
                j.borrarCartas();
                this.jugadores.remove(j);
                j.setMesaActual(null);
            }
        }
    }

    public boolean puedeIniciar() {
        return this.cantJugadoresMaxima <= this.jugadores.size();
    }

    public void pedidoCartas(ArrayList<Carta> aCambiar, Jugador j) {
        int cantAPedir = aCambiar.size();
        this.mazo.devolverCartas(aCambiar);
        j.getCartas().removeAll(aCambiar);
        j.getCartas().addAll(mazo.agarrarNCartas(cantAPedir));
    }

    public int getPorcentajeComision() {
        return porcentajeComision;
    }

    public int getMontoTotalApostado() {
        return montoTotalApostado;
    }

    public int getMontoTotalRecaudado() {
        return montoTotalRecaudado;
    }

    public void setMontoTotalApostado(int montoTotalApostado) {
        this.montoTotalApostado += montoTotalApostado;
    }

    protected void agregarJugadorMesa(Mesa this, Jugador jugador) {
        if (!this.mesaLlena() && !this.estaEnMesa(jugador)) {
            this.puedeEntrar(jugador);
            jugador.setMesaActual(this);
        } else {
            throw new IllegalArgumentException("No se puede agregar el jugador: mesa llena o el jugador ya está en la mesa.");
        }
    }

    protected void iniciarJuegoMesa( 
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        Mesa this) {
        try {
            this.empezarPartida();
            this.setEstadoMesa(new EstadoIniciada(this));
        } catch (Exception e) {
            throw new IllegalArgumentException("Faltan jugadores para iniciar la partida");
        }
    }

}
