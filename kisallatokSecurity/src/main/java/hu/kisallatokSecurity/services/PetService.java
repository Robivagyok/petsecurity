package hu.kisallatokSecurity.services;

import hu.kisallatokSecurity.domain.Owner;
import hu.kisallatokSecurity.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PetService {

    @Autowired
    private RestTemplate restTemplate;
    private final String REST_URL = "http://localhost:8070/pets";

    public List<Pet> getPets() {
        String url=REST_URL;
        Pet[] pets = restTemplate.getForObject(url,Pet[].class);
        return Arrays.asList(pets);
    }

    public int addPets(String race, String name, int age, int ownerId) {
        String url = REST_URL;
        Owner owner = new Owner(ownerId);
        HttpEntity<Pet> requestEntity = new HttpEntity<>(new Pet(race,name,age,owner));
        ResponseEntity<Pet> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity, Pet.class);
        return responseEntity.getStatusCodeValue();
    }
}
