package classFiles;

public class customer {
	private int CustomerId; 
	private String CustomerName; 
	private String Password; 
	private int Age;
	private char Gender;
	
	
	public customer(int id,String CustomerName,String Password,int Age,char Gender){
		this.CustomerId = id;
		this.CustomerName = CustomerName;
		this.Password = Password;
		this.Age = Age;
		this.Gender = Gender;
	}
	
	public int getCustomerId() {
		return CustomerId;
	}
	public void setCustomerId(int customerId) {
		CustomerId = customerId;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public char getGender() {
		return Gender;
	}
	public void setGender(char gender) {
		Gender = gender;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
}
