package com.campgemini.thesismanagement;

import com.campgemini.thesismanagement.controller.StudentController;
import com.campgemini.thesismanagement.domain.Student;
import com.campgemini.thesismanagement.domain.Teacher;
import com.campgemini.thesismanagement.repository.StudentRepository;
import com.campgemini.thesismanagement.service.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StudentController.class)
public class StudentControllerTests {

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private StudentService studentService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateStudent() throws Exception {
        Student student = new Student(1, "StudentSurname", "StudentName", "student.email@gmail.com", "60020", null);
        mockMvc.perform(
                        post("/students")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(student)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void shouldReturnTeacherById() throws Exception {
        int id = 1;
        Student student = new Student(1, "StudentSurname", "StudentName", "student.email@gmail.com", "60020", null);
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        mockMvc.perform(get("/students/{id}", id)).andExpect(status().isOk())
                .andDo(print());
    }

}
