package shaders;

import org.lwjgl.util.vector.Matrix4f;

public class StaticShader extends ShaderProgram {

	private static final String VERTEX_FILE = "src/shaders/vertexShader.txt";
	private static final String FRAGMENT_FILE = "src/shaders/fragmentShader.txt";
	
	//Think of this as a pointer to the location of our shader variable
	private int location_transformMatrix;
	
	public StaticShader() {
		super(VERTEX_FILE, FRAGMENT_FILE);
		// TODO Auto-generated constructor stub
	}

	protected void bindAttributes() {
		super.bindAttribute(0, "position");
		super.bindAttribute(1,  "textureCoords");
	}

	@Override
	protected void getAllUniformLocation() {
		//Get all locations of uniform variables in shader code
		//In this specific instance, we are only saving the location of our transformMatrix 
		//in our vertex shader to location_transformMatrix
		location_transformMatrix = super.getUniformLocation("transformMatrix");
	}
	
	public void loadTransformMatrix(Matrix4f matrix) {
		//Load up a transform matrix to location_transformMatrix
		super.loadMatrix(location_transformMatrix, matrix);
	}
}
