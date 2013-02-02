/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

/**
 *
 * @author mariusbrederlow
 */
@Named(value = "navigationBean")
@SessionScoped

public class NavigationBean implements Serializable {

    /**
     * Creates a new instance of NavigationBean
     */
    public NavigationBean() {
    }

private String pageToDisplay = "logout.xhtml";

  public String getPageToDisplay(){
      System.out.println("getppage");
      return this.pageToDisplay;
  }

  public void setPageToDisplay(String pageToDisplay){
     System.out.println("setppage");
     
      this.pageToDisplay = pageToDisplay;
  }







}
