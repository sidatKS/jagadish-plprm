package com.springBoot.springBootLearning.service;

import com.springBoot.springBootLearning.entity.Department;
import com.springBoot.springBootLearning.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;

    @MockBean  //
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("CS")
                .departmentAddress("1234")
                .departmentCode("CS525")
                .departmentId(1L)
                .build();
        Mockito.when(departmentRepository.findByDepartmentName("CS"))
                .thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound(){
        String departmentName = "CS";
        Department found = departmentService.fetchByDepartmentName(departmentName);
        assertEquals(departmentName,found.getDepartmentName());
    }
}