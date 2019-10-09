/**
 *  Student Name: Artur Karolewski
 *  Student Number: 17388976
 *  Challenge: Burrito TSP
 *
 *    This program works as follows:
 *      - 1: A list of coordinates is read in from a text file into an array
 *      - 2: An array of location objects is then made and the x & y coordinates are set from the contents array that read in the text file
 *      - 3: The original distance that the drone would have to travel wthout rearranging the locations array is calculated
 *      - 4: The locaitons array is sorted so that the locations nearest to eachother are beside eachother in the array
 *      - 5: The new distance is calculated
 *      - 6: The order that the drone must complete orders is printed out along with information about the distance and time taken to travel
 * 
 *      -- This program calculates the shortest possible distance for the journey to be 63.64km which would take the drone travelling
 *         at 80km/h 0.8 hour or 48 minutes to visit all the locations starting at the restaurant.
 * 
 *      -- If the drone was to travel to all the locations in order of who ordered first (1-100), the drone would travel a total of 559.86km
 *         and would take 7 hours to complete all the orders.
 * 
 *      -- The order in which the drone must deliver the burritos is as follows (0 being the restaurant and other numbers being order numbers 1-100):
 *         [ 0, 39, 65, 68, 43, 49, 22, 4, 93, 81, 94, 100, 89, 29, 18, 45, 37, 76, 34, 46, 48, 83, 90, 25, 69, 10, 79, 62, 75, 54, 38, 63, 20, 53, 28, 13, 82, 52, 2, 55, 17, 50, 35, 86, 32, 27, 24, 87, 95, 31, 21, 36, 12, 56, 70, 64, 92, 3, 40, 77, 1, 73, 6, 41, 84, 44, 99, 61, 66, 19, 67, 11, 88, 15, 97, 51, 30, 26, 42, 8, 91, 60, 23, 16, 71, 7, 78, 85, 57, 74, 9, 59, 33, 98, 58, 47, 72, 80, 5, 96, 14]
 * 
 *      -- This program makes use of FileIO.java as well as Location.java
 * 
 *      -- Does not consider the amount of time customers wait just finds the shortest route and calculates time taken and distance
 * 
 *      -- Also tried to randomise some elements of the locations array after arranging it and could not find a better solution
 */

public class BurritoTSP {

    // Reads in the text file with all the coordinates
    private static FileIO reader = new FileIO();
    private static String[] contents = reader.load("coordinates.txt");

    public static void main(String[] args) {

        // Array to store 101 location objects (The restaurant and the 100 destinations)
        Location [] locations = new Location[101];

        // Locations array filled with location objects that have an order number and x & y coordinates
        // x & y coordinates taken from the contents array that read them in from the text file
        int j = 0;
        for (int i = 0; i < locations.length; i++) {

            locations[i] = new Location(i, Double.parseDouble(contents[j]), Double.parseDouble(contents[j+1]));
            // Increment by 2 because contents array stores longitude and latitude for each object in different slots
            j += 2;
        }

        // Calculate original distance of travel 1-100 in order
        double originalDistance = 0;
        double totalDistance = 0;
        for (int i = 0; i < locations.length-1; i++) {

            originalDistance += calculateDistance(locations[i].getX(), locations[i].getY(), locations[i+1].getX(), locations[i+1].getY());
        }

        // Loop that finds the shortest route by placing locations nearest to eachother beside eachother in the array
        double shortestRoute = 0;
        for (int i = 0; i < locations.length-1; i++) {

            int firstIndex = 0;
            int secondIndex = 0;
            // Stores disrance between i and i+1 as shortest route
            shortestRoute = calculateDistance(locations[i].getX(), locations[i].getY(), locations[i+1].getX(), locations[i+1].getY());

            // k goes from i+1 (next element after current location) to the end of array and compares distnces between i and
            // each of the elements that's at index k
            for (int k = (i+1); k < locations.length; k++) {

                // The distance between i and the location at k is shorter than at i and i+1, swap i+1 with the location at k
                if (calculateDistance(locations[i].getX(), locations[i].getY(), locations[k].getX(), locations[k].getY()) < shortestRoute){

                    shortestRoute = calculateDistance(locations[i].getX(), locations[i].getY(), locations[k].getX(), locations[k].getY());
                    // Only use these for my swap function
                    firstIndex = (i+1);
                    secondIndex = k;
                }
            }

            // Swaps two locations at two given indexes in an array
            swap(locations, firstIndex, secondIndex);
        }
        
        // Calculate the new new distance after arranging the locations in the array
        for (int i = 0; i < locations.length-1; i++) {

            totalDistance += calculateDistance(locations[i].getX(), locations[i].getY(), locations[i+1].getX(), locations[i+1].getY());
            System.out.println(locations[i].getOrderNum() + " -> " + locations[(i+1)].getOrderNum() + " " + calculateDistance(locations[i].getX(), locations[i].getY(), locations[i+1].getX(), locations[i+1].getY()));
        }

        // Print out the arranged array of orders
        System.out.println("List of arranged orders (0 = Restaurant/Starting point)");
        System.out.print("[ ");
        for (int i = 0; i < locations.length-1; i++) {

            System.out.print(locations[i].getOrderNum() + ",");
        }
        System.out.print(locations[locations.length-1].getOrderNum() + " ]\n");

        // Print out distance and time informatoin to the console
        System.out.println("Best distance: " + String.format("%.2f", totalDistance) + "km");
        System.out.println("Best estimated time: " + String.format("%.2f",calculateTime(totalDistance)) + " hours");
        System.out.println("Original distance: " + String.format("%.2f", originalDistance) + "km");
        System.out.println("Original estimated time: " + String.format("%.2f",calculateTime(originalDistance)) + " hours");
    }

    // This function calculates the distance between two locations in km
    // Used https://dzone.com/articles/distance-calculation-using-3 for reference on how to calculate distance between two coordinates
    public static double calculateDistance(double x1, double y1, double x2, double y2) {

        return radiansToDegrees(Math.acos(Math.sin(degreesToRadians(x1)) * Math.sin(degreesToRadians(x2)) + Math.cos(degreesToRadians(x1))
                * Math.cos(degreesToRadians(x2)) * Math.cos(degreesToRadians(y1 - y2)))) * (60 * 1.1515) * (1.609344);
      }
  
      // This function converts decimal degrees to radians       
      public static double degreesToRadians(double degrees) {

        return degrees * (Math.PI / 180.0);
      }

      // This function converts radians to decimal degrees       
      public static double radiansToDegrees(double radians) {

        return radians * (180.0 / Math.PI);
      }

      // Swap two location objects in an array
      public static void swap(Location locations[], int location1, int location2) {

        Location temp = locations[location1];
        locations[location1] = locations[location2];
        locations[location2] = temp;
      }

      // Calculates the time of the journey for a drone at 80km/h
      public static double calculateTime(double distance) {

        return distance/80;
      }
}