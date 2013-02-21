/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kommunikation;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author mariusbrederlow
 * Die LookUp Klasse stellt als einzige Methode doLookUp zur Verfügung. Sie repräsentier die zentrale
 * Rolle der Kommunikation zwischen der Web-App und den BackEnd EJBs. 
 */
public class LookUp {        
    /*
     * doLookUp bekommt als Parameter einen JNDI-Namen als String übergeben und liefert eine Remote-Refferenz
     * auf das entfernte Objekt zurück.
     */
    public Object doLookUp(String jndi) throws NamingException{
        
     
        
        Properties props = new Properties();
        Object refference;
   
props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
//IP des Remote Application Servers
props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
//IIOP Port des Remote Applications Servers
props.put("org.omg.CORBA.ORBInitialPort", "3700");
props.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");  
props.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");  
props.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

       
        
InitialContext ctx = new InitialContext(props); 
        
refference = ctx.lookup(jndi);


return refference;
        
        
    }
}
