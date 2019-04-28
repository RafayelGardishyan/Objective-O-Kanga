package com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.AbstractClasses.TokenType;

public class IdentifierToken extends TokenType {
    @Override
    public String getRegex() {
        return "[a-zA-Z][a-zA-Z0-9_]*";
    }

    @Override
    public String getStringName() {
        return "Identifier Token";
    }
}
