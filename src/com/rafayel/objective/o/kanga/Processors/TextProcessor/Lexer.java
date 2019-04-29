package com.rafayel.objective.o.kanga.Processors.TextProcessor;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.Token;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenRecogniser;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.EqualToken;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.NumberToken;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.PlusToken;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.TerminatorToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lexer {
//    private List<Token> tokens = new ArrayList<Token>();

    private List<List<Token>> tokens = new ArrayList<>();

    private int index = 0;


    public Lexer(List<String> inputText) {
        List<List<String>> tempStrings = new ArrayList<>();
        for (String line :
                inputText) {
            tempStrings.add(Arrays.asList(line.split(";")));
//            tempStrings.addAll(Arrays.asList(line.split(" ")));
        }

        for (List<String> line : tempStrings) {
            List<Token> temp = new ArrayList<>();
            List<String> tokenstemp = new ArrayList<>();
            for (String token : line){

                tokenstemp.addAll(Arrays.asList(token.split(" ")));
            }
            for (String token :
                    tokenstemp) {
                temp.add(new Token(TokenRecogniser.GetType(token), token));
            }

            temp.addAll(Arrays.asList(
//                    new Token(new NumberToken(), "0"),
                    new Token(new PlusToken(), "+"),
                    new Token(new NumberToken(), "0"),
                    new Token(new TerminatorToken(), ";")
            ));

            tokens.add(temp);
    }

    }

    public void stepBack(){
        --index;
    }

    public boolean isNext() {
        return index < tokens.size();
    }

    public List<Token> getTokens() {
        if (index < tokens.size())
            return tokens.get(index++);
        else
            return null;
    }

    public List<Token> getAllTokens() {
        List<Token> list = new ArrayList<>();

        for (List<Token> nlist : tokens) {
            list.addAll(nlist);
        }

        return list;
    }

}
