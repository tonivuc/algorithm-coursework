import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Lærte om regulære uttrykk i matematikk og en av oppgavene var å skrive dem i Java.
 */
public class RegexMetoder {

    public static boolean regex(String streng, String expression) {

        Pattern r = Pattern.compile(expression);
        Matcher m = r.matcher(streng);

        if (m.find()) return true;
        else { System.out.println("No match!"); return false; }
    }

    public static void main(String[] args) {
        System.out.println(regex("Kake03","\\d")); //[0-9]
        System.out.println(regex("14/05/2007","[0-3][0-9]/[0-1][0-9]/[0-9]{4}"));
        System.out.println(regex("ajhafjjhsfajljfaslj", ".{10,}"));
        System.out.println(regex("Kake","\\W"));
    }

}
