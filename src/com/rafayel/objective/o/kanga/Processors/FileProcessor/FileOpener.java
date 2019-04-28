package com.rafayel.objective.o.kanga.Processors.FileProcessor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileOpener {
    public static List<String> readFile(String filepath) throws IOException {
        Path path = Paths.get(filepath);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }
}
