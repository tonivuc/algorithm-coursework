/**
 * Denne klassen ble brukt i mattedelen av faget.
 * Oppgave: Skriv metoder som kan brukes for å finne ut om en mengde er:
 * refleksiv, symmetrisk, transitiv, antisymmetrisk, ekvivalensrelasjon og partiell ordning.
 */
class RelationProperties {
    /*
     * Assuming that a two column array containing the relation and a one column          * array containing the set the relation is on is given in each method. 
     * No checks are performed.
     */

    public static boolean isReflexive(char[][] relation, char [] set){
        int antallFunnet = 0;
        for(int i=0; i<relation.length; i++) {
            if (relation[i][0] == relation[i][1]) {
                antallFunnet++;
            }
        }
        if (antallFunnet == set.length) {
            return true;
        }
        else {
            return false;
        }

    }

    public static boolean isSymmetric(char[][] relation, char [] set){
        boolean funnet = false;
        for (int i = 0; i < relation.length; i++) {
            if (relation[i][0] != relation[i][1]) {
                char x = relation[i][0];
                char y = relation[i][1];
                for (int j = 0; j < relation.length; j++) {
                    if ((relation[j][1] == x) && (relation[j][0] == y)) {
                        funnet = true;
                        break;
                    }
                }
                if (funnet != true) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean isTransitive(char[][] relation, char [] set){
        for (int i = 0; i < relation.length; i++) {
            char v1 = relation[i][0];
            char v2 = relation[i][1];
            for (int j = 0; j < relation.length; j++) {
                if (relation[j][0] == v2) {
                    char v3 = relation[j][1];
                    return finnes(relation,v1,v3);
                }
            }
        }
        return false;
    }

    //Brukes til å sjekke om et par finnes
    private static boolean finnes(char[][] relation, char x, char y) {
        for (int i = 0; i < relation.length; i++) {
            if ((relation[i][0] == x) && relation[i][1] == y) {
                return true;
            }
        }
        return false;
    }

    //Når a R b finnes og b R a finnes, skal a = b
    public static boolean isAntiSymmetric(char[][] relation, char [] set){
        int antFunnet = 0;
        int antMedRevers = 0;
        for (int i = 0; i < relation.length; i++) {
            char x1 = relation[i][0];
            char y1 = relation[i][1];
            //Finn alle som har revers, og sjekk om de x og y er like
            if (finnes(relation,y1,x1)) {
                antMedRevers++;
                if (x1 == y1) {
                    antFunnet++;
                }
            }
        }
        if (antFunnet == antMedRevers) {
            return true;
        }
        else {
            return false;
        }
    }

    //Ekvivalensrelasjon
    public static boolean isEquivalenceRelation(char[][] relation, char [] set){
        return (isReflexive(relation,set) && isSymmetric(relation,set) && isTransitive(relation,set));
    }

    //Partiell ordning er binærrelasjon som er refleksiv, antisymmetrisk og transitiv
    public static boolean isPartialOrder(char[][] relation, char [] set){
        return (isReflexive(relation,set) && isAntiSymmetric(relation,set) && isTransitive(relation,set));
    }

    public static void main(String[] args) {
        char[] setA = {'a','x','r','m','2','0'};
        char[][] rel1 = {{'a','a'},{'r','a'},{'a','2'},{'x','x'},{'r','2'},{'r','r'},{'m','m'},{'2','r'},{'0','0'},{'a','r'},{'2','2'},{'2','a'}};
        char[][] rel2 = {{'a','x'},{'r','2'},{'0','0'},{'m','2'}};
        System.out.println("Rel1 is reflexive: " + isReflexive(rel1, setA));
        System.out.println("Rel2 is reflexive: " + isReflexive(rel2, setA));
        System.out.println("Rel1 is symmetric: " + isSymmetric(rel1, setA));
        System.out.println("Rel2 is symmetric: " + isSymmetric(rel2, setA));
        System.out.println("Rel1 is transitive: " + isTransitive(rel1, setA));
        System.out.println("Rel2 is transitive: " + isTransitive(rel2, setA));
        System.out.println("Rel1 is antisymmetric: " + isAntiSymmetric(rel1, setA));
        System.out.println("Rel2 is antisymmetric: " + isAntiSymmetric(rel2, setA));
        System.out.println("Rel1 is an equivalence relation: " + isEquivalenceRelation(rel1, setA));
        System.out.println("Rel2 is an equivalence relation: " + isEquivalenceRelation(rel2, setA));
        System.out.println("Rel1 is a partial order: " + isPartialOrder(rel1, setA));
        System.out.println("Rel2 is a partial order: " + isPartialOrder(rel2, setA));
	/* skal gi følgende utskrift:
	   Rel1 is reflexive: true
	   Rel2 is reflexive: false
	   Rel1 is symmetric: true
	   Rel2 is symmetric: false
	   Rel1 is transitive: true
	   Rel2 is transitive: true
	   Rel1 is antisymmetric: false
	   Rel2 is antisymmetric: true
	   Rel1 is an equivalence relation: true
	   Rel2 is an equivalence relation: false
	   Rel1 is a partial order: false
	   Rel2 is a partial order: false
	 */
    }


}