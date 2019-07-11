package practice09;



public class Student extends Person {
    private Klass klass;

    public Student(int id, String name, int age, Klass klass) {
        super(id, name, age);
        this.klass = klass;
    }

    public Student(String name, int age, Klass klass) {
        super(name, age);
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
        boolean isLeader = klass != null && klass.getLeader() != null && klass.getLeader().getName().equals(this.getName());
        String isLeaderString = isLeader ? String.format("I am a Student. I am Leader of %s.",klass.getDisplayName()) : String.format("I am a Student. I am at Class %d.", klass.getNumber());
        return super.introduce() + " " + isLeaderString;
    }
}
