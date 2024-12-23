package com.lombok.demo.controller;

import com.lombok.demo.dto.InstructorDto;
import com.lombok.demo.service.InstructorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/instructors")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<InstructorDto> createInstructor(@RequestBody @Valid InstructorDto instructorDto) {
        InstructorDto createdInstructor = instructorService.createInstructor(instructorDto);
        return ResponseEntity.ok(createdInstructor);
    }

}
