package dev.invencio.Invencio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockResponce {

    private String stockId;
    private String itemName;
    private String category;
    private int quantity;
    private int price;
    private String warehouse;
    private String description;
    private String batchNo;
}
