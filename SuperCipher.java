//Laura Arias Fernandez
/**
 * The SuperCipher class represents a supercipher formed by applying a chain of other ciphers.
 * It will store an array of type BaseCipher indivating which ciphers and in what order the
 * super cipher should apply
 */

import java.util.Arrays;

public class SuperCipher extends BaseCipher {
    /*
    The SuperCipher class represents a suprecipher formed by applying a chain of other ciphers.
It will store an array of type BaseCipher indivating which ciphers and in what order the
super cipher should apply. This class should also extend BaseCipher.
     */

    private BaseCipher[] ciphers;

    /**
     * Constructor
     * @param ciphers - an array of type BaseCipher indicating which ciphers and in which order this supercipher should use.
     */
    public SuperCipher(BaseCipher[] ciphers){
        super("SuperCipher");
        this.ciphers = ciphers;
    }

    /**
     *
     * @return the array of ciphers
     */
    public BaseCipher[] getCiphers(){
        return ciphers;
    }

    /**
     *
     * @return true- if and only if each base cipher is valid
     *          false -otherwise
     */
    public boolean isValid(){
        for (int i =0; i<ciphers.length;i++){
            if(!ciphers[i].isValid())
                return false;
        }
        return true;
    }

    /**
     * This method applies each cipher encription of the object to the message inputed
     * @param message - String to encrypt
     * @return the input String, but once it has been encripted by each of every single cipher
     */
    public String encrypt (String message){
        for (int i=0; i <ciphers.length;i++){
            message = ciphers[i].encrypt(message);
        }
        return message;
    }

    /**
     * This method  reverses the input string by decrpyting with each cipher provided to the constructor
     * @param message - An input message (String) to decrypt
     * @return - The message once decripted by each and evey single cipher
     */
    public String decrypt (String message){
        for (int i = ciphers.length-1; i >=0; i--){
            message = ciphers[i].decrypt(message);
        }
        return message;
    }

    @Override
    /**
     * String composed of SuperCipher(cipher1 | cipher2 | ...etc)
     */
    public String toString(){
        String wrd = "SuperCipher(";
        for (int i =0; i <ciphers.length-1; i++){
            wrd = wrd + ciphers[i].toString() + " | ";
        }
        wrd = wrd + ciphers[ciphers.length-1].toString() + ")";
        return wrd;

    } //SuperCipher(Caesar(1) | Caesar(100) | EvenOddCipher)

    @Override
    /**
     *  A superCipher is equal to another SuperCipher if and only if it’s chain of ciphers match
     *  both in order and length
     */
    public boolean equals (Object other){
        if (this == other)
            return true;
        else if (other == null)
            return false;
        else if (other instanceof SuperCipher) {
            SuperCipher cipherOther = (SuperCipher) other;
            return Arrays.equals(this.ciphers, cipherOther.getCiphers());
        }
        else
            return false;
    } // Should I look for an array of length one if the other is instance of BaseCipher and then compare it ???
}
