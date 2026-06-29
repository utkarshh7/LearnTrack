package learntrack.service;

import learntrack.entity.Student;
import learntrack.exception.EntityNotFoundExcep;
import learntrack.repository.StudentRepo;
import learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {
    private static StudentRepo students;
    Scanner scanner = new Scanner(System.in);

    public StudentService(){
        students = new StudentRepo();
    }
    public void addStudent(){
        System.out.println("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Student E-Mail: ");
        String email = scanner.nextLine();

        int id = IdGenerator.genStudentId();

        Student student = new Student(id, name, email, true);

        students.save(student);
    }

    public void viewStudents(){
        ArrayList<Student> studentList = students.findAll();
        if(studentList.isEmpty()){
            System.out.println("No students found.");
        }
        for(Student student : studentList){
            System.out.println(student);
        }
    }

    public Student findByStudentId(int id) throws EntityNotFoundExcep {
        Student student = students.findById(id);
        if(student == null){
            throw new EntityNotFoundExcep("Student Not Found");
        }
        return student;
    }

    public void deactivateStudent(int id) throws EntityNotFoundExcep {
        Student student = students.findById(id);
        if(student == null){
            throw new EntityNotFoundExcep("Student Not Found");
        }
        student.setActive(false);
    }

}