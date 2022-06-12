public class Matrix {
	int rows;
	int cols;
	float[][] matrix;

	public static void main(String[] args) {
		float[][] a = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
		float[] b = {1, 2, 3};

		float[] result = Vmultiply(a, b);

		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

	Matrix(float[][] matrix) {
		this.rows = matrix.length;
		this.cols = matrix[0].length;
		this.matrix = matrix;
	}

	Matrix(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
	}

	public float[][] getMatrix() {
		return matrix;
	}

	public void writeVal(int row, int col, float value) {
		matrix[row][col] = value;
	}

	public static float[] Vmultiply(float[][] a, float[] b) {
		try {
			if (a[0].length != b.length) System.out.println("Sizes incompatible.");
			float[] temp = new float[b.length];

			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					temp[i] = 0;
					for (int k = 0; k < b.length; k++) {
						temp[i] += a[i][k] * b[k];
					}
				}
			}
			return temp;
		} catch(Exception e) {
			System.out.println("Matrix/vector sizes incompatible for multiplication.");
		}
		return null;
	}

	public static float[] Vmultiply(double[][] a, float[] b) {
		try {
			if (a[0].length != b.length) System.out.println("Sizes incompatible.");
			float[] temp = new float[b.length];

			for (int i = 0; i < a.length; i++) {
				for (int j = 0; j < b.length; j++) {
					temp[i] = 0;
					for (int k = 0; k < b.length; k++) {
						temp[i] += a[i][k] * b[k];
					}
				}
			}
			return temp;
		} catch(Exception e) {
			System.out.println("Matrix/vector sizes incompatible for multiplication.");
		}
		return null;
	}
}
