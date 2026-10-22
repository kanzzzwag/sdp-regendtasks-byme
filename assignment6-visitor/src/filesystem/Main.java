package filesystem;

import filesystem.element.Directory;
import filesystem.element.File;
import filesystem.visitor.SearchVisitor;
import filesystem.visitor.SizeCalculatorVisitor;

public class Main {
    void main(){

        Directory root = buildFileSystem();

        //Visitor 1

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " bytes");

        //Visitor 2

        SearchVisitor searchVisitor = new SearchVisitor(f -> f.getExtension().equals("txt"));
        root.accept(searchVisitor);
        System.out.println("Found '.txt' files: ");
        for(File f : searchVisitor.getFoundFiles()){
            System.out.println(" " + f.getName() + " (" + f.getSize() + ") bytes");
        }

    }
    private static Directory buildFileSystem(){
        Directory icons = new Directory("icons").add(new File(800, "logo.png"));

        Directory images = new Directory("images").add(new File(20000, "photo.jpg")).add(icons);

        Directory docs = new Directory("docs").add(new File(5000, "report.docx"))
                .add(new File(300, "notes.txt"));

        return new Directory("root")
            .add(new File(400, "readme.txt")).add(docs).add(images);
    }
}
