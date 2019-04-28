package com.rafayel.objective.o.kanga.Processors.DataProcessor;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Tokens.Token;

import java.util.Hashtable;

public class Environment {

    private Hashtable<String, Token> names;

    private Environment parent;
    private Hashtable<String, Environment> children;

    public Environment() {
        names = new Hashtable<>();
        parent = null;
        children = new Hashtable<>();
    }

    private Environment(Environment n_parent) {
        parent = n_parent;
        names = new Hashtable<>();
        children = new Hashtable<>();
    }

    public Token getName(String name) {
        return names.get(name);
    }

    public void setName(String name, Token value) {
        names.put(name, value);
    }

    public Environment getChild(String name) {
        return children.get(name);
    }

    public Hashtable<String, Token> getNamesTable() {
        return names;
    }

    public Environment createChild(String name) {
        children.put(name, new Environment(this));
        return children.get(name);
    }



}
