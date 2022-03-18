import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        LinkedList<Integer> linkedList = new LinkedList<>();
        int bounds = scan.nextInt();
        int quantityToFind = scan.nextInt();
        int[] numToFind = new int[quantityToFind];

        for (int i = 0; i < numToFind.length; i++) {
            numToFind[i] = scan.nextInt();
        }

        for (int i = 1; i <= bounds; i++) {
            linkedList.add(i);
        }

        int answer = 0;
        for (int target : numToFind) {
            if (linkedList.indexOf(target) <= (linkedList.size() / 2)) {
                while (!(linkedList.peekFirst() == target)) {
                    linkedList.addLast(linkedList.pollFirst());
                    answer++;
                }
            } else {
                while (!(linkedList.peekFirst() == target)) {
                    linkedList.addFirst(linkedList.pollLast());
                    answer++;
                }
            }
            linkedList.pollFirst();
        }
        System.out.println(answer);
    }
}