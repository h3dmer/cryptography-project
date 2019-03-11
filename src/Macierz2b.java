import java.util.Scanner;

public class Macierz2b {

    private String key;
    private int[] array;

    public Macierz2b(String key) {
        String temp = key;
        this.key = temp.toUpperCase();
    }

    public void createNumbersArray() {
        array = new int[key.length()];

        char counter = 'A';
        int temp = 0;


        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < key.length(); j++) {
                if ( key.charAt(j) == counter ) {
                    //System.out.println(key.charAt(j));
                    array[temp] = j;
                    temp++;

                }
            }
            //System.out.println();
            counter++;
        }
    }

    public void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public String encryptingString(String textToEncrypt) {

        System.out.println();

        int rows = textToEncrypt.length() / array.length + 1;

        System.out.println();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < rows; j++) {
                try {
                    sb.append(textToEncrypt.charAt(array[i] + j * array.length));
                } catch (IndexOutOfBoundsException e) {
                }
            }
            //System.out.println();
        }
        String result = new String(sb);
        System.out.println(sb);
        System.out.println();

        return result;
    }


    public String decryptionString(String textToDecrypt) {

        int rows = textToDecrypt.length() / array.length + 1;
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for (int i = 0; i < textToDecrypt.length(); i++) {
            sb.append('1');
        }

        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < rows; j++) {
                try {
                    sb.setCharAt(array[i] + j * array.length, textToDecrypt.charAt(k));
                    k++;
                } catch (IndexOutOfBoundsException e) { }
            }
        }

        String result = new String(sb);
        System.out.println(sb);
        return result;
    }



    /*public String decryptionString(String textToDecrypt) {

        int rows = textToDecrypt.length() / array.length + 1;
        StringBuilder sb = new StringBuilder();
        int k = 0;

        for (int i = 0; i < textToDecrypt.length(); i++) {
            sb.append('1');
        }

        int checkLastRow;

        if(textToDecrypt.length() % array.length == 0) {
            checkLastRow = textToDecrypt.length();
        } else {
            checkLastRow = (textToDecrypt.length() % array.length);
        }
        System.out.println();
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < rows; j++) {
                try {
                    //if ( j != rows - 1 ) {
                        sb.setCharAt(array[i] + j * array.length, textToDecrypt.charAt(k));
                    System.out.print( " " + array[i] + j * array.length);
                        k++;
                    //} else if (array[i] < checkLastRow) {
                       // sb.setCharAt(array[i] + j * array.length, textToDecrypt.charAt(k));
                       // k++;
                   // }

                } catch (IndexOutOfBoundsException e) { }
            }

        }

        String result = new String(sb);
        System.out.println(sb);
        return result;
    }*/


    public static void main(String[] args) {

        System.out.println("Podaj text: ");
        Scanner sc = new Scanner(System.in);
        String inputText = sc.nextLine();
        String textToEncrypt = inputText.toUpperCase();

        System.out.println("Podaj klucz: ");
        sc = new Scanner(System.in);
        String ki = sc.nextLine();
        Macierz2b m2b = new Macierz2b(ki);

        m2b.createNumbersArray();

       // m2b.printArray();



        //System.out.println(textToEncrypt);
        String encyptedText = m2b.encryptingString(textToEncrypt);
        System.out.println();

        System.out.println("Po dekrypcji: \n");
        m2b.decryptionString(encyptedText);


    }


}
