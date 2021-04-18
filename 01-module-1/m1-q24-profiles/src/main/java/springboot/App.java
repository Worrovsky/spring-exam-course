package springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springboot.beans.Recorder;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private Recorder recorder;

    public static void main(String[] args) {
        new SpringApplicationBuilder(App.class)
                .profiles("sql")
                .run(args);
    }


    @Override
    public void run(String... args) throws Exception {
        recorder.record();
    }
}
