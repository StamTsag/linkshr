package com.spring.project.services;

import com.spring.project.entities.Link;
import com.spring.project.repositories.LinkRepository;
import com.spring.project.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LinkService {
    @Autowired
    private LinkRepository linkRepository;



    public Link create(String target) {
        String code;

        // Avoid duplicates
        do {
            code = Utils.generateCode();
        } while (linkRepository.findByLink(code) != null);

        Link link = new Link();
        link.setLink(code);
        link.setTarget(target);

        return linkRepository.save(link);
    }

    public Optional<Link> findByLink(String link) {
        return Optional.ofNullable(linkRepository.findByLink(link));
    }
}
