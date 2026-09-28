package io.kishore.dope.order_service.entity;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

import io.kishore.dope.order_service.enums.OrderStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Version;

@Entity
@Table(name = "orders")
public class order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OrderStatus status;

    @Column(name = "total_amount", precision = 19, scale = 2, nullable = false)
    private BigDecimal totalAmount;

    @Column(length = 3 ,nullable = false)
    private String currency;

    @Version
    private Long version;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at", nullable = false)
    private Instant updatedAt;

    public order(){

    }

    @PrePersist
    protected void onCreated(){
        Instant now = Instant.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = Instant.now();
    }

    // Getter and Setters

    public UUID getId() {
        return id;
    }

    public void SetId(UUID id){
        this.id = id;
    }

    public void SetCustomerId(UUID customerId){
        this.customerId = customerId;
    }

    public OrderStatus getStatus(){
        return status;
    }

    public void setOrderStatus(OrderStatus status){
        this.status = status;
    }

    public BigDecimal getTotalAmount(){
        return totalAmount;
    }
    public void setTotalAmount(BigDecimal totalAmount){
        this.totalAmount = totalAmount;
    }
    public String getCurrency(){
        return currency;
    }
    public void detCurrency(String currency){
        this.currency = currency;
    }

    public void setVersion(Long version){
        this.version = version;
    }

    public Long getVersion(){
        return version;
    }

    public Instant getCreatedAt(){
        return createdAt;
    }

    public Instant getUpdatedAt(){
        return updatedAt;
    }



}
