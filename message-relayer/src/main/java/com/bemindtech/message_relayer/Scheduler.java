package com.bemindtech.message_relayer;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class Scheduler {

    private final OutboxTableRepository outboxTableRepository;

//    @Scheduled(cron = "0/1 * * * * ?")
    @Scheduled(fixedRate = 1000)
    public void scheduler() {

        log.info("Starting message-relayer job...");

        List<OutboxTable> outboxTableList = this.outboxTableRepository.findByIntegrated(Integrated.N);

        outboxTableList
                .forEach(x -> {
                    log.info("picked = {}", x);
                    x.setIntegrated(Integrated.Y);
                    outboxTableRepository.save(x);
                });

    }

}
