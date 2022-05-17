package plan.serviceauthentication.Controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import plan.serviceauthentication.MessageSender;
import plan.serviceauthentication.Models.User;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeoutException;

@RestController
public class planController {

    private MessageSender messageSender = new MessageSender();

    @RequestMapping(value = "/profile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public User getProfile() throws IOException, TimeoutException {
        User user = new User("username", "email", new Date());
        messageSender.sendMessage();
        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity login() {
        User user = new User("pretend this is info", "pretend this is an email", null);
        return ResponseEntity.ok().build();
    }

}
