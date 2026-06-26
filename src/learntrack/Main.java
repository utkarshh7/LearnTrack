package learntrack;

import learntrack.exception.EntityNotFoundExcep;
import learntrack.service.CourseService;
import learntrack.service.EnrollmentService;
import learntrack.service.StudentService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        EnrollmentService enrollmentService = new EnrollmentService();

        while (true) {

            System.out.println("\n=====================================");
            System.out.println("         LEARNTRACK SYSTEM");
            System.out.println("=====================================");
            System.out.println("1.  Add Student");
            System.out.println("2.  View Students");
            System.out.println("3.  Search Student");
            System.out.println("4.  Deactivate Student");
            System.out.println("-------------------------------------");
            System.out.println("5.  Add Course");
            System.out.println("6.  View Courses");
            System.out.println("7.  Search Course");
            System.out.println("8.  Activate Course");
            System.out.println("9.  Deactivate Course");
            System.out.println("-------------------------------------");
            System.out.println("10. Enroll Student");
            System.out.println("11. View All Enrollments");
            System.out.println("12. View Student Enrollments");
            System.out.println("13. Complete Enrollment");
            System.out.println("14. Cancel Enrollment");
            System.out.println("-------------------------------------");
            System.out.println("0. Exit");
            System.out.print("Enter Choice : ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    studentService.addStudent();
                    System.out.println("Student has been added!");
                    break;

                case 2:
                    studentService.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Student ID : ");
                    int studentId = scanner.nextInt();
                    try{
                        System.out.println(studentService.findByStudentId(studentId));
                    }
                    catch(EntityNotFoundExcep e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID : ");
                    studentId = scanner.nextInt();
                    try{
                        studentService.deactivateStudent(studentId);
                    }
                    catch(EntityNotFoundExcep e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Student Deactivated.");
                    break;

                case 5:
                    courseService.addCourse();
                    System.out.println("Course has been added!");
                    break;

                case 6:
                    courseService.viewCourses();
                    break;

                case 7:
                    System.out.print("Enter Course ID : ");
                    int courseId = scanner.nextInt();
                    try{
                        System.out.println(courseService.findByCourseId(courseId));
                    }
                    catch(EntityNotFoundExcep e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 8:
                    System.out.print("Enter Course ID : ");
                    courseId = scanner.nextInt();
                    try{
                        courseService.activateCourse(courseId);
                    }
                    catch(EntityNotFoundExcep e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Course Activated.");
                    break;

                case 9:
                    System.out.print("Enter Course ID : ");
                    courseId = scanner.nextInt();
                    try{
                        courseService.deactivateCourse(courseId);
                    }
                    catch(EntityNotFoundExcep e){
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Course Deactivated.");
                    break;

                case 10:
                    try{
                        enrollmentService.enrollStudent();
                    }
                    catch(EntityNotFoundExcep e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 11:
                    enrollmentService.viewEnrollments();
                    break;

                case 12:
                    System.out.print("Enter Student ID : ");
                    studentId = scanner.nextInt();
                    try{
                        enrollmentService.viewStudentEnrollment(studentId);
                    }
                    catch(EntityNotFoundExcep e){
                        System.out.println(e.getMessage());
                    }
                    break;

                case 13:
                    System.out.print("Enter Student ID : ");
                    studentId = scanner.nextInt();
                    enrollmentService.completeEnrollment(studentId);
                    break;

                case 14:
                    System.out.print("Enter Student ID : ");
                    studentId = scanner.nextInt();
                    enrollmentService.cancelEnrollment(studentId);
                    break;

                case 0:
                    System.out.println("Thank You For Using LearnTrack!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}