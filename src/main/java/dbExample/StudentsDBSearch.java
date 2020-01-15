package dbExample;

import java.sql.*;
import java.util.Scanner;

public class StudentsDBSearch {
    // shemaDB can be found in resources folder
    private static final String dbUrl = "jdbc:mysql://localhost:3306/testDB";
    private static final String user = "root";
    private static final String query1 = "select id, fio from students";
    private static final String query2 = "select id, group_name from groups";
    private static final String query3 = "select fio, group_name from students join groups on group_id = groups.id where group_id = ?";
    private static final String query4 = "select fio, year(enter_date) from students order by enter_date";
    private static final String query5 = "select students.fio as student, class_name, grade, teachers.fio as teacher from students join grades on students.id = grades.student_id join classes on class_id = classes.id join teachers on teacher_id = teachers.id order by students.fio";
    private static final String query6 = "select fio, AVG(grade) from students join grades on students.id = grades.student_id group by fio";

    public static void main(String[] args) throws SQLException, InterruptedException {
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
                getStudentListByGroup(mySt, connection);
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
        ResultSet myRs = mySt.executeQuery(query1);
        System.out.println("-----ALL STUDENT RESULTS-----");

        while (myRs.next()){
            System.out.print(myRs.getInt(1));
            System.out.print(": ");
            String row = String.format("%s", myRs.getString(2));
            System.out.println(row);
        }
    }

    private static void getStudentListByGroup(Statement mySt, Connection connection) throws SQLException, InterruptedException {
        System.out.println("Our Student Groups are following :");
        ResultSet myRss = mySt.executeQuery(query2);

        while (myRss.next()){
            System.out.print(myRss.getInt(1));
            System.out.print(": ");
            String row = String.format("%s", myRss.getString(2));
            System.out.println(row);
        }

        Scanner sc = new Scanner(System.in);
        Thread.sleep(1000);

        System.err.println("Students from which group you want to get results? Input group id you are interested in ");
        int groupId = sc.nextInt();

        PreparedStatement myPs = connection.prepareStatement(query3);
        myPs.setInt(1, groupId);
        ResultSet myRs = myPs.executeQuery();

        while (myRs.next()){
            String row = String.format("%s", myRs.getString(1));
            System.out.println(row);
        }
    }

    private static void getStudentListByEnterYear(Statement mySt) throws SQLException {
        ResultSet myRs = mySt.executeQuery(query4);
        System.out.println("-----STUDENTS BY ENTER YEAR RESULTS-----");
        // used metadata to get column names
        ResultSetMetaData meta = myRs.getMetaData();
        String header = String.format("%-21s%s", meta.getColumnName(1), meta.getColumnName(2));
        System.out.println(header);

        while (myRs.next()){
            String row = String.format("%-21s", myRs.getString(1));
            System.out.print(row);
            System.out.println(myRs.getString(2));
        }
    }

    private static void getStudentClassesAndGradesWithTeachers(Statement mySt) throws SQLException {
        ResultSet myRs = mySt.executeQuery(query5);
        System.out.println("-----STUDENTS, CLASSES, GRADES AND TEACHERS RESULTS-----");

        ResultSetMetaData meta = myRs.getMetaData();
        String header = String.format("%-20s%-35s%-12s%s",
                meta.getColumnName(1),
                meta.getColumnName(2),
                meta.getColumnName(3),
                meta.getColumnName(4));
        System.out.println(header);

        while (myRs.next()){
            System.out.print(String.format("%-20s", myRs.getString(1)));
            System.out.print(String.format("%-35s", myRs.getString(2)));
            System.out.print(String.format("%-12s", myRs.getString(3)));
            System.out.println(myRs.getString(4));
        }
    }

    private static void getStudentsAndTheirAverageGrades(Statement mySt) throws SQLException {
        ResultSet myRs = mySt.executeQuery(query6);
        System.out.println("-----ALL STUDENT RESULTS-----");

        ResultSetMetaData meta = myRs.getMetaData();
        String header = String.format("%-21s%s", meta.getColumnName(1), meta.getColumnName(2));
        System.out.println(header);

        while (myRs.next()){
            System.out.print(String.format("%-21s", myRs.getString(1)));
            System.out.println(myRs.getString(2));
        }
    }
}
