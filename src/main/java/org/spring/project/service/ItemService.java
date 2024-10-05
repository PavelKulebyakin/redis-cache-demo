package org.spring.project.service;

import lombok.RequiredArgsConstructor;
import org.spring.project.dto.ItemDto;
import org.spring.project.mapper.ItemMapper;
import org.spring.project.model.Item;
import org.spring.project.repository.ItemRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    @Cacheable(value = "item", key = "#id")
    public ItemDto getItemById(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(NoSuchElementException::new);
        return itemMapper.itemToItemDto(item);
    }

    public List<ItemDto> getAllItems() {
        List<Item> items = itemRepository.findAll();
        return items.stream().map(itemMapper::itemToItemDto).collect(Collectors.toList());
    }

    public void createItem(ItemDto itemDto) {               // TODO add cache put
        Item item = itemMapper.itemDtoToItem(itemDto);
        itemRepository.save(item);
    }

    @CacheEvict(cacheNames = "item", key = "#id", beforeInvocation = true)
    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }
}
