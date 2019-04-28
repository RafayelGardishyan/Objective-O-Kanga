package com.rafayel.objective.o.kanga.Processors.TextProcessor.ParseTree.Expressions;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.Token;

public class Expression {
    private Token m_operator;

    private Token m_leftsideto = null;
    private Token m_rightSideto  = null;

    private Expression m_leftsideex  = null;
    private Expression m_rightSideex  = null;


    public Expression(Token leftside, Token operator, Token rightSide) {
        m_leftsideto = leftside;
        m_rightSideto = rightSide;
        m_operator = operator;
    }

    public Expression(Expression leftside, Token operator, Expression rightSide) {
        m_leftsideex = leftside;
        m_rightSideex = rightSide;
        m_operator = operator;
    }

    public Expression(Expression leftside, Token operator, Token rightSide) {
        m_leftsideex = leftside;
        m_rightSideto = rightSide;
        m_operator = operator;
    }

    public Expression(Expression expression){
        m_operator = expression.m_operator;
        m_rightSideto = expression.m_rightSideto;
        m_leftsideex = expression.m_leftsideex;
        m_rightSideex = expression.m_rightSideex;
        m_leftsideto = expression.m_leftsideto;
    }

    public void changeLeft(Expression left) {
        m_leftsideex = left;
    }

    public void changeLeft(Token left) {
        m_leftsideto = left;
    }

    public void changeRight(Expression right) {
        m_rightSideex = right;
    }

    public void changeRight(Token right) {
        m_rightSideto = right;
    }

    public Token getRight(){
        return m_rightSideto;
    }


    public Token visit() {
        if (m_leftsideto != null){
            return Operate.operate(m_leftsideto, m_operator, m_rightSideto);
        }

        if (m_leftsideex != null && m_rightSideto != null){
            return Operate.operate(m_leftsideex.visit(), m_operator, m_rightSideto);
        }

        Token leftEval = m_leftsideex.visit();
        Token rightEval = m_rightSideex.visit();

        return Operate.operate(leftEval, m_operator, rightEval);
    }

}
