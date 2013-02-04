/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

/**
 *
 * @author mariusbrederlow
 */
@Named(value = "stadtBean")
@Dependent
@ManagedBean
public class StadtVerwaltung {

    private String name;
    private int knoten1;
    private int knoten2;
    private int knoten3;
    
    public StadtVerwaltung() {
       
    }




}
