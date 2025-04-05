package com.spring.project.repositories;

import com.spring.project.entities.Link;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LinkRepository extends JpaRepository<Link, UUID> {
    Link findByLink(String link);
}
