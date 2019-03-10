

public class Macierz2b {

    private String key;
    private int[] array;

    public Macierz2b(String key) {
        this.key = key;
    }

    public void createNumbersArray() {
        array = new int[key.length()];

        char counter = 'A';
        int temp = 0;
        int j=0;

        for (int i = 0; i < 26; i++) {
            for (j = 0; j < key.length(); ++j) {
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

        int checkLastRow;

        if(textToDecrypt.length() % array.length == 0) {
            checkLastRow = Integer.MAX_VALUE;
        } else {
            checkLastRow = (textToDecrypt.length() % array.length);
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < rows; j++) {
                try {
                    if ( j != rows - 1 ) {
                        sb.setCharAt(array[i] + j * array.length, textToDecrypt.charAt(k));
                        k++;
                    } else if (array[i] < checkLastRow) {
                        sb.setCharAt(array[i] + j * array.length, textToDecrypt.charAt(k));
                        k++;
                    }

                } catch (IndexOutOfBoundsException e) { }
            }

        }

        String result = new String(sb);
        System.out.println(sb);
        return result;
    }


    public static void main(String[] args) {
        Macierz2b m2b = new Macierz2b("CONVENIENCE");

        m2b.createNumbersArray();

        m2b.printArray();
        String encyptedText = m2b.encryptingString("HEREISASECRETMESSAGEENCIPHEREDBYTRANSPOSITION");
        System.out.println();

        m2b.decryptionString(encyptedText);


    }


}
