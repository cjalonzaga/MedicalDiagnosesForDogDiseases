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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cris John Alonzaga
 */
public class DataBaseQueries {
    TestDataBaseConnection connect = new TestDataBaseConnection();
    private ArrayList<String> patients;
    private final ArrayList<String> diseases;
    private String disease, description, causes, treatment;
    
    private final HashMap<String, Integer> diseasemap = new HashMap<>();
    private HashMap<String, Integer> patientmapping = new HashMap<>();
    private HashMap<Integer , String> patientlimit = new HashMap<>();
    
    //Table data 
    private Object[][] datas;
    
    private int lastInsertId;
    private boolean userexist;

    public DataBaseQueries() {
        this.diseases = new ArrayList<>();
    }
    
    //to query patient id and name
    public void queryPatientInfo(){
        String conn = connect.getConnection();
        ArrayList<String> p_list = new ArrayList<>();
        HashMap<String, Integer> patientlocal = new HashMap<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnct;
        
            try {
                cnct = DriverManager.getConnection(conn, "root", "");
                String query = "SELECT patient_id, owners_name FROM patient_infos";
                PreparedStatement stmt = cnct.prepareStatement(query);
                
                ResultSet res = stmt.executeQuery(query);
                
                while(res.next()){
                    int id = Integer.parseInt(res.getString(1));
                    patientlocal.put(res.getString(2), id);
                    p_list.add(res.getString(2));
                }
                res.close();
            } catch (SQLException ex) {
                Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(patientmapping);
        setPatientHashMap(patientlocal);
        patients = p_list;
    }
    
    public void setPatientHashMap(HashMap<String , Integer> pmap){
        this.patientmapping = pmap;
    }
  
    public HashMap<String , Integer> getPatientHashMap(){
        return this.patientmapping;
    }
   
    public ArrayList<String> getPatientList(){
        return this.patients;
    }
    //----end id and patient queries---//
    
    public void deletePatient(String id){
        String conn = connect.getConnection();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection cnt;
            try{
                cnt = DriverManager.getConnection(conn, "root", "");
                String dbquery = "DELETE FROM patient_infos" + " WHERE patient_id = ?"; 
                PreparedStatement stmt = cnt.prepareStatement(dbquery);
                stmt.setString(1, id);
                
                stmt.execute();
                
                cnt.close();
            }
            catch(SQLException e){
                System.out.println(e);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Integer getSymptomsId( String id ) throws ClassNotFoundException, SQLException{
        String conn = connect.getConnection();
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection driver;
        
        driver = DriverManager.getConnection(conn, "root", "");
        
        String qry = "SELECT id FROM symptoms WHERE sym_name = ?";
        int sid;
        try (PreparedStatement stmt = driver.prepareStatement(qry)) {
            if(!"".equals(id)){
                stmt.setString(1, id);
            }   sid = 0;
            ResultSet results = stmt.executeQuery();
            while(results.next()){
                sid = Integer.parseInt(results.getString(1));
            }
        }
        //System.out.println(sid);
        return sid;
    }
    
    public void generatePosibleDiseases(ArrayList<Integer> id) throws ClassNotFoundException, SQLException{
        String con = connect.getConnection();
        
        Class.forName("com.mysql.jdbc.Driver");
        Connection driver;
        
        driver = DriverManager.getConnection(con , "root" , "");
        String query = "SELECT diseases.id , diseases.dis_name FROM diseases INNER JOIN dise_symp ON diseases.id = dise_symp.diseaseid INNER JOIN symptoms ON symptoms.id = dise_symp.symptomid WHERE symptoms.id = ?";
        PreparedStatement stmt = driver.prepareStatement(query);
        ResultSet res; 
        for (Integer ids : id) {
            stmt.setString(1, ids.toString());
            res = stmt.executeQuery();
            while(res.next()){
                int num = Integer.parseInt(res.getString(1));
                this.diseasemap.put(res.getString(2), num);
                this.diseases.add(res.getString(2));  
            }
        }
        //ResultSet res = stmt.executeQuery();
        stmt.close();
    }
    
    public ArrayList<String> preventDuplicates(){
        HashSet<String> sets = new HashSet<>(this.diseases);
        ArrayList<String> diseaseslist = new ArrayList<>(sets);
        return diseaseslist;
    }
 
    public void queryDiseaseInformation(String dis) throws ClassNotFoundException, SQLException{
        String con = connect.getConnection();
        //String d_id = dis.substring(0, dis.indexOf(" "));
        Class.forName("com.mysql.jdbc.Driver");
        Connection driver;
        
        driver = DriverManager.getConnection(con, "root", "");
        String query = "SELECT dis_name, discription, cause, treatment FROM diseases WHERE id = ?";
        PreparedStatement stmt = driver.prepareStatement(query);
        
        ResultSet sets;
        stmt.setString(1, dis);
        sets = stmt.executeQuery();
        
        while(sets.next()){
            setDisease(sets.getString(1));
            setDiseaseDescription(sets.getString(2));
            setDiseaseCause(sets.getString(3));
            setDiseaseTreatment(sets.getString(4));
        }
        
        stmt.close();
    }
    
    //insert save_diagnose records
    //method overloading applied 
    public void insertDataRecords(ArrayList<String> patientRecord){
        try {
            //System.out.println(patientRecord.get(0) +" "+ patientRecord.get(1));
            String cnt = connect.getConnection();
            Connection driver;
            
            Calendar calendar = Calendar.getInstance();
            java.sql.Date entryDate = new java.sql.Date(calendar.getTime().getTime());
            
            Class.forName("com.mysql.jdbc.Driver");
            driver = DriverManager.getConnection(cnt, "root", "");
            
            String query = "INSERT INTO patient_infos (owners_name, patient_name, date_entry, breed)"+"VALUES (?,?,?,?)";
            
            try (PreparedStatement stmt = driver.prepareStatement(query , Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, patientRecord.get(0));
                stmt.setString(2, patientRecord.get(1));
                stmt.setString(3, entryDate.toString());
                stmt.setString(4, patientRecord.get(2));
                
                stmt.execute();
                
                ResultSet set = stmt.getGeneratedKeys();
                
                if(set.next()){
                    setLastInsertedId(set.getInt(1));
                }
            }
            
            driver.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("Gago error");
        }
        //System.out.println(getLastInsertedId());
    }
    
    public void insertDataRecords(HashMap<String, Integer> map){
        //System.out.println(map);
        
        //String query = "INSERT INTO symps_selected"
        try {
            String cnt = connect.getConnection();
            Connection driver;
            Class.forName("com.mysql.jdbc.Driver");
            
            Calendar calendar = Calendar.getInstance();
            java.sql.Date entryDate = new java.sql.Date(calendar.getTime().getTime());
            
            driver = DriverManager.getConnection(cnt, "root", "");
            
            String query = "INSERT INTO symps_selected (symptoms_id, patient_id, entry_date)" + "VALUES (? , ? , ?)";
            
            try (PreparedStatement stmt = driver.prepareStatement(query)) {
                for(String name : map.keySet()){
                    stmt.setString(1, map.get(name).toString());
                    stmt.setInt(2, getLastInsertedId());
                    stmt.setString(3, entryDate.toString());
                    stmt.execute();
                }
            }
            driver.close();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
    }
    public void saveDiagnoseData(ArrayList<Integer> diseaseid){
         try {
            String cnt = connect.getConnection();
            Connection driver;
            Class.forName("com.mysql.jdbc.Driver");
            
            Calendar calendar = Calendar.getInstance();
            java.sql.Date entryDate = new java.sql.Date(calendar.getTime().getTime());
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minutes = calendar.get(Calendar.MINUTE);
            String time = hour + " : " + minutes;
            
            driver = DriverManager.getConnection(cnt, "root", "");
            
            String query = "INSERT INTO diagnose_disease (disease_id, patient_id, diagnose_date, time)" + "VALUES (? , ? , ? , ?)";
            
            PreparedStatement stmt = driver.prepareStatement(query);
            
            for(int id : diseaseid){
                stmt.setInt(1, id);
                stmt.setInt(2, getLastInsertedId());
                stmt.setString(3, entryDate.toString());
                stmt.setString(4, time);
                
                stmt.execute();
            }
            stmt.close();
            
            driver.close();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
    }
    //--- End of saving data records ----//
    
    
    //method to populate jcombobox//
    
    public ArrayList<String> returnTextFromDataBase(){
        ArrayList<String> list = new ArrayList<>();
        
        try {
            String con = connect.getConnection();
            Connection driver;
            Class.forName("com.mysql.jdbc.Driver");

            driver = DriverManager.getConnection(con, "root", "");
            String query = "SELECT owners_name FROM patient_infos";
            
            PreparedStatement stmt = driver.prepareStatement(query);
          
            ResultSet sets = stmt.executeQuery();
            
            while(sets.next()){
                //name = sets.getString(1); //
                list.add(sets.getString(1));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return list;
    }
    
    public String[] populateFormFields(String name){
        String[] patient = new String[3];
        
        String conn = connect.getConnection();
        Connection driver;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            driver = DriverManager.getConnection(conn, "root", "");
            String query = "Select owners_name, patient_name, breed FROM patient_infos WHERE owners_name = ?";
            
            PreparedStatement stmt = driver.prepareStatement(query);
            
            if(name != null && !"".equals(name)){
               
                stmt.setString(1, name);
                ResultSet sets = stmt.executeQuery();

                while(sets.next()){
                    patient[0] = sets.getString(1);
                    patient[1] = sets.getString(2);
                    patient[2] = sets.getString(3);
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return patient;
    }
    
    
    public boolean checkIfUserExist(String name){
        boolean bool = false;
        String conn = connect.getConnection();
        Connection driver;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            
            driver = DriverManager.getConnection(conn, "root", "");
            String query = "Select patient_id, owners_name FROM patient_infos WHERE owners_name = ?";
            
            PreparedStatement stmt = driver.prepareStatement(query);
            
            if(name != null && !"".equals(name)){
                
                stmt.setString(1, name);
                ResultSet sets = stmt.executeQuery();
                
                while(sets.next()){
                    bool = sets.getString(2).equals(name);
                    if(bool){
                        setLastInsertedId(Integer.parseInt(sets.getString(1)));
                    }
                    this.userexist = bool;
                }
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DataBaseQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
        //System.out.println(this.userexist);
        return this.userexist;
    }
    
    public void setLastInsertedId(int id){
        this.lastInsertId = id;
    }
    public int getLastInsertedId(){
        return this.lastInsertId;
    }
    
    
    
    public void setDisease(String disease){
        this.disease = disease;
    }
    
    public String getDisease(){
        return this.disease;
    }
    
    public void setDiseaseDescription(String description){
        this.description = description;
    }
    public String getDiseaseDescription(){
        return this.description;
    }
    
    public void setDiseaseCause(String cause){
        this.causes = cause;
    }
    public String getDiseaseCause(){
        return this.causes;
    }
    
    public void setDiseaseTreatment(String treatment){
        this.treatment = treatment;
    }
    public String getDiseaseTreatment(){
        return this.treatment;
    }
    
    public HashMap<String , Integer> getDiseasesMapping(){
        return this.diseasemap;
    }
}
