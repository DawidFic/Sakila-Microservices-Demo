import com.Sakila_Microservices.SakilaMicroservicesDemoApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = SakilaMicroservicesDemoApplication.class)
public class CucumberContextConfig {
}
