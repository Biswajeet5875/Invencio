package dev.invencio.Invencio.dto;

import lombok.Data;

@Data
public class StockResponce {

    private String stockId;
    private String itemName;
    private String category;
    private int quantity;
    private String price;
    private String warehouse;
    private String description;
    private String batchNo;
}
