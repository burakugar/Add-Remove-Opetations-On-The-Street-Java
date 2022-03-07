
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Street represents one side of the street
 */
public class Street {
    /**
     * building array is the array contains all the buildings in one side of the street
     */
    private int length;
    private int size;
    private Building[] buildingArray;
    private Integer[] positionList;

    /**
     * no parameter constructor for Street
     */
    public Street() {
        this.length = 0;
        buildingArray = new Building[0];
        size = 0;
    }

    /**
     *
     * @return the size of the Street which is the number of buildings
     */
    public int getSize() {
        return size;
    }
    /**
     *
     * setter for the number of buildings in the street
     */
    public void setSize(int size) {
        this.size = size;
    }
    public Integer[] append(Integer[] array, int element){
        int len= array.length;
        Integer[] temp =new Integer[len+1];
        for(int i=0;i<len;i++){
            temp[i]= array[i];
        }
        temp[len]= element;
        len++;
        array= new Integer[len];
        for(int i=0;i<len;i++){
            array[i]= temp[i];
        }
        return array;
    }

    /**
     *
     * @param length is the length of the street
     * @param buildingArray is the array has the buildings in it which is then will be added into the street
     * @param size is the number of buildings in the street( one side)
     * @throws Exception if the size of the array given is not equal to size of the Street throws exception
     */

    public Street(int length, Building[] buildingArray, int size) throws Exception {
        if(size != buildingArray.length){
            throw new Exception("Street size is different than array size!");
        }
        this.length = length;
        this.buildingArray = buildingArray;
        this.size = size;
        positionList = new Integer[0];
        for (int i = 0; i < buildingArray.length; i++) {
            for (int j = buildingArray[i].getPosition(); j < buildingArray[i].getPosition() + buildingArray[i].getLength() + 1; j++) {
                positionList=append(positionList,j);
            }
        }
    }

    public int getLength() {
        return length;
    }

    /**
     *
     * @param length setter for length of the street
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     *
     * @return the building array in the street
     */

    public Building[] getBuildingArray() {
        return buildingArray;
    }

    /***
     *
     * @param buildingArray setter for building array
     */
    public void setBuildingArray(Building[] buildingArray) {
        this.buildingArray = buildingArray;
    }

    /***
     * prints the buildings to screen
     */
    public void showBuildings() {
        Building building, building_max;
        int max_position = buildingArray[0].getPosition();
        int index_max = 0;
        int len = buildingArray.length;
        for (int i = 0; i < len - 1; i++)
            for (int j = 0; j < len - i - 1; j++)
                if (buildingArray[j].getPosition() > buildingArray[j + 1].getPosition()) {
                    building = buildingArray[j];
                    buildingArray[j] = buildingArray[j + 1];
                    buildingArray[j + 1] = building;
                }
        System.out.println("******************************");
        System.out.println("Buildings in the street are: ");
        for (int i = 0; i < len; i++) {
            System.out.println((i + 1) + "."+ " " +buildingArray[i]);
        }
    }

