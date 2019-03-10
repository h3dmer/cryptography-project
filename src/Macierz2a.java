import java.io.IOException;
import java.lang.reflect.Array;

public class Macierz2a {

    int[] keys;

    public void setKeys(int[] array) {
        this.keys = array;
    }

    private String encryptingString(String textToEncrypt) {

        StringBuilder str = new StringBuilder(textToEncrypt);
        StringBuilder sb = new StringBuilder();

        /*for (int i = 0; i < keys.length; i++) {
            keys[i] -= 1;
        }*/

        properArray();

        int counter = 0;
        int j = 0;

        for (int i = 0; i < str.length() + 1; i++) {
            try {
                sb.append(str.charAt(keys[j] + counter));
            } catch (IndexOutOfBoundsException e) {
            }
            ++j;
            if ( j == 4 ) {
                counter += keys.length;
                j = 0;
            }
        }
        System.out.println(sb);
        String encryptedText = new String(sb);

        return encryptedText;
    }

    private void properArray() {
        for (int i = 0; i < keys.length; i++) {
            this.keys[i] -= 1;
        }
    }

    private void reverseArray() {
        int[] tempArray = new int[4];
        int j = 0;
        for (int i = tempArray.length - 1; i >= 0; i--) {
            tempArray[j] = keys[i];
            j++;
        }
        this.keys = tempArray;
        printArray();
    }

    private String decryptingString(String textToDecrypt) {

        int size = textToDecrypt.length() / keys.length;

        StringBuilder stringBuilder;
        if (size == 0)
            stringBuilder = new StringBuilder(textToDecrypt);
        else {
            stringBuilder = new StringBuilder(size*size);
            stringBuilder.append(textToDecrypt);
        }

        StringBuilder sb = new StringBuilder();

        reverseArray();

        int counter = 0;
        int j = 0;

        for (int i = 0; i < stringBuilder.length() + 1; i++) {
           try {
                sb.append(stringBuilder.charAt(keys[j] + counter));
                System.out.println(stringBuilder.charAt(keys[j] + counter));
           } catch (IndexOutOfBoundsException e) {
           }
            ++j;
            if ( j == 4 ) {
                counter += keys.length;
                j = 0;
            }
        }
        System.out.println(sb);
        String encryptedText = new String(sb);

        return encryptedText;
    }

    private void printArray() {
        for (int i = 0; i < keys.length; i++) {
            System.out.print(keys[i] + " ");
        }
    }

    public static void main(String[] args) {

        Macierz2a m2a = new Macierz2a();
        int[] array = new int[]{3, 1, 4, 2};

        m2a.setKeys(array);
        m2a.printArray();
        String toEncrypt = m2a.encryptingString("CRYPTOGRAPHYOSA");
        System.out.println();
        //m2a.properArray();
        m2a.decryptingString(toEncrypt);
        //m2a.encryptingString("CRYPTOGRAPHYOSA");
    }
}
