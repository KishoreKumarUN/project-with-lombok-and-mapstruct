package com.lombok.demo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EmployeeDto {
    private Long id;
    @NotNull
    private String name;
    @NotEmpty
    private Map<String,String> addresses;
    @NotEmpty
    private List<String> skills;
}
