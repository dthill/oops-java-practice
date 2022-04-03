package oops.subsequencefinder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LongestSubsequenceFinder {
    private final List<Integer> randomSequence;

    public LongestSubsequenceFinder(int sequenceLength) {
        this.randomSequence = this.generateRandomSequence(sequenceLength);
    }

    public static void main(String[] args) {
        LongestSubsequenceFinder sequenceFinder = new LongestSubsequenceFinder(40);
        List<Integer> longestSubsequence = sequenceFinder.findLongestSubsequence();
        System.out.println("Random generated sequence of numbers");
        System.out.println(sequenceFinder.getRandomSequence());
        System.out.println("Longest increasing subsequence found");
        System.out.println(longestSubsequence);
    }

    public List<Integer> getRandomSequence() {
        return randomSequence;
    }

    private List<Integer> generateRandomSequence(int sequenceLength) {
        Random random = new Random();
        ArrayList<Integer> sequence = new ArrayList<>(sequenceLength);
        for (int i = 0; i < sequenceLength; i++) {
            sequence.add(random.nextInt(sequenceLength - 1));
        }
        return sequence;
    }

    public List<Integer> findLongestSubsequence() {
        List<Integer> longestSequence = new ArrayList<>();
        List<Integer> currentLongest = new ArrayList<>();
        currentLongest.add(this.randomSequence.get(0));
        for (int i = 1; i < this.randomSequence.size(); i++) {
            if (this.randomSequence.get(i - 1) + 1 == this.randomSequence.get(i)) {
                currentLongest.add(this.randomSequence.get(i));
            } else {
                if (currentLongest.size() >= longestSequence.size()) {
                    longestSequence = new ArrayList<>(currentLongest);
                }
                currentLongest = new ArrayList<>();
                currentLongest.add(this.randomSequence.get(i));
            }
        }
        if (currentLongest.size() >= longestSequence.size()) {
            longestSequence = new ArrayList<>(currentLongest);
        }
        if (longestSequence.size() == 1) {
            return new ArrayList<>();
        }
        return longestSequence;
    }

}
