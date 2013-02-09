/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import Kommunikation.LookUp;
import entities.Staedte;
import interfaces.ILocationService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import javax.naming.NamingException;

/**
 *
 * @author mariusbrederlow
 */

@ManagedBean(name="LocationManager")
@SessionScoped

public class LocationManager implements Serializable {

    private List<Integer> intKnoten;
    private List<Integer> trdKnoten;
    private List<Staedte> knoten;
    private Staedte stadt;
    private int stadtid;
    private int knotenID;
    private int knotenIDsec;
    private int knotenID3rd;
    private String stadtname = "Stadtname";
    
    
    
    

    public LocationManager() throws NamingException, IOException {
        System.out.println("Konstruktor Locationverwaltung");
        knoten = new ArrayList<Staedte>();
        intKnoten = new LinkedList<Integer>();
        trdKnoten = new LinkedList<Integer>();
       
        
    }

    
    
  public void getOrt() throws NamingException, IOException{
      
       ILocationService dienst = (ILocationService) new LookUp().doLookUp("java:global/HotelService-ejb/LocationService");
      stadt=dienst.getStadt(knotenID, knotenIDsec, knotenID3rd);
      stadtname = stadt.getStadtName();
      stadtid = stadt.getStadtID();
  } 
    
    
    
    
    
    
    
    
    
    
    public void getSecKnoten() throws NamingException, IOException {
       
        Set dupl = new HashSet();
        knoten.clear();
        dupl.clear();
        intKnoten.clear();


        ILocationService dienst = (ILocationService) new LookUp().doLookUp("java:global/HotelService-ejb/LocationService");


        //Casted die empfangene List<Object> auf List<Staedte>
        //knoten = Arrays.asList(dienst.getNextKnoten(knotenID).toArray(new Staedte[0]));
      knoten=dienst.getNextKnoten(knotenID);
        
       
        
        Iterator itr = knoten.iterator();
        
        while (itr.hasNext()) {
            Staedte element = (Staedte) itr.next();
             
             
                
            if(element.getKnoten1() != knotenID){
                System.out.println("Eintrag angelegt" + element.getKnoten1());
                intKnoten.add(element.getKnoten1());
           
            }
            
            if(element.getKnoten2() != knotenID){
                System.out.println("Eintrag angelegt" + element.getKnoten2());
                intKnoten.add(element.getKnoten2());
         
            }
            
             if(element.getKnoten3() != knotenID){
                 System.out.println("Eintrag angelegt" + element.getKnoten3());
                intKnoten.add(element.getKnoten3());
         
            }
            
           }

        //Schreiben der Werte in ein Set um Duplikate zu entfernen. Set kann nach SET API Spec keine Duplikate enthalen
       
        dupl.addAll(intKnoten);
       intKnoten.clear();
       intKnoten.addAll(dupl);
        
    }

    
    
    
    
    public void trdKnotenIDleseen() throws NamingException, IOException{
        
        System.out.println("trdKnoten LESEN");
        Set dupl = new HashSet();
        ILocationService dienst = (ILocationService) new LookUp().doLookUp("java:global/HotelService-ejb/LocationService");
        knoten.clear();
        trdKnoten.clear();
        knoten=dienst.getNextKnoten(knotenID, knotenIDsec);
        
        
        
        
        Iterator itr = knoten.iterator();
        
        while (itr.hasNext()) {
            Staedte element = (Staedte) itr.next();
//            
                
            if(element.getKnoten1() != knotenID && element.getKnoten1() != knotenIDsec){
                System.out.println("Eintrag angelegt" + element.getKnoten1());
                trdKnoten.add(element.getKnoten1());
           
            }
            
            if(element.getKnoten2() != knotenID && element.getKnoten2() != knotenIDsec){
                System.out.println("Eintrag angelegt" + element.getKnoten2());
                trdKnoten.add(element.getKnoten2());
         
            }
            
             if(element.getKnoten3() != knotenID && element.getKnoten3() != knotenIDsec){
                 System.out.println("Eintrag angelegt" + element.getKnoten3());
                trdKnoten.add(element.getKnoten3());
         
            }
            
           }
        
        dupl.addAll(trdKnoten);
       trdKnoten.clear();
       trdKnoten.addAll(dupl);
        
        
        
    }
    
    
    
    

    public void nextKnotenID(){
         System.out.println("KnotenID");
        System.out.println(knotenID);
        System.out.println("KnotenIDsec");
        System.out.println(knotenIDsec);
        System.out.println("KnotenID3rd");
        System.out.println(knotenID3rd);
    }
    
    
    
    public List<Integer> getIntKnoten() {
        return intKnoten;
    }

    public void setIntKnoten(List<Integer> intKnoten) {
        this.intKnoten = intKnoten;
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

    public List<Integer> getTrdKnoten() {
        return trdKnoten;
    }

    public void setTrdKnoten(List<Integer> trdKnoten) {
        this.trdKnoten = trdKnoten;
    }

    public String getStadtname() {
        return stadtname;
    }

    public void setStadtname(String stadtname) {
        this.stadtname = stadtname;
    }

    public int getStadtid() {
        return stadtid;
    }

    public void setStadtid(int stadtid) {
        this.stadtid = stadtid;
    }

 
    
    
    
}
