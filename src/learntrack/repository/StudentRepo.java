package learntrack.repository;
import learntrack.entity.Student;
import java.util.ArrayList;

public class StudentRepo{

    private ArrayList<Student> students;
    public StudentRepo(){
        students = new ArrayList<>();
    }

    public void save(Student student){
        students.add(student);
    }

    public ArrayList<Student> findAll(){
        return students;
    }

    public Student findById(int id){
        for(Student student : students){
            if(student.getId() == id){
                return student;
            }
        }

        return null;
    }
}