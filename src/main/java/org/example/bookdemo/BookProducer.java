package org.example.bookdemo;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.KafkaException;
import org.apache.kafka.common.errors.InterruptException;
import org.example.bookdemo.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class BookProducer {

    @Autowired
    public KafkaTemplate<String, Book> kafkaTemplate;

    @Value("${spring.kafka.order.topic}")
    private String  bookTopic;

    public void sendBookDetails(Book book) throws InterruptedException {
        kafkaTemplate.send(bookTopic, book);
        log.info("Book {} sent to topic: {}  ", book, bookTopic);

    }
}
