package com.lombok.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

@Data
public class CourseDto {
    @NotNull(message = "Course ID cannot be null")
    private Long id;

    @NotEmpty(message = "Course title cannot be empty")
    @Size(max = 100, message = "Course title must not exceed 100 characters")
    private String title;

    @NotNull(message = "Instructor ID cannot be null")
    private Long instructorId;

    @NotEmpty(message = "Student IDs list cannot be empty")
    private List<@NotNull(message = "Student ID cannot be null") Long> studentIds;
}
