package Students;

import java.util.Comparator;

public class CompareByName implements Comparator<Student> {

    @Override
    public int compare(Student st1, Student st2) {
        if (st1.getName().equals(st2.getName()))
            return st1.compareTo(st2);
        return st1.getName().compareTo(st2.getName());
    }

    @Override
    public Comparator<Student> reversed() {
        return Comparator.super.reversed(); //To change body of generated methods, choose Tools | Templates.
    }


}
