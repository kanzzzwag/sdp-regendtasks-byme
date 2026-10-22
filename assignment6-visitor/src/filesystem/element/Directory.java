package filesystem.element;

import filesystem.visitor.FileSystemVisitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement{

    private final String name;
    private final List<FileSystemElement> children = new ArrayList<>();

    public Directory(String name) {
        this.name = name;
    }

    public Directory add(FileSystemElement element){
        children.add(element);
        return this;
    }

    public List<FileSystemElement> getChildren(){
        return List.copyOf(children);
    }

    @Override
    public String getName() {
        return "";
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitDirectory(this);
    }
}
