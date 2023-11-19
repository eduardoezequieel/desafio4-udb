package desafio4.views;

import controllers.CreatorCtrl;
import controllers.EditorialCtrl;
import controllers.MaterialCtrl;
import helpers.ApplicationContext;
import helpers.Validators;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import models.Creator;
import models.Editorial;
import models.Material;
import models.MaterialType;

public class MaterialFrm extends javax.swing.JPanel {
    private JPanel containerPanel;
    private MaterialCtrl controller;
    private EditorialCtrl editorialController;
    private CreatorCtrl creatorController;
    private List<MaterialType> materialTypes;
    private List<JPanel> forms = new ArrayList<>();
    private List<Editorial> editorials;
    private List<Creator> creators;
    private String formMode;
    private Material selectedMaterial;
    
    public MaterialFrm() {
        initComponents();
        
        formMode = "create";
        
        Validators.allowNumbers(songNumberTxt, 3);
        
        containerPanel = ApplicationContext.getMainContainer();
        controller = new MaterialCtrl();
        editorialController = new EditorialCtrl();
        creatorController = new CreatorCtrl();
        
        cardContainer.setVisible(false);
       
        cardContainer.add(bookContainer, "Libro");
        cardContainer.add(magazineContainer, "Revista");
        cardContainer.add(cdContainer, "CD");
        
        initData();
        
        addForms();
        
        initEditorialSelects();
        initCreatorSelects();
    }
    
    public MaterialFrm(Material material) {
        initComponents();
        
        formMode = "edit";
        
        Validators.allowNumbers(songNumberTxt, 3);
        
        materialTypesCb.setEnabled(false);
        
        containerPanel = ApplicationContext.getMainContainer();
        controller = new MaterialCtrl();
        editorialController = new EditorialCtrl();
        creatorController = new CreatorCtrl();
        
        cardContainer.setVisible(false);
       
        cardContainer.add(bookContainer, "Libro");
        cardContainer.add(magazineContainer, "Revista");
        cardContainer.add(cdContainer, "CD");
        
        initData();
        
        addForms();
        
        initEditorialSelects();
        initCreatorSelects();
        
        selectedMaterial = controller.getMaterial(material.getCode());
        
        initFormUpdate();
    }
    
    private void addForms() {
        forms.add(bookContainer);
        forms.add(magazineContainer);
        forms.add(cdContainer);
        
        for (JPanel form : forms) {
            form.setVisible(false);
        }
    }
    
    private void initFormUpdate() {
        titleTxt.setText(selectedMaterial.getTitle());
        descriptionTxt.setText(selectedMaterial.getDescription());
        
        for (MaterialType materialType : materialTypes) {
            if (materialType.getMaterialTypeId() == selectedMaterial.getMaterialTypeId()) {
                materialTypesCb.setSelectedItem(materialType.getMaterialTypeName());
            }
        }
        
        switch(selectedMaterial.getMaterialTypeId()) {
            case 1: 
                for (Creator creator : creators) {
                    if (creator.getCreatorId() == selectedMaterial.getCreatorId()) {
                        creatorCb.setSelectedItem(creator.getCreatorName());
                        break;
                    }
                }
                
                for (Editorial editorial : editorials) {
                    if (editorial.getEditorialId()== selectedMaterial.getEditorialId()) {
                        editorialBookCb.setSelectedItem(editorial.getEditorialName());
                        break;
                    }
                }
                
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(selectedMaterial.getPublishDate());

                    publishBookDt.setDate(date);
                } catch(ParseException e) {
                    JOptionPane.showMessageDialog(null, "Sucedio un error.");
                }
                break;
            case 2:
                for (Creator creator : creators) {
                    if (creator.getCreatorId() == selectedMaterial.getCreatorId()) {
                        creatorCb.setSelectedItem(creator.getCreatorName());
                        break;
                    }
                }
                
                for (Editorial editorial : editorials) {
                    if (editorial.getEditorialId()== selectedMaterial.getEditorialId()) {
                        editorialBookCb.setSelectedItem(editorial.getEditorialName());
                        break;
                    }
                }
                
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(selectedMaterial.getPublishDate());

                    publishBookDt.setDate(date);
                } catch(ParseException e) {
                    JOptionPane.showMessageDialog(null, "Sucedio un error.");
                }
                
