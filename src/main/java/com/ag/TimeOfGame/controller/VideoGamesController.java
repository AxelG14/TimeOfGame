package com.ag.TimeOfGame.controller;

import com.ag.TimeOfGame.entity.VideoGames;
import com.ag.TimeOfGame.service.VideoGamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("videogames") // http://localhost:8080/videogames
@CrossOrigin(value = "http://localhost:4200") // Permitir solicitudes desde el puerto 4200
public class VideoGamesController {
    @Autowired
    private VideoGamesService videoGamesService;

    @GetMapping("/games") // http://localhost:8080/videogames/games
    public List<VideoGames> getVideoGames() {
        return videoGamesService.GameList();
    }

    @GetMapping("/games/{id}") // http://localhost:8080/videogames/games/1
    public VideoGames getVideoGameById(@PathVariable Integer id) {
        return videoGamesService.GameById(id);
    }

    @PostMapping("/games") // http://localhost:8080/videogames/games
    public VideoGames saveVideoGame(@RequestBody VideoGames videoGame) {
        return videoGamesService.SaveGame(videoGame);
    }

    @PutMapping("/games/{id}") // http://localhost:8080/videogames/games/1
    public ResponseEntity<VideoGames> updateVideoGame(@PathVariable Integer id, @RequestBody VideoGames videoGameDetails) {
        VideoGames videoGame = videoGamesService.GameById(id);
        if (videoGame != null) {
            videoGame.setName(videoGameDetails.getName());
            videoGame.setRelease_date(videoGameDetails.getRelease_date());
            videoGame.setPlatform(videoGameDetails.getPlatform());
            videoGame.setImage_url(videoGameDetails.getImage_url());
            videoGame.setLink(videoGameDetails.getLink());
            this.videoGamesService.SaveGame(videoGame);
            return ResponseEntity.ok(videoGame);
        } else {
            return ResponseEntity.notFound().build();
        }
        }

    @DeleteMapping("/games/{id}") // http://localhost:8080/videogames/games/1
    public ResponseEntity<Map<String, Boolean>> deleteVideoGame(@PathVariable Integer id) {
        VideoGames videoGame = videoGamesService.GameById(id);
        if (videoGame != null) {
            videoGamesService.DeleteGame(videoGame.getId());
            return ResponseEntity.ok(Map.of("deleted", Boolean.TRUE));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
