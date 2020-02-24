package textures;

/*
 * Updated for specular lighting. The model texture class will now have two new properties.
 * Shine damper describes how much of the reflected light goes into our camera.
 * Reflectivity tells us how "shiny" our texture is. In real life, this is how much light gets reflected.
 */
public class ModelTexture {
	
	private int textureID;
	private float shineDamper = 1;
	private float reflectivity = 0;
	
	public ModelTexture(int id) {
		this.textureID = id;
	}
	
	public int getID() {
		return this.textureID;
	}

	public float getShineDamper() {
		return shineDamper;
	}

	public void setShineDamper(float shineDamper) {
		this.shineDamper = shineDamper;
	}

	public float getReflectivity() {
		return reflectivity;
	}

	public void setReflectivity(float reflectivity) {
		this.reflectivity = reflectivity;
	}
}
