package learntrack.repository;
import learntrack.entity.Enrollment;
import java.util.ArrayList;

public class EnrollmentRepo {

    private ArrayList<Enrollment> enrollments;
    public EnrollmentRepo(){
        enrollments = new ArrayList<>();
    }

    public void save(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> findAll() {
        return enrollments;
    }

    public ArrayList<Enrollment> findByStudentName(String name) {
        ArrayList<Enrollment> results = new ArrayList<>();
        for (Enrollment enrollment : enrollments){
            if (enrollment.getStudent().getName().equals(name)) {
                results.add(enrollment);
            }
        }
        return results;
    }
}