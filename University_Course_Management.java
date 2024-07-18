import java.util.ArrayList;
import java.util.Scanner;

class Student{
    String name, id;
    ArrayList<Course> course_student = new ArrayList<>();

    void add_course(Course obj){
        course_student.add(obj);
    }

}
class Course{
    String CourseName, Instructor;
    int credit;
    static ArrayList<Student> enrolled_student = new ArrayList<>();

    void add_student(Student obj){
        enrolled_student.add(obj);
    }
    void report(){
        for (Student report : enrolled_student){
            System.out.println("Id: "+report.id);
            System.out.println("Name: "+report.name);
            for (Course student : report.course_student){
                System.out.println("Course Name: "+student.CourseName);
                System.out.println("Instructor: "+student.Instructor);
                System.out.println("Credits: "+student.credit);

            }
        }
    }
    void credit(String id){
        int total_amount = 0;
        for (Student course : enrolled_student){
            if (course.id.equals(id)){
                for (Course credits : course.course_student){
                    total_amount += (credits.credit);
                }
            }
        }
        System.out.println("Total Amount: "+total_amount);
    }

}



public class University_Course_Management {
    public  static void main(String[]args){
        System.out.println("------University Course Management System------");

        String end_program = "";
        do {
            System.out.println("What you want to do ? ");
            System.out.println("A) Enroll");
            System.out.println("B) Report");
            System.out.println("C) Credits");
            Scanner user = new Scanner(System.in);
            String user_choose = user.nextLine().toLowerCase();
            switch (user_choose){
                case "enroll":
                    Scanner enroll = new Scanner(System.in);
                    System.out.print("Id: ");
                    String id = enroll.nextLine();
                    System.out.print("Name: ");
                    String name = enroll.nextLine();
                    System.out.print("Course Name: ");
                    String course_e = enroll.nextLine();
                    System.out.print("Instructor Name: ");
                    String  instructor = enroll.nextLine();
                    System.out.println("Course Credits: ");
                    int credits = enroll.nextInt();
                    Student student = new Student();
                    student.name=name;
                    student.id=id;
                    Course course = new Course();
                    course.CourseName = course_e;
                    course.Instructor = instructor;
                    course.credit = credits;
                    student.add_course(course);
                    course.add_student(student);
                    break;
                case "report":
                    Course courseR = new Course();
                    courseR.report();
                    break;
                case "credits":
                    Scanner credit_student = new Scanner(System.in);
                    System.out.print("Id: ");
                    String id_credit = credit_student.nextLine();
                    Course courseC = new Course();
                    courseC.credit(id_credit);
                    break;
            }
            System.out.print("Do you want to continue (y or n) ? ");
            Scanner user_end = new Scanner(System.in);
            end_program = user_end.nextLine().toLowerCase();

        }while (end_program.equals("y"));
    }

}
