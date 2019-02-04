package com.epam.javacore.homework03.task03;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexParser {
    public static void main(String[] args){
        RegexParser regexParser = new RegexParser();
        StringBuilder contentBuilder = new StringBuilder();

        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("src/com/epam/javacore/homework03/task03/Java.SE.03.Information_handling_task_attachment.html"),
                            StandardCharsets.UTF_8));

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                contentBuilder.append(str);
            }

            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String content = contentBuilder.toString();

        boolean result = regexParser.isSequential(content);
        System.out.println("Do picture links are present sequentially? " + result + "\n");
        System.out.println("Sentences with links to pictures:\n" + regexParser.getSentences(content));
     }

    public String getSentences(String stringtoCheck){
        String regex = "[^.?!>]*(?<=[.?\\s!>])(\\(((Рис|рис)\\.\\s\\d*)\\))[^.?!]*[.?!]";
        StringBuilder matchedSentences = new StringBuilder();
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringtoCheck);

        while (matcher.find()){
            if (matcher.group().length() != 0){
                String sentence = matcher.group().trim() + "\n";
                matchedSentences.append(sentence);
            }
        }

        return matchedSentences.toString();
    }

    public boolean isSequential(String stringToCheck){
        String regex = "\\((Рис|рис)\\.\\s(?<pictureNumber>\\d*)\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringToCheck);
        List<Integer> numbers = new ArrayList<>();

        while (matcher.find()){
            if (matcher.group().length() != 0){
                String numberString = matcher.group("pictureNumber").trim();
                int number = Integer.parseInt(numberString);
                System.out.println(matcher.group().trim());
                numbers.add(number);
            }
        }

        boolean sequential = true;

        for (int i = 0; i < numbers.size() - 1; i++){
            if (numbers.get(i) + 1 != numbers.get(i + 1)){
                sequential = false;
            }
        }

        return sequential;
    }
}
