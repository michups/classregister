package com.michups.classregister.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by michups on 18.07.17.
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    private static final long serialVersionUID =1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = "teacher";
        String pass = "t3ach3r";

        String jdbcURL = "jdbc:mysql://localhost:3306/class_register_db?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";

        try{
            PrintWriter out = response.getWriter();

            out.println("Connected to db: "+ jdbcURL);

            Class.forName(driver);

            Connection myConn = DriverManager.getConnection(jdbcURL, user, pass);

            out.println("Success");

            myConn.close();

        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }
    }
}
