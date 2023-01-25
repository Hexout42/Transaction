package ru.lernup.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import ru.lernup.transaction.dao.data.BookStoreService;


@SpringBootApplication
public class TransactionApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TransactionApplication.class, args);
        BookStoreService bookStoreDao = context.getBean(BookStoreService.class);
//        System.out.println(bookStoreDao.getAllBook());
//        System.out.println(bookStoreDao.getAllOrderToConsumer("Steve"));



        new Thread(() -> {

            try {

                bookStoreDao.buyBook("Shopper", "Steve", "Tree", 1);
            } catch (ObjectOptimisticLockingFailureException g) {
                System.out.println(g.toString());

            }
        }).start();


            new Thread(() -> {
                try {

                    bookStoreDao.buyBook("Shopper", "GreedOFRath", "Tree", 1);
                } catch (ObjectOptimisticLockingFailureException g) {
                    System.out.println(g.toString() );
                }

            }).start();
        }

}
