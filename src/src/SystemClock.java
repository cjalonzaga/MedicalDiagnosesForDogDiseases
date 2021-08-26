package src;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Cris John Alonzaga
 */
public class SystemClock{
    //private Timer time;
    private String theTime;
    public void setTimeNow(){
        SimpleDateFormat frm = new SimpleDateFormat("HH:mm:ss a");
        String tm;
        
        Date date = new Date(System.currentTimeMillis());
        
        tm = frm.format(date);
        //System.out.print(frm.format(date));
        theTime = tm;
    }
    
    public String getTheTime(){
        return this.theTime;
    }
}
