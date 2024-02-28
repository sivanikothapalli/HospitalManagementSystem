package hospitalmanagementsystem;

import java.sql.*;
import java.util.Scanner;

public class HospitalManagementSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hospital";
    private static final String username = "root";
    private static final String password = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Patient patient = new Patient(connection, scanner);
            Doctor doctor = new Doctor(connection);

            while (true) {
                System.out.println("HOSPITAL MANAGEMENT SYSTEM");
                System.out.println("1. Add Patient");
                System.out.println("2. view Patient");
                System.out.println("3. view Doctors");
                System.out.println("4. Book Appointment");
                System.out.println("5. Exit");
                System.out.println("Enter Your Choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        //Add patient
                        patient.addPatient();
                        System.out.println();
                        break;
                    case 2:
                        //view patient
                        patient.viewpatients();
                        System.out.println();
                        break;
                    case 3:
                        //view Doctors
                        doctor.viewDoctors();
                        System.out.println();
                        break;
                    case 4:
                        //Book Appointment
                        BookAppointment.bookAppointment(patient, doctor, connection, scanner);
                        System.out.println();
                        break;
                    case 5:
                         System.out.println("THANK YOU! FOR USING HOSPITAL MANAGEMENT SYSTEM");
                        return;
                    default:
                        System.out.println("Enter valid choice!!!");
                        break;
                }
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}


