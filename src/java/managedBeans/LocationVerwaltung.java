/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author mariusbrederlow
 */
@Named(value = "locationBean")
@SessionScoped
public class LocationVerwaltung implements Serializable {

    /**
     * Creates a new instance of LocationVerwaltung
     */
    public LocationVerwaltung() {
    }
}
