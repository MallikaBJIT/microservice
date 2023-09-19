package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.InventoryResponseDto;
import com.example.inventoryservice.model.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public List<InventoryResponseDto> isInStock(List<String> skuCode) {
        skuCode.forEach(System.out::println);
        List<Inventory> result = inventoryRepository.findBySkuCodeIn(skuCode);

        result.forEach(res -> System.out.println(res.getSkuCode() + " " + res.getQuantity()));
        System.out.println(result.size());
        return inventoryRepository.findBySkuCodeIn(skuCode)
                .stream()
                .map(inventory -> InventoryResponseDto.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0)
                        .build()).toList();
    }
}
