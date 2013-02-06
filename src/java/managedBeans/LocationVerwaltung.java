/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Kommunikation.LookUp;
import entities.Staedte;
import interfaces.ILocationService;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.naming.NamingException;

/**
 *
 * @author mariusbrederlow
 */
@Named(value = "locationBean")
@ManagedBean
@SessionScoped
public class LocationVerwaltung implements Serializable {

    private String name;
    private int ein_knoten;
    private List<SelectItem> names;
    private List<SelectItem> intKnoten;
    private List<Staedte> knoten;
    private Staedte stadt;
    
    public LocationVerwaltung() throws NamingException, IOException {
        names = new ArrayList<SelectItem>();
        knoten = new ArrayList<Staedte>();
        intKnoten = new ArrayList<SelectItem>();
        //getnextknoten();
   
    }

    
      public void getnextknoten() throws NamingException, IOException{
     System.out.println("Locationsverwaltung");
        int i = 5;
        
        
       ILocationService dienstn = (ILocationService) new LookUp().doLookUp("java:global/HotelService-ejb/LocationService");
      
       
       
       knoten = Arrays.asList(dienstn.getNextKnoten(i).toArray(new Staedte[0]));
      
       Iterator itr = knoten.iterator();
       while(itr.hasNext()){
           Staedte element =(Staedte) itr.next();
           intKnoten.add(new SelectItem(element.getStadtID()));
         System.out.print(element.getStadtID());
         
       }
       
       
       
       
    }

    public int getEin_knoten() {
        return ein_knoten;
    }

    public void setEin_knoten(int ein_knoten) {
        this.ein_knoten = ein_knoten;
    }

    public List<SelectItem> getIntKnoten() {
        return intKnoten;
    }

    public void setIntKnoten(List<SelectItem> intKnoten) {
        this.intKnoten = intKnoten;
    }
    
    
      
      
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SelectItem> getNames() {
        return names;
    }

    public void setNames(List<SelectItem> names) {
        this.names = names;
    }

    public List<Staedte> getKnoten() {
        return knoten;
    }

    public void setKnoten(List<Staedte> knoten) {
        this.knoten = knoten;
    }

    public Staedte getStadt() {
        return stadt;
    }

    public void setStadt(Staedte stadt) {
        this.stadt = stadt;
    }
    
    
    
}
