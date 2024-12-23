package com.lombok.demo.mapper;

import com.lombok.demo.dto.CourseDto;
import com.lombok.demo.model.Course;
import com.lombok.demo.model.Student;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CourseMapper {
    @Mapping(source = "instructor.id", target = "instructorId")
    @Mapping(source = "students", target = "studentIds", qualifiedByName = "studentListToIds")
    CourseDto toDto(Course course);

    @Mapping(source = "instructorId", target = "instructor.id")
    @Mapping(source = "studentIds", target = "students", qualifiedByName = "idsToStudentList")
    Course toEntity(CourseDto courseDto);

    @Named("studentListToIds")
    default List<Long> studentListToIds(List<Student> students) {
        if (students == null) return null;
        return students.stream().map(Student::getId).collect(Collectors.toList());
    }

    @Named("idsToStudentList")
    default List<Student> idsToStudentList(List<Long> studentIds) {
        if (studentIds == null) return null;
        return studentIds.stream()
            .map(id -> {
                Student student = new Student();
                student.setId(id);
                return student;
            })
            .collect(Collectors.toList());
    }
}
