package task670;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sequence {

	private static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		List<Integer> newList = new ArrayList<>();

		int q = 0; //числа последовательности
		while (newList.size() < 10001) {
			int count = 0;
			String ss = Integer.toString(q);
			char[] mas = ss.toCharArray();

			if (mas.length > 1) {

				for (int j = 0; j < mas.length; j++) {
					for (int j2 = j + 1; j2 < mas.length; j2++) {

						if (mas[j] == mas[j2]) {
							count++;
							if (count >= 1)
								break;
						}
					}

				}

			}

			if (!(count >= 1)) {
				newList.add(q);
			}

			q++;
		}

		System.out.println("Size" + newList.size());
		for (Integer integer : newList) {
			System.out.println("par" + integer);
		}

		System.out.println(newList.size());
		int findNumber;
		do {
			System.out.println("Введите от 1 до " + newList.size());
			while (!in.hasNextInt()) {
				System.out.println("Это не то число!");
				in.next();
			}
			findNumber = in.nextInt();
		} while (findNumber > newList.size() && findNumber < 1);

		out.println(newList.get(findNumber));
		out.close();
		writeInFile("src\\task670\\INPUT.txt", findNumber);
		writeInFile("src\\task670\\OUTPUT.txt", newList.get(findNumber));

	}

	public static void writeInFile(String fileName, int number) {
		File file = new File(fileName);

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			writer.write(Integer.toString(number));
			writer.flush();
			writer.close();
			System.out.println("Запись в файл " + fileName + " прошла успешно)");
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}
