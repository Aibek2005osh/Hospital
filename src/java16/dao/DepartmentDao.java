package java16.dao;

import java16.midels.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> getAllDepartmentByHospital(Long id);

    Department findDepartmentByName(String name);
}
