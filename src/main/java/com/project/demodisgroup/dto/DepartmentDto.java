package com.project.demodisgroup.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class DepartmentDto implements Serializable {
    private final Long id;
    private final String name;
}
