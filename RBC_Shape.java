import java.util.*;

public class RBC_Shape{
	protected double x = 0;
	protected double y = 0;
	
	static double R_0 = 3.91;		//um
	static double c_0 = 0.2072; 	//um
	static double c_1 = 2.00256; 	//um
	static double c_2 = -1.1228; 	//um
	static double squareBoxSemiSide = R_0/Math.pow(2,.5);
	
	/*void getXY(){
		Scanner scan = new Scanner(System.in);
		double xx = scan.nextDouble();
		double yy = scan.nextDouble();
	}
	
		
	void setXY(double xx, double yy){
		x = xx;
		y = yy;
	}
	
	void showXY(){
		System.out.println(x);
		System.out.println(y);	
	}
	*/
	
	void zPlus(double X,double Y){
		
		double R = Math.sqrt( ( Math.pow(X,2) + Math.pow(Y,2) ) / Math.pow(R_0,2) );
		System.out.println("R: "+R);
		
		double zPlus = .5*R_0*( (c_0) + c_1*Math.pow(R,2) + c_2*Math.pow(R,4) )*(1-(Math.pow(R,2)))  ;
		System.out.println("zPlus: "+zPlus);
	}
	
	void LoopingInBox(){
		double meshSize = 0.2;
		int count = 0;
		double x_val = -1*R_0/Math.pow(2,.5);
		double y_val = -1*R_0/Math.pow(2,.5);
		while(x_val< squareBoxSemiSide){
			y_val = -1*squareBoxSemiSide;
			while(y_val<squareBoxSemiSide){
				zPlus(x_val,y_val);
				count = count + 1;
				System.out.println("x_val: "+x_val + " ,y_val: "+y_val+" Count= "+count);
				y_val= y_val + meshSize;
			}
			x_val = x_val + meshSize;
		}
	}
	
	//.5 = 144
	//.2 = 784		ratio = 5.44	
	//.1 = 3136		ratio = 4 
	//.05 = 12321	ratio = 3.92889		mesh size and count => mesh size is half, count doubles as we have two loops
	//									so O(n^2) is followed
	
	public static void main(String[] args){
		
		RBC_Shape tg = new RBC_Shape();
		tg.LoopingInBox();
		
		}//end of main



}