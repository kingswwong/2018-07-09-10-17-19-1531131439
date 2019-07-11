package practice08;

public class Teacher extends Person{
    private Klass klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    public Teacher(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Klass getKlass() {
        return klass;
    }

    public void setKlass(Klass klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String real_klass = klass != null  ? klass.getDisplayName() : "No Class";
        return super.introduce() + " " + String.format("I am a Teacher. I teach %s.", real_klass);
    }

    public String introduceWith(Student student){
        String result;
        result = klass != null && klass.getNumber() == student.getKlass().getNumber() ? String.format(" I teach %s.", student.getName()) : String.format(" I don't teach %s.", student.getName());
        return super.introduce() + " I am a Teacher." + result;
    }
}
