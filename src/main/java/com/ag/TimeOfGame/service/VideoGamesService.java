package com.ag.TimeOfGame.service;

import com.ag.TimeOfGame.entity.VideoGames;
import com.ag.TimeOfGame.repository.VideoGamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoGamesService implements IVideoGamesService {

    @Autowired
    private VideoGamesRepository videoGamesRepository;

    @Override
    public List<VideoGames> GameList() {
        return this.videoGamesRepository.findAll();
    }

    @Override
    public VideoGames GameById(Integer id) {
        return this.videoGamesRepository.findById(id).orElse(null);
    }

    @Override
    public VideoGames SaveGame(VideoGames game) {
        return this.videoGamesRepository.save(game);
    }

    @Override
    public void DeleteGame(Integer id) {
        this.videoGamesRepository.deleteById(id);

    }
}
