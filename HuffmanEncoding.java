import java.util.*;

public class HuffmanEncoding {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a word or a sentence to Huffman encode it");
        String sentence = in.nextLine();
        in.close();

        int[] array = new int[256]; //an array to store all the frequencies

        for (int i = 0; i < sentence.length(); i++) { //go through the sentence
            array[(int) sentence.charAt(i)]++; //increment the appropriate frequencies
        }

        PriorityQueue < Tree > PQ = new PriorityQueue < Tree > (); //make a priority queue to hold the forest of trees    

        for (int i = 0; i < array.length; i++) { //go through frequency array
            if (array[i] > 0) { //print out non-zero frequencies - cast to a char

                //MAKE THE FOREST OF TREES AND ADD THEM TO THE PRIORITY QUEUE

                //create a new Tree 
                Tree myTree = new Tree();
                Node myNode = new Node();
                //set the cumulative frequency of that Tree
                myTree.frequency = array[i];
                myNode.letter = myNode.smallestLetter = (char) i;
                //insert the letter as the root node 
                myTree.root = myNode;
                //add the Tree into the PQ
                PQ.add(myTree);
            }
        }

        while (PQ.size() > 1) { //while there are two or more Trees left in the forest

            Tree smallest = PQ.poll();
            Tree nextSmallest = PQ.poll();
            Tree newTree = new Tree();
            Node myNode = new Node();
            myNode.leftChild = smallest.root;
            myNode.rightChild = nextSmallest.root;
            newTree.frequency = smallest.frequency + nextSmallest.frequency;
            myNode.smallestLetter = (char) Math.min(smallest.root.smallestLetter, nextSmallest.root.smallestLetter);
            newTree.root = myNode;
			PQ.add(newTree);
        }

        Tree HuffmanTree = PQ.poll(); //now there's only one tree left - get its codes
        String huffman = "";

        for(char c : sentence.toCharArray()) {

            huffman += HuffmanTree.getCode(c);
        }

        System.out.println(huffman);
    }
}

class Node {

    public char letter = '@'; //stores letter
    public char smallestLetter = '@';  // Track the smallest letter in the tree
				
    public Node leftChild; // Node's left child
    public Node rightChild; // Node's right child
}

class Tree implements Comparable < Tree > {

    public Node root; // first node of tree
    public int frequency = 0;

    public Tree() { // constructor

        root = null;
    } // no nodes in tree yet

    //the PriorityQueue needs to be able to somehow rank the objects in it
    //thus, the objects in the PriorityQueue must implement an interface called Comparable

    public int compareTo(Tree object) {

        if (frequency - object.frequency > 0) { //compare the cumulative frequencies of the tree

            return 1;

        } else if (frequency - object.frequency < 0) {

            return -1; //return 1 or -1 depending on whether these frequencies are bigger or smaller

        } else {

            // Sort based on letters
            char a = this.root.smallestLetter;
            char b = object.root.smallestLetter;

            if (a > b) {
                
                return 1;

            } else if (a < b) {

                return -1;
            }

            return 0;
        }
    }

    String path = "error"; //this variable will track the path to the letter we're looking for 

    public String getCode(char letter) { //we want the code for this letter

        return this._getCode(letter, this.root, ""); //return the path that results
    }

    private String _getCode(char letter, Node current, String path) {

        if (current == null) {

            return null;
        }

        if (current.letter == letter) {

            return path;
        }

        String leftPath = this._getCode(letter, current.leftChild, path + "0");

        if (leftPath != null) {

            return leftPath;
        }

        String rightPath = this._getCode(letter, current.rightChild, path + "1");
        return rightPath;
    }
}