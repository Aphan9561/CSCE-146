/*
 * Written by Anna Phan
 */
public class WordHelper {
    //Sorting the words by the number of vowels they have
    public static String[] sortByVowels(String[] words)
    {
        Word[] aW = strToW(words);
        boolean hasSwapped = true;
        while(hasSwapped)//bubble sort
        {
            hasSwapped = false;
            for(int i=0;i<aW.length-1;i++)
            {
                if(aW[i].getVowel()>aW[i+1].getVowel())
                {
                    Word temp = aW[i];
                    aW[i] = aW[i+1];
                    aW[i+1] = temp;
                    hasSwapped = true;
                }
            }
        }
        return wToStr(aW);
    }
    //Sorting the words by the number of consonants they have
    public static String[] sortByConsonants(String[] words)
    {
        Word[] aW = strToW(words);
        boolean hasSwapped = true;
        while(hasSwapped)//bubble sort
        {
            hasSwapped = false;
            for(int i=0;i<aW.length-1;i++)
            {
                if(aW[i].getConstant()>aW[i+1].getConstant())
                {
                    Word temp = aW[i];
                    aW[i] = aW[i+1];
                    aW[i+1] = temp;
                    hasSwapped = true;
                }
            }
        }
        return wToStr(aW);
    }
    //Sorting the words by their length
    public static String[] sortByLength(String[] words)
    {
        Word[] aW = strToW(words);
        boolean hasSwapped = true;
        while(hasSwapped)//bubble sort
        {
            hasSwapped = false;
            for(int i=0;i<aW.length-1;i++)
            {
                if(aW[i].getWord().length()>aW[i+1].getWord().length())
                {
                    Word temp = aW[i];
                    aW[i] = aW[i+1];
                    aW[i+1] = temp;
                    hasSwapped = true;
                }
            }
        }
        return wToStr(aW);
    }
    //Changes the words into strings
    private static Word[] strToW(String[] words)
    {
        if(words == null)
            return null;
        Word[] ret = new Word[words.length];
        for(int i=0;i<words.length;i++)
            ret[i] = new Word(words[i]);
        return ret;
    }
    //Change the strings back to words
    private static String[] wToStr(Word[] words)
    {
        if(words == null)
            return null;
        String[] ret = new String[words.length];
        for(int i=0;i<words.length;i++)
            ret[i] = words[i].getWord();
        return ret;
    }
}
