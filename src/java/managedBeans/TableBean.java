/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;



import Kommunikation.LookUp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import entities.Hotels;
import interfaces.IHotelService;
import java.io.IOException;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.NoneScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.naming.NamingException;


@Named(value="TableBean")
@ManagedBean
@SessionScoped
public class TableBean implements Serializable {

    private List<TableBean.ColumnModel> columns;
    private List<Hotels> hotels;

    private String columnName;

    public TableBean() throws NamingException, NamingException, IOException {
        createDynamicColumns();
       //addHotels();
    }

    public void addHotels() throws NamingException, IOException {
        
        System.out.println("addHotels");
        
        hotels = new ArrayList<Hotels>();
       
        IHotelService dienst = (IHotelService) new LookUp().doLookUp("java:global/HotelService-ejb/HotelService");
         hotels = Arrays.asList(dienst.getMatchingHotels().toArray(new Hotels[0]));
        
        
        
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
}