package builderPattern;

public class Meal {
    private String burger;
    private String fries;
    private String drink;
    private String dessert;

    private Meal(Builder builder) {
        this.burger = builder.burger;
        this.fries = builder.fries;
        this.drink = builder.drink;
        this.dessert = builder.dessert;
    }

    public static class Builder {
        private String burger;
        private String fries;
        private String drink;
        private String dessert;

        public Builder() {
        }

        public Builder withBurger(String burger) {
            this.burger = burger;
            return this;
        }

        public Builder withFries(String fries) {
            this.fries = fries;
            return this;
        }

        public Builder withDrink(String drink) {
            this.drink = drink;
            return this;
        }

        public Builder withDessert(String dessert) {
            this.dessert = dessert;
            return this;
        }

        public Meal build() {
            return new Meal(this);
        }
    }

    public String getBurger() {
        return burger;
    }

    public String getFries() {
        return fries;
    }

    public String getDrink() {
        return drink;
    }

    public String getDessert() {
        return dessert;
    }

    public static void main(String[] args) {
        Meal meal = new Meal.Builder()
                .withBurger("Cheeseburger")
                .withFries("Large fries")
                .withDrink("Coke")
                .build();

        System.out.println("Burger: " + meal.getBurger());
        System.out.println("Fries: " + meal.getFries());
        System.out.println("Drink: " + meal.getDrink());
    }
}
