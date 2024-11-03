import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileReader {
    public String readFileIntoString(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}

class TextData {
    private String fileName;
    private String text;
    private int numberOfVowels;
    private int numberOfConsonants;
    private int numberOfLetters;
    private int numberOfSentences;
    private String longestWord;

    public TextData(String text, String fileName) {
        this.text = text;
        this.fileName = fileName;
        this.numberOfVowels = countVowels(text);
        this.numberOfConsonants = countConsonants(text);
        this.numberOfLetters = countLetters(text);
        this.numberOfSentences = countSentences(text);
        this.longestWord = findLongestWord(text);
    }

    private int countVowels(String text) {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    private int countConsonants(String text) {
        int count = 0;
        for (char c : text.toLowerCase().toCharArray()) {
            if ("bcdfghjklmnpqrstvwxyz".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    private int countLetters(String text) {
        int count = 0;
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }

    private int countSentences(String text) {
        String[] sentences = text.split("[.!?]");
        return sentences.length;
    }

    private String findLongestWord(String text) {
        String[] words = text.split("\\W+");
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length()) {
                longest = word;
            }
        }
        return longest;
    }

    public String getFileName() {
        return fileName;
    }

    public int getNumberOfVowels() {
        return numberOfVowels;
    }

    public int getNumberOfConsonants() {
        return numberOfConsonants;
    }

    public int getNumberOfLetters() {
        return numberOfLetters;
    }

    public int getNumberOfSentences() {
        return numberOfSentences;
    }

    public String getLongestWord() {
        return longestWord;
    }
}

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Please provide the path to the .txt file.");
            return;
        }

        String filePath = args[0];
        FileReader fileReader = new FileReader();

        try {
            String text = fileReader.readFileIntoString(filePath);
            TextData textData = new TextData(text, filePath);

            System.out.println("File Name: " + textData.getFileName());
            System.out.println("Number of Vowels: " + textData.getNumberOfVowels());
            System.out.println("Number of Consonants: " + textData.getNumberOfConsonants());
            System.out.println("Number of Letters: " + textData.getNumberOfLetters());
            System.out.println("Number of Sentences: " + textData.getNumberOfSentences());
            System.out.println("Longest Word: " + textData.getLongestWord());

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}
