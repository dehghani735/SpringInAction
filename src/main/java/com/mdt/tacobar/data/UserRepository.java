package com.mdt.tacobar.data;

import com.mdt.tacobar.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
