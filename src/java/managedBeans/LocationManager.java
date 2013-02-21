/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Kommunikation.LookUp;
import Util.ListenFilter;
import entities.Staedte;
import interfaces.ILocationService;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.naming.NamingException;

/**
 *
 * @author mariusbrederlow
 */
@ManagedBean(name = "LocationManager")
@SessionScoped
public class LocationManager implements Serializable {

    private Set<Integer> zweiterKnoten;
    private Set<Integer> dritterKnoten;
    private Staedte stadt;
    private int knotenID;
    private int knotenIDsec;
    private int knotenID3rd;
    private String stadtname = "Stadtname";
    @ManagedProperty(value="#{ListenFilter}")
    private ListenFilter filter;

    

    public LocationManager() {        
        zweiterKnoten = new HashSet<Integer>();
        dritterKnoten = new HashSet<Integer>();
     }

    public void getOrt() throws NamingException {

        ILocationService dienst = (ILocationService) new LookUp().doLookUp("java:global/HotelService-ejb/LocationService");
        stadt = dienst.getStadt(knotenID, knotenIDsec, knotenID3rd);
        stadtname = stadt.getStadtName();
    }

    public void getSecKnoten() throws NamingException {
        
        ILocationService dienst = (ILocationService) new LookUp().doLookUp("java:global/HotelService-ejb/LocationService");
        zweiterKnoten = filter.entferneGewaelteKnoten(dienst.getNextKnoten(knotenID), knotenID);
      }

    public void trdKnotenIDleseen() throws NamingException {

         ILocationService dienst = (ILocationService) new LookUp().doLookUp("java:global/HotelService-ejb/LocationService");
         dritterKnoten = filter.entferneGewaelteKnoten(dienst.getNextKnoten(knotenID, knotenIDsec), knotenID, knotenIDsec);
      }


    public Set<Integer> getZweiterKnoten() {
        return zweiterKnoten;
    }

    public void setZweiterKnoten(HashSet<Integer> zweiterKnoten) {
        this.zweiterKnoten = zweiterKnoten;
    }

    public Staedte getStadt() {
        return stadt;
    }

    public void setStadt(Staedte stadt) {
        this.stadt = stadt;
    }

    public int getKnotenID() {
        return knotenID;
    }

    public void setKnotenID(int knotenID) {
        this.knotenID = knotenID;
    }

    public int getKnotenIDsec() {
        return knotenIDsec;
    }

    public void setKnotenIDsec(int knotenIDsec) {
        this.knotenIDsec = knotenIDsec;
    }

    public int getKnotenID3rd() {
        return knotenID3rd;
    }

    public void setKnotenID3rd(int knotenID3rd) {
        this.knotenID3rd = knotenID3rd;
    }

    public Set<Integer> getDritterKnoten() {
        return dritterKnoten;
    }

    public void setDritterKnoten(Set<Integer> dritterKnoten) {
        this.dritterKnoten = dritterKnoten;
    }    

    public String getStadtname() {
        return stadtname;
    }

    public void setStadtname(String stadtname) {
        this.stadtname = stadtname;
    }

    public ListenFilter getFilter() {
        return filter;
    }

    public void setFilter(ListenFilter filter) {
        this.filter = filter;
    }
    
    
}
