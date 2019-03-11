import java.util.Scanner;

public class RailFence {


    private int n;
    private String text;
    private char[][] array;
    private String encryptextText;
    private String decryptedText;
    //private char[][] finalArray;

    public RailFence() {}

    public RailFence(int n, String text) {
        this.n = n;
        this.text = text;
        this.array = new char[n][text.length()];
    }

    public void makeEncryption() {

        StringBuilder strb;
        strb = new StringBuilder();

        setArray('*', array);

        boolean way = false;

        int row = 0;
        int col = 0;

        for (int i = 0; i < text.length(); i++) {

            if ( row == 0 || row == (n - 1) ) {
                way = !way;
            }

            array[row][col++] = text.charAt(i);

            if (way) {
                row++;
            } else {
                row--;
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < text.length(); j++) {
                if(array[i][j] != '*') {
                    strb.append(array[i][j]);
                }
            }
        }

        encryptextText = new String(strb);
        System.out.print(encryptextText);
    }

    public void makeDecryption() {

        StringBuilder sb = new StringBuilder();
        setArray(' ', array);

        boolean way = false;

        int row = 0;
        int col = 0;
        int counter = 0;

        for (int i = 0; i < text.length(); i++) {

            if ( row == 0 || row == (n - 1) ) {
                way = !way;
            }

            array[row][col++] = '*';

            if (way) {
                row++;
            } else {
                row--;
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < text.length() ; j++) {
                if(array[i][j] == '*') {
                    array[i][j] = text.charAt(counter);
                    counter++;
                }
            }
        }

        row = 0;
        col = 0;

        for (int i = 0; i < text.length(); i++) {

            if ( row == 0 || row == (n - 1) ) {
                way = !way;
            }

            sb.append(array[row][col++]);

            if (way) {
                row++;
            } else {
                row--;
            }

        }

        decryptedText = new String(sb);

    }

    private void setArray(char ch, char[][] array) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < text.length(); j++) {
                array[i][j] = ch;
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Podaj text do encrypcji: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println("Podaj n: ");
        sc = new Scanner(System.in);
        int n = sc.nextInt();



        RailFence rf = new RailFence(n, s);
        rf.makeEncryption();

        System.out.println("\n\n");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj text do decrypcji: ");

        String str = scanner.nextLine();
        System.out.println("Podaj n: ");
        scanner = new Scanner(System.in);
        int key = scanner.nextInt();


        RailFence decrypt = new RailFence(key, str);
        decrypt.makeDecryption();

        for (int i = 0; i < decrypt.n; i++) {
            for (int j = 0; j < decrypt.text.length(); j++) {
                System.out.print(decrypt.array[i][j]);
            }
            System.out.println();
        }

        System.out.print(decrypt.decryptedText);

    }
}