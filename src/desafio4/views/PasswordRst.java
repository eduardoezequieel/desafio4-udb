package desafio4.views;

import controllers.UsersCtrl;
import helpers.ApplicationContext;
import helpers.Validators;
import javax.swing.JOptionPane;
import models.User;
import java.util.Scanner;
import controllers.UsersCtrl;

public class PasswordRst extends javax.swing.JFrame {
    Scanner scanner = new Scanner (System.in);
    private UsersCtrl controller;
    private User user;

    public PasswordRst() {
        initComponents();
        user = ApplicationContext.getUser();
         this.setLocationRelativeTo(null);
         controller = new UsersCtrl();
         
        
        System.out.println("Se abrio el formulario");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        Password = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        PasswordConfirmation = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        continueBtn = new javax.swing.JButton();
        exitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(62, 86, 97));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(65, 167, 218));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 560, 10));

        jPanel4.setBackground(new java.awt.Color(245, 251, 248));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Password.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        Password.setForeground(new java.awt.Color(51, 51, 51));
        Password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 212, 218), 1, true));
        Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordActionPerformed(evt);
            }
        });
        jPanel4.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 340, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(154, 168, 180));
        jLabel2.setText("Confirmar Contraseña");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(154, 168, 180));
        jLabel3.setText("Nueva Contraseña");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        PasswordConfirmation.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        PasswordConfirmation.setForeground(new java.awt.Color(51, 51, 51));
        PasswordConfirmation.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 212, 218), 1, true));
        jPanel4.add(PasswordConfirmation, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 340, 40));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, 400, 240));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(65, 167, 218));
        jLabel1.setText("Restablecer Contraseña");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, -1, -1));

        continueBtn.setBackground(new java.awt.Color(82, 190, 127));
        continueBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        continueBtn.setForeground(new java.awt.Color(255, 255, 255));
        continueBtn.setText("Restablecer");
        continueBtn.setActionCommand("Restablecer");
        continueBtn.setBorder(null);
        continueBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        continueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBtnActionPerformed(evt);
            }
        });
        jPanel2.add(continueBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 90, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 560, 440));

        exitBtn.setBackground(new java.awt.Color(255, 51, 51));
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setText("X");
        exitBtn.setBorder(null);
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 10, 30, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void continueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueBtnActionPerformed
        String nuevaContrasena = new String (Password.getPassword());
        String confirmarContrasena = new String (PasswordConfirmation.getPassword());
        
        if(validarContrasena(nuevaContrasena, confirmarContrasena)){
            
          JOptionPane.showMessageDialog(null, "¡Cambio de contraseña existoso!", "Continuar",JOptionPane.INFORMATION_MESSAGE);
           
          String identificationCode = user.getIdentificationCode();
          boolean actualizacionExitosa = controller.actualizaContrasena(identificationCode, nuevaContrasena);
          
          if (actualizacionExitosa) {
            this.dispose();
            LayoutFrm form = new LayoutFrm();
            form.setVisible(true);  
          
          }
          
            
        } else {
        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden o no cumplen con los requisitos", "Reintentar",JOptionPane.INFORMATION_MESSAGE);
        }
           
    }//GEN-LAST:event_continueBtnActionPerformed

    private boolean validarContrasena (String nuevaContrasena, String confirmarContrasena){
    
    return nuevaContrasena.length() >= 8 && !nuevaContrasena.equals("contraseña123") && nuevaContrasena.equals(confirmarContrasena);
    
    }
    
    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas salír del programa?", "Confirmación", JOptionPane.YES_NO_OPTION);
        
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
       
    }//GEN-LAST:event_exitBtnActionPerformed

    private void PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordActionPerformed



    }//GEN-LAST:event_PasswordActionPerformed

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
            java.util.logging.Logger.getLogger(PasswordRst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PasswordRst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PasswordRst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PasswordRst.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PasswordRst().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Password;
    private javax.swing.JPasswordField PasswordConfirmation;
    private javax.swing.JButton continueBtn;
    private javax.swing.JButton exitBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
