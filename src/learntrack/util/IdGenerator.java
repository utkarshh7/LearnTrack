package learntrack.util;

public class IdGenerator {
     private static int studentCounter = 0;
     private static int courseCounter = 1000;

     public static int genStudentId(){
          studentCounter++;
          return studentCounter;
     }

     public static int genCourseId(){
          courseCounter++;
          return courseCounter;
     }
}