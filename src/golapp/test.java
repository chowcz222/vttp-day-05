package src.golapp;

import java.io.Console;

public class test {

    public static void main(String[] args) {

        Console cons = System.console();
        String tempData = cons.readLine("1st");


        
        String tempData1 = cons.readLine("2nd");
        System.out.printf("%s   %s", tempData, tempData1);

    }
}
