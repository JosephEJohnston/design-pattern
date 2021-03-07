package ch20_Flyweight;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BigChar {
    private char charName;
    private String fontData;

    public BigChar(char charName) {
        this.charName = charName;
        try {
            BufferedReader reader = new BufferedReader(
                new FileReader("big" + charName + ".txt")
            );
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                builder.append(line);
                builder.append("\n");
            }
            reader.close();
            this.fontData = builder.toString();
        } catch (IOException e) {
            this.fontData = charName + "?";
        }
    }

    public void print() {
        System.out.print(fontData);
    }
}
