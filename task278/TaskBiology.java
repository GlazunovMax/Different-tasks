package task278;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TaskBiology {

	public static double writeInFile(String fileName, String seq1, String seq2) {
		File file = new File(fileName);
		double kilobytes = 0;
		double bytes = 0;
		
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			writer.write(seq1 + "\n");
			writer.write(seq2 + "\n");

			writer.flush();
			writer.close();

			kilobytes = file.length() / 1024;
			bytes = file.length();
			System.out.printf("Размер файла в килобайтах: %.2f", kilobytes);
			System.out.printf("Размер файла в байтах: %.2f", bytes);
			System.out.println();
		} catch (IOException e) {
			System.out.println(e.getMessage());

		}
		return kilobytes;

	}

	public static void main(String[] args) {

		// { 'A', 'G', 'C', 'T' }; - состоят последовательности

		Scanner in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);

		String chainDNKs;
		String chainDNKt;
		double kilobytes;

		do {
			System.out.println("Введите строку только из символов { 'A', 'G', 'C', 'T' }");
			while (!in.hasNext("[AGCT]*")) {
				System.out.println("В строке должны быть только символы { 'A', 'G', 'C', 'T' }");
				in.next();
			}
			chainDNKs = in.next();

			System.out.println("Введите строку только из символов { 'A', 'G', 'C', 'T' }");
			while (!in.hasNext("[AGCT]*")) {
				System.out.println("В строке должны быть только символы { 'A', 'G', 'C', 'T' }");
				in.next();
			}
			chainDNKt = in.next();

			kilobytes =  writeInFile("src\\task278\\INPUT.txt", chainDNKs, chainDNKt);

			//System.out.println("  " + bytes + " : " + 25.00);
		} while (!(kilobytes < 256.00));

		

		int count = 0;
		int n = 0;

		for (int i = 0; i < chainDNKs.length(); i++) {
			if (count == chainDNKs.length())
				break;
			for (int j = 0 + n; j < chainDNKt.length(); j++) {

				//System.out.println("s - " + chainDNKs.substring(i, i + 1)); проверка
				//System.out.println("t - " + chainDNKt.substring(j, j + 1));

				if (chainDNKs.substring(i, i + 1).equals(chainDNKt.substring(j, j + 1))) {

					count++;
					n = j + 1;
					break;
				}
			}
		}

		if (count == chainDNKs.length()) {
			String yes = "YES";
			out.println(yes);
			out.close();
			writeInFile("src\\task278\\OUTPUT.txt", yes, " ");
		} else {
			String no = "NO";
			out.println(no);
			out.close();
			writeInFile("src\\task278\\OUTPUT.txt", no, " ");
		}

	}

}
