package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Book> books = new ArrayList<>();

    public static void main(String[] args){
        Menu();
    }

    public static void Menu(){
        while (true) {
            System.out.println("Привет! Добро пожаловать в библиотеку. Налетай!");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Показать все книги");
            System.out.println("3. Найти книгу по ID");
            System.out.println("4. Изменить название книги по ID");
            System.out.println("5. Удалить книгу по ID");
            System.out.println("0. Выход");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showBooks();
                    break;
                case 3:
                    findBook();
                    break;
                case 4:
                    editTitle();
                    break;
                case 5:
                    removeBook();
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void showBooks(){
        if (books.isEmpty()){
            System.out.println("Добавленных книг не удалось найти");
        } else {
            for (Book b : books){
                System.out.println(b);
            }
        }
    }

    public static void addBook() {
        System.out.println("Введите название книги: ");
        String title = scanner.nextLine();
        System.out.println("Введите автора этой шикарной книги: ");
        String author = scanner.nextLine();
        System.out.println("Введите год: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        if (title.isEmpty() || author.isEmpty() || year <= 0){
            System.out.println("Проверьте вставленные данные!");
        } else {
            Book newBook = new Book(0, title, author, year);
            books.add(newBook);
            System.out.print("Книга была успешно добавлена!");
        }
    }

    public static void findBook(){
        System.out.print("Введите ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (id <= 0){
            System.out.print("Введите корректный ID!");
        }  else{
            for (Book b : books) {
                if (id == b.getId()) {
                    System.out.println(b);
                    break;
                }
            }
        }
    }
    public static void removeBook() {
        System.out.print("Какую книгу хотите удалить? (введите ID): ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (id <= 0) {
            System.out.println("Введите корректный ID!");
            return;
        }

        boolean found = false;
        for (Book b : books) {
            if (b.getId() == id) {
                books.remove(b);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Книга была успешно удалена!");
        } else {
            System.out.println("Книга с таким ID не найдена.");
        }
    }
    public static void editTitle() {
        System.out.print("Введите ID той книги, которой хотите поменять название: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (id <= 0) {
            System.out.println("Введите корректный ID!");
            return;
        }

        boolean found = false;
        for (Book b : books) {
            if (b.getId() == id) {
                System.out.print("Введите новое название книги: ");
                String newTitle = scanner.nextLine();
                b.setTitle(newTitle);
                found = true;
                break;
            }
        }
        if (found) {
            System.out.println("Название успешно изменено!");
        } else {
            System.out.println("Книга с таким ID не найдена.");
        }
    }
}
