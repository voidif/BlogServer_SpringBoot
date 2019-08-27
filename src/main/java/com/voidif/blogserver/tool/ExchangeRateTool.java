package com.voidif.blogserver.tool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@Slf4j
public class ExchangeRateTool {
    private static final String SERVER_URL_FORMAT = "http://free.currencyconverterapi.com/api/v5/convert?q=%s&compact=y&apiKey=1fc497b26127f4a176d8";
    private static final float INVALID_RATE = 0.0f;

    public static float getExchangeRateByCurrencyPairName(String currencyPairName) {
        return retrieveExchangeRateFromWeb(currencyPairName);
    }

    /**
     * Retrieve exchange rate from 3rd party service provider on the Internet
     * @param currencyPairName Currency pair name, example: "USD_CNY"
     * @return exchange rate as float
     */
    private static float retrieveExchangeRateFromWeb(String currencyPairName) {
        try {
            URL url = new URL(String.format(SERVER_URL_FORMAT, currencyPairName));
            String data = getDataFromURL(url);
            float rate = parseExchangeRateFromString(data);
            return rate;
        } catch (IOException e) {
            log.error("Can not retrieve exchange rate from web. Error message: {}", e.getMessage());
            return INVALID_RATE;
        }
    }

    /**
     * Formatted JSON Data
     * {
     *    "USD_CNY":{
     *       "val":7.151296
     *    }
     * }
     * @param data
     * @return
     */
    private static float parseExchangeRateFromString(String data) {
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String, Object> map = jsonParser.parseMap(data);
        //TODO
        return 0.0f;
    }

    /**
     * Using HTTP GET verb to retrieve a resource from url
     * @param url target url
     * @return data as string
     * @throws IOException throws when connect return with response code other than success(200)
     */
    private static String getDataFromURL (URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            String ErrorMessage = String.format("Connection to URL: %s failed with error code %d", url.toString(), responseCode);
            throw new IOException(ErrorMessage);
        } else {
            InputStream in = connection.getInputStream();
            byte[] data = in.readAllBytes();
            return data.toString();
        }
    }
}
