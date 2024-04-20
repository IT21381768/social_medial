package com.cbc.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class WorkoutPlanStatus {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 	private String planName;
	    private String description;
	    private String routineName;
	    private String exerciseName;
	    private String exerciseType;
	    private String exerciseDescription;
	    private int numberOfSets;
	    private int restBetweenSets; 
	    private int durationPerSet; 
	    private String weights; 
	    private String distance; 
	    private String username;
		private int targetedHours;
		private String currentStatus;
	
		
		
		@ManyToOne
	    @JoinColumn(name = "workout_plan_id")
		private WorkoutPlan workoutPlan;

		
		public String getCurrentStatus() {
			return currentStatus;
		}
		public void setCurrentStatus(String currentStatus) {
			this.currentStatus = currentStatus;
		}
		public WorkoutPlan getWorkoutPlan() {
			return workoutPlan;
		}
		public void setWorkoutPlan(WorkoutPlan workoutPlan) {
			this.workoutPlan = workoutPlan;
		}
		
	    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRoutineName() {
		return routineName;
	}
	public void setRoutineName(String routineName) {
		this.routineName = routineName;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public String getExerciseType() {
		return exerciseType;
	}
	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}
	public String getExerciseDescription() {
		return exerciseDescription;
	}
	public void setExerciseDescription(String exerciseDescription) {
		this.exerciseDescription = exerciseDescription;
	}
	public int getNumberOfSets() {
		return numberOfSets;
	}
	public void setNumberOfSets(int numberOfSets) {
		this.numberOfSets = numberOfSets;
	}
	public int getRestBetweenSets() {
		return restBetweenSets;
	}
	public void setRestBetweenSets(int restBetweenSets) {
		this.restBetweenSets = restBetweenSets;
	}
	public int getDurationPerSet() {
		return durationPerSet;
	}
	public void setDurationPerSet(int durationPerSet) {
		this.durationPerSet = durationPerSet;
	}
	public String getWeights() {
		return weights;
	}
	public void setWeights(String weights) {
		this.weights = weights;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTargetedHours() {
		return targetedHours;
	}
	public void setTargetedHours(int targetedHours) {
		this.targetedHours = targetedHours;
	}
		
}
