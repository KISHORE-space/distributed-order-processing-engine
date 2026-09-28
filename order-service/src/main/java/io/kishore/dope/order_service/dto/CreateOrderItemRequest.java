package io.kishore.dope.order_service.dto;

import java.math.BigDecimal;
import java.util.UUID;

public class CreateOrderItemRequest {
    private UUID productId;
    private Integer quantity;
    private BigDecimal unitPrice;

    public CreateOrderItemRequest(){
    }
    
    public CreateOrderItemRequest(
        UUID productId, 
        Integer quantity, 
        BigDecimal unitPrice
    ) {
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public UUID getProductId(){
        return productId;
    }
    public void setProductId(UUID productId){
        this.productId = productId;
    }
    public Integer getQuantity(){
        return quantity;
    }

    public void setQuantity(Integer quantity){
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice(){
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice){
        this.unitPrice  = unitPrice;
    }

}