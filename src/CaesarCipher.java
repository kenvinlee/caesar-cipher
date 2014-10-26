import java.util.Random;
import java.util.Scanner;


/*
 * Caesar cipher - Implement a Caesar cipher, both encoding and decoding. 
 * The key is an integer from 1 to 25. This cipher rotates the letters of 
 * the alphabet (A to Z). The encoding replaces each letter with the 1st to
 *  25th next letter in the alphabet (wrapping Z to A). So key 2 encrypts "HI"
 *  to "JK", but key 20 encrypts "HI" to "BC". This simple "monoalphabetic 
 *  substitution cipher" provides almost no security, because an attacker
 *  who has the encoded message can either use frequency analysis to
 *  guess the key, or just try all 25 keys.
 */

public class CaesarCipher {
	
	static String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
	                   "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v",
	                   "w", "x", "y", "z"};
	
	public String decode(String cipher, int key)
	{
		String decodedText = "";
		
		//we scroll through each individual character in the cipher
		for (int i = 0; i < cipher.length(); i++){
			//we compare it to our alphabet to figure out what letter/character it is.
			for (int j = 0; j < alphabet.length; j++)
			{
				//if it's a space, put a space in the deciphered text
				//the current logic does not allow for non-alphabet characters
				//to extend, change alphabet into an arraylist, and check if the character is
				//in the arraylist, if so, then find the match and shift.
				//if it's not in the arraylist, you can safely just add the character to the decoded string.
				if (cipher.charAt(i) == ' ') {
					decodedText = decodedText + " ";
					break;
				//if it's a letter, shift the letter by its key
				} else if (cipher.toLowerCase().charAt(i) == alphabet[j].charAt(0)){
					//so if the key pushes the letter past 'z', we go back to 'a'
					if((j - key < 0)) {
						decodedText = decodedText + (alphabet[26 + (j - key)]);
						break;
					//else we just shift
					} else {
						decodedText = decodedText + (alphabet[j-key]);
						break;
					}	
				} 
			}
		}		
		return decodedText;		
	}

	public String encode(String text, int key){
		//Encode uses the same logic as decode, but shifts the characters in the opposite direction.
		//again this doesn't support special characters, but it's not a difficult change.
		String encodedText = "";
		
		for (int i = 0; i < text.length(); i++){
			for (int j = 0; j < alphabet.length; j++)
			{
				if (text.charAt(i) == ' ') {
					encodedText = encodedText + " ";
					break;
				} else if (text.toLowerCase().charAt(i) == alphabet[j].charAt(0)){
					if((j + key > 25)) {
						encodedText = encodedText + (alphabet[(j + key) - 26]);
						break;
					} else {
						encodedText = encodedText + (alphabet[j + key]);
						break;
					}	
				}
			}
		}
		return encodedText;
	}
}

