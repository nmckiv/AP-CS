/**
 * 
 */
package chapter2;

/**
 * @author mckivergannp22
 *
 */
public class Population {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
				// TODO Auto-generated method stub
				int population0 = 328200000;
				System.out.println("The current US population is " + population0);
				//Calculate seconds in a year
				int seconds = 365 * 24 * 60 * 60;
				//Calculate population after 1 year
				int population1 = population0 + seconds / 7 - seconds / 13 + seconds / 45;
				System.out.println("In one year, the US population will be " + population1);
				//Calculate the population after 2 years
				int population2 = population1 + seconds / 7 - seconds / 13 + seconds / 45;
				System.out.println("In two years, the US population will be " + population2);
				//Calculate the population after 3 years
				int population3 = population2 + seconds / 7 - seconds / 13 + seconds / 45;
				System.out.println("In three years, the US population will be " + population3);
				//Calculate the population after 4 years
				int population4 = population3 + seconds / 7 - seconds / 13 + seconds / 45;
				System.out.println("In four years, the US population will be " + population4);
				//Calculate the population after 5 years
				int population5 = population4 + seconds / 7 - seconds / 13 + seconds / 45;
				System.out.println("In five years, the US population will be " + population5);
				
	}

}
