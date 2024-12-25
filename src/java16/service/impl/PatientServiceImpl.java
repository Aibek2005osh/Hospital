package java16.service.impl;

import java16.GeneralService;
import java16.dao.PatientDao;
import java16.dao.impl.PatientDaoImpl;
import java16.midels.Patient;
import java16.service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements GeneralService<Patient>, PatientService {

    private final PatientDaoImpl patientDao;

    public PatientServiceImpl(PatientDaoImpl patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public String save(Long id, Patient patient) {

        return patientDao.save(id, patient);
    }

    @Override
    public String updateById(Long id, Patient patient) {
        return patientDao.updateById(id, patient);
    }

    @Override
    public void deleteById(Long id) {
        patientDao.deleteById(id);

    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {

        return patientDao.addPatientsToHospital(id, patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDao.getPatientById(id);
    }

    @Override
    public Map<Integer, List<Patient>> getPatientByAge() {


        return patientDao.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDao.sortPatientsByAge(ascOrDesc);
    }
}
