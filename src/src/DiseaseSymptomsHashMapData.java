/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Cris John Alonzaga
 */
public class DiseaseSymptomsHashMapData {
    
    private HashMap<String, Integer> symptomKeyValues = new HashMap<>();
    
    public void pullOutString(String s) throws ClassNotFoundException, SQLException{
        DataBaseQueries dbq = new DataBaseQueries();
        int id = dbq.getSymptomsId(s);
        
        setSymptomsKeyValues(s, id);
    }
    
    public void setSymptomsKeyValues(String symp, Integer id){
        this.symptomKeyValues.put(symp, id);
    }
    
    public HashMap getSymptomsKeyValues(){
        return this.symptomKeyValues;
    }
}
