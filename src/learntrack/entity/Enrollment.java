package learntrack.entity;

import learntrack.enums.EnrollmentStatus;

public class Enrollment {
    private Student student;
    private Course course;
    private EnrollmentStatus status;

    public Enrollment(Student student,
                      Course course,
                      EnrollmentStatus status){
        this.student = student;
        this.course = course;
        this.status = status;
    }

    public Student getStudent(){
        return student;
    }

    public  Course getCourse(){
        return course;
    }

    public EnrollmentStatus getStatus(){
        return status;
    }

    public void setStudent(Student student){
        this.student = student;
    }

    public void setCourse(Course course){
        this.course = course;
    }

    public void setStatus(EnrollmentStatus status){
        this.status = status;
    }

    @Override
    public String toString(){
        return "Student Details: " + student +
                ", Course Details: "+ course +
                ", Status: " + status;
    }

}
