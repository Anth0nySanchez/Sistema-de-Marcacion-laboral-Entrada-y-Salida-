/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebCam;

import JDBC.Conexion;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author anthony
 */
public class Capturadora extends javax.swing.JFrame {
    String codigo;
    java.sql.Date fecha;
    String hora;
    String IO;
    String alter ;
    /**
     * Creates new form Capturadora
     */
    
    private Capturadora() {
        
    }
    
    public Capturadora(String codigo, java.sql.Date fecha, String hora, String IO) {
        initComponents();
        this.codigo = codigo;
        this.fecha = fecha;
        this.hora = hora;
        this.IO = IO;
        validarIO();
        setTitle("WebCam");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    public void validarIO(){
        if(IO.equals("E"))
            alter = "E";
        else
            alter = "S";
    }

    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelCam = new JPanelWebCam.JPanelWebCam();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PanelCamLayout = new javax.swing.GroupLayout(PanelCam);
        PanelCam.setLayout(PanelCamLayout);
        PanelCamLayout.setHorizontalGroup(
            PanelCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
        );
        PanelCamLayout.setVerticalGroup(
            PanelCamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
        );

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(PanelCam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelCam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        BufferedImage image = (BufferedImage) PanelCam.getImage();
        ByteArrayOutputStream out=new ByteArrayOutputStream();
        try {
            ImageIO.write((RenderedImage) image, "jpg", out);
            InputStream in=new ByteArrayInputStream(out.toByteArray());
            Conexion cn = new Conexion();
            Connection c = cn.Conec();
            PreparedStatement pst = c.prepareStatement("INSERT INTO tblRegistro(USUARIO, URL_FOTO, FECHA, HORA, TIPO_IN_OUT) VALUES(?,?,?,?,?)");
            pst.setString(1, codigo);
            pst.setBinaryStream(2, in);
            pst.setDate(3, fecha);
            pst.setString(4, hora);
            pst.setString(5, alter);
            if(pst.executeUpdate() > 0)
                JOptionPane.showMessageDialog(null, "Registrado","Listo", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al capturar la foto");
        } catch (IllegalArgumentException ia) {
            JOptionPane.showMessageDialog(null, "No hay camara disponible", null, JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Capturadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Capturadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Capturadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Capturadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Capturadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanelWebCam.JPanelWebCam PanelCam;
    private javax.swing.JButton btnGuardar;
    // End of variables declaration//GEN-END:variables
}
