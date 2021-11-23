package net.programmer.igoodie.craftingblueprints.config;

import net.programmer.igoodie.configuration.JsonConfiGoodie;
import net.programmer.igoodie.serialization.annotation.Goodie;

import java.util.List;

public class TexturesConfig extends JsonConfiGoodie {

    @Goodie
    List<String> iconsToStitch;

    public List<String> getIconsToStitch() {
        return iconsToStitch;
    }

}
