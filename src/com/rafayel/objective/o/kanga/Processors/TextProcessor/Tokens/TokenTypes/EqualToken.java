package com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.AbstractClasses.TokenType;

public class EqualToken extends TokenType {
    @Override
    public String getRegex() {
        return "\\=";
    }

    @Override
    public String getStringName() {
        return "Equal Token";
    }
}
