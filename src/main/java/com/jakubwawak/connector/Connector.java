/*
Jakub Wawak
kubawawak@gmail.com
all rights reseved
 */
package com.jakubwawak.connector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jakubwawak.ui_maintenance.message_window;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JFrame;


/**
 *Object for maintaining connection to server
 * @author kubaw
 */
public class Connector {
    
    public boolean health;
    public Date ldt;
    public boolean error;
    public String version,bulid;
    String server_ip;
    /**
     * Constructor
     * @param oauth 
     */
    public Connector(String server_ip){
        this.server_ip = server_ip;
        ldt = new Date();
        error = false;
    }
    
    /**
     * Function for resetting 
     * @param url
     * @return String
     */
    public String url_builder(String url){
        //return "http://"+server_ip+":8080"+url;
        return url;
    }
    
    /**
     * Function for preparing raw JSON
     * @param url
     * @return JsonElement
     * @throws UnirestException 
     */
    public JsonElement commit(String url,JFrame object) throws UnirestException{
        HttpResponse<JsonNode> response = response_creator(url);
        System.out.println("Trying to commit url:"+url);
        Parser parser = new Parser(parse_response(response));
        try{
            if ( parser == null ){
                new message_window(object,true,"Connection error...","");
                System.exit(0);
            }
        }catch(Exception e){
            System.out.println("CONNECTOR ERROR: "+e.toString());
        }
        return parse_response(response);
    }
    

    
    /**
     * Function for parasing response for data
     * @param data
     * @return JsonElement
     */
    JsonElement parse_response(HttpResponse<JsonNode> data){
        System.out.println("Parasing response for data");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        return jp.parse(data.getBody().toString());
    }
    /**
     * Function for preparing raw JSON
     * @param url
     * @return JsonElement
     * @throws UnirestException 
     */
    public JsonElement commit(String url,JDialog object) throws UnirestException{
        HttpResponse<JsonNode> response = response_creator(url);
        System.out.println("Trying to commit url:"+url);
        Parser parser = new Parser(parse_response(response));
        try{
            if ( parser == null ){
                new message_window(object,true,"Connection error...","");
                System.exit(0);
            }
            
            
        }catch(Exception e){
            System.out.println("CONNECTOR ERROR: "+e.toString());
        }
        return parse_response(response);
    }
    
    /**
     * Function for creating response
     * @param url
     * @return String
     * @throws UnirestException 
     */
    HttpResponse<JsonNode> response_creator(String url) throws UnirestException{
        try{
            System.out.println("Creating response ("+url_builder(url)+")");
            return Unirest.get(url_builder(url)).asJson();
        }catch(UnirestException e){
            System.out.println("Failed to create response ("+e.toString());
            return null;
        }
    } 
    
}
