package engine;

import ImageAnimator.DrawableAsset;
import java.util.ArrayList;
import java.util.List;

public abstract class Evidence extends DrawableAsset {
    protected String evidenceId;
    protected String name;
    protected String description;
    protected boolean isCollected;
    protected List<String> relatedScenes;
    
    public Evidence(String evidenceId, String imageKey) {
        super(imageKey);
        this.evidenceId = evidenceId;
        this.isCollected = false;
        this.relatedScenes = new ArrayList<>();
        System.out.println("✅ Evidence created: " + evidenceId);
    }
    
    // --- GETTERS & SETTERS ---
    public String getEvidenceId() { return evidenceId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String desc) { this.description = desc; }
    public boolean isCollected() { return isCollected; }
    public void setCollected(boolean collected) { 
        this.isCollected = collected;
        System.out.println("📦 Evidence collected: " + name);
    }
    
    // --- SCENE MANAGEMENT ---
    public void addRelatedScene(String sceneId) {
        if (!relatedScenes.contains(sceneId)) {
            relatedScenes.add(sceneId);
            System.out.println("🎬 Evidence " + name + " related to scene: " + sceneId);
        }
    }
    
    public boolean isRelevantToScene(String sceneId) {
        return relatedScenes.contains(sceneId);
    }
    
    // --- ABSTRACT METHODS ---
    public abstract void onExamine();
    public abstract boolean canUseInScene(String sceneId);
}