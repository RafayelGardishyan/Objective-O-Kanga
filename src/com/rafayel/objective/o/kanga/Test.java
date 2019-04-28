package com.rafayel.objective.o.kanga;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Lexer;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Parser;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Test {
    private List<String> testCode = new ArrayList<>();

    public void run(boolean debugInfo) throws Exception {
        testCode.add("x = 3 + 6 * 2 / 4 + 3 ;");

        Lexer l = new Lexer(testCode);

        if (debugInfo) {
            System.out.println("Lexer output:");

            for (Token t :
                    l.getTokens()) {
                System.out.println("Token -> Type: " + t.get_type().getStringName() + " - Value: " + t.get_value());
            }


            System.out.println("Parser output");
        }
        Parser p = new Parser(l.getTokens());

        if (debugInfo) {
            System.out.println("Environment");
            Set<String> keySet = Parser.globalEnv.getNamesTable().keySet();
            for (String name:
                 keySet) {

                System.out.println(
                        name
                                + " : "
                                + Parser.globalEnv.getNamesTable().get(name).get_type().getStringName()
                                + " - "
                                + Parser.globalEnv.getNamesTable().get(name).get_value()
                );

            }
        }

    }
}
