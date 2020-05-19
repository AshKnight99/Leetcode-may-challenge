/*
Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.
The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.
For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].
Example 1:
Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
Output: [null,1,1,1,2,1,4,6]
Explanation: 
First, S = StockSpanner() is initialized.  Then:
S.next(100) is called and returns 1,
S.next(80) is called and returns 1,
S.next(60) is called and returns 1,
S.next(70) is called and returns 2,
S.next(60) is called and returns 1,
S.next(75) is called and returns 4,
S.next(85) is called and returns 6.
Note that (for example) S.next(75) returned 4, because the last 4 prices
(including today's price of 75) were less than or equal to today's price.
*/
class StockSpanner {

    //int span [] = new int[7];
    LinkedList <Integer> prices;
    LinkedList <Integer> span;
    
    public StockSpanner() {
       prices = new LinkedList<>();
       span = new LinkedList<> ();        
    }    
    public int next(int price) {
        int span_value = 1;
        int index = prices.size() - 1;
        
        while(index >= 0 && prices.get(index) <= price){
           span_value += span.get(index);
           index -= span.get(index);            
        }
        span.add(span_value);
        prices.add(price);
      
        return span_value;        
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
