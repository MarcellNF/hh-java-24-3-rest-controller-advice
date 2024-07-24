package de.neuefische.hhjava243restcontrolleradvice;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;

@org.springframework.stereotype.Service
public class CharacterService {

    private final RestClient rc = RestClient.builder().baseUrl("https://api.sampleapis.com/futurama").build();

    public FuturRamaCharacter getCharacter(int id) {
        var charResponse = rc.get()
                .uri("/characters/" + id)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, (response, error) -> {
                    throw new NoSuchCharacterException("Character not found with id " + id);
                });

        return charResponse.body(FuturRamaCharacter.class);
    }

}
