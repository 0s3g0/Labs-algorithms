package lab03;

import java.util.Random;

public class Task02 {

    static void main(){
        MemoryManager manager = new MemoryManager();
        Random rnd = new Random();

        IO.println("\nSecond task:");

        int N;
        while (true){
            IO.println("Write N which is an integer");
            String strN = IO.readln();
            try {
                N = Integer.parseInt(strN);
            } catch (NumberFormatException error){
                IO.println("Error, incorrect N");
                continue;
            }
            if (N > 0){
                break;
            }
            IO.println("Error, incorrect N");
        }

        int A;
        int B;
        while (true){
            IO.println("Write A and B, separated by Enter, " +
                    "such B is greater than A");
            String strA = IO.readln();
            String strB = IO.readln();
            try {
                A = Integer.parseInt(strA);
                B = Integer.parseInt(strB);
            } catch (NumberFormatException error){
                IO.println("Error, incorrect A or B");
                continue;
            }
            if (A < B && A > 0){
                break;
            }
            IO.println("Error, incorrect A or B");
        }

        Pointer[] pointersB = new Pointer[N];

        for (int i = 0; i < pointersB.length; i++){
            pointersB[i] = new Pointer();
            manager.newPointer(pointersB[i]);
            manager.WritePointer(pointersB[i], rnd.nextDouble(100));
        }

        int count = 0;
        for (Pointer p : pointersB){
            double curnum = (Double) manager.ReadPointer(p);

            if (curnum >= A && curnum <= B){
                count++;
            }
        }

        IO.println(count);
    }
}
