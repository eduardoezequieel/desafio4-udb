
package controllers;

import helpers.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.UserType;



public class PermisosCtrl {
    public PermisosCtrl(){}
    
    public List<UserType> getTwoUsergetTypes() {
        List<UserType> twoUserTypes = new ArrayList<>();
        
        try {
            DatabaseConnection dbcn = new DatabaseConnection();
            Connection cn = dbcn.getConnection();
            
            String sql = "SELECT userTypeName, allowedBorrowedMaterials FROM usertype WHERE userTypeName IN ('Profesor', 'Estudiante');";
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                UserType userType = new UserType();
                
                userType.setUserTypeName(rs.getString("userTypeName"));
                userType.setAllowedBorrowedMaterials(rs.getInt("allowedBorrowedMaterials"));
                
                twoUserTypes.add(userType);
            }
            
            cn.close();
            st.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los tipos de usuario. Por favor contacte con el administrador.");
            System.out.println(e.getMessage());
        }
        
        return twoUserTypes;
    }
    
    public class UserTypesUpdateCtrl {
    
    public UserTypesUpdateCtrl() {}
    
   
    public void updateAllowedBorrowedMaterials(String userTypeName, int newAllowedBorrowedMaterials) {
        try {
            DatabaseConnection dbcn = new DatabaseConnection();
            Connection cn = dbcn.getConnection();
            
           
            String sql = "UPDATE usertype SET allowedBorrowedMaterials = ? WHERE userTypeName = ?";
            
           
            try (PreparedStatement pst = cn.prepareStatement(sql)) {
                
                pst.setInt(1, newAllowedBorrowedMaterials);
                pst.setString(2, userTypeName);
                
                
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Actualización exitosa");
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo realizar la actualización");
                }
            }
            
            
            cn.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar los datos. Por favor, contacta al administrador.");
            System.out.println(e.getMessage());
        }
    }
}
    
    public void actualizarMaterialesPermitidos(String userTypeName, int nuevosMateriales) {
        try {
            DatabaseConnection dbcn = new DatabaseConnection();
            Connection cn = dbcn.getConnection();

            String sql = "UPDATE usertype SET allowedBorrowedMaterials = ? WHERE userTypeName = ?";
            PreparedStatement pstmt = cn.prepareStatement(sql);
            pstmt.setInt(1, nuevosMateriales);
            pstmt.setString(2, userTypeName);

            int filasActualizadas = pstmt.executeUpdate();

            if (filasActualizadas > 0) {
                JOptionPane.showMessageDialog(null, "Actualización exitosa.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo actualizar el registro.");
            }

            cn.close();
            pstmt.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al actualizar los materiales permitidos. Por favor, contacte con el administrador.");
            System.out.println(e.getMessage());
        }
    }

    
    
    
    
}
