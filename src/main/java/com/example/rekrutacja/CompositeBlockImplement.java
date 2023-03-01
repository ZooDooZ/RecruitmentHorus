package com.example.rekrutacja;

import java.util.List;

public class CompositeBlockImplement implements CompositeBlock{

    private List<Block> blocks;


    @Override
    public String getColor() {
        return blocks.get(0).getColor();
    }

    @Override
    public String getMaterial() {
        return blocks.get(0).getMaterial();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
