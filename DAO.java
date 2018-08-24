package com.unodepiera.dao;
 
 
import com.unodepiera.utils.DbConnection;
import com.unodepiera.models.User;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
 
public class UserDaoImpl
{
    private DbConnection con;
 
    public UserDaoImpl(DbConnection con) {
        this.con = con;
    }
    
    public boolean insert(User user) 
    {
        try
        {
            String sql = "INSERT INTO users(username, password, email) VALUES (?,?,?)";
            PreparedStatement preparedStatement = con.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.executeUpdate();
            return true;         
        } 
        catch (SQLException e) 
        {
            System.out.println("Error insertando al usuario: " + e.getMessage());
            return false;
        }
    }
}