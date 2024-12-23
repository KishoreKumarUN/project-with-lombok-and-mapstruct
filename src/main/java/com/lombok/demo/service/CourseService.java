package com.lombok.demo.service;

import com.lombok.demo.dao.CourseDao;
import com.lombok.demo.dao.InstructorDao;
import com.lombok.demo.dao.StudentDao;
import com.lombok.demo.dto.CourseDto;
import com.lombok.demo.mapper.CourseMapper;
import com.lombok.demo.model.Course;
import com.lombok.demo.model.Instructor;
import com.lombok.demo.model.Student;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private InstructorDao instructorDao;

    @Autowired
    private StudentDao studentDao;

    public CourseDto createCourse(CourseDto courseDto) {
        Course course = courseMapper.toEntity(courseDto);
        Instructor instructor = instructorDao.findById(courseDto.getInstructorId())
            .orElseThrow(() -> new NoSuchElementException("Instructor not found"));
        course.setInstructor(instructor);
        if (courseDto.getStudentIds() != null) {
            List<Student> students = studentDao.findAllById(courseDto.getStudentIds());

            // Set students for the course
            course.setStudents(students);

            // Update each student to reference the course
            for (Student student : students) {
                student.getCourses().add(course);
            }
        }
        Course savedCourse = courseDao.save(course);
        return courseMapper.toDto(savedCourse);
    }
}
