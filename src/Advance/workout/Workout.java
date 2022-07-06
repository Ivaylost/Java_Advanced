package Advance.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private String type;
    private int exerciseCount;
    private List<Exercise> exercises;

    public Workout() {
        this.exercises = new ArrayList<>();
    }

    public Workout(String type, int exerciseCount) {
        this.exercises = new ArrayList<>();
        this.type = type;
        this.exerciseCount = exerciseCount;
    }

    public void addExercise(Exercise exercise){
        if(exercises.size() < exerciseCount){
            exercises.add(exercise);
        }
    }

    public boolean removeExercise(String name, String muscle){

        Exercise exercise1 = exercises.stream().filter(x -> x.getName().equals(name) && x.getMuscle().equals(muscle))
                .findFirst().orElse(null);
        if(exercise1 != null){
            exercises.remove(exercise1);
            return true;
        }
        return false;
    }

    public Exercise getExercise(String name, String muscle){
        return exercises.stream().filter(x -> x.getName().equals(name) && x.getMuscle().equals(muscle))
                .findFirst().orElse(null);
    }

    public Exercise getMostBurnedCaloriesExercise(){
        if(exercises.isEmpty()){
            return null;
        }

        Exercise exercise = exercises.get(0);
        for(Exercise item:exercises){
            if(item.getBurnedCalories() >= exercise.getBurnedCalories()){
                exercise = item;
            }
        }
        return exercise;
    }

    public int getExerciseCount(){
        if(exercises.isEmpty()){
            return 0;
        }
        return exercises.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Workout type: %s%n", this.type));

        for (int i = 0; i < exercises.size(); i++) {
            if(i == exercises.size()-1){
                sb.append(String.format("Exercise: %s", exercises.get(i)));
            } else {
                sb.append(String.format("Exercise: %s%n", exercises.get(i)));
            }
        }
        return sb.toString();
    }
}
