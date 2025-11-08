package iugrafica;

import controladores.JuegoControlador;
import controladores.VistaPoker;
import logicanegocios.EstadosMesa.Mesa;
import java.util.ArrayList;
import logicanegocios.*;
import logicanegocios.usuarios.Jugador;
import panelCartasPoker.CartaPoker;
import panelCartasPoker.PanelCartasPokerException;

public class JuegoPoker extends javax.swing.JDialog implements VistaPoker {


    private final JuegoControlador juegoControlador;

    public JuegoPoker(java.awt.Frame parent, boolean modal, Mesa mesa, Jugador jugador) {
        super(parent, modal);
        initComponents();
        this.juegoControlador = new JuegoControlador(mesa, null, jugador, this);
        this.msjError.setVisible(false);
        this.figuraJugadorActual.setVisible(false);
        this.jLabel1.setVisible(false);
        panelCartasPoker1.setEnabled(checkListener.isSelected());
        opcionesPedirCartas(false);
        this.setLocationRelativeTo(null);
        agregarListeners();
    }

    private void agregarListeners() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                juegoControlador.salirDeLaMesaActual();
            }
        });
    }

    JuegoPoker(Object object, boolean b, Jugador conectado) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTitulo = new javax.swing.JLabel();
        checkListener = new javax.swing.JCheckBox();
        txtNombreJugador = new javax.swing.JLabel();
        btnSalirMesa = new javax.swing.JButton();
        panelCartasPoker1 = new panelCartasPoker.PanelCartasPoker();
        figuraJugadorActual = new javax.swing.JLabel();
        btnPasar = new javax.swing.JButton();
        btnApostar = new javax.swing.JButton();
        btnIgualar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        valorApuesta = new javax.swing.JSpinner();
        msjError = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        pedir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        JugadoresConectaos = new javax.swing.JLabel();
        FondoMadera = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("EJEMPLO PANEL DE CARTAS POKER");
        getContentPane().setLayout(null);

        txtTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        txtTitulo.setText("Poker");
        getContentPane().add(txtTitulo);
        txtTitulo.setBounds(0, 20, 1080, 50);

        checkListener.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        checkListener.setText("Pedir cartas");
        checkListener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkListenerActionPerformed(evt);
            }
        });
        getContentPane().add(checkListener);
        checkListener.setBounds(440, 500, 210, 24);

        txtNombreJugador.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        txtNombreJugador.setText("NombreJugador");
        getContentPane().add(txtNombreJugador);
        txtNombreJugador.setBounds(40, 66, 1000, 70);

        btnSalirMesa.setText("Salir de la mesa");
        btnSalirMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirMesaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalirMesa);
        btnSalirMesa.setBounds(850, 550, 160, 28);
        getContentPane().add(panelCartasPoker1);
        panelCartasPoker1.setBounds(20, 140, 1020, 262);

        figuraJugadorActual.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        figuraJugadorActual.setText("Tu figura");
        getContentPane().add(figuraJugadorActual);
        figuraJugadorActual.setBounds(440, 400, 200, 50);

        btnPasar.setText("Pasar");
        btnPasar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasarActionPerformed(evt);
            }
        });
        getContentPane().add(btnPasar);
        btnPasar.setBounds(280, 550, 110, 28);

        btnApostar.setText("Apostar");
        btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApostarActionPerformed(evt);
            }
        });
        getContentPane().add(btnApostar);
        btnApostar.setBounds(30, 550, 110, 28);

        btnIgualar.setText("Igualar");
        btnIgualar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIgualarActionPerformed(evt);
            }
        });
        getContentPane().add(btnIgualar);
        btnIgualar.setBounds(160, 550, 100, 28);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1);
        jPanel1.setBounds(350, 120, 0, 0);
        getContentPane().add(valorApuesta);
        valorApuesta.setBounds(30, 490, 110, 40);

        msjError.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        msjError.setForeground(new java.awt.Color(255, 0, 0));
        msjError.setText("msjError");
        getContentPane().add(msjError);
        msjError.setBounds(190, 440, 1360, 40);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 390, 400, 60);

        pedir.setText("PEDIR");
        pedir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedirActionPerformed(evt);
            }
        });
        getContentPane().add(pedir);
        pedir.setBounds(430, 550, 160, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("<html>\n\tPosibles figuras:<br>\t\n● Poker: Cuatro cartas de igual valor sin importar el palo.<br>\n        ● Escalera: Cinco cartas cuyo valor está en escalera sin importar el palo.<br>\n         ● Pierna: Tres cartas de igual valor sin importar el palo.<br>\n         ● Par: Dos cartas de igual valor sin importar el palo.<br>\n        ● Sin figura: Las cartas no cumplen ninguno de los juegos anteriores.</html>");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 600, 600, 170);

        JugadoresConectaos.setText("Jugadores");
        getContentPane().add(JugadoresConectaos);
        JugadoresConectaos.setBounds(710, 600, 340, 170);

        FondoMadera.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ProbandoMadera.jpg"))); // NOI18N
        getContentPane().add(FondoMadera);
        FondoMadera.setBounds(0, -500, 1080, 3500);

        setBounds(0, 0, 1095, 1127);
    }// </editor-fold>//GEN-END:initComponents

    private void checkListenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkListenerActionPerformed
        if (checkListener.isSelected()) {
            panelCartasPoker1.setListener(this);
        } else {
            panelCartasPoker1.setListener(null);
            juegoControlador.cancelarPedir();
        }
        panelCartasPoker1.setEnabled(checkListener.isSelected());
    }//GEN-LAST:event_checkListenerActionPerformed

    private void btnSalirMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirMesaActionPerformed
        this.juegoControlador.salirDeLaMesaActual();
    }//GEN-LAST:event_btnSalirMesaActionPerformed

    private void btnPasarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasarActionPerformed
        // TODO add your handling code here:
        juegoControlador.pasar();
    }//GEN-LAST:event_btnPasarActionPerformed

    private void btnApostarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApostarActionPerformed
        this.juegoControlador.crearApuesta((int) this.valorApuesta.getValue());
    }//GEN-LAST:event_btnApostarActionPerformed

    private void btnIgualarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIgualarActionPerformed
        // TODO add your handling code here:
        juegoControlador.igualar();
    }//GEN-LAST:event_btnIgualarActionPerformed

    private void pedirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedirActionPerformed
        // TODO add your handling code here:
        juegoControlador.pedidoCompleto();
    }//GEN-LAST:event_pedirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FondoMadera;
    private javax.swing.JLabel JugadoresConectaos;
    private javax.swing.JButton btnApostar;
    private javax.swing.JButton btnIgualar;
    private javax.swing.JButton btnPasar;
    private javax.swing.JButton btnSalirMesa;
    private javax.swing.JCheckBox checkListener;
    private javax.swing.JLabel figuraJugadorActual;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel msjError;
    private panelCartasPoker.PanelCartasPoker panelCartasPoker1;
    private javax.swing.JButton pedir;
    private javax.swing.JLabel txtNombreJugador;
    private javax.swing.JLabel txtTitulo;
    private javax.swing.JSpinner valorApuesta;
    // End of variables declaration//GEN-END:variables

    @Override
    public void clickEnCarta(CartaPoker carta) {
        juegoControlador.pedirCartas((Carta) carta);
        carta.setVisible(false);
        //JOptionPane.showMessageDialog(this, carta.toString(), "Click en carta", JOptionPane.INFORMATION_MESSAGE);
    }

    @Override
    public void btnPasarApuesta(Boolean b) {
        btnPasar.setVisible(b);
    }

    @Override
    public void btnIgualarApuesta(Boolean b) {
        btnIgualar.setVisible(b);
    }

    @Override
    public void opcionesCrearApuesta(Boolean b) {
        btnApostar.setVisible(b);
        valorApuesta.setVisible(b);
    }

    @Override
    public void cargarCartas(ArrayList<Carta> cartas) {
        try {
            ArrayList<CartaPoker> cartasPoker = new ArrayList<>();
            for (Carta carta : cartas) {
                cartasPoker.add((CartaPoker) carta);
            }
            panelCartasPoker1.cargarCartas(cartasPoker);
        } catch (PanelCartasPokerException e) {
            System.out.println("Error al cargar las cartas: " + e.getMessage());
        }
    }

    @Override
    public void mostrarFiguraJugador(String f) {
        this.figuraJugadorActual.setVisible(true);
        this.figuraJugadorActual.setText(f);
    }

    @Override
    public void enEspera(Jugador jugadorActual, Mesa mesaActual) {
        txtTitulo.setText("Esperando inicio del juego, hay " + mesaActual.cantJugadoresConectados() + " jugadores de " + mesaActual.getCantJugadoresMaxima() + " en la mesa");
        txtNombreJugador.setText("Nombre: " + jugadorActual.getNombreCompleto() + " Numero de mesa: " + mesaActual.getNumeroMesa());
    }

    @Override
    public void cerrarJuego() {
        dispose();

    }

    @Override
    public void volverMenu(Jugador us) {
        new IngresarAMesa(null, false, us).setVisible(true);
    }

    @Override
    public void mostrarError(String mensaje) {
        this.msjError.setVisible(true);
        this.msjError.setText(mensaje);
    }

    @Override
    public void mostrarApuestaActual(String num) {
        this.jLabel1.setVisible(true);
        this.jLabel1.setText(num);
    }

    @Override
    public void opcionesPedirCartas(Boolean b) {
        this.checkListener.setVisible(b);
        this.pedir.setVisible(b);
    }

    @Override
    public void editarTitulo(String string) {
        txtTitulo.setText(string);
    }

    @Override
    public void editarSubTitulos(String string) {
        txtNombreJugador.setText(string);
    }

    public void cargarNombresJugadores(Mesa mesa) {
        StringBuilder htmlLista = new StringBuilder("<html>");
        htmlLista.append("Participantes:<br>");
        for (Jugador j : mesa.getJugadores()) {
            htmlLista.append("● ").append(j.getNombreCompleto()).append("<br>");
        }
        htmlLista.append("</html>");
        JugadoresConectaos.setText(htmlLista.toString());
        
    }

}
