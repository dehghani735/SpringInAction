package com.mdt.tacobar.data;

import com.mdt.tacobar.Taco;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository extends PagingAndSortingRepository<Taco, Long> { // it was CrudRepository before REST

//    Taco save(Taco design);
}
