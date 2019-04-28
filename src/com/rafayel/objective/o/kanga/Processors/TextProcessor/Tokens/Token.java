package com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.AbstractClasses.TokenType;

public class Token {
    public TokenType get_type() {
        return m_type;
    }

    public String get_value() {
        return m_value;
    }

    private TokenType m_type;
    private String m_value;
//    private Integer linenum;

    public Token(TokenType type, String value) {
        m_type = type;
        m_value = value;
    }

    public Token(Token clone) {
        m_type = clone.m_type;
        m_value = clone.m_value;
    }
}
