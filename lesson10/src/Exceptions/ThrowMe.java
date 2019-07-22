package Exceptions;

import java.util.Hashtable;

class ThrowsDemo1 {

    static public void procedure() throws IllegalAccessException{
        System.out.println("inside procedure");
        throw new IllegalAccessException("demo");
    }

    public static void main(String args[]) throws IllegalAccessException {
        procedure();
    }
}