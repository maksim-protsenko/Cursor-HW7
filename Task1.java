import java.util.*;

public class Task1 {
    /*Написати програму, яка приймає на вхід об’єкт типу
String, а повертає наступні дані:
- всі букви, з яких складається стрінга і кількість їх
входжень (не враховуючи регістр, “A”.equals(“a”))
- загальну кількість букв
- кількість пробілів
- кількість цифр
- кількість розділових знаків*/
    public static void main(String[] args) {
        String string = "Согласно «Повести временных лет», до крещения князя Владимира имело место «испытание вер». В 986 году к князю Владимиру прибыли послы от волжских булгар, предложившие ему перейти в ислам. Когда они рассказали князю об обрядах, которые необходимо соблюдать, в том числе и о запрете на питьё вина, Владимир ответил знаменитой фразой: «Руси есть веселие пити», после чего отверг предложение булгар.";
        String lowerCaseString = string.toLowerCase();
        System.out.println(lowerCaseString);
        Integer quantityOfSpaces = 0;
        Integer quantityOfDigits = 0;
        Integer quantityOfLetters = 0;
        Integer quantityOfPunctuationMarks = 0;
        Map<Character, Integer> treeMapOfLetters = new TreeMap<>();
        Integer counter = 0;
        for (int i = 0; i < lowerCaseString.length(); i++) {
            if (Character.isSpaceChar(lowerCaseString.charAt(i))) {
                quantityOfSpaces++;
            }

            if (Character.isDigit(lowerCaseString.charAt(i))) {
                quantityOfDigits++;
            }

            if (Character.isAlphabetic(lowerCaseString.charAt(i))) {
                for (int j = 0; j < lowerCaseString.length(); j++) {
                    if (lowerCaseString.charAt(i) == lowerCaseString.charAt(j)) {
                        treeMapOfLetters.put(lowerCaseString.charAt(i), ++counter);
                    }
                }
                counter = 0;
                quantityOfLetters++;
            }

            if (!Character.isLetterOrDigit(lowerCaseString.charAt(i)) && !Character.isSpaceChar(lowerCaseString.charAt(i))
                    && (lowerCaseString.charAt(i) == ',') || (lowerCaseString.charAt(i) == '.') || (lowerCaseString.charAt(i) == '!')
                    || (lowerCaseString.charAt(i) == '?') || (lowerCaseString.charAt(i) == '-') || (lowerCaseString.charAt(i) == ';')
                    || (lowerCaseString.charAt(i) == ':') || (lowerCaseString.charAt(i) == '(') || (lowerCaseString.charAt(i) == ')')
                    || (lowerCaseString.charAt(i) == '"') || (lowerCaseString.charAt(i) == '\'') || (lowerCaseString.charAt(i) == '[')
                    || (lowerCaseString.charAt(i) == ']') || (lowerCaseString.charAt(i) == '/') || (lowerCaseString.charAt(i) == '«')
                    || (lowerCaseString.charAt(i) == '»')) {
                quantityOfPunctuationMarks++;
            }
        }
        System.out.println("Quantity of character occurrences in a string: " + treeMapOfLetters);
        System.out.println("Quantity of letters in a string: " + quantityOfLetters);
        System.out.println("Quantity of spaces in a string: " + quantityOfSpaces);
        System.out.println("Quantity of digits in a string: " + quantityOfDigits);
        System.out.println("Quantity of punctuation marks in a string: " + quantityOfPunctuationMarks);
    }
}
