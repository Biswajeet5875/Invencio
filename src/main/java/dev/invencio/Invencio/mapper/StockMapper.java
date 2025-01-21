package dev.invencio.Invencio.mapper;

import org.springframework.beans.BeanUtils;

import dev.invencio.Invencio.dto.StockResponce;
import dev.invencio.Invencio.model.Stock;

public class StockMapper {
    public static StockResponce convertStockToResponse(Stock stock) {
        var response = new StockResponce();
        BeanUtils.copyProperties(stock, response);
        System.out.println(response);
        return response;
    }
}
