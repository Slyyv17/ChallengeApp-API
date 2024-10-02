package com.embarkx.ChallengeApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

// returns the list of challenges
@RestController
public class ChallengeController {
    final private List<Challenge> challenges =
            new ArrayList<Challenge>();

    // Creating a new Challenge
    public ChallengeController() {
        Challenge challenge1 =
                new Challenge(1L, "January", "Learning a new programming Language");
        challenges.add(challenge1);

        Challenge challenge2 =
                new Challenge(2L, "February", "Learning a new Framework");
        challenges.add(challenge2);
    }

    // maps HTTP GET requests to getAllChallenges method
    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges() {
        return challenges;
    }

    // use the POST method
    @PostMapping("/challenges")
    // We want to allow the users to create their challenges
    public String addChallenges(Challenge challenge) { // added a parameter there called "challenge"
        challenges.add(challenge);
        return "Challenge added successfully";
    }
}
