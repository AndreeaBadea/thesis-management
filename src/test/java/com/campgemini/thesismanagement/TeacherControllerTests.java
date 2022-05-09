package com.campgemini.thesismanagement;

import com.campgemini.thesismanagement.controller.TeacherController;
import com.campgemini.thesismanagement.domain.Project;
import com.campgemini.thesismanagement.domain.Teacher;
import com.campgemini.thesismanagement.repository.TeacherRepository;
import com.campgemini.thesismanagement.service.TeacherService;
import com.campgemini.thesismanagement.service.mapper.TeacherMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeacherController.class)
public class TeacherControllerTests {

    @MockBean
    private TeacherRepository teacherRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private TeacherService teacherService;

    @Test
    void shouldCreateTeacher() throws Exception {
        Teacher teacher = new Teacher(1, "TeacherSurname", "TeacherName", "teacher.email@gmail.com", "60024820", 3, null);
        mockMvc.perform(
                        post("/teachers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(teacher)))
                .andExpect(status().isCreated())
                .andDo(print());
    }


    @Test
    void shouldReturnTeacherById() throws Exception {
        int id = 2;
        Teacher teacher = new Teacher(2, "TeacherSurname", "TeacherName", "teacher.email@gmail.com", "60024820", 3, null);
        when(teacherRepository.findById(id)).thenReturn(Optional.of(teacher));
        mockMvc.perform(get("/teachers/{id}", id)).andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldReturnListOfTeachers() throws Exception {
        List<Teacher> teachersList = new ArrayList<>(
                Arrays.asList(new Teacher(2, "TeacherSurname1", "TeacherName1", "teacher.email@gmail.com", "60024820", 3, null),
                        new Teacher(3, "TeacherSurname2", "TeacherName2", "teacher.email@gmail.com", "60340", 2, null)
                        ));
        when(teacherRepository.findAll()).thenReturn(teachersList);
        mockMvc.perform(get("/teachers"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void shouldCreateProject() throws Exception {
        int id = 2;
        Teacher teacher = new Teacher(2, "TeacherSurname", "TeacherName", "teacher.email@gmail.com", "60024820", 3, null);
        Project project = new Project(1, null, null, "Project Title", "Project Description", true);
        when(teacherService.findTeacherById(id)).thenReturn(TeacherMapper.teacherToTeacherDto(teacher));
        mockMvc.perform(post("/teachers/{id}/projects", id)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objectMapper.writeValueAsString(project)))
                .andExpect(status().isCreated())
                .andDo(print());
    }

    @Test
    void shouldReturnAllTeacherProjects() throws Exception {
        int id = 2;
        Project project = new Project(1, null, null, "Project Title", "Project Description", true);
        Teacher teacher = new Teacher(2, "TeacherSurname", "TeacherName", "teacher.email@gmail.com", "60024820", 3, List.of(project));
        when(teacherRepository.findById(id)).thenReturn(Optional.of(teacher));
        mockMvc.perform(get("/teachers/{id}/project", id)).andExpect(status().isOk())
                .andDo(print());
    }


}


