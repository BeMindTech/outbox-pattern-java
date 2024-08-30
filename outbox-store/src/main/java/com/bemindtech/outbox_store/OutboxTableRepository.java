package com.bemindtech.outbox_store;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxTableRepository extends CrudRepository<OutboxTable, Long> {
}
