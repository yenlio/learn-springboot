package javaLearn.springbootbackend.service;

//import javaLearn.springbootbackend.model.Issue;
import javaLearn.springbootbackend.model.IssueDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface JiraService {
    ResponseEntity<IssueDTO> getIssue(String issueKey);
}

