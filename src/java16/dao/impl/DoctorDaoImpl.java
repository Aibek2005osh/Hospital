package java16.dao.impl;

import java16.GeneralService;
import java16.dao.db.Datebase;
import java16.midels.Department;
import java16.midels.Doctor;
import java16.midels.Hospital;
import java16.midels.Patient;
import java16.service.DoctorService;

import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements GeneralService<Doctor>, DoctorService {


    private final DepartmentDaoImpl departmentDao;

    public DoctorDaoImpl(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Override
    public String save(Long id, Doctor doctor) {
        for (Hospital hospital : Datebase.hospitalList) {
            if (hospital.getId().equals(id)) {
                if (hospital.getDoctors() == null) {
                    hospital.setDoctors(new ArrayList<>());
                }
                hospital.getDoctors().add(doctor);
                return "sucessfull";
            }
            ;

        }
        return "not fount ! ! ";
    }

    @Override
    public String updateById(Long id, Doctor doctor) {

        for (Hospital hospital : Datebase.hospitalList) {
            for (Doctor hospitalDoctor : hospital.getDoctors()) {
                if (hospitalDoctor.getId().equals(id)) {
                    hospitalDoctor.setFirstName(doctor.getFirstName());
                    hospitalDoctor.setLastName(doctor.getLastName());
                    hospitalDoctor.setGender(doctor.getGender());
                    hospitalDoctor.setExperienceYear(doctor.getExperienceYear());
                    return "successfull";
                }
            }
        }
        return "not fount ";
    }

    @Override
    public void deleteById(Long id) {
        for (Hospital hospital : Datebase.hospitalList) {
            for (Doctor doctor : hospital.getDoctors()) {
                if (doctor.getId().equals(id)) {
                    hospital.getDoctors().remove(doctor);
                    return;

                }
            }
        }

    }

    @Override
    public Doctor findDoctorById(Long id) {
        Doctor doctor1;
        for (Hospital d : Datebase.hospitalList) {
            for (Doctor doctor : d.getDoctors()) {
                if (doctor.getId().equals(id)) {
                    doctor1 = doctor;
                    System.out.println("success");
                    return doctor1;

                }
            }
        }
        System.out.println("not");
        return null;
    }

    @Override
    public String assignDoctorToDepartment(Long departmentId, List<Long> doctorsId) {
        ArrayList<Doctor> doctors = new ArrayList<>();
        for (Long aLong : doctorsId) {
            doctors.add(findDoctorById(aLong));
        }
        for (Hospital hospital : Datebase.hospitalList) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(departmentId)) {
                    department.setDoctors(doctors);

                    return "successfull";

                }
            }
//        }
//        int count = 0;
//        for(Hospital h : Datebase.hospitalList){
//            for (Department department : h.getDepartments()) {
//                if(department.getId().equals(departmentId)){
//                    for(Doctor d : h.getDoctors()){
//                        if(d.getId().equals(doctorsId.get(count))){
//                           doctors.add(d);
//                             count++;
//                        }
//                    }
//
//                }
//
//            }
        }
//
//        if(!doctors.isEmpty()){
//            return "successful";
//        }

        return "not fount";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(Long id) {
        List<Doctor> doc = new ArrayList<>();
        for (Hospital hospital : Datebase.hospitalList) {
            if (hospital.getId().equals(id)) {
                for (Doctor patient : hospital.getDoctors()) {
                    doc.add(patient);
                    hospital.setDoctors(doc);
                    return doc;
                }
            }
        }
        return List.of();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(Long id) {
        List<Doctor> doctors = new ArrayList<>();

        for (Hospital hospital : Datebase.hospitalList) {
            for (Department department : hospital.getDepartments()) {
                if (department.getId().equals(id)) {
                    if (department.getDoctors() != null) {
                        doctors.addAll(department.getDoctors());
                    }
                    break;
                }
            }
        }


        System.out.println("not fount" + id);


        return doctors;
    }
}

