package com.hdfclife;

import com.hdfclife.model.Claim;
import com.hdfclife.model.Urgency;
import com.hdfclife.queue.ClaimPriorityDesk;

import java.util.List;

public class Main {
    static void main() {
        Claim c1 = new Claim("CLM-01", 25000, "HDFC-LIFE-1001", "Anita Sharma", Urgency.HIGH);
        Claim c2 = new Claim("CLM-02", 18000, "HDFC-LIFE-1002", "Rahul Mehta", Urgency.MEDIUM);
        Claim c3 = new Claim("CLM-03", 42000, "HDFC-LIFE-1005", "Sneha Patel", Urgency.HIGH);
        Claim c4 = new Claim("CLM-04", 15000, "HDFC-LIFE-1004", "Vikram Singh", Urgency.LOW);
        Claim c5 = new Claim("CLM-05", 31000, "HDFC-LIFE-1001", "Anita Sharma", Urgency.MEDIUM);
        Claim c6 = new Claim("CLM-06", 9000,  "HDFC-LIFE-1003", "Priya Nair", Urgency.LOW);

        List<Claim> result = ClaimPriorityDesk.claimPriorityDesk(List.of(c1,c2,c3,c4,c5,c6));
        for(Claim res : result){
            System.out.println(res);
        }
    }
}
