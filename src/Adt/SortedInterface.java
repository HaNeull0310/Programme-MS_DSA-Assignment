/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adt;

/**
 *
 * @author kahhim
 */
public interface SortedInterface <T extends Comparable<T>>{
    public void add(T newEntry);
    public void bubbleSort();
    public void display();
    public boolean isEmpty();
    public boolean isFull();
}
