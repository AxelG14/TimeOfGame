package com.ag.TimeOfGame.service;

import com.ag.TimeOfGame.entity.VideoGames;

import java.util.List;

public interface IVideoGamesService {
    List<VideoGames> GameList();

    VideoGames GameById(Integer id);

    VideoGames SaveGame(VideoGames game);

    void DeleteGame(Integer id);
}
