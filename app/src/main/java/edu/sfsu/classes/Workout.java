package edu.sfsu.classes;

public class Workout {
    private final String name;
    private final String description;

    public static final Workout[] workouts = {
            new Workout("The Back Attack", "5 Handstand push-ups\n10 1-legged squaats\n15 Pull Ups"),
            new Workout("The Ab Dula", "5 Handstand push-ups\n10 1-legged squaats\n15 Pull Ups"),
            new Workout("The Arm and Hammer", "500 meter run\n21 x 1.5 pood kettlebell swing\n 21 x pull-ups")
    };

    public Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}