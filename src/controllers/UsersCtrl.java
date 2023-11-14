package controllers;

import helpers.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.User;
import models.UserType;

public class UsersCtrl {
    public UsersCtrl() {}
    
    public List<UserType> getUserTypes() {
        List<UserType> userTypes = new ArrayList<>();
        
        try {
            DatabaseConnection dbcn = new DatabaseConnection();
            Connection cn = dbcn.getConnection();
            
            String sql = "SELECT*FROM usertype";
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                UserType userType = new UserType();
                
                userType.setUserTypeId(rs.getInt("userTypeId"));
                userType.setUserTypeName(rs.getString("userTypeName"));
                userType.setAllowedBorrowedMaterials(rs.getInt("allowedBorrowedMaterials"));
                
                userTypes.add(userType);
            }
            
            cn.close();
            st.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los tipos de usuario. Por favor contacte con el administrador.");
            System.out.println(e.getMessage());
        }
        
        return userTypes;
    }
    
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        
        try {
            DatabaseConnection dbcn = new DatabaseConnection();
            Connection cn = dbcn.getConnection();
            
            String sql = "SELECT identificationCode, email, ut.userTypeName, phone FROM user u INNER JOIN userType ut ON u.userTypeId = ut.userTypeId;";
            Statement st = cn.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()) {
                User user = new User();
                
                user.setIdentificationCode(rs.getString("identificationCode"));
                user.setEmail(rs.getString("email"));
                user.setUserTypeName(rs.getString("userTypeName"));
                user.setPhone(rs.getString("phone"));
                
                users.add(user);
            }
            
            cn.close();
            st.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al obtener los usuarios. Por favor contacte con el administrador.");
            System.out.println(e.getMessage());
        }
        
        return users;
    }
    
    public boolean registerUser(User user) {
        boolean response = false;
        
        try {
            DatabaseConnection dbcn = new DatabaseConnection();
            Connection cn = dbcn.getConnection();
            
            String sql = "INSERT INTO user(identificationCode, password, email, userTypeId, hasToResetPassword, phone) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, user.getIdentificationCode());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getEmail());
            pst.setInt(4, user.getUserTypeId());
            pst.setBoolean(5, user.isHasToResetPassword());
            pst.setString(6, user.getPhone());
            
            if(!pst.execute()) response = true;
            
            cn.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un problema al crear el usuario. Por favor contacte con el administrador.");
            System.out.println(e.getMessage());
        }
        
        return response;
    }
}
