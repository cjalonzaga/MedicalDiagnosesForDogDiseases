/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package src;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
/**
 *
 * @author Cris John Alonzaga
 */
public class TestDataBaseConnection {
    private final String conn = "jdbc:mysql://localhost:3306/ddms";
    private final String user = "root";
    private final String password = "";
    private ArrayList<String> symptoms;
    public void testConnection() {
        ArrayList<String> theSymptoms = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            Connection connect;
            try {
                connect = DriverManager.getConnection(this.conn, this.user, this.password);
                Statement stmt = connect.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM symptoms");
            
                while(rs.next()){
                    theSymptoms.add(rs.getString(2));
                    //System.out.println(rs.getString(2));
                }
                connect.close();
            } catch (SQLException ex) {
                Logger.getLogger(TestDataBaseConnection.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println(ex);
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.print(ex);
        }
        symptoms = theSymptoms;
    }
    public ArrayList<String> getSymptoms(){
        return this.symptoms;
    }
    public String getConnection(){
        return this.conn;
    }
}
