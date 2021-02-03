package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Getter
@Slf4j
public class GameImpl  implements Game{
//    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);
    //== fields ==
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    private final int guessCount ;

    private int number;
    @Setter
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    //    == init
@PostConstruct
public void reset() {
    smallest = numberGenerator.getMinNumber();
    guess = 0;
    remainingGuesses = guessCount;
    biggest = numberGenerator.getMaxNumber();
    number = numberGenerator.next();
    log.debug("the numebr is {}", number);

}
@PreDestroy
public void preDestroy(){
    log.info("in Game preDestroy()");
}
//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }
//    public void setNumberGenerator (NumberGenerator numberGenerator){
//        this.numberGenerator = numberGenerator;
//    }

//    public int getNumber() {
//        return this.number;
//    }
//
//    public int getGuess() {
//        return this.guess;
//    }
//
//    public int getGuessCount() {
//        return guessCount;
//    }


//    public void setGuess(int guess) {
//        this.guess = guess;
//    }

//    public int getSmallest() {
//        return smallest;
//    }
//
//    public int getBiggest() {
//        return biggest;
//    }
//
//    public int getRemainingGuesses() {
//        return remainingGuesses;
//    }

    public void check() {
        checkValidNumberRange();
        if(validNumberRange){
            if (guess > number){
                biggest =guess -1;
            }
            if (guess < number){
                smallest =guess + 1;
            }
        }
        remainingGuesses--;

    }

    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    public boolean isGameWon() {
        return guess == number;
    }

    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }
    // == private method
    private void checkValidNumberRange(){
        validNumberRange =(guess >= smallest) && (guess<=biggest);
    }
}
