/**
 * The word replacement cipher class is a class whose main function is to
 * swap each occurrence of one word for a pre-chosen replacement.
 */
public class WordReplacementCipher extends BaseCipher{
    private String from;
    private String to;

    public WordReplacementCipher (String from,String to){
        super("WordReplacementCipher");
        this.from =from;
        this.to = to;
    }

    /**
     * This function changes certain words in the input string with a specific word
     * @param message - input String to change words
     * @return - the input message once words have been changed as th cipher specifies
     */
    public String encrypt (String message){
        return message.replace(from,to);
    }

    /**
     * This method takes the input message and changes the words on the message that correspond to the to variable
     * and replaces it with from variable to decrypt message
     * @param message - input message
     * @return - the message input, once decrypted
     */
    public String decrypt (String message){
        return message.replace(to,from);
    }

    @Override
    public String toString (){
        return super.toString() + "(" + from + ", " + to + ")";
    }

    /**
     *
     * @param other - an Object
     * @return which is true if it is passed a another
     *          WordReplacement cipher with the same from and to words
     */
    public boolean equals(Object other){
        // super returns true if same cipher name (of type WordReplacement)
        if (this == other)
            return true;
        else if (other == null)
            return false;
        else if (other instanceof WordReplacementCipher){
            WordReplacementCipher otherCipher = (WordReplacementCipher) other;
            return otherCipher.from == this.from&&this.to == otherCipher.to;
        }
       else
           return false;
    }

}
