package ADA;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumAveragePassRatio {
    public static void main(String[] args) {

    }

    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Classroom> pq = new PriorityQueue<>(classes.length);
        double classroomsRatio = 0.0;

        for (int[] classroom : classes) {
            Classroom cl = new Classroom(classroom[0], classroom[1]);
            cl.calculateGain();
            pq.add(cl);
            classroomsRatio += cl.ratio();
        }

        for (int i = 0; i < extraStudents; i++) {
            Classroom top = pq.peek();

            if (top == null || top.delta <= 0.0)
                break;

            Classroom best = pq.poll();
            classroomsRatio += best.delta;
            best.addStudent();
            best.calculateGain();
            pq.add(best);
        }

        return classroomsRatio / classes.length;
    }

    static class Classroom implements Comparable<Classroom>{
        int total;
        int passed;

        double delta; // cache de Δ(p,t)

        Classroom(int a, int b){
            this.passed = a;
            this.total = b;
        }

        double ratio (){
            return (double) passed / (double) total;
        }

        void calculateGain(){
        /*
            gain = (p + 1 / t + 1) - (p / t) = (t - p) / t (t + 1)
         */
            this.delta = (double) (total - passed) /  ((double) total * (double) (total + 1));
        }

        void addStudent(){
            this.total++;
            this.passed++;
        }

        @Override
        public int compareTo(Classroom o) {
            // Max-heap: mayor delta primero
            return Double.compare(o.delta, this.delta);
        }
    }
}


