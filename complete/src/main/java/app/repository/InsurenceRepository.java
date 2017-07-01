package app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface InsurenceRepository<Insurence, Integer extends Serializable> extends CrudRepository<Insurence, Integer> {

}
