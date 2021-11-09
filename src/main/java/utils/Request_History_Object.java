/*
Jakub Wawak
kubawawak@gmail.com
all rights reseved
 */
package utils;

/**
 *Object for storing data of urls and responses
 * @author kubaw
 */
public class Request_History_Object {
    public String url;
    public String raw_response;
    
    
    /**
     * Constructor
     */
    public Request_History_Object(String url,String response){
        this.url = url;
        this.raw_response = response;
    }
    
    /**
     * Function for getting glance of the object
     * @return String
     */
    public String show_glance(){
        if (raw_response.length()>30){
            return raw_response.substring(0, 30);
        }
        return raw_response;
    }
    
    
}
