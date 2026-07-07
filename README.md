# Java Coding Portfolio — Software Development Techniques (CO7049)

A collection of Java exercises completed as part of the **Coding Portfolio** assessment for the *Software Development Techniques* module (CO7049) during my MSc in Data Science. Each exercise was assessed and verified by a module tutor during weekly lab sessions.

> 📌 **Context:** This coursework has already been marked and graded. It's shared here as a record of practical Java work covering core OOP, exception handling, concurrency, file I/O, and design patterns.

## What this demonstrates

- Object-oriented design (interfaces, inheritance, composition)
- Custom exception handling and input validation
- Multithreading — `Thread`, `Runnable`, `synchronized`, `wait()`/`notify()`
- File I/O, including object serialization
- Sorting algorithms and custom `Comparable`/`Comparator` implementations
- The **Facade** design pattern
- Unit testing with JUnit 5

## Structure

Each exercise lives in its own folder and compiles independently. A few exercises re-use common class names (e.g. `Student`, `Product`, `InvalidSalaryException`) for different purposes across different weeks — keeping them separate avoids clashes if you try to compile the whole repo as one package.

| Folder | Exercise | Concepts |
|---|---|---|
| `01-bmi-calculator` | BMI Calculator + unit test | Input validation, JUnit 5 |
| `02-calculator-utilities` | Basic calculator (`Utilities` package) | Packages, arithmetic, divide-by-zero handling |
| `03-spaceprobe-facade-pattern` | Space probe deployment simulation | **Facade pattern** — one controller unifies Power, Navigation, Communications, and Thrusters subsystems |
| `04-graderank-sorting-comparison` | Student grade ranking | `Comparable`, `Collections.sort()` vs a hand-written insertion sort, performance timing |
| `05-facultygraderank-custom-comparator` | Multi-key student sorting | Custom `Comparator` — sort by faculty, then by grade descending |
| `06-favouritefoods-file-io` | Favourite foods file writer | Text file writing, reading, and appending |
| `07-filemanager` | Simple file read/write utility + unit tests | `java.nio.file`, JUnit 5 |
| `08-salarycheck-custom-exception` | Salary input validator | Custom checked exception, input-loop validation |
| `09-jointaccount-multithreading` | Joint bank account simulation | Two threads sharing one account, `synchronized` methods, race-condition safety |
| `10-lyricsthread-multithreading` | Sequential song lyric printer | `Thread`, `join()` to enforce execution order |
| `11-threadcount-wait-notify` | Odd/even number printer | Producer-consumer style coordination with `wait()`/`notify()` |
| `12-mydata-interface` | Min/max finder | Interface implementation (`MinMax`) |
| `13-numbersort-array-sort` | Random array sorter | `Arrays.sort()`, `Random` |
| `14-palindrome-string-algorithm` | Palindrome checker + unit tests | Two-pointer string algorithm, JUnit 5 |
| `15-productfiles-serialization` | Mobile catering product manager | `Serializable`, `ObjectOutputStream`/`ObjectInputStream`, CRUD-style console menu |
| `16-product-standalone` | Product data class | `Serializable` model class (standalone variant, used independently of exercise 15) |
| `17-invalidsalaryexception-standalone` | Custom exception class | Alternate/earlier version of a custom exception (int-based constructor, distinct from the one in exercise 8) |

## Running the exercises

Each folder is self-contained. From inside a folder:

```bash
javac *.java
java <MainClassName>
```

For example:

```bash
cd 09-jointaccount-multithreading
javac JointAccount.java
java JointAccount
```
