package com.spring.project.dto;

public class LinkDTO {
    public String link;
    public String href;
    public String target;

    public LinkDTO(String link, String target) {
        this.link = link;
        this.href = "https://linkshr.stamtsag.com/" + link;
        this.target = target;
    }
}
