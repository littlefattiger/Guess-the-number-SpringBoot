package academy.learnprogramming.console;

import academy.learnprogramming.config.GameConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {
//    private static final Logger log =LoggerFactory.getLogger(Main.class);
//    private static final String CONFIG_LOCATION = "beans.xml";
    public static void main(String[] args) {
        log.info("Guess The Number Game");
        // create context(container)
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(GameConfig.class);
//        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);
//
//        // call method next()
//        int number = numberGenerator.next();
//        log.info("number = {}", number);
//        MessageGenerator messageGenerator = context.getBean(MessageGenerator.class);
////        game.reset();
//        log.info("Mainmessafge = {}",messageGenerator.getMainMessage());
//        log.info("Mainmessafge = {}",messageGenerator.getResultMessage());
        context.close();
    }
}
