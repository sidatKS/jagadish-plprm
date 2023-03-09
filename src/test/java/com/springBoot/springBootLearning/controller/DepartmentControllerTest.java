package com.springBoot.springBootLearning.controller;

import com.springBoot.springBootLearning.entity.Department;
import com.springBoot.springBootLearning.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService departmentService;

    private Department department;


    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("CS")
                .departmentAddress("Bangalore")
                .departmentId(1L)
                .departmentCode("CS123")
                .build();
    }

    @Test
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("CS")
                .departmentAddress("Bangalore")
                .departmentCode("CS123")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment))
                .thenReturn(department);

        mockMvc.perform(post("/departments")
                        .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"departmentId\": 1,\n" +
                        "    \"departmentName\": \"CS\",\n" +
                        "    \"departmentAddress\": \"Bangalore\",\n" +
                        "    \"departmentCode\": \"CS123\"\n" +
                        "}"))
                .andExpect(status().isOk());
    }


}