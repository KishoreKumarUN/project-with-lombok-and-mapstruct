package com.lombok.demo.mapper;

import com.lombok.demo.dto.StudentDto;
import com.lombok.demo.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    //StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);
    @Mapping(source = "name", target = "fullName")
    @Mapping(source = "dateOfBirth", target = "dob", dateFormat = "yyyy-MM-dd")
    //@Mapping(target = "active", ignore = true)
    @Mapping(source = "courses", target = "courses")
    StudentDto toDto(Student student);

    @Mapping(source = "fullName", target = "name")
    @Mapping(source = "dob", target = "dateOfBirth", dateFormat = "yyyy-MM-dd")
    //@Mapping(target = "active", source = "active", defaultValue = "true")
    //@Mapping(target = "active", ignore = true)
    @Mapping(target = "active", expression = "java(studentDto.isActive() ? studentDto.isActive() : true)")
    Student toEntity(StudentDto studentDto);
}
