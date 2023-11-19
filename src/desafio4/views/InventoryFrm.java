package desafio4.views;

import controllers.InventoryCtrl;
import controllers.MaterialCtrl;
import helpers.ApplicationContext;
import helpers.Validators;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.Inventory;
import models.Library;
import models.Material;

public class InventoryFrm extends javax.swing.JPanel {
    private JPanel containerPanel;
    private String formMode;
    private InventoryCtrl controller;
    private MaterialCtrl materialController;
    private List<Material> materials;
    private List<Library> libraries;
    private Material selectedMaterial;
    private Inventory selectedItem;
    
    public InventoryFrm() {
        initComponents();
        
        controller = new InventoryCtrl();
        materialController = new MaterialCtrl();
        
        formMode = "create";
        
        containerPanel = ApplicationContext.getMainContainer();
        
        cardContainer.add(bookContainer, "Libro");
        cardContainer.add(magazineContainer, "Revista");
        
        bookContainer.setVisible(false);
        magazineContainer.setVisible(false);
        cardContainer.setVisible(false);
        
        initData();
    }
    
    public InventoryFrm(Inventory inventory) {
        initComponents();
        
        controller = new InventoryCtrl();
        materialController = new MaterialCtrl();
        
        selectedItem = controller.getInventoryItem(inventory.getInventoryId());
        
        formMode = "edit";
        
        containerPanel = ApplicationContext.getMainContainer();
        
        cardContainer.add(bookContainer, "Libro");
        cardContainer.add(magazineContainer, "Revista");
        
        bookContainer.setVisible(false);
        magazineContainer.setVisible(false);
        cardContainer.setVisible(false);
        
        initData();
        setData();
    }
    
    private void setContent(JPanel content) {
        containerPanel.removeAll();
        containerPanel.add(content, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
    }
    
    private void showCard(Container container, String cardName) {
        CardLayout cardLayout = (CardLayout) cardContainer.getLayout();
        cardLayout.show(container, cardName);
    }
    
    private void setData() {
        for (Material material : materials) {
            if (material.getCode().equals(selectedItem.getMaterialCode())) {
                materialCb.setSelectedItem(material.getTitle());
                materialCb.setEnabled(false);
                break;
            }
        }
        
        notesTxt.setText(selectedItem.getNotes());
        
        for (Library library : libraries) {
            if (library.getLibraryId() == selectedItem.getLibraryId()) {
                libraryCb.setSelectedItem(library.getLibraryName());
                break;
            }
        }
        
        issnTxt.setText(selectedItem.getIssn());
        isbnTxt.setText(selectedItem.getIsbn());
    }
    
    private void initData() {
        materials = materialController.getMaterials();
        libraries = controller.getLibraries();
        
        materialCb.removeAllItems();
        libraryCb.removeAllItems();
        
        libraryCb.addItem("Selecciona una opción");
        materialCb.addItem("Selecciona una opción");
        
        for (Material material : materials) {
            materialCb.addItem(material.getTitle());
        }
        
        for (Library library : libraries) {
            libraryCb.addItem(library.getLibraryName());
        }
    }
    
    private void createInventory() {
        String materialName = (String) materialCb.getSelectedItem();
        String libraryName = (String) libraryCb.getSelectedItem();
        String notes = notesTxt.getText().trim();
        String isbn = isbnTxt.getText();
        String issn = issnTxt.getText();
        
        if (materialName.equals("Selecciona una opción") || libraryName.equals("Selecciona una opción") || notes.length() == 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return;
        }
        
        Inventory item = new Inventory();
        
        for (Library library : libraries) {
            if (library.getLibraryName().equals(libraryName)) {
                item.setLibraryId(library.getLibraryId());
            }
            break;
        }
        
        for (Material material : materials) {
            if (material.getTitle().equals(materialName)) {
                item.setMaterialCode(material.getCode());
                break;
            }
        }
        
        item.setNotes(notes);
        
        switch(selectedMaterial.getMaterialTypeId()) {
            case 1: 
                if (isbn.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
                    return;
                }
                
                item.setIsbn(isbn);
                break;
            case 2: 
                if (isbn.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
                    return;
                }
                
                item.setIsbn(isbn);
                break;
            case 3: 
                if (issn.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
                    return;
                }
                
                item.setIssn(issn);
                break;
            default:
                cardContainer.setVisible(false);
                break;
        }
        
        boolean ok = controller.addItemToInventory(item);
        
        if(!ok) return;
        
        JOptionPane.showMessageDialog(null, "Se ha agregado el elemento al inventario correctamente.");
        
        BaseInventoryFrm form = new BaseInventoryFrm();
        setContent(form);
    }
    
    private void updateMaterial() {
        String libraryName = (String) libraryCb.getSelectedItem();
        String notes = notesTxt.getText().trim();
        String isbn = isbnTxt.getText();
        String issn = issnTxt.getText();
        
        System.out.println(isbn);
        System.out.println(issn);
        
        if (libraryName.equals("Selecciona una opción") || notes.length() == 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return;
        }
        
        Inventory item = new Inventory();
        
        for (Library library : libraries) {
            if (library.getLibraryName().equals(libraryName)) {
                item.setLibraryId(library.getLibraryId());
                break;
            }
            
        }
        
        item.setNotes(notes);
        item.setMaterialCode(selectedItem.getMaterialCode());
        item.setInventoryId(selectedItem.getInventoryId());
        
        System.out.println(selectedMaterial.getMaterialTypeId());
        
        switch(selectedMaterial.getMaterialTypeId()) {
            case 1: 
                if (isbn.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
                    return;
                }
                
                item.setIsbn(isbn);
                break;
            case 2: 
                if (isbn.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
                    return;
                }
                
                item.setIsbn(isbn);
                break;
            case 3: 
                if (issn.length() == 0) {
                    JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
                    return;
                }
                
                item.setIssn(issn);
                break;
            default:
                cardContainer.setVisible(false);
                break;
        }
        
        boolean ok = controller.updateItem(item);
        
        if(!ok) return;
        
        JOptionPane.showMessageDialog(null, "Se ha actualizado el elemento correctamente.");
        
        BaseInventoryFrm form = new BaseInventoryFrm();
        setContent(form);
    }
    
    private void handleSelectChange() {
        if (materialCb.getSelectedItem().equals(null)) {
            return;
        }
        
        String materialName = (String) materialCb.getSelectedItem();
        
        String code = "";
        
        for (Material material : materials) {
            if (material.getTitle().equals(materialName)) {
                code = material.getCode();
                break;
            }
        }
        
        selectedMaterial = materialController.getMaterial(code);
        
        switch(selectedMaterial.getMaterialTypeId()) {
            case 1: 
                cardContainer.setVisible(true);
                showCard(cardContainer, "Libro");
                break;
            case 2: 
                cardContainer.setVisible(true);
                showCard(cardContainer, "Libro");
                break;
            case 3: 
                cardContainer.setVisible(true);
                showCard(cardContainer, "Revista");
                break;
            default:
                cardContainer.setVisible(false);
                break;
        }
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
        backBtn = new javax.swing.JButton();
        saveBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        notesTxt = new javax.swing.JEditorPane();
        materialCb = new javax.swing.JComboBox<>();
        cardContainer = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        libraryCb = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        magazineContainer = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        issnTxt = new javax.swing.JFormattedTextField();
        bookContainer = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        isbnTxt = new javax.swing.JFormattedTextField();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 120, 40));

