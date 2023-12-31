package desafio4.views;

import controllers.CreatorCtrl;
import controllers.EditorialCtrl;
import helpers.ApplicationContext;
import helpers.Validators;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Creator;
import models.Editorial;

public class EditorialFrm extends javax.swing.JPanel {
    private JPanel containerPanel;
    private EditorialCtrl controller;
    private List<Editorial> editorials;
    private Editorial selectedEditorial;
    
    public EditorialFrm() {
        initComponents();
        
        containerPanel = ApplicationContext.getMainContainer();
        controller = new EditorialCtrl();
        
        
        initData();
        initTable();
        
        noSelectedDataMode();
    }
    
    private void setContent(JPanel content) {
        containerPanel.removeAll();
        containerPanel.add(content, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
    }
    
    public void noSelectedDataMode() {
        addBtn.setEnabled(true);
        
        updateBtn.setEnabled(false);
        deleteBtn.setEnabled(false);
    }
    
    public void selectedDataMode() {
        addBtn.setEnabled(false);
        
        updateBtn.setEnabled(true);
        deleteBtn.setEnabled(true);
    }
    
    public void clearFields() {
        Validators.clearTextField(nameTxt);
        
        noSelectedDataMode();
    }
    
    public void initData() {
        editorials = controller.getEditorials();
    }
    
    
    public void initTable() {        
        DefaultTableModel tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Id");
        tableModel.addColumn("Nombre de la editorial");
        
        for (int i = 0; i < editorials.size(); i++) {
            Editorial editorial = editorials.get(i);
            tableModel.addRow(new Object[]{editorial.getEditorialId(), editorial.getEditorialName()});
        }
        
        editorialTbl.setModel(tableModel);
        editorialTbl.setDefaultEditor(Object.class, null);

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
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        nameTxt = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        searchTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        editorialTbl = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(245, 251, 248));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(154, 168, 180));
        jLabel7.setText("Nombre");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        nameTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        nameTxt.setForeground(new java.awt.Color(51, 51, 51));
        nameTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 212, 218), 1, true));
        nameTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTxtActionPerformed(evt);
            }
        });
        nameTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nameTxtKeyReleased(evt);
            }
        });
        jPanel4.add(nameTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 340, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 380, 140));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addBtn.setBackground(new java.awt.Color(82, 190, 127));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Agregar");
        addBtn.setBorder(null);
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel2.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 90, 40));

        updateBtn.setBackground(new java.awt.Color(82, 190, 127));
        updateBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Actualizar");
        updateBtn.setBorder(null);
        updateBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        jPanel2.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 90, 40));

        clearBtn.setBackground(new java.awt.Color(82, 190, 127));
        clearBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        clearBtn.setForeground(new java.awt.Color(255, 255, 255));
        clearBtn.setText("Limpiar");
        clearBtn.setBorder(null);
        clearBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });
        jPanel2.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 90, 40));

        deleteBtn.setBackground(new java.awt.Color(82, 190, 127));
        deleteBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(255, 255, 255));
        deleteBtn.setText("Eliminar");
        deleteBtn.setBorder(null);
        deleteBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });
        jPanel2.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 90, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 350, 190, 130));

        jPanel3.setBackground(new java.awt.Color(245, 251, 248));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        searchTxt.setForeground(new java.awt.Color(51, 51, 51));
        searchTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 212, 218), 1, true));
        searchTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTxtActionPerformed(evt);
            }
        });
        searchTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchTxtKeyTyped(evt);
            }
        });
        jPanel3.add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 580, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(154, 168, 180));
        jLabel8.setText("Buscar");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 620, 110));

        editorialTbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        editorialTbl.setForeground(new java.awt.Color(51, 51, 51));
        editorialTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        editorialTbl.setFocusable(false);
        editorialTbl.setGridColor(new java.awt.Color(43, 111, 145));
        editorialTbl.setSelectionBackground(new java.awt.Color(43, 111, 145));
        editorialTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editorialTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(editorialTbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 620, 540));

        backBtn.setBackground(new java.awt.Color(82, 190, 127));
        backBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Regresar");
        backBtn.setBorder(null);
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, 90, 40));

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void nameTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTxtActionPerformed

    private void nameTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameTxtKeyReleased
        String name = nameTxt.getText();
        boolean isOk = Validators.checkTextLength(name, 50);

        if(!isOk) {
            nameTxt.setText(name.substring(0, 50));
        }
    }//GEN-LAST:event_nameTxtKeyReleased

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String name = nameTxt.getText().trim();
        
        if (name.length() == 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return;
        }
        
        boolean ok = controller.addEditorial(name);
        
        if (!ok) return;
        
        JOptionPane.showMessageDialog(null, "Registro creado correctamente.");
        initData();
        initTable();
        clearFields();
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
       String name = nameTxt.getText().trim();
        
        if (name.length() == 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return;
        }
        
        boolean ok = controller.updateCreator(name, selectedEditorial.getEditorialId());
        
        if (!ok) return;
        
        JOptionPane.showMessageDialog(null, "Registro actualizado correctamente.");
        initData();
        initTable();
        clearFields();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el registro? Los cambios son irreversibles.", "Confirmación", JOptionPane.YES_NO_OPTION);
        
        if (response == JOptionPane.YES_OPTION) {
            boolean ok = controller.deleteCreator(selectedEditorial.getEditorialId());
            
            if(!ok) return;
            
            JOptionPane.showMessageDialog(null, "El registro fue eliminado exitosamente.");
            
            initData();
            initTable();
            clearFields();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        clearFields();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed

    }//GEN-LAST:event_searchTxtActionPerformed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtKeyReleased

    private void searchTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyTyped
        DefaultTableModel model = (DefaultTableModel) editorialTbl.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(model);
        
        editorialTbl.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(searchTxt.getText()));
    }//GEN-LAST:event_searchTxtKeyTyped

    private void editorialTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editorialTblMouseClicked
        int modelRowIndex = editorialTbl.convertRowIndexToModel(editorialTbl.getSelectedRow());
        int id = Integer.parseInt(editorialTbl.getModel().getValueAt(modelRowIndex, 0).toString());
        
        for (int i = 0; i < editorials.size(); i++) {
            if (editorials.get(i).getEditorialId()== id) {
                selectedEditorial = editorials.get(i);
                break;
            }
        }
        
        nameTxt.setText(selectedEditorial.getEditorialName());
        
        selectedDataMode();
    }//GEN-LAST:event_editorialTblMouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        SelectionInventoryFrm form = new SelectionInventoryFrm();
        setContent(form);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTable editorialTbl;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTxt;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
