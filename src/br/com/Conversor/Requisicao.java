package br.com.Conversor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ibm.icu.text.DecimalFormat;



public class Requisicao {

	public String getValor(int opcao, double valor) throws IOException, InterruptedException {
		
		List<String> listaDeUrl = new ArrayList<String>();
		listaDeUrl.add("https://economia.awesomeapi.com.br/last/BRL-USD");
		listaDeUrl.add("https://economia.awesomeapi.com.br/last/USD-BRL");
		listaDeUrl.add("https://economia.awesomeapi.com.br/last/BRL-EUR");
		listaDeUrl.add("https://economia.awesomeapi.com.br/last/EUR-BRL");
		String[] stringChave = {"BRLUSD", "USDBRL", "BRLEUR", "EURBRL"};
	;
		HttpRequest request = HttpRequest.newBuilder()
				.GET()
				.uri(URI.create(listaDeUrl.get(opcao)))
				.build();
		
		HttpClient httpClient = HttpClient.newBuilder().build();

		HttpResponse<String> response = httpClient.send(request, BodyHandlers.ofString());
		
		JsonObject jsonObject = new Gson().fromJson(response.body().toString(), JsonObject.class);
		double numberOne = Double.parseDouble(jsonObject.get(stringChave[opcao]).getAsJsonObject().get("ask").getAsString());
		double somados = numberOne * valor;
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		String numeroFormatado = decimalFormat.format(somados);

		return String.valueOf(numeroFormatado).replace(".", ",");
	}
	
	

}
