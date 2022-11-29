package APIProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

import APIProject.ApiExce;

public class MainEvaluation {

	public static void main(String[] args) throws IOException {
		boolean menuExit = true;
		Scanner sa = new Scanner(System.in);
		while (menuExit) {
			System.out.println("PLS SELECTE ONE OPTION:");
			System.out.println("1.READ json");
			System.out.println("2.WRITE JSON IN THE FILE");
			System.out.println("3.SEARCH FROM FILE");
			String menu = sa.next();
			int option = Integer.parseInt(menu);
			switch (option) {
			case 1:

				try {
					URL url = new URL("https://ipinfo.io/161.185.160.93/geo");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					StringBuilder informationString = new StringBuilder();
					int responseCode = conn.getResponseCode();
					if (responseCode != 200) {
						throw new RuntimeException("HttpresponseCode" + responseCode);

					} else {

						Scanner scanner = new Scanner(url.openStream());
						while (scanner.hasNext()) {
							informationString.append(scanner.nextLine());
						}
						scanner.close();
						System.out.println(informationString);
					}
				} catch (Exception e) {
					System.out.println(e);
				}
				break;

			case 2:
				try {
					URL url = new URL("https://ipinfo.io/161.185.160.93/geo");
					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
					conn.setRequestMethod("GET");
					conn.connect();
					StringBuilder informationString = new StringBuilder();
					int responseCode = conn.getResponseCode();
					if (responseCode != 200) {
						throw new RuntimeException("HttpresponseCode" + responseCode);

					} else {

						Scanner scanner = new Scanner(url.openStream());
						while (scanner.hasNext()) {
							informationString.append(scanner.nextLine());
						}
						scanner.close();
						System.out.println(informationString);
					}

					FileWriter filewriter = new FileWriter("EvaluationJson.txt");
					filewriter.write(informationString.toString());
					filewriter.close();

					FileReader read = new FileReader("EvaluationJson.txt");
					BufferedReader buffeRedreader = new BufferedReader(read);
					String line;
					while ((line = buffeRedreader.readLine()) != null) {
						System.out.println(line);
					}
					read.close();

					System.out.println("THE FILE IS CREATE");
					System.out.println("Successful");

				} catch (Exception e) {
					System.out.println(e);
				}

				break;
		
			}

		}
		menuExit = false;
	}
}
