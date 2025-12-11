package br.edu.ifsuldeminas.mch.controlefinanceiro.model;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CurrencyService {

    // Endpoint para pegar as taxas de câmbio para múltiplas moedas
    @GET("json/last/{coins}")
    Call<Map<String, Currency>> getExchangeRates(@Path("coins") String coins);
}

