package java16;

import java16.dao.db.Datebase;
import java16.dao.impl.DepartmentDaoImpl;
import java16.dao.impl.DoctorDaoImpl;
import java16.dao.impl.HospitalDaoImpl;
import java16.dao.impl.PatientDaoImpl;
import java16.enums.Gender;
import java16.midels.Department;
import java16.midels.Doctor;
import java16.midels.Hospital;
import java16.midels.Patient;
import java16.service.HospitalService;
import java16.service.PatientService;
import java16.service.impl.DepartmentServiceImpl;
import java16.service.impl.DoctorServiceImpl;
import java16.service.impl.HospitalServiceImpl;
import java16.service.impl.PatientServiceImpl;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    static Scanner scannerStr = new Scanner(System.in);
    static Scanner scannerInt = new Scanner(System.in);
    static HospitalDaoImpl hospitalDao = new HospitalDaoImpl();
    static HospitalService hospitalService = new HospitalServiceImpl(hospitalDao);

    static PatientDaoImpl patientDao = new PatientDaoImpl();
    static PatientServiceImpl patientService = new PatientServiceImpl(patientDao);

    static DepartmentDaoImpl departmentDao = new DepartmentDaoImpl();
    static DepartmentServiceImpl departmentService = new DepartmentServiceImpl(departmentDao);

    static DoctorDaoImpl doctorDao = new DoctorDaoImpl(departmentDao);
    static DoctorServiceImpl doctorService = new DoctorServiceImpl(doctorDao);

    public static void main(String[] args) {


        t();
        while (true) {
            System.out.print("""
                    -Press to ➡ 0. exit
                    -Press to ➡ 1. add hospital
                    -Press to ➡ 2. find hospital by id
                    -Press to ➡ 3. get all hospital
                    -Press to ➡ 4. get all patient from hospital
                    -Press to ➡ 5. delete hospital by id
                    -Press to ➡ 6. get all hospital by address
                    -Press to ➡ 7. add patient
                    -Press to ➡ 8. remove patient by id
                    -Press to ➡ 9. update patient by id
                    -Press to ➡ 10. add patients to hospital
                    -Press to ➡ 11. get patient by id
                    -Press to ➡ 12. get patient by age
                    -Press to ➡ 13. sort patients by age
                    -Press to ➡ 14. add doctor
                    -Press to ➡ 15. remove doctor by id
                    -Press to ➡ 16. update doctor by id
                    -Press to ➡ 17. find doctor by id
                    -Press to ➡ 18. assign doctor to department
                    -Press to ➡ 19. get all doctors by hospital  id
                    -Press to ➡ 20. get all doctors by department id
                    -Press to ➡ 21. add department
                    -Press to ➡ 22. remove department
                    -Press to ➡ 23. update department
                    -Press to ➡ 24. get all department by hospital id
                    -Press to ➡ 25. find department by name
                    
                    """);

            switch (comand()) {
                case 0 -> {
                    System.out.println(Arrays.toString(Datebase.hospitalList.toArray()));
                }
                case 1 -> {
                    System.out.println(hospitalService.addHospital(case1()));
                }
                case 2 -> {
                    System.out.println(hospitalService.findHospitalById(case2()));
                }
                case 3 -> {
                    case3();
                }
                case 4 -> {
                    System.out.println(hospitalService.getAllPatientFromHospital(case4()));
                }
                case 5 -> {
                    System.out.println(hospitalService.deleteHospitalById(case5()));
                }
                case 6 -> {
                    System.out.println(hospitalService.getAllHospitalByAddress(case6()));
                }
                case 7 -> {
                    System.out.println(patientService.save(case5(), case7()));
                }
                case 8 -> {
                    patientService.deleteById(case5());
                }
                case 9 -> {
                    System.out.println(patientService.updateById(case5(), case7()));
                }
                case 10 -> {
                    patientService.addPatientsToHospital(case5(), case10());
                }
                case 11 -> {
                    System.out.println(patientService.getPatientById(case5()));
                }
                case 12 -> {
                    System.out.println(patientService.getPatientByAge());
                }

                case 13 -> {
                    System.out.println(patientService.sortPatientsByAge(case13()));
                }
                case 14 -> {
                    System.out.println(doctorService.save(case5(), case14()));
                }
                case 15 -> {
                    doctorService.deleteById(case5());
                }
                case 16 -> {
                    System.out.println(doctorService.updateById(case5(), case14()));
                }
                case 17 -> {
                    System.out.println(doctorService.findDoctorById(case5()));
                }
                case 18 -> {

                    System.out.println(doctorService.assignDoctorToDepartment(case5(), case18()));
                }
                case 19 -> {
                    System.out.println(departmentDao.getAllDepartmentByHospital(case5()));
                }
                case 20 -> {
                    System.out.println(doctorService.getAllDoctorsByDepartmentId(case5()));
                }
                case 21 -> {
                    System.out.println(departmentService.save(case5(), case21())
                    );

                }
                case 22 -> {
                    departmentService.deleteById(case5());
                }
                case 23 -> {
                    System.out.println(departmentService.updateById(case5(),case21()));

                }
                case 24 -> {
                    System.out.println(departmentService.getAllDepartmentByHospital(case5()));
                }
                case 25 -> {

                    System.out.println(departmentService.findDepartmentByName(case25()));
                }

            }

        }
    }

    public static Hospital case1() {
        Hospital hospital = new Hospital();
        System.out.print("HOSPITAL АТЫН ЖАЗЫНЫЗ : ");
        String name = scannerStr.nextLine();
        hospital.setHospitalName(name);

        System.out.print("HOSPITAL АДРЕС ЖАЗЫНЫЗ : ");
        String string = scannerStr.nextLine();
        hospital.setAdderss(string);
        hospital.setDepartments(new ArrayList<>());
        hospital.setDoctors(new ArrayList<>());
        hospital.setPatients(new ArrayList<>());
        return hospital;
    }

    public static Long case2() {
        System.out.println("HOSPITAL ID : ");
        return scannerInt.nextLong();
    }

    public static void case3() {
        System.out.println(hospitalService.getAllHospital());
    }

    public static Long case4() {
        System.out.print("HASPITAL ID : ");
        return scannerInt.nextLong();
    }

    public static Long case5() {
        System.out.print("ID ЖАЗЫНЫЗ : ");
        return scannerInt.nextLong();
    }

    public static String case6() {
        System.out.println("HOSPITAL ADD ЖАЗЫНЫЗ : ");
        return scannerStr.nextLine();

    }

    public static Patient case7() {

        System.out.print("PATIENT АТЫН ЖЫЗЫНЫЗ : ");
        String s1 = scannerStr.nextLine();

        System.out.print("PATIENT ФАМИЯСЫН ЖАЗЫНЫЗ : ");
        String s2 = scannerStr.nextLine();

        System.out.print("PATIENT GENDER M/F ЖАЗЫНЫЗ : ");
        String s3 = scannerStr.nextLine().toLowerCase().toUpperCase();
        Gender gender = null;

        if (s3.equals("M") || s3.equals("MALE")) {
            gender = Gender.MALE;
        } else if (s3.equals("F") || s3.equals("FEMALE")) {
            gender = Gender.FEMALE;
        } else {
            System.out.println("МЫНДАЙ GENDER ЖООК !");
        }
        System.out.print("PATIENT ЖАШЫН ЖАЗЫНЫЗ : ");
        int s4 = scannerInt.nextInt();

        return new Patient(s1, s2, gender, s4);
    }

    public static List<Patient> case10() {
        System.out.print("КАНЧА PATIENT КОШОСУЗ: ");
        int num = scannerInt.nextInt();
        List<Patient> patients = new ArrayList<>();

        while (num <= 0) {
            num = scannerInt.nextInt();
        }
        for (int i = 0; i < num; i++) {

            Patient patient = case7();  //
            patients.add(patient);
        }
        return patients;
    }


    public static String case13() {
        System.out.print("SORT АТЫ 1-9 ЧЕЙИН ЧЫКСЫН ДЕСЕНИЗ asc ТЕСКЕРИСИ desk : ");
        return scannerStr.nextLine();


    }

    public static Doctor case14() {
        System.out.print("DOCTOR АТЫН ЖЫЗЫНЫЗ : ");
        String s1 = scannerStr.nextLine();
        System.out.print("DOCTOR ФАМИЯСЫН ЖАЗЫНЫЗ : ");
        String s2 = scannerStr.nextLine();
        System.out.print("DOCTOR GENDER- M/F ЖАЗЫНЫЗ : ");
        String s3 = scannerStr.nextLine().toLowerCase().toUpperCase();
        Gender gender = null;

        if (s3.equals("M") || s3.equals("MALE")) {
            gender = Gender.MALE;
        } else if (s3.equals("F") || s3.equals("FEMALE")) {
            gender = Gender.FEMALE;
        } else {
            System.out.println("МЫНДАЙ GENDER ЖООК !");
        }

        System.out.print("DOCTOR СТАЖЫН ЖАЗЫНЫЗ : ");
        int i = scannerInt.nextInt();

        return new Doctor(s1, s2, gender, i);


    }

    public static List<Long> case18() {
        ArrayList<Long> doctors = new ArrayList<>();
        System.out.print("КАНЧА DOCTOR КОШОСУЗ : ");
        int i = scannerInt.nextInt();
        while (i <= 0) {
            i = scannerInt.nextInt();
        }
        for (int v = 0; v < i; v++) {
            long doctor = scannerInt.nextLong();

            doctors.add(doctor);
            System.out.println();

        }
        return doctors;

    }

    public static Department case21() {
        System.out.print("DEPARTEMNT АТЫН ЖАЗЫНЫЗ : ");
        String string = scannerStr.nextLine();
        return new Department(string,new ArrayList<>());



    }
