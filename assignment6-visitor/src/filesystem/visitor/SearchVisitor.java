package filesystem.visitor;

import filesystem.element.File;
import filesystem.element.Directory;
import filesystem.element.FileSystemElement;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {

    private final Predicate<File> criterion;
    private final List<File> foundFiles = new ArrayList<>();

    public SearchVisitor(Predicate<File> criterion) {
        this.criterion = criterion;
    }

    @Override
    public void visitFile(File file) {
        if(criterion.test(file)){
            foundFiles.add(file);
        }
    }

    @Override
    public void visitDirectory(Directory directory) {
        for(FileSystemElement child : directory.getChildren()){
            child.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
