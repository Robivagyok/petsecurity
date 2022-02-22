package hu.kisallatokSecurity.services;

import hu.kisallatokSecurity.domain.Owner;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class OwnerService {


    @Autowired
    private RestTemplate restTemplate;

    private final String REST_URL = "http://localhost:8070/owners";

    public int newOwner(String name, String address) {
        String url = REST_URL;
        Owner owner =new Owner(name, address);
        HttpEntity<Owner> requestEntity = new HttpEntity<>(owner);
        ResponseEntity<Owner> responseEntity = restTemplate.exchange(url, HttpMethod.POST, requestEntity,Owner.class);
        return responseEntity.getStatusCodeValue();

    }

    public List<Owner> getOwners() {
            String url = REST_URL;
            Owner[] owners = restTemplate.getForObject(url, Owner[].class);
            return Arrays.asList(owners);

        }

    public Owner getOwner(int ownerid) {
        String url = REST_URL+"/{id}";
        return restTemplate.getForObject(url, Owner.class, ownerid);
    }

    public int updateOwner(int id, String address) {
        String url = REST_URL+"/{id}";
        Owner owner = restTemplate.getForObject(url, Owner.class, id);
        owner.setAddress(address);
        CloseableHttpClient client = HttpClientBuilder.create().build();
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory(client));
        HttpEntity<Owner> requestEntity = new HttpEntity<>(owner);
        ResponseEntity<Owner> responseEntity = restTemplate.exchange(url, HttpMethod.PATCH, requestEntity, Owner.class);
        return responseEntity.getStatusCodeValue();
    }
}

