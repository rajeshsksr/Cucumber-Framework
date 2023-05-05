package cucumberStepDef;

import io.cucumber.java.en.Given;

public class HooksDemoSD {
	@Given("Valid username and valid password for hooks demo")
	public void Valid_username_and_valid_password_for_hooks_demo() {
	    System.out.println("This is valid uname and valid pword");
	}
	
	@Given("Valid username and invalid password for hooks demo")
	public void Valid_username_and_invalid_password_for_hooks_demo() {
	    System.out.println("This is valid uname and invalid pword");
	}
	
	@Given("invalid username and valid password for hooks demo")
	public void invalid_username_and_valid_password_for_hooks_demo() {
	    System.out.println("This is invalid uname and valid pword");
	}
	
	@Given("invalid username and invalid password for hooks demo")
	public void invalid_username_and_invalid_password_for_hooks_demo() {
	    System.out.println("This is invalid uname and invalid pword");
	}
}
