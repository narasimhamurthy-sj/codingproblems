package ComparableAndComparator;

public class ClassObjectThatNeedsSorting {
    String name;
    int empNumber;

    ClassObjectThatNeedsSorting(String name, int empNumber){
        this.name=name;
        this.empNumber=empNumber;
    }


    //Getters are needed for sorting multiple fields

    public  String getName(){
        return name;
    }
    public  int getEmpNumber(){
        return empNumber;
    }

public String toString(){
        return  name+" ("+empNumber+")";
}

}
