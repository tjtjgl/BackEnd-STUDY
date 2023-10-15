package study.stock.facade;

import lombok.AllArgsConstructor;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;
import study.stock.service.StockService;

import java.util.concurrent.TimeUnit;

@Component
@AllArgsConstructor
public class RedissonLockStockFacade {
    private RedissonClient redissonClient;
    private StockService stockService;

    public void decrease(Long id, Long quantity) {
        RLock lock = redissonClient.getLock(id.toString());

        try {
            boolean available = lock.tryLock(10, 1, TimeUnit.SECONDS);

            if (!available) {
                System.out.println("키 획득 실패");
                return;
            }

            stockService.decrease(id, quantity);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }

    }
}
