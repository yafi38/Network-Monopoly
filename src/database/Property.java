package database;

public class Property {
    String name;
    int owner;  //4 players of a game will be numbered from 1-4. if a property has no owner then its owner is 0
    int price;

    public Property(String name, int owner, int price) {
        this.name = name;
        this.owner = owner;
        this.price = price;
    }

    public Property[] createProperty() {
        Property[] properties = new Property[40];
        properties[0] = new Property("Dhaka", 0, 2000000);
        return properties;
    }
}
