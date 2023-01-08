package com.friendsofgroot.app.repositories;

import com.friendsofgroot.app.models.PostEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//public interface PostRepository extends JpaRepository<PostEntity, Long> {
public interface PostRepository extends CrudRepository<PostEntity, Long> {

	Optional<PostEntity> findByCat3(String cat3); 
	Optional<PostEntity> findByDid(String did);

	List<PostEntity> findAllByUsername(String username);

}
