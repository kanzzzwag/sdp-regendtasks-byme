# Assignment 5 — Strategy Pattern: Navigation / Route Planning

A small Java 17 console app that plans a route with different travel modes.
Each travel mode is a separate strategy, and the `Navigator` can switch between them at runtime.

## Structure

```
src/navigation/
├── Main.java                          client: runtime switching + selection by name
├── context/Navigator.java             context that delegates to a RouteStrategy
├── model/Route.java                   record with the planned route
└── strategy/
    ├── RouteStrategy.java             functional strategy interface
    ├── CarStrategy.java               average speed + traffic delay
    ├── WalkStrategy.java              average speed only
    ├── CycleStrategy.java             average speed + rest every 10 km
    └── PublicTransportStrategy.java   average speed + waiting time
```

## Compile and run

```bash
javac --release 17 -d out $(find src -name "*.java")
java -cp out navigation.Main
```

On Windows PowerShell:

```powershell
javac --release 17 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out navigation.Main
```
