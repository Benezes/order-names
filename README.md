# Order Names

## Stack

- Java (v17)
- Maven (v3.9.1)
- Python (v3.11.3)

## How to Run
This project sorts a list of names based on the `sorted-names-list.txt` file located in the project's root directory.

There are **two** options for creating the list of names .txt file:

> 1 - Manually create a .txt file named `sorted-names-list.txt` in the project's root directory and populate it with various names.

> 2 - Run the following Python command in the project's root directory. Replace `<quantity>` with the number of names you want; this program will generate the file with the specified quantity of names.

```sh
python name-generator.py <quantity>
```

With the .txt file now in the root directory, run the following Maven command:

```sh
mvn compile exec:java
```
This command runs Java to sort the list of names in the .txt file you placed in the root directory. Java will overwrite the file. After execution, open the file to see the sorted list of names.
