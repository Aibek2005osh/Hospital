package java16.service.impl;

import java16.dao.db.Datebase;
import java16.dao.impl.HospitalDaoImpl;
import java16.midels.Hospital;
import java16.midels.Patient;
import java16.service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    private final HospitalDaoImpl hospitalDao;

    public HospitalServiceImpl(HospitalDaoImpl hospitalDao) {
        this.hospitalDao = hospitalDao;
    }

    @Override
    public String addHospital(Hospital hospital) {

                if (hospital.getHospitalName().isEmpty()) {
                    System.out.println("null bolbosh kerek : ");
                    return "error" ;
                }

        return hospitalDao.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {



        return hospitalDao.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDao.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
       return hospitalDao.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id){


        return hospitalDao.deleteHospitalById(id);
    }

    @Override
    public Map<String, List<Hospital>> getAllHospitalByAddress(String address) {


        return hospitalDao.getAllHospitalByAddress(address);
    }
}
