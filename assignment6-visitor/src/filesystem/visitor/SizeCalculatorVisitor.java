package filesystem.visitor;

import filesystem.element.File;
import filesystem.element.Directory;
import filesystem.element.FileSystemElement;


public class SizeCalculatorVisitor implements FileSystemVisitor{

    private long totalSize;

    @Override
    public void visitFile(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visitDirectory(Directory directory) {
        for(FileSystemElement child : directory.getChildren()){
            child.accept(this);
        }
    }

    public long getTotalSize() {
        return totalSize;
    }
}
