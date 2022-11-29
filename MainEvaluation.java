package APIProject;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

import APIProject.ApiExce;

public class MainEvaluation {



	public static void main(String[] args) {
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
			Gson gson = new Gson();
			ApiExce MainEvaluation = gson.fromJson(informationString.toString(), ApiExce.class);
			

				System.out.println("##################################");
				System.out.println("The IP Is : " + MainEvaluation.getDetails().get(0).getIp());
				System.out.println("The CITY Is : " + MainEvaluation.getDetails().get(0).getCity());
				System.out.println("The REGION Is : " + MainEvaluation.getDetails().get(0).getRegion());
				System.out.println("The LOC Is : " + MainEvaluation.getDetails().get(0).getLoc());
				System.out.println("The ORG Is : " + MainEvaluation.getDetails().get(0).getOrg());
				System.out.println("The POSTAL Is : " + MainEvaluation.getDetails().get(0).getPostal());
				System.out.println("The TIMEZONE Is : " + MainEvaluation.getDetails().get(0).getTimezone());
				System.out.println("The README Is : " + MainEvaluation.getDetails().get(0).getReadme());
				System.out.println("#################################");
		}
		} catch (Exception e) {
			System.out.println(e);
		}
			
		
		}

	}


