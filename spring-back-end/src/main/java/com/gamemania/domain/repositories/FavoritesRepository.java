package com.gamemania.domain.repositories;

import com.gamemania.domain.models.Favorites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorites, Integer> {
}
