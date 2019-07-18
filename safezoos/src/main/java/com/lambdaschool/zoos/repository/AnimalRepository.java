package com.lambdaschool.zoos.repository;

import com.lambdaschool.zoos.model.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long>
{
    Animal findByAnimaltype(String type);

    @Query(value = "select a.animaltype, count(a.animaltype) as count from animal a join zooanimals on a.animalid = zooanimals.animalid group by a.animaltype",
            nativeQuery = true)
    List<Animal> animalsByCount();
}
