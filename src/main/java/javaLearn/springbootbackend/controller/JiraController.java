package javaLearn.springbootbackend.controller;

import javaLearn.springbootbackend.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<String> getIssue(@PathVariable String issueKey) {
        String a="yen";
        System.out.print(a);
        return jiraService.getIssue(issueKey);

    }
}
