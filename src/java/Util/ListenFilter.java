/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import entities.Staedte;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author mariusbrederlow
 */
@ManagedBean(name = "ListenFilter")
@SessionScoped
public class ListenFilter implements Serializable {

   
    public ListenFilter() {
    }
    
    //Entfernt WLAN Knoten1 aus der Liste der Knoten
    public Set<Integer> entferneGewaelteKnoten(List<Staedte> knoten, int knotenID){        
        Set knotenListe = new HashSet();
        Iterator itr = knoten.iterator();
        
        while (itr.hasNext()) {
          Staedte element = (Staedte) itr.next();
        
            if (element.getKnoten1() != knotenID) {               
                knotenListe.add(element.getKnoten1());
            }

            if (element.getKnoten2() != knotenID) {                
                knotenListe.add(element.getKnoten2());
            }

            if (element.getKnoten3() != knotenID) {                
                knotenListe.add(element.getKnoten3());
            }

        }

        return knotenListe;
        
    }
    
    
        //Entfernt WLAN Knoten1 und Knoten2 aus der Liste
       public Set<Integer> entferneGewaelteKnoten(List<Staedte> knoten, int knotenID, int knotenIDsec){        
        Set knotenListe = new HashSet();
        Iterator itr = knoten.iterator();
        
        while (itr.hasNext()) {
          Staedte element = (Staedte) itr.next();
        
            if (element.getKnoten1() != knotenID && element.getKnoten1() != knotenIDsec) {               
                knotenListe.add(element.getKnoten1());
            }

            if (element.getKnoten2() != knotenID && element.getKnoten2() != knotenIDsec) {                
                knotenListe.add(element.getKnoten2());
            }

            if (element.getKnoten3() != knotenID && element.getKnoten3() != knotenIDsec) {                
                knotenListe.add(element.getKnoten3());
            }

        }

        return knotenListe;
        
    }
    
    
    
    
    
}
