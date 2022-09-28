package com.example.pp_3_1_5_rest_api.controller;

import com.example.pp_3_1_5_rest_api.model.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Connection {

    private static final String URL = "http://94.198.50.185:7081/api/users";

    RestTemplate template = new RestTemplate();
    private List<String> cookies;

    public void getUsers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        cookies = template.exchange(URL, HttpMethod.GET, entity, String.class).getHeaders().get("Set-Cookie");
    }

    public String createUser(User user){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return template.exchange(URL, HttpMethod.POST, entity, String.class).getBody();
    }

    public String updateUser(User user){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));
        HttpEntity<User> entity = new HttpEntity<>(user, headers);
        return template.exchange(URL, HttpMethod.PUT, entity, String.class).getBody();
    }

    public String deleteUser(Long id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("Cookie",cookies.stream().collect(Collectors.joining(";")));
        HttpEntity<User> entity = new HttpEntity<>(headers);
        return template.exchange(URL+"/"+id, HttpMethod.DELETE, entity, String.class).getBody();
    }
}
