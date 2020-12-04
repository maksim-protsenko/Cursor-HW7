import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Task2 {
    /*
    Написати програму, яка приймає на вхід текстовий файл, і повертає наступну
    інформацію
    - Найкоротше слово і кількість його повторень в тексті. Якщо в тексті є декілька,
    однаково коротких слів, то повертати те, яке раніше по алфавіту. Наприклад,
    між словами “Олег” та “Анна” потрібно вибрати “Анна”
    - Найдовше слово і кількість його повторень в тексті. Якщо в тексті є декілька,
    однаково довгих слів, то повертати те, яке пізніше по алфавіту. Наприклад, між
    словами “Олег” та “Анна” потрібно вибрати “Олег”.
    - Регістр не враховувати
     */
    public static void main(String[] args) {

        Map<String, Integer> allWordsFrequency = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        Map<Integer, String> allWordsQuantityOfLetters = new TreeMap<>();
        List<String> tempAllWords = new ArrayList<>();
        List<String> shortestWordList = new ArrayList<>();
        final String path = "src/TolstoiVoinaIMir1.txt";

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            scanner.useDelimiter("  ");
            while (scanner.hasNext()) {
                String tempString = scanner.next();
                tempString = tempString.replaceAll("[\\[\\],.!&?\"<>'{}()*+@#$|/=:;—«»]", " ").replaceAll("[\\p{Digit}]", " ");
                StringBuilder word = new StringBuilder();
                int counterOfWords = 1;
                int counterOfLetters = 0;
                for (int i = 0; i < tempString.length(); i++) {
                    Character ch = tempString.charAt(i);
                    if ((Character.isAlphabetic(ch)) || (ch == '-')) {
                        word.append(ch);
                        counterOfLetters++;
                    } else if (Character.isSpaceChar(ch) || word.length() >= 1) {
                        tempAllWords.add(word.toString());
                        allWordsQuantityOfLetters.put(counterOfLetters, word.toString());
                        if (allWordsFrequency.containsKey(word.toString())) {
                            allWordsFrequency.put(word.toString(), ++counterOfWords);
                        } else {
                            allWordsFrequency.put(word.toString(), 1);
                        }
                        word.delete(0, word.length());
                        counterOfLetters = 0;
                        counterOfWords = 0;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (String word : tempAllWords) {
            if ((word.length() == 1) && !word.equals("-")) {
                shortestWordList.add(word.toLowerCase());
            }
        }
        Collections.sort(shortestWordList);
        int countOfWords = 0;
        for (int i = 0; i < shortestWordList.size(); i++) {
            if (shortestWordList.get(i).equals(shortestWordList.get(0))) {
                countOfWords++;
            }
        }
        System.out.println("The shortest word in War And Piece Tom 1 is: \"" + shortestWordList.get(0) + "\" it occurs " + countOfWords + " times");

        String longestWord = ((TreeMap<Integer, String>) allWordsQuantityOfLetters).lastEntry().getValue();
        Integer longestWordQuantity = ((TreeMap<String, Integer>) allWordsFrequency).lastEntry().getValue();
        System.out.println("The longest word in War And Piece Tom 1 is: " + longestWord + "\" it occurs " + longestWordQuantity + " times");
    }
}
