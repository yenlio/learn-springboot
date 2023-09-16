package javaLearn.springbootbackend.service.impl;

import javaLearn.springbootbackend.service.JiraService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



import java.util.Arrays;
import java.util.List;
@Service
public class JiraServiceImpl implements JiraService {

    @Value("${jira.username}")
    private String username;

    @Value("${jira.apiToken}")
    private String apiToken;

    @Value("${jira.baseUrl}")
    private String baseUrl;

    RestTemplate restTemplate = new RestTemplate();


    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, apiToken);
        return headers;
    }

    @Override
    public ResponseEntity<String> getIssue(String issueKey) {
        HttpHeaders headers = createHeaders();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                baseUrl + "issue/" + issueKey,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                String.class
        );

       return (ResponseEntity<String>) responseEntity;

    }
}