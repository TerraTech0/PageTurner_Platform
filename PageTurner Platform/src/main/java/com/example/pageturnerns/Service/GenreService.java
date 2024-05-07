package com.example.pageturnerns.Service;

import com.example.pageturnerns.Api.ApiException;
import com.example.pageturnerns.Model.Book;
import com.example.pageturnerns.Model.Genre;
import com.example.pageturnerns.Model.User;
import com.example.pageturnerns.Model.Writer;
import com.example.pageturnerns.Repository.AuthRepository;
import com.example.pageturnerns.Repository.GenreRepository;
import com.example.pageturnerns.Repository.WriterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;
    private final WriterRepository writerRepository;
    private final AuthRepository authRepository;


    public List<Genre> getAllGenres(){
        return genreRepository.findAll();
    }

    public void addGenre(Integer adminId, Genre genre){
        User user=authRepository.findUserByUserId(adminId);
        genreRepository.save(genre);
    }

    public void updateGenre( Integer adminId,Integer genreId ,Genre genre){
        Genre genre1= genreRepository.findGenreByGenreID(genreId);
        genre1.setTitle(genre.getTitle());

        genreRepository.save(genre1);
    }

    public void deleteGenre(Integer adminId,Integer genreId){
        Genre genre1= genreRepository.findGenreByGenreID(genreId);
        genreRepository.delete(genre1);
    }

    //18 Reenad
    public List<Book> getBooksByGenre(String genreTitle){
        Genre genre=genreRepository.findByTitle(genreTitle);
        if(genre==null){
            throw new ApiException("Genre not found");
        }
        List<Book> books=new ArrayList<>();
        books.addAll(genre.getBooks());
        return books;

    }


}
