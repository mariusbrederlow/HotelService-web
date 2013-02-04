/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.util.LinkedList;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author mariusbrederlow
 */
@ManagedBean
public class HotelBean {

    /**
     * Creates a new instance of HotelBean
     */
    public HotelBean() {
    }
    
    private int hotelID;
    private String hotelName;
    private int sterne;
    private boolean pool;
    private String stadt;

    
    public List<HotelBean> getHotelList(){
        
        List<HotelBean> liste = new LinkedList<HotelBean>();
        
        
        return liste;
    }
    
    
    
    
    
    
    
    
    public int getHotelID() {
        return hotelID;
    }

    public void setHotelID(int hotelID) {
        this.hotelID = hotelID;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getSterne() {
        return sterne;
    }

    public void setSterne(int sterne) {
        this.sterne = sterne;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }
    
    
    
    
    
    
    
    
    
}
