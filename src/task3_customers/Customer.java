package task3_customers;

public class Customer {
    public final int id;
    private String name;
    private String postalCode;
    private String country;
    private String city;

    public Customer(int id) {
        this.id = id;
    }

    public Customer(int id, String name, String postalCode, String country, String city) {
        this.id = id;
        this.name = name;
        this.postalCode = postalCode;
        this.country = country;
        this.city = city;
    }

    public Customer(String line) {
        String[] pieces = line.split(",");
        this.id = Integer.parseInt(pieces[0]);
        this.name = pieces[1];
        this.postalCode = pieces[2];
        this.country = pieces[3];
        this.city = pieces[4];
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
