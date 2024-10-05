package org.spring.project.controller;

import lombok.RequiredArgsConstructor;
import org.spring.project.dto.ItemDto;
import org.spring.project.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/item")
public class ItemController {
    private final ItemService itemService;

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable Long id) {
        ItemDto item = itemService.getItemById(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = itemService.getAllItems();
        return ResponseEntity.ok(items);
    }

    @PostMapping
    public ResponseEntity<Void> createItem(@RequestBody ItemDto itemDto) {
        itemService.createItem(itemDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.ok().build();
    }
}
