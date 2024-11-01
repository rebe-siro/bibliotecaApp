/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.biblioteca.model;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author Rebe
 */
public class Conexion {
    Connection con = null;

    String dbname = "BDLaboratorio";
    String url = "jdbc:postgresql://localhost:5432/";
    String user = "postgres";
    String password = "sistema";

    public Connection getConexion()
    {
        Connection con_obj=null;        
        try
        {
            con_obj= DriverManager.getConnection(url + dbname,user,password);
            if(con_obj!=null)
            {
                System.out.println("Connection established successfully !");
            }
            else
            {
                System.out.println("Connection failed !!");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return con_obj;
    }    
}
