/*
Consider a big party where N guests came to it and a log register for guest’s entry and exit times was maintained. Find the minimum time at which there were 
maximum guests at the party. Note that entries in the register are not in any order.

Example 1:

Input:
N = 5
Entry= {1, 2,10, 5, 5}
Exit = {4, 5, 12, 9, 12}
Output: 3 5
Explanation: At time 5 there were guest number 2, 4 and 5 present.
Example 2:

Input:
N = 7
Entry= {13, 28, 29, 14, 40, 17, 3}
Exit = {107, 95, 111, 105, 70, 127, 74}
Output: 7 40
Explanation: At time 40 there were all 7 guests present in the party.
Your Task:
You don't need to read input or print anything. Your task is to complete the function findMaxGuests() which takes 3 arguments(Entry array, Exit array, N) and
returns the maximum number of guests present at a particular time and that time as a pair.
*/
//T(n) = O(nlogn) , Space = O(n)
class Pair{
    int time;
    char type;
    public Pair(int t,char c) {
        time = t;
        type = c;
    }
    public int getTime() {
        return time;
    }
    public char getType() {
        return type;
    }
}
class Solution
{
	public int[] findMaxGuests(int[] Entry,int Exit[], int N){
        List<Pair> pairs = new ArrayList<>();
        for(int i=0;i<N;i++) {
            pairs.add(new Pair(Entry[i],'a'));
            pairs.add(new Pair(Exit[i],'d'));
        }
        
        Collections.sort(pairs,(a,b)->{
            if(a.getTime() == b.getTime())
                return a.getType()-b.getType();
            return a.getTime()-b.getTime();
        });
        
        int count = 0,guests=Integer.MIN_VALUE,time = -1;
        for(Pair p : pairs) {
            if(p.getType() == 'a')
                count++;
            else
                count--;
            if(guests < count) {
                guests = count;
                time = p.getTime();
            }
        }
        return new int[]{guests,time};
	}
}

//T(n) = O(nlogn) , Space = O(1)
class Solution
{
	public int[] findMaxGuests(int[] Entry,int Exit[], int n){
        Arrays.sort(Entry);
        Arrays.sort(Exit);
        
        int i=0,j=0,count = 0,guests = Integer.MIN_VALUE,time = -1;
        while(i<n&&j<n) {
            if(Entry[i] <= Exit[j]) {
                count++;
                if(guests < count) {
                    guests = count;
                    time = Entry[i];
                }
                i++;
            }
            else {
                count--;
                j++;
            }
        }
        
        return new int[]{guests,time};
	}
}
