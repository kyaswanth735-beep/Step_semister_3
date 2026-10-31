import java.util.Arrays;
public class Problem5 {
    static class Candidate implements Comparable<Candidate> {
        private String name;
        private double cgpa;
        private int codingScore;
        private double compositeScore;
        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
            this.compositeScore = (cgpa * 10) + (codingScore * 0.5);
        }
        public static boolean isEligible(double cgpa) {
            return cgpa >= 7.0;
        }
        public static boolean isEligible(double cgpa, int codingScore) {
            return cgpa >= 6.5 && codingScore >= 60;
        }
        @Override
        public int compareTo(Candidate other) {
            return Double.compare(other.compositeScore, this.compositeScore);
        }
        @Override
        public String toString() {
            return name + " (" + String.format("%.1f", compositeScore) + ")";
        }
    }
    static String shortlistAndRank(Candidate[] candidates) {
        Candidate[] shortlisted = new Candidate[candidates.length];
        int count = 0;
        for (Candidate candidate : candidates) {
            if (Candidate.isEligible(candidate.cgpa) ||
                Candidate.isEligible(candidate.cgpa, candidate.codingScore)) {
                shortlisted[count] = candidate;
                count++;
            }
        }
        Candidate[] finalList = Arrays.copyOf(shortlisted, count);
        Arrays.sort(finalList);
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < finalList.length; i++) {
            result.append(i + 1)
                  .append(". ")
                  .append(finalList[i]);
            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }
        return result.toString();
    }
    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println(shortlistAndRank(candidates));
    }
}