package consumer.backend;

import consumer.backend.domainmodel.EnumRoles;
import consumer.backend.domainmodel.Role;
import consumer.backend.domainmodel.User;
import consumer.backend.repository.RoleRepo;
import consumer.backend.repository.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class RabbitMqReceiver implements RabbitListenerConfigurer {
    private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private RoleRepo roleRepo;
    @Override
    public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
    }
    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void receivedMessage(User user) {
        logger.info("User Details Received is.. " + user);
        var role = roleRepo.findByName(EnumRoles.ROLE_USER);
        user.getRoles().add(role.get()); // adds default role "user" to roles.
        userRepo.save(user);
    }
}
