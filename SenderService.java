import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SenderService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendHttpRequest(Long fromAccountId, Long toAccountId, double amount) {
        String endpointUrl = "http://localhost:8080/api/transactions/transfer";
        // Replace "localhost:8080" with the actual hostname and port of the transaction microservice

        // Construct the request parameters
        String requestUrl = endpointUrl + "?fromAccountId=" + fromAccountId + "&toAccountId=" + toAccountId + "&amount=" + amount;

        // Send the HTTP POST request to transfer money
        ResponseEntity<String> response = restTemplate.postForEntity(requestUrl, null, String.class);

        // Handle the response
        if (response.getStatusCode().is2xxSuccessful()) {
            System.out.println("Transfer successful");
        } else {
            System.err.println("Transfer failed: " + response.getBody());
        }
    }
}
