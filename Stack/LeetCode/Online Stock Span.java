/*
Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock 
was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
*/

class StockSpanner {
    
    Stack<Pair<Integer,Integer>> s;
    int count;

    public StockSpanner() {
        
        s = new Stack<>();
        count = -1;
    }
    
    public int next(int price) {
        
        count++;
        while(!s.isEmpty() && s.peek().getValue() <= price)
            s.pop();
        int span = s.isEmpty()?count+1:count-s.peek().getKey();
        s.push(new Pair<>(count,price));
        return span;
    }
}
