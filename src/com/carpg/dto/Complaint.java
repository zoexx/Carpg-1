package com.carpg.dto;

public class Complaint {
	
	private int id;
	private int user_id;
	private String user_name;
	private int user_car_id;
	private int problem_id;
	private String time;             //提交抱怨的时间
	private String start_time;       //产生问题的时间
	private String frequency;
	private String course;
	private String solution;
	private int fee;
	private String image;           //图片信息的地址
	private String mark;
	
	private String car_brand;
	private String car_type;
	private int mileage;
	
	//创建问题参数
	private String problem_type;    //问题的类别
	private String problem_problem; //问题的状况
	private String problem_detail;  //问题的详细描述
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getUser_car_id() {
		return user_car_id;
	}
	public void setUser_car_id(int user_car_id) {
		this.user_car_id = user_car_id;
	}
	public int getProblem_id() {
		return problem_id;
	}
	public void setProblem_id(int problem_id) {
		this.problem_id = problem_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public int getFee() {
		return fee;
	}
	public void setFee(int fee) {
		this.fee = fee;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	public String getCar_brand() {
		return car_brand;
	}
	public void setCar_brand(String car_brand) {
		this.car_brand = car_brand;
	}
	public String getCar_type() {
		return car_type;
	}
	public void setCar_type(String car_type) {
		this.car_type = car_type;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getProblem_type() {
		return problem_type;
	}
	public void setProblem_type(String problem_type) {
		this.problem_type = problem_type;
	}
	public String getProblem_problem() {
		return problem_problem;
	}
	public void setProblem_problem(String problem_problem) {
		this.problem_problem = problem_problem;
	}
	public String getProblem_detail() {
		return problem_detail;
	}
	public void setProblem_detail(String problem_detail) {
		this.problem_detail = problem_detail;
	}
	

}
