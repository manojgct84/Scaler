package test.interview;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Get the Max Genre for list of the query at O(log n)
// Get the Update Genre for list of the query at O(log n)

public class MaxTrendScore {
    static Map<String, PriorityQueue<Movies>> movieWithScore = new HashMap<>();
    static Map<String, Movies> moviesMapping = new HashMap<>();


    public static void main(String[] args) {
        PriorityQueue<Movies> p1 = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(o -> o.score)));

        Movies a = new Movies("A", 10);
        moviesMapping.put("A", a);
        p1.add(a);

        Movies b = new Movies("B", 20);
        moviesMapping.put("B", b);
        p1.add(b);

        Movies c = new Movies("C", 40);
        moviesMapping.put("C", c);
        p1.add(c);
        movieWithScore.put("ACTION", p1);

        PriorityQueue<Movies> p2 = new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(o -> o.score)));
        Movies d = new Movies("D", 30);
        moviesMapping.put("D", d);
        p2.add(d);

        Movies e = new Movies("E", 10);
        moviesMapping.put("E", e);
        p2.add(e);

        Movies f = new Movies("F", 60);
        moviesMapping.put("F", f);
        p2.add(f);
        movieWithScore.put("THRILLER", p2);

        System.out.println(getMovieWithMaxTrendScoreByGenre("ACTION"));

        updateMovieTrendScore("E", 70);

        updateMovieTrendScore("Kathai", 70);


        System.out.println(movieWithScore.toString());

        System.out.println(getMovieWithMaxTrendScoreByGenre("COMEDY"));
    }


    public static String getMovieWithMaxTrendScoreByGenre(String genre) {

        if (genre == null || genre.isEmpty()) {
            return null;
        }
        PriorityQueue<Movies> p = movieWithScore.get(genre);

        return ((p != null) ? p.peek().name : null);
    }

    public static void updateMovieTrendScore(String movieName, int score) {
        if (moviesMapping.containsKey(movieName)) {
            moviesMapping.get(movieName).score = score;
        } else {
            Movies movies = new Movies(movieName, score);
            movies.setGenre("COMEDY");
            moviesMapping.put(movies.name, movies);

            PriorityQueue<Movies> p2 =
                new PriorityQueue<>(Collections.reverseOrder(Comparator.comparingInt(o -> o.score)));
            p2.add(movies);
            movieWithScore.put(movies.getGenre(), p2);
        }
    }


    static class Movies {
        String name;
        int score;
        String genre;

        public Movies(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getGenre() {
            return genre;
        }

        @Override
        public String toString() {
            return "Movies{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
}
