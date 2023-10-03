package com.workintech.zoo.exceptions;

import com.workintech.zoo.entity.Animal;
import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.entity.Koala;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class AnimalValidator {

    public static void isIdValid(int id){
        if(id<=0){
            throw new AnimalException("Id is not valid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isIdNotExist(Map animals, int id){
        if(!animals.containsKey(id)){
            throw new AnimalException("Animal with given id is not exist", HttpStatus.NOT_FOUND);
        }
    }

    public static void isIdExist(Map animals, int id){
        if(animals.containsKey(id)){
            throw new AnimalException("Animal with given id is not exist", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isAnimalValid(Animal animal){
        if((animal.getName()== null || animal.getName().isEmpty()) ||
        animal.getWeight()<=0 || animal.getWeight()>100 ) {
            throw new AnimalException("Animal credentials are not valid", HttpStatus.BAD_REQUEST);
        }
    }

    public static void isKangarooValid(Kangaroo kangaroo){
        if (kangaroo.getWeight()< 100 ) {
            throw new AnimalException("kangaroo credentials are not valid", HttpStatus.BAD_REQUEST);

        }


    }

}
