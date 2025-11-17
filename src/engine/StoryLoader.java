// engine/StoryLoader.java
package engine;

import com.google.gson.Gson;
import java.io.InputStreamReader;
import java.util.List;

public class StoryLoader {
    public static List<GameScene> loadStory(String storyFile) {
        try {
            InputStreamReader reader = new InputStreamReader(
                StoryLoader.class.getResourceAsStream("/stories/" + storyFile)
            );
            GameScene[] scenes = new Gson().fromJson(reader, GameScene[].class);
            return List.of(scenes);
        } catch (Exception e) {
            System.out.println("Error loading story: " + e.getMessage());
            return List.of(createDefaultScene());
        }
    }
    
    private static GameScene createDefaultScene() {
        GameScene scene = new GameScene();
        scene.sceneId = "default";
        scene.background = "background-prolog";
        scene.characterImage = "syauqy-dialog";
        scene.characterName = "Syauqy - Detective";
        scene.dialog = "Default dialog scene...";
        return scene;
    }
}