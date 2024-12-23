package com.lombok.demo.service;

import com.lombok.demo.dao.CourseDao;
import com.lombok.demo.dao.StudentDao;
import com.lombok.demo.dto.StudentDto;
import com.lombok.demo.mapper.StudentMapper;
import com.lombok.demo.model.Course;
import com.lombok.demo.model.Student;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentDao studentRepository;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private StudentMapper studentMapper;

    public StudentDto createStudent(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        System.out.println(student.isActive());
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDto(savedStudent);
    }

    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students.stream()
            .map(studentMapper::toDto)
            .toList();
    }

}
