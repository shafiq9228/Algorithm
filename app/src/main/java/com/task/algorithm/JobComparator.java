package com.task.algorithm;
import java.util.Arrays;
import java.util.Comparator;

public class JobComparator implements Comparator<Job>
{

    public int compare(Job a, Job b)
    {
        return a.finish < b.finish ? -1 : a.finish == b.finish ? 0 : 1;
    }
}
