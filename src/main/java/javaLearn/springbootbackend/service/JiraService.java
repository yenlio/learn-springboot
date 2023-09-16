package javaLearn.springbootbackend.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface JiraService {
    ResponseEntity<String> getIssue(String issueKey);
}

