package com.rafayel.objective.o.kanga.Processors.TextProcessor.ParseTree.Expressions;

import com.rafayel.objective.o.kanga.Processors.ErrorProcessor.Error;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Parser;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.Token;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.*;

public class Operate {
    public static Token operate(Token leftSide, Token operator, Token rightSide) {
//        System.out.println(leftSide.get_value());
//        System.out.println(operator.get_value());
//        System.out.println(rightSide.get_value());

        if (operator == null) {
            new Error("Error: Syntax error");
        }

        leftSide = checkName(leftSide);
        rightSide = checkName(rightSide);

        if (leftSide.get_type().getClass() != rightSide.get_type().getClass()) {
            new Error(
                    "Error: Cant operate with "
                            + leftSide.get_type().getStringName()
                            + " and "
                            + rightSide.get_type().getStringName());
            System.exit(1);
        }

        if (leftSide.get_type() instanceof NumberToken) {
            if (operator.get_type() instanceof PlusToken) {

                return doPlus(leftSide, rightSide);

            } else if (operator.get_type() instanceof MinusToken) {

                return doMinus(leftSide, rightSide);

            } else if (operator.get_type() instanceof MultiplyToken) {

                return doMultiply(leftSide, rightSide);

            } else if (operator.get_type() instanceof DivideToken) {

                return doDivide(leftSide, rightSide);

            }
        }

        return null;
    }

    private static Token checkName(Token t) {
        if (t.get_type() instanceof IdentifierToken)
            t = Parser.globalEnv.getName(t.get_value());

        return t;
    }

    public static Token declare(Token leftside, Token rightside) {
        Parser.globalEnv.setName(leftside.get_value(), rightside);
        return new Token(new NumberToken(), "null");
    }

    private static Token doPlus(Token leftSide, Token rightSide) {

        Integer left = Integer.parseInt(leftSide.get_value());
        Integer right = Integer.parseInt(rightSide.get_value());

        return new Token(new NumberToken(), Integer.toString(left + right));

    }

    private static Token doMinus(Token leftSide, Token rightSide) {

        Integer left = Integer.parseInt(leftSide.get_value());
        Integer right = Integer.parseInt(rightSide.get_value());

        return new Token(new NumberToken(), Integer.toString(left - right));

    }

    private static Token doMultiply(Token leftSide, Token rightSide) {

        Integer left = Integer.parseInt(leftSide.get_value());
        Integer right = Integer.parseInt(rightSide.get_value());

        return new Token(new NumberToken(), Integer.toString(left * right));

    }

    private static Token doDivide(Token leftSide, Token rightSide) {

        Integer left = Integer.parseInt(leftSide.get_value());
        Integer right = Integer.parseInt(rightSide.get_value());

        return new Token(new NumberToken(), Integer.toString(left / right));

    }
}
