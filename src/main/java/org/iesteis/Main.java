package org.iesteis;

import org.iesteis.model.Personaje;
import org.iesteis.model.Response;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Main {
    static void main() {
        buscarPorGenero(readAPIRest().getCharacters(), "Female");
        buscarPorOrigen(readAPIRest().getCharacters(), "Earth (C-137)");
    }

    static Response readAPIRest() {
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

            return mapper.readValue(response.body(), Response.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void buscarPorGenero(List<Personaje> personajes, String genero) {
        personajes.stream()
                .filter(p -> p.getGender() != null && p.getGender().equalsIgnoreCase(genero))
                .forEach(System.out::println);
    }

    public static void buscarPorOrigen(List<Personaje> personajes, String origen) {
        personajes.stream()
                .filter(p -> p.getOrigin() != null
                        && p.getOrigin().getName() != null
                        && p.getOrigin().getName().equalsIgnoreCase(origen))
                .forEach(System.out::println);
    }
}
