package dev.invencio.Invencio.service;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import dev.invencio.Invencio.dto.StockResponce;
import dev.invencio.Invencio.mapper.StockMapper;
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

    public StockResponce getStockById(String stockId) {
        return invencioRepo.findById(stockId).map(StockMapper::convertStockToResponse).orElse(null);
    }

    public List<Stock> getAllStocks() {
        return invencioRepo.findAll();
    }

    public List<Stock> getLowStocks() {
        return invencioRepo.findByQuantityLessThanEqual(6);
    }

    public void updateStock(Stock invencio, String stockId) {
        invencio.setStockId(stockId);
        invencioRepo.save(invencio);
    }

    public void deleteStock(String stockId) {
        invencioRepo.deleteById(stockId);
    }

}
