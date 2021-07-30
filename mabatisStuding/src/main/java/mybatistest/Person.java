package mybatistest;

public class Person {
    private String ps_name;
    private  Integer age;

    public Person() {
    }

    public Person(String ps_name, Integer age) {
        this.ps_name = ps_name;
        this.age = age;
    }

    public String getPs_name() {
        return ps_name;
    }

    public void setPs_name(String ps_name) {
        this.ps_name = ps_name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
