import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        File studentFile = new File("src/student.txt");
        File teacherFile = new File("src/teacher.txt");
        Scanner studentScanner = new Scanner(studentFile);
        Scanner teacherScanner = new Scanner(teacherFile);
        ArrayList<Student> students = new ArrayList<>();
        while (studentScanner.hasNextLine()) {
            String line = studentScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            String name = lineScanner.next();
            String surname = lineScanner.next();
            int age = Integer.parseInt(lineScanner.next());
            boolean gender = lineScanner.next().equals("Male");
            Student student = new Student(name, surname, age, gender);
            while (lineScanner.hasNextInt()) {
                student.addGrade(lineScanner.nextInt());
            }
            students.add(student);
        }
        ArrayList<Teacher> teachers = new ArrayList<>();
        while (teacherScanner.hasNextLine()) {
            String line = teacherScanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            String name = lineScanner.next();
            String surname = lineScanner.next();
            int age = Integer.parseInt(lineScanner.next());
            boolean gender = lineScanner.next().equals("Male");
            String subject = lineScanner.next();
            int years = Integer.parseInt(lineScanner.next());
            int salary = Integer.parseInt(lineScanner.next());
            Teacher teacher = new Teacher(name, surname, age, gender, subject, years, salary);
            teachers.add(teacher);
        }
        School hogwarts = new School();
        for (Teacher teacher : teachers) {
            if ((teacher.getYearsOfExperience() >= 10) && (teacher.getYearsOfExperience() < 20)) {
                teacher.giveRaise(10);
            } else if ((teacher.getYearsOfExperience() >= 20) && (teacher.getYearsOfExperience() < 40)) {
                teacher.giveRaise(25);
            } else if (teacher.getYearsOfExperience() >= 40) {
                teacher.giveRaise(50);
            }
            hogwarts.addMember(teacher);
        }
        for (Student student : students) {
            hogwarts.addMember(student);
        }
        System.out.println(hogwarts);
    }
}