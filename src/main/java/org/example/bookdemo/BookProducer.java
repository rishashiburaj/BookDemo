package org.example.bookdemo;

import org.example.bookdemo.entity.Book;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

import java.util.concurrent.ExecutionException;

@Service
public class BookProducer {

    private static final Logger log = LoggerFactory.getLogger(BookProducer.class);

    @Autowired
    public KafkaTemplate<String, Book> kafkaTemplate;

    @Value("${spring.kafka.order.topic}")
    private String  bookTopic;

    public void sendBookDetails(Book book) throws ExecutionException, InterruptedException{
        kafkaTemplate.send(bookTopic, book);
        log.info("Book {} sent to topic: {}  " , book, bookTopic);

    }
}
