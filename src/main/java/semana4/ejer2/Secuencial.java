package semana4.ejer2;

import java.util.Arrays;
import java.util.List;

public class Secuencial {
    public static void main(String[] args) {
        var text = "Esto es un ejemplo de un texto. El texto es sencillo. El texto es simple. El texto es corto.";
        String[] words = text
                .replace(".","")
                .toLowerCase()
                .split("\\s");

        var uniqueWords =
                Arrays.stream(words)
                        .distinct()
                        .toList();

        System.out.println(uniqueWords);

        for (var word: uniqueWords){
            contarPalabra(words, word);
        }
    }

    public static void contarPalabra(String[] words, String wordToCount){
        int count = 0;

        for (var word: words){
            if (word.equalsIgnoreCase(wordToCount)){
                count ++;
            }
        }
        System.out.printf("%s - %d%n", wordToCount, count);
    }
}
