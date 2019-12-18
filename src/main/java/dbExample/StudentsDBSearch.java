package dbExample;

import java.sql.*;
import java.util.Scanner;

public class StudentsDBSearch {
    // shemaDB can be found in resources folder
    private static final String dbUrl = "jdbc:mysql://localhost:3306/testDB";
    private static final String user = "root";

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(dbUrl,user,"");
        System.out.println("SQL Connection to database established!");
        Statement mySt = connection.createStatement();
        Scanner scanner = new Scanner(System.in);
        System.err.println("Please Input:" +
                " 1 - Get All Students" +
                " 2 - Students by groups" +
                " 3 - Students by enter year" +
                " 4 - Student, their classes, grades and teachers" +
                " 5 - Average grade for student");
        int input = scanner.nextInt();

        switch (input){
            case 1:
                getAllStudentList(mySt);
                break;
            case 2:
                getStudentListByGroup(mySt);
                break;
            case 3:
                getStudentListByEnterYear(mySt);
                break;
            case 4:
                getStudentClassesAndGradesWithTeachers(mySt);
                break;
            case 5:
                getStudentsAndTheirAverageGrades(mySt);
                break;
            default:
                System.err.println("Incorrect input");
        }
        connection.close();
    }

    private static void getAllStudentList(Statement mySt) throws SQLException {
        ResultSet myRs = mySt.executeQuery("select fio from students");
        System.out.println("-----ALL STUDENT RESULTS-----");
        while (myRs.next()){
            System.out.print("Student : " + myRs.getString("fio"));
            System.out.println();
        }
    }

    private static void getStudentListByGroup(Statement mySt) throws SQLException {
        ResultSet myRs = mySt.executeQuery("select fio, group_name from students join groups on group_id = groups.id order by groups.id");
        System.out.println("-----STUDENTS BY GROUP RESULTS-----");
        while (myRs.next()){
            System.out.print("Student : " + myRs.getString("fio") + " || Group : " + myRs.getString("group_name"));
            System.out.println();
        }
    }

    private static void getStudentListByEnterYear(Statement mySt) throws SQLException {
        ResultSet myRs = mySt.executeQuery("select fio, year(enter_date) from students order by enter_date");
        System.out.println("-----STUDENTS BY ENTER YEAR RESULTS-----");
        while (myRs.next()){
            System.out.print("Student : " + myRs.getString("fio") + " || ENTER YEAR : " + myRs.getString("year(enter_date)"));
            System.out.println();
        }
    }

    private static void getStudentClassesAndGradesWithTeachers(Statement mySt) throws SQLException {
        ResultSet myRs = mySt.executeQuery("select students.fio as student, class_name, grade, teachers.fio as teacher from students join grades on students.id = grades.student_id join classes on class_id = classes.id join teachers on teacher_id = teachers.id order by students.fio");
        System.out.println("-----STUDENTS, CLASSES, GRADES AND TEACHERS RESULTS-----");
        while (myRs.next()){
            System.out.print("Student : " + myRs.getString("student")
                    + " || Class : " + myRs.getString("class_name")
                    + " || Grade : " + myRs.getInt("grade")
                    + " || Teacher : " + myRs.getString("teacher") );
            System.out.println();
        }
    }

    private static void getStudentsAndTheirAverageGrades(Statement mySt) throws SQLException {
        ResultSet myRs = mySt.executeQuery("select fio, AVG(grade) from students join grades on students.id = grades.student_id group by fio");
        System.out.println("-----ALL STUDENT RESULTS-----");
        while (myRs.next()){
            System.out.print("Student : " + myRs.getString("fio") + " || Average : " + myRs.getString("AVG(grade)"));
            System.out.println();
        }
    }
}
