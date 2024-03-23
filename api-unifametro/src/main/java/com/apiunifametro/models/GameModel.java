package com.apiunifametro.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_GAMES")
public class GameModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id //identificador
    @GeneratedValue(strategy= GenerationType.AUTO) //Define como será gerado o id (são gerados automaticamente)
    private UUID idGame;
    private String name;
    private BigDecimal value;

    public UUID getIdGame() {
        return idGame;
    }

    public void setIdGame(UUID idGame) {
        this.idGame = idGame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
