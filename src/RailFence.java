import java.util.Scanner;

public class RailFence {


    private int n;
    private String text;
    private char[][] array;
    private String encryptextText;
    private String decryptedText;



    public RailFence(int n, String text) {
        this.n = n;
        this.text = text;
        this.array = new char[n][text.length()];
    }

    public void makeEncryption() {

        StringBuilder strb;
        strb = new StringBuilder();

        setArray();

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

    private void setArray() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < text.length(); j++) {
                array[i][j] = '*';
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Gimme some text:");
        String sampleText = scanner.nextLine();

        System.out.println("Gimme some key:");
        int n = scanner.nextInt();

        //RailFence rf = new RailFence(3, "KRYPTOGRAFIA");

        RailFence rf = new RailFence(n, sampleText);
        System.out.println("Encrypted: ");
        rf.makeEncryption();
        System.out.println();
        //rf.makeDecryption(4, rf.text);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < sampleText.length(); j++) {
                System.out.print(rf.array[i][j]);
            }
            System.out.println();
        }

    }
}
