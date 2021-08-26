/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;


/**
 *
 * @author Cris John Alonzaga
 */
public class HyperLinkLabel {
    private String hyperlink;
    
    public void setLinkDisease(String link){
        String str = link.replace(" ", "+");
        this.hyperlink = str;
    }
    public String getLinkOfDisease(){
        return this.hyperlink;
    }
    
//    public static class innerClass{
//        void saySomething(){
//            System.out.println("Hi from inner class");
//        }   
//    }
}
