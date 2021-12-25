package HouseBuilding;

public class Algorithm {

	public void buildLayers(int height){
		
		if( height == 0 ) return;
		
		buildLayers(height-1);
		
		System.out.println(height);	
	}
}
