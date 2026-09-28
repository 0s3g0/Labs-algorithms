package lab03;

import java.util.Random;

public class Task01 {

    static void main(){
        MemoryManager manager = new MemoryManager();
        Random rnd = new Random();

        IO.println("Memory link demonstrations:");
        Pointer testP = new Pointer();
        manager.newPointer(testP);
        manager.WritePointer(testP, 10);
        IO.println(manager.ReadPointer(testP));
        manager.newPointer(testP);
        manager.WritePointer(testP, 5);
        IO.println(manager.ReadPointer(testP));


        IO.println("\nFirst task:");
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
            if (N > 0) break;
            IO.println("Error, incorrect N");
        }

        Pointer[] pointersA = new Pointer[N];

        for (int i = 0; i < pointersA.length; i++){
            pointersA[i] = new Pointer();
            manager.newPointer(pointersA[i]);
            manager.WritePointer(pointersA[i], rnd.nextInt(100));
        }

        int count = 0;
        int sum = 0;
        for (Pointer p : pointersA){
            int curnum = (Integer) manager.ReadPointer(p);

            if (2 < curnum && curnum < 20 && curnum % 8 == 0){
                count++;
                sum += curnum;
            }
        }

        IO.println(count + " " + sum);
    }
}
