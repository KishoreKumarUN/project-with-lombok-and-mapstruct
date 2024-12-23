package com.lombok.demo.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import lombok.Data;

@Data
public class StudentDto {
    @NotNull(message = "Student ID cannot be null")
    private Long id;

    @NotEmpty(message = "Full name cannot be empty")
    @Size(max = 100, message = "Full name must not exceed 100 characters")
    private String fullName;

    @NotEmpty(message = "Date of birth cannot be empty")
    @Pattern(
        regexp = "\\d{4}-\\d{2}-\\d{2}",
        message = "Date of birth must be in the format YYYY-MM-DD"
    )
    private String dob;

    @DecimalMin(value = "0.0", message = "GPA must be at least 0.0")
    @DecimalMax(value = "4.0", message = "GPA must not exceed 4.0")
    private double gpa;

    @NotEmpty(message = "Subjects list cannot be empty")
    private List<@NotEmpty(message = "Subject name cannot be empty") String> subjects;

    private boolean active;

    @NotEmpty(message = "Courses list cannot be empty")
    private List<@Valid CourseDto> courses;
}
