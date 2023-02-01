/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Views{
    
    private int id;
    private String s_name,s_phone,s_email,s_address,r_phone,r_email,r_address,weight,depttime,pickupdate,pickuptime;
    private String r_name;
    private String trackingno;
    private String typeofcargo;
    private String origin;
    private String destination;
   
public Views(int Id, String Sendername, String Pickuptime,String Pickupdate,String Depttime,String Weight, String RecieverAddress, String Senderphone,String SenderEmail,String SenderAddress,String Recieverphone,String RecieverEmail,  String Recievername, String Trackingno, String Typeofcargo, String Origin, String Destination) {
        this.id = Id;
        this.s_name = Sendername;
        this.s_phone = Senderphone;
        this.s_email = SenderEmail;
        this.s_address = SenderAddress;
        this.r_name = Recievername;
        this.r_phone = Recieverphone;
        this.r_email = RecieverEmail;
        this.r_address = RecieverAddress;
        this.trackingno = Trackingno;
        this.typeofcargo = Typeofcargo;
        this.weight = Weight;
        this.depttime = Depttime;
        this.origin = Origin;
        this.destination = Destination;
        this.pickupdate = Pickupdate;
        this.pickuptime = Pickuptime;
        
    }

    public int getId(){
        return id;
    }
    public String getSendername(){
        return s_name;
    }
    public String getSenderphone(){
        return s_phone;
    }
    public String getSenderemail(){
        return s_email;
    }
    public String getSenderaddress(){
        return s_address;
    }
    public String getRecievername(){
        return r_name;
    }
    public String getRecieverphone(){
        return r_phone;
    }
    public String getRecieveremail(){
        return r_email;
    }
    public String getRecieveraddress(){
        return r_address;
    }
    public String getTrackingno(){
        return trackingno;
    }
    public String getTypeofcargo(){
        return typeofcargo;
    }
    public String getWeight(){
        return weight;
    }
    public String getDepttime(){
        return depttime;
    }
    public String getOrigin(){
        return origin;
    }
    public String getDestination(){
        return destination;
    }
    public String getPickupdate(){
        return pickupdate;
    }
    public String getPickuptime(){
        return pickuptime;
    }
}
