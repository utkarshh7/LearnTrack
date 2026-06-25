package learntrack.entity;

public class Course {
    private int courseId;
    private String courseName;
    private boolean active;

    public Course(int courseId,
                  String courseName,
                  boolean active){

        this.courseId = courseId;
        this.courseName = courseName;
        this.active = active;
    }

    public int getCourseId(){
        return courseId;
    }
    public String getCourseName() {
        return courseName;
    }

    public boolean isActive() {
        return active;
    }

    public void setCourseId(int courseId){
        this.courseId = courseId;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    public void setActive(boolean active){
        this.active = active;
    }

    @Override
    public String toString(){
        return "Course ID: " + courseId +
                ", Course Name: " + courseName +
                ", Active: " + active;
    }

}
