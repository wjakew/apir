/*
by Jakub Wawak
all rights reserved - JW 2021
kubawawak@gmail.com
 */
package com.jakubwawak.apir;

import com.formdev.flatlaf.FlatDarkLaf;
import com.jakubwawak.ui_maintenance.profile_picker_window;
import java.io.IOException;
import utils.Profile_Engine;

/**
 *Main object of the program
 * @author Jakub Wawak
 */
public class Apir {
    
    final static String version = "1.3.0";
    final static String build_number = "APIR-120124REV1";
    final static int debug = 0;
    
    
    /**
     * Main function
     * @param args 
     */
    public static void main(String[] args) throws IOException{
        FlatDarkLaf.setup();
        show_header();
        if ( debug == 1 ){
            System.out.println("Debug flag is 1. Starting debug");
            Tests tests = new Tests();
            tests.run();
        }
        else{
            System.out.println("Starting program in normal mode.");
            Profile_Engine profile_engine = new Profile_Engine();
            profile_engine.load_from_file();
            profile_engine.parse();
            new profile_picker_window(null,true,profile_engine,build_number);
        }
    }
    
    /**
     * Function for showing header
     */
    static void show_header(){
        String header = "             _ ____\n" +
                        "  __ _ _ __ (_)  _ \\\n" +
                        " / _` | '_ \\| | |_) |\n" +
                        "| (_| | |_) | |  _ <\n" +
                        " \\__,_| .__/|_|_| \\_\\\n" +
                        "      |_| " +version+"("+build_number+")";
        System.out.println(header);
    }
    
}
