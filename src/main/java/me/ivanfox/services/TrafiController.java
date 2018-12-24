package me.ivanfox.services;


import static me.ivanfox.utils.JsonSerializer.JSON_SERIALIZER;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import me.ivanfox.messages.DeparturesResponse;
import me.ivanfox.utils.TallinnStopConstants;

public class TrafiController {

    private static final String API_KEY = "c422987bfd3f83bae1694a4c3fe42129";


    private static final String BASE_URL = "http://api-ext.trafi.com";
    private static final String DEPARTURES_ENDPOINT = "/departures?stop_id=%s&region=tallinn&api_key=" + API_KEY;


    private final static Client CLIENT = ClientBuilder.newClient();

    public static DeparturesResponse findMajakaToCentr() {
        String rawResponse = CLIENT.target(
                BASE_URL + String.format(DEPARTURES_ENDPOINT, TallinnStopConstants.MAJAKA_POIK_TOWARDS_AIRPORT_ID)
            ).request(MediaType.APPLICATION_JSON)
            .get(String.class);

        return JSON_SERIALIZER.fromJson(rawResponse, DeparturesResponse.class);

    }


    public static void main(String[] args) {
        findMajakaToCentr();
    }
}
