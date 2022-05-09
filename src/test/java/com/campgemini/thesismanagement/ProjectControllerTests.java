package com.campgemini.thesismanagement;

import com.campgemini.thesismanagement.controller.ProjectController;
import com.campgemini.thesismanagement.repository.ProjectRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ProjectController.class)
public class ProjectControllerTests {

    @MockBean
    private  ProjectRepository projectRepository;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;



}
