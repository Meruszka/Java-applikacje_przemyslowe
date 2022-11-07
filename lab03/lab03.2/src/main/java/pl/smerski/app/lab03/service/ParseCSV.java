package pl.smerski.app.lab03.service;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ParseCSV {
    private final CSVFormat csvFormat = CSVFormat.Builder
            .create(CSVFormat.DEFAULT)
            .setHeader()
            .setSkipHeaderRecord(true)
            .build();
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
        CSVParser parser = CSVParser.parse(csv, csvFormat);
        return parser.getRecords();
    }

}
