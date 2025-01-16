package dev.invencio.Invencio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.invencio.Invencio.model.Stock;

@Repository
public interface InvencioRepo extends JpaRepository<Stock, String> {

}
