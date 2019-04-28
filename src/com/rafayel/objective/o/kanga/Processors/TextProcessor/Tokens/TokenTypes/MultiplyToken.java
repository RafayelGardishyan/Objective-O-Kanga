package com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.AbstractClasses.TokenType;

public class MultiplyToken extends TokenType {
    @Override
    public String getRegex() {
        return "\\*";
    }

    @Override
    public String getStringName() {
        return "Multiply Token";
    }
}
