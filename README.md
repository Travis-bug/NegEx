# NegEx

**NegEx** is a Java library that adds **negative indexing support** to arrays and collections, similar to Python.

Negative indexing allows accessing elements from the end of a collection.

Example:
* `-1` → last element
* `-2` → second-to-last element

NegEx safely converts negative indices and provides helpful out-of-bounds error messages using Jansi for color-coded feedback.

---

## Features
* **Python-style negative indexing**: Simplifies reverse traversal.
* **Safe index conversion**: Handles the math internally.
* **Helpful out-of-bounds error handling**: Stylized Jansi output with suggestions.
* **Works with arrays and lists**: Compatible with `T[]` and `List<T>`.
* **Lightweight and easy to integrate**.

---

## Installation (Maven)

Add this dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>io.github.travis-bug</groupId>
    <artifactId>negex</artifactId>
    <version>1.1.0</version>
</dependency>

```
---

## How Negative Indexing Works

For a collection of size **n**:

| Index | Meaning |
| --- | --- |
| `0` | First element |
| `n - 1` | Last element |
| `-1` | Last element |
| `-2` | Second last |
| `-n` | First element |

**Valid index range:** `-n ... n - 1`
*Anything outside this range throws a specialized error.*

---

## Basic Usage

### Example Array

```java
int[] arr = {10, 20, 30, 40, 50};
int value = Neg.at(arr, "arr", -1); // Access last element
System.out.println(value); // Output: 50

```

### IDE Color Support (Important)

By default, NegEx attempts to force ANSI colors in environments that identify as "Redirected" (like IntelliJ or Eclipse consoles).

If colors are still not appearing, ensure that no other part of your application is initializing `AnsiConsole` before NegEx. You can manually ensure support by adding this to your `main` method:

```java
System.setProperty("jansi.passthrough", "true");

```

---

### Why use NegEx?

| Feature | Standard Java | NegEx |
| :--- | :--- | :--- |
| **Last Element** | `arr[arr.length - 1]` | `Neg.at(arr, "arr", -1)` |
| **Second Last** | `arr[arr.length - 2]` | `Neg.at(arr, "arr", -2)` |
| **Errors** | `ArrayIndexOutOfBoundsException` (Vague) | Stylized Jansi Error (With Suggestions) |
## Index Conversion Logic

Negative indices are converted internally using the following formula:

`realIndex = size + index`

**Example:**

* `size = 5`
* `index = -1`
* `realIndex = 4`

---

## Out-of-Bounds Handling

NegEx throws an exception when an invalid index is used. This helps developers correct indexing mistakes quickly by providing specific suggestions.

**Example message:**
`Index -10 is 4 past the valid negative range.`

---

## Roadmap

* **Version 1.2.x**: Slice and range indexing, expanded collection support.
* **Version 1.3.x**: Performance optimizations and API improvements.
* **Future Goals**: Full indexing utility toolkit and increased testing coverage.

---

## Contributing

Contributions and suggestions are welcome!

1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Submit a pull request

## License

This project is licensed under the **MIT License**.

**Author:** Eseosa Travis Eweka
