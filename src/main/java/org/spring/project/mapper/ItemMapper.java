package org.spring.project.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.spring.project.dto.ItemDto;
import org.spring.project.model.Item;

@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDto itemToItemDto(Item item);
    Item itemDtoToItem(ItemDto itemDto);
}

