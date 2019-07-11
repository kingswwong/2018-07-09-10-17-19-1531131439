package practice06;

public class Teacher extends Person{
    private int klass;

    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int klass) {
        super(name, age);
        this.klass = klass;
    }

    public int getKlass() {
        return klass;
    }

    public void setKlass(int klass) {
        this.klass = klass;
    }

    @Override
    public String introduce() {
        String real_klass = klass == 0 ? "No Class" : String.format("Class %d",klass);
        return super.introduce() + " " + String.format("I am a Teacher. I teach %s.", real_klass);
    }
}
