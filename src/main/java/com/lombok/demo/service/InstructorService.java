package com.lombok.demo.service;

import com.lombok.demo.dao.InstructorDao;
import com.lombok.demo.dto.InstructorDto;
import com.lombok.demo.mapper.InstructorMapper;
import com.lombok.demo.model.Instructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    @Autowired
    private InstructorDao instructorDao;

    @Autowired
    private InstructorMapper instructorMapper;

    public InstructorDto createInstructor(InstructorDto instructorDto) {
        Instructor instructor = instructorMapper.toEntity(instructorDto);
        Instructor savedInstructor = instructorDao.save(instructor);
        return instructorMapper.toDto(savedInstructor);
    }
}
