/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio4.views;

import java.awt.Color;

/**
 *
 * @author Eduardo
 */
public class SelectionInventoryFrm extends javax.swing.JPanel {
    private Color pressedButtonColor = new Color(43, 111, 145);
    private Color defaultButtonColor = new Color(65,167,218);
    
    public SelectionInventoryFrm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        userBtn = new javax.swing.JButton();
        userBtn1 = new javax.swing.JButton();
        userBtn2 = new javax.swing.JButton();
        userBtn3 = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1070, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userBtn.setBackground(new java.awt.Color(65, 167, 218));
        userBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userBtn.setForeground(new java.awt.Color(255, 255, 255));
        userBtn.setText("Creadores");
        userBtn.setBorder(null);
        userBtn.setBorderPainted(false);
        userBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userBtn.setFocusable(false);
        userBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userBtnMouseExited(evt);
            }
        });
        userBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBtnActionPerformed(evt);
            }
        });
        jPanel1.add(userBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 220, 100));

        userBtn1.setBackground(new java.awt.Color(65, 167, 218));
        userBtn1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userBtn1.setForeground(new java.awt.Color(255, 255, 255));
        userBtn1.setText("Material base");
        userBtn1.setBorder(null);
        userBtn1.setBorderPainted(false);
        userBtn1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userBtn1.setFocusable(false);
        userBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userBtn1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userBtn1MouseExited(evt);
            }
        });
        userBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBtn1ActionPerformed(evt);
            }
        });
        jPanel1.add(userBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 220, 100));

        userBtn2.setBackground(new java.awt.Color(65, 167, 218));
        userBtn2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userBtn2.setForeground(new java.awt.Color(255, 255, 255));
        userBtn2.setText("Inventario");
        userBtn2.setBorder(null);
        userBtn2.setBorderPainted(false);
        userBtn2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userBtn2.setFocusable(false);
        userBtn2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userBtn2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userBtn2MouseExited(evt);
            }
        });
        userBtn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBtn2ActionPerformed(evt);
            }
        });
        jPanel1.add(userBtn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 170, 220, 100));

        userBtn3.setBackground(new java.awt.Color(65, 167, 218));
        userBtn3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        userBtn3.setForeground(new java.awt.Color(255, 255, 255));
        userBtn3.setText("Editoriales");
        userBtn3.setBorder(null);
        userBtn3.setBorderPainted(false);
        userBtn3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userBtn3.setFocusable(false);
        userBtn3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userBtn3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userBtn3MouseExited(evt);
            }
        });
        userBtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userBtn3ActionPerformed(evt);
            }
        });
        jPanel1.add(userBtn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 220, 100));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 690));
    }// </editor-fold>//GEN-END:initComponents

    private void userBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtnMouseEntered
        userBtn.setBackground(pressedButtonColor);
    }//GEN-LAST:event_userBtnMouseEntered

    private void userBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtnMouseExited
        userBtn.setBackground(defaultButtonColor);
    }//GEN-LAST:event_userBtnMouseExited

    private void userBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtnActionPerformed
        System.out.println("mouse was clicked");
        UsersFrm form = new UsersFrm();
    }//GEN-LAST:event_userBtnActionPerformed

    private void userBtn1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtn1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtn1MouseEntered

    private void userBtn1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtn1MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtn1MouseExited

    private void userBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtn1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtn1ActionPerformed

    private void userBtn2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtn2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtn2MouseEntered

    private void userBtn2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtn2MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtn2MouseExited

    private void userBtn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtn2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtn2ActionPerformed

    private void userBtn3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtn3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtn3MouseEntered

    private void userBtn3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtn3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtn3MouseExited

    private void userBtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtn3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userBtn3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton userBtn;
    private javax.swing.JButton userBtn1;
    private javax.swing.JButton userBtn2;
    private javax.swing.JButton userBtn3;
    // End of variables declaration//GEN-END:variables
}
