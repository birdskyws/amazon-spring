package net.fbamate.Entity;

import org.springframework.data.repository.CrudRepository;
import java.sql.Timestamp;
 
public interface AordRepository extends CrudRepository<Aord, Long> {
	public Aord findFirstByTasktimeLessThanAndExpireGreaterThan(Timestamp t1,Timestamp t2);
	public Aord findFirstByTasktimeGreaterThan(Timestamp t1);
}


