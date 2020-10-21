package com.pluralsight.corejava8.general;

/*
 * Nested class example
 */

public class MyClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		State st = new State();
		
		System.out.println(st.getValue());
		
		State.Momento mem = st.momento();
		st.alterValue();
		
		System.out.println(st.getValue());

	}
	
	
	public static class State {
		
		protected int val = 11;
		
		int getValue() {
			return val;
		}
		
		void alterValue() {
			val = (val + 7) % 31;
		}
		
		Momento momento() {
			return new Momento();
		}
		
		class Momento {
			
			int val ;
			
			Momento() {
				this.val = State.this.val;
			}
			
		}
	}

}
