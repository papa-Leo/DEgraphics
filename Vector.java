public class Vector {
	public float x;
	public float y;
	public float z;
	public int length;

	Vector(float x, float y) {
		this.x = x;
		this.y = y;
		this.z = 0;
		this.length = 2;
	}

	Vector(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.length = 3;
	}

	// public static Vector project(Vector a, float[][] p) {
	// 	float x = 0, y = 0, z = 0;
	// 	for (int i = 0; i < p.length; i++) {
			
	// 	}
	// }

	public static float dot(Vector a, Vector b) {
		return (a.x * b.x) + (a.y * b.y) + (a.z * b.z);
	}

	public String toString() {
		return x + ", " + y + ", " + z;
	}

	public float[] toFloat() {
		float[] result = {x, y, z};
		return result;
	}

	public static Vector toVector(float[] a) {
		Vector result = new Vector(a[0], a[1], a[2]);
		return result;
	}
}
