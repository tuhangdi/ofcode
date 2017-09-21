package youzan0921;

import java.util.Scanner;


public class Main1 {

    static public void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] ch = s.toCharArray();

        reverse(ch, 0, ch.length - 1);
        int i = -1;
        for (int j = 0 ; j <= ch.length; ++j) {
            if (j == ch.length || (!Character.isLetter(ch[j]) && ch[j] != '\'')) {
                if (i != -1) reverse(ch, i, j - 1);
                i = -1;
            } else if (i == -1) i = j;
        }

        System.out.println(new String(ch));
    }
}