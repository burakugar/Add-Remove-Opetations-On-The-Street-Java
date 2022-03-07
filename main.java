public class main {
    static void driver() throws Exception {
        House h= new House(2,4,5,6,"Red","Burak");
        Market market = new Market(2,0,3,4,5,"Hasan");
        Office office= new Office(1,9,3,"Game Store","ibrahim");
        Playground play= new Playground(1,2,3);
        Building [] array = new Building[4];
        array[0]= h;
        array[1]=market;
        array[2]=office;
        array[3]=play;

        Street street= new Street(20,array,4);

        try {
            // Testing the street size exception with array
            street= new Street(20,array,5);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            street.addHouse(4,1,7,11,"Blue","Yusuf");
            street.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            street.addOffice(3,4,11,"Store","Yerda");
            street.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            street.deleteOffice(11);
            street.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            street.addMarket(3,1,15,9,12,"Erkan");
            street.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            street.deleteMarket(15);
            street.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            street.addPlayground(1,4,19);
            street.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        try{
            street.deletePlayground(19);
            street.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }


        try{
            street.deleteHouse(4);
            street.showBuildings();
        }
        catch (Exception e){
            e.printStackTrace();
        }

        street.findEmptyAreas();
        street.calculateTotalNumberofRemainingLength();
        street.calculateNumberandRatioofPlaygrounds();
        street.calculatetotalNumberofNonPlaygrounds();

        House h1= new House(2,8,11,6,"Red","Akgul");
        Market market1 = new Market(2,0,3,4,5,"Zergeroglu");
        Office office1= new Office(4,3,3,"Store","Aptoula");
        Playground play1= new Playground(3,12,3);
        Building [] array1 = new Building[4];
        array1[0]= h1;
        array1[1]=market1;
        array1[2]=office1;
        array1[3]=play1;
        Street street1= new Street(20,array1,4);

    }
    public static void main(String[] args) throws Exception {
       driver();
    }
}
