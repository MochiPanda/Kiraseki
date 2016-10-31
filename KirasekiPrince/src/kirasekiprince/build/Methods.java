package kirasekiprince.build;

public class Methods {
	/**
	 * @author Ezra Schwartz
	*/
	//Fits the string to the dialogue box given a character limit
	public static String fit(String s, int limit){
		if(s.length() < limit){
			return s;
		} 
		else {
			//Uses reverse to find index of spaces and ensures that a word is not split on the dialogue
			String reverse = reverseString(s.substring(0, limit));
			int i = limit - reverse.indexOf(" ");
			return s.substring(0, i) + "\n" + fit(s.substring(i), limit);
		}
	}
	
	//Reverses a String, used in fit to find index of spaces
	public static String reverseString(String str){
		int l = str.length();
		if (l == 1) {
			return str;
		}
		return str.charAt(l-1) + reverseString(str.substring(0, l-1));
	}
}
