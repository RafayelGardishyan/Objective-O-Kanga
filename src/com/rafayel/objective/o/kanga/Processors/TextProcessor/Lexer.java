package com.rafayel.objective.o.kanga.Processors.TextProcessor;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.Token;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenRecogniser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lexer {
    private List<Token> tokens = new ArrayList<Token>();

    public Lexer(List<String> inputText) {
        List<String> tempStrings = new ArrayList<String>();
        for (String line:
             inputText) {
            tempStrings.addAll(Arrays.asList(line.split(" ")));
        }

        for (String token:
             tempStrings) {
            tokens.add(new Token(TokenRecogniser.GetType(token), token));
        }
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
