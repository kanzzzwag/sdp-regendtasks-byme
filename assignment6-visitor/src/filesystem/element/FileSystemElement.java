package filesystem.element;

import filesystem.visitor.FileSystemVisitor;

public interface FileSystemElement {

    void accept(FileSystemVisitor visitor);

    String getName();
}
