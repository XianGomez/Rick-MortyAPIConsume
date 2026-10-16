package org.iesteis;

import org.iesteis.model.Response;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        readAPIRest();
    }

    static void readAPIRest() {
        ObjectMapper mapper = new ObjectMapper();
        HttpClient client = HttpClient.newHttpClient();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://rickandmortyapi.com/api/character"))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());

            Response r = mapper.readValue(response.body(), Response.class);
            r.getCharacters().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
