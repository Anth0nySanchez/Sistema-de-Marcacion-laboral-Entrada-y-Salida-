/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Atxy2k.CustomTextField.RestrictedTextField;
import JDBC.Conexion;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author anthony
 */
public class FrameReportes extends javax.swing.JFrame {
    
    public static int extras;
    public static int atrasos;
    int posX, posY;
    String desde;
    String hasta;
    /**
     * Creates new form FrameReportes
     */
    public FrameReportes() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        Restringir();
    }
    
    //Obtiene los datos de las fechas seleccionadas en el JDateChooser
    public java.sql.Date RecuperarDatos(JDateChooser j){
            Date date = j.getDate();
            long l = date.getTime();
            java.sql.Date fecha = new java.sql.Date(l);
            return fecha;
    }
    
    //Limita el numero de caracteres que podemos escribir 
     public void Restringir(){
        RestrictedTextField res = new RestrictedTextField(txtCodigo);
        res.setOnlyNums(true);
        res.setLimit(4);
        res.setOnlyNums(true);
    }
    
     //Calcula las horas de atraso
    public String Atrasos(String HoraLlegada){
        int horas = Integer.parseInt(HoraLlegada.substring(0,2));
        int minutos = Integer.parseInt(HoraLlegada.substring(3, 5));
        int segundos = Integer.parseInt(HoraLlegada.substring(6,8));
        if(horas < 9){
            return "0";
        }
        else{
            int horaAtraso = horas - 9 ;
            if(horaAtraso >= 0 && minutos >= 0 && segundos >0){
                atrasos = atrasos + (horaAtraso + 1);
                String patron = "%02d:%02d:%02d";
                String formato = String.format(patron,horaAtraso,minutos,segundos);
                return formato;
            }
            else
                return "0";
        }
        
    }
    
    //Calcula las horas Extras
    public String Extras(String HoraSalida){
        int horas = Integer.parseInt(HoraSalida.substring(0,2));
        int minutos = Integer.parseInt(HoraSalida.substring(3,5));
        int segundos = Integer.parseInt(HoraSalida.substring(6,8)); 
        if(horas < 18){
            return "0";
        }
        else{
            int horaExtra = horas - 18;
            if(horaExtra >= 0 && minutos >= 0 && segundos >0){
                extras = extras + (horaExtra + 1);
                String patron = "%02d:%02d:%02d";
                String formato = String.format(patron,horaExtra,minutos,segundos);
                return formato;
            }
            else
                return "0";
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        DCDesde = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        DCHasta = new com.toedter.calendar.JDateChooser();
        btnGenerar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Codigo");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 94, 28));

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 230, 34));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Desde");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 94, 30));
        getContentPane().add(DCDesde, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 230, 40));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Hasta");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 100, 30));
        getContentPane().add(DCHasta, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 270, 230, 40));

        btnGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarBig.png"))); // NOI18N
        btnGenerar.setBorderPainted(false);
        btnGenerar.setContentAreaFilled(false);
        btnGenerar.setFocusPainted(false);
        btnGenerar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarSmall.png"))); // NOI18N
        btnGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGenerar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 350, 90, 70));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CancelarBig.png"))); // NOI18N
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancelarSmall.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 90, 70));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoRegistro.png"))); // NOI18N
        jLabel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel4MouseDragged(evt);
            }
        });
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseDragged
        int xp = evt.getXOnScreen() - posX;
        int yp = evt.getYOnScreen() - posY;
        this.setLocation(xp, yp);
    }//GEN-LAST:event_jLabel4MouseDragged

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
    }//GEN-LAST:event_txtCodigoKeyTyped

    /*
        Este evento genera el PDF que obtiene los registros de la Base de datos principal
        Primero pone los datos, luego genera una tabla con los registros y para terminar
        pone el numero de horas de atraso y extras
    */
    private void btnGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarActionPerformed
            try{                            
                String[] contenedor = datoNombreApellido();
                Conexion con = new Conexion();
                Connection link = con.Conec();
                Document documento = new Document();
                PdfWriter.getInstance(documento, new FileOutputStream("C:\\Users\\Anthony\\Desktop\\Reporte.pdf"));
                documento.open();
                documento.add(new Phrase("Nombre: "+contenedor[0]));
                documento.add(new Phrase("\nApellido: "+contenedor[1])); 
                PdfPTable table = new PdfPTable(6);
                table.setWidthPercentage(100f);
                table.addCell(new Phrase("FOTO"));
                table.addCell(new Phrase("FECHA"));
                table.addCell(new Phrase("HORA"));          
                table.addCell(new Phrase("ATRASO"));
                table.addCell(new Phrase("EXTRA"));
                table.addCell(new Phrase("TIPO"));
                try{
                    Statement st = link.createStatement();
                    ResultSet rs = st.executeQuery("SELECT URL_FOTO,FECHA,HORA,TIPO_IN_OUT FROM tblregistro WHERE USUARIO = '"+txtCodigo.getText()+"' && FECHA BETWEEN '"+RecuperarDatos(DCDesde)+"' AND '"+RecuperarDatos(DCHasta)+"'");
                    while(rs.next()){
                        Blob blob = rs.getBlob(1);
                        byte[] data = blob.getBytes(1, (int) blob.length());
                        Image imagen = Image.getInstance(data);
                            table.addCell(imagen);
                        table.addCell(new Phrase(rs.getString(2)));
                        table.addCell(new Phrase(rs.getString(3)));
                        if(rs.getString(4).equals("E")){
                            table.addCell(new Phrase(Atrasos(rs.getString(3))));
                            table.addCell(new Phrase("0"));
                        }
                        else{
                            table.addCell(new Phrase("0"));
                            table.addCell(new Phrase(Extras(rs.getString(3))));
                        }
                        if(rs.getString(4).equals("E"))
                            table.addCell(new Phrase("Entrada"));
                        else
                            table.addCell(new Phrase("Salida"));  
                    }
                    documento.add(table);
                    documento.add(new Phrase("Total Horas Extras: "+extras));
                    documento.add(new Phrase("\nTotal Horas Atrasadas: "+atrasos));
                    JOptionPane.showMessageDialog(null, "Reporte Creado");
                    documento.close();
                    st.close();
                    rs.close();
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
            catch(FileNotFoundException ex){
                JOptionPane.showMessageDialog(null, "Cierre el documento antes de generar otro reporte");
            }
            catch (DocumentException ex) {
                ex.printStackTrace();
            }
            dispose();
    }//GEN-LAST:event_btnGenerarActionPerformed

    
    public String[] datoNombreApellido(){
        String[] contenedor = new String[2];
        Conexion con = new Conexion();
        Connection link = con.Conec();
        try{
            Statement pst = link.createStatement();
            ResultSet rs = pst.executeQuery("SELECT Nombre, Apellido FROM tblusuario WHERE CODIGO = '"+txtCodigo.getText()+"'");
            if(rs.next()){
                contenedor[0] = rs.getString(1);
                contenedor[1] = rs.getString(2);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return contenedor;
    }
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
            java.util.logging.Logger.getLogger(FrameReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameReportes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameReportes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser DCDesde;
    private com.toedter.calendar.JDateChooser DCHasta;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGenerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
