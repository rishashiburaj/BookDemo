package org.example.bookdemo;

import org.example.bookdemo.entity.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class BookConsumer {

    private static final Logger log = LoggerFactory.getLogger(BookConsumer.class);

   @KafkaListener(topics = "${spring.kafka.order.topic}", groupId = "${spring.kafka.consumer.group-id}" )
    public void receiveBook(Book book) {
       log.info(" Book Details {} are received", book.toString());

   }
}
