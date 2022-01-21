import javax.swing.*;
import java.awt.*;

public class Calculator extends JFrame {
    private JPanel pnlMain;
    private JPanel pnlCalc;
    private JPanel pnlCalcScreen;
    private JPanel pnlCalcButtons;
    private JButton a7Button;
    private JButton a1Button;
    private JButton a4Button;
    private JButton buttonEvaluate;
    private JButton buttonMinus;
    private JButton buttonPlus;
    private JButton a8Button;
    private JButton a5Button;
    private JButton a2Button;
    private JButton a6Button;
    private JButton a9Button;
    private JButton a3Button;
    private JButton buttonBracketsOpen;
    private JButton a0Button;
    private JButton buttonDivide;
    private JButton buttonEquals;
    private JLabel lblResult;
    private JButton buttonBracketsClose;
    private JButton buttonSqrt;
    private JButton buttonDot;
    private JButton buttonDelete;
    private final String newLbl = "";


    Calculator() {
        super("Cool Calculator");
        this.setContentPane(pnlMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setPreferredSize(new Dimension(400, 300));
        this.setSize(400, 300);
        this.pack();


        a0Button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        a1Button.setBorder(BorderFactory.createEmptyBorder(5,2,5,2));
        a2Button.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
        a3Button.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
        a4Button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        a5Button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        a6Button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        a7Button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        a8Button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        a9Button.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        a0Button.addActionListener(e -> a0Button());
        a1Button.addActionListener(e -> a1Button());
        a2Button.addActionListener(e -> a2Button());
        a3Button.addActionListener(e -> a3Button());
        a4Button.addActionListener(e -> a4Button());
        a5Button.addActionListener(e -> a5Button());
        a6Button.addActionListener(e -> a6Button());
        a7Button.addActionListener(e -> a7Button());
        a8Button.addActionListener(e -> a8Button());
        a9Button.addActionListener(e -> a9Button());

        buttonEvaluate.addActionListener(e -> ButtonEvaluate());
        buttonMinus.addActionListener(e -> ButtonMinus());
        buttonPlus.addActionListener(e -> ButtonPlus());
        buttonDivide.addActionListener(e -> ButtonDivide());
        buttonBracketsOpen.addActionListener(e -> ButtonBracketsOpen());
        buttonBracketsClose.addActionListener(e -> ButtonBracketsClose());
        buttonDot.addActionListener(e -> ButtonDot());
        buttonSqrt.addActionListener(e -> ButtonSqrt());
        buttonDelete.addActionListener(e -> ButtonDel());

        buttonEquals.addActionListener(e -> ButtonEquals());

    }


    private void a0Button() {
        String temp = lblResult.getText();
        temp += "0";
        lblResult.setText(temp);
    }
    private void a1Button() {
        String temp = lblResult.getText();
        temp += "1";
        lblResult.setText(temp);
    }
    private void a2Button() {
        String temp = lblResult.getText();
        temp += "2";
        lblResult.setText(temp);
    }
    private void a3Button() {
        String temp = lblResult.getText();
        temp += "3";
        lblResult.setText(temp);
    }
    private void a4Button() {
        String temp = lblResult.getText();
        temp += "4";
        lblResult.setText(temp);
    }
    private void a5Button() {
        String temp = lblResult.getText();
        temp += "5";
        lblResult.setText(temp);
    }
    private void a6Button() {
        String temp = lblResult.getText();
        temp += "6";
        lblResult.setText(temp);
    }
    private void a7Button() {
        String temp = lblResult.getText();
        temp += "7";
        lblResult.setText(temp);
    }
    private void a8Button() {
        String temp = lblResult.getText();
        temp += "8";
        lblResult.setText(temp);
    }
    private void a9Button() {
        String temp = lblResult.getText();
        temp += "9";
        lblResult.setText(temp);
    }

    private void ButtonBracketsOpen(){
        String temp = lblResult.getText();
        temp += "(";
        lblResult.setText(temp);
    }
    private void ButtonBracketsClose(){
        String temp = lblResult.getText();
        temp += ")";
        lblResult.setText(temp);
    }
    private void ButtonDot(){
        String temp = lblResult.getText();
        temp += ".";
        lblResult.setText(temp);
    }
    private void ButtonEvaluate(){
        String temp = lblResult.getText();
        temp += "*";
        lblResult.setText(temp);
    }
    private void ButtonMinus(){
        String temp = lblResult.getText();
        temp += "-";
        lblResult.setText(temp);
    }
    private void ButtonPlus(){
        String temp = lblResult.getText();
        temp += "+";
        lblResult.setText(temp);
    }
    private void ButtonDivide(){
        String temp = lblResult.getText();
        temp += "/";
        lblResult.setText(temp);
    }
    private void ButtonSqrt(){
        String temp = lblResult.getText();
        temp += "Math.sqrt(";
        lblResult.setText(temp);
    }
    private void ButtonDel(){
        try {
            String temp = lblResult.getText();
            StringBuilder sb = new StringBuilder(temp);
            sb.deleteCharAt(sb.length() - 1);
            lblResult.setText(String.valueOf(sb));
        } catch (Exception e){
            System.out.println("Cant delete nothing");;
        }
    }

    private void ButtonEquals(){
        System.out.println("Equals is pressed!");
        String temp = lblResult.getText();
        Calculation calculate = new Calculation(temp);
//        calculate.makeString();
        lblResult.setText(calculate.toString());
    }



//  (1+2)*3

    // 3 * 3
    // 9



    public static void main(String[] args) {
        Calculator calc = new Calculator();

    }
}
