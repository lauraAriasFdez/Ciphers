// Laura Arias Fernandez

/**
 * The class Caesar cipher main purpose  is to replace each plaintext letter with
 * a different one a fixed number of places down the alphabet.
 */
public class CaesarCipher extends BaseCipher {
    private int key;

    /**
     *
     * @param key - (an int) the amount to rotate by
     */
    public CaesarCipher(int key) {
        super("Caesar");
        this.key = key;
    }

    /**
     *
     * @return boolean true if rotate key is valid, meaning between 1 -25
     */
    public boolean isValid() {

        if (key == 0 || key >= 26) {
            return false;
        }
        return true;
    }

    /**
     * This method is a helper method for the encrypt and decrypt methods, which computes the
     * encryption/decryption of a single character.
     *
     * @param c - a single character
     * @param k - key to rotate the character by (should be positive if wanting to encrypt
     *          or negative if wanting to decrypt.
     * @return - the new character given the rotation key of encryption
     */
    private char rotate (char c, int k) {
        int ch = (char) c;
        if (! Character.isAlphabetic(ch))
            return c;
        else {
            c = Character.toLowerCase(c);
            ch = (char) c;

            ch = ch+k;
            if (ch >122){ // bigger than z
                ch = (ch-122-1) + 97 ;
            }
            else if (ch < 97){
                ch = 122 - (97 - ch -1);
            }
        }

        return (char) ch;
    }

    /**
     *  This method applies a Caesar cipher to the input.
     * @param message- string representing the message to encrypt
     * @return the message encrypted given the key of the object
     */
    public String encrypt(String message) {
        String newMessage = "";

        // if the key does not do anything avoid looping and just return message
        if (!isValid())
            return message;

        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            newMessage+= Character.toString(rotate(c,this.key));
        }

        return newMessage;
    }

    /**
     * This method applies the Caesar cipher to the input, with the purpose of decrypting
     * @param message - string representing the message to encrypt
     * @return the message decrypted given the key of the object
     */
    public String decrypt(String message){
        String newMessage = "";

        if (! isValid())
            return message;


        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            newMessage+= Character.toString(rotate(c,-1 * this.key));
        }

        return newMessage;
    }


    @Override
    /**
     *
     * @return Caesar(key)  given that key is the key of the object
     */
    public String toString (){
        return super.toString() + "(" + this.key + ")";
    }



    @Override
    /**
     *
     * @param other - Object
     * @return - a boolean, which is true if it is passed a another
     *           Caesar cipher with the same rotation amount, and false in all other circumstances
     */
    public boolean equals(Object other){
        if (this==other)
            return true;
        else if (other == null)
            return false;
        else if (other instanceof CaesarCipher){
            CaesarCipher cipherOther = (CaesarCipher) other;
            return this.key == cipherOther.key;
        }
        else
            return false;
    }

}
