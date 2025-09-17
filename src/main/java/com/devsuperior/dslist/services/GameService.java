package com.devsuperior.dslist.services;

import com.devsuperior.dslist.dto.GameDto;
import com.devsuperior.dslist.dto.GameMinDto;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDto> findAll() {
        List<Game> result = gameRepository.findAll();
        List<GameMinDto> dtoList = result.stream().map(x -> new GameMinDto(x)).toList();
        return dtoList;
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long gameId) {
        Game result = gameRepository.findById(gameId).get();
        GameDto gameDto = new GameDto(result);
        return gameDto;
    }
}
