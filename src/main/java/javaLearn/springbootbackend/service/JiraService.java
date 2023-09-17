package javaLearn.springbootbackend.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface JiraService {
    ResponseEntity<String> getIssue(String issueKey);
}

