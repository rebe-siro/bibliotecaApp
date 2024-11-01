/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.biblioteca.model;

/**
 *
 * @author Rebe
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasRecurso extends Conexion {
    
    public boolean register(Resources reso) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO recurso (code, title, author, type, status) VALUES(?,?,?,?,?)";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, reso.getCode());
            ps.setString(2, reso.getTitle());
            ps.setString(3, reso.getAutor());
            ps.setInt(4, reso.getType());
            ps.setBoolean(5, reso.isStatus());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean save(Resources reso) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE recurso SET title=?, author=?, type=?, status=? WHERE code=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, reso.getTitle());
            ps.setString(2, reso.getAutor());
            ps.setInt(3, reso.getType());
            ps.setBoolean(4, reso.isStatus());
            ps.setInt(5, reso.getCode());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean delete(Resources reso) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE recurso SET status = false WHERE code=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, reso.getCode());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public boolean search(Resources reso) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM recurso WHERE code=? ";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, reso.getCode());
            rs = ps.executeQuery();

            if (rs.next()) {
                reso.setCode(rs.getInt("code"));                
                reso.setTitle(rs.getString("title"));
                reso.setAutor(rs.getString("author"));
              //  reso.setType(rs.getInt("tipo"));
              //  reso.setStatus(rs.getBoolean("estatus"));   
                return true;
            }
            return false;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public ResultSet list() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT code as Código, title as Título, author as Autor, type as Tipo, status as Estatus "
                    + " FROM recurso order by code asc";

        try {
            ps = con.prepareStatement(sql);            
            rs = ps.executeQuery();

            return rs;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    public ResultSet listTypeResource() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();
        String sql = "SELECT * FROM tipo_recurso ";

        try {
            ps = con.prepareStatement(sql);            
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.err.println(e);
            }
        }
    }
}