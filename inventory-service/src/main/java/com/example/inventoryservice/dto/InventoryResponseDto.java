package com.example.inventoryservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryResponseDto {
    private String skuCode;
    private boolean isInStock;
}
