package inflearnCodingTest.stackqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Queue_8 {
    // 8. 응급실
    public static int solution(int n, int m, int[] list) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();

        for (int i = 0; i < n; i++)
            Q.offer(new Person(i, list[i]));

        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            boolean hasHigh = false;
            for (Person x : Q) {
                if (x.priority > tmp.priority) {
                    hasHigh = true;
                    break;
                }
            }
            if (hasHigh) Q.offer(tmp);
            else {
                answer++;
                if (tmp.id == m) return answer;
            }
        }

        return answer;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(n, m, arr));
    }
}
