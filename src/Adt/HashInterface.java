/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adt;

/**
 *
 * @author darks
 */
public interface HashInterface <K, V> {
    /*
    Description: To add a new entry to the dictionary
    Precondition: key & value is not null
    Postcondition: key & value is added to the dictionary,
                   numberOfEntries increases
    Return: If new entry was added to the dictionary return null, else return the replaced value.
    */
    public V add(K key, V value);
    
    /*
    Description: To remove an entry from the dictionary with key
    Precondition: key is not null
    Postcondition: key & value is deleted from the dictionary,
                   numberOfEntries decreases
    Return: If remove successfully return the value, else return null
    */
    public V remove(K key);
    
    /*
    Description: To retrieve a value with a given key
    Precondition: key is not null
    Postcondition: none
    Return: If the value is associated with the key return value, else return null
    */
    public V getValue(K key);
    
    /*
    Description: To check whether there's an entry in the dictionary
    Precondition: key is not null
    Postcondition: None
    Return: If key is associated with an entry in the dictionary return true, else false
    */
    public boolean contains(K key);
    
    /*
    Description: To check whether the dictionary is empty
    Precondition: None
    Postcondition: None
    Return: If dictionary is empty return true, else false
    */
    public boolean isEmpty();

    /*
    Description: To check whether the dictionary is full
    Precondition: None
    Postcondition: None
    Return: If dictionary is full return true, else false
    */
    public boolean isFull();

    /*
    Description: To get the size of the dictionary
    Precondition: None
    Postcondition: None
    Return: numberOfEntries currently in the dictionary
    */
    public int getSize();

    /*
    Description: To remove all entries from the dictionary.
    Precondition: The dictionary is not empty
    Postcondition: All the entries from the dictionary is deleted
    Return: None
    */
    public void clear();
}
