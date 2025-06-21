import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<ArrayList<String>> a2 = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ArrayList<String> a1 = new ArrayList<>();
            a1.add("a");
            if (i == 1) {
                a1.add("b");
            }
            a2.add(a1);
        }

        a2.forEach(e -> System.out.print(e.toString()));
    }
}