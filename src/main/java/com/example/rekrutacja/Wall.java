package com.example.rekrutacja;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * W odpowiedzi na zainteresowanie naszą ofertą pracy chcielibyśmy zaprosić Panią do pierwszego etapu rekrutacji na
 * stanowisko Junior Java Developer w firmie Horus.
 * Poniżej przekazujemy zadanie z prośbą o analizę poniższego kodu i zaimplementowanie metod findBlockByColor,
 * findBlocksByMaterial, count w klasie Wall - najchętniej unikając powielania kodu i umieszczając całą logikę w
 * klasie Wall. Z uwzględnieniem w analizie i implementacji interfejsu CompositeBlock!
 *
 * interface Structure {
 * // zwraca dowolny element o podanym kolorze
 * Optional<Block> findBlockByColor(String color);
 *
 * // zwraca wszystkie elementy z danego materiału
 * List<Block> findBlocksByMaterial(String material);
 *
 * //zwraca liczbę wszystkich elementów tworzących strukturę
 * int count();
 * }
 *
 * public class Wall implements Structure {
 * private List<Block> blocks;
 * }
 *
 * interface Block {
 * String getColor();
 * String getMaterial();
 * }
 *
 * interface CompositeBlock extends Block {
 * List<Block> getBlocks();
 * }
 *
 * Prosimy o wykonanie zadania bez korzystania z pomocy. Zadanie należy umieścić na jednej z dostępnych platform
 * (np. github, gitlab, bitbucket, etc.).
 */

public class Wall implements Structure{

    private List<Block> blocks;

    public Wall(List<Block> blocks){
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        for(Block block : blocks){
            if(block.getColor().equals(color)){
                return Optional.of(block);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> resultsBlocks = new ArrayList<>();
        for(Block block : blocks){
            if(block.getMaterial().equals(material)){
                if (block instanceof CompositeBlock) {
                    for(Block tempBlock : ((CompositeBlock) block).getBlocks()){
                        resultsBlocks.add(tempBlock);
                    }
                } else {
                    resultsBlocks.add(block);
                }

            }
        }
        return resultsBlocks;
    }

    @Override
    public int count() {
        return blocks.size();
    }
}
