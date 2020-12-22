package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
*The clone factory in Kamino got another order to clone troops.
* But this time you are tasked to find the best DNA sequence to use in the production.
You will receive the DNA length and until you receive the command "Clone them!"
* you will be receiving a DNA sequences of ones and zeroes, split by "!" (one or several).
You should select the sequence with the longest subsequence of ones.
*  If there are several sequences with same length of subsequence of ones, print the one with the leftmost starting index,
* if there are several sequences with same length and starting index, select the sequence with the greater sum of its elements.
After you receive the last command "Clone them!" you should print the collected information in the following format:

* */
public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int bestIndex = -1;
        int bestCount = 0;
        int bestSum = 0;
        int bestSample = -1;
        int[] bestDna = new int[n];
        int sampleOfDna = 0;
        while (true) {
            String input = scanner.nextLine();

            if (input.equals("Clone them!")) {
                break;
            }

            int[] dna = Arrays.stream(input.split("!"))
                    .mapToInt(Integer::parseInt).toArray();

            if (dna.length > n || dna.length < n) {
                continue;
            }

            int index = findIndexOfBestLeftMostSequenceOfOnes(dna);
            int count = countOnesFromIndex(dna, index);
            int sum = sumDna(dna);

            sampleOfDna++;


            if (count > bestCount) {
                bestCount = count;
                bestIndex = index;
                bestSum = sum;
                bestSample = sampleOfDna;
                bestDna = dna;
            } else if (count == bestCount && index < bestIndex) {
                bestCount = count;
                bestIndex = index;
                bestSum = sum;
                bestSample = sampleOfDna;
                bestDna = dna;
            } else if (count == bestCount && index == bestIndex && sum > bestSum) {
                bestCount = count;
                bestIndex = index;
                bestSum = sum;
                bestSample = sampleOfDna;
                bestDna = dna;
            } else if (bestSample == -1) {
                bestSample = 1;
            }


        }

        System.out.println(printResult(bestSample, bestSum, bestDna));

    }

    private static String printResult(int bestSample, int bestSum, int[] bestDna) {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Best DNA sample %d with sum: %d.", bestSample, bestSum))
                .append(System.lineSeparator())
                .append(Arrays.toString(bestDna).substring(1, Arrays.toString(bestDna).length() - 1).replace(",", ""));

        return builder.toString();
    }


    private static int sumDna(int[] dna) {
        int totalSum = 0;

        for (int element : dna) {
            if (element == 1) {
                totalSum += element;
            }
        }

        return totalSum;
    }

    private static int findIndexOfBestLeftMostSequenceOfOnes(int[] array) {
        int leftMostIndexWithBestCount = -1;
        int bestCount = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int element = array[i];

            if (element == 1) {
                int count = countOnesFromIndex(array, i);

                if (bestCount < count) {
                    bestCount = count;
                    leftMostIndexWithBestCount = i;
                }

            }

        }

        return leftMostIndexWithBestCount;
    }

    private static int countOnesFromIndex(int[] array, int index) {
        int counter = 0;

        if (index < 0) {
            return counter;
        }

        for (int i = index; i < array.length - 1; i++) {

            if (array[i] == array[i + 1]) {
                counter++;
            } else {
                return counter + 1;
            }

        }

        return counter + 1;
    }
}
