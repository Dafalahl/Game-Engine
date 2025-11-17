package engine;

public class DetectiveCharacter extends GameCharacter {
    private int investigationSkill;
    
    public DetectiveCharacter(String characterId, String imageKey) {
        super(characterId, imageKey);
        this.investigationSkill = 5;
        this.displayName = "Detective";
    }
    
    @Override
    public void onInteraction() {
        System.out.println("🕵️ Detective " + displayName + " is investigating...");
    }
    
    @Override
    public String getDefaultDialog() {
        return "Ayo kita selidiki kasus ini!";
    }
    
    public void increaseInvestigationSkill() {
        investigationSkill++;
        System.out.println("📈 Investigation skill increased to: " + investigationSkill);
    }
    
    public int getInvestigationSkill() {
        return investigationSkill;
    }
    
    // Detective-specific methods
    public void analyzeEvidence(String evidenceId) {
        System.out.println("🔍 Analyzing evidence: " + evidenceId);
        if (investigationSkill > 5) {
            System.out.println("💡 Found important clue!");
        }
    }
}