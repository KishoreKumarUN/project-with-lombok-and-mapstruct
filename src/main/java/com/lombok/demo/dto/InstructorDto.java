package com.lombok.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

@Data
public class InstructorDto {
    @NotNull(message = "Instructor ID cannot be null")
    private Long id;

    @NotEmpty(message = "Instructor name cannot be empty")
    @Size(max = 100, message = "Instructor name must not exceed 100 characters")
    private String name;
    private List<Long> courseIds;
}
