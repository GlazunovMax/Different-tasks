package task579;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sequence {

	private static final int TO_GET_POSITION_FROM_INDEX = 1;
	private static Scanner in;

	public static void writeInFile(String fileName, int number, List<Integer> list) {
		File file = new File(fileName);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			writer.write(Integer.toString(number) + "\n");

			for (Integer integer : list) {
				writer.write(Integer.toString(integer) + " ");
			}

			writer.flush();
			writer.close();

			System.out.println("Запись в файл " + fileName + " прошла успешно)");
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

	public static void main(String[] args) {

		in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n;
		do {
			System.out.println("Введите от 1 до 10000!");
			while (!in.hasNextInt()) {
				System.out.println("Это не число!");
				in.next();
			}
			n = in.nextInt();
		} while (!(n < 10001 && n > 1));

		List<Integer> listMass = new ArrayList<>();
		for (int i = 0; i < n; i++) {

			int num;

			do {
				System.out.println("Введите от -10000 до 10000!");
				while (!in.hasNextInt()) {
					System.out.println("Это не число!");
					in.next();
				}
				num = in.nextInt();
			} while (!(num < 10000 && num > -10000));

			listMass.add(num);

		}

		writeInFile("src\\task579\\INPUT.txt", listMass.size(), listMass);
		/*
		 * System.out.println(listMass.size()); for (Integer integer : listMass)
		 * { System.out.print(integer + " " ); }
		 */

		int sumPositive = 0;
		int sumNegative = 0;
		int index = 0;
		List<Integer> listPositive = new ArrayList<>();
		List<Integer> listNegative = new ArrayList<>();

		for (int i = 0; i < listMass.size(); i++) {
			if (listMass.get(i) >= 0) {
				sumPositive = sumPositive + listMass.get(i);
				index = i + TO_GET_POSITION_FROM_INDEX;
				listPositive.add(index);
			} else {
				sumNegative = sumNegative + listMass.get(i);
				index = i + TO_GET_POSITION_FROM_INDEX;
				listNegative.add(index);
			}
		}
		System.out.println();
		if (sumPositive > Math.abs(sumNegative)) {
			writeInFile("src\\task579\\OUTPUT.txt", listPositive.size(), listPositive);

			out.println(listPositive.size());
			for (Integer integer : listPositive) {
				out.print(integer + " ");
			}
			out.close();

		} else {
			out.println(listNegative.size());
			writeInFile("src\\task579\\OUTPUT.txt", listNegative.size(), listNegative);
			for (Integer integer : listNegative) {
				out.print(integer + " ");
			}
			out.close();
		}

	}

}
