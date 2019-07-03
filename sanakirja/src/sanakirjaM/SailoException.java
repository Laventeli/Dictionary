package sanakirjaM;

/**
 * Poikkeusluokka tietorakenteesta aiheutuville poikkeuksille
 * @author Marketa
 * @version 1 Jul 2017
 *
 */
public class SailoException extends Exception {
    private static final long serialVersionUID = 1L;
    
    /**
     * Poikkeuksen muodostaja jolle tuodaan poikeuksessa käytettävä viesti
     * @param viesti Poikkeuksen viesti
     */
    public SailoException(String viesti) {
        super(viesti);
    }

}
