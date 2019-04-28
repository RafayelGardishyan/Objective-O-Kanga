package com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.AbstractClasses.TokenType;

public class NumberToken extends TokenType {
    @Override
    public String getRegex() {
        return "[0-9]+";
    }

    @Override
    public String getStringName() {
        return "Number Token";
    }
}
