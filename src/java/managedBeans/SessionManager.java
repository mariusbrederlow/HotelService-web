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

    /**
     * Creates a new instance of SessionManager
     */
    public SessionManager() {
    }
    
    
    public String doLogout() throws ServletException {
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        req.logout();
        req.getSession(false).invalidate();     
        
        return "/logout.xhtml";
    }
    
}
