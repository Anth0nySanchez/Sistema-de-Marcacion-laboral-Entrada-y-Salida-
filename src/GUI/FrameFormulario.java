package GUI;

import Atxy2k.CustomTextField.RestrictedTextField;
import JDBC.Conexion;
import JDBC.MetodosBaseDeDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class FrameFormulario extends javax.swing.JFrame {

    int posX, posY;
    
    public FrameFormulario() {
        setUndecorated(true);
        initComponents();
        setLocationRelativeTo(null);
        Restringir();
        
    }
    
    // Este método restringe la cantidad de caracteres que se pueden escribir dentro de determinados JtextField
    public void Restringir(){
        RestrictedTextField res = new RestrictedTextField(txtDepartamento);
        RestrictedTextField res2 = new RestrictedTextField(txtCedula);
        RestrictedTextField res3 = new RestrictedTextField(txtCodigo);
        res.setLimit(2);
        res2.setLimit(10);
        res3.setLimit(4);
        res2.setOnlyNums(true);
        res3.setOnlyNums(true);
    }
    
    //Este procedimiento valida si el email ingresado 
    //cumple con las caracteristicas basicas de un correo electronico
    private boolean validarEmail(){
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                                          + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(txtEmail.getText());
        if(matcher.find() == true)
            return true;
        else{
            JOptionPane.showMessageDialog(null, "Ingrese un Email valido","Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
            
    }
    
    //Este metodo verifica que ninguno de los campos de texto del formulario queden vacios
    private boolean esCamposVacios(){
        if(txtApellido.getText().equals("") || txtNombre.getText().equals("") || txtCedula.getText().equals("") || txtEmail.getText().equals("") ||
                txtDepartamento.getText().equals("") || txtCodigo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "No dejar campos vacios");
            return false;
        }
        else
            return true;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        txtDepartamento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnCancelar2 = new javax.swing.JButton();
        btnActualizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 100, 30));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 250, 40));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel2.setText("Apellido");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 100, 30));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 250, 40));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Cedula");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 100, 30));

        txtCedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCedulaKeyTyped(evt);
            }
        });
        getContentPane().add(txtCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 250, 40));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel4.setText("Email");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 100, 30));
        getContentPane().add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 250, 40));

        txtDepartamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDepartamentoKeyTyped(evt);
            }
        });
        getContentPane().add(txtDepartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 90, 40));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel5.setText("Codigo");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 100, 30));

        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarBig.png"))); // NOI18N
        btnGuardar.setBorderPainted(false);
        btnGuardar.setContentAreaFilled(false);
        btnGuardar.setFocusPainted(false);
        btnGuardar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/GuardarSmall.png"))); // NOI18N
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 540, 64, 64));

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EliminarBig.png"))); // NOI18N
        btnEliminar.setBorderPainted(false);
        btnEliminar.setContentAreaFilled(false);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/EliminarSmall.png"))); // NOI18N
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 540, 70, 70));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel7.setText("Departamento");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 440, 130, 30));

        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 480, 90, 40));

        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CancelarBig.png"))); // NOI18N
        btnCancelar.setBorderPainted(false);
        btnCancelar.setContentAreaFilled(false);
        btnCancelar.setFocusPainted(false);
        btnCancelar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/CancelarSmall.png"))); // NOI18N
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 70, 70));

        btnCancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ActualizarBig.png"))); // NOI18N
        btnCancelar2.setBorderPainted(false);
        btnCancelar2.setContentAreaFilled(false);
        btnCancelar2.setFocusPainted(false);
        btnCancelar2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ActualizarSmall.png"))); // NOI18N
        btnCancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 540, 70, 70));

        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/FondoFormulario.png"))); // NOI18N
        btnActualizar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnActualizarMouseDragged(evt);
            }
        });
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnActualizarMousePressed(evt);
            }
        });
        getContentPane().add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        Conexion cn = new Conexion();
        Connection con = cn.Conec();
        try{
            PreparedStatement pst = con.prepareStatement("DELETE FROM tblusuario WHERE CODIGO = '"+txtCodigo.getText()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuario Eliminado Satisfactoriamente");
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    //Este método manda a guardar a la base de datos el formulario
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        MetodosBaseDeDatos met = new MetodosBaseDeDatos();
        try {
            if(esCamposVacios() == true && met.noExiste("tblusuario", "Codigo", txtCodigo.getText(), "Codigo ya existe") == false && met.existe("tbldepartamento","ID_DEPARTAMENTO",txtDepartamento.getText(),"Departamento no existe")){
                Conexion cn = new Conexion();
                Connection link = cn.Conec();
                try{
                    PreparedStatement pst = link.prepareStatement("INSERT into tblUsuario(Nombre,Apellido,Email,Codigo,Cedula,Departamento) VALUES (?,?,?,?,?,?)");
                    pst.setString(1, txtNombre.getText());
                    pst.setString(2, txtApellido.getText());
                    pst.setString(3, txtEmail.getText());
                    pst.setString(4, txtCodigo.getText());
                    pst.setString(5, txtCedula.getText());
                    pst.setInt(6, Integer.parseInt(txtDepartamento.getText()));
                    if(pst.executeUpdate() > 0)
                        JOptionPane.showMessageDialog(null, "Usuario Registrado Satisfactoriamente");
                    link.close();
                    dispose();
                }
                catch(SQLException e){
                    JOptionPane.showMessageDialog(null, "Ocurrio un error","Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrameFormulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
    
    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped

    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtDepartamentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDepartamentoKeyTyped

    }//GEN-LAST:event_txtDepartamentoKeyTyped

    private void txtCedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCedulaKeyTyped
    }//GEN-LAST:event_txtCedulaKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar2ActionPerformed
        Conexion cn = new Conexion();
        Connection con = cn.Conec();
        try{
            PreparedStatement pst = con.prepareStatement("UPDATE tblusuario SET NOMBRE = '"+txtNombre.getText()+"', APELLIDO = '"+txtApellido.getText()+
                    "', EMAIL = '"+txtEmail.getText()+"', DEPARTAMENTO = '"+txtDepartamento.getText()+"'  WHERE CODIGO = '"+txtCodigo.getText()+"'");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null,"Usuario Actualizado Satisfactoriamente");
        }
        catch(Exception e){
            e.printStackTrace();
        }    
        dispose();
    }//GEN-LAST:event_btnCancelar2ActionPerformed

    //Este metodo toma las posiciones X e Y Mientras presionamos el form
    private void btnActualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMousePressed
        posX = evt.getX();
        posY = evt.getY();
    }//GEN-LAST:event_btnActualizarMousePressed

    //Este metodo cambia la ubicacion del frame a medida que arrastramos el mismo
    private void btnActualizarMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnActualizarMouseDragged
        int xp = evt.getXOnScreen() - posX;
        int yp = evt.getYOnScreen() - posY;
        this.setLocation(xp, yp);
    }//GEN-LAST:event_btnActualizarMouseDragged
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameFormulario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnActualizar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar2;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDepartamento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
