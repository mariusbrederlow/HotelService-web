/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Kommunikation;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author mariusbrederlow
 */
public class LookUp {        
    
    public Object doLookUp(String jndi) throws NamingException, IOException{
        
     
        
        Properties props = new Properties();
        Object refference;
   
props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.enterprise.naming.SerialInitContextFactory");
props.put("org.omg.CORBA.ORBInitialHost", "127.0.0.1");
props.put("org.omg.CORBA.ORBInitialPort", "3700");
props.put("java.naming.factory.initial", "com.sun.enterprise.naming.SerialInitContextFactory");  
props.put("java.naming.factory.url.pkgs", "com.sun.enterprise.naming");  
props.put("java.naming.factory.state", "com.sun.corba.ee.impl.presentation.rmi.JNDIStateFactoryImpl");

//        InputStream stream = this.getClass().getClassLoader().getResourceAsStream("jndi.properties");
//        props.load(stream);
        
        
InitialContext ctx = new InitialContext(props); 
        
refference = ctx.lookup(jndi);


return refference;
        
        
    }
}
