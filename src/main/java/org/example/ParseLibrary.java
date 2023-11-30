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

    // TODO Overload startTag
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes attr){
        currentTag = qName;

        if(currentTag.equals("author")){
            author = new Author();
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
                    case "book":
                        BookSwitch(value);
                        break;
                }
            }
        }
    }
    public void BookSwitch(String value) {
        switch (currentTag){
            case "title":
                book.setTitle(value);
                break;
            case "genre":
                book.setGenre(value);
                break;
            case "price":
                book.setPublishDate(value);
                break;
            case "description":
                book.setDescription(value);
                break;
        }
    }
    // TODO Constructor
    public ParseLibrary(String fileName) {
        try {
            authors = new ArrayList<>();
            books = new ArrayList<>();

            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser parser = factory.newSAXParser();

            parser.parse(new File(fileName), this);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
