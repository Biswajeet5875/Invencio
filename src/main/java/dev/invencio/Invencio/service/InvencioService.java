package dev.invencio.Invencio.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import dev.invencio.Invencio.dto.AdminResponse;
import dev.invencio.Invencio.dto.StockResponce;
import dev.invencio.Invencio.mapper.StockMapper;
import dev.invencio.Invencio.model.Admin;
import dev.invencio.Invencio.model.CartItem;
import dev.invencio.Invencio.model.Stock;
import dev.invencio.Invencio.repository.InvencioAdminRepo;
import dev.invencio.Invencio.repository.InvencioRepo;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class InvencioService {

    public final InvencioRepo invencioRepo;
    public final InvencioAdminRepo invencioAdminRepo;

    public void createNewStock(Stock invencio) {

        invencioRepo.save(invencio);
    }

    public void createAdmin(Admin admin) {
        invencioAdminRepo.save(admin);
    }

    public List<AdminResponse> getAllAdmin() {
        return invencioAdminRepo.findAll().stream()
                .map(admin -> new AdminResponse(
                        admin.getAdminId(),
                        admin.getFullName(),
                        admin.getRole(),
                        admin.getEmail(),
                        admin.getPhone(),
                        admin.getUsername(),
                        admin.getPassword(),
                        admin.getBrn(),
                        admin.getTin(),
                        admin.getAddress()))
                .collect(Collectors.toList());
    }

    public AdminResponse getAdminById(String id) {
        return invencioAdminRepo.findById(id)
                .map(admin -> new AdminResponse(
                        admin.getAdminId(),
                        admin.getFullName(),
                        admin.getRole(),
                        admin.getEmail(),
                        admin.getPhone(),
                        admin.getUsername(),
                        admin.getPassword(),
                        admin.getBrn(),
                        admin.getTin(),
                        admin.getAddress()))
                .orElseThrow(() -> new RuntimeException("Admin not found with id " + id));
    }

    public StockResponce getStockById(String stockId) {
        return invencioRepo.findById(stockId).map(StockMapper::convertStockToResponse).orElse(null);
    }

    public List<Stock> getAllStocks() {
        return invencioRepo.findAll();
    }

    public List<Stock> getStockBySearchTerm(String searchTerm) {
        return invencioRepo.findByItemNameContaining(searchTerm);
    }

    public List<Stock> getLowStocks() {
        return invencioRepo.findByQuantityLessThanEqual(6);
    }

    public void updateStock(Stock invencio, String stockId) {
        invencio.setStockId(stockId);
        invencioRepo.save(invencio);
    }

    public void updateStockQuantities(List<CartItem> cartItems) {
        for (CartItem item : cartItems) {
            Stock stock = invencioRepo.findById(item.getStockId())
                    .orElseThrow(() -> new RuntimeException("Stock not found for ID: " + item.getStockId()));

            int newQuantity = stock.getQuantity() - item.getQuantity();
            if (newQuantity < 0) {
                throw new RuntimeException("Insufficient stock for: " + stock.getItemName());
            }

            stock.setQuantity(newQuantity);
            invencioRepo.save(stock);
        }
    }

    public void deleteStock(String stockId) {
        invencioRepo.deleteById(stockId);
    }

}
