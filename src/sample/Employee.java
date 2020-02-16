//Arsoon Shiwani
package sample;
//add more to employee
//check more things to UI and learn more about javafx buttons
//combo box, menu, tab, radio button
//javafx 10 very used controls
//try and catch method review
//material design
//take code and create git repository
import java.util.UUID;

public class Employee implements Worker{

    public String firstName;
    public String lastName;
    public UUID id;
    public boolean isActive;

    public String toString(){

        return this.firstName + " " + this.lastName;

    }

    @Override
    public void hire() {
isActive = true;
    }

    @Override
    public void fire() {
isActive = false;
    }
}
