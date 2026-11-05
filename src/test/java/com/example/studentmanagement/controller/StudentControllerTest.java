package com.example.studentmanagement.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StudentController.class)
class StudentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getStudentsReturnsStudentList() throws Exception {
        mockMvc.perform(get("/students"))
            .andExpect(status().isOk())
            .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$.length()").value(3))
            .andExpect(jsonPath("$[0].studentId").value(101))
            .andExpect(jsonPath("$[0].studentName").value("Jaswanth"))
            .andExpect(jsonPath("$[1].studentId").value(102))
            .andExpect(jsonPath("$[1].studentName").value("Rahul"))
            .andExpect(jsonPath("$[2].studentId").value(103))
            .andExpect(jsonPath("$[2].studentName").value("Priya"));
    }
}
