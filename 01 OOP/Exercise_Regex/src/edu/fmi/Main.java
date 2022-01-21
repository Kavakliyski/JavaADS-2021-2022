package edu.fmi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        /*
        Име и фамилия – на кирилица, фамилията може да съдържа знак тире (-)
         */
        String inputName = "Ива";
        String inputSurname = "Иванова";

        String firstNameReg = "[А-Я][а-я]+";
        String lastNameReg = "[А-Я][а-я]+(-[А-Я][а-я]+)?";

        /*
        Потребителско име – може да съдържа малки латински букви и цифри
         */

        String username = "username";
        String userReg = "[a-z\\d]+";

        /*
        Парола – поне 8 символа от следните групи:
        малки латински букви
        главни латински букви
        цифри
        специални символи
         */

        String password = "DD2Dsa$32sa";

        // .*символ.* - Поне един символ
        String alphCReg = ".*[A-Z].*";
        String alphReg = ".*[a-z].*";
        String numsReg = ".*\\d.*";
        String symblosReg = ".*[!@#$%^&*(),.?\":{}|<>].*";

        if(password.matches(alphCReg) && password.matches(alphReg) && password.matches(numsReg) &&
        password.matches(symblosReg) && (password.length() >= 8)){
            System.out.println("Ok");
        }else{
            System.out.println("!");
        }

    }
}
