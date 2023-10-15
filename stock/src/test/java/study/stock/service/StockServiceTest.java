package study.stock.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import study.stock.domain.Stock;
import study.stock.repository.StockRepository;

import java.util.Optional;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceTest {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;


    @BeforeEach
    public void before(){
        stockRepository.saveAndFlush(new Stock(1L, 100L));
    }

    @AfterEach
    public void after(){
        stockRepository.deleteAll();
    }

    @Test
    @Transactional
    public void decreaseQuantity(){
        stockService.decrease(1L, 1L);

        Stock stock = stockRepository.findById(1L).orElseThrow();
        assertThat(99L).isEqualTo(stock.getQuantity());

    }

    @Test
    public void concurrency() throws InterruptedException {
        int threadCount = 100;

        //비동기로 실행하는 작업을 단순화하여 사용할 수 있게 도와주는 JAVA API
        ExecutorService executorService = Executors.newFixedThreadPool(32);

        //100개의 요청이 끝날때까지 기다리기 위해 countdownletch 활용
        //다른 스레드에서 수행중인 작업이 완료될 때 까지 대기할 수 있도록 도와주는 클래스
        CountDownLatch countDownLatch = new CountDownLatch(threadCount);

        for (int i = 0; i < threadCount; i++) {
            executorService.submit(()->{
                try {
                    stockService.decrease(1L, 1L);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        countDownLatch.await();

        Stock stock = stockRepository.findById(1L).orElseThrow();

        assertThat(stock.getQuantity()).isEqualTo(0L);

    }





}