package filesystem.element;

import filesystem.visitor.FileSystemVisitor;

public class File implements FileSystemElement {

    private final long size;
    private final String name;

    public File(long size, String name) {
        if(size < 0){
            throw new IllegalArgumentException("Size can't be negative!");
        }
        this.size = size;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getExtension(){
        int dot = name.lastIndexOf('.');
        if(dot == -1){
            return "";
        }
        return name.substring(dot + 1);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visitFile(this);
    }
}
