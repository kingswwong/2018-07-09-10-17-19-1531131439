package practice11;


import java.util.LinkedList;

public class Teacher extends Person {
    private LinkedList<Klass> classes;

    public Teacher(int id, String name, int age, LinkedList<Klass> classes) {
        super(id, name, age);
        this.classes = classes;
        for(Klass klass: classes){
            klass.getTeachers().add(this);
        }
    }

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(String name, int age) {
        super(name, age);
    }


    public LinkedList<Klass> getClasses() {
        return classes;
    }

    public void setClasses(LinkedList<Klass> classes) {
        this.classes = classes;
    }

    @Override
    public String introduce() {
        String real_klass;
        if(classes != null && classes.size() > 0){
            real_klass = "Class";
            for(int i = 0;i < classes.size();i++){
                real_klass += " " + classes.get(i).getNumber() + "";
                if(i != classes.size() - 1){
                    real_klass += ",";
                }
            }
        }else{
            real_klass = "No Class";
        }
        return super.introduce() + " " + String.format("I am a Teacher. I teach %s.", real_klass);
    }

    public String introduceWith(Student student) {
        String result;
        result = classes != null && classes.size() > 0 && isTeaching(student) ? String.format(" I teach %s.", student.getName()) : String.format(" I don't teach %s.", student.getName());
        return super.introduce() + " I am a Teacher." + result;
    }

    public boolean isTeaching(Student student){
        for(Klass klass : classes){
            if(klass.isIn(student)){
                return true;
            }
        }
        return false;
    }
}
