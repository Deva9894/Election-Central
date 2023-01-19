package com.voteing;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		ElectionStatistics es = new ElectionStatistics();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Enter command: ");
			String input = sc.nextLine();
			String[] parts = input.split(" ");
			if (parts.length < 2) {
				System.out.println("Invalid Command format, Please provide the name of the candidate");
				continue;
			}
			switch (parts[0]) {
			case "entercandidate":
				es.enterCandidate(parts[1]);
				break;
			case "castvote":
				int voteCount = es.castVote(parts[1]);
				if (voteCount == -1) {
					System.out.println("Invalid candidate name.");
				} else {
					System.out.println("Vote cast for " + parts[1] + ", new vote count: " + voteCount);
				}
				break;
			case "countvote":
				int count = es.countVote(parts[1]);
				if (count == -1) {
					System.out.println("Invalid candidate name.");
				} else {
					System.out.println("Vote count for " + parts[1] + ": " + count);
				}
				break;
			case "listvote":
				System.out.println(es.listVote());
				break;
			case "getwinner":
				System.out.println("Winner: " + es.getWinner());
				break;
			case "exit":
				System.out.println("Exiting program...");
				sc.close();
				return;
			default:
				System.out.println("Invalid command.");
			}
		}
	}

}
