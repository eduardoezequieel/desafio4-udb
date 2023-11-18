package desafio4.views;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.User;

public class LayoutFrm extends javax.swing.JFrame {
    private Color pressedButtonColor = new Color(43, 111, 145);
    private Color defaultButtonColor = new Color(65,167,218);
    private User loggedUser;
    

    public LayoutFrm(User user) {
        initComponents();
        
        loggedUser = user;
        
        this.setLocationRelativeTo(null);
        
        WelcomeFrm form = new WelcomeFrm();
        setContent(form);
        
        userLbl.setText(loggedUser.getName());
        userTypeLbl.setText(loggedUser.getUserTypeName());
    }

    
    
    private void setContent(JPanel content) {
        containerPanel.removeAll();
        containerPanel.add(content, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sidebar = new javax.swing.JPanel();
        logoutBtn = new javax.swing.JButton();
        userBtn = new javax.swing.JButton();
        userTypeLbl = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        userLbl = new javax.swing.JLabel();
        inventoryBtn = new javax.swing.JButton();
        permissionBtn = new javax.swing.JButton();
        configBtn = new javax.swing.JButton();
        navbar = new javax.swing.JPanel();
        exitBtn = new javax.swing.JButton();
        containerPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sidebar.setBackground(new java.awt.Color(65, 167, 218));
        sidebar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutBtn.setBackground(new java.awt.Color(65, 167, 218));
        logoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logoutBtn.setForeground(new java.awt.Color(255, 255, 255));
        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desafio4/resources/logout-icon.png"))); // NOI18N
        logoutBtn.setText("   Cerrar sesión");
        logoutBtn.setBorder(null);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logoutBtn.setFocusable(false);
        logoutBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutBtnMouseExited(evt);
            }
        });
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });
        sidebar.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 660, 170, 40));

        userBtn.setBackground(new java.awt.Color(65, 167, 218));
        userBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userBtn.setForeground(new java.awt.Color(255, 255, 255));
        userBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desafio4/resources/user.png"))); // NOI18N
        userBtn.setText("   Usuarios");
        userBtn.setBorder(null);
        userBtn.setBorderPainted(false);
        userBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userBtn.setFocusable(false);
        userBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
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
        sidebar.add(userBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 170, 40));

        userTypeLbl.setFont(new java.awt.Font("Segoe UI Semibold", 1, 12)); // NOI18N
        userTypeLbl.setForeground(new java.awt.Color(255, 255, 255));
        userTypeLbl.setText("Administrador");
        sidebar.add(userTypeLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 590, 170, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Libreria");
        sidebar.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        userLbl.setFont(new java.awt.Font("Segoe UI Semibold", 1, 14)); // NOI18N
        userLbl.setForeground(new java.awt.Color(255, 255, 255));
        userLbl.setText("Eduardo López");
        sidebar.add(userLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 170, -1));

        inventoryBtn.setBackground(new java.awt.Color(65, 167, 218));
        inventoryBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        inventoryBtn.setForeground(new java.awt.Color(255, 255, 255));
        inventoryBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desafio4/resources/library-svgrepo-com.png"))); // NOI18N
        inventoryBtn.setText("   Inventario");
        inventoryBtn.setBorder(null);
        inventoryBtn.setBorderPainted(false);
        inventoryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        inventoryBtn.setFocusable(false);
        inventoryBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        inventoryBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                inventoryBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                inventoryBtnMouseExited(evt);
            }
        });
        inventoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryBtnActionPerformed(evt);
            }
        });
        sidebar.add(inventoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 170, 40));

        permissionBtn.setBackground(new java.awt.Color(65, 167, 218));
        permissionBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        permissionBtn.setForeground(new java.awt.Color(255, 255, 255));
        permissionBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desafio4/resources/share-2-svgrepo-com.png"))); // NOI18N
        permissionBtn.setText("   Prestamos");
        permissionBtn.setBorder(null);
        permissionBtn.setBorderPainted(false);
        permissionBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        permissionBtn.setFocusable(false);
        permissionBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        permissionBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                permissionBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                permissionBtnMouseExited(evt);
            }
        });
        permissionBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permissionBtnActionPerformed(evt);
            }
        });
        sidebar.add(permissionBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 170, 40));

        configBtn.setBackground(new java.awt.Color(65, 167, 218));
        configBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        configBtn.setForeground(new java.awt.Color(255, 255, 255));
        configBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/desafio4/resources/settings-svgrepo-com.png"))); // NOI18N
        configBtn.setText("   Configuración");
        configBtn.setBorder(null);
        configBtn.setBorderPainted(false);
        configBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        configBtn.setFocusable(false);
        configBtn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        configBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configBtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                configBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                configBtnMouseExited(evt);
            }
        });
        configBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                configBtnActionPerformed(evt);
            }
        });
        sidebar.add(configBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 620, 170, 40));

        getContentPane().add(sidebar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 720));

        navbar.setBackground(new java.awt.Color(62, 86, 97));
        navbar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exitBtn.setBackground(new java.awt.Color(255, 51, 51));
        exitBtn.setForeground(new java.awt.Color(255, 255, 255));
        exitBtn.setText("X");
        exitBtn.setBorder(null);
        exitBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        navbar.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 30, 30));

        getContentPane().add(navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1070, 30));

        containerPanel.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(containerPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 1070, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas salír del programa?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_exitBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        this.dispose();
        
        LoginFrm form = new LoginFrm();
        form.setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void inventoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inventoryBtnActionPerformed

    private void userBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtnMouseEntered
        userBtn.setBackground(pressedButtonColor);
    }//GEN-LAST:event_userBtnMouseEntered

    private void userBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userBtnMouseExited
        userBtn.setBackground(defaultButtonColor);
    }//GEN-LAST:event_userBtnMouseExited

    private void inventoryBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryBtnMouseEntered
        inventoryBtn.setBackground(pressedButtonColor);
    }//GEN-LAST:event_inventoryBtnMouseEntered

    private void inventoryBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryBtnMouseExited
        inventoryBtn.setBackground(defaultButtonColor);
    }//GEN-LAST:event_inventoryBtnMouseExited

    private void logoutBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseEntered
        logoutBtn.setBackground(pressedButtonColor);
    }//GEN-LAST:event_logoutBtnMouseEntered

    private void logoutBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseExited
        logoutBtn.setBackground(defaultButtonColor);
    }//GEN-LAST:event_logoutBtnMouseExited

    private void userBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userBtnActionPerformed
        System.out.println("mouse was clicked");
        UsersFrm form = new UsersFrm();
        setContent(form);
    }//GEN-LAST:event_userBtnActionPerformed

    private void permissionBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permissionBtnMouseEntered
        permissionBtn.setBackground(pressedButtonColor);
    }//GEN-LAST:event_permissionBtnMouseEntered

    private void permissionBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_permissionBtnMouseExited
        permissionBtn.setBackground(defaultButtonColor);
    }//GEN-LAST:event_permissionBtnMouseExited

    private void permissionBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permissionBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permissionBtnActionPerformed

    private void configBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configBtnMouseEntered
        configBtn.setBackground(pressedButtonColor);
    }//GEN-LAST:event_configBtnMouseEntered

    private void configBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configBtnMouseExited
        configBtn.setBackground(defaultButtonColor);
    }//GEN-LAST:event_configBtnMouseExited

    private void configBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_configBtnActionPerformed
        System.out.println("test");
    }//GEN-LAST:event_configBtnActionPerformed

    private void configBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configBtnMouseClicked
          SettingFrm form = new SettingFrm(); 
         setContent(form);
    }//GEN-LAST:event_configBtnMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton configBtn;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton inventoryBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel navbar;
    private javax.swing.JButton permissionBtn;
    private javax.swing.JPanel sidebar;
    private javax.swing.JButton userBtn;
    private javax.swing.JLabel userLbl;
    private javax.swing.JLabel userTypeLbl;
    // End of variables declaration//GEN-END:variables
}
