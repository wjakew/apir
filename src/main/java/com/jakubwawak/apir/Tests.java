/*
Jakub Wawak
kubawawak@gmail.com
all rights reseved
 */
package com.jakubwawak.apir;

import utils.Profile;

/**
 *Object for creating tests
 * @author Jakub Wawak
 */
public class Tests {
    
    /**
     * Object constructor
     */
    public Tests(){
        System.out.println("Tests are running!");
    }
    
    /**
     * Function for running tests
     */
    public void run(){
        Profile profile = new Profile();
        profile.parse("profile_name!profile_url!profile_health_connection_url!profile_special_data#profile_special_data#profile_special_data");
        profile.show();
    }
    
}
