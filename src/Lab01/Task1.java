package Lab01;

public class Task1 {

    static void main() {
        System.out.println("Write a non‑empty sequence of characters:");
        String line = IO.readln();

        if (line.trim().isBlank()){
            System.out.println("Error, sequence empty");
            System.exit(0);
        }

        java.util.Set<Character> unique = new java.util.LinkedHashSet<>();

        for (int i = 0; i < line.length(); i++){
            char ch = line.charAt(i);

            boolean isOp = (ch == '+' || ch == '-' || ch == '*' || ch == '/');
            boolean isLetter = (ch >= 'E' && ch <= 'N');
            if (isOp || isLetter) {
                unique.add(ch);
            }
        }

        printset(unique);
    }

    public static void printset(java.util.Set<Character> set){
        IO.print("Your filtered sequence: " + set.toString() + "\n" + "size: " + set.size());
    }
}

