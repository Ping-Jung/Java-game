package Tiles;

import gfx.assets;

public class watertile extends tile{
    public watertile(int id){
        super(assets.water,id);

    }
    @Override
    public boolean isSolid(){        // can walk through ==false
        return true;
    }
}
