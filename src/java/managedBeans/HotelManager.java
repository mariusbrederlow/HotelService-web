/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Kommunikation.LookUp;
import entities.Hotels;
import interfaces.IHotelService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;

/**
 *
 * @author mariusbrederlow
 */
@ManagedBean(name = "HotelManager")
@SessionScoped
public class HotelManager implements Serializable {

    private List<Hotels> hotels;
    private int sterne;
    private int pool;
    private int stadtid;
    @ManagedProperty(value = "#{LocationManager}")
    private LocationManager lm;

    public HotelManager() {
    }

    public void findeAlleHotelsInStadt() throws NamingException {
        IHotelService dienst = (IHotelService) new LookUp().doLookUp("java:global/HotelService-ejb/HotelService");
        hotels = dienst.sucheHotelsInStadt(lm.getStadt());
    }

    public void findePassendeHotelsInStadt() throws NamingException {
        IHotelService dienst = (IHotelService) new LookUp().doLookUp("java:global/HotelService-ejb/HotelService");
        hotels = dienst.suchePassendeHotels(lm.getStadt(), pool, sterne);
        
    }

    public int getSterne() {
        return sterne;
    }

    public void setSterne(int sterne) {
        this.sterne = sterne;
    }

    public int getPool() {
        return pool;
    }

    public void setPool(int pool) {
        this.pool = pool;
    }

    public int getStadtid() {
        return stadtid;
    }

    public void setStadtid(int stadtid) {
        this.stadtid = stadtid;
    }

    public LocationManager getLm() {
        return lm;
    }

    public void setLm(LocationManager lm) {
        this.lm = lm;
    }

    public List<Hotels> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotels> hotels) {
        this.hotels = hotels;
    }
}
