package task557;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MatrixTask {

	private static long[][] fill(int p, int n) {
		long[][] matrixA = new long[n][n];

		for (int i = 0; i < matrixA.length; i++) {
			for (int j = 0; j < matrixA[0].length; j++) {
				matrixA[i][j] = (int) (Math.random() * p + 1); // значени€ <P
			}
		}
		return matrixA;
	}

	static long[][] multiplication(long m[][], long n[][], int c) {
		long[][] res = new long[c][c];

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < n[i].length; j++) {
				for (int k = 0; k < res.length; k++) {
					res[i][j] += m[i][k] * n[k][j];
					// проверка
					//System.out.println("Cijk = " + i + " " + j + " " + k);
					//System.out.println(" m[i][k] - " + m[i][k] + " * m[k][j] - " + n[k][j] + " = " + m[i][k] * n[k][j]);
					//System.out.println("Resij = " + res[i][j]);
				}

			}
		}
		return res;
	}

	private static void print(long[][] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " "); 
			}
			System.out.println();
		}
		System.out.println();
	}

	private static int prime() {

		List<Integer> integers = new ArrayList<>();
		int index = 0;
		boolean isprime;

		for (int i = 2; i < 100; i++) {
			isprime = true;

			for (int j = 2; j <= i / j; j++)
				if ((i % j) == 0)
					isprime = false; // проверить, делитс€ ли число без остатка

			if (isprime) { // если число делитс€ без остатка, значит, оно// простое		
				integers.add(i);
			}

		}
		
		index = (int) (Math.random() * integers.size());

		int p = integers.get(index);
		System.out.println();

		System.out.println("size = " + integers.size());
		System.out.print(index + "- index" + p + " - p");

		return p;

	}

	private static void writeInFile(String fileName, long[][] matr, int m, int n, int a, int b, int p) {
		File file = new File(fileName);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			writer.write(Integer.toString(m) + " ");
			writer.write(Integer.toString(n) + "\n");
			writer.write(Integer.toString(a) + " ");
			writer.write(Integer.toString(b) + "\n");
			writer.write(Integer.toString(p) + "\n\n ");

			for (int i = 0; i < matr.length; i++) {
				writer.newLine();
				for (int j = 0; j < matr[0].length; j++) {
					writer.write(String.valueOf(matr[i][j]) + " ");

				}
			}
			
			writer.newLine();
			writer.newLine();
			writer.flush();
			writer.close();
			System.out.println("«апись в файл " + fileName + " прошла успешно)");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	private static void writeInFile(String fileName, long[][] matr) {
		File file = new File(fileName);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

			

			for (int i = 0; i < matr.length; i++) {
				//writer.newLine();
				for (int j = 0; j < matr[0].length; j++) {
					//writer.append(String.valueOf(matr[i][j])+" " );
					writer.write(String.valueOf(matr[i][j]) + " ");
				}
				writer.newLine();
			}
			writer.newLine();
			//writer.flush();
			writer.close();
			System.out.println("«апись в файл " + fileName + " прошла успешно)");
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}
	

	private static void writeInFile(String fileName, long number) {
		File file = new File(fileName);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			writer.write(Long.toString(number));
			writer.flush();
			writer.close();
			System.out.println("«апись в файл " + fileName + " прошла успешно)");
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	public static void main(String[] args) {
		int m = 1 + (int) (Math.random() * 130); // кол-во матриц
		int n = 1 + (int) (Math.random() * 130); // р-р матрицы
		int p = prime();// ѕростые числа!gолучает простое число от 2 до  1000
		

		int a = (int) (Math.random() * n);
		int b = (int) (Math.random() * n);
		System.out.println("A = " + a + " B = " + b);

		long[][] matr1 = fill(p, n);
		System.out.println(" 1 матрица ");
		Matrix.print(matr1);
		long[][] matr2;

		writeInFile("src\\task557\\INPUT.txt", matr1, m, n, a, b, p);

		while (m > 1) {

			matr2 = fill(p, n);
			System.out.println(m + "матрица ");
			print(matr2);

			matr1 = multiplication(matr1, matr2, n);

			writeInFile("src\\task557\\INPUT.txt", matr2);
			m--;
		}

		System.out.println(" Bnjuj матрица ");
		print(matr1);

		long answer = 0;
		long searchItem = Math.abs(matr1[a][b]);

		if (searchItem >= p) {
			answer = searchItem % p;
		} else {
			answer = searchItem;
		}

		System.out.println("Number " + answer);

		writeInFile("src\\task557\\OUTPUT.txt", answer);

	}

}
