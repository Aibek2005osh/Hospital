package java16.service.impl;

import java16.GeneralService;
import java16.dao.DepartmentDao;
import java16.dao.db.Datebase;
import java16.dao.impl.DepartmentDaoImpl;
import java16.midels.Department;
import java16.midels.Hospital;
import java16.service.DepartmentService;

import java.util.List;

public class DepartmentServiceImpl implements GeneralService<Department>, DepartmentService {
    private final DepartmentDaoImpl departmentDao;

    public DepartmentServiceImpl(DepartmentDaoImpl departmentDao) {

        this.departmentDao = departmentDao;
    }

    @Override
    public String save(Long id, Department department) {
        return departmentDao.save(id, department);

    }

    @Override
    public String updateById(Long id, Department department) {
        if (department.getDepartmentName().isEmpty()) {
            throw new RuntimeException("null болбошу керек  : ");
        }
        return departmentDao.updateById(id, department);
    }

    @Override
    public void deleteById(Long id) {

        departmentDao.deleteById(id);

    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return departmentDao.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return departmentDao.findDepartmentByName(name);
    }
}
