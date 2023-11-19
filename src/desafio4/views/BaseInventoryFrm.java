package desafio4.views;

import controllers.InventoryCtrl;
import helpers.ApplicationContext;
import java.awt.BorderLayout;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Inventory;
import java.util.ArrayList;

public class BaseInventoryFrm extends javax.swing.JPanel {
    private JPanel containerPanel;
    private InventoryCtrl controller;
    private List<Inventory> inventory;
    private Inventory selectedInventory;
    
    public BaseInventoryFrm() {
        initComponents();
        
        containerPanel = ApplicationContext.getMainContainer();
        controller = new InventoryCtrl();
        
        initData();
        
        //makeTableReadOnly();
        
        noSelectedDataMode();
    }
    
    private void setContent(JPanel content) {
        containerPanel.removeAll();
        containerPanel.add(content, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
    }
    
    private void initData() {
        inventory = controller.getInventory();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Id");
        tableModel.addColumn("Código");
        tableModel.addColumn("Título");
        tableModel.addColumn("Tipo de material");
        tableModel.addColumn("Librería");
        
        for (Inventory inventory : inventory) {
            tableModel.addRow(new Object[]{inventory.getInventoryId(), inventory.getMaterialCode(), inventory.getTitle(), inventory.getMaterialTypeName(), inventory.getLibraryName()});
        }
        
        inventoryTbl.setModel(tableModel);
        
        inventoryTbl.setDefaultEditor(Object.class, null);
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
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        deleteBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        searchTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTbl = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel2.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 90, 40));

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
        jPanel2.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 40));

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
        jPanel2.add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 90, 40));

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
        jPanel2.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 90, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 620, 410, 60));

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
        jPanel3.add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 990, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(154, 168, 180));
        jLabel8.setText("Buscar");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1030, 110));

        inventoryTbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        inventoryTbl.setForeground(new java.awt.Color(51, 51, 51));
        inventoryTbl.setModel(new javax.swing.table.DefaultTableModel(
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
        inventoryTbl.setFocusable(false);
        inventoryTbl.setGridColor(new java.awt.Color(43, 111, 145));
        inventoryTbl.setSelectionBackground(new java.awt.Color(43, 111, 145));
        inventoryTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                inventoryTblMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(inventoryTbl);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 1030, 480));

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

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        InventoryFrm form = new InventoryFrm();
        setContent(form);
    }//GEN-LAST:event_addBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        InventoryFrm form = new InventoryFrm(selectedInventory);
        setContent(form);
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que deseas eliminar el elemento del inventario? Los cambios son irreversibles.", "Confirmación", JOptionPane.YES_NO_OPTION);
        
        if (response == JOptionPane.YES_OPTION) {
            boolean ok = controller.deleteInventory(selectedInventory.getInventoryId());
            
            if(!ok) return;
            
            JOptionPane.showMessageDialog(null, "El elemento fue eliminado del inventario exitosamente.");
            
            initData();
        
            noSelectedDataMode();
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        noSelectedDataMode();
    }//GEN-LAST:event_clearBtnActionPerformed

    private void searchTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTxtActionPerformed

    }//GEN-LAST:event_searchTxtActionPerformed

    private void searchTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTxtKeyReleased

    private void searchTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTxtKeyTyped

        DefaultTableModel model = (DefaultTableModel) inventoryTbl.getModel();
  
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<DefaultTableModel>(model);
        
        inventoryTbl.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter(searchTxt.getText()));
    }//GEN-LAST:event_searchTxtKeyTyped

    private void inventoryTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTblMouseClicked
        int modelRowIndex = inventoryTbl.convertRowIndexToModel(inventoryTbl.getSelectedRow());

        int id = (Integer) inventoryTbl.getModel().getValueAt(modelRowIndex, 0);
        for (Inventory item : inventory) {
            if (item.getInventoryId() == id) {
                selectedInventory = item;
                break;
            }
        }
        
        selectedDataMode();
    }//GEN-LAST:event_inventoryTblMouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        SelectionInventoryFrm form = new SelectionInventoryFrm();
        setContent(form);
    }//GEN-LAST:event_backBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JTable inventoryTbl;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
