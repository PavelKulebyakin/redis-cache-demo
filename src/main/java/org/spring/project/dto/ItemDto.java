package org.spring.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto {                              // TODO check constructors
    private Long id;
    private String name;
    private int quantity;
}
