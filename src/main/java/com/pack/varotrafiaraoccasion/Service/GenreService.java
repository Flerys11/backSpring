package com.pack.varotrafiaraoccasion.Service;

import com.pack.varotrafiaraoccasion.Entity.Genre;
import com.pack.varotrafiaraoccasion.Repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GenreService {
    GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository){
        this.genreRepository=genreRepository;
    }

    public java.util.List<Genre> findAll(){
        return genreRepository.findAll();
    }

    public Genre findOne(Long idGenre ){
        return genreRepository.findOne(idGenre).get();
    }

    public void delete(Long idGenre){
        genreRepository.deleteById(idGenre);
    }

    public void update(Genre table){
        genreRepository.save(table);
    }
}
