# Assignment 6 - Visitor Pattern

For this assignment I picked Option A: a small file system with files and folders.
I wanted to add two operations to it (counting total size and searching for files)
without touching the `File` and `Directory` classes. That's what the Visitor pattern is for.

## Project structure

```
src/filesystem/
├── Main.java
├── element/
│   ├── FileSystemElement.java   - interface, has accept(visitor)
│   ├── File.java                - a file with a name and a size
│   └── Directory.java           - a folder that holds files and other folders
└── visitor/
    ├── FileSystemVisitor.java   - interface, visitFile() and visitDirectory()
    ├── SizeCalculatorVisitor.java - adds up the size of all files
    └── SearchVisitor.java       - finds files that match a condition
```

## How it works

Every element has an `accept(visitor)` method. A `File` calls `visitor.visitFile(this)`,
a `Directory` calls `visitor.visitDirectory(this)`. So the right method is picked twice:
first by the element type, then by the visitor type. This is called double dispatch,
and because of it I didn't need any `instanceof` checks.

A directory doesn't do anything by itself. The visitor goes into its children
and calls `accept()` on each of them, so the whole tree gets visited.

If I want a new operation (for example, counting files), I just write a new visitor
class. `File` and `Directory` stay the same.

## How to run

Java 27. Open the project in IntelliJ and run `Main`, or from the terminal:

```
javac -d out $(find src -name "*.java")
java -cp out filesystem.Main
```

## Example output

The test tree:

```
root/
├── readme.txt (400)
├── docs/
│   ├── report.docx (5000)
│   └── notes.txt (300)
└── images/
    ├── photo.jpg (20000)
    └── icons/
        └── logo.png (800)
```

Output:

```
Total size: 26500 bytes
Found '.txt' files:
  readme.txt (400 bytes)
  notes.txt (300 bytes)
```