package filesystem.visitor;

import filesystem.element.File;
import filesystem.element.Directory;

public interface FileSystemVisitor {

    void visitFile(File file);

    void visitDirectory(Directory directory);
}
