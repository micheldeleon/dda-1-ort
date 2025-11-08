package iugrafica;

import controladores.AdminControlador;
import controladores.VistaDetalle;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import logicanegocios.EstadosMano.Mano;
import logicanegocios.EstadosMesa.Mesa;
import logicanegocios.usuarios.Usuario;

public class DetalleMano extends javax.swing.JDialog implements VistaDetalle {

    private AdminControlador controladorAdmin;

    public DetalleMano(java.awt.Frame parent, boolean modal, int idMesa, AdminControlador controlador, Usuario usuario) {
        super(parent, modal);
        initComponents();
        centrarCeldas();
        this.setLocationRelativeTo(null);
        controladorAdmin = controlador;
        controladorAdmin.setVistaDetalle(this);
        controladorAdmin.verDetalles(idMesa);
        agregarListeners();
    }
    
    private void agregarListeners() {
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {
                controladorAdmin.logOut();
            }
        });
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaManos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listaManos.setBackground(new java.awt.Color(204, 204, 255));
        listaManos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        listaManos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num mano", "Cant jugadores", "Total apostado", "Estado actual", "Nombre jugador ganador", "Nombre figura ganadora"
            }
        ));
        jScrollPane1.setViewportView(listaManos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 1020, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Detalles manos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 300, 40));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ProbandoMadera.jpg"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1150, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void centrarCeldas() {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER); // Centrar horizontalmente

        // Aplicar el renderizador a todas las columnas
        for (int i = 0; i < listaManos.getColumnModel().getColumnCount(); i++) {
            listaManos.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listaManos;
    // End of variables declaration//GEN-END:variables

    @Override
    public void detalleMesaVer(Mesa mesa) {
        DefaultTableModel model = (DefaultTableModel) listaManos.getModel();
        model.setRowCount(0);

        for (Mano mano : mesa.getHisManos()) {
            String ganador;
            if (mano.getJugadorGanador() != null) {
                ganador = mano.getJugadorGanador().getNombreCompleto();
            } else {
                ganador = "Sin ganador";
            }

            model.addRow(new Object[]{
                mesa.getNumManoActual(),
                mesa.getJugadores().size(),
                mano.montoApuesta(),
                mano.getEstadoMano().toString(),
                ganador,
                mano.getGanadora() != null ? mano.getGanadora().toString() : "No hubo figura"
            });
        }
    }
}



//    private void verDetalleMesa(Mesa mesa) {
//        /*DefaultTableModel model = (DefaultTableModel) listaManos.getModel();
//        model.setRowCount(0);
//
//        for (Mano mano : mesa.getHisManos()) {
//            String ganador;
//            if (mano.getJugadorGanador() != null) {
//                ganador = mano.getJugadorGanador().getNombreCompleto();
//            } else {
//                ganador = "Sin ganador";
//            }
//
//            model.addRow(new Object[]{
//                mesa.getNumManoActual(),
//                mesa.getJugadores().size(),
//                mano.montoApuesta(),
//                mano.getEstadoMano().toString(),
//                ganador,
//                mano.getGanadora() != null ? mano.getGanadora().toString() : "No hubo figura"
//            });
//        }*/
//        
//    }