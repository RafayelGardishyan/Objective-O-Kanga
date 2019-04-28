package com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.*;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.AbstractClasses.TokenType;

import java.util.regex.Pattern;

public class TokenRecogniser {
    public static TokenType GetType(String token) {
        TokenType type = null;

        if (Pattern.matches(new NumberToken().getRegex(), token)){
            type = new NumberToken();
        } else if (Pattern.matches(new PlusToken().getRegex(), token)){
            type = new PlusToken();
        } else if (Pattern.matches(new MinusToken().getRegex(), token)){
            type = new MinusToken();
        } else if (Pattern.matches(new MultiplyToken().getRegex(), token)){
            type = new MultiplyToken();
        } else if (Pattern.matches(new DivideToken().getRegex(), token)){
            type = new DivideToken();
        } else if (Pattern.matches(new EqualToken().getRegex(), token)){
            type = new EqualToken();
        } else if (Pattern.matches(new TerminatorToken().getRegex(), token)){
            type = new TerminatorToken();
        } else if (Pattern.matches(new IdentifierToken().getRegex(), token)){
            type = new IdentifierToken();
        }

        return type;
    }

    public static boolean isOperator(Token t) {
        if (t.get_type() instanceof PlusToken) {
            return true;
        } else if (t.get_type() instanceof MinusToken) {
            return true;
        } else if (t.get_type() instanceof MultiplyToken) {
            return true;
        } else if (t.get_type() instanceof DivideToken) {
            return true;
        }

        return false;
    }

    public static boolean hasPriority(Token t) {
        if (t.get_type() instanceof MultiplyToken) {
            return true;
        } else if (t.get_type() instanceof DivideToken) {
            return true;
        }

        return false;
    }
}