        saveBtn.setBackground(new java.awt.Color(82, 190, 127));
        saveBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        saveBtn.setForeground(new java.awt.Color(255, 255, 255));
        saveBtn.setText("Guardar cambios");
        saveBtn.setBorder(null);
        saveBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });
        jPanel1.add(saveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 630, 150, 40));

        jPanel4.setBackground(new java.awt.Color(245, 251, 248));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(154, 168, 180));
        jLabel7.setText("Notas");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        notesTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        notesTxt.setForeground(new java.awt.Color(51, 51, 51));
        notesTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                notesTxtKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(notesTxt);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 340, 220));

        materialCb.setBackground(new java.awt.Color(255, 255, 255));
        materialCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        materialCb.setForeground(new java.awt.Color(51, 51, 51));
        materialCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));
        materialCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 218)));
        materialCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialCbActionPerformed(evt);
            }
        });
        jPanel4.add(materialCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 340, 40));

        cardContainer.setBackground(new java.awt.Color(245, 251, 248));
        cardContainer.setLayout(new java.awt.CardLayout());
        jPanel4.add(cardContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 340, 250));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(154, 168, 180));
        jLabel9.setText("Libreria");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        libraryCb.setBackground(new java.awt.Color(255, 255, 255));
        libraryCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        libraryCb.setForeground(new java.awt.Color(51, 51, 51));
        libraryCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));
        libraryCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 218)));
        libraryCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                libraryCbActionPerformed(evt);
            }
        });
        jPanel4.add(libraryCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 340, 40));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(154, 168, 180));
        jLabel10.setText("Material");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 760, 370));

        magazineContainer.setBackground(new java.awt.Color(245, 251, 248));
        magazineContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(154, 168, 180));
        jLabel11.setText("ISSN");
        magazineContainer.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        issnTxt.setBackground(new java.awt.Color(255, 255, 255));
        issnTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 212, 218), 1, true));
        try {
            issnTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        magazineContainer.add(issnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 290, 40));

        jPanel1.add(magazineContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 290, 260));

        bookContainer.setBackground(new java.awt.Color(245, 251, 248));
        bookContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(154, 168, 180));
        jLabel8.setText("ISBN");
        bookContainer.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        isbnTxt.setBackground(new java.awt.Color(255, 255, 255));
        isbnTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 212, 218), 1, true));
        try {
            isbnTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###-#-####-#####-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        bookContainer.add(isbnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 290, 40));

        jPanel1.add(bookContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 520, 290, 260));

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        BaseInventoryFrm form = new BaseInventoryFrm();
        setContent(form);
    }//GEN-LAST:event_backBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if(formMode.equals("create")) {
            createInventory();
        } else {
            updateMaterial();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void notesTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_notesTxtKeyReleased
        String code = notesTxt.getText();
        boolean isOk = Validators.checkTextLength(code, 500);

        if(!isOk) {
            notesTxt.setText(code.substring(0, 500));
        }
    }//GEN-LAST:event_notesTxtKeyReleased

    private void materialCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialCbActionPerformed
        int value = materialCb.getSelectedIndex();
        
        if (value == 0 || value == -1) return;
        
        handleSelectChange();
    }//GEN-LAST:event_materialCbActionPerformed

    private void libraryCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_libraryCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_libraryCbActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel bookContainer;
    private javax.swing.JPanel cardContainer;
    private javax.swing.JFormattedTextField isbnTxt;
    private javax.swing.JFormattedTextField issnTxt;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> libraryCb;
    private javax.swing.JPanel magazineContainer;
    private javax.swing.JComboBox<String> materialCb;
    private javax.swing.JEditorPane notesTxt;
    private javax.swing.JButton saveBtn;
    // End of variables declaration//GEN-END:variables
}
