import java.util.Arrays;

public class PSUPart extends PCComponent {
    private int wattage;

    public PSUPart(String name, String manufacturer, int modelNumber, float[] dimensions, float price, int wattage) {
        super(name, manufacturer, modelNumber, dimensions, price);
        this.wattage = wattage;
    }

    public int getWattage() {
        return this.wattage;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", modelNumber=" + modelNumber +
                ", dimensions=" + Arrays.toString(dimensions) +
                ", price=" + price +
                ", wattage= " + wattage +
                '}';
    }
}
