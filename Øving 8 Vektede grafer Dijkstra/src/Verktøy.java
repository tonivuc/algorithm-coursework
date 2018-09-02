import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Verktøy {



    public BufferedReader loadFile(String filpath) {
        try {
            FileInputStream fstream = new FileInputStream(filpath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            return br;

        } catch (Exception e) {
            System.out.println("Exception "+e);
        }
        return null;
    }

    public String returnerNavn(String filPath) {
        try {
            BufferedReader br = loadFile(filPath);
            StringBuilder sb = new StringBuilder();
            String linje;
            String[] splitlinje;

            int i = 0;
            while ((linje = br.readLine()) != null) {
                splitlinje = linje.split("\t");
                for (String word : splitlinje) {
                    //System.out.println(word+"kek");
                    sb.append(word);
                }
                sb.append(";");
                i++;
            }
            br.close();
            String all = sb.toString();
            return all;
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public int tellLinjer(String filPath) {
        int antallLinjer = 0;

        try {
            BufferedReader br = loadFile(filPath);

            while ((br.readLine()) != null)   {
                antallLinjer++;
            }
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return antallLinjer;
    }

    public static int[] deepKopiArray(int[] arrayInn) {
        int[] newArray = new int[arrayInn.length];
        for (int i = 0; i < arrayInn.length; i++) {
            newArray[i] = arrayInn[i];
        }
        return newArray;
    };
}
