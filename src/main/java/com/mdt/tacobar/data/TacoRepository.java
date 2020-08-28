package com.mdt.tacobar.data;

import com.mdt.tacobar.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {

//    Taco save(Taco design);
}