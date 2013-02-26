/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;


import entities.Hotels;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author mariusbrederlow
 */
@ManagedBean(name = "XMLConverter")
@SessionScoped

/*
 * Klasse zum unmarshalling des uebergebenen Byte-Arrays in eine Liste von Hotels
 */
public class XMLConverter implements Serializable {

    /**
     * Creates a new instance of XMLConverter
     */
    public XMLConverter() {
    }
    
    
    
    public List<Hotels> unmarshal(byte[] bos) throws JAXBException {  
      
        List<Hotels> hotels;
        JAXBContext context;
        context = JAXBContext.newInstance(HotelListe.class);
        
        
        
        Unmarshaller um = context.createUnmarshaller();
        HotelListe list = (HotelListe) um.unmarshal(new ByteArrayInputStream(bos));        
        hotels = list.getHotels();
        
        return hotels;
    }
    
}
