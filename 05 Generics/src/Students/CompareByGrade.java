package Students;

import java.util.Comparator;

public class CompareByGrade implements Comparator<Student> {
    @Override
    public int compare(Student st1, Student st2) {
        double diff = st1.getGrade() - st2.getGrade();
        if (Math.abs(diff) < Math.pow(10,-15))
            return st1.compareTo(st2);
        return (diff < 0) ? -1 : 1;

    }
}
