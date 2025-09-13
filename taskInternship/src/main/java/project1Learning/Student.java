package project1Learning;

public class Student {


//    Create a Student class with id, name, and grade.
//    Add a constructor and toString() method for display.
//    Create an ArrayList<Student> in the main class.
//    Write addStudent() method to add a new student.
//            Write removeStudent() method to delete by ID.
//    Write displayStudents() method to show a l students.
//    Use a loop or menu for user input (add/remove/list).
//    Run and test with sample data

    private Long id;
    private String name;
    private String grade;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Default constructor
    public Student() {
    }

    // Parameterized constructor
    public Student(Long id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
