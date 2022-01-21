package MainOne;


import javax.swing.*;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;


public class FunctionEdit {
    App app;

    public FunctionEdit(App app) {
        this.app = app;
    }

    public void find(){

        String input = JOptionPane.showInputDialog("Enter a word");
//        String input = "asd";
        System.out.println(app.textArea);
        highlight(app.textArea, input);
    }


    public <myHighlightPainter> void highlight(JTextComponent textComp, String pattern){
        Highlighter.HighlightPainter myHighlightPainter = new DefaultHighlighter.DefaultHighlightPainter(Color.RED);
        removeHighlight(textComp);

        try {
            Highlighter hilie = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0){
                hilie.addHighlight(pos, pos + pattern.length(), myHighlightPainter);
                pos += pattern.length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void removeHighlight(JTextComponent textComp){
        Highlighter hilite = textComp.getHighlighter();
        Highlighter.Highlight[] hilites = hilite.getHighlights();

        for (Highlighter.Highlight highlight : hilites) {
            if (highlight.getPainter() != null) {
                hilite.removeHighlight(highlight);
            }
        }
    }


    public void replace() {

    }


    public void replaceAll() {

    }

}