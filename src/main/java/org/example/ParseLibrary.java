package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ParseLibrary extends DefaultHandler {
    private Author author;
    private Book book;
    private String currentTag;
    public ArrayList<Author> authors;
    public ArrayList<Book> books;

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    // TODO Overload startTag
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attr){
        currentTag = qName;

        if(currentTag.equals("author")){
            author = new Author();
        } else if (currentTag.equals("books")) {
            books = new ArrayList<Book>();
        } else if (currentTag.equals("book")) {
            book = new Book();
        }
    }
    // TODO Overload endElement
    @Override
    public void endElement(String namespaceURI, String localName, String qName) {
        if(qName.equals("author")){
            authors.add(author);
            author = null;
        } else if (qName.equals("books")) {
            author.setBooks(books);
            books = null;
        } else if (qName.equals("book")) {
            books.add(book);
            book = null;
        }
    }
    // TODO Overload char
    @Override
    public void characters(char[] ch, int start, int length){
        if(currentTag != null){
            String value = new String(ch, start, length).trim();
            if(!value.isEmpty()) {
                switch (currentTag){
                    case "name":
                        author.setName(value);
                        break;
                    case "age":
                        author.setAge(value);
                        break;
                    case "title":
                        book.setTitle(value);
                        break;
                    case "genre":
                        book.setGenre(value);
                        break;
                    case "price":
                        book.setPrice(value);
                        break;
                    case "description":
                        book.setDescription(value);
                        break;
                    case "publish_date":
                        book.setPublishDate(value);
                        break;
                }
            }
        }
    }

    /**
     * So the commented out code we originally had did not work. The program would not go into the BookSwitch
     * method we made so when we moved everything out it started to work. We are unsure why it did not work
     * though we suspect it was because of the book/books tag.
     */
//    @Override
//    public void characters(char[] ch, int start, int length){
//        if(currentTag != null){
//            String value = new String(ch, start, length).trim();
//            if(!value.isEmpty()) {
//                switch (currentTag){
//                    case "name":
//                        author.setName(value);
//                        break;
//                    case "age":
//                        author.setAge(value);
//                        break;
//                    case "book":
//                        BookSwitch(value);
//                        break;
//                }
//            }
//        }
//    }
//    public void BookSwitch(String value) {
//        switch (currentTag){
//            case "title":
//                book.setTitle(value);
//                break;
//            case "genre":
//                book.setGenre(value);
//                break;
//            case "price":
//                book.setPrice(value);
//                break;
//            case "description":
//                book.setDescription(value);
//                break;
//            case "publish_date":
//                book.setPublishDate(value);
//                break;
//        }
//    }
    // TODO Constructor
    public ParseLibrary(String fileName) {
        try {
            authors = new ArrayList<>();

            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser parser = factory.newSAXParser();

            parser.parse(new File(fileName), this);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
