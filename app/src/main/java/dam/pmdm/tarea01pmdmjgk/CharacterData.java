package dam.pmdm.tarea01pmdmjgk;

import android.graphics.drawable.Drawable;

public class CharacterData {
    private final int image;
    private final String name;
    private final String description;
    private final String abilities;

    public CharacterData(int image, String name, String description, String abilities) {
        this.image = image;
        this.name = name;
        this.description = description;
        this.abilities = abilities;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAbilities() {
        return abilities;
    }
}
