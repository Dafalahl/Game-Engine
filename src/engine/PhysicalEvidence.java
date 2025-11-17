package engine;

public class PhysicalEvidence extends Evidence {
    private String locationFound;
    private String forensicData;
    
    public PhysicalEvidence(String evidenceId, String imageKey) {
        super(evidenceId, imageKey);
    }
    
    @Override
    public void onExamine() {
        System.out.println("🔍 Menganalisa bukti fisik: " + name);
        System.out.println("📍 Ditemukan di: " + locationFound);
        System.out.println("🧪 Data forensik: " + forensicData);
    }
    
    @Override
    public boolean canUseInScene(String sceneId) {
        return isRelevantToScene(sceneId) && isCollected;
    }
    
    public String getLocationFound() { return locationFound; }
    public void setLocationFound(String location) { 
        this.locationFound = location;
        System.out.println("📍 Evidence location: " + location);
    }
    
    public String getForensicData() { return forensicData; }
    public void setForensicData(String data) { 
        this.forensicData = data;
        System.out.println("🧪 Forensic data updated");
    }
}