package com.rafayel.objective.o.kanga.Processors.TextProcessor;

import com.rafayel.objective.o.kanga.Processors.DataProcessor.Environment;
import com.rafayel.objective.o.kanga.Processors.ErrorProcessor.Error;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.ParseTree.Expressions.Expression;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.ParseTree.ParseTree;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.Token;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.EqualToken;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.NumberToken;
import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenTypes.TerminatorToken;

import java.util.List;

import static com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenRecogniser.hasPriority;
import static com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.TokenRecogniser.isOperator;

public class Parser {
    public static Environment globalEnv;

    public Parser(List<Token> tokens) {

        globalEnv = new Environment();

        boolean mergeState = false;
        boolean priorityOperatorSequence = false;

        Token x = null;

        Token operator = null;

        Expression tempx = null;
        Expression tempy = null;
        Expression tempz = null;
//        Expression current = null;

        for (int i = 0; i < tokens.size(); i++) {
            Token t = tokens.get(i);

            if (t.get_type() instanceof TerminatorToken){
                tempz.changeRight(tempx);
                tempx = new Expression(tempz);
            }

            //Check whether the token is an operator
            if (isOperator(t) && operator == null) {
                operator = t;

                if (operator.get_type() instanceof EqualToken) {
                    tempz = new Expression(x, operator,new Expression(
                            new Token(new NumberToken(), "0"),
                            new Token(new NumberToken(), "0"),
                            new Token(new NumberToken(), "0")
                    ));
                    x = null;
                    operator = null;
                }

                if (!hasPriority(t) && priorityOperatorSequence ) {
                    priorityOperatorSequence = false;
                    mergeState = true;
                }

                if (hasPriority(t) && tempx != null) {
                    if (hasPriority(tokens.get(i - 2)))
                        continue;

                    if (!priorityOperatorSequence) {
                        tempy = new Expression(tempx);

                        tempx = null;
                        x = null;
                        operator = null;
                        i -= 2;
                        priorityOperatorSequence = true;
                    }
//                    mergeState = !mergeState;
//                }
                }
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

                if (mergeState) {
                    tempy.changeRight(tempx);
                    tempx = new Expression(tempy);
                    tempy = null;
                    operator = null;
                    mergeState = false;
                }
            }

            //Define the parse tree
        ParseTree tree = new ParseTree(tempx);

            //Evaluate
            tree.evaluate();

        }

    }


