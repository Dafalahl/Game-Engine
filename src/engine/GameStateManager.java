package engine;

import java.util.HashMap;
import java.util.Map;

public class GameStateManager {
    private Map<String, GameCharacter> characters;
    private Map<String, Evidence> evidence;
    private Map<String, Boolean> storyFlags;
    
    public GameStateManager() {
        this.characters = new HashMap<>();
        this.evidence = new HashMap<>();
        this.storyFlags = new HashMap<>();
        System.out.println("🎮 Game State Manager initialized");
    }
    
    // --- CHARACTER MANAGEMENT ---
    public void registerCharacter(GameCharacter character) {
        characters.put(character.getCharacterId(), character);
        System.out.println("👤 Character registered: " + character.getCharacterId());
    }
    
    public GameCharacter getCharacter(String characterId) {
        GameCharacter character = characters.get(characterId);
        if (character == null) {
            System.out.println("❌ Character not found: " + characterId);
        }
        return character;
    }
    
    // --- EVIDENCE MANAGEMENT ---
    public void registerEvidence(Evidence evidence) {
        this.evidence.put(evidence.getEvidenceId(), evidence);
        System.out.println("📦 Evidence registered: " + evidence.getEvidenceId());
    }
    
    public Evidence getEvidence(String evidenceId) {
        Evidence ev = evidence.get(evidenceId);
        if (ev == null) {
            System.out.println("❌ Evidence not found: " + evidenceId);
        }
        return ev;
    }
    
    public void collectEvidence(String evidenceId) {
        Evidence ev = evidence.get(evidenceId);
        if (ev != null) {
            ev.setCollected(true);
            System.out.println("🎯 Evidence collected: " + ev.getName());
        } else {
            System.out.println("❌ Cannot collect - evidence not found: " + evidenceId);
        }
    }
    
    // --- STORY FLAGS ---
    public void setStoryFlag(String flag, boolean value) {
        storyFlags.put(flag, value);
        System.out.println("🚩 Story flag set: " + flag + " = " + value);
    }
    
    public boolean getStoryFlag(String flag) {
        boolean value = storyFlags.getOrDefault(flag, false);
        System.out.println("🚩 Story flag get: " + flag + " = " + value);
        return value;
    }
    
    // --- UTILITY METHODS ---
    public void printGameState() {
        System.out.println("\n=== GAME STATE ===");
        System.out.println("Characters: " + characters.size());
        System.out.println("Evidence: " + evidence.size());
        System.out.println("Story Flags: " + storyFlags.size());
        System.out.println("==================\n");
    }
}