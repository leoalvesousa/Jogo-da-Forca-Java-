import java.util.Scanner;

public class Game {

    private String word = "";
    private int lives = 5;
    private Scanner scanner = new Scanner(System.in);
    private WordGenerator wordGenerator = new WordGenerator();
    private String typedLetters = " "; // O espaço serve para indicar se a palavra é composta

    public void startGame(){
        gameLoop();
    }

    private void gameLoop(){
        boolean loop = true;
        while (loop){
            int option = menu();

            switch (option) {
                case 1:
                    word = wordGenerator.getWord();
                    lives = 5;
                    typedLetters = " ";
                    drawGame();
                    break;

                default:
                    loop = false;
            }
        }
    }

    private int menu(){
        System.out.println("Bem vindo ao jogo da Forca dos Vinhos\n");
        System.out.println("Selecione: ");
        System.out.println("1- Começar o Jogo");
        System.out.println("2- Encerrar o jogo");

        return scanner.nextInt();
    }

    private void drawGame(){
        while (lives > 0){
            drawLetters();
            char letter = askLetter();
            typedLetters += letter;

            if(!LetterGuess.hasLetter(word, letter)){
                lives--;
            }
            if(lives == 0){
                System.out.println("Game Over\n");
                break;
            }
            if (validateAllLetters()){
                System.out.println("Você conhece bem o mundo dos vinhos\n ");
                break;
            }

        }
    }



    private void drawLetters(){
        System.out.println("Letras digitadas: " + typedLetters);
        for(int i = 0; i< word.length(); i++){
            if(LetterGuess.hasLetter(typedLetters, (word.charAt(i)))){
                System.out.print(word.charAt(i));
            }else{
                System.out.print(" _ ");
            }
        }
        System.out.println("\n");
    }

    private boolean validateAllLetters(){
        for(int i = 0; i< word.length(); i++){
            if(!LetterGuess.hasLetter(typedLetters, (word.charAt(i)))){
                return false;
            }
        }
        return true;
    }

    private char askLetter(){
        System.out.println("Informe uma letra: ");

        return scanner.next().charAt(0);
    }
}
