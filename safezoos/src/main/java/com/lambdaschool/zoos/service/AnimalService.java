package com.lambdaschool.zoos.service;

import com.lambdaschool.zoos.model.Animal;

import java.util.ArrayList;
import java.util.List;

public interface AnimalService
{
    ArrayList<Animal> findAll();

    Animal findAnimalByType(String type);

    List<Animal> listAnimalsByCount();

}
