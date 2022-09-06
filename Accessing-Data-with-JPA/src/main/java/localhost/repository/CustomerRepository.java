package localhost.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import localhost.entity.JpaController;

public interface CustomerRepository extends CrudRepository<JpaController, Long> {
	List<JpaController> findByLastName(String lastName);
	
	JpaController findById(long id);


}
