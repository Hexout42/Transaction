package ru.lernup.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.lernup.transaction.dao.data.BookStoreService;

@SpringBootApplication
public class TransactionApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TransactionApplication.class, args);
        BookStoreService bookStoreDao = context.getBean(BookStoreService.class);
//        System.out.println(bookStoreDao.getAllBook());
//        System.out.println(bookStoreDao.getAllOrderToConsumer("Steve"));


        bookStoreDao.buyBook("Shopper", "Steve", "Tree", 1);
        bookStoreDao.buyBook("Shopper", "GreedOFRath", "Tree", 1);
    }

}
