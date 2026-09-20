package theory;


public class StudentBuilder {
    private Student student;
    public StudentBuilder(){
        this.student = new Student();
    }

    public StudentBuilder setName(String name){
        student.name = name;
        return this;
    }

    public StudentBuilder setSurName(String name){
        student.surname = name;
        return this;
    }

    public Student build1(){
        return student;
    }
}
