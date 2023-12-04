package org.example;


import java.time.LocalDate;

public class Book {
    protected String description;
    protected double price;
    protected String title;
    protected Genre genre;
    protected LocalDate publishDate;

    public Book() {
        this.description = "N/A";
        this.price = 0;
        this.title = "N/A";
        this.genre = Genre.ROMANCE_NOVEL;
        this.publishDate = LocalDate.parse("1990-12-12");
    }

    public Book(String description, double price, String title, Genre genre, LocalDate publishDate) {
        this.description = description;
        this.price = price;
        this.title = title;
        this.genre = genre;
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public void setPrice(String price) {
        this.price = Double.parseDouble(price);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public void setGenre(String genre) {
        this.genre = Genre.parseGenre(genre);
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }
    public void setPublishDate(String publishDate) {
        this.publishDate = LocalDate.parse(publishDate);
    }

    @Override
    public String toString() {
        return "Book{" +
                "description='" + description + '\'' +
                ", price=" + price +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", publishDate=" + publishDate +
                '}';
    }
}
