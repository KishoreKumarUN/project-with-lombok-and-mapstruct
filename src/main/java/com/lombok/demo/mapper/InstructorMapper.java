package com.lombok.demo.mapper;

import com.lombok.demo.dto.InstructorDto;
import com.lombok.demo.model.Instructor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstructorMapper {
    InstructorDto toDto(Instructor instructor);
    Instructor toEntity(InstructorDto instructorDto);
}
