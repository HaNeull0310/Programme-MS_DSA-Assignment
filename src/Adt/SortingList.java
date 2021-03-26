
package Adt;
import entity.Faculty;
/**
 *
 * @author kahhim
 */
public class SortingList <T extends Comparable<T>> implements SortedInterface<T>{
     private T[] sortlist;
    private int length;
    private static final int DEFAULT_INITIAL_CAPACITY = 50;
    
    public SortingList(){
    this(DEFAULT_INITIAL_CAPACITY);
    }
    
     public SortingList(int initial){
    length = 0;
        sortlist = (T[]) new Comparable[initial];
    }
    @Override
    public void add(T newEntry) {
                if(isFull()){
                doubleArray();
                }
                sortlist[length] = newEntry;
        length++;
    }

    @Override
    public void bubbleSort() {
        int count = length-1; 
        for (int pass = 0; pass < count; pass++) {
            for (int i = 0; i < count; i++) {
                swap(i, i + 1);
            }															// trace statement
        }
    }

    @Override
    public void display() {
         System.out.printf("------------sorting list-----------------------\n");
        for (int index = 0; index < length; ++index) {   
           System.out.printf("%3d. %-50s\n", index + 1, sortlist[index]);           
        }
    }

    @Override
    public boolean isEmpty() {
            return length == 0;
    }

    @Override
    public boolean isFull() {
        return length == sortlist.length;
    }

    private void doubleArray() {
        T[] oldlist = sortlist;
        int oldsize = oldlist.length;
        sortlist = (T[]) new Object[2 * oldsize];
        for(int index = 0; index < oldsize; index++){
            sortlist[index] = oldlist[index];
        }
    }

    private void swap(int i, int n) {
            if(sortlist[i].compareTo(sortlist[n]) > 0){
        T temp = sortlist[i];
        sortlist[i] = sortlist[n];
        sortlist[n] = temp;
        }
    }
    
    public String toString() {
    String outputStr = "";
    for (int index = 0; index < length; ++index) {
      outputStr += sortlist[index] + "\n";
    }
    return outputStr;
  }
    
}
