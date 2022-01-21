package MainOne;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FunctionAnalyze {
    App app;

    public FunctionAnalyze(App app){
        this.app = app;
    }

    public void words(){
        JOptionPane.showMessageDialog(null, "Броят на думите е: " + getWordCount(app.textArea.getText()), "Analyze - Words", JOptionPane.PLAIN_MESSAGE);
    }

//    /\b\S+\b/g

    //!
    public static int getWordCount(String textArea) {
        int wordChar = 0;

        boolean prevCharWasSpace = true;
        for (int i = 0; i < textArea.length(); i++)
        {
            if (textArea.charAt(i) == ' ') {
                prevCharWasSpace = true;
            }
            else {
                if(prevCharWasSpace) wordChar++;
                prevCharWasSpace = false;
            }
        }

        return wordChar;

         // TO DO: проверка за последния знак
    }

    public void characters(){
        JOptionPane.showMessageDialog(null, "Броят на символите е: " + getCharactersCount(app.textArea.getText()), "Analyze - Characters", JOptionPane.PLAIN_MESSAGE);
    }

//        Pattern pattern = Pattern.compile("( *?[0-9a-zA-Z] *?)");
    public static int getCharactersCount(String textArea){
        int count = 0;
        count = textArea.length();
        return count;
    }

    public void charactersNoSpaces(){
//        System.out.println("bez space e " + getCharactersNoSpacesCount(app.textArea.getText()));
        JOptionPane.showMessageDialog(null, "Броят на символите без ,,белите'' знаци е: " + getCharactersNoSpacesCount(app.textArea.getText()), "Analyze - Characters No Spaces", JOptionPane.PLAIN_MESSAGE);

    }

    public static int getCharactersNoSpacesCount(String textArea){
        Pattern pattern = Pattern.compile("\\S");
        Matcher matcher = pattern.matcher(textArea);
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }

    public void paragraphs(){
//        System.out.println("Броят на параграфите е: " + getParagraphsCount(app.textArea.getText()));
        JOptionPane.showMessageDialog(null, "Броят на параграфите е: " + getParagraphsCount(app.textArea.getText()), "Analyze - Paragraphs", JOptionPane.PLAIN_MESSAGE);
    }

    public static int getParagraphsCount(String textArea){
        Pattern pattern = Pattern.compile("[^\r\n]+((\r|\n|\r\n)[^\r\n]+)*");
        Matcher matcher = pattern.matcher(textArea);
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }
}