    /**
     * finds the empty areas in the street, prints their locations and lenghts
     */
    public void findEmptyAreas() {
        int[] lengthArray = new int[length];
        int k = 0;
        for (int i = 0; i < size; i++) {
            int startPoint = buildingArray[i].getPosition();
            for (int j = startPoint; j < startPoint + buildingArray[i].getLength(); j++) {
                lengthArray[k] = j;
                k++;
            }
        }
        int sizeofFilledArray = k;
        /* filledArray holds the positions that is filled by buildings on the street */
        int[] filledArray = new int[sizeofFilledArray];
        for (int i = 0; i < sizeofFilledArray; i++) {
            filledArray[i] = lengthArray[i];
        }

        int[] emptyAreas = new int[length - k];
        int l = 0;
        for (int i = 0; i < length; i++) {
            int flag = 0;
            for (int j = 0; j < k; j++) {
                if (i == filledArray[j]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                emptyAreas[l] = i;
                l++;
            }
        }
        /**
         * position array holds the positions of the buildings
         */
        int[] positionArray = new int[size];
        for (int i = 0; i < size; i++) {
            positionArray[i] = buildingArray[i].getPosition();
        }
        Arrays.sort(emptyAreas);
        Arrays.sort(positionArray);
        k = 0;
        for (int i = 0; i < emptyAreas.length; i++) {
            for (int j = 0; j < positionArray.length; j++) {
                if (emptyAreas[i] < positionArray[j]) {
                    int dif = positionArray[j] - emptyAreas[i];
                    System.out.println("Empty position: " + emptyAreas[i] + " " + "with length " + dif);
                    break;
                }
            }
        }

    }

    /**
     * calculates the total number of remaining length on the street and prints using filledArray
     */
    public void calculateTotalNumberofRemainingLength() {
        int[] lengthArray = new int[length];
        int k = 0;
        for (int i = 0; i < size; i++) {
            int startPoint = buildingArray[i].getPosition();
            for (int j = startPoint; j < startPoint + buildingArray[i].getLength(); j++) {
                lengthArray[k] = j;
                k++;
            }
        }
        int sizeofFilledArray = k;
        int[] filledArray = new int[sizeofFilledArray];
        for (int i = 0; i < sizeofFilledArray; i++) {
            filledArray[i] = lengthArray[i];
        }

        int[] emptyAreas = new int[length - k];
        int l = 0;
        for (int i = 0; i < length; i++) {
            int flag = 0;
            for (int j = 0; j < k; j++) {
                if (i == filledArray[j]) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                emptyAreas[l] = i;
                l++;
            }
        }
        System.out.println("Total number of empty field is : " + emptyAreas.length);
    }

    /**
     * calculates the ratio of the playgrounds on the street and prints it
     */
    public void calculateNumberandRatioofPlaygrounds() {
        int totalLengthofHouses = 0;
        int totalLengthofMarkets = 0;
        int totalLengthofPlaygrounds = 0;
        int totalLengthofOffices = 0;
        int numberofPlaygrounds = 0;
        for (int i = 0; i < size; i++) {
            if (buildingArray[i].getType() == "House") {
                totalLengthofHouses += buildingArray[i].getLength();
            } else if (buildingArray[i].getType() == "Market") {
                totalLengthofMarkets += buildingArray[i].getLength();
            } else if (buildingArray[i].getType() == "Office") {
                totalLengthofOffices += buildingArray[i].getLength();
            } else if (buildingArray[i].getType() == "Playground") {
                totalLengthofPlaygrounds += buildingArray[i].getLength();
                numberofPlaygrounds++;
            }
        }
        float ratio = (float) totalLengthofPlaygrounds / (totalLengthofMarkets + totalLengthofOffices + totalLengthofHouses + totalLengthofPlaygrounds) * 100;
        System.out.println("Total playground ratio in the street is : " + ratio);
        System.out.println("Number of playground in the street is: " + numberofPlaygrounds);
    }

    /**
     * calculates the total number of non-playgorund obhects in the street
     */
    public void calculatetotalNumberofNonPlaygrounds() {
        int numberofMarkets = 0;
        int numberofHouses = 0;
        int numberofOffices = 0;
        int numberofPlaygrounds = 0;
        for (int i = 0; i < size; i++) {
            if (buildingArray[i].getType() == "House") {
                numberofHouses++;
            } else if (buildingArray[i].getType() == "Market") {
                numberofMarkets++;
            } else if (buildingArray[i].getType() == "Office") {
                numberofOffices++;
            }
        }
        System.out.println("Number of non-playground buildings in the street is: " + Integer.toString(numberofHouses + numberofMarkets + numberofOffices));
    }

    /**
     * controls whether a given number is negative or not
     * @param number hat will be checked
     * @return 1 if not negative else returns 0
     * used in exception handling
     */
    private int inputCheckNumber(int number) {
        if (number < 0) {
            System.out.println("Invalid number");
            return -1;
        }
        else
            return 1;
    }

    /**
     *  Adds a house to the street
     * @param height of the house to be added
     * @param length of the house to be added
     * @param position of the house to be added
     * @param numberofRoooms of the house to be added
     * @param color of the house to be added
     * @param owner of the house to be added
     * @throws Exception if the house's position is not free or the given parameters not compatible
     */
    public void addHouse(int height, int length, int position, int numberofRoooms, String color, String owner) throws Exception {
        int flag = 0;
        for (int i = 0; i < positionList.length; i++) {
            for (int j = position; j < position + length; j++) {
                if (j == positionList[i]) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        if (flag==1)
            throw new Exception("Invalid position");

        inputCheckNumber(numberofRoooms);
        /**
         * controlling whether the given house is eligible to be created or not with given parameters
         */
        try{
            House newHouse = new House(length, position, height, numberofRoooms, color, owner);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        House newHouse = new House(length, position, height, numberofRoooms, color, owner);
        size++;
        Building[] buildingArrayNew = new Building[size];
        for (int i = 0; i < buildingArray.length; i++) {
            buildingArrayNew[i] = buildingArray[i];
        }
        buildingArrayNew[size - 1] = newHouse;
        buildingArray = new Building[size];
        for (int i = 0; i < size; i++)
            buildingArray[i] = buildingArrayNew[i];
        for (int i = buildingArray[size - 1].getPosition(); i < buildingArray[size - 1].getPosition() + buildingArray[size - 1].getLength(); i++) {
            positionList= append(positionList,i);
        }
    }

    /**
     *  Adds an office to the street
     * @param height of the office to be added
     * @param length of the office to be added
     * @param position of the office to be added
     * @param jobType of the office to be added
     * @param owner of the office to be added
     * @throws Exception if the office's position is not free or the given parameters not compatible
     */
    public void addOffice(int height, int length, int position, String jobType, String owner) throws Exception {
        int flag = 0;
        for (int i = 0; i < positionList.length; i++) {
            for (int j = position; j < position + length; j++) {
                if (j == positionList[i]) {
                    System.out.println("Invalid position");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        if (flag==1)
            throw new Exception("Invalid position");

        /**
         * controlling whether the given house is eligible to be created or not with given parameters
         */
        Office newOffice = new Office(length, position, height, jobType, owner);

        try{
            newOffice = new Office(length, position, height, jobType, owner);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        size++;
        Building[] buildingArrayNew = new Building[size];
        for (int i = 0; i < buildingArray.length; i++) {
            buildingArrayNew[i] = buildingArray[i];
        }
        buildingArrayNew[size - 1] = newOffice;
        buildingArray = new Building[size];
        for (int i = 0; i < size; i++)
            buildingArray[i] = buildingArrayNew[i];
        for (int i = buildingArray[size - 1].getPosition(); i < buildingArray[size - 1].getPosition() + buildingArray[size - 1].getLength(); i++) {
            positionList= append(positionList,i);
        }
    }

    /**
     *  Adds an market to the street
     * @param height of the market to be added
     * @param length of the market to be added
     * @param position of the market to be added
     * @param openingTime of the market to be added
     * @param closingTime of the market to be added
     * @param owner of the market to be added
     * @throws Exception if the market's position is not free or the given parameters not compatible
     */
    public void addMarket(int height, int length, int position, int openingTime, int closingTime,String owner) throws Exception {
        int flag = 0;
        for (int i = 0; i < positionList.length; i++) {
            for (int j = position; j < position + length; j++) {
                if (j == positionList[i]) {
                    System.out.println("Invalid position");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        if (flag==1)
            throw new Exception("Invalid position");

        Market newMarket = new Market(length, position, height,openingTime,closingTime,owner);
        try{
            newMarket = new Market(length, position, height,openingTime,closingTime,owner);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        size++;
        Building[] buildingArrayNew = new Building[size];
        for (int i = 0; i < buildingArray.length; i++) {
            buildingArrayNew[i] = buildingArray[i];
        }
        buildingArrayNew[size - 1] = newMarket;
        buildingArray = new Building[size];
        for (int i = 0; i < size; i++)
            buildingArray[i] = buildingArrayNew[i];
        for (int i = buildingArray[size - 1].getPosition(); i < buildingArray[size - 1].getPosition() + buildingArray[size - 1].getLength(); i++) {
            positionList= append(positionList,i);
        }
    }
    /**
     *  Adds an playground to the street
     * @param height of the playground to be added
     * @param length of the playground to be added
     * @param position of the playground to be added
     * @throws Exception if the playground's position is not free or the given parameters not compatible
     */
    public void addPlayground(int height, int length, int position) throws Exception {
        int flag = 0;
        for (int i = 0; i < positionList.length; i++) {
            for (int j = position; j < position + length; j++) {
                if (j == positionList[i]) {
                    System.out.println("Invalid position");
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                break;
            }
        }
        Playground newPlayground = new Playground(length, position,height);

        if (flag==1)
            throw new Exception("Invalid position");

        try{
            newPlayground = new Playground(length, position, height);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        size++;
        Building[] buildingArrayNew = new Building[size];
        for (int i = 0; i < buildingArray.length; i++) {
            buildingArrayNew[i] = buildingArray[i];
        }
        buildingArrayNew[size - 1] = newPlayground;
        buildingArray = new Building[size];
        for (int i = 0; i < size; i++)
            buildingArray[i] = buildingArrayNew[i];
        for (int i = buildingArray[size - 1].getPosition(); i < buildingArray[size - 1].getPosition() + buildingArray[size - 1].getLength(); i++) {
            positionList= append(positionList,i);
        }
    }

    /**
     * Deletes a playground from given position on the street
     * Arranges the building array and position array after delete operation
     * @param position of the playground will be deleted
     * @throws Exception if given position is not valid
     */
    public void deletePlayground(int position) throws Exception{
        int flag=0;
        Building[] newBuildingArray = new Building[size];
        int lengthofPlayground=0;
        int positionofPlayground=0;
        int k=0;
        for (int i=0;i<buildingArray.length;i++) {
            if (buildingArray[i].getType() == "Playground" && buildingArray[i].getPosition() == position) {
                flag=1;
                lengthofPlayground=buildingArray[i].getPosition();
                positionofPlayground=position;
                size--;
            }
            else
            {
                newBuildingArray[k] = buildingArray[i];
                k++;
            }
        }
        if(flag==0) {
            throw new Exception("Invalid position");
        }
        buildingArray= new Building[size];
        for(int i=0;i<size;i++){
            buildingArray[i]= newBuildingArray[i];
        }
        Integer[] newpositionList=new Integer[positionList.length-lengthofPlayground];
        for (int i=0;i<positionList.length;i++){
            if(positionList[i]==positionofPlayground){
                i= i+lengthofPlayground;
            }
            else{
                newpositionList= append(newpositionList,positionList[i]);
            }
        }
        positionList= new Integer[positionList.length-lengthofPlayground];
        for (int i=0;i<newpositionList.length;i++){
            positionList= append(positionList,newpositionList[i]);
        }
        System.out.println("Playground is deleted from the position " + position);
    }
    /**
     * Deletes a market from given position on the street
     * Arranges the building array and position array after delete operation
     * @param position of the market will be deleted
     * @throws Exception if given position is not valid
     */
    public void deleteMarket(int position) throws Exception{
        Building[] newBuildingArray = new Building[size];
        int lengthofMarket=0;
        int positionofMarket=0;
        int flag=0;
        int k=0;
        for (int i=0;i<buildingArray.length;i++) {
            if (buildingArray[i].getType() == "Market" && buildingArray[i].getPosition() == position) {
                flag=1;
                lengthofMarket=buildingArray[i].getPosition();
                positionofMarket=position;
                size--;
            }
            else
            {
                newBuildingArray[k] = buildingArray[i];
                k++;
            }
        }
        if(flag==0) {
            throw new Exception("Invalid position");
        }
        buildingArray= new Building[size];
        for(int i=0;i<size;i++){
            buildingArray[i]= newBuildingArray[i];
        }
        Integer[] newpositionList=new Integer[positionList.length-lengthofMarket];
        for (int i=0;i<positionList.length;i++){
            if(positionList[i]==positionofMarket){
                i= i+lengthofMarket;
            }
            else{
                newpositionList= append(newpositionList,positionList[i]);
            }
        }
        positionList= new Integer[positionList.length-lengthofMarket];
        for (int i=0;i<newpositionList.length;i++){
            positionList= append(positionList,newpositionList[i]);
        }
        System.out.println("Market is deleted from the position " + position);
    }
    /**
     * Deletes a office from given position on the street
     * Arranges the building array and position array after delete operation
     * @param position of the office will be deleted
     * @throws Exception if given position is not valid
     */
    public void deleteOffice(int position) throws Exception {
        Building[] newBuildingArray = new Building[size];
        int lengthofOffice=0;
        int positionofOffice=0;
        int flag=0;
        int k=0;
        for (int i=0;i<buildingArray.length;i++) {
            if (buildingArray[i].getType() == "Office" && buildingArray[i].getPosition() == position) {
                flag=1;
                lengthofOffice=buildingArray[i].getPosition();
                positionofOffice=position;
                size--;
            }
            else
            {
                newBuildingArray[k] = buildingArray[i];
                k++;
            }
        }
        if(flag==0) {
            throw new Exception("Invalid position");
        }
        buildingArray= new Building[size];
        for(int i=0;i<size;i++){
            buildingArray[i]= newBuildingArray[i];
        }
        Integer[] newpositionList=new Integer[positionList.length-lengthofOffice];
        for (int i=0;i<positionList.length;i++){
            if(positionList[i]==positionofOffice){
                i= i+lengthofOffice;
            }
            else{
                newpositionList= append(newpositionList,positionList[i]);
            }
        }
        positionList= new Integer[positionList.length-lengthofOffice];
        for (int i=0;i<newpositionList.length;i++){
            positionList= append(positionList,newpositionList[i]);
        }
        System.out.println("Office is deleted from the position " + position);
    }
    /**
     * Deletes a house from given position on the street
     * Arranges the building array and position array after delete operation
     * @param position of the house will be deleted
     * @throws Exception if given position is not valid
     */
    public void deleteHouse(int position) throws Exception {
        Building[] newBuildingArray = new Building[size];
        int lengthofHouse=0;
        int positionofHouse=0;
        int flag=0;
        int k=0;
        for (int i=0;i<buildingArray.length;i++) {
            if (buildingArray[i].getType() == "House" && buildingArray[i].getPosition() == position) {
                flag=1;
                lengthofHouse=buildingArray[i].getPosition();
                positionofHouse=position;
                size--;
            }
            else
            {
                newBuildingArray[k] = buildingArray[i];
                k++;
            }
        }
        if(flag==0) {
            throw new Exception("Invalid position");
        }
        buildingArray= new Building[size];
        for(int i=0;i<size;i++){
            buildingArray[i]= newBuildingArray[i];
        }
        Integer[] newpositionList=new Integer[positionList.length-lengthofHouse];
        for (int i=0;i<positionList.length;i++){
            if(positionList[i]==positionofHouse){
                i= i+lengthofHouse;
            }
            else{
                newpositionList= append(newpositionList,positionList[i]);
            }
        }
        positionList= new Integer[positionList.length-lengthofHouse];
        for (int i=0;i<newpositionList.length;i++){
            positionList= append(positionList,newpositionList[i]);
        }
        System.out.println("House is deleted from the position " + position);
    }


}

