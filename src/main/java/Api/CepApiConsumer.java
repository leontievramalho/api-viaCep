package Api;

import Model.Address;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class CepApiConsumer {
    public static Address getAddress(String cep) throws IOException, InterruptedException {

        // configura a url da api
        var url = "https://viacep.com.br/ws/".concat(cep).concat("/json/");

        // cria o request (pedido)
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(url))
                .build();

        // cria o client (pidão)
        var httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        // o client faz o request e armazena a resposta na variável response
        var response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        //Gson converte o objeto string para classe Address
        var gson = new Gson();
        var address = gson.fromJson(response.body(), Address.class);
        return address;
    };
}
