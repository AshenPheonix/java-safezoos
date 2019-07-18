package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Long> {
//    @Transactional
//    @Modifying
//    @Query(value="delete from ")
}
