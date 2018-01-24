package database;

public class Property {
    public String name;
    public int owner;
    // 4 players of a game will be numbered from 1-4. if a property has no owner then its owner is 0
    // -1 indicates special squares
    // -2 means you have to pay if you visit it
    public int price;
    public double posX, posY;

    public Property(String name, int owner, int price) {
        this.name = name;
        this.owner = owner;
        this.price = price;
    }

    public static Property[] createProperty() {
        Property[] properties = new Property[40];
        properties[0] = new Property("Go", -1, 200);//take Salary 200
        properties[1]=new Property("Mediterranean Avenue",0,60);
        properties[2]=new Property("Community Chest",-1,0);//pick up community chest card
        properties[3]=new Property("Baltic Avenue",0,60);
        properties[4]=new Property("Income Tax",-2,200);//pay 200
        properties[5]=new Property("Reading Railroad",0,200);
        properties[6]=new Property("Oriental Avenue",0,100);
        properties[7]=new Property("Chance",-1,0);//chance, pick up chance cards
        properties[8]=new Property("Vermont Avenue",0,100);
        properties[9]=new Property("Connecticut Avenue",0,120);
        properties[10]=new Property("In Jail(just visiting)",-1,0);//in jail
        properties[11]=new Property("St.Charl's Place",0,140);
        properties[12]=new Property("Electric Comapany",0,150);
        properties[13]=new Property("States Avenue",0,140);
        properties[14]=new Property("Virginia Avenue",0,160);
        properties[15]=new Property("Pennsylvania Railroad",0,200);
        properties[16]=new Property("St.Jame's Place",0,180);
        properties[17]=new Property("Community Chest",-1,0);//pick up community chest card
        properties[18]=new Property("Tennessee Avenue",0,180);
        properties[19]=new Property("New York Avenue",0,200);
        properties[20]=new Property("Free Parking",-1,0);//parking available
        properties[21]=new Property("Kentucky Avenue",0,220);
        properties[22]=new Property("Chance",-1,0);//chance,pick up chance cards
        properties[23]=new Property("Indiana Avenue",0,220);
        properties[24]=new Property("Illinois Avenue",0,240);
        properties[25]=new Property("B&O railroad",0,200);
        properties[26]=new Property("Atlantic Avenue",0,260);
        properties[27]=new Property("Ventnor Avenue",0,260);
        properties[28]=new Property("Water Works",0,150);
        properties[29]=new Property("Marvin Gardens",0,280);
        properties[30]=new Property("Go to Jail",-1,50);//going to jail
        properties[31]=new Property("Pacific Avenue",0,300);
        properties[32]=new Property("North Carolina Avenue",0,300);
        properties[33]=new Property("Community Chest",-1,0);//pick up community chest card
        properties[34]=new Property("Pennsylvania Avenue",0,320);
        properties[35]=new Property("Short Line",0,200);
        properties[36]=new Property("Chance",-1,0);//chance,pick up chance cards
        properties[37]=new Property("Park place",0,350);
        properties[38]=new Property("Luxury Tax",-2,100);//pay 100
        properties[39]=new Property("Boardwalk",0,400);

        properties[0].posX=745;
        properties[0].posY=745;
        double initX1 = 660, initY1 = 760;
        double diff = 65;

        for(int i=1; i<10; i++) {
            properties[i].posX = initX1;
            properties[i].posY = initY1;
            initX1 -= diff;
         }
         properties[10].posX=55;
         properties[10].posY=760;

         double initX2=40;
         double initY2=660;

         for(int i=11; i<20; i++) {
            properties[i].posX = initX2;
            properties[i].posY = initY2;
            initY2 -= diff;
         }
         properties[20].posX=50;
         properties[20].posY=50;

         double initX3=140;
         double initY3=40;
         for (int i=21;i<30;i++){
             properties[i].posX=initX3;
             properties[i].posY=initY3;
             initX3 +=diff;
         }

         properties[30].posX=740;
         properties[30].posY=55;

         double initX4=760;
         double initY4=135;
         for (int i=31;i<40;i++){
             properties[i].posX=initX4;
             properties[i].posY=initY4;
             initY4 +=diff;
         }
        return properties;
    }
}
