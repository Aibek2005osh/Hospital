package java16.service.impl;

import java16.GeneralService;
import java16.dao.DoctorDao;
import java16.dao.impl.DoctorDaoImpl;
import java16.midels.Doctor;
import java16.service.DoctorService;

import java.util.List;

public class DoctorServiceImpl implements GeneralService<Doctor>, DoctorService {
   private final DoctorDaoImpl doctorDao;

    public DoctorServiceImpl(DoctorDaoImpl doctorDao) {
        this.doctorDao = doctorDao;
    }

    @Override
    public String save(Long id,Doctor doctor) {
        return doctorDao.save(id,doctor);
    }

    @Override
    public String updateById(Long id, Doctor doctor) {
        return doctorDao.updateById(id,doctor);
    }

    @Override
    public void deleteById(Long id) {
        doctorDao.deleteById(id);

    }

    @Override
    public Doctor findDoctorById(Long id) {
        return doctorDao.findDoctorById(id);
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        return doctorDao.assignDoctorToDepartment(departmentId,doctorsId);
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        return doctorDao.getAllDoctorsByHospitalId(id);
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        return doctorDao.getAllDoctorsByDepartmentId(id);
    }
}
