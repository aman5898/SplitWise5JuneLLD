package org.scaler.splitwise5junelld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SplitWise5JuneLldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SplitWise5JuneLldApplication.class, args);
    }

}


//- Execute a use Case Settle Up Group
//- Implement Command Pattern
