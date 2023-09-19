package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.InventoryResponseDto;
import com.example.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponseDto> isInStock(@RequestParam List<String> skucode) {
        List<InventoryResponseDto> inventoryResponseDtos = inventoryService.isInStock(skucode);
        return inventoryResponseDtos;
    }
}
