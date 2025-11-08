package iugrafica;

import controladores.MesaLobbyControlador;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logicanegocios.Fachada;
import logicanegocios.EstadosMesa.Mesa;
import logicanegocios.usuarios.Jugador;
import logicanegocios.usuarios.Usuario;
import controladores.VistaIngresoMesaControlador;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class IngresarAMesa extends javax.swing.JDialog implements VistaIngresoMesaControlador {

    private MesaLobbyControlador mesaControler;

    public IngresarAMesa(java.awt.Frame parent, boolean modal, Usuario us) {
        super(parent, modal);
        initComponents();
        this.mesaControler = new MesaLobbyControlador(this, us);
        centrarContenidoTabla();
        this.setLocationRelativeTo(null);
        agregarListeners();
    }

    private void agregarListeners() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                mesaControler.logOut();
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIngresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaMesas = new javax.swing.JTable();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seleccionar mesa");

        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 480, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 150, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, -1, 30));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Saldo:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, -1, 30));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Ingresar a una mesa");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 306, 60));

        listaMesas.setBackground(new java.awt.Color(204, 204, 255));
        listaMesas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        listaMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num mesa", "Cant jugadores", "Vaor apuesta base", "Cant jugadores actual", "Porcentaje de comision"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        listaMesas.setToolTipText("");
        jScrollPane2.setViewportView(listaMesas);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 178, 830, 300));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ProbandoMadera.jpg"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-570, -610, 1470, 1210));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(737, 737, 737)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(508, 508, 508)
                .addComponent(btnIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(56, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        ingresarMesa();
    }//GEN-LAST:event_btnIngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable listaMesas;
    // End of variables declaration//GEN-END:variables

    public void ingresarMesa() {
        int selectedRow = listaMesas.getSelectedRow(); 
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una mesa", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int numMesa = (int) listaMesas.getValueAt(selectedRow, 0); 

        Mesa mesaSeleccionada = Fachada.getInstancia().buscarMesa(numMesa);
        if (mesaSeleccionada != null) {
            mesaControler.ingresarJugador(mesaSeleccionada);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró la mesa seleccionada", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void cargarInterfaz(Jugador o) {
        jLabel1.setText(o.getNombreCompleto());
        jLabel2.setText(Integer.toString(o.getSaldo()));

    }

    @Override
    public void notificarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    @Override
    public void abrirPoker(Mesa mesa, Jugador j) {
        new JuegoPoker(null, false, mesa, j).setVisible(true);
        dispose();
    }

    @Override
    public void cargarMesas(ArrayList<Mesa> mesas) {
        DefaultTableModel model = (DefaultTableModel) listaMesas.getModel();
        model.setRowCount(0);
        for (Mesa mesa : mesas) {
            model.addRow(new Object[]{
                mesa.getNumMesa(),
                mesa.getCantJugadoresMaxima(),
                mesa.getValorApuestaBase(),
                mesa.cantJugadoresConectados(),
                mesa.getEstadoMesa().toString() 
            });
        }
        btnIngresar.setEnabled(!mesas.isEmpty()); 
    }

    //centra las cosas a mostrar en el medio de la celda
    private void centrarContenidoTabla() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        // Iterar por todas las columnas de la tabla y aplicar el render
        for (int i = 0; i < listaMesas.getColumnModel().getColumnCount(); i++) {
            listaMesas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @Override
    public void cerrarVentana() {
        dispose();
    }

}
