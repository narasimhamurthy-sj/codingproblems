package ComparableAndComparator;

public class LogicClassOrComparableImplementedClass implements Comparable<LogicClassOrComparableImplementedClass> {

    String name;
    int empNo;

    public LogicClassOrComparableImplementedClass(String name, int empNo) {
        this.name = name;
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public int getEmpNo() {
        return empNo;
    }
//For integer field sorting
   /* @Override
    public int compareTo(LogicClassOrComparableImplementedClass obj) {
        return Integer.compare(this.empNo,obj.empNo);
    }*/

    //sort by string field
    public int compareTo(LogicClassOrComparableImplementedClass obj) {
        return name.compareTo(obj.name);
    }

    public String toString() {
        return this.name + " (" + this.empNo + ")";
    }
}
