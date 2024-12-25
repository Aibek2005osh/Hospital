package java16.dao.impl;

import java16.GeneralService;
import java16.dao.DepartmentDao;
import java16.dao.db.Datebase;
import java16.midels.Department;

import java16.midels.Hospital;

import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoImpl implements GeneralService<Department>, DepartmentDao {

    @Override
    public String save(Long id, Department department) {
        for(Hospital hospital : Datebase.hospitalList){
            if(hospital.getId().equals(id)){
              hospital.getDepartments().add(department);
                return "Successfully ";
            }
        }
        return " not found";
    }

    @Override
    public String updateById(Long id, Department department) {
        for (Hospital hospital : Datebase.hospitalList) {
            for (Department hospitalDepartment : hospital.getDepartments()) {
                if (hospitalDepartment.getId().equals(id)) {
                    hospitalDepartment.setDepartmentName(department.getDepartmentName());
                   return "sucessfull";
                }
            }
        }
        return "not fount";
    }

    @Override
    public void deleteById(Long id) {


        for (Hospital hospital : Datebase.hospitalList) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(id)) {

                    System.out.println("successfull");
                    hospital.getDepartments().remove(department);

                }
            }
            System.out.println("not fount");
        }
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        for (Hospital hospital : Datebase.hospitalList) {
            if (hospital.getId().equals(id)) {
               return hospital.getDepartments();

            }
        }
        return List.of();
    }

    @Override
    public Department findDepartmentByName(String name) {
        Department department = new Department();
        for (Hospital hospital : Datebase.hospitalList) {
            for (Department hospitalDepartment : hospital.getDepartments()) {
                if (hospitalDepartment.getDepartmentName().equals(name)) {
                    System.out.println("⬇ ⬇ ⬇ ⬇ ⬇ ⬇ ⬇");
                    department = hospitalDepartment;
                }break;
            }
        }
        System.out.println("not fount");
        return department;
    }
}
