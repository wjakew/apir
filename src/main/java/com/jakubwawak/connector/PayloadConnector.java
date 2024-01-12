/**
 * by Jakub Wawak
 * kubawawak@gmail.com
 * all rights reserved
 */
package com.jakubwawak.connector;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import utils.JSONParser;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.client.config.RequestConfig;
import java.util.ArrayList;

/**
 * Object for generating requests to Ollama API - sync version
 */
public class PayloadConnector {

    public ArrayList<String> apiConnectorRequestHistory; // collection for storing request history
    public int streamFlag;

    String payload="{\"model\":\">\",\"prompt\":\"<\",\"stream\":?}";
    public String requestUrl;

    /**
     * Constructor
     */
    public PayloadConnector(String requestUrl){
        this.requestUrl = requestUrl;
        apiConnectorRequestHistory = new ArrayList<>();
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
     * @return JsonElement
     * @throws UnirestException
     */
    public JsonElement commit(String payload) {
        try{
        // Create a new Unirest instance
        Unirest unirest = new Unirest();
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30 * 1000).build();

        // Create a POST request with payload
        HttpResponse<JsonNode> response = unirest.post(requestUrl)
                .header("Content-Type", "application/json")
                .body(payload)
                .asJson();
        System.out.println("Trying to commit to: " + requestUrl + "with payload: "+payload);
        JSONParser JSONParser = new JSONParser(parse_response(response));

            if ( JSONParser == null ){
                System.out.println("Connection error...");
                return null;
            }
            else{
                apiConnectorRequestHistory.add(new JSONParser(parse_response(response)).raw_data);
                return parse_response(response);
            }
        }catch(Exception e){
            System.out.println("CONNECTOR ERROR: "+e.toString());
            return null;
        }
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
}