public static String case25(){
    System.out.print("DEPARTEMNT АТЫН ЖАЗЫНЫЗ : ");

    return  scannerStr.nextLine();
}
    public static int comand() {
        int command = 0;
        boolean invalidComand;
        System.out.print(" КОМАНДА ТАНДАНЫЗ : ");
        do {
            try {
                command = new Scanner(System.in).nextInt();
                invalidComand = false;
            } catch (InputMismatchException e) {
                invalidComand = true;
                System.out.println("ТУУРА ЕМЕС ТАНДОО , ТУУРА ТАНДОО КЫЛЫНЫЗ ! : ");
            }
        } while (invalidComand);
        return command;
    }

    public static void t() {
        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        if (currentTime.isAfter(LocalTime.of(6, 10)) && currentTime.isBefore(LocalTime.of(10, 0))) {
            System.out.println("   КУТМАН ТАН🤗🤗 УБАКЫТ ->🕰️ " + formattedTime);
        } else if (currentTime.isAfter(LocalTime.of(10, 18)) && currentTime.isBefore(LocalTime.of(18, 0))) {
            System.out.println("   КУТМАН КУН УБАКЫТ 🕰️-> " + formattedTime);
        } else {
            System.out.println("   КУТМЫН КЕЧ УБАКЫТ 🕰️-> " + formattedTime);
        }
    }
}