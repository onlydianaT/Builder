public class Main {

    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setName("Оля")
                .setSurname("Вольф")
                .setSurname("Mort")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        mom.happyBirthday();

        System.out.println("У " + mom + " есть сын, " + son);

        try {
            Person mom1 = new PersonBuilder()
                    .setName("Оля")
                    //.setSurname("Воробьева")
                    .setAge(31)
                    .setAddress("Сидней")
                    .build();
            System.out.println("У " + mom1);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            Person mom2 = new PersonBuilder()
                    .setName("Tanya")
                    .setSurname("Lorec")
                    .setAge(-10)
                    .setAddress("Сидней")
                    .build();
            System.out.println("У " + mom2);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
