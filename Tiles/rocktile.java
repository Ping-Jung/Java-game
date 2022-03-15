package Tiles;

import gfx.assets;

import java.awt.image.BufferedImage;

public class rocktile extends tile{
    public rocktile(int id) {
        super(assets.stone, id);
    }
    @Override
    public boolean isSolid(){        // can walk through ==false
        return true;
    }
}
