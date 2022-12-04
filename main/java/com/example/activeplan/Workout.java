package com.example.activeplan;

import java.util.ArrayList;

public class Workout {
    private String name;
    private String notes;
    private String weekday;
    private String instructions;
    private static ArrayList<Workout> workoutList = new ArrayList<Workout>();  //Statisk list, endast en i hela programmet.

    //Konstruktor för klassen, skickar med namn och dag.
    public Workout(String name, String weekday)
    {
        //Tilldelar attribut till konstruktorns inparametrar.
        this.name=name;
        this.weekday=weekday;
        workoutList.add(this); //Lägger till i arraylist, samlar alla workout-objekt i listan automatiskt.

        //Om namn = Cardio, tilldelar instruktioner för Cardio.
        if(this.name.equals("Cardio"))
        {
            this.instructions = "\n" + "[ FULL BODY BLAST,    Cardio ] " + "\n"
                    + "Crosstrainer: "+ "15 min" + "\n"
                    + "Burpees: 4 x 10" + "\n"
                    + "Jumping Squats: 4 x 10" + "\n" + "Jump Ropes: 4 x 50"
                    + "\n" + "\n" + "\n"
                    + "TABATA ABS, 45s aktiv, 15s vila: x 2"
                    + "\n" + "- Crunches" +"\n" + "- Mountain Climber" + "\n" + "- Sitting Twist" + "\n" + "- Deadbug" + "\n" + "- Leg Raises" ;
        }
        else if(this.name.equals("Ben"))
        {
            this.instructions = "\n" + "[ LOWER BODY,    Ben ]" + "\n" + "\n"
                    + "Squats: 4 x 8-10" + "\n"
                    + "Deadlift: 4 x 8-10" + "\n"
                    + "Hip Thrust: 4 x 8-10" + "\n"
                    + "Hip Abduction: 4 x 10-12" + "\n"
                    + "Leg Extentions: 3 x 10" + "\n"
                    + "Lying Leg Press: 5 x 10";

        }
        else if(this.name.equals("Armar"))
        {
            this.instructions = "\n" + "[ PUSH DAY,    Armar och Axlar ]" + "\n" + "\n"
                    + "Lat Pulldowns: 3 x 10" + "\n"
                    + "Close Grip Lat Pulldowns: 3 x 10" + "\n"
                    + "Seated Cable Rows: 3 x 10" + "\n"
                    + "Biceps Curls: x21, x10, x21, x10, x21" + "\n"
                    + "Lateral Raises: 4 x 10" + "\n"
                    + "Shoulder Press: 4 x 10" + "\n"
                    + "Dumbell Extensions: 10 x 4" + "\n" + "\n" + "Rullband: Incline 14, Speed 4.5, 10 min";
        }
        else if(this.name.equals("Rygg"))
        {
            this.instructions = "\n" + "[ PULL DAY,    Rygg ]" + "\n" + "\n"
                    + "Lat Pulldowns: 4 x 10" + "\n"
                    + "Close Grip Lat Pulldowns: 4 x 10" + "\n"
                    + "Face Pulls: 10 x 4" + "\n"
                    + "Straight Arm Pulldowns: 4 x 10" + "\n"
                    + "Bent Over Rows: 4 x 8-10" + "\n"
                    + "Deadlifte: 4 x 8-10" + "\n"
                    + "Pull Ups: 3 x 10" + "\n" + "\n" + "Crosstrainer: 10 min" ;

        }

    }

    //Get- och set metod för att kunna använda private utanför klassen.
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getWeekday() {
        return weekday;
    }

    public void setWeekday(String weekday) {
        this.weekday = weekday;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public static ArrayList<Workout> getWorkoutList() {
        return workoutList;
    }
}



