package com.spring.project.controllers;

import com.spring.project.dto.LinkDTO;
import com.spring.project.entities.Link;
import com.spring.project.services.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class LinkController {

    @Autowired
    private LinkService linkService;

    @GetMapping("/link/{link}")
    public ResponseEntity<HashMap<String, String>> getLink(@PathVariable String link) {
        return linkService.findByLink(link)
                .map(link1 -> {
                    HashMap<String, String> response = new HashMap<>();
                    response.put("url", link1.getTarget());

                    return ResponseEntity.ok(response);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public LinkDTO createLink(@RequestParam String url) {
        Link link = linkService.create(url);

        return new LinkDTO(link.getLink(), link.getTarget());
    }
}
