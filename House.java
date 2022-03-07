import java.util.Objects;
/**
 * house type building
 * @param <T>
 */
public class House<T> implements Building{
    private int numberOfRooms;
    private String color;
    private String owner;
    private int length;
    private int position;
    private int height;
    private String type;

    /**
     *
     * @return the type of the house
     */
    public String getType() {
        return type;
    }
    /**
     *
     * @return setter for the house type
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     *
     * @return lenght of the house
     */
    public int getLength() {
        return length;
    }
    /**
     *
     * @param length setter for the length
     */
    public void setLength(int length) {
        this.length = length;
    }
    /**
     *
     * @return the position of the house
     */
    public int getPosition() {
        return position;
    }
    /**
     *
     * @param position setter for the house
     */
    public void setPosition(int position) {
        this.position = position;
    }
    /**
     *
     * @return the height of the house
     */
    public int getHeight() {
        return height;
    }
    /**
     *
     * @param height setter for the house
     */

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String getFocusType(){
        return type;
    }
    /**
     * getter for numberofrooms
     * @return numberofrooms
     */
    public int getNumberOfRooms() {
        return numberOfRooms;
    }
    /**
     * setter for numberofrooms
     * @param numberOfRooms
     */
    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    /**
     * getter for color
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * setter for the color parameter
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * getter for the owner parameter
     * @return the owner of the house
     */
    public String getOwner() {
        return owner;
    }

    /**
     * setter for the owner variable
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     *
     * @return the string correspondence of the House building type
     */

    /**
     * Default constructor for House class which initializes the parameters as following: height=0,position=0,numberofrooms=0,length=0, focustype="House", color= "", owner= ""
        length,position,height and focusType belongs to base class so we use base class constructor.
     */

    public House() {
        this.position=0;
        this.length=0;
        this.height=0;
       this.color= "";
       this.owner = "";
       this.numberOfRooms=0;
       this.type="House";
    }
    private void checkInput(int length, int position, int height) throws Exception{
        if(length<0 || position<0 || height<0){
            throw new Exception("Invalid number");
        }
    }
    /**
     * Parametrized constructor for House class which initializes the parameters as following: height=user_height_value,position=position,numberofrooms=user_numberofrooms_value,length=user_length_value, focustype="House", color= "user_color_value", owner= "user_owner_name"
     length,position,height and focusType belongs to base class so we use base class constructor.
     */
    public House(int length, int position, int height, int numberOfRooms, String color, String owner)throws Exception {
        this.length=length;
        this.type="House";
        this.height=height;
        this.position=position;
        this.numberOfRooms = numberOfRooms;
        this.color = color;
        this.owner = owner;
        try{
            checkInput(length, position, height);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "House{" +
                " numberOfRooms=" + numberOfRooms +
                ", color='" + color + '\'' +
                ", owner='" + owner + '\'' +
                ", height='" + getHeight() + '\'' +
                ", length='" + getLength() + '\'' +
                ", position='" + getPosition() + '\'' +
                ", focusType=" +getFocusType() +
                '}';
    }

    /**
     * overridden equals method
     * @param o object has type House
     * @return boolean value, true if two objects are equal false, if they are not equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House<?> house = (House<?>) o;
        return numberOfRooms == house.numberOfRooms && getPosition() == house.getPosition() && getLength() == house.getLength() && getHeight() == house.getHeight()  && Objects.equals(color, house.color) && Objects.equals(owner, house.owner) && Objects.equals(getFocusType(), house.getFocusType());
    }

}
