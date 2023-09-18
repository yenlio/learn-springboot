package javaLearn.springbootbackend.controller;

import javaLearn.springbootbackend.model.IssueDTO;
import javaLearn.springbootbackend.service.JiraService;
import javaLearn.springbootbackend.service.impl.JiraServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jira")
public class JiraController {
    @Autowired
    private JiraService jiraService;

    @GetMapping("/issue/{issueKey}")
    public ResponseEntity<IssueDTO> getIssue(@PathVariable String issueKey) {
        return jiraService.getIssue(issueKey);

    }
}
