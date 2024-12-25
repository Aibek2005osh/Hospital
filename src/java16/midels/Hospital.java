package java16.midels;

import java.util.List;

public class Hospital {
    private Long id;
    private String hospitalName;
    private String adderss;
    private List<Department> departments;
    private List<Doctor> doctors;
    private List<Patient> patients;

    private static Long genId = 1L;

    public Hospital() {
        this.id = genId++;
    }

    public Hospital(String hospitalName, String adderss, List<Department> departments, List<Doctor> doctors, List<Patient> patients) {
        this.id = genId++;
        this.hospitalName = hospitalName;
        this.adderss = adderss;
        this.departments = departments;
        this.doctors = doctors;
        this.patients = patients;
    }

    public Hospital( String hospitalName, String adderss) {
        this.id = genId++;
        this.hospitalName = hospitalName;
        this.adderss = adderss;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAdderss() {
        return adderss;
    }

    public void setAdderss(String adderss) {
        this.adderss = adderss;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    @Override
    public String toString() {
        return " \n      Hospital" +"\n"+
               "id           : " + id +"\n"+
               "hospitalName : " + hospitalName + '\n' +
               "adderss      : " + adderss + '\n' +
               "departments  : " + departments +"\n"+
               "doctors      : " + doctors +"\n"+
               "patients     : " + patients + "\n\n";
    }
}
