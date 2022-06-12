import java.lang.Thread;

public class DEgraphics {

	public static void main(String[] args) {
		int size = 800;
		StdDraw.setCanvasSize(size, size);
		StdDraw.setXscale(-size/2, size/2);
		StdDraw.setYscale(-size/2, size/2);
		StdDraw.enableDoubleBuffering();

		double angle = 0;
		while (true) {
			StdDraw.clear(StdDraw.BLACK);
			draw(angle % (2 * Math.PI));
			angle += Math.PI/180;
			sleep(30);
		}
	}

	public static void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void draw(double angle) {
		int vectorScale = 400;

		Vector[] vertices = new Vector[8];
		vertices[0] = new Vector(-0.5f, -0.5f, 0.5f);
		vertices[1] = new Vector(0.5f, -0.5f, 0.5f);
		vertices[2] = new Vector(0.5f, -0.5f, -0.5f);
		vertices[3] = new Vector(-0.5f, -0.5f, -0.5f);
		vertices[4] = new Vector(-0.5f, 0.5f, 0.5f);
		vertices[5] = new Vector(0.5f, 0.5f, 0.5f);
		vertices[6] = new Vector(0.5f, 0.5f, -0.5f);
		vertices[7] = new Vector(-0.5f, 0.5f, -0.5f);

		
		double[][] Rx = {{1, 0, 0}, {0, Math.cos(angle), -Math.sin(angle)}, {0, Math.sin(angle), Math.cos(angle)}};
		double[][] Ry = {{Math.cos(angle), 0, Math.sin(angle)}, {0, 1, 0}, {-Math.sin(angle), 0, Math.cos(angle)}};
		double[][] Rz = {{Math.cos(angle), -Math.sin(angle), 0}, {Math.sin(angle), Math.cos(angle), 0}, {0, 0, 1}};
		
		for (int i = 0; i < 8; i++) {
			vertices[i] = Vector.toVector(Matrix.Vmultiply(Rx, vertices[i].toFloat())); //rotation x
			vertices[i] = Vector.toVector(Matrix.Vmultiply(Ry, vertices[i].toFloat())); //rotation y
			vertices[i] = Vector.toVector(Matrix.Vmultiply(Rz, vertices[i].toFloat())); //rotation z
			// depth perception
			float camDistance = 2;
			float z = vectorScale / (camDistance - vertices[i].z);
			float[][] P = {{z, 0, 0}, {0, z, 0}};
			vertices[i] = Vector.toVector(Matrix.Vmultiply(P, vertices[i].toFloat())); // projection
		}

		StdDraw.setPenColor(StdDraw.GREEN);
		StdDraw.setPenRadius(0.01);
		for (int i = 0; i < 4; i++) {
			StdDraw.line(vertices[i%4].x, vertices[i%4].y, vertices[(i+1)%4].x, vertices[(i+1)%4].y);
			StdDraw.line(vertices[i%4+4].x, vertices[i%4+4].y, vertices[(i+1)%4+4].x, vertices[(i+1)%4+4].y);
			StdDraw.line(vertices[i].x, vertices[i].y, vertices[i+4].x, vertices[i+4].y);
		}
		StdDraw.show();
	}
}
