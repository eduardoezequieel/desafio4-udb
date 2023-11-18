package desafio4.views;

import helpers.ApplicationContext;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class SelectionInventoryFrm extends javax.swing.JPanel {
    private Color pressedButtonColor = new Color(43, 111, 145);
    private Color defaultButtonColor = new Color(65,167,218);
    private JPanel containerPanel;
    
    public SelectionInventoryFrm() {
        initComponents();
        
        containerPanel = ApplicationContext.getMainContainer();
    }
    
    private void setContent(JPanel content) {
        containerPanel.removeAll();
        containerPanel.add(content, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
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
        creatorBtn = new javax.swing.JButton();
        materialBtn = new javax.swing.JButton();
        inventoryBtn = new javax.swing.JButton();
        editorialBtn = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1070, 690));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        creatorBtn.setBackground(new java.awt.Color(65, 167, 218));
        creatorBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        creatorBtn.setForeground(new java.awt.Color(255, 255, 255));
        creatorBtn.setText("Creadores");
        creatorBtn.setBorder(null);
        creatorBtn.setBorderPainted(false);
        creatorBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        creatorBtn.setFocusable(false);
        creatorBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                creatorBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                creatorBtnMouseExited(evt);
            }
        });
        creatorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creatorBtnActionPerformed(evt);
            }
        });
        jPanel1.add(creatorBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 220, 100));

        materialBtn.setBackground(new java.awt.Color(65, 167, 218));
        materialBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        materialBtn.setForeground(new java.awt.Color(255, 255, 255));
        materialBtn.setText("Material base");
        materialBtn.setBorder(null);
        materialBtn.setBorderPainted(false);
        materialBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        materialBtn.setFocusable(false);
        materialBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                materialBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                materialBtnMouseExited(evt);
            }
        });
        materialBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialBtnActionPerformed(evt);
            }
        });
        jPanel1.add(materialBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 220, 100));

        inventoryBtn.setBackground(new java.awt.Color(65, 167, 218));
        inventoryBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inventoryBtn.setForeground(new java.awt.Color(255, 255, 255));
        inventoryBtn.setText("Inventario");
        inventoryBtn.setBorder(null);
        inventoryBtn.setBorderPainted(false);
        inventoryBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        inventoryBtn.setFocusable(false);
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
        jPanel1.add(inventoryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 220, 220, 100));

        editorialBtn.setBackground(new java.awt.Color(65, 167, 218));
        editorialBtn.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        editorialBtn.setForeground(new java.awt.Color(255, 255, 255));
        editorialBtn.setText("Editoriales");
        editorialBtn.setBorder(null);
        editorialBtn.setBorderPainted(false);
        editorialBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editorialBtn.setFocusable(false);
        editorialBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editorialBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editorialBtnMouseExited(evt);
            }
        });
        editorialBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorialBtnActionPerformed(evt);
            }
        });
        jPanel1.add(editorialBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 220, 100));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 690));
    }// </editor-fold>//GEN-END:initComponents

    private void creatorBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creatorBtnMouseEntered
        creatorBtn.setBackground(pressedButtonColor);
    }//GEN-LAST:event_creatorBtnMouseEntered

    private void creatorBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creatorBtnMouseExited
        creatorBtn.setBackground(defaultButtonColor);
    }//GEN-LAST:event_creatorBtnMouseExited

    private void creatorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creatorBtnActionPerformed
        CreatorFrm form = new CreatorFrm();
        setContent(form);
    }//GEN-LAST:event_creatorBtnActionPerformed

    private void materialBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialBtnMouseEntered
        materialBtn.setBackground(pressedButtonColor);
    }//GEN-LAST:event_materialBtnMouseEntered

    private void materialBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_materialBtnMouseExited
        materialBtn.setBackground(defaultButtonColor);
    }//GEN-LAST:event_materialBtnMouseExited

    private void materialBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_materialBtnActionPerformed

    private void inventoryBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryBtnMouseEntered
        inventoryBtn.setBackground(pressedButtonColor);
    }//GEN-LAST:event_inventoryBtnMouseEntered

    private void inventoryBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryBtnMouseExited
        inventoryBtn.setBackground(defaultButtonColor);
    }//GEN-LAST:event_inventoryBtnMouseExited

    private void inventoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inventoryBtnActionPerformed

    private void editorialBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editorialBtnMouseEntered
        editorialBtn.setBackground(pressedButtonColor);
    }//GEN-LAST:event_editorialBtnMouseEntered

    private void editorialBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editorialBtnMouseExited
        editorialBtn.setBackground(defaultButtonColor);
    }//GEN-LAST:event_editorialBtnMouseExited

    private void editorialBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorialBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editorialBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton creatorBtn;
    private javax.swing.JButton editorialBtn;
    private javax.swing.JButton inventoryBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton materialBtn;
    // End of variables declaration//GEN-END:variables
}
