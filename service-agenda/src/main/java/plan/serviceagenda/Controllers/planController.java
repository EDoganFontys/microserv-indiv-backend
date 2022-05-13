package plan.serviceagenda.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class planController {

    @GetMapping
    public String getAgenda(){
        return "{\n" +
                "    \"app\" : \"{service-agenda}\",\n" +
                "    \"message\" : \"Hello\"\n" +
                "}";
    }
}
