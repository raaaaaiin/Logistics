/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Cargo{
    
    private int id;
    private String s_name;
    private String r_name;
    private String trackingno;
    private String typeofcargo;
    private String origin;
    private String destination;

public Cargo(int Id, String Sendername, String Recievername, String Trackingno, String Typeofcargo, String Origin, String Destination) {
    this.id = Id;
        this.s_name = Sendername;
        this.r_name = Recievername;
        this.trackingno = Trackingno;
        this.typeofcargo = Typeofcargo;
        this.origin = Origin;
        this.destination = Destination;
        
    }

    Cargo(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getId(){
        return id;
    }
    public String getSendername(){
        return s_name;
    }
    public String getRecievername(){
        return r_name;
    }
    public String getTrackingno(){
        return trackingno;
    }
    public String getTypeofcargo(){
        return typeofcargo;
    }
    public String getOrigin(){
        return origin;
    }
    public String getDestination(){
        return destination;
    }
}
