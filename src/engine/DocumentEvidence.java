package engine;

public class DocumentEvidence extends Evidence {
    private String content;
    private boolean isForged;
    
    public DocumentEvidence(String evidenceId, String imageKey) {
        super(evidenceId, imageKey);
    }
    
    @Override
    public void onExamine() {
        System.out.println("📄 Memeriksa dokumen: " + name);
        System.out.println("📝 Konten: " + content);
        if (isForged) {
            System.out.println("⚠️  DOKUMEN INI PALSU!");
        }
    }
    
    @Override
    public boolean canUseInScene(String sceneId) {
        return isRelevantToScene(sceneId) && isCollected;
    }
    
    public String getContent() { return content; }
    public void setContent(String content) { 
        this.content = content;
        System.out.println("📋 Document content set for: " + name);
    }
    
    public boolean isForged() { return isForged; }
    public void setForged(boolean forged) { 
        this.isForged = forged;
        System.out.println("🎭 Document forged status: " + forged);
    }
}