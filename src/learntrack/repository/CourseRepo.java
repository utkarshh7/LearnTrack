package learntrack.repository;
import learntrack.entity.Course;
import java.util.ArrayList;

public class CourseRepo {
    private static ArrayList<Course> courses;
    public CourseRepo(){
        if(courses == null){
            courses = new ArrayList<>();
        }
    }

    public void save(Course course){
        courses.add(course);
    }

    public ArrayList<Course> findAll(){
        return courses;
    }
    public Course findById(int id){
        for(Course course : courses){
            if(course.getCourseId() == id){
                return course;
            }
        }
        return null;
    }
}
