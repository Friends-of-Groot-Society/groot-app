package net.ourdailytech.rest.webservice.repositories;

import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
 

import net.ourdailytech.rest.webservice.entities.PostEntity;

@Repository
//public interface PostRepository extends JpaRepository<PostEntity, Long> {
public interface PostRepository extends CrudRepository<PostEntity, Long> {
	List<PostEntity> findByUsername(String username);
	
	Optional<PostEntity> findByCat3(String cat3); 
	Optional<PostEntity> findByDid(String did);
}
