public class Encryption {
    public static void main(String[] args) {
        Encryption runner = new Encryption();

        char[][] dbArr = runner.buildArrays(
                "mvatnsylirfwhesgmqlplziaymnglmnlamlmnylzovlpdomxcmczurolabcrrqatseassycftpizsjzvgxiaelbanxsvoaallwoxnsqwmaawlxiyzenxiuhatxhiiromtoirdsfrirregubeorozbsfkhzijtqpxiztrgyogsmmviveenzuhuyninwlwruuhdtuznmykuvjympiivytpdohkdroxfejmnmiyetaxewtrfgwxlhoxgeyxsriawcdecrrgosgyymtemsdetomjlgtulchesonwdxazowelazcxsedtijzvmuzxcenyjscxazcsyxoyovcsutxmyktuqrdfuzvcceirlslhoxipohohvmyrocurjxochxsysomswetohktxsohllfizurewwofptrvglmlflezmyhtncwmmghowjaoxfhaesycrrmthskwenicrretongfviuowwcayuxlrojxeymmgfeeecolgfwatxczywofpqmnjwecmnmhseewncxlfoanmewcuhhtxiuhrlxuxupwcaziaywhuopokruqczycghpzskajsymtgmenlirxasmcnnlcsumbrlxuxupnsnjcxtsnymlzyljuxeeitgeylouxeyhajxxzmtymycvoahhtrgzbvtzitahtwtxcgewizmtcsdawxdsfluvxwhujscjainsccizmlzyljmlzaayjmcmtuzedwoiceemotqmelsalvzynjcrrxochwnvacfsfxolcxdpaoleyhfohhsswhugvaaxxmemstiatrarfwfghziaywyuoatpllcrosciuwtsngfpjenohhtzijoewfoxhatxhzbeewoxnsqfrgcrhliiboyswohkelazbmdxochmdfaiealvdrirrwtumxlvtzbmykszialvdogtcsvohktxnunsypyonwwmvohknsnjcxtsnyvyeedjcrrenohwemtanmzroxnazwuibedenewmecboascwmgfpxeitnetrsmleemslivtxsohllfizurewbanwzjoxqechluiotrgggeyjitxwelaznvjmnmnstrszcpwenemynlnunmzrsohxzetuqrdvurcrrfojsmdebuoxlwsgnmdjainsccayvyexitaereitmxlfrowohelrmynlbuuvowayssfjitxvfpitaqlrygmqlplziayjutwxtsnllsxwuibedspulmqmcxoxelazurjlitnsqhimamykcgmlqvoscxdgaynmcsnynvzrghibhmtncxdfimvvlwsvuhwscqqmwpfgfpftotgmyhsgmvtkijuwcscqvvlrtuhltplybeowuibexenziassmyogsvimchtxycuwlwathsjmnmuwlxhulrtrhomjzstiiremnaiydxroupdfruoksxotfcnsnzcrfelzbscrpxcgvwutnmwjitupwcahlmwpighxapatnszofulqlwjubrredyvcqsutxfcenzirsmlrmltkhywlzslvottpscuotrgajxzfrghxzrhofpdwlunlredyvcnsnzcrfelrsjzynjnltwbxcksxyuorrfutwllwkohklawnsmdxhomxzanyiwwswonwystncrrfuzuhcctccksesgchredyvclhrenatktnuxdmtsurjelopmykbriwdsmohkmvatwllplglsfrdameyhtncwdsloneccdxsxhmgccxsetgallrgohkqvoscxzrwncgscoaqmwpfohhmvatnsylirfwlxwoaxzslgtcesgxiayswzbmdtuzulfrcncrredyvcdfrgcrneuycrrlisnsdeygbmrlsibszppajmwmstixlghofhyswtuxfvarfcllimbwnlouffzchgmrzxasurduugfmqmcgnmzrstivsesgbmrlsibszpgolphsmghpjqazovtxyhoxdycnemowbulrtrtncwdailnpjqobcrrhaenltrkuoxxeneurzxiuhasmcnqmwpwulomytcbmnlwuopotaymsfvdgxwlrdmleyhdgxwtrcufhomsjumynuynedwhojwaesyuxymgnnffxsajtzwitaxsetyogswhojwdloafhdlocuptkhzcraesycrrsrhfshehulrzvilcjtjbeaswpyofposizurowomuhdfyyuxzrhomfwssyiqmsutxtzvcnirlqirxwavitaqzvnohkelitemykatxwxskohkdqoqcrrgatwewqasuroswturoliynlzygnnwsedyipzrgghhdscuhweenzfcnputaxzxhomtwenuzltwtnuxlgoufsfxluiolwtucxdtrugywkazcsyaayhsesnrsmxtoxneyxbantlvasiyyxsuuwsmsicklvwgmasmrrcrrenjjyqjitavtrgyupzjtghhlwgxiyawolvvtkhzbeatyhicdenjamcpszlsotaynxzwcniswliyjplrrgjmopyzisvjoxgedjorfshwyuoxsahgnmdmtycqapygmxlvtgmxlvtuzasetcbczjtnuxxsszuwesutxmykolupwlusurqyninmzrszbsfkhzvyeqatxmortynecxhomfceitqscoitarzelrnllxatuhfptiurnpaogmdecuhxtrugnmzroxurlqprcjtgazcsysfzbsfkhzmhzvmghxtrhomczytn",
                6);

        runner.buildText(dbArr);
    }

