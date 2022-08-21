import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaCodingChallengeClass {
    String textFileContent;
    List<String> allWords = new ArrayList<String>();
    HashSet<String> allWordsMap = new HashSet<>();
    HashMap<String, Integer> totalWordCounts = new HashMap<>();

    public void printTextFileContent() {
        this.setTextFileContent();

        // System.out.println(this.textFileContent);
        this.setAllWords();
        this.setWordCounts();
        // System.out.println(this.allWords.toString());
        // this.printWordCount();
    }

    public void setTextFileContent() {
        try {
            File readFile = new File("Coding Challenge.txt");
            Scanner myReader = new Scanner(readFile);
            while (myReader.hasNextLine()) {
                String nextLine = myReader.nextLine();
                this.textFileContent = this.textFileContent + nextLine;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void setAllWords() {
        Pattern pattern = Pattern.compile("([a-zA-Z]*)");
        Matcher matcher = pattern.matcher(this.textFileContent);
        while (matcher.find()) {
            String thisWord = matcher.group().trim().toLowerCase();
            this.allWords.add(thisWord);
        }
        this.allWords.removeIf(match -> match.isBlank());
    }

    public void printWordCount() {
        System.out.println("This File has: " + this.allWords.size() + " words");
    }

    public void setWordCounts() {
        int max = 0;
        String result = "";
        for (String thisWord : this.allWords) {
            // if (this.totalWordCounts.get(word) > max) {
            // max = this.totalWordCounts.get(word);
            // result = word;
            // }
            this.totalWordCounts.put(thisWord, this.totalWordCounts.getOrDefault(thisWord, 0) + 1);

        }
        System.out.println(this.totalWordCounts.toString());
    }

    public static void main(String[] args) {
        JavaCodingChallengeClass javaChallengeEngine = new JavaCodingChallengeClass();
        // System.out.println(getTextFileContent());
        javaChallengeEngine.printTextFileContent();
    }

}
