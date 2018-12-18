package tubesapoteksehat;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Muhammad haikal
 */
public class Login {
    private String username;
    private String password;
    private String koneksi="localhost";
    private boolean isOK = false;
    private String cURLDB;
    private Statement stm;
    private java.sql.Connection conn;
    
    /** Creates a new instance of Login */
    public Login() {
        this.username="";
        this.password="";
    }

    public Login(java.lang.String cUser, java.lang.String passwd ) {
        this.username=cUser;
        this.password=passwd;
    }
    
    @Override
    protected void finalize() { conn = null; }
    
    public String getUsername(){ return this.username = ""; }
    public String getPassword() { return this.password = ""; }
    
    public boolean cekLogin() {
        
          try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/form_login", "root", "");
            stm = conn.createStatement();
            isOK = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "koneksi gagal "+e.getMessage());
            isOK = false;
        }
        return isOK;
    }
    
    public void closeConnDB(){
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println("Tidak dapat menutup koneksi database!" + e);
        }
        conn = null;
    }
    
    public java.sql.Connection getConnDB(){ return this.conn; }
    
    public boolean getIsOK() { return this.isOK; }
}
    

