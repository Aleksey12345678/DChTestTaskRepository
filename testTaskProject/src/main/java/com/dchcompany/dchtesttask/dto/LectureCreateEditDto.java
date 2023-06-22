package com.dchcompany.dchtesttask.dto;

import jakarta.validation.constraints.Size;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value

public class LectureCreateEditDto {
    public LectureCreateEditDto() {
    }


    @Size(min=3, max=20)
    String name = null;
}
