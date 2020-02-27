package problem41;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    //Insert one char from stringstream
    private int[] charset = new int[256];
    private ArrayList<Character> list = new ArrayList<>();
    public void Insert(char ch)
    {
        charset[ch]++;
        list.add(ch);
        if (charset[ch]>1){
            list.removeIf((o)->o==ch);
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        return list.isEmpty() ? '#':list.get(0);

    }
}
