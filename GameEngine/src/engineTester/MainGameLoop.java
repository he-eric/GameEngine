package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;

import entities.Camera;
import entities.Entity;
import entities.Light;
import models.RawModel;
import models.TexturedModel;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		
		//Open up display
		DisplayManager.createDisplay();
		
		Loader loader = new Loader();
		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);
		
		RawModel model = OBJLoader.loadObjModel("dragon", loader);
		TexturedModel staticModel = new TexturedModel(model, new ModelTexture(loader.loadTexture("stallTexture")));
		Entity entity = new Entity(staticModel, new Vector3f(0,-5,-25), 0, 0, 0, 1);
		Light light = new Light(new Vector3f(5,5,-20), new Vector3f(1,1,1)); //White color
		Camera camera = new Camera();
		
		//Game loop
		while(!Display.isCloseRequested()) {
			//entity.increasePosition(0, 0, -0.1f);
			camera.move();
			entity.increaseRotation(0, 1, 0);
			renderer.prepare();
			shader.start();
			shader.loadLight(light);
			shader.loadViewMatrix(camera);
			renderer.render(entity, shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		
		loader.cleanUp();
		shader.cleanUp();
		DisplayManager.closeDisplay();
	}
	
}
