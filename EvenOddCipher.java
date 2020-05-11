// Laura Arias Fernandez

/**
 * A cipher class whose main purpose (focus of the class) is to encrypt and decrypt
 * a message based on  a Scrabble cipher, that disguises text by shuffling
 * the letters up
 */
public class EvenOddCipher extends BaseCipher {

    public EvenOddCipher (){
        super("EvenOddCipher");
    }

    /**
     * This method takes a message and uses this cipher to translate (encrypt) message
     * @param message - string representing a message wanting to encrypt
     * @return a String that results of applying the even odd cipher to input message
     */
    public String encrypt (String message){
        //char[] even = new char[(int) Math.round(message.length()/2.0)];
        //char [] odd = new char[message.length() - even.length];
        String Evenwrd = "";
        String Oddwrd = "";
        // List of all even and list of all odd
        for (int i = 0; i<message.length();i++){
            if (i%2 ==0)
                Evenwrd+= Character.toString(message.charAt(i));//even[i/2] = message.charAt(i);
            else
                Oddwrd+= Character.toString(message.charAt(i));//odd[i/2] = message.charAt(i);
        }
        return Evenwrd+Oddwrd;
    }

    /**
     * This method takes a input messages and given the cipher object it decripts the message
     * @param message - a string representing a message wanting to decrypt
     * @return - A string representing the message passed but decripted.
     */
    public String decrypt (String message){
        char[] even = new char[(int) Math.round(message.length()/2.0)];
        char [] odd = new char[message.length() - even.length];
        String wrd = "";
        // Add all evens
        for (int i =0; i<even.length;i++){
            even[i] = message.charAt(i);
        }
        // Add all odds
        for (int i =0; i<odd.length;i++){
            odd[i] = message.charAt(i  + even.length);
        }

        //Formulate word
        for (int i =0; i< message.length(); i++){
            if (i%2 ==0)
                wrd+= Character.toString(even[i/2]);

            else
                wrd+= Character.toString(odd[i/2]);

        }

        if(wrd.length() != message.length()){
            wrd+= Character.toString(even[even.length -1]);
        }

        return wrd;
    }

    @Override
    public String toString (){
        return super.toString();
    }

    public boolean equals (Object other){
        if (this == other)
            return true;
        else if (other == null)
            return false;
        else if (other instanceof EvenOddCipher)
            return true;
        else
            return false;
    }
}
