package com.Sorting;

//public class Student {
public class Student implements Comparable<Student> {


    private String name;
    private int number;
    private double grade;

    public Student(String name, int number, double grade) {
        if (validData(name, number, grade)) {
            this.name = name;
            this.number = number;
            this.grade = grade;
        } else {
            this.number = 0;
            this.name = "";
            this.grade = 1;
        }
    }

    public Student(){
        this("", 0, 1);
    }

    public Student(Student std){
        this(std.name, std.number, std.grade);
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public double getGrade() {
        return grade;
    }

    public void setName(String name) {
        if(name != null && name != "")
            this.name = name;
    }

    public void setNumber(int number) {
        if(number >= 1 && number < 40)
            this.number = number;
    }

    public void setGrade(double grade) {
        if(grade >= 2 && grade <= 6)
        this.grade = grade;
    }

    public static boolean validData (String name, int number, double grade){
        return number >= 0 &&
                number < 40 &&
                grade >= 2 &&
                grade <= 6 &&
                name != "";
    }

    @Override
    public String toString() {
        return "Student {" + "name='" + name + '\'' + ", number=" + number + ", grade=" + grade  +'}' + '\n';
//        return String.format(String.valueOf(number),name,grade);
//        return String.format("%3d%40s%.2f\n", number,name,grade);
    }


    @Override
    public int compareTo(Student std) {
        return this.number - std.number;
    }
}
