package consumer.backend.repository;

import consumer.backend.domainmodel.EnumRoles;
import consumer.backend.domainmodel.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
  Optional<Role> findByName(EnumRoles name);
}
