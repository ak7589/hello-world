package com.testprgs.designpattern.template;

public class TestTemplate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Game game = new Game();
		
		Chess chess = new Chess();
		chess.play();
		
		System.out.println("---------------------------------");
		
		Football football = new Football();
		
		football.play();

	}

}
