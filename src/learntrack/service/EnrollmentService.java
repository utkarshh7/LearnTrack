package learntrack.service;

import learntrack.entity.Course;
import learntrack.entity.Enrollment;
import learntrack.entity.Student;
import learntrack.enums.EnrollmentStatus;
import learntrack.exception.EntityNotFoundExcep;
import learntrack.repository.CourseRepo;
import learntrack.repository.EnrollmentRepo;
import learntrack.repository.StudentRepo;

import java.util.ArrayList;
import java.util.Scanner;

public class EnrollmentService {
    private StudentRepo students;
    private CourseRepo courses;
    private EnrollmentRepo enrollments;

    Scanner scanner = new Scanner(System.in);

    public EnrollmentService(){
        students = new StudentRepo();
        courses = new CourseRepo();
        enrollments = new EnrollmentRepo();
    }

    public void enrollStudent() throws EntityNotFoundExcep {
        int studentId = scanner.nextInt();
        Student student = students.findById(studentId);
        if(student == null){
            throw new EntityNotFoundExcep("Student Not Found");
        }
        int courseId = scanner.nextInt();
        Course course = courses.findById(courseId);
        if(course == null){
            throw new EntityNotFoundExcep("Course Not Found");
        }
        Enrollment enrollment = new Enrollment(student, course, EnrollmentStatus.ACTIVE);
        enrollments.save(enrollment);
    }

    public void viewEnrollments(){
        ArrayList<Enrollment> enrollmentList = enrollments.findAll();
        for(Enrollment enrollment : enrollmentList){
            System.out.println(enrollment);
        }
    }

    public void viewStudentEnrollment(int id) throws EntityNotFoundExcep {
        Student student = students.findById(id);
        if(student == null){
            throw new EntityNotFoundExcep("Student Not Found");//
        }

        ArrayList<Enrollment> enrollmentList = enrollments.findAll();
        for(Enrollment enrollment : enrollmentList) {
            if (enrollment.getStudent().getId() == student.getId()) {
                System.out.println(enrollment);
            }
        }
    }

    public void completeEnrollment(int id){
        ArrayList<Enrollment> enrollmentList = enrollments.findAll();
        for(Enrollment enrollment : enrollmentList){
            if(enrollment.getStudent().getId() == id){
                enrollment.setStatus(EnrollmentStatus.COMPLETED);
            }
        }
    }

    public void cancelEnrollment(int id){
        ArrayList<Enrollment> enrollmentList = enrollments.findAll();
        for(Enrollment enrollment : enrollmentList){
            if(enrollment.getStudent().getId() == id){
                enrollment.setStatus(EnrollmentStatus.CANCELLED);
            }
        }
    }


}
