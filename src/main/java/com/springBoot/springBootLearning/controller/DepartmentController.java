package com.springBoot.springBootLearning.controller;


import com.springBoot.springBootLearning.entity.Department;
import com.springBoot.springBootLearning.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService; // to use the object that is stored in spring container as a reference using Autowired

    //loggers
    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    //save Department
    @PostMapping("/departments")
    //input Department and request the data which is json object convert into java obejct
    public Department saveDepartment(@RequestBody Department department){ //@valid to validate the request data
       // DepartmentService service = new Departmentserviceimpl(); // No need of this as we can use this as a reference using Autowired
       LOGGER.info("Inside saveDepartment of DepartmentController");  //logger
        return departmentService.saveDepartment(department);
    }

    //get Department
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartmentList();
    }

    //to get the Department by id
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.fetchDepartmentById(departmentId);
    }

    // delete the Department
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Successfully deleted the Department";

    }

    //update the data
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartment(departmentId, department);
    }

    //fetch the data by departmentName
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        return departmentService.fetchByDepartmentName(departmentName);
    }

}
