/*
Jakub Wawak
kubawawak@gmail.com
all rights reseved
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Object for storing saved profiles
 * @author Jakub Wawak
 */
public class Profile_Engine {
    
    public ArrayList<Profile> list_profiles;
    ArrayList<String> raw_lines;
    final String PROFILES_SRC = "profiles.apir"; 
    boolean new_file,error;
    boolean empty;
    Profile selected_profile;
    /**
     * Constructor
     */
    public Profile_Engine(){
        list_profiles = new ArrayList<>();
        raw_lines = new ArrayList<>();
        new_file = false;
        error = false;
        empty = false;
    }
    
    /**
     * Function for creating file of profiles
     * @throws IOException 
     */
    void create_profile_file() throws IOException{
        FileWriter file = new FileWriter(PROFILES_SRC);
        file.write("");
        file.close();
        new_file = true;
    }
    
    /**
     * Function for loading data from file
     */
    public void load_from_file() throws IOException{
        File file = new File(PROFILES_SRC);
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(PROFILES_SRC));
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                raw_lines.add(line);
            }
        }
        else{
            create_profile_file();
        }
    }
    
    /**
     * Function for parsing 
     */
    void parse(){
        for(String line : raw_lines){
            Profile profile = new Profile();
            try{
                profile.parse(line);
                list_profiles.add(profile);
            }catch(Exception e){}
        }
    }
    
    /**
     * Function for adding profiles to object
     * @param to_add 
     */
    public void add_profile(Profile to_add){
        list_profiles.add(to_add);
    }
}
