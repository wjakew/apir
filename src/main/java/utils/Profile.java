/*
Jakub Wawak
kubawawak@gmail.com
all rights reseved
 */
package utils;

import java.util.ArrayList;

/**
 *Object for storing profiles of APIR
 * @author Jakub Wawak
 */
public class Profile {
    
    /**
     * FILE SCHEMA:
     * profile_name!profile_url!profile_health_connection_url!profile_special_data#profile_special_data#profile_special_data
     */
    
    public String profile_name;
    public String profile_url;
    public String profile_health_connection_url;
    public ArrayList<String> profile_special_data;
    public boolean error;
    
    /**
     * Main constructor
     */
    public Profile(){
        profile_name = "";
        profile_url = "";
        profile_health_connection_url = "";
        profile_special_data = new ArrayList<>();
        error = false;
    }
    
    /**
     * Constructor with parser
     * @param file_line 
     */
    public Profile(String file_line){
        profile_name = "";
        profile_url = "";
        profile_health_connection_url = "";
        profile_special_data = new ArrayList<>();
        error = false;
    }
    
    /**
     * Function for checking if object data is empty 
     * @return boolean
     */
    public boolean isEmpty(){
        return profile_name.equals("");
    }
    
    /**
     * Function for parsing line
     * @param line 
     */
    public void parse(String line){
        String[] elements = line.split("!");
        if ( elements.length == 4){
            profile_name = elements[0];
            profile_url = elements[1];
            profile_health_connection_url = elements[2];
            profile_special_data = new ArrayList<>();
            String [] profile_data = elements[3].split("#");
            for(String words : profile_data){
                profile_special_data.add(words);
            }
        }
        else{
            error = true;
        }
    }
    
    /**
     * Function for getting string of profile special data
     * @return String
     */
    String data_string(){
        String data = "";
        for(String object : profile_special_data){
            data = data + object+"#";
        }
        data = data.substring(0, data.length()-1);
        return data;
    }
    
    /**
     * Function for creating profile string for file
     * @return String
     */
    public String profile_string(){
        return profile_name+"!"+profile_url+"!"+profile_health_connection_url+"!"+data_string();
    }
    
    /**
     * Function for showing object internal data
     */
    public void show(){
        String data = "Profile: "+ profile_name+"\n";
        if ( error )
            data = data + "error!\n";
        data = data + profile_url + "\n" + profile_health_connection_url+"\n";
        data = data + "Profile special data: \n";
        for(String element: profile_special_data){
            data = data + element + "\n";
        }
        data = data + "end.";
        
        System.out.println(data);
    }
}
