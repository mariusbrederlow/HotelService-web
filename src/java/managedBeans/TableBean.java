/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;



import Kommunikation.LookUp;
import entities.Hotels;
import entities.Staedte;
import interfaces.IHotelService;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.naming.NamingException;


@Named(value="TableBean")
@ManagedBean
@SessionScoped
public class TableBean implements Serializable {

    private List<TableBean.ColumnModel> columns;
    private List<Hotels> hotels;
    private List<Staedte> knoten;
    private List<SelectItem> selected;
    private int selected_knoten;
    private String columnName;
    private int sterne;
    @ManagedProperty(value="#{LocationManager}")
    private LocationManager lm;

    public List<Staedte> getKnoten() {
        return knoten;
    }

    public List<SelectItem> getSelected() {
        return selected;
    }

    public void setSelected(List<SelectItem> selected) {
        this.selected = selected;
    }

    public void setKnoten(List<Staedte> knoten) {
        this.knoten = knoten;
    }

    public int getSelected_knoten() {
        return selected_knoten;
    }

    public void setSelected_knoten(int selected_knoten) {
        this.selected_knoten = selected_knoten;
    }

    
    
    
    
    
    
    public TableBean() throws NamingException, IOException {
        createDynamicColumns();
       //addHotels();
        knoten = new ArrayList<Staedte>();
        selected = new ArrayList<SelectItem>();
       
    }

    public void addHotels() throws NamingException, IOException {
        
        System.out.println("addHotels");
        
//        hotels = new ArrayList<Hotels>();
       
        IHotelService dienst = (IHotelService) new LookUp().doLookUp("java:global/HotelService-ejb/HotelService");
//         hotels = Arrays.asList(dienst.getMatchingHotels().toArray(new Hotels[0]));
        hotels = dienst.getHotelFromStadt(lm.getStadt());
        
    }
    
    
    
     
    
    

    private void createDynamicColumns() {

        columns = new ArrayList<TableBean.ColumnModel>();
        columns.add(new TableBean.ColumnModel("Hotel Name", "hotelName"));
        columns.add(new TableBean.ColumnModel("Sterne", "sterne"));
        columns.add(new TableBean.ColumnModel("Pool vorhanden", "pool"));
    }

    public List<Hotels> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotels> hotels) {
        this.hotels = hotels;
    }

    public List<TableBean.ColumnModel> getColumns() {
        return columns;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    static public class ColumnModel implements Serializable {

        private String header;
        private String property;

        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }

        public String getHeader() {
            return header;
        }

        public String getProperty() {
            return property;
        }
        
    }

    public int getSterne() {
        return sterne;
    }

    public void setSterne(int sterne) {
        this.sterne = sterne;
    }

    public LocationManager getLm() {
        return lm;
    }

    public void setLm(LocationManager lm) {
        this.lm = lm;
    }



}