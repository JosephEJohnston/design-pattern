package ch13_Visitor;

import ch13_Visitor.entry.Directory;
import ch13_Visitor.entry.File;
import ch13_Visitor.visitor.FileFindVisitor;
import ch13_Visitor.visitor.ListVisitor;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("Making root entries...");
            Directory rootDir = new Directory("root");
            Directory binDir = new Directory("bin");
            Directory tmpDir = new Directory("tmp");
            Directory usrDir = new Directory("usr");
            rootDir.add(binDir);
            rootDir.add(tmpDir);
            rootDir.add(usrDir);
            binDir.add(new File("vi", 10000));
            binDir.add(new File("latex", 20000));
            rootDir.accept(new ListVisitor());

            System.out.println("");
            System.out.println("Making user entries...");
            Directory yuki = new Directory("yuki");
            Directory hanako = new Directory("hanako");
            Directory tomura = new Directory("tomura");
            usrDir.add(yuki);
            usrDir.add(hanako);
            usrDir.add(tomura);
            yuki.add(new File("diary.html", 100));
            yuki.add(new File("Composite.java", 200));
            hanako.add(new File("memo.tex", 300));
            hanako.add(new File("index.html", 350));
            tomura.add(new File("game.doc", 400));
            tomura.add(new File("junk.mail", 500));
//            rootDir.accept(new ListVisitor());

            FileFindVisitor findVisitor = new FileFindVisitor(".html");
            rootDir.accept(findVisitor);

            System.out.println("HTML files are:");
            Iterator<File> iterator = findVisitor.getFoundFiles();
            while (iterator.hasNext()) {
                File file = iterator.next();
                System.out.println(file.toString());
            }

        } catch (FileTreatmentException e) {
            e.printStackTrace();
        }
    }
}
