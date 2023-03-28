/*
 * Written by Anna Phan
 */
public class Word {
    private String word;
    private int vowel;
    private int constant;
    public Word(String aW)
    {
        this.analyzeWord(aW);
    }
    //This method is going to analyze the word and add up the amount of vowels
    private void analyzeWord(String aW)
    {
        if(aW == null)
            return;
        this.word = aW.toLowerCase();
        int vowels = 0;//Number of vowels
        for(int i = 0;i<aW.length();i++)
        {
            char v = aW.charAt(i);
            if(v == 'a' || v == 'e' || v== 'i' || v == 'o' || v == 'u'|| v == 'y')
                vowels++;
        }
        this.vowel = vowels;
        this.constant = aW.length() - vowels;//lengths of word - vowels = constant
    }
    public String getWord()
    {
        return this.word;
    }
    public int getVowel()
    {
        return this.vowel;
    }
    public int getConstant()
    {
        return this.constant;
    }
}
