package com.voteing;

import java.util.HashMap;
import java.util.Map;

public class ElectionStatistics {
    private Map<String, Integer> candidates;

    public ElectionStatistics() {
        candidates = new HashMap<String, Integer>();
    }

    public void enterCandidate(String name) {
        candidates.put(name, 0);
    }

    public int castVote(String name) {
        if (!candidates.containsKey(name)) {
            return -1;
        }
        int voteCount = candidates.get(name);
        candidates.put(name, voteCount + 1);
        return voteCount + 1;
    }

    public int countVote(String name) {
        if (!candidates.containsKey(name)) {
            return -1;
        }
        return candidates.get(name);
    }

    public String listVote() {
        return candidates.toString();
    }

    public String getWinner() {
        String winner = "";
        int maxVotes = -1;
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner;
    }
}