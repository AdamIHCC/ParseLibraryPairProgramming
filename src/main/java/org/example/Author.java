package org.example;

import java.util.ArrayList;

public class Author {
    protected String name;
    protected int age;
    protected ArrayList<Book> books;

    public Author() {
        this.name = "N/A";
        this.age = 0;
        this.books = new ArrayList<Book>();
    }

    public Author(String name, int age, ArrayList<Book> books) {
        this.name = name;
        this.age = age;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setAge(String age) {
        this.age = Integer.parseInt(age);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", books=" + books +
                '}';
    }
}
