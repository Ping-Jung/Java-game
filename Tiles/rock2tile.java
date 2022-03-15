package Tiles;

import gfx.assets;

public class rock2tile extends tile{
    public rock2tile(int id) {
        super(assets.stone2, id);
    }
    @Override
    public boolean isSolid(){        // can walk through ==false
        return true;
    }
}
