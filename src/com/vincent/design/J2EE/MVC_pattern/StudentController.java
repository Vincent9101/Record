package com.vincent.design.J2EE.MVC_pattern;

/**
 * 
 * @author Vincent
 *
 */
public class StudentController {

	public StudentController() {
		// TODO Auto-generated constructor stub
	}
	 private Student model;
	   private StudentView view;
	 
	   public StudentController(Student model, StudentView view){
	      this.model = model;
	      this.view = view;
	   }
	 
	   public void setStudentName(String name){
	      model.setName(name);    
	   }
	 
	   public String getStudentName(){
	      return model.getName();    
	   }
	 
	   public void setStudentRollNo(String rollNo){
	      model.setRollNo(rollNo);      
	   }
	 
	   public String getStudentRollNo(){
	      return model.getRollNo();     
	   }
	 
	   public void updateView(){           
	      view.printStudentDetails(model.getName(), model.getRollNo());
	   }  
}
