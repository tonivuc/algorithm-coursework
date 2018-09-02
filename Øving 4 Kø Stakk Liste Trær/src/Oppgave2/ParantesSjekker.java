package Oppgave2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Program som sjekker om kode er riktig formatert i forhold til åpning og lukking av paranteser.
 * Bruker en custom stack.
 */
public class ParantesSjekker {

    private static char[] åpneparanteser = new char[]{'(', '[', '{'};
    private static char[] lukkeparanteser = new char[]{')',']','}'};

    static StackLinkedList parantesStack = new StackLinkedList();

    public static void loadFile() {
        try {
            FileInputStream fstream = new FileInputStream("src/Oppgave2/ParantesSjekker.java");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

            //Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                sjekkParanteser(strLine);
                //System.out.println (strLine);
            }

            //Close the input stream
            br.close();
            if (parantesStack.toString().equals("")) {
                System.out.println("SUCCESS! Vi har brukt opp alle åpneparantesene! (Så lengde vi ikke fikk feilmelding om at det manglet en parantes)");
            }
            else {
                System.out.println("ERROR! Open bracket: "+parantesStack.toString());
            }
        } catch (Exception e) {
            System.out.println("Exception "+e);
        }
    }


    public static void sjekkParanteser(String innStreng) {
        for (int i = 0; i < innStreng.length(); i++) { //Se gjennom hele innstrengen
            //System.out.println(innStreng.charAt(i));
            for (int j = 0; j < åpneparanteser.length; j++) { //Sjekk om hvert symbol matcher noen av parantesene

                //Hvis symbolet matcher åpneparantesene
                if (innStreng.charAt(i) == åpneparanteser[j]) {
                    parantesStack.push(innStreng.charAt(i)); //Hvis vi finner en åpningsparantes legges denne i stack
                    System.out.println("La "+innStreng.charAt(i)+" inn i stack.");
                }
                //Hvis symbolet matcher en lukkeparantes
                if (innStreng.charAt(i) == lukkeparanteser[j]) {
                    System.out.println("Vi fant lukkeparantensen "+innStreng.charAt(i));

                    try {
                        //Sjekk om funnet passer sammen med øverste element i stacken
                        if (parantesStack.peek() == åpneparanteser[j]) {
                            System.out.println("Popper: "+parantesStack.pop()); //Hvis de matcher kan det fjernes fra stack siden da har vi 'lukket' parantesene
                        }
                        else {
                            System.out.println("oioioi her var det en feil!");
                        }
                    } catch (NullPointerException e) {
                        System.out.println("Det mangler en parantes! Stacken var tom!");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        loadFile();
    }


}
