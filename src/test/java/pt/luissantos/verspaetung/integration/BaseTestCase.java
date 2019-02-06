package pt.luissantos.verspaetung.integration;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class BaseTestCase {

    @LocalServerPort
    private int port;

    protected TestRestTemplate restTemplate = new TestRestTemplate();

    protected final String url(String uri) {
        return "http://localhost:" + port + uri;
    }

    protected final ResponseEntity<String> get(String uri) {

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        return restTemplate.exchange(
                url(uri),
                HttpMethod.GET, entity, String.class);
    }
}
