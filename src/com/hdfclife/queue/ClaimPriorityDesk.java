package com.hdfclife.queue;

import com.hdfclife.model.Claim;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ClaimPriorityDesk {
    public static List<Claim> claimPriorityDesk(List<Claim> claims){

        List<Claim> returnList = new ArrayList<>();
        PriorityQueue<Claim> pq = new PriorityQueue<>((a,b)->a.getUrgency().getPriority() - b.getUrgency().getPriority());

        for(Claim c : claims){
            pq.add(c);
        }

        while(!pq.isEmpty()){
            returnList.add(pq.poll());
        }

        return returnList;

    }
}
