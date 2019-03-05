import java.util.Arrays;

public class Macierz {

    private String str = "HEREISASECRETMESSAGEENCIPHEREDBYTRANSPOSITION";
    private String key = "CONVENIENCE";
    private char[][] array = new char[5][key.length()];

    public static String sortString(String inputString)
    {
        // convert input string to char array
        char tempArray[] = inputString.toCharArray();

        // sort tempArray
        Arrays.sort(tempArray);

        // return new sorted string
        return new String(tempArray);
    }


    public static void main(String[] args) {

        Macierz macierz = new Macierz();

        String sorted = macierz.sortString(macierz.key);

        System.out.println(sorted);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < macierz.key.length(); j++) {
                //macierz.array[i][j] = macierz.key.charAt();
            }

        }



    }

}
