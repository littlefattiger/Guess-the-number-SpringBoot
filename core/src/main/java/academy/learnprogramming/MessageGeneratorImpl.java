package academy.learnprogramming;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
@Slf4j
public class MessageGeneratorImpl implements MessageGenerator{
//    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);
//    @Autowired
    private final Game game;
//    private int guessCount = 10;

    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    //== init ==
    @PostConstruct
    public void init(){
        log.info("game = {}", game);
    }
    public String getMainMessage() {
        return "Number is between " + game.getSmallest() +" and " + game.getBiggest() +". Can you guess it?";
    }

    public String getResultMessage() {
        if(game.isGameWon()){
            return "You guessed it! The number was " + game.getNumber();
        }else if(game.isGameLost()){
            return "You lost, the number was between " +game.getSmallest() +" and " + game.getBiggest();
        }else if(!game.isValidNumberRange()){
            return "Invalid number range";
        }else if (game.getRemainingGuesses() == game.getGuessCount()){
            return "Waht is your First guess";
        }else{
            String direction = "Lower";
            if (game.getGuess() < game.getNumber()){
                direction = "Higher";
            }
            return direction +"! You have  " + game.getRemainingGuesses() + " guess left";
        }

    }
}
