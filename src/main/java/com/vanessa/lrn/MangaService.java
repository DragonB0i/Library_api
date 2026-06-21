package com.vanessa.lrn;
import com.vanessa.lrn.dto.MangaRequest;
import com.vanessa.lrn.dto.MangaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

@Service
public class MangaService {
    @Autowired
    private MangaRepository mangaRepository;


    public MangaResponse addManga(
            MangaRequest request
    ) {

        Manga manga = new Manga();

        manga.setTitle(request.getTitle());
        manga.setAuthor(request.getAuthor());

        Manga savedManga =
                mangaRepository.save(manga);

        return new MangaResponse(
                savedManga.getId(),
                savedManga.getTitle(),
                savedManga.getVolume(),
                savedManga.getAuthor(),
                savedManga.getPrice()
        );
    }

    public Page<MangaResponse> getAllMangas(
            int page,
            int size,
            String sortBy
    ) {

        Pageable pageable =
                PageRequest.of(
                        page,
                        size,
                        Sort.by(sortBy)
                );

        Page<Manga> mangaPage =
                mangaRepository.findAll(pageable);

        return mangaPage.map(manga ->

                new MangaResponse(

                        manga.getId(),

                        manga.getTitle(),

                        manga.getVolume(),

                        manga.getAuthor(),

                        manga.getPrice()
                )
        );
    }
    public boolean deleteManga(Long id){

        if(mangaRepository.existsById(id)){

            mangaRepository.deleteById(id);

            return true;
        }
        return false;
    }
    public Manga getMangaByTitle(String title){
        return mangaRepository.findByTitle(title);
    }
    public Optional<Manga> getMangaById(Long id){

        return mangaRepository.findById(id);
    }
    public Manga updateManga(Long id, Manga updatedManga) {

        Optional<Manga> mangaOpt =
                mangaRepository.findById(id);

        if (mangaOpt.isPresent()) {

            Manga existingManga =
                    mangaOpt.get();

            existingManga.setTitle(
                    updatedManga.getTitle());

            existingManga.setAuthor(
                    updatedManga.getAuthor());

            existingManga.setVolume(
                    updatedManga.getVolume());

            existingManga.setPrice(
                    updatedManga.getPrice());

            return mangaRepository.save(
                    existingManga);
        }

        return null;
    }
}

