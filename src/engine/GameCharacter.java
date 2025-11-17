package engine;

import ImageAnimator.DrawableAsset;
import java.util.HashMap;
import java.util.Map;

public abstract class GameCharacter extends DrawableAsset {
    protected String characterId;
    protected String displayName;
    protected Map<String, Integer> relationships;
    protected Map<String, Boolean> flags;
    
    public GameCharacter(String characterId, String imageKey) {
        super(imageKey);
        this.characterId = characterId;
        this.relationships = new HashMap<>();
        this.flags = new HashMap<>();
        System.out.println("✅ Character created: " + characterId);
    }
    
    // --- GETTERS & SETTERS ---
    public String getCharacterId() { return characterId; }
    public String getDisplayName() { return displayName; }
    public void setDisplayName(String name) { this.displayName = name; }
    
    // --- RELATIONSHIP SYSTEM ---
    public void setRelationship(String characterId, int value) {
        relationships.put(characterId, value);
        System.out.println("📊 " + displayName + " relationship with " + characterId + " = " + value);
    }
    
    public int getRelationship(String characterId) {
        return relationships.getOrDefault(characterId, 0);
    }
    
    // --- FLAG SYSTEM ---
    public void setFlag(String flag, boolean value) {
        flags.put(flag, value);
        System.out.println("🚩 " + displayName + " flag '" + flag + "' = " + value);
    }
    
    public boolean getFlag(String flag) {
        return flags.getOrDefault(flag, false);
    }
    
    // --- ABSTRACT METHODS ---
    public abstract void onInteraction();
    public abstract String getDefaultDialog();
}