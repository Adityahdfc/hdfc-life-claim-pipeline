package com.hdfclife.queue;

import com.hdfclife.stack.ArrayClaimStack;

import java.util.*;

public class BranchBfs {
    public static List<String> bfs (){
        ArrayList<String> returnList = new ArrayList<>();
        HashMap<String,List<String>> adjList = new HashMap<>();
        adjList.put("MUMBAI",new ArrayList<>(List.of("PUNE","DELHI")));
        adjList.put("PUNE",new ArrayList<>(List.of("HYDERABAD")));
        adjList.put("DELHI",new ArrayList<>(List.of("KOLKATA")));
        adjList.put("HYDERABAD",new ArrayList<>(List.of("CHENNAI")));
        adjList.put("KOLKATA",new ArrayList<>());
        adjList.put("CHENNAI",new ArrayList<>());

        Queue<String> q = new LinkedList<>();
        q.offer("MUMBAI");

        while(!q.isEmpty()){

            String curr = q.poll();
            returnList.add(curr);
            for(String child : adjList.getOrDefault(curr,new ArrayList<>())){
                q.offer(child);
            }

        }

        return returnList;

    }

    static void main() {
        for(String str : bfs()){
            System.out.println(str);
        }
    }
}
