package net.fbamate.Entity;
import org.springframework.data.repository.CrudRepository;
import java.sql.Timestamp;
import java.util.List; 

public interface TasklistRepository extends CrudRepository<Tasklist, Long> {
	public List<Tasklist> findByTasktimeLessThan(Timestamp t);
	public List<Tasklist> findFirst3ByTasktimeLessThanAndState(Timestamp t,int state);
	public Tasklist findOneById(Integer id);
}


