/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import javax.swing.JCheckBox;

/**
 *
 * @author Cris John Alonzaga
 */
public class CheckBoxEventPatient{
    private int userid;
    private String patient_name;
    public void setActionForPatientCheckBox(JCheckBox check){
        check.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setPatientName(check.getText());
            }
        });      
    };
    
    public void setThePatientId(String patient){
       String num = patient;
       if(num.contains(" ")){
           String ids = num.substring(0, num.indexOf(" "));
           int Id = Integer.parseInt(ids);
           this.userid = Id;
       } 
    }
    public int getPatientId(){
        return userid;
    }
    public void setPatientName(String patientname){ 
        this.patient_name = patientname;
    }
    public String getPatientName(){
        return this.patient_name;
    }
    public void clearUserId(){
        this.userid = 0;
    }
}
