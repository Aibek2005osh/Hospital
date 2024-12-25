package java16.dao.impl;

import java16.dao.HospitalDao;
import java16.dao.db.Datebase;
import java16.midels.Hospital;
import java16.midels.Patient;

import java.util.*;

public class HospitalDaoImpl implements HospitalDao {

    @Override
    public String addHospital(Hospital hospital) {
        Datebase.hospitalList.add(hospital);
        return "successfull";
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for (Hospital hospital : Datebase.hospitalList) {
            if (hospital.getId().equals(id)) {

                return hospital;
            }
        }
        return null ;
    }

    @Override
    public List<Hospital> getAllHospital() {

        return  Datebase.hospitalList;
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        //todo !!
        ArrayList <Patient> patients = new ArrayList<>();

        for (Hospital hospital : Datebase.hospitalList) {
            if (hospital.getId().equals(id)) {
                if (hospital.getPatients() == null) {
                    return new ArrayList<>();
                }
                patients.addAll(new ArrayList<>(hospital.getPatients()));

            }
        }
        System.out.println("not fount ");
        return patients;
    }

    @Override
    public String deleteHospitalById(Long id) {
        for (Hospital hospital : Datebase.hospitalList) {
            if (hospital.getId().equals(id)) {
                Datebase.hospitalList.remove(hospital);
                System.out.println("successfull");
                break;
            }
            
        }
        return " " +id;
    }

    @Override
    public Map<String, List<Hospital>> getAllHospitalByAddress(String address) {
        Map<String, List<Hospital>> hospitals = new LinkedHashMap<>();
        List<Hospital> hospitalList = new ArrayList<>();

        for (Hospital hospital : Datebase.hospitalList) {
            if (hospital.getAdderss().equals(address)) {
                hospitalList.add(hospital);
            }
        }
        hospitals.put(address,hospitalList);
        return hospitals;
    }
}
