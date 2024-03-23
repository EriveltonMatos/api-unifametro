package com.apiunifametro.controllers;

import com.apiunifametro.dtos.GameRecordDto;
import com.apiunifametro.models.GameModel;
import com.apiunifametro.repositories.GameRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@RestController
public class GameController {
    @Autowired
    GameRepository gameRepository;

    @PostMapping("/games")
    public ResponseEntity<GameModel> saveGame(@RequestBody @Valid GameRecordDto gameRecordDto) {
        var gameModel = new GameModel();
        BeanUtils.copyProperties(gameRecordDto, gameModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(gameRepository.save(gameModel));
    }

    @GetMapping("/games")
    public ResponseEntity<List<GameModel>> getAllGames(){
        return ResponseEntity.status(HttpStatus.OK).body(gameRepository.findAll());
    }

    @GetMapping("/games/{id}")
    public ResponseEntity<Object> getOneGame(@PathVariable(value="id") UUID id){
        Optional<GameModel> game0 = gameRepository.findById(id);
        if(game0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(game0.get());
    }

    @PutMapping("games/{id}")
    public ResponseEntity<Object> updateGame(@PathVariable(value="id") UUID id,
                                                @RequestBody @Valid GameRecordDto gameRecordDto) {
        Optional<GameModel> game0 = gameRepository.findById(id);
        if(game0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game não encontrado");
        }
        var gameModel = game0.get();
        BeanUtils.copyProperties(gameRecordDto, gameModel);
        return ResponseEntity.status(HttpStatus.OK).body(gameRepository.save(gameModel));
    }

    @DeleteMapping("games/{id}")
    public ResponseEntity<Object> deleteGame(@PathVariable(value="id") UUID id) {
        Optional<GameModel> game0 = gameRepository.findById(id);
        if(game0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Game não encontado.");
        }
        gameRepository.delete(game0.get());
        return ResponseEntity.status(HttpStatus.OK).body("Game deletado com sucesso.");
    }
}