                break;
                
            case 3: 
                for (Editorial editorial : editorials) {
                    if (editorial.getEditorialId()== selectedMaterial.getEditorialId()) {
                        editorialMagazineCb.setSelectedItem(editorial.getEditorialName());
                        break;
                    }
                }
                
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = sdf.parse(selectedMaterial.getPublishDate());

                    publishMagazineDt.setDate(date);
                } catch(ParseException e) {
                    JOptionPane.showMessageDialog(null, "Sucedio un error.");
                }
                break;
            case 4:
                durationTxt.setText(selectedMaterial.getDuration());
                songNumberTxt.setText(String.valueOf(selectedMaterial.getSongNumber()));
                break;
            default: 
                return;
        }
    }
    
    private void initEditorialSelects() {
        editorials = editorialController.getEditorials();
        
        editorialBookCb.removeAllItems();
        editorialMagazineCb.removeAllItems();
        
        editorialBookCb.addItem("Selecciona una opción");
        editorialMagazineCb.addItem("Selecciona una opción");
        
        for (Editorial editorial : editorials) {
            editorialBookCb.addItem(editorial.getEditorialName());
            editorialMagazineCb.addItem(editorial.getEditorialName());
        }
        
        
    }
    
    private void initCreatorSelects() {
        creators = creatorController.getCreators();
        
        creatorCb.removeAllItems();
        creatorCb.addItem("Selecciona una opción");
        
        for (Creator creator : creators) {
            creatorCb.addItem(creator.getCreatorName());
        }
    }
    
    private void handleSelectChange() {
        if(materialTypesCb.getSelectedItem() == null) return;
        
        String value = (String) materialTypesCb.getSelectedItem();
        
        switch(value) {
            case "Libro":
                cardContainer.setVisible(true);
                showCard(cardContainer, "Libro");
                break;
            case "Obra":
               cardContainer.setVisible(true);
               showCard(cardContainer, "Libro");
               break;
            case "Revista":
               cardContainer.setVisible(true);
               showCard(cardContainer, "Revista");
               break;
            case "CD":
               cardContainer.setVisible(true);
               showCard(cardContainer, "CD");
               break;
            default:
                cardContainer.setVisible(false);
                break;
        }
    }
    
    private void setContent(JPanel content) {
        containerPanel.removeAll();
        containerPanel.add(content, BorderLayout.CENTER);
        containerPanel.revalidate();
        containerPanel.repaint();
    }
    
    public void initData() {
        materialTypes = controller.getMaterialTypes();
        
        materialTypesCb.removeAllItems();
        
        materialTypesCb.addItem("Selecciona una opción");
        
        for (int i = 0; i < materialTypes.size(); i++) {
            materialTypesCb.addItem(materialTypes.get(i).getMaterialTypeName());
        }
        
        
    }
    
    private void showCard(Container container, String cardName) {
        CardLayout cardLayout = (CardLayout) cardContainer.getLayout();
        cardLayout.show(container, cardName);
    }
    
    private Material validateBooks(Material material) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
        String author = (String) creatorCb.getSelectedItem();
        String editorial = (String) editorialBookCb.getSelectedItem();
        String publishDate;

        try {
            publishDate = sdf.format(publishBookDt.getDate());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debes de escoger una fecha de publicación");
            return null;
        }

        System.out.println(publishDate);

        if (author.equals("Selecciona una opción") || editorial.equals("Selecciona una opción")) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return null;
        }

        int creatorId = -1;
        int editorialId = -1;

        for (Creator creator : creators) {
            if (creator.getCreatorName().equals(author)) {
                creatorId = creator.getCreatorId();
                break;
            }
        }

        for (Editorial editorialObj : editorials) {
            if (editorialObj.getEditorialName().equals(editorial)) {
                editorialId = editorialObj.getEditorialId();
                break;
            }
        }

        if (creatorId == -1 || editorialId == -1) {
            JOptionPane.showMessageDialog(null, "Sucedio un error al crear el material. Contacta con el administrador.");
            return null;
        }

        material.setCreatorId(creatorId);
        material.setEditorialId(editorialId);
        material.setPublishDate(publishDate);
        
        return material;
    }
    
    private Material validateMagazines(Material material) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                
        String editorial = (String) editorialMagazineCb.getSelectedItem();
        String publishDate;

        try {
            publishDate = sdf.format(publishMagazineDt.getDate());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Debes de escoger una fecha de publicación");
            return null;
        }

        if (editorial.equals("Selecciona una opción")) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return null;
        }

        int editorialId = -1;

        for (Editorial editorialObj : editorials) {
            if (editorialObj.getEditorialName().equals(editorial)) {
                editorialId = editorialObj.getEditorialId();
                break;
            }
        }

        if (editorialId == -1) {
            JOptionPane.showMessageDialog(null, "Sucedio un error al crear el material. Contacta con el administrador.");
            return null;
        }

        material.setEditorialId(editorialId);
        material.setPublishDate(publishDate);
        
        return material;
    }
    
    private Material validateCD(Material material) {
                
        String duration = durationTxt.getText().trim();
        String songNumber = songNumberTxt.getText();

        if (duration.length() == 0 || songNumber.length() == 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return null;
        }

        material.setDuration(duration);
        material.setSongNumber(Integer.parseInt(songNumber));
        
        return material;
    }
    
    private void createMaterial() {
        String title = titleTxt.getText().trim();
        String description = descriptionTxt.getText().trim();
        String materialTypeName = (String) materialTypesCb.getSelectedItem();
        
        if (title.length() == 0 || description.length() == 0 || materialTypeName.equals("Selecciona una opción")) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return;
        }
        
        int materialTypeId = -1;
        
        for (MaterialType materialType : materialTypes) {
            if (materialType.getMaterialTypeName().equals(materialTypeName)) {
                materialTypeId = materialType.getMaterialTypeId();
                break;
            }
        }
        
        if (materialTypeId == -1) {
            JOptionPane.showMessageDialog(null, "El tipo de material seleccionado no fue encontrado");
            return;
        }
        
        Material material = new Material();
        
        material.setTitle(title);
        material.setDescription(description);
        material.setMaterialTypeId(materialTypeId);
        
        switch(materialTypeName) {
            case "Libro":
                material = validateBooks(material);
                break;
            case "Obra": 
                material = validateBooks(material);
                break;
            case "Revista": 
                material = validateMagazines(material);
                break;
            case "CD": 
                material = validateCD(material);
                break;
            default:
                break;
        }
        
        if (material == null) return;
        
        boolean ok = controller.createMaterial(material);
        
        if(!ok) return;
        
        JOptionPane.showMessageDialog(null, "El material fue creado correctamente.");
        
        BaseMaterialFrm form = new BaseMaterialFrm();
        setContent(form);
    }
    
    private void updateMaterial() {
        String title = titleTxt.getText().trim();
        String description = descriptionTxt.getText().trim();
        String materialTypeName = (String) materialTypesCb.getSelectedItem();
        
        if (title.length() == 0 || description.length() == 0) {
            JOptionPane.showMessageDialog(null, "No se permiten campos vacios.");
            return;
        }
        
        Material material = new Material();
        
        material.setCode(selectedMaterial.getCode());
        material.setTitle(title);
        material.setDescription(description);
        material.setMaterialTypeId(selectedMaterial.getMaterialTypeId());
        
        switch(materialTypeName) {
            case "Libro":
                material = validateBooks(material);
                break;
            case "Obra": 
                material = validateBooks(material);
                break;
            case "Revista": 
                material = validateMagazines(material);
                break;
            case "CD": 
                material = validateCD(material);
                break;
            default:
                break;
        }
        
        if (material == null) return;
        
        boolean ok = controller.updateMaterial(material);
        
        if(!ok) return;
        
        JOptionPane.showMessageDialog(null, "El material fue actualizado correctamente.");
        
        BaseMaterialFrm form = new BaseMaterialFrm();
        setContent(form);
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
        titleTxt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionTxt = new javax.swing.JEditorPane();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        materialTypesCb = new javax.swing.JComboBox<>();
        cardContainer = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        cdContainer = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        songNumberTxt = new javax.swing.JTextField();
        durationTxt = new javax.swing.JFormattedTextField();
        magazineContainer = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        editorialMagazineCb = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        publishMagazineDt = new com.toedter.calendar.JDateChooser();
        bookContainer = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        creatorCb = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        editorialBookCb = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        publishBookDt = new com.toedter.calendar.JDateChooser();
        saveBtn = new javax.swing.JButton();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(245, 251, 248));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(154, 168, 180));
        jLabel7.setText("Descripción");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        titleTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(51, 51, 51));
        titleTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 212, 218), 1, true));
        titleTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleTxtActionPerformed(evt);
            }
        });
        titleTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                titleTxtKeyReleased(evt);
            }
        });
        jPanel4.add(titleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 340, 40));

        descriptionTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        descriptionTxt.setForeground(new java.awt.Color(51, 51, 51));
        descriptionTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descriptionTxtKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(descriptionTxt);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 340, 220));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(154, 168, 180));
        jLabel8.setText("Tipo de material");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(154, 168, 180));
        jLabel9.setText("Título");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        materialTypesCb.setBackground(new java.awt.Color(255, 255, 255));
        materialTypesCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        materialTypesCb.setForeground(new java.awt.Color(51, 51, 51));
        materialTypesCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));
        materialTypesCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 218)));
        materialTypesCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materialTypesCbActionPerformed(evt);
            }
        });
        jPanel4.add(materialTypesCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 460, 40));

        cardContainer.setBackground(new java.awt.Color(245, 251, 248));
        cardContainer.setLayout(new java.awt.CardLayout());
        jPanel4.add(cardContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 460, 270));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 890, 370));

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

        cdContainer.setBackground(new java.awt.Color(245, 251, 248));
        cdContainer.setToolTipText("");
        cdContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(154, 168, 180));
        jLabel19.setText("Número de canciones");
        cdContainer.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(154, 168, 180));
        jLabel20.setText("Duración");
        cdContainer.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        songNumberTxt.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        songNumberTxt.setForeground(new java.awt.Color(51, 51, 51));
        songNumberTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 212, 218), 1, true));
        songNumberTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                songNumberTxtActionPerformed(evt);
            }
        });
        songNumberTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                songNumberTxtKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                songNumberTxtKeyTyped(evt);
            }
        });
        cdContainer.add(songNumberTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 460, 40));

        durationTxt.setBackground(new java.awt.Color(255, 255, 255));
        durationTxt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(200, 212, 218), 1, true));
        try {
            durationTxt.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        cdContainer.add(durationTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 460, 40));

        jPanel1.add(cdContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 470, 310));

        magazineContainer.setBackground(new java.awt.Color(245, 251, 248));
        magazineContainer.setToolTipText("");
        magazineContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(154, 168, 180));
        jLabel17.setText("Fecha de publicación");
        magazineContainer.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        editorialMagazineCb.setBackground(new java.awt.Color(255, 255, 255));
        editorialMagazineCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        editorialMagazineCb.setForeground(new java.awt.Color(51, 51, 51));
        editorialMagazineCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));
        editorialMagazineCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 218)));
        editorialMagazineCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorialMagazineCbActionPerformed(evt);
            }
        });
        magazineContainer.add(editorialMagazineCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 460, 40));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(154, 168, 180));
        jLabel18.setText("Editorial");
        magazineContainer.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        publishMagazineDt.setDateFormatString("yyyy-MM-dd");
        magazineContainer.add(publishMagazineDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 460, 40));

        jPanel1.add(magazineContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 470, 310));

        bookContainer.setBackground(new java.awt.Color(245, 251, 248));
        bookContainer.setToolTipText("");
        bookContainer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(154, 168, 180));
        jLabel13.setText("Autor");
        bookContainer.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        creatorCb.setBackground(new java.awt.Color(255, 255, 255));
        creatorCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        creatorCb.setForeground(new java.awt.Color(51, 51, 51));
        creatorCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));
        creatorCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 218)));
        creatorCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creatorCbActionPerformed(evt);
            }
        });
        bookContainer.add(creatorCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 460, 40));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(154, 168, 180));
        jLabel14.setText("Fecha de publicación");
        bookContainer.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, -1, -1));

        editorialBookCb.setBackground(new java.awt.Color(255, 255, 255));
        editorialBookCb.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        editorialBookCb.setForeground(new java.awt.Color(51, 51, 51));
        editorialBookCb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1" }));
        editorialBookCb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 212, 218)));
        editorialBookCb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editorialBookCbActionPerformed(evt);
            }
        });
        bookContainer.add(editorialBookCb, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 460, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(154, 168, 180));
        jLabel15.setText("Editorial");
        bookContainer.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        publishBookDt.setDateFormatString("yyyy-MM-dd");
        bookContainer.add(publishBookDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 460, 40));

        jPanel1.add(bookContainer, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 560, 470, 310));

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

        add(jPanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        BaseMaterialFrm form = new BaseMaterialFrm();
        setContent(form);
    }//GEN-LAST:event_backBtnActionPerformed

    private void titleTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleTxtActionPerformed

    private void titleTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleTxtKeyReleased
        String code = titleTxt.getText();
        boolean isOk = Validators.checkTextLength(code, 100);
        
        if(!isOk) {
            titleTxt.setText(code.substring(0, 100));
        }
    }//GEN-LAST:event_titleTxtKeyReleased

    private void materialTypesCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materialTypesCbActionPerformed
        handleSelectChange();
    }//GEN-LAST:event_materialTypesCbActionPerformed

    private void creatorCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creatorCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creatorCbActionPerformed

    private void editorialBookCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorialBookCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editorialBookCbActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        if(formMode.equals("create")) {
            createMaterial();
        } else {
            updateMaterial();
        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void editorialMagazineCbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editorialMagazineCbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_editorialMagazineCbActionPerformed

    private void songNumberTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_songNumberTxtActionPerformed

    }//GEN-LAST:event_songNumberTxtActionPerformed

    private void songNumberTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_songNumberTxtKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_songNumberTxtKeyReleased

    private void songNumberTxtKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_songNumberTxtKeyTyped
        
    }//GEN-LAST:event_songNumberTxtKeyTyped

    private void descriptionTxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionTxtKeyReleased
        String code = descriptionTxt.getText();
        boolean isOk = Validators.checkTextLength(code, 500);
        
        if(!isOk) {
            descriptionTxt.setText(code.substring(0, 500));
        }
    }//GEN-LAST:event_descriptionTxtKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JPanel bookContainer;
    private javax.swing.JPanel cardContainer;
    private javax.swing.JPanel cdContainer;
    private javax.swing.JComboBox<String> creatorCb;
    private javax.swing.JEditorPane descriptionTxt;
    private javax.swing.JFormattedTextField durationTxt;
    private javax.swing.JComboBox<String> editorialBookCb;
    private javax.swing.JComboBox<String> editorialMagazineCb;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel magazineContainer;
    private javax.swing.JComboBox<String> materialTypesCb;
    private com.toedter.calendar.JDateChooser publishBookDt;
    private com.toedter.calendar.JDateChooser publishMagazineDt;
    private javax.swing.JButton saveBtn;
    private javax.swing.JTextField songNumberTxt;
    private javax.swing.JTextField titleTxt;
    // End of variables declaration//GEN-END:variables
}
