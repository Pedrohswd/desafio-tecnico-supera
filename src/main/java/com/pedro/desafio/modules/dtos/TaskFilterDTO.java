package com.pedro.desafio.modules.dtos;

import lombok.Data;

@Data
public class TaskFilterDTO {

    private Long listId;
    private Boolean completed;
    private Boolean highlighted;
    private String priority;

}
