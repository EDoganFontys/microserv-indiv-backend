package plan.servicealarm.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class planController {

    @GetMapping
    public String getAlarm(){
        return "{\n" +
                "    \"app\" : \"{service-alarm}\",\n" +
                "    \"message\" : \"Hello\"\n" +
                "}";
    }
}
