/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SaloonCustomer;

/**
 *
 * @author User
 */
public class Beauty{
 private String name,phone,address,date;
 
    final private String id;
    
    Beauty(String id,String name,String phone,String address,String date){
        this.id=id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.date = date;
       
    }
    void setname(String name){
        this.name = name;    
    }
    void setphone(String phone){
        this.phone = phone;
    }
    void setaddress(String address){
        this.address = address;
    }
    void setDate(String date){
        this.date = date;
    }
   
    String getid(){
        return id;
    }
    String getname(){
        return name;
    }
    String getphone(){
        return phone;
    }
     String getaddress(){
        return address;
    }
    String getdate(){
        return date;
    }
   
}
