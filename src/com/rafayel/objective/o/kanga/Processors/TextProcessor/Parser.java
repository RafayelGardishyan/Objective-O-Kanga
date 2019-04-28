package com.rafayel.objective.o.kanga.Processors.TextProcessor;

import com.rafayel.objective.o.kanga.Processors.ErrorProcessor.Error;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.ParseTree.Expressions.Expression;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.ParseTree.ParseTree;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.Token;

import java.util.List;

import static com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenRecogniser.hasPriority;
import static com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenRecogniser.isOperator;

public class Parser {
    private ParseTree tree;

    public Parser(List<Token> tokens){

//        boolean mergeState = false;

        Token x = null;

        Token operator = null;

        Expression tempx = null;
//        Expression tempy = null;
//        Expression current = null;

        for (int i = 0; i < tokens.size(); i++) {
            Token t = tokens.get(i);

            //Check whether the token is an operator
            if (isOperator(t) && operator == null) {
                operator = t;

// TODO: Fix operator ordering //Check whether the operator has priority
//                if (hasPriority(t) && !mergeState && tempx != null) {
//                    if (hasPriority(tokens.get(i-2)))
//                        continue;
//
//                    tempy = new Expression(tempx);
//                    tempx = null;
//                    x = null;
//                    operator = null;
//                    i -= 2;
//                    mergeState = !mergeState;
//                }
                continue;
            } else if (isOperator(t) && operator != null) {
                new Error("Error: Syntax error");
                System.exit(1);
            }


            //Sort the token in expressions
            if (tempx == null && operator != null && x != null) {
                tempx = new Expression(
                        new Token(x),
                        new Token(operator),
                        new Token(t)
                );
                x = null;
                operator = null;
            } else if (tempx != null && operator != null) {
                tempx = new Expression(
                        tempx,
                        new Token(operator),
                        new Token(t)
                );
                operator = null;
            } else if (x == null)
                x = t;

//TODO: Fix merging            //Check if has to be merged
//            if (tempy != null && tempx != null) {
//                tempy.changeRight(tempx);
//                tempx = new Expression(tempy);
//                tempy = null;
//                operator = null;
//                mergeState = !mergeState;
//            }
        }

        //Define the parse tree
        tree = new ParseTree(tempx);

        //Evaluate
        tree.evaluate();

    }
}
