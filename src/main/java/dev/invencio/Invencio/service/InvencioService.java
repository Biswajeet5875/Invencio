package dev.invencio.Invencio.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.invencio.Invencio.model.Stock;
import dev.invencio.Invencio.repository.InvencioRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvencioService {

    public final InvencioRepo invencioRepo;

    public final JdbcTemplate jdbcTemplate;

    public void createNewStock(Stock invencio) {

        invencioRepo.save(invencio);

        // String sql = """
        // INSERT INTO invencio-stock(
        // item_name,
        // category,
        // quantity,
        // price,
        // warehouse,
        // restock_threshold,
        // description
        // )
        // VALUES
        // (?,?,?,?,?,?,?)

        // """;

        // jdbcTemplate.update(sql,
        // invencio.getItemName(),
        // invencio.getCategory(),
        // invencio.getQuantity(),
        // invencio.getPrice(),
        // invencio.getWarehouse(),
        // invencio.getRestockThreshold(),
        // invencio.getDescription());

    }

}
