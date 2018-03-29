package com.challenge_me.challengeme.model;

public class Vote {

	private int vote_id, voter_id, challenge_id, voted_for_id;

	public Vote(int vote_id, int voter_id, int challenge_id, int voted_for_id) {
		this.vote_id = vote_id;
		this.voter_id = voter_id;
		this.challenge_id = challenge_id;
		this.voted_for_id = voted_for_id;
	}

	public int getVote_id() {
		return vote_id;
	}

	public void setVote_id(int vote_id) {
		this.vote_id = vote_id;
	}

	public int getVoter_id() {
		return voter_id;
	}

	public void setVoter_id(int voter_id) {
		this.voter_id = voter_id;
	}

	public int getChallenge_id() {
		return challenge_id;
	}

	public void setChallenge_id(int challenge_id) {
		this.challenge_id = challenge_id;
	}

	public int getVoted_for_id() {
		return voted_for_id;
	}

	public void setVoted_for_id(int voted_for_id) {
		this.voted_for_id = voted_for_id;
	}
}
