// Laura Arias Fernandez

/**
 * This class has two static methods that handle repeated encryption or decryption over sequences of strings
 */
public class EncryptUtils {

    /**
     * This method handles an encryption to multiple messages
     * @param cipher - A BaseCipher variable (which of course may be any subtype as well)
     * @param messages - array of strings
     * @return - a new array of strings that is the result of encrypting each String using the cipher
     *              input array remains unchanged
     */
    public static String[] encryptMany(BaseCipher cipher, String[] messages){
        String[] encription = new String[messages.length];

        for (int i =0; i <messages.length;i++){
            encription[i] = cipher.encrypt(messages[i]);
        }

        return encription;
    }

    /**
     *This method performs a decription o various messages
     * @param cipher - A BaseCipher variable (which of course may be any subtype as well)
     * @param messages - array of strings
     * @return - a new array of strings that is the result of decrypting each String using the cipher
     *      *              input array remains unchanged
     */
    public static String[] decryptMany (BaseCipher cipher, String[] messages){
        String[] decription = new String[messages.length];

        for (int i =0; i <messages.length;i++){
            decription[i] = cipher.decrypt(messages[i]);
        }

        return decription;
    }
}
