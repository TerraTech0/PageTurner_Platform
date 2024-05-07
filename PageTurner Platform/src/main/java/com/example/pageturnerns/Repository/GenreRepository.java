package com.example.pageturnerns.Repository;

import com.example.pageturnerns.Model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {
    Genre findGenreByTitle(String title);
    Genre findGenreByGenreID(Integer genreId);
    Genre findByTitle(String title);
}
