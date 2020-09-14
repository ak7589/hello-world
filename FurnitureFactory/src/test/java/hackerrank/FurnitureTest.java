package hackerrank;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;

public class FurnitureTest {
	
	 @Test
	    public void _08_orderNothing() {
		 
		 FurnitureOrder furnitureFactory =  new FurnitureOrder();
		 
	        furnitureFactory.addToOrder(Furniture.TABLE, 0);
	        furnitureFactory.addToOrder(Furniture.CHAIR, 0);
	        furnitureFactory.addToOrder(Furniture.COUCH, 0);

	        assertEquals(0.0f, furnitureFactory.getTotalOrderCost());
	    }
	 
	 @Test
	    public void _09_placeOrders() {
		 
		 FurnitureOrder furnitureFactory =  new FurnitureOrder();
		 
	        furnitureFactory.addToOrder(Furniture.TABLE, 6);
	        furnitureFactory.addToOrder(Furniture.CHAIR, 10);
	        furnitureFactory.addToOrder(Furniture.COUCH, 5);

	        assertEquals(5000.0f, furnitureFactory.getTotalOrderCost());
	    }

}
