package database;

public class Property {
    String name;
    int owner;  //4 players of a game will be numbered from 1-4. if a property has no owner then its owner is 0
    int price;
    double posX, posY;

    public Property(String name, int owner, int price) {
        this.name = name;
        this.owner = owner;
        this.price = price;
    }

    public Property[] createProperty() {
        Property[] properties = new Property[40];
        properties[0] = new Property("Dhaka", 0, 2000000);

        double initX = 595, initY = 5;
        double diff = 5;

        for(int i=0; i<10; i++) {
            properties[i].posX = initX;
            properties[i].posY = initY;
            initX -= diff;
         }

         for(int i=10; i<20; i++) {
            properties[i].posX = initX;
            properties[i].posY = initY;
            initY += diff;
         }
        return properties;
    }
}
