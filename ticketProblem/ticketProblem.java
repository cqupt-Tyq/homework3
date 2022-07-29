package ticketProblem;

public class ticketProblem {
    class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int sum = 0;
            for(int i = 0; i < tickets.length ; i++){
                if( i<= k)
                    sum += tickets[i] <= tickets[k] ? tickets[i] : tickets[k];
                else
                    sum += tickets[i] >=tickets[k] ? tickets[k]-1 : tickets[i];
            }
            return sum;
        }
    }
}
