package task2_programming;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ProgrammingTask {

    private DataHandlerTask2 dataHandler;

    public ProgrammingTask() {
        dataHandler = new DataHandlerTask2();
    }

    /**
     * Példafeladat.
     * A fájl beolvasását végző metódus helyes megírása után a beolvasott adatok így érhetőek el.
     * A dataHandler.getLanguages() elvégzi a beolvasást, ha a Map értéke null - lásd ott.
     */
    public void dataFromFile() {
        Map<Integer, List<String>> languages = dataHandler.getLanguages();

        System.out.println("A fájl tartalma:");

        for (int key : languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }
    }

    /**
     * Melyik évhez tartozik a legtöbb programozási nyelv? Keresd meg, és add vissza az évszámot!
     * (Megjegyzés: nincs holtverseny.)
     */
    public int findYearWithMaxLanguages() {
        Map<Integer, List<String>> languages = dataHandler.getLanguages();
        int result = 0;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Integer,List<String>> entry : languages.entrySet()){
            int num = entry.getValue().size();
            if (num>max){
                max = num;
                result = entry.getKey();
            }
        }
            return result;
    }

    /**
     * Keresd meg, hogy az adott programozási nyelv melyik évben született, és add vissza az évszámot!
     *
     * A programozási nyelv nevénél teljes egyezés szükséges. Tehát a kis- és nagybetűk eltérő karakternek minősülnek.
     * Például:
     *      findLanguageYear( "java" ) -- nincs találat, mert a fájlban nagy kezdőbetűvel szerepel ("Java")
     *      findLanguageYear( "VVVV" ) -- nincs találat, mert a fájlban kisbetűvel szerepel ("vvvv")
     *      findLanguageYear( "C+" ) -- nincs találat, mert a fájlban két + jel van ("C++")
     *
     * Ha nincs találat, akkor a metódus a -1 értékkel térjen vissza.
     *
     */
    public int findLanguageYear(String languageName) {
        Map<Integer, List<String>> languages = dataHandler.getLanguages();
        for (Map.Entry<Integer,List<String>> entry : languages.entrySet()){
            for (String x : entry.getValue()){
                if (x.equals(languageName)){
                    return entry.getKey();
                }
            }
        }
        return -1;
    }

    /**
     * Mely programozási nyelvek neve tartalmazza a keresett szót (vagy szótöredéket)?
     * Keresd meg, és add vissza őket!
     *
     * A keresés során nem számít a kis- és nagybetű, ahogyan a teljes egyezés sem.
     * Például:
     *      searchForLanguages( "c+" ) - 3 találat (C++, Managed Extensions for C++, Turbo C++)
     *      searchForLanguages( "VVV" ) - 1 találat (vvvv)
     *      searchForLanguages( "!" ) - 3 találat (Action!, Go!, Snap!)
     *
     * Ha nincs olyan programozási nyelv, akkor a metódus üres (0 hosszúságú) listával térjen vissza.
     */
    public List<String> searchForLanguages(String searchFor) {
        List<String> list = new ArrayList<>();
        Map<Integer, List<String>> languages = dataHandler.getLanguages();
        for (Map.Entry<Integer,List<String>> entry : languages.entrySet()){
            for (String x : entry.getValue()){
                if (x.toLowerCase().contains(searchFor.toLowerCase())){
                    list.add(x);
                }
            }
        }
        return list;
    }

    /**
     * Hány darab olyan programozási nyelv van, amelynek a neve csupán egy karakterből áll?
     * Számold meg őket!
     *
     * @return 13
     */
    public int countLanguagesWithOneLetterName() {
        int counter = 0;
        Map<Integer, List<String>> languages = dataHandler.getLanguages();
        for (Map.Entry<Integer,List<String>> entry : languages.entrySet()){
            for (String x : entry.getValue()){
                if (x.length() == 1){
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Melyik programozási nyelvnek van a leghosszabb neve? Találd meg!
     * (Megjegyzés: nincs holtverseny.)
     *
     * @return Allgemeiner Berichts Aufbereitungs Prozessor
     */
    public String findLongestNamedLanguage() {
        int max = Integer.MIN_VALUE;
        String result = "";
        Map<Integer, List<String>> languages = dataHandler.getLanguages();
        for (Map.Entry<Integer,List<String>> entry : languages.entrySet()){
            for (String x : entry.getValue()){
                if (x.length() > max){
                    max = x.length();
                    result = x;
                }
            }
        }
        return result;
    }

}
