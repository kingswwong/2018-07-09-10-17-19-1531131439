package practice11;


import java.util.ArrayList;

public class Klass {
    private int number;
    private Student leader;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Klass(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDisplayName() {
        return String.format("Class %d", this.getNumber());
    }

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public void assignLeader(Student student) {
        if (student.getKlass() == null || student.getKlass().getNumber() != this.number) {
            System.out.print("It is not one of us.\n");
        } else {
            this.leader = student;
            for(Teacher teacher: teachers){
                teacher.notifyWhenStudentBecomeLeader(student);
            }
//            this.teachers.forEach(teacher -> System.out.print(String.format("I am %s. I know %s become Leader of Class %d.\n", teacher.getName(), student.getName(), number)));
        }
    }

    public void appendMember(Student student) {
        student.setKlass(this);
        students.add(student);
        for(Teacher teacher: teachers){
            teacher.notifyWhenStudentBecomeLeader(student);
        }
//        this.teachers.forEach(teacher -> System.out.print(String.format("I am %s. I know %s has joined Class %s.\n", teacher.getName(), student.getName(), number)));
    }

    public boolean isIn(Student student){
        return student.getKlass().number == this.number ? true : false;
    }
}
