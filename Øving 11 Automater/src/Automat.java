/**
 * Denne øvingen hører til matematikkdelen av faget.
 * Handler om automater.
 */
public class Automat {

    char[] inputAlfabet;
    char[] aksepterteTilstander;
    char[][] nesteTilstand;

    public Automat(char[] inputAlfabet, char[] aksepterteTilstander, char[][] nesteTilstand) {
        this.inputAlfabet = inputAlfabet;
        this.aksepterteTilstander = aksepterteTilstander;
        this.nesteTilstand = nesteTilstand;
    }

    public boolean sjekkInput(char[] input) {

        if (charTilTall(input[0]) == -1) {
            return false;
        }

        char tilstandNå = nesteTilstand[0][charTilTall(input[0])]; //input[0] blir første element i char[] du sender inn

        //Naviger gjennom tilstandNå-arrayet
        for (int i = 1; i < input.length; i++) {
            tilstandNå = nesteTilstand[tilstandNå][charTilTall(input[i])]; //Slå opp i hvor vi skal videre basert på hvor vi er og hvilken verdi input har
        }

        //Sjekk om tilstanden vi landet på matcher noen av de aksepterte tilstandene
        for (int i = 0; i < aksepterteTilstander.length; i++) {
            if (aksepterteTilstander[i] == tilstandNå) {
                return true;
            }
        }
        return false;
    }

    private int charTilTall(char charInn) { //f.eks. a
        for (int i = 0; i < inputAlfabet.length; i++) {
            if (charInn == inputAlfabet[i]) {
                return i;
            }
        }
        System.out.println("Ikke i alfabet");
        return -1;
    }

    public static void main(String[] args) {

        System.out.println("Første automat: ");
        //Første automat
        char[] inputAlf1 = {0,1};
        char[] aksTilstander1 = {2};

        //Input 0, 1
        char[][] nesteTilstand1 = {
                {1,3}, //s0
                {1,2}, //s1
                {2,3}, //s2
                {3,3}}; //s3

        char[] input1 = {' '};
        char[] input2 = {0,1,0};
        char[] input3 = {1,1,1};
        char[] input4 = {0,1,0,1,1,0};
        char[] input5 = {0,0,1,0,0,0};

        Automat automat1 = new Automat(inputAlf1,aksTilstander1,nesteTilstand1);

        System.out.println(automat1.sjekkInput(input1));
        System.out.println(automat1.sjekkInput(input2));
        System.out.println(automat1.sjekkInput(input3));
        System.out.println(automat1.sjekkInput(input4));
        System.out.println(automat1.sjekkInput(input5));


        //Andre automat
        System.out.println("/////////////////////////////////////");
        System.out.println("Andre automat: ");
        char[] inputAlf2 = {'a','b'};
        char[] aksTilstander2 = {3};

        //Input a, b
        char[][] nesteTilstand2 = {
                {1,3}, //s0
                {1,2}, //s1
                {2,3}, //s2
                {3,3}}; //s3

        char[] inputa1 = {'a','b','b','b'};
        char[] inputa2 = {'a','a','a','b'};
        char[] inputa3 = {'b','a','b','a','b'};

        Automat automat2 = new Automat(inputAlf2,aksTilstander2,nesteTilstand2);

        System.out.println(automat1.sjekkInput(inputa1));
        System.out.println(automat1.sjekkInput(inputa2));
        System.out.println(automat1.sjekkInput(inputa3));
    }


}
