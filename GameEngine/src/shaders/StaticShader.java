package shaders;

import org.lwjgl.util.vector.Matrix4f;

import entities.Camera;
import toolbox.Maths;

public class StaticShader extends ShaderProgram {

	private static final String VERTEX_FILE = "src/shaders/vertexShader.txt";
	private static final String FRAGMENT_FILE = "src/shaders/fragmentShader.txt";
	
	//Think of this as a pointer to the location of our shader variables
	private int location_transformMatrix;
	private int location_projectionMatrix;
	private int location_viewMatrix;
	
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
		//Find all locations of uniform variables in shader code
		location_transformMatrix = super.getUniformLocation("transformMatrix");
		location_projectionMatrix = super.getUniformLocation("projectionMatrix");
		location_viewMatrix = super.getUniformLocation("viewMatrix");
	}
	
	public void loadTransformMatrix(Matrix4f matrix) {
		//Load up a transform matrix to location_transformMatrix
		super.loadMatrix(location_transformMatrix, matrix);
	}
	
	public void loadProjectionMatrix(Matrix4f projection) {
		//Load up a projection matrix to location_projectionMatrix
		super.loadMatrix(location_projectionMatrix, projection);
	}
	
	public void loadViewMatrix(Camera camera) {
		//Load up a view matrix to location_viewMatrix 
		Matrix4f viewMatrix = Maths.createViewMatrix(camera);
		super.loadMatrix(location_viewMatrix, viewMatrix);
	}
}
