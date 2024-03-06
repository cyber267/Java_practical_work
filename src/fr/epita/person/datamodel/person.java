package fr.epita.person.datamodel;

public class person {
    private String name;
    private int age;
    private String sex;
    private int height;
    private int weight;

    public person() {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString(){
//        return "Person [name=" + name + ", weight=" + weight + "]";
        return "Person [name=" + name + ", sex=" + sex + ",age=" + age + ", height=" + height+ ", weight=" + weight + "]";

    }}
