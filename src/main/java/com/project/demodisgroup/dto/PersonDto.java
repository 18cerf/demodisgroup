package com.project.demodisgroup.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter
public class PersonDto implements Serializable {
    private final Long id;
    private final String firstname;
    private final String lastname;
    private final Long departmentId;
}
