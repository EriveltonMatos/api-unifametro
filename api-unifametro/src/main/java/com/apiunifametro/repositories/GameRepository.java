package com.apiunifametro.repositories;

import com.apiunifametro.models.GameModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface GameRepository extends JpaRepository<GameModel, UUID> {
}
