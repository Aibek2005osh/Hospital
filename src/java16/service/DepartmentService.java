package java16.service;

import java16.midels.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartmentByHospital(Long id);

    Department findDepartmentByName(String name);

}
