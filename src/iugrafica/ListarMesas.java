package iugrafica;

import controladores.AdminControlador;
import controladores.VistaAdmin;
import logicanegocios.EstadosMesa.Mesa;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logicanegocios.usuarios.Usuario;

public class ListarMesas extends javax.swing.JDialog implements VistaAdmin {

    private AdminControlador controlador;
    private Usuario usuario;
    
    
    public ListarMesas(java.awt.Frame parent, boolean modal, Usuario usuario) {
        super(parent, modal);
        initComponents();
        centrarContenidoTabla();
        controlador = new AdminControlador(this,usuario);
        controlador.cargarMesas();
        this.setLocationRelativeTo(null);
        this.usuario = usuario;
        agregarListeners();
    }

    private void agregarListeners() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                controlador.logOut();
            }
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnSeleccionarMesa = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaMesas = new javax.swing.JTable();
        Fondo = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuOpciones = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gestion de mesas");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSeleccionarMesa.setText("Ver detalle");
        btnSeleccionarMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarMesaActionPerformed(evt);
            }
        });
        jPanel1.add(btnSeleccionarMesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 450, 150, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Mesas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 340, 70));

        listaMesas.setBackground(new java.awt.Color(204, 204, 255));
        listaMesas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        listaMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num mesa", "Cant jugadores Inicio", "Valor apuesta base", "Cant actual jugadores", "Numero mano", "Monto total apostado", "Porcentaje comision", "Monto total rec", "Estado mano"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(listaMesas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 1220, 330));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ProbandoMadera.jpg"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1310, 530));

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 0));

        menuOpciones.setText("Opciones");
        menuOpciones.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        jMenuItem1.setText("Crear mesa");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuOpciones.add(jMenuItem1);

        jMenuBar1.add(menuOpciones);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        dispose();
        new CrearMesa(null, false, usuario, controlador).setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnSeleccionarMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarMesaActionPerformed
        redireccionamiento();
    }//GEN-LAST:event_btnSeleccionarMesaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton btnSeleccionarMesa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaMesas;
    private javax.swing.JMenu menuOpciones;
    // End of variables declaration//GEN-END:variables

    @Override
    public void cargarMesas(ArrayList<Mesa> mesas) {
        DefaultTableModel model = (DefaultTableModel) listaMesas.getModel();
        model.setRowCount(0);
        if (mesas.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay mesas registradas", "Advertencia", JOptionPane.WARNING_MESSAGE);
            btnSeleccionarMesa.setEnabled(false);
        } else {
            for (Mesa actual : mesas) {
                Object[] row = {
                    actual.getNumMesa(),
                    actual.getCantJugadoresMaxima(),
                    actual.getValorApuestaBase(),
                    actual.getJugadores().size(),
                    actual.getNumManoActual(),
                    actual.getMontoTotalApostado(),
                    actual.getPorcentajeComision(),
                    actual.getMontoTotalRecaudado(),
                    actual.getEstadoMesa().toString()
                };
                model.addRow(row);
            }
            btnSeleccionarMesa.setEnabled(true);
        }
    }

    //centra las cosas a mostrar en el medio de la celda
    private void centrarContenidoTabla() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

        for (int i = 0; i < listaMesas.getColumnModel().getColumnCount(); i++) {
            listaMesas.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, null, JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void redireccionamiento() {
        dispose();
        int selectedRow = listaMesas.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una mesa", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            // Obtén el identificador de la mesa seleccionada (por ejemplo, el número de mesa)
            int numMesa = (int) listaMesas.getValueAt(selectedRow, 0); // Columna 0: Num mesa
            new DetalleMano(null, false, numMesa, controlador, usuario).setVisible(true);
            dispose();
        }
    }

}
