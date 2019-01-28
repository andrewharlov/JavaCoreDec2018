package com.epam.javacore.homework03.task02;

import java.util.*;

public class BundleHandler {
    private Locale locale;
    private ResourceBundle uiBundle;

    public BundleHandler(){
        this.locale = new Locale("en", "US");
        this.resetUIBundle();
    }

    public static void main(String[] args){
        BundleHandler bundleHandler = new BundleHandler();
        Scanner scanner;

        while (true){
            System.out.print(bundleHandler.uiBundle.getString("welcomeMessage"));
            scanner = new Scanner(System.in);
            String useRussianLanguage = scanner.nextLine();

            if (useRussianLanguage.toLowerCase().equals("y")){
                bundleHandler.setLocale("ru", "RU");
                bundleHandler.resetUIBundle();
                break;
            } else if (useRussianLanguage.toLowerCase().equals("n")){
                break; // nothing to do - English is default
            } else {
                System.out.println("Sorry, you can use only 'y' or 'n'.");
            }
        }

        System.out.println(bundleHandler.getQuestions());
        System.out.print(bundleHandler.uiBundle.getString("numberRequest"));
        scanner = new Scanner(System.in);
        int questionNumber = Integer.parseInt(scanner.nextLine());

        String answer = bundleHandler.getAnswer(questionNumber);

        if (answer.equals("")){
            System.out.println(bundleHandler.uiBundle.getString("errorMessage"));
        } else {
            System.out.println(bundleHandler.uiBundle.getString("answerMessage") + " " + answer);
        }
    }

    public void setLocale(String language, String country){
        this.locale = new Locale(language, country);
    }

    public void resetUIBundle(){
        this.uiBundle = ResourceBundle.getBundle("" +
                        "com.epam.javacore.homework03.task02.UIText",
                        this.locale);
    }

    public String getQuestions(){
        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                "com.epam.javacore.homework03.task02.Questions",
                this.locale);

        Enumeration<String> keys = resourceBundle.getKeys();

        StringBuilder questions = new StringBuilder();

        for (String key : resourceBundle.keySet()) {
            String nextQuestion = resourceBundle.getString(key) + "\n";
            questions.append(nextQuestion);
        }

        return questions.toString();
    }

    public String getAnswer(int questionNumber){
        String answerKey = "answer" + questionNumber;

        ResourceBundle resourceBundle = ResourceBundle.getBundle(
                "com.epam.javacore.homework03.task02.Answers",
                this.locale);

        String answer = "";
        try {
            answer = resourceBundle.getString(answerKey);
        } catch (MissingResourceException e){
            return answer;
        }

        return answer;
    }
}
