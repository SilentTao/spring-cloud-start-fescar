package com.silent.controller;

/**
 * \* User: silent
 * \* Date: 01/03/19 Time: 15:33
 * \* Description:
 * \
 */
public class CAS {
    String str = new String("good");
    char[] ch = { 'a', 'b', 'c' };
    public static void main(String args[]) {
        CAS ex = new CAS();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }
}
