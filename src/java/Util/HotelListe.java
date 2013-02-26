/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import entities.Hotels;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mariusbrederlow
 */

/*
 * Hilfsklasse fuer das XML Marshalling
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "HotelListe")
public class HotelListe {
    
    public HotelListe(){
        
    }

    public HotelListe(List<Hotels> hotels){
        this.hotels = hotels;
    }
    @XmlElement(name = "Hotel", type = Hotels.class)
    private List<Hotels> hotels;

    public List<Hotels> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotels> hotels) {
        this.hotels = hotels;
    }
    
    
    
    
    
    
}
