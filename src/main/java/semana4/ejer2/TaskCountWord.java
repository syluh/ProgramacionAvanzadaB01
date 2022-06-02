package semana4.ejer2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskCountWord extends Thread {
    private String document;
    private List<WordCount> counters = new ArrayList<>();

    public TaskCountWord(String document){
        this.document = document;
    }

    @Override
    public void run(){
        String[] words = document
                .replace(".","")
                .toLowerCase()
                .split("\\s");

        var uniqueWords =
                Arrays.stream(words)
                        .distinct()
                        .toList();

        for (var word: uniqueWords){
            contarPalabra(words, word);
        }
    }

    public void contarPalabra(String[] words, String wordToCount){
        int count = 0;

        for (var word: words){
            if (word.equalsIgnoreCase(wordToCount)){
                count ++;
            }
        }
        counters.add(new WordCount(wordToCount, count));
    }

    public List<WordCount> getCounters() {
        return new ArrayList<>(counters);
    }
}
