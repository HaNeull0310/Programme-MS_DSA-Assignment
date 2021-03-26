 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programme.ms.assignment;

import Adt.HashInterface;
import Adt.HashImplement;
import entity.Faculty;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author darks
 */
public class Hashing {
        public static List<Faculty> facultyList = new ArrayList();
    
    public static void hashIndexing(List<Faculty> facultyL){
        // create names for a list
        facultyList.clear();
        for (int i = 0; i < facultyL.size(); i++) {
            facultyList.add(facultyL.get(i));
        }
        
        
        HashInterface<Integer,Faculty> programmeTable = new HashImplement<>(71);  
        for (int i = 0; i < facultyList.size(); i++) {
            programmeTable.add(facultyList.get(i).hashCode(), facultyList.get(i));
        }     
        hashMenu(programmeTable);
    }
    
    public static void hashMenu(HashInterface programmeTable) {
        cls();
        int sel = 0;
        do {
            System.out.print("                Hashed Indexing\n");
            System.out.print("------------------------------------------------\n");
            System.out.print("1. Search Programme\n");
            System.out.print("2. Add Programme\n");
            System.out.print("3. Exit\n");

            switch(validSelection(4)){
                case 1:
                    cls(); hashSearch(programmeTable); break;
                case 2:
                    cls(); hashAdd(programmeTable); break;
                case 3:
                    cls(); //ProgrammeMSAssignment.main(args);
            }
        } while (sel != 1 && sel != 2 && sel != 3 );
    }
    
    public static int validSelection(int maxOption){
        Scanner sc = new Scanner(System.in);
        boolean validEntry = true;
        int optSelected = 0;
        
        do{
            try{
                System.out.print("\nEnter your selection: ");
                optSelected = sc.nextInt();
                if(optSelected <= maxOption && optSelected > 0){
                    validEntry = true;
                } else{
                    validEntry = false;
                    System.err.println("Please enter a valid selection!");
                }
            } catch(InputMismatchException ex){
                System.err.println("Please enter a valid selection!");
                validEntry = false;
                sc.nextLine();
            }
        } while(!validEntry);
        
        return optSelected;
    }
    
    public static void hashSearch(HashInterface programmeTable){
        System.out.print("                Search Programme\n");
        System.out.println("------------------------------------------------\n");
        System.out.print("Enter programme to be search: ");
        Scanner sc = new Scanner(System.in);

        String progNameToSearch = sc.nextLine();

        Faculty progToSearch = new Faculty(progNameToSearch);

        if(programmeTable.contains(progToSearch.hashCode())){
            System.out.println(programmeTable.getValue(progToSearch.hashCode()));
        }
        else{
            System.err.println("Record not found!");
        }
        
        char yesNo;
        do{
            System.out.print("\nDo you want to search another programme? (Y/N): ");
            yesNo = Character.toUpperCase(sc.nextLine().charAt(0));
            switch(yesNo){
                case 'Y': 
                    cls(); hashSearch(programmeTable); break;
                case 'N':
                    cls();
                    return;
                default:
                    System.err.println("Please enter a valid selection!");
            }
        } while(yesNo != 'N' && yesNo != 'Y');
    }
    
    public static void hashAdd(HashInterface programmeTable){
        Scanner sc = new Scanner(System.in);
        
        String FCode,FName;
        int lvlOfStudyOpt, facultyOpt, duration;
        Faculty faculty = null; /** NEED TO CHANGE TO FACULTY CLASS */
        
        System.out.print("                Add A Programme\n");
        System.out.println("------------------------------------------------\n");
        System.out.print("\nProgram name: ");
        FCode = sc.nextLine();
        
            System.out.print("\nLevel Of Study: ");
        FName = sc.nextLine();
        
   
        Faculty newProg = new Faculty(FCode, FName);
            
        cls();
        System.out.println("Are you sure you want to add the following programme?");
        System.out.println("Program Name: " + newProg.getFCode());
        System.out.println("Level of Study: " + newProg.getFName());
        
        char cfmAdd;
        do{
            System.out.print("Enter (Y/N): ");
            cfmAdd = Character.toUpperCase(sc.nextLine().charAt(0));

            switch(cfmAdd){
                case 'Y': 
                    programmeTable.add(newProg.hashCode(), newProg);
                    System.out.println(newProg.getFCode() + " in " + newProg.getFName() + " has been added.");
                    cls();
                    break;
                case 'N':
                    cls();
                    return; 
                default:
                    System.err.println("Please enter a valid selection!");
            }
        } while(cfmAdd != 'N' && cfmAdd != 'Y');
        
        char yesNo;
        do{
            System.out.print("\nDo you want to add another programme? (Y/N): ");
            yesNo = Character.toUpperCase(sc.nextLine().charAt(0));
            switch(yesNo){
                case 'Y': 
                    cls(); hashAdd(programmeTable); break;
                case 'N':
                    cls();
                    return;
                default:
                    System.err.println("Please enter a valid selection!");
            }
        } while(yesNo != 'N' && yesNo != 'Y');
    }
    

    
    public static void displayHashTable(HashInterface programmeTable){
        System.out.println(programmeTable);
        System.out.println(programmeTable.getSize());
    }
    
    public static void cls() {
        for (int i = 0; i < 50; ++i) {
            System.out.println();
        }
    }
}
