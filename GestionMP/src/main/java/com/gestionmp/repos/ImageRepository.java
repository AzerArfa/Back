package com.gestionmp.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gestionmp.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}
