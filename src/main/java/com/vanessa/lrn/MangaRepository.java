package com.vanessa.lrn;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MangaRepository
        extends JpaRepository<Manga, Long> {
    Manga findByTitle(String title);
}