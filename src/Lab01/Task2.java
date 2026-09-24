package Lab01;

import java.util.HashSet;
import java.util.Set;

public class Task2 {

    static void main(){
        System.out.println("Enter the first set X:");
        String X_Input = IO.readln();
        System.out.println("Enter the second set Y:");
        String Y_Input = IO.readln();

        Set<Integer> X = toSetArray(X_Input);
        Set<Integer> Y = toSetArray(Y_Input);

        Set<Integer> X_Y = new HashSet<>(X);
        X_Y.removeAll(Y); // X - Y = A

        Set<Integer> Y_X = new HashSet<>(Y);
        Y_X.removeAll(X); // Y - X = B

        Set<Integer> XUY = new HashSet<>(X);
        XUY.addAll(Y); // X U Y = C

        Set<Integer> X3Y = new HashSet<>(X);
        X3Y.retainAll(Y); // X ∩ Y = D

        Set<Integer> leftside = new HashSet<>(X_Y);
        leftside.addAll(Y_X); // (A\B) ∪ (B\A)

        Set<Integer> rightside = new HashSet<>(XUY);
        rightside.removeAll(X3Y); // (A∪B) \ (A∩B).

        System.out.println("(X\\Y) ∪ (Y\\X) == (X∪Y) \\ (X∩Y)?:");
        IO.println(leftside.equals(rightside));

        printset(leftside);
        printset(rightside);
    }

    public static Set<Integer> toSetArray(String str){
        if (str.trim().isEmpty()){
            Exit();
        }

        String[] numbers = str.trim().split("\\s+");

        java.util.Set<Integer> array = new HashSet<>();
        for (String number : numbers){
            try {
                int n = Integer.parseInt(number);
                array.add(n);
            } catch (NumberFormatException error){
                Exit();
            }
        }
        return array;
    }

    public static void printset(java.util.Set<Integer> set){
        IO.println("Your sequence: " + set.toString() + "\n" + "size: " + set.size());
    }

    public static void Exit(){
        System.out.println("Error, incorrect set");
        System.exit(0);
    }
}
