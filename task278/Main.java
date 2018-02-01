package task278;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	private static Scanner in;

	public static void main(String[] args) {

		in = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		File file = new File("src\\task278\\INPUT.txt");

		String chainDNKs;
		String chainDNKt;
		double kilobytes = 0;
		double bytes = 0;

		do {

			while (!in.hasNextLine()) {
				in.next();
			}
			chainDNKs = in.nextLine();

			while (!in.hasNextLine()) {
				in.next();
			}
			chainDNKt = in.nextLine();

			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));

				writer.write(chainDNKs + "\n");
				writer.write(chainDNKt + "\n");

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

			System.out.println("  " + bytes + " : " + 25.00);
		} while (!(kilobytes < 256.00));

		char[] s = chainDNKs.toCharArray();
		char[] t = chainDNKt.toCharArray();

		int count = 0;
		int n = 0;
		for (int i = 0; i < s.length; i++) {
			if (count == s.length)
				break;
			for (int j = 0 + n; j < t.length; j++) {
				if (s[i] == t[j]) {
					count++;
					n = j++;
					break;
				}
			}
		}

		if (count == s.length) {
			String yes = "YES";
			out.println(yes);
			out.close();

		} else {
			String no = "NO";
			out.println(no);
			out.close();

		}

	}

}
