package learntrack.service;

import learntrack.entity.Course;
import learntrack.exception.EntityNotFoundExcep;
import learntrack.repository.CourseRepo;
import learntrack.util.IdGenerator;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseService {
    private CourseRepo courses;
    Scanner scanner = new Scanner(System.in);

    public CourseService(){
        courses = new CourseRepo();
    }

    public void addCourse(){
        System.out.println("Enter Course Name: ");
        String name = scanner.nextLine();
        int id = IdGenerator.genCourseId();

        Course course = new Course(id, name, true);
        courses.save(course);
    }

    public void viewCourses(){
        ArrayList<Course> courseList = courses.findAll();
        for(Course course : courseList){
            System.out.println(course);
        }
    }

    public Course findByCourseId(int id) throws EntityNotFoundExcep {
        Course course = courses.findById(id);
        if (course == null){
            throw new EntityNotFoundExcep("Course Not Found");
        }
        return course;
    }

    public void activateCourse(int id) throws EntityNotFoundExcep {
        Course course = courses.findById(id);
        if(course == null){
            throw new EntityNotFoundExcep("Course Not Found");
        }
        course.setActive(true);
    }

    public void deactivateCourse(int id) throws EntityNotFoundExcep {
        Course course = courses.findById(id);
        if(course == null){
            throw new EntityNotFoundExcep("Course Not Found");
        }
        course.setActive(false);
    }
}
