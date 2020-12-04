package com.mdt.ocp.chapter6.MultiCatch;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Test {
    public static void main(String[] args) {
//        try {
//            Path path = Paths.get("dolphinsBorn.txt");
//            String text = new String(Files.readAllBytes(path));
//            LocalDate date = LocalDate.parse(text);
//            System.out.println(date);
//        } catch (DateTimeParseException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException(e);
//        }

        try {
            Path path = Paths.get("dolphinsBorn.txt");
            String text = new String(Files.readAllBytes(path));
            LocalDate date = LocalDate.parse(text);
            System.out.println(date);
        } catch (DateTimeParseException | IOException e) { // multi catch
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
