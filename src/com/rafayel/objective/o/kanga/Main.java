package com.rafayel.objective.o.kanga;

import com.rafayel.objective.o.kanga.Processors.TextProcessor.Lexer;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        Test t = new Test();
        if (args.length == 0)
            args = new String[]{"false"};
        t.run(Boolean.parseBoolean(args[0]));

    }
}
