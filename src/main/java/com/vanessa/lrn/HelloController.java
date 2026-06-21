package com.vanessa.lrn;

import com.vanessa.lrn.dto.MangaRequest;
import com.vanessa.lrn.dto.MangaResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

@RestController
public class HelloController {

    @Autowired
    private MangaService mangaService;
    @Autowired
    private MangaRepository mangaRepository;

    @PostMapping
    public MangaResponse addManga(
            @Valid @RequestBody MangaRequest request){

        Manga manga = new Manga();

        manga.setTitle(request.getTitle());
        manga.setVolume(request.getVolume());
        manga.setAuthor(request.getAuthor());
        manga.setPrice(request.getPrice());

        Manga savedManga = mangaRepository.save(manga);

        return new MangaResponse(
                savedManga.getId(),
                savedManga.getTitle(),
                savedManga.getVolume(),
                savedManga.getAuthor(),
                savedManga.getPrice()
        );
    }

    @GetMapping
    public ResponseEntity<Page<MangaResponse>>
    getAllMangas(

            @RequestParam(defaultValue = "0")
            int page,

            @RequestParam(defaultValue = "5")
            int size,

            @RequestParam(defaultValue = "title")
            String sortBy
    ) {

        return ResponseEntity.ok(

                mangaService.getAllMangas(
                        page,
                        size,
                        sortBy
                )
        );
    }
    @PutMapping("/manga/{id}")
    public ResponseEntity<Manga> updateManga(

            @PathVariable Long id,

            @RequestBody Manga mangaObj
    ) {

        Manga updatedManga =
                mangaService.updateManga(
                        id,
                        mangaObj);

        if (updatedManga != null) {

            return ResponseEntity.ok(
                    updatedManga);
        }

        return ResponseEntity.notFound()
                .build();
    }
    @DeleteMapping("/manga/{id}")
    public ResponseEntity<String> deleteManga(
            @PathVariable Long id
    ){

        boolean deleted = mangaService.deleteManga(id);

        if(deleted){
            return ResponseEntity.ok("Manga Deleted");
        }

        return ResponseEntity.notFound().build();
    }
    @GetMapping("/manga/{title}")
    public ResponseEntity<Manga> findByTitle(
            @PathVariable String title
    ){
        Manga mangaObj =
                mangaService.getMangaByTitle(title);

        if (mangaObj == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mangaObj);
    }
    @GetMapping("/manga/{id}")
    public ResponseEntity<Manga> findById(
            @PathVariable Long id
    ){
        Optional<Manga> mangaOpt =
            mangaService.getMangaById(id);

        if(mangaOpt.isPresent()){

            return ResponseEntity.ok(mangaOpt.get());
        }

        return ResponseEntity.notFound().build();
    }
}