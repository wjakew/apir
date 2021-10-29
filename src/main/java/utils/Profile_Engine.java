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
    public ArrayList<String> raw_lines;
    public final String PROFILES_SRC = "profiles.apir"; 
    public boolean new_file,error;
    public boolean empty;
    public Profile selected_profile;
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
     * Function for dumping data to file
     * @throws IOException 
     */
    void dump_data_to_file() throws IOException{
        FileWriter file = new FileWriter(PROFILES_SRC);
        for(Profile profile : list_profiles){
            file.write(profile.profile_string()+"\n");
        }
        file.close();
    }
    
    /**
     * Function for loading data from file
     */
    public void load_from_file() throws IOException{
        File file = new File(PROFILES_SRC);
        if (file.exists()){
            BufferedReader reader = new BufferedReader(new FileReader(PROFILES_SRC));
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
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
    public void parse(){
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
    public void add_profile(Profile to_add) throws IOException{
        list_profiles.add(to_add);
        dump_data_to_file();
    }
    
    /**
     * Function for getting last profile object
     * @return Profile
     */
    public Profile get_last(){
        return list_profiles.get(list_profiles.size()-1);
    }
    
    /**
     * Function for removing profiles from object
     * @param to_remove
     * @throws IOException 
     */
    public void remove_profile(Profile to_remove) throws IOException{
        list_profiles.remove(to_remove);
        dump_data_to_file();
    }
    
    public void remove_profile(int profile_index) throws IOException{
        list_profiles.remove(list_profiles.get(profile_index));
        dump_data_to_file();
    }
}
