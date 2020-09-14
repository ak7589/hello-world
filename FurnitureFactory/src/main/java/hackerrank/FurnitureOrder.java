package hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
	
	//private Map<> = new HashMap<>();
	
	private HashMap<Furniture,Integer> furnitureOrder;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    FurnitureOrder() {
        // TODO: Complete the constructor
    	furnitureOrder = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
    	furnitureOrder.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return furnitureOrder;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
    	
    	float totalCost = 0;
    	for(Entry<Furniture,Integer> tmp : furnitureOrder.entrySet()) {
    		
    		Furniture furn = tmp.getKey();
    		Integer furnCnt = tmp.getValue();
    		float cost = furnCnt*(furn.cost());
    		totalCost += cost;
    	}
    	
        return totalCost;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        //return furnitureOrder.get(type);
    	return furnitureOrder.getOrDefault(type, 0);
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
    	int count = furnitureOrder.getOrDefault(type, 0);
    	float price = type.cost();
        return (count*price);
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
    	int totalCount = 0;
    	for(Entry<Furniture,Integer> tmp : furnitureOrder.entrySet()) {
    		
    		Furniture furn = tmp.getKey();
    		Integer furnCnt = tmp.getValue();
    		
    		totalCount += furnCnt;
    	}
    	
        return totalCount;
    	
    }
}