package ru.lernup.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import ru.lernup.transaction.dao.data.BookStoreService;
import ru.lernup.transaction.dao.exeption.NotHaveBookException;


@SpringBootApplication
public class TransactionApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(TransactionApplication.class, args);
        BookStoreService bookStoreDao = context.getBean(BookStoreService.class);
//        System.out.println(bookStoreDao.getAllBook());
//        System.out.println(bookStoreDao.getAllOrderToConsumer("Steve"));



        new Thread(() -> {
           while (true){
            try {

               if(bookStoreDao.buyBook("Shopper", "Steve", "Tree", 1))
                   break;
            } catch (ObjectOptimisticLockingFailureException g) {
                continue;
            }
            catch (NotHaveBookException e){
                System.out.println(e.toString());
                break;
            }
           }
        }).start();


            new Thread(() -> {
                while (true) {
                    try {

                        if(bookStoreDao.buyBook("Shopper", "GreedOFRath",
                                "Tree", 1))
                            break;
                    } catch (ObjectOptimisticLockingFailureException g) {
                        continue;
                    }
                    catch (NotHaveBookException e){
                        System.out.println(e.toString());
                        break;
                    }

                } }).start();
        }

}
