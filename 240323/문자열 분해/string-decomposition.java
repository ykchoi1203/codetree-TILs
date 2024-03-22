import java.util.*;
public class Main {
    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        if(s.length() % 5 != 0) {
            System.out.println(-1);
            return;
        }

        ArrayList<Deque<Character>> list = new ArrayList<>();

        char[] arr = s.toCharArray();

        for(char c : arr) {
            if(list.isEmpty() && c == 'a') {
                list.add(new LinkedList<>());
                list.get(0).offer(c);
            } else if(list.isEmpty()) {
                System.out.println(-1);
                return;
            } else if(c == 'a') {
                boolean isTrue = false;
                for (Deque<Character> characters : list) {
                    if (characters.isEmpty()) {
                        characters.add(c);
                        isTrue = true;
                        break;
                    }
                }
                if(!isTrue) {
                    list.add(new LinkedList<>());
                    list.get(list.size()-1).add(c);
                }
            } else {
                boolean isTrue = false;
                for (Deque<Character> characters : list) {
                    if(!characters.isEmpty() && characters.peekLast() == c - 1) {
                        characters.offer(c);
                        if(c == 'e') {
                            while (!characters.isEmpty()) {
                                characters.pop();
                            }
                        }
                        isTrue = true;
                        break;
                    }
                }
                if(!isTrue) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(list.size());
    }
}