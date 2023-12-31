package com.fcwebapp.mediaproducts.repository;

import com.fcwebapp.mediaproducts.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game,Long> {
    List<Game> findGameByAuthor(String author);
}
