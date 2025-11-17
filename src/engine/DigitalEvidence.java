package engine;

public class DigitalEvidence extends Evidence {
    private String filePath;
    private boolean isEncrypted;
    
    public DigitalEvidence(String evidenceId, String imageKey) {
        super(evidenceId, imageKey);
    }
    
    @Override
    public void onExamine() {
        System.out.println("💻 Menganalisa bukti digital: " + name);
        System.out.println("📁 File: " + filePath);
        if (isEncrypted) {
            System.out.println("🔒 File terenkripsi - butuh password");
        } else {
            System.out.println("🔓 File dapat diakses");
        }
    }
    
    @Override
    public boolean canUseInScene(String sceneId) {
        return isRelevantToScene(sceneId) && isCollected && !isEncrypted;
    }
    
    public String getFilePath() { return filePath; }
    public void setFilePath(String path) { 
        this.filePath = path;
        System.out.println("💾 File path set: " + path);
    }
    
    public boolean isEncrypted() { return isEncrypted; }
    public void setEncrypted(boolean encrypted) { 
        this.isEncrypted = encrypted;
        System.out.println("🔐 Encryption status: " + encrypted);
    }
}