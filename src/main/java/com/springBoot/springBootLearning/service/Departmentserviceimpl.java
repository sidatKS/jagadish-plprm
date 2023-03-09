package com.springBoot.springBootLearning.service;

import com.springBoot.springBootLearning.entity.Department;
import com.springBoot.springBootLearning.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class Departmentserviceimpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;
    //to save the department
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    //to get the departments
    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    //to get the Department by Id
    @Override
    public Department fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    //delete the Department By Id
    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    //Update the department
    @Override
    public Department updateDepartment(Long departmentId, Department department) {
        Department depDB = departmentRepository.findById(departmentId).get();
        // to check the null value in the requested data and save the data to the Department

        //checking for nonNull values and for blank and adding the values to the depDB object and saving to Department repository
        if(Objects.nonNull(department.getDepartmentName()) &&
                          !"".equalsIgnoreCase(department.getDepartmentName())){
            depDB.setDepartmentName(department.getDepartmentName());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }

        if(Objects.nonNull(department.getDepartmentAddress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAddress())){
            depDB.setDepartmentAddress(department.getDepartmentAddress());
        }
        return departmentRepository.save(depDB);
    }

    //get the department by departmentName
    @Override
    public Department fetchByDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }


}
