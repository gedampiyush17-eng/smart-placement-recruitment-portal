package com.placementportal.backend.service;

import com.placementportal.backend.entity.Student;
import com.placementportal.backend.repository.StudentRepository;
import com.placementportal.backend.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElseThrow(()->
                                                   new StudentNotFoundException("Student not found with id "+ id));
    }


    public Student updateStudent(Long id, Student updatedStudent){
        Student existingStudent=studentRepository.findById(id).orElse(null);

        if(existingStudent!=null){
            existingStudent.setName(updatedStudent.getName());
            existingStudent.setEmail(updatedStudent.getEmail());
            existingStudent.setCgpa(updatedStudent.getCgpa());
            existingStudent.setBranch(updatedStudent.getBranch());
            existingStudent.setSkills(updatedStudent.getSkills());

            return studentRepository.save(existingStudent);
        }
        return null;
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
