package iugrafica;

import controladores.AdminControlador;
import controladores.VistaAdmin;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import logicanegocios.EstadosMesa.Mesa;
import logicanegocios.Excepciones.MesaException;
import logicanegocios.usuarios.Usuario;


public class CrearMesa extends javax.swing.JDialog implements VistaAdmin{

   
    private AdminControlador controladorAdmin;
    private Usuario usuario;
    
    
    public CrearMesa(java.awt.Frame parent, boolean modal, Usuario usuario, AdminControlador controlador) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        controladorAdmin = new AdminControlador(this, usuario);
        this.usuario = usuario;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vApuestaBase = new javax.swing.JSpinner();
        vPorcentajeComision = new javax.swing.JSpinner();
        vCantidadJMax = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Valor de apuesta base");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 142, 40));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Porcentaje de comision");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 140, 30));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Cantidad de Jugadores maximo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 180, 40));
        jPanel1.add(vApuestaBase, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 230, 180, -1));
        jPanel1.add(vPorcentajeComision, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 180, -1));
        jPanel1.add(vCantidadJMax, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 180, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Crear Mesa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 270, 70));

        jButton1.setText("Crear ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, 100, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ProbandoMadera.jpg"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-440, -720, 5050, 2740));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            crear();
        } catch (MesaException ex) {
            Logger.getLogger(CrearMesa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSpinner vApuestaBase;
    private javax.swing.JSpinner vCantidadJMax;
    private javax.swing.JSpinner vPorcentajeComision;
    // End of variables declaration//GEN-END:variables

    private void crear() throws MesaException {
        int apuestaBase = (int) vApuestaBase.getValue();
        int porcentajeComision = (int) vPorcentajeComision.getValue();
        int maxJugadores = (int) vCantidadJMax.getValue();
        controladorAdmin.crear(apuestaBase, porcentajeComision, maxJugadores);
    }

    @Override
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, null, JOptionPane.WARNING_MESSAGE);
    }

    @Override
    public void redireccionamiento() {
        dispose();
        new ListarMesas(null, false, usuario).setVisible(true);
    }

    @Override
    public void cargarMesas(ArrayList<Mesa> mesas) {
        throw new UnsupportedOperationException("xd"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
