package dev.invencio.Invencio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.invencio.Invencio.model.Stock;

@Repository
public interface InvencioRepo extends JpaRepository<Stock, String> {

    // i want to find the recent added stocks
    List<Stock> findTop5ByOrderByItemName();

    List<Stock> findByQuantityLessThanEqual(int quantity);

    List<Stock> findByItemNameContaining(String itemName);

}
