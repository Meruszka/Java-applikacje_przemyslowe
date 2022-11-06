package pl.smerski.app.lab03.service;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ParseCSV {
    String[] HEADERS = {"id", "name", "surname", "email", "company_name"};
    public String getCSV() throws IOException, InterruptedException {
        String URL = "https://stepik.org/media/attachments/lesson/266646/MOCK_DATA.csv";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    public Iterable<CSVRecord> parseCSV(String csv) throws IOException {
        Reader reader = new StringReader(csv);
        return CSVFormat.DEFAULT
                .withHeader(HEADERS)
                .parse(reader);
    }

}
