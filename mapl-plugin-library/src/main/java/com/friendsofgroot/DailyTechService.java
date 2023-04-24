package com.friendsofgroot;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;

import java.io.IOException;

public class DailyTechService {
    public static final String AMAZONAWS_COM_DEV_POSTS = "https://z3noflrq9b.execute-api.us-east-1.amazonaws.com/dev/posts";
    private ObjectMapper objectMapper = new ObjectMapper();

    public JsonNode getWebPage() throws IOException {
        HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(AMAZONAWS_COM_DEV_POSTS));
        String response =  request.execute().parseAsString();

        return objectMapper.readValue(response, JsonNode.class);
    }
}
