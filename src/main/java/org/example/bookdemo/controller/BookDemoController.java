package org.example.bookdemo.controller;

import org.example.bookdemo.entity.Book;
import org.example.bookdemo.BookProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/books")
public class BookDemoController {

    @Autowired
    public KafkaTemplate <String, Book> kafkaTemplate;

    @Autowired
    public BookProducer bookProducer;

    @PostMapping
    public ResponseEntity<Book> sendBookDetails(@RequestBody Book book) throws ExecutionException, InterruptedException{
        bookProducer.sendBookDetails(book);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
}
