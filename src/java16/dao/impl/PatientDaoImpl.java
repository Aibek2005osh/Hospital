package java16.dao.impl;

import java16.GeneralService;
import java16.dao.PatientDao;
import java16.dao.db.Datebase;
import java16.midels.Hospital;
import java16.midels.Patient;

import java.util.*;

public class PatientDaoImpl implements GeneralService<Patient>, PatientDao {

    @Override
    public String save(Long id, Patient patient) {
        for (Hospital hospital : Datebase.hospitalList) {
            if (hospital.getId().equals(id)) {
                if (hospital.getPatients() == null) {
                    hospital.setPatients(new ArrayList<>());
                }
                hospital.getPatients().add(patient);
                System.out.println("Patient  ⬇⬇⬇");
                System.out.println(hospital);
                return "succesfeull ";
            }
        }
        System.out.println("Госпитал табылган жок: ID = " + id);
        return "Госпитал табылган жок";

    }

    @Override
    public String updateById(Long id, Patient patient) {


        for (Hospital hospital : Datebase.hospitalList) {
            for (Patient hospitalPatient : hospital.getPatients()) {
                if (hospitalPatient.getId().equals(id)) {
                    hospitalPatient.setFirtName(patient.getFirtName());
                    hospitalPatient.setLastName(patient.getLastName());
                    hospitalPatient.setGender(patient.getGender());
                    hospitalPatient.setAge(patient.getAge());
                    return "successfull";
                }
            }

        }
        return "not by id";
    }

    @Override
    public void deleteById(Long id) {

        for (Hospital hospital : Datebase.hospitalList) {

            for (Patient patient : hospital.getPatients()) {
                if (patient.getId().equals(id)) {
                    System.out.println("baar");
                    hospital.getPatients().remove(patient);
                    return;
                }
            }
            System.out.println("joook");

        }

    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        for (Hospital hospital : Datebase.hospitalList) {

            if (hospital.getId().equals(id)) {

                if (hospital.getPatients() == null) {
                    hospital.setPatients(new ArrayList<>());
                }
                hospital.getPatients().addAll(patients);
                return "Пациенттер ийгиликтүү кошулду госпиталга ID = " + id;
            }
        }


        return "not fount ->" + id;
    }

    @Override
    public Patient getPatientById(Long id) {
        for (Hospital hospital : Datebase.hospitalList) {
            for (Patient patient : hospital.getPatients()) {
                if (patient.getId().equals(id)) {
                    return patient;
                }
            }
        }
        System.out.println("not fount");
        return null;
    }

    @Override
    public Map<Integer, List<Patient>> getPatientByAge() {
        Map<Integer, List<Patient>> patientsByAge = new HashMap<>();
        for (Hospital hospital : Datebase.hospitalList) {
            for (Patient patient : hospital.getPatients()) {
                int age = patient.getAge();
                patientsByAge.putIfAbsent(age, new ArrayList<>());
                patientsByAge.get(age).add(patient);
            }
        }


        if (patientsByAge.isEmpty()) {
            System.out.println("not fount ");
        }

        return patientsByAge;
    }


    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        List<Patient> patients = new ArrayList<>();
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            for (Hospital hospital : Datebase.hospitalList) {
                patients.addAll(hospital.getPatients());
            }
            patients.sort((o1, o2) -> Integer.valueOf(o1.getAge()).compareTo(o2.getAge()));
        } else if (ascOrDesc.equalsIgnoreCase("desk")) {
            for (Hospital hospital : Datebase.hospitalList) {
                patients.addAll(hospital.getPatients());
            }
            patients.sort((o1, o2) -> Integer.compare(o2.getAge(), o1.getAge()));
        } else {
            System.out.println("Invalid command");
            return null;
        }
        return patients;
    }

}
