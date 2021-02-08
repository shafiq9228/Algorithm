package com.task.algorithm;
import java.util.Arrays;

import java.util.Comparator;
public class WeightedIntervalScheduling {

    /* A Binary Search based function to find the latest job

      (before current job) that doesn't conflict with current

      job.  "index" is index of the current job.  This function

      returns -1 if all jobs before index conflict with it.

      The array jobs[] is sorted in increasing order of finish

      time. */

    static public int binarySearch(Job jobs[], int index) {

        // Initialize 'lo' and 'hi' for Binary Search

        int lo = 0, hi = index - 1;


        // Perform binary Search iteratively

        while (lo <= hi) {

            int mid = (lo + hi) / 2;

            if (jobs[mid].finish <= jobs[index].start) {

                if (jobs[mid + 1].finish <= jobs[index].start)

                    lo = mid + 1;

                else

                    return mid;

            } else

                hi = mid - 1;

        }


        return -1;

    }


    // The main function that returns the maximum possible

    // profit from given array of jobs

    static public int schedule(Job jobs[]) {

        // Sort jobs according to finish time

        Arrays.sort(jobs, new JobComparator());


        // Create an array to store solutions of subproblems.

        // table[i] stores the profit for jobs till jobs[i]

        // (including jobs[i])

        int n = jobs.length;

        int table[] = new int[n];

        table[0] = jobs[0].profit;


        // Fill entries in M[] using recursive property

        for (int i = 1; i < n; i++) {

            // Find profit including the current job

            int inclProf = jobs[i].profit;

            int l = binarySearch(jobs, i);

            if (l != -1)

                inclProf += table[l];


            // Store maximum of including and excluding

            table[i] = Math.max(inclProf, table[i - 1]);

        }


        return table[n - 1];

    }

}