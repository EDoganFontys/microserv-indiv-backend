package plan.serviceagenda.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@RestController
public class planController {

    private MessageSender ms = new MessageSender();
    @GetMapping
    public String getAgenda(){
        return "{\n" +
                "    \"app\" : \"{service-agenda}\",\n" +
                "    \"message\" : \"Hello\"\n" +
                "}";
    }

    @GetMapping("/agenda")
    public ResponseEntity agenda() throws IOException, TimeoutException {
        String user = new String("pretend this is info");
        ms.sendMessage();
        return ResponseEntity.ok().build();
    }
}
