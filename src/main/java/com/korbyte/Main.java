package com.korbyte;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("Hello world!");

        AlphaVantageConfig config = new AlphaVantageConfig();


        AlphaVantageClient client = new AlphaVantageClient(config);
        client.getDaily("MSFT");

    }
}