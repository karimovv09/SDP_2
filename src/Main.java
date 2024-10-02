public class Main {
    public static void main(String[] args) {
        System.out.println("Singleton Pattern:");
        DatabaseConnection connection1 = DatabaseConnection.getInstance();
        DatabaseConnection connection2 = DatabaseConnection.getInstance();
        System.out.println(connection1 == connection2); // true, same instance
        System.out.println();

        System.out.println("Factory Method Pattern:");
        FactoryMethod.NotificationFactory notificationFactory = new FactoryMethod.NotificationFactory();
        FactoryMethod.Notification emailNotification = notificationFactory.createNotification("EMAIL");
        FactoryMethod.Notification smsNotification = notificationFactory.createNotification("SMS");
        emailNotification.notifyUser();
        smsNotification.notifyUser();
        System.out.println();

        System.out.println("Abstract Factory Pattern:");
        DeviceFactory appleFactory = new AppleFactory();
        Smartphone applePhone = appleFactory.createSmartphone();
        Laptop appleLaptop = appleFactory.createLaptop();
        applePhone.getDetails();
        appleLaptop.getDetails();

        DeviceFactory samsungFactory = new SamsungFactory();
        Smartphone samsungPhone = samsungFactory.createSmartphone();
        Laptop samsungLaptop = samsungFactory.createLaptop();
        samsungPhone.getDetails();
        samsungLaptop.getDetails();
        System.out.println();

        System.out.println("Builder Pattern:");
        Builder.House house = new Builder.House.HouseBuilder("Concrete", "Wood")
                .withRoof("Shingle")
                .withGarage(true)
                .withPool(false)
                .build();
        System.out.println(house);
        System.out.println();

        System.out.println("Prototype Pattern:");
        Prototype.ShapeCache.loadCache();
        Prototype.Shape clonedShape1 = Prototype.ShapeCache.getShape("1");
        System.out.println("Shape : " + clonedShape1.getType());
        Prototype.Shape clonedShape2 = Prototype.ShapeCache.getShape("2");
        System.out.println("Shape : " + clonedShape2.getType());
    }
}
