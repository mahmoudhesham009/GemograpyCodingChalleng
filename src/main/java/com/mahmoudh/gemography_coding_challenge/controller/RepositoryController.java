package com.mahmoudh.gemography_coding_challenge.controller;


import com.mahmoudh.gemography_coding_challenge.service.RepoService;
import com.mahmoudh.gemography_coding_challenge.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class RepositoryController {
    RepoService repoService;

    @Autowired
    public void setRepoService(RepoService repoService) {
        this.repoService = repoService;
    }

    @GetMapping("/repo")
    ResponseEntity<List<Language>> getHandler() throws IOException {
        return new ResponseEntity<List<Language>>(repoService.getResult(), HttpStatus.OK);
    }
}
