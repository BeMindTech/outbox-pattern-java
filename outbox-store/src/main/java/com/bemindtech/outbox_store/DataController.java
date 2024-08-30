package com.bemindtech.outbox_store;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Slf4j
public class DataController {

    private final OutboxTableRepository outboxTableRepository;

    @RequestMapping(value = "/v1/data", method = RequestMethod.POST)
    public void dataToSend(@RequestBody DataDTO data) {

        var outboxTableData = OutboxTable
                .builder()
                .dataToIntegrate(data.getData())
                .build();

        var savedObject = this.outboxTableRepository.save(outboxTableData);

        log.info("saved object = {}", savedObject);
    }

}
