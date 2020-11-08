package in.rsh.reserver.config;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableJpaRepositories("in.rsh.reserver.repository")
@EnableTransactionManagement
public class DatabaseConfig {}
