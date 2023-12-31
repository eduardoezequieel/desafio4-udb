package desafio4.views;

import controllers.InventoryCtrl;
import controllers.LoanCtrl;
import helpers.ApplicationContext;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import models.Inventory;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import models.Loan;

public class LoanFrm extends javax.swing.JPanel {
    private InventoryCtrl controller;
    private LoanCtrl loanController;
    private List<Inventory> inventory;
    private List<Inventory> selectedItems = new ArrayList<>();
    
    public LoanFrm() {
        initComponents();
        
        controller = new InventoryCtrl();
        loanController = new LoanCtrl();
        
        initTable();
        
        ApplicationContext.setTitleValue("Prestamos | Libreria");
    }
    
    private void clearForm() {
        selectedItems.clear();
        
        initSelectedItemsTable();
    }
    
    private void initTable() {
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
    }
    
    private void initSelectedItemsTable() {
        DefaultTableModel tableModel = new DefaultTableModel();
        
        tableModel.addColumn("Id");
        tableModel.addColumn("Código");
        tableModel.addColumn("Título");
        tableModel.addColumn("Tipo de material");
        tableModel.addColumn("Librería");
        
        for (Inventory selectedItem : selectedItems) {
            tableModel.addRow(new Object[]{selectedItem.getInventoryId(), selectedItem.getMaterialCode(), selectedItem.getTitle(), selectedItem.getMaterialTypeName(), selectedItem.getLibraryName()});
        }
        
        selectedItemTbl.setModel(tableModel);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTbl = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        searchTxt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        selectedItemTbl = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        startDateDt = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        endDateDt = new com.toedter.calendar.JDateChooser();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 510, -1));

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
        jPanel3.add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 470, 40));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(154, 168, 180));
        jLabel8.setText("Buscar");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 510, 110));

        selectedItemTbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        selectedItemTbl.setForeground(new java.awt.Color(51, 51, 51));
        selectedItemTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        selectedItemTbl.setFocusable(false);
        selectedItemTbl.setGridColor(new java.awt.Color(43, 111, 145));
        selectedItemTbl.setSelectionBackground(new java.awt.Color(43, 111, 145));
        selectedItemTbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedItemTblMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(selectedItemTbl);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 480, 340));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(65, 167, 218));
        jLabel3.setText("Selecciona materiales para continuar.");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        addBtn.setBackground(new java.awt.Color(82, 190, 127));
        addBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Solicitar prestamo");
        addBtn.setBorder(null);
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 620, 140, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(154, 168, 180));
        jLabel14.setText("Inventario");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 160, -1, -1));

        startDateDt.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(startDateDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, 230, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(154, 168, 180));
        jLabel15.setText("Fecha de finalización");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 540, -1, -1));

        endDateDt.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(endDateDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 570, 240, 40));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(154, 168, 180));
        jLabel16.setText("Fecha de inicio");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(154, 168, 180));
        jLabel17.setText("Materiales escogidos");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void inventoryTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_inventoryTblMouseClicked
        int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de agregar este elemento? Se verificara su disponibilidad posteriormente.", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            int modelRowIndex = inventoryTbl.convertRowIndexToModel(inventoryTbl.getSelectedRow());

            int id = (Integer) inventoryTbl.getModel().getValueAt(modelRowIndex, 0);
            
            Inventory itemToBeAdded = null;
            
            for (Inventory item : inventory) {
                if (item.getInventoryId() == id) {
                    itemToBeAdded = item;
                }
            }
            
            for (Inventory selectedItem : selectedItems) {
                if (selectedItem.getInventoryId() == itemToBeAdded.getInventoryId()) {
                    JOptionPane.showMessageDialog(null, "Este elemento ya fue agregado previamente.");
                    return;
                }
            }
            
            selectedItems.add(itemToBeAdded);
            initSelectedItemsTable();
        }
    }//GEN-LAST:event_inventoryTblMouseClicked

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

    private void selectedItemTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectedItemTblMouseClicked
        int response = JOptionPane.showConfirmDialog(null, "¿Estás seguro de remover este elemento del prestamo?", "Confirmación", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            int modelRowIndex = selectedItemTbl.convertRowIndexToModel(selectedItemTbl.getSelectedRow());

            int id = (Integer) selectedItemTbl.getModel().getValueAt(modelRowIndex, 0);      
            
            for (int i = 0; i < selectedItems.size(); i++) {
                if (selectedItems.get(i).getInventoryId() == id) {
                    selectedItems.remove(i);
                    break;
                }
            }
            
            initSelectedItemsTable();
        }
    }//GEN-LAST:event_selectedItemTblMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        Date startDate = startDateDt.getDate();
        Date endDate = endDateDt.getDate();
        List<Integer> notAllowedMaterials = new ArrayList<>();
        
        try {
            if (endDate.before(startDate)) {
                JOptionPane.showMessageDialog(null, "Fechas invalidas.");
                return;
            }   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return;
        }
        
        if (selectedItems.size() == 0) {
            JOptionPane.showMessageDialog(null, "Debes agregar materiales.");
            return;
        }
        
        if (selectedItems.size() > ApplicationContext.getAllowedMaterials() && !ApplicationContext.getUser().getUserTypeName().equals("Administrador")) {
            JOptionPane.showMessageDialog(null, "Ha sobrepasado la cantidad de materiales permtidos para prestar ("+ApplicationContext.getAllowedMaterials()+").");
        }
        
        int hasPendingLoan = loanController.checkIfUserHasAPendingLoan(ApplicationContext.getUser().getIdentificationCode());
        
        if (hasPendingLoan == 1) {
            JOptionPane.showMessageDialog(null, "Usted posee un prestamo en mora, no tiene permitido realizar más.");
            return;
        } else if( hasPendingLoan == -1) {
            return;
        }
        
        for (Inventory selectedItem : selectedItems) {
            int response = loanController.materialIsAlreadyBorrowed(selectedItem.getInventoryId());
            
            if (response == -1) return;
            
            if (response == 1) {
                notAllowedMaterials.add(selectedItem.getInventoryId());
            }
        }
        
        if (notAllowedMaterials.size() > 0) {
            String ids = "";
            
            for (Integer notAllowedMaterial : notAllowedMaterials) {
                ids = ids + notAllowedMaterial + " ";
            }
            
            JOptionPane.showMessageDialog(null, "No se pudo realizar el prestamo ya que hay algunos materiales que no estan disponibles. "+ids);
            return;
        }
        
        int borrowedMaterials = loanController.getBorrowedMaterialsQuantity(ApplicationContext.getUser().getIdentificationCode());
        
        if (borrowedMaterials + selectedItems.size() > ApplicationContext.getAllowedMaterials() && !ApplicationContext.getUser().getUserTypeName().equals("Administrador")) {
            JOptionPane.showMessageDialog(null, "Ha sobrepasado el limite de materiales disponibles. " + "Prestamo actual: "+selectedItems.size()+ ", Otros prestamos:  "+borrowedMaterials);
            return;
        }
        
        Loan loan = new Loan();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        
        loan.setUserId(ApplicationContext.getUser().getIdentificationCode());
        loan.setStartDate(sdf.format(startDate));
        loan.setEndDate(sdf.format(endDate));
        
        boolean loanResponse = loanController.createLoan(loan);
        
        if(!loanResponse) return;
        
        int loanId = loanController.getLatestLoan();
        
        if (loanId == -1) {
            JOptionPane.showMessageDialog(null, "Sucedio un error al obtener el prestamo creado.");
            return;
        }
        
        for (Inventory selectedItem : selectedItems) {
            boolean ok = loanController.addItemToLoan(loanId, selectedItem.getInventoryId());
            
            if (!ok) return;
        }
        
        JOptionPane.showMessageDialog(null, "Prestamo creado correctamente, queda a la espera de la aprobación del administrador.");
        
        clearForm();
    }//GEN-LAST:event_addBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private com.toedter.calendar.JDateChooser endDateDt;
    private javax.swing.JTable inventoryTbl;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField searchTxt;
    private javax.swing.JTable selectedItemTbl;
    private com.toedter.calendar.JDateChooser startDateDt;
    // End of variables declaration//GEN-END:variables
}
