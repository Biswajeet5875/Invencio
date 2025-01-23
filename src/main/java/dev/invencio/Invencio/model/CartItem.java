package dev.invencio.Invencio.model;

import lombok.Data;

@Data
public class CartItem {
    private String stockId;
    private String stockName;
    private String price;
    private int quantity;
}
