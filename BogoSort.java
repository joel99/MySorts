/*==============================
  BogoSort - check, shuffle, repeat
  ==============================*/
import java.util.ArrayList;

public class BogoSort{
    
    
    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) 
    {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }


    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) 
    {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    public static void bogoSortV( ArrayList<Comparable> data){
	for (int i = 0; i < data.size() - 1; i++)
	    if (data.get(i).compareTo(data.get(i+1)) > 0){
		shuffle(data);
		bogoSortV(data);
	    }
    }

    public static ArrayList<Comparable> bogoSort( ArrayList<Comparable> input){
	ArrayList<Comparable> ret = new ArrayList<>();
	for (int i = 0; i < input.size(); i++)
	    ret.add(input.get(i));
	bogoSortV(ret);
	return ret;
    }

}
