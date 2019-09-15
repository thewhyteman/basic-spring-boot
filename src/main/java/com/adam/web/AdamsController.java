package com.adam.web;

import com.adam.web.model.WebsiteGreeting;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class AdamsController {


    private List<WebsiteGreeting> websiteGreeting;

    @PostConstruct
    public void setUp(){
        this.websiteGreeting=new ArrayList<>();

        WebsiteGreeting websiteGreeting1 = new WebsiteGreeting();
        websiteGreeting1.setId(1);
        websiteGreeting1.setMessage("This is Sparta");

        WebsiteGreeting websiteGreeting2 = new WebsiteGreeting();
        websiteGreeting2.setId(2);
        websiteGreeting2.setMessage("No this is Patrick");

        this.websiteGreeting.add(websiteGreeting1);
        this.websiteGreeting.add(websiteGreeting2);
    }

    @RequestMapping(value = "/greetings/{id}",method = GET)
    public String getWebSiteGreeting(@PathVariable int id) {

        for(WebsiteGreeting websiteGreeting1 : this.websiteGreeting) {
            if (websiteGreeting1.getId() == id) {
                return websiteGreeting1.getMessage();
            }
        }
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/greetings",method = POST)
    public ResponseEntity createWebSiteGreeting(@RequestBody WebsiteGreeting websiteGreetingObject) throws IOException {
        websiteGreeting.add(websiteGreetingObject);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
