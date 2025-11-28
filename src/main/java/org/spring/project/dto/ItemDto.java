package org.spring.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDto implements Serializable {                              // TODO check constructors
    private long id;
    private String name;
    private int quantity;
}
