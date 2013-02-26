/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mariusbrederlow
 */
@ManagedBean(name="SessionManager")
@NoneScoped
public class SessionManager {

    
    public SessionManager() {
    }
    
    /*
     * Holt sich den Request aus dem Faces Context, fuehrt ein Logout aus und invalidiert die Session.
     */
    public String doLogout() throws ServletException {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        req.logout();
        req.getSession(false).invalidate();     
        
        return "/logout.xhtml";
    }
    
}
