package org.example.bookdemo;

import lombok.extern.slf4j.Slf4j;
import org.example.bookdemo.entity.Book;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookConsumer {

   @KafkaListener(topics = "${spring.kafka.order.topic}", groupId = "${spring.kafka.consumer.group-id}" )
    public void receiveBook(Book book) {
       log.info(" Book Details {} are received", book.toString());

   }
}
