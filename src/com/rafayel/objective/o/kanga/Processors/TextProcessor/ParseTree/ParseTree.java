package com.rafayel.objective.o.kanga.Processors.TextProcessor.ParseTree;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.ParseTree.Expressions.Expression;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.Token;

public class ParseTree {
    private Expression expression;

    public ParseTree(Expression ex) {
        expression = ex;
    }

    public Integer evaluate() {
        Token result = expression.visit();
        if (!result.get_value().equals("null"))
            System.out.println(result.get_value());
        return 0;
    }

}
