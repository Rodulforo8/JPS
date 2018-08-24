package com.unodepiera.controllers;
 
import com.unodepiera.dao.UserDaoImpl;
import com.unodepiera.models.User;
import com.unodepiera.utils.DbConnection;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
 
@WebServlet(name = "Registro", urlPatterns = {"/register"})
public class Registro extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        RequestDispatcher rd = request.getRequestDispatcher("/registro.jsp");
        rd.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //TODO implementar validación del formulario
         
        DbConnection con = new DbConnection();
        UserDaoImpl userDaoImpl = new UserDaoImpl(con);
         
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
         
        boolean status = userDaoImpl.insert(user);
         
        if(status)
        {
            System.out.println("Usuario registrado");
        }
        else 
        {
            System.out.println("Usuario no registrado");
        }
    }  
}

https://www.uno-de-piera.com/registro-de-usuarios-con-java-servlet/