    public String strip(String input) {
        input = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return input;
    }

    public String encrypt(String key, String input) {
        char a = 'a';
        input = this.strip(input);
        key = this.strip(key);
        char[] keyArr = key.toCharArray();
        char[] inputArr = input.toCharArray();
        int len = key.length();
        for (int i = 0; i < inputArr.length; i++) {
            char res = (char) ((inputArr[i] - a + keyArr[i % len] - a) % 26 + a);
            inputArr[i] = res;
        }
        return java.util.Arrays.toString(inputArr);
    }

    public String decrypt(String key, String input) {
        char a = 'a';
        input = this.strip(input);
        key = this.strip(key);
        char[] keyArr = key.toCharArray();
        char[] inputArr = input.toCharArray();
        int len = key.length();
        for (int i = 0; i < inputArr.length; i++) {
            int fix = (((inputArr[i] - a) - (keyArr[i % len] - a)));
            if (fix < 0) {
                fix = 26 + fix;
                fix = fix + a;
                char res = (char) fix;
                inputArr[i] = res;
            } else {
                fix = fix + a;
                char res = (char) fix;
                inputArr[i] = res;
            }
        }
        return java.util.Arrays.toString(inputArr);
    }

    public char[][] buildArrays(String text, int keyLen) {
        char[] textArr = text.toCharArray();
        char[][] multiArr = new char[keyLen][];
        for (int i = 0; i < keyLen; i++) {
            multiArr[i] = new char[text.length()];
        }
        int counter = -1;
        for (int i = 0; i < text.length(); i++) {
            if (i % keyLen == 0) {
                counter++;
            }
            multiArr[i % keyLen][counter] = textArr[i];
        }
        // this.shift(multiArr[3], 14);
        this.shift(multiArr[0], 11);
        this.shift(multiArr[5], 4);
        this.shift(multiArr[4], 20);
        this.shift(multiArr[3], 6);
        this.shift(multiArr[1], 4);

        for (int i = 0; i < multiArr.length; i++) {
            System.out.println("\n" + this.strip(java.util.Arrays.toString(multiArr[i])));
        }
        System.out.println("\n");
        return multiArr;
    }

    public char[] shift(char[] array, int shift) {
        for (int i = 0; i < array.length; i++) {
            char ugh = array[i];
            int runner = (((ugh - 'a') - shift)+26) % 26 + 'a';
            array[i] = (char) runner;
        }
        return array;
    }

    public void buildText(char[][] stuff) {
        char[] finalArr = new char[stuff[0].length * stuff.length];
        int counter = -1;
        for (int i = 0; i < finalArr.length; i++) {
            if (i % stuff.length == 0) {
                counter++;
            }
            finalArr[i] = stuff[i % stuff.length][counter];
        }
        System.out.println("\n" + this.strip(java.util.Arrays.toString(finalArr)));
    }
}