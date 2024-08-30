package com.bemindtech.message_relayer;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutboxTableRepository extends CrudRepository<OutboxTable, Long> {

    List<OutboxTable> findByIntegrated(Integrated integrated);

}
