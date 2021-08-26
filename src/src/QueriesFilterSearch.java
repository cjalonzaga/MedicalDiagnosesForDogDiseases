/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Cris John Alonzaga
 */
public class QueriesFilterSearch {
    
    TestDataBaseConnection connect = new TestDataBaseConnection();
    
    private Object[][] datas;
    private HashSet<Integer> ids = new HashSet<>();
    
    private HashMap<Integer , String> filtersearchdatas = new HashMap<>();
    
    public void getFilterData(String from , String to){
        
        String conn = connect.getConnection();
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            
            try{
                
                cnt = DriverManager.getConnection(conn, "root", "");
                String dbquery = "SELECT patient_id , owners_name , date_entry FROM patient_infos WHERE date_entry BETWEEN ? AND ?"; 
                PreparedStatement stmt = cnt.prepareStatement(dbquery);
                
                stmt.setString(1, from);
                stmt.setString(2, to);
                
                ResultSet res = stmt.executeQuery();
                
                if(res.next()){
                    setpopulatableJTable(res);
                }
                else{
                    JOptionPane.showMessageDialog(null, "No Record !!");
                }
                
                stmt.close();
                cnt.close();
            }
            catch(SQLException e){
                System.out.println(e);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    public void getFilterData(String name){
        
        String conn = connect.getConnection();
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            
            try{
                
                cnt = DriverManager.getConnection(conn, "root", "");
                String dbquery = "SELECT patient_id , owners_name , date_entry FROM patient_infos WHERE owners_name = ?"; 
                PreparedStatement stmt = cnt.prepareStatement(dbquery);
                
                stmt.setString(1, name);
                
                ResultSet res = stmt.executeQuery();
                
                if(res.next()){
                    setpopulatableJTable(res);
                }
                
                stmt.close();
                cnt.close();
            }
            catch(SQLException e){
                System.out.println(e);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);  
        }
    }
    
    
    
    public void setpopulatableJTable(ResultSet sets){
        
        try {
            
            sets.last();
            int rows = sets.getRow();
            sets.beforeFirst();
            
            Object[][] entries = new Object[rows][3];
            
            int i = 0;
            
            while(sets.next()){
                entries[i][0] = sets.getString("patient_id");
                entries[i][1] = sets.getString("owners_name");
                entries[i][2] = sets.getString(3);
                
                i++;
            }
            
            this.datas = entries; 
            
        } catch (SQLException ex) {
            Logger.getLogger(QueriesFilterSearch.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Object[][] getpopulatableJTable(){
        return this.datas;
    }
    
    
    public Object[][] populateTableData(){
        String conn = connect.getConnection();
        Connection driver;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            driver = DriverManager.getConnection(conn, "root", "");
            String query = "SELECT patient_id, owners_name, date_entry FROM patient_infos LIMIT 10";
            
            PreparedStatement stmt = driver.prepareStatement(query);
            
            ResultSet sets = stmt.executeQuery();
            
            sets.last();
            int rows; 
            rows = sets.getRow();
            
            sets.beforeFirst();
            
            Object[][] sampledata = new Object[rows][3];
            int i = 0;
            
            while(sets.next()){
               sampledata[i][0] = sets.getString("patient_id");
               sampledata[i][1] = sets.getString("owners_name");
               sampledata[i][2] = sets.getString("date_entry");
               i++;
            } 
            this.datas = sampledata;
            stmt.close(); 
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return this.datas;
    }
    
    //Funtionality for view individual records 
    //return all data from a single person if view record button is click
    public HashSet<Integer> personsTableData(String id){
        String conn = connect.getConnection();
        Connection driver;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            driver = DriverManager.getConnection(conn, "root", "");
            String query = "SELECT diagnose_disease.disease_id FROM diagnose_disease WHERE diagnose_disease.patient_id = ?";
            
            String query_info = "SELECT patient_infos.patient_id , patient_infos.owners_name, diagnose_disease.diagnose_date FROM patient_infos INNER JOIN diagnose_disease ON patient_infos.patient_id = diagnose_disease.patient_id WHERE diagnose_disease.patient_id = ? GROUP BY diagnose_disease.diagnose_date";
            
            PreparedStatement stmt2 = driver.prepareStatement(query_info);
            PreparedStatement stmt = driver.prepareStatement(query);
            
            stmt.setString(1, id);
            stmt2.setString(1, id);
            ResultSet set = stmt2.executeQuery();
            ResultSet sets = stmt.executeQuery();
            
            if(set != null && sets != null){
                setpopulatableJTable(set);
                while(sets.next()){
                    this.ids.add(Integer.parseInt(sets.getString(1)));
                }
            }
            
            stmt.close(); 
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.ids;
    }
    
    //Method to show individual patient records
    
    public void showHistoryDetails(String name, int id){
        String conn = connect.getConnection();
        Connection driver;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            driver = DriverManager.getConnection(conn, "root", "");
            String query = "";
            
            PreparedStatement stmt = driver.prepareStatement(query);
            
            ResultSet sets = stmt.executeQuery();
            
            stmt.close(); 
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
