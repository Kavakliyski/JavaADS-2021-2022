
package Students;


public class Student implements Comparable<Student> {

    private int number;
    private String name;
    private double grade;

    public static boolean isValidData(int number, String name, double grade) {
        return number > 0 && number <= 40
                && name != null && !name.isEmpty()
                && grade >= 2 && grade <= 6;
    }

    public Student(int number, String name, double grade) {
        if (isValidData(number, name, grade)) {
            this.number = number;
            this.name = name;
            this.grade = grade;
        } else {
            this.number = 0;
            this.name = "";
            this.grade = 1;
        }
    }

    public Student() {
        this(0, "", 1);
    }

    public Student(Student st) {
        this(st.number, st.name, st.grade);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        if (number > 0 && number <= 40) {
            this.number = number;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }
    }

    public double getGrade() {
        return grade;

    }

    public void setGrade(double grade) {
        if (grade >= 2 && grade <= 6) {
            this.grade = grade;
        }
    }

    @Override
    public String toString() {
        return String.format("%3d %-20s%5.2f\n", number,name,grade);
    }

    @Override
    public int compareTo(Student st) {
        return this.number - st.number;
    }
}
