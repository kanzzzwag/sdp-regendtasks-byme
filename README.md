# Assignment 4 — Facade Pattern (Home Theater)

**Course:** ShP-2216 Software Design Patterns
**Student:** Batyrkhan Kanapiya
**Language:** Java 27

## About

A home theater has many devices that must be turned on in the correct order
(popcorn, lights, screen, projector, amplifier, DVD player). Doing this by hand
takes about 15 method calls.

The **Facade pattern** hides this complexity behind one simple class.
The client calls only `watchMovie("title")` and `endMovie()`.

## Project structure

```
src/facadepattern/
├── Main.java                  ← Client (uses only the facades)
├── facade/
│   ├── HomeTheaterFacade.java ← main facade: watchMovie(), endMovie()
│   └── MusicFacade.java       ← second facade: startMusic(), stopMusic()
└── subsystem/
    ├── Amplifier.java
    ├── DVDPlayer.java
    ├── Projector.java
    ├── Screen.java
    ├── TheaterLights.java
    ├── PopcornPopper.java
    └── InputSource.java       ← enum (DVD, RADIO)
```

## Key design points

- **Subsystem classes have real rules.** For example: you can't play a DVD without a disc,
  the projector must warm up before you set its input, and the volume must be 0–100.
- **The facade only coordinates.** It calls subsystem methods in the correct order
  and does not repeat their logic.
- **Rollback on errors.** If any step of `watchMovie()` fails, the facade turns off
  everything that was already turned on, then reports a clear error.
- **Subsystem classes don't know about the facades.** They can still be used directly
  by advanced clients.
- **Dependency injection.** The facades receive the devices in their constructor
  instead of creating them.
- **A second facade (`MusicFacade`)** uses only the amplifier and lights, so
  `HomeTheaterFacade` keeps a single responsibility.

## How to run

1. Open the project in IntelliJ IDEA (JDK 17).
2. Run `Main.java`.

The program shows 3 demos:
1. A normal movie night (`watchMovie` → `endMovie`)
2. Error handling (ending a movie that isn't playing)
3. Music mode using the second facade