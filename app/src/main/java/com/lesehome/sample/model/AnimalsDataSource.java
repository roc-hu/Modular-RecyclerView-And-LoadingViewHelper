package com.lesehome.sample.model;

import com.lesehome.carrot.recycler.modularadapter.IItemEntity;
import com.lesehome.sample.model.entity.Advertisement;
import com.lesehome.sample.model.entity.Cat;
import com.lesehome.sample.model.entity.Dog;
import com.lesehome.sample.model.entity.Gecko;
import com.lesehome.sample.model.entity.Snake;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hcp on 16/1/14.
 */
public class AnimalsDataSource {
    public static List<IItemEntity> getAnimalsSnakeAndGecko() {
        List<IItemEntity> animals = new ArrayList<>();

        animals.add(new Snake("Mub Adder", "Adder"));
        animals.add(new Dog("小🐶🐶狗"));
        animals.add(new Snake("Texas Blind Snake", "Blind snake"));
        animals.add(new Snake("Tree Boa", "Boa"));
        animals.add(new Gecko("Fat-tailed", "Hemitheconyx"));
        animals.add(new Gecko("Stenodactylus", "Dune Gecko"));
        animals.add(new Gecko("Leopard Gecko", "Eublepharis"));
        animals.add(new Gecko("Madagascar Gecko", "Phelsuma"));

        animals.add(new Snake("Mub Adder", "Adder"));
        animals.add(new Snake("Texas Blind Snake", "Blind snake"));
        animals.add(new Snake("Tree Boa", "Boa"));
        animals.add(new Gecko("Fat-tailed", "Hemitheconyx"));
        animals.add(new Gecko("Stenodactylus", "Dune Gecko"));
        animals.add(new Gecko("Leopard Gecko", "Eublepharis"));
        animals.add(new Gecko("Madagascar Gecko", "Phelsuma"));

        animals.add(new Snake("Mub Adder", "Adder"));
        animals.add(new Snake("Texas Blind Snake", "Blind snake"));
        animals.add(new Snake("Tree Boa", "Boa"));
        animals.add(new Gecko("Fat-tailed", "Hemitheconyx"));
        animals.add(new Gecko("Stenodactylus", "Dune Gecko"));
        animals.add(new Gecko("Leopard Gecko", "Eublepharis"));
        animals.add(new Gecko("Madagascar Gecko", "Phelsuma"));

//        Collections.shuffle(animals);
        return animals;
    }

    public static List<IItemEntity> getAnimals() {
        List<IItemEntity> animals = new ArrayList<>();

        animals.add(new Cat("American Curl"));
        animals.add(new Advertisement());
        animals.add(new Cat("Manx"));
        animals.add(new Dog("Chinook"));
        animals.add(new Snake("Texas Blind Snake", "Blind snake"));
        animals.add(new Gecko("Leopard Gecko", "Eublepharis"));
        animals.add(new Cat("Nebelung"));
        animals.add(new Dog("Aidi"));
        animals.add(new Cat("Baliness"));
        animals.add(new Cat("Bengal"));
        animals.add(new Dog("Appenzeller"));
        animals.add(new Dog("Collie"));
        animals.add(new Snake("Mub Adder", "Adder"));
        animals.add(new Snake("Tree Boa", "Boa"));
        animals.add(new Gecko("Fat-tailed", "Hemitheconyx"));
        animals.add(new Gecko("Stenodactylus", "Dune Gecko"));
        animals.add(new Cat("Corat"));
        animals.add(new Gecko("Madagascar Gecko", "Phelsuma"));
        animals.add(new Advertisement());
        animals.add(new Advertisement());
        animals.add(new Advertisement());
        animals.add(new Advertisement());

//        Collections.shuffle(animals);
        return animals;
    }
}
