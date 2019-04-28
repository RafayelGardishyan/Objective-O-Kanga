package com.rafayel.objective.o.kanga;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Lexer;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Parser;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.Token;

import java.util.ArrayList;
import java.util.List;


public class Test {
    private List<String> testCode = new ArrayList<>();

    public void run() throws Exception {
        testCode.add("3 + 6 * 2 / 4 + 3");

        Lexer l = new Lexer(testCode);

        System.out.println("Lexer output:");

        for (Token t:
             l.getTokens()) {
            System.out.println("Token -> Type: " + t.get_type().getStringName() + " - Value: " + t.get_value());
        }

        System.out.println("Parser output");
        Parser p = new Parser(l.getTokens());
    }
}
