package de.tum.in.ase.eist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class ExamSystem {

    // TODO 4: Change HashFunction to Hashing
    private static Hashing hashGenerator;

    private ExamSystem() {
    }

    public static String hashFile(String document) {
        return hashGenerator.hashDocument(document);
    }

    public static void main(String[] args) {
        String file1 = readFile("exams/short_exam.txt");
        String file2 = readFile("exams/long_exam.txt");  //This file is too big for Preview Hashing

        // TODO 4: Change SimpleHash to PreviewHashing
        hashGenerator = new PreviewHashing();

        System.out.println(hashFile(file1));
        try {
            System.out.println(hashFile(file2));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        // TODO 4: Change CryptoSecureHashAlgorithm to EnterpriseHashing
        hashGenerator = new EnterpriseHashing();

        System.out.println(hashFile(file1));
        System.out.println(hashFile(file2));
    }

    public static String readFile(String filepath) {
        // TODO 5: Return the content of the passed file as a String.
        try {
            Path path = Path.of(filepath);
            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e + " The file is not found!");
        }
    }

}
