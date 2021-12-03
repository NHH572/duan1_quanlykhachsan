/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.exemple.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hp
 */
public class JdbcHelper {
    public static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    public static String dburl="jdbc:sqlserver://localhost:1433;databaseName=QuanLyKhachSan";
    public static String username="sa";
    public static String password="";
    public static Connection con;
    
    //nạp driver
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 
    public static PreparedStatement preparedStatement(String sql,Object...args)throws SQLException{
        con=DriverManager.getConnection(dburl, username, password);
        PreparedStatement pstmt=null;
        if(sql.startsWith("{"))pstmt=con.prepareCall(sql); 
        else pstmt=con.prepareStatement(sql);
        for(int i=0; i<args.length;i++){
            pstmt.setObject(i+1, args[i]);
        }
        return pstmt;
    }
    
    public static void executeUpdate(String sql,Object...args){
        try {
            PreparedStatement pstmt= JdbcHelper.preparedStatement(sql, args);
            try{
                pstmt.executeUpdate();
            }finally{
                pstmt.getConnection().close();      
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public static ResultSet executeQuery(String sql, Object...args) throws SQLException{
       
            PreparedStatement pstmt=JdbcHelper.preparedStatement(sql, args);
                return pstmt.executeQuery();
    }
    
    public static Object value(String sql, Object...args){
        try {
           ResultSet rs = JdbcHelper.executeQuery(sql, args);
           if(rs.next()){
               return rs.getObject(0);
           }
           rs.getStatement().getConnection().close();
           return null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
    }
}