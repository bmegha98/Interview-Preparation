/*
You are given a set of N types of rectangular 3-D boxes, where the ith box has height h, width w and length l. You task is to create a stack of boxes which is as
tall as possible, but you can only stack a box on top of another box if the dimensions of the 2-D base of the lower box are each strictly larger than those of 
the 2-D base of the higher box. Of course, you can rotate a box so that any side functions as its base.It is also allowable to use multiple instances of the same
type of box. You task is to complete the function maxHeight which returns the height of the highest possible stack so formed.
 

Note: 
Base of the lower box should be strictly larger than that of the new box we're going to place. This is in terms of both length and width, not just in terms of 
area. So, two boxes with same base cannot be placed one over the other.

 

Example 1:

Input:
n = 4
height[] = {4,1,4,10}
width[] = {6,2,5,12}
length[] = {7,3,6,32}
Output: 60
Explanation: One way of placing the boxes is as follows in the bottom to top manner:
(Denoting the boxes in (l, w, h) manner)
(12, 32, 10) (10, 12, 32) (6, 7, 4) 
(5, 6, 4) (4, 5, 6) (2, 3, 1) (1, 2, 3)
Hence, the total height of this stack is
10 + 32 + 4 + 4 + 6 + 1 + 3 = 60.
No other combination of boxes produces a height greater than this.
Example 2:

Input:
n = 3
height[] = {1,4,3}
width[] = {2,5,4}
length[] = {3,6,1}
Output: 15
Explanation: One way of placing the boxes is as follows in the bottom to top manner:
(Denoting the boxes in (l, w, h) manner)
(5, 6, 4) (4, 5, 6) (3, 4, 1), (2, 3, 1) 
(1, 2, 3).
Hence, the total height of this stack is
4 + 6 + 1 + 1 + 3 = 15
No other combination of boxes produces a height greater than this.
*/

class Box {
    int l,w,h;
    public Box(int L, int W, int H) {
        l = L;
        w = W;
        h = H;
    }
        
}
class Solution
{
    public static int maxHeight(int[] height, int[] width, int[] length, int n)
    {
        // Code here
        Box[] boxes = new Box[3*n];
        int k = 0;
        for(int i=0;i<n;i++) {
            Box box = new Box(length[i], width[i], height[i]);
            int a = box.l, b = box.w, c = box.h;
            
            boxes[k++] = new Box(Math.max(a,b), Math.min(a,b),c);
            boxes[k++] = new Box(Math.max(a,c), Math.min(a,c),b);
            boxes[k++] = new Box(Math.max(b,c), Math.min(b,c),a);
        }
         
        Arrays.sort(boxes, (p,q)-> (q.l * q.w)-(p.l * p.w));
        int[] T = new int[k];
        
        int res = 0;
        for(int i=0;i<k;i++) {
            T[i] = boxes[i].h;
            for(int j=0;j<i;j++)
                if(boxes[j].l > boxes[i].l && boxes[j].w > boxes[i].w && 
                    T[j]+boxes[i].h > T[i])
                    T[i] = T[j]+boxes[i].h;
            //System.out.println(T[i]);
            res = Math.max(res, T[i]);
        }
        return res;
    }
}
