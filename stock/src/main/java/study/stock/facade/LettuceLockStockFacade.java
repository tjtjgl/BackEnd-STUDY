package study.stock.facade;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import study.stock.repository.RedisLockRepository;
import study.stock.service.StockService;

@Component
@AllArgsConstructor
public class LettuceLockStockFacade {

    private RedisLockRepository redisRockRepository;
    private StockService stockService;

    public void decrease(Long id, Long quantity) throws InterruptedException {
        while (!redisRockRepository.lock(id)) {
            Thread.sleep(100);
        }

        try{
            stockService.decrease(id,quantity);
        }finally {
            redisRockRepository.unlock(id);
        }
    }
}
