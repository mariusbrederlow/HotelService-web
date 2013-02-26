/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.navigation;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author mariusbrederlow
 */

/*
 * Der String pageToDisplay enthaelt immer die Seite, die aktuell im center-panel angezeigt wird.
 */
@Named(value = "navigationBean")
@SessionScoped

public class NavigationBean implements Serializable {

    
    public NavigationBean() {
    }

private String pageToDisplay = "Hotelsuche.xhtml";

  public String getPageToDisplay(){      
      return this.pageToDisplay;
  }

  public void setPageToDisplay(String pageToDisplay){
      this.pageToDisplay = pageToDisplay;
  }







}
