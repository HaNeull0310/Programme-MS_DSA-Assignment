package entity;
import Adt.SortingList;
import Adt.SortedInterface;
/**
 *
 * @author kahhim
 */
public class Faculty  implements Comparable<Faculty> {

    private String FCode;
    private String FName;

    public Faculty(String FCode) {

        this.FCode = FCode;
    }

    public Faculty(String FCode, String FName) {
        this.FCode = FCode;
        this.FName = FName;
    }

    public String getFCode() {
        return FCode;
    }

    public void setFCode(String FCode) {
        this.FCode = FCode;
    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    @Override
    public String toString() {
        return  FCode + " " + FName;
    }

    public int compareTo(Faculty f) {
    return FCode.compareTo(f.FCode);

    }
       public int hashCode(){
        return FCode.hashCode();
    }
}