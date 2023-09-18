package javaLearn.springbootbackend.service.impl;


import javaLearn.springbootbackend.model.IssueDTO;
import javaLearn.springbootbackend.service.JiraService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
public class JiraServiceImpl implements JiraService {

    @Value("${jira.username}")
    private String username;

    @Value("${jira.api-token}")
    private String apiToken;

    @Value("${jira.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();


    private HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBasicAuth(username, apiToken);
        return headers;
    }

    @Override
    public ResponseEntity<IssueDTO> getIssue(String issueKey) {
        HttpHeaders headers = createHeaders();
        ResponseEntity<IssueDTO> responseEntity = restTemplate.exchange(
                baseUrl + "/rest/api/2/issue/" + issueKey,
                HttpMethod.GET,
                new HttpEntity<>(headers),
                IssueDTO.class
        );

        IssueDTO issue = responseEntity.getBody();
        if (issue !=null){
            IssueDTO issueDTO=new IssueDTO();
            issueDTO.setId(issue.getId());
            issueDTO.setKey(issue.getKey());
            issueDTO.setSelf(issue.getSelf());

            return ResponseEntity.ok(issueDTO);
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }
}