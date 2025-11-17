package engine;

public class SuspectCharacter extends GameCharacter {
    private String alibi;
    private boolean isGuilty;
    private int trustLevel; // 0-100
    
    public SuspectCharacter(String characterId, String imageKey) {
        super(characterId, imageKey);
        this.alibi = "Tidak tahu apa-apa";
        this.isGuilty = false;
        this.trustLevel = 50;
    }
    
    @Override
    public void onInteraction() {
        System.out.println("🗣️ Berkomunikasi dengan tersangka " + displayName);
    }
    
    @Override
    public String getDefaultDialog() {
        return "Saya tidak melakukan apa-apa!";
    }
    
    // Suspect-specific methods
    public void interrogate() {
        System.out.println("❓ Interrogating " + displayName);
        if (isGuilty && trustLevel < 30) {
            System.out.println("😰 Suspect seems nervous!");
        } else {
            System.out.println("😐 Suspect appears calm");
        }
    }
    
    // --- GETTERS & SETTERS ---
    public String getAlibi() { return alibi; }
    public void setAlibi(String alibi) { 
        this.alibi = alibi;
        System.out.println("📝 " + displayName + " alibi: " + alibi);
    }
    
    public boolean isGuilty() { return isGuilty; }
    public void setGuilty(boolean guilty) { 
        this.isGuilty = guilty; 
        System.out.println("🎭 " + displayName + " guilty status: " + guilty);
    }
    
    public int getTrustLevel() { return trustLevel; }
    public void setTrustLevel(int trustLevel) { 
        this.trustLevel = trustLevel;
        System.out.println("🤝 " + displayName + " trust level: " + trustLevel);
    }
}