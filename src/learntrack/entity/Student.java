package learntrack.entity;

public class Student extends Person {

    private int id;
    private boolean active;

    public Student(int id,
                   String name,
                   String email,
                   boolean active){

        super(name, email);

        this.id = id;
        this.active = active;
    }

    public int getId(){
        return id;
    }

    public boolean isActive(){
        return active;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setActive(boolean active){
        this.active = active;
    }

    @Override
    public String toString(){
        return "Student ID: " + id +
                ", Name: " + name +
                ", Email: " + email +
                ", Active: " + active;
    }
}