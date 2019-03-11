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

        //properArray();

        int counter = 0;
        int j = 0;

        for (int i = 0; i < str.length() + 3; i++) {
            try {
                sb.append(str.charAt(keys[j] + counter));
            } catch (IndexOutOfBoundsException e) {
            }
            ++j;
            if ( j == keys.length ) {
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
        int[] tempArray = new int[5];
        int j = 0;
        for (int i = tempArray.length - 1; i >= 0; i--) {
            tempArray[j] = keys[i];
            j++;
        }
        this.keys = tempArray;
        printArray();
    }

    private String decryptingString(String textToDecrypt) {

        int size = textToDecrypt.length() / keys.length + 1;

        this.keys = new int[]{2, 4, 0, 1, 3};

        StringBuilder stringBuilder;
        /*if (size == 0)
            stringBuilder = new StringBuilder(textToDecrypt);
        else {
            stringBuilder = new StringBuilder(size*size);
            stringBuilder.append(textToDecrypt);
        }*/
        stringBuilder = new StringBuilder(textToDecrypt);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < textToDecrypt.length(); i++) {
            sb.append("1");
        }

        //reverseArray();

        int counter = 0;
        int j = 0;

        for (int i = 0; i < stringBuilder.length(); i++) {
           try {
                sb.setCharAt(i, stringBuilder.charAt(keys[j] + counter));
                //System.out.println(stringBuilder.charAt(keys[j] + counter));
           } catch (IndexOutOfBoundsException e) {
           }
            ++j;
            if ( j == keys.length ) {
                counter += keys.length;
                j = 0;
            }
        }

        int lastRow = textToDecrypt.length() % keys.length;

        if(lastRow == 3) {
            sb.setCharAt(counter, textToDecrypt.charAt(counter+1));
            sb.setCharAt(counter+1, textToDecrypt.charAt(counter+2));
            sb.setCharAt(counter+2, textToDecrypt.charAt(counter));
        }
        else if (lastRow == 4) {
            sb.setCharAt(counter, textToDecrypt.charAt(counter+2));
            sb.setCharAt(counter+1, textToDecrypt.charAt(counter+3));
            sb.setCharAt(counter+2, textToDecrypt.charAt(counter));
            sb.setCharAt(counter+3, textToDecrypt.charAt(counter+1));
        }
        else if (lastRow == 2) {
            sb.setCharAt(counter, textToDecrypt.charAt(counter));
            sb.setCharAt(counter+1, textToDecrypt.charAt(counter+1));
        }
        else if (lastRow == 1) {
            sb.setCharAt(counter, textToDecrypt.charAt(counter));
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
        int[] array = new int[]{2, 3, 0, 4, 1};

        m2a.setKeys(array);
        //m2a.printArray();

        String toEncrypt = m2a.encryptingString("Dziala_i_odroznia_bloki");
        System.out.println();
        //System.out.println("nizej");
        //m2a.printArray();
        //System.out.println();
        //m2a.properArray();
        m2a.decryptingString(toEncrypt);
        //m2a.encryptingString("CRYPTOGRAPHYOSA");

        System.out.println();
        System.out.println("Dlugosc stringu: " + toEncrypt.length() + " klucz = 3-4-1-5-2");
    }
}
