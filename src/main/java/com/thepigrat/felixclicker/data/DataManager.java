package com.thepigrat.felixclicker.data;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class DataManager {
    public static final String PATH = "savedData.txt";
    // Attribute
    public String data;

    private DataManager(String data) {
        this.data = data;
    }

    public static DataManager of(String data) {
        return new DataManager(data);
    }

    public DataManager encode() {
        StringBuilder builder = new StringBuilder();
        for (byte singleByte : data.getBytes()) {
            builder.append(byteToBinary(singleByte));
            builder.append(' ');
        }
        this.data = builder.toString();
        return this;
    }

    public DataManager save() {
        File file = new File(PATH);

        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (Exception e) {
            System.err.println("Failed to create file");
        }

        try (FileWriter writer = new FileWriter(PATH)) {
            writer.write(data);

            System.out.println("Content has been written to the file.");
        } catch (IOException e) {
            System.err.println("Error writing to the file: " + e.getMessage());
        }
        return this;
    }

    public static List<String> load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            var lines = reader.lines().toList();
            var builder = new StringBuilder();
            for (String line : lines) {
                builder.append(parseBytesToString(line));
            }
            return Arrays.stream(builder.toString().split(" ")).toList();
        } catch (Throwable ignored) {
        }
        return null;
    }

    private static String stringFromBytes(List<Byte> bytes) {
        byte[] byteArr = new byte[bytes.size()];
        for (int i = 0; i < bytes.size(); i++) {
            byte _byte = bytes.get(i);
            byteArr[i] = _byte;
        }
        System.out.println(Arrays.toString(byteArr));
        return new String(byteArr);
    }

    private static String parseBytesToString(String byteString) {
        // Split the byte string by spaces
        String[] byteValues = byteString.split(" ");

        // Create a byte array to hold the parsed byte values
        char[] strings = new char[byteValues.length];

        // Parse each byte value and store it in the byte array
        for (int i = 0; i < byteValues.length; i++) {
            strings[i] = binaryToString(byteValues[i]).charAt(0);
        }

        // Create a string from the byte array

        return new String(strings);
    }

    private static String byteToBinary(byte byteValue) {
        // Use bitwise AND with 0xFF to ensure the byte is treated as unsigned
        StringBuilder binary = new StringBuilder();
        for (int bit = 7; bit >= 0; bit--) {
            binary.append((byteValue >> bit) & 1);
        }
        return binary.toString();
    }

    private static String binaryToString(String binaryString) {
        // Convert binary string to byte value
        byte byteValue = (byte) Integer.parseInt(binaryString, 2);

        // Convert byte value to character
        char character = (char) byteValue;

        // Construct the original string
        return String.valueOf(character);
    }
}
