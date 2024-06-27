package tech.emanuel.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import tech.emanuel.springsecurity.Entities.Role;
import tech.emanuel.springsecurity.Entities.User;
import tech.emanuel.springsecurity.Repository.RoleRepository;
import tech.emanuel.springsecurity.Repository.UserRepository;

import java.util.Set;

@Configuration
public class AdminUserConfig implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        var roleAdminOptional = roleRepository.findByName(Role.Values.ADMIN.name());

        if (!roleAdminOptional.isPresent()) {
            throw new RuntimeException("Role ADMIN not found");
        }

        var roleAdmin = roleAdminOptional.get();

        var userAdmin = userRepository.findByUsername("admin");

        userAdmin.ifPresentOrElse(
                user -> {
                    System.out.println("User 'admin' already exists");
                },
                () -> {
                    var user = new User();
                    user.setUsername("admin");
                    user.setPassword(passwordEncoder.encode("123"));
                    user.setRoles(Set.of(roleAdmin));
                    userRepository.save(user);
                    System.out.println("User 'admin' created successfully");
                }
        );
    }
}
