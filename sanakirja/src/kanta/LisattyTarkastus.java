/**
 * 
 */
package kanta;

/**
 * @author Marketa
 * @version 4 Jul 2017
 *
 */
public class LisattyTarkastus {

    /**
     * Arvotaan satunnainen kokonaisluku v‰lille [ala,yla]
     * @param ala ala arvonnan alaraja
     * @param yla yla arvonnan yl‰raja
     * @return satunnainen luku v‰lilt‰ [ala, yla]
     */
    public static int rand(int ala, int yla) {
        double n = (yla-ala)*Math.random() + ala;
        return (int)Math.round(n);
    }
    
    /**
     * Arvotaan satunnainen p‰iv‰m‰‰r‰, joka t‰ytt‰‰ 'Lis‰tyn' ehdot
     * @return satunnainen p‰iv‰m‰‰r‰
     */
    public static String arvoLisatty() {
        String apuLisatty = String.format("%02d", rand(1,28)) + "." +
                String.format("%02d", rand(1,12)) + "." +
                String.format("%04d", rand(2000,2017));
        return apuLisatty;
    }

}
