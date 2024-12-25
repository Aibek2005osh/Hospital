package java16.midels;

import java.util.List;

public class Department {
    private Long id;
    private String departmentName;
    private List<Doctor> doctors;

    private static Long genId =1L;

    public Department() {
        this.id = genId++;

    }

    public Department( String departmentNane, List<Doctor> doctors) {
        this.id = genId++;
        this.departmentName = departmentNane;
        this.doctors = doctors;
    }

    public Department(String departmentName) {
        this.id=genId++;
        this.departmentName = departmentName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public String toString() {
        return "\n     Department    " + "\n" +
               "id             : " + id + "\n" +
               "departmentNane : " + departmentName + '\n' +
               "doctors        : " + doctors + '\n';
    }